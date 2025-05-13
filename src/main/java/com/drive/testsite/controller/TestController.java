package com.drive.testsite.controller;

import com.drive.testsite.entity.Answer;
import com.drive.testsite.entity.Question;
import com.drive.testsite.entity.User;
import com.drive.testsite.repositary.AnswerRepository;
import com.drive.testsite.repositary.QuestionRepository;
import com.drive.testsite.repositary.TestRepository;
import com.drive.testsite.repositary.UserRepository;
import com.drive.testsite.service.MailService;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class TestController {
    private final TestRepository testRepo;
    private final QuestionRepository questionRepo;
    private final AnswerRepository answerRepo;
    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;
    private final MailService mailService;

    public TestController(TestRepository testRepo, QuestionRepository questionRepo, AnswerRepository answerRepo, UserRepository userRepository, PasswordEncoder passwordEncoder, MailService mailService) {
        this.testRepo = testRepo;
        this.questionRepo = questionRepo;
        this.answerRepo = answerRepo;
        this.userRepo = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.mailService = mailService;
    }

    @GetMapping("/")
    public String home(HttpSession session, Model model) {
        if (session.getAttribute("loggedInUser") == null) {
            return "redirect:/register";
        }

        model.addAttribute("tests", testRepo.findAll());
        return "test_list";
    }

    @GetMapping("/test/{id}")
    public String takeTest(@PathVariable Long id, Model model) {
        List<Question> questions = questionRepo.findByTestId(id);
        if (questions.isEmpty()) {
            return "error"; // or show message
        }

        Question firstQuestion = questions.get(0);
        List<Answer> firstAnswers = answerRepo.findByQuestionId(firstQuestion.getId());

        model.addAttribute("question", firstQuestion);
        model.addAttribute("answers", firstAnswers);
        model.addAttribute("currentIndex", 0);
        model.addAttribute("totalQuestions", questions.size());
        model.addAttribute("testId", id);
        model.addAttribute("progress", 0); // ✅ Initialize progress explicitly

        return "take_test";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username,
                           @RequestParam String email,
                           @RequestParam String phone,
                           @RequestParam String password) {

        if (userRepo.findByEmail(email).isPresent()) {
            return "redirect:/register?error=email_taken";
        }

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPhone(phone);
        user.setPassword(passwordEncoder.encode(password));  // Add password encoder!
        user.setPaid(false);
        userRepo.save(user);
        return "redirect:/login?success";
    }

    @PostMapping("/login")
    public String login(@RequestParam String emailOrUsername,
                        @RequestParam String password,
                        HttpSession session) {

        Optional<User> optional = userRepo.findByEmail(emailOrUsername);
        if (optional.isEmpty()) {
            optional = userRepo.findByUsername(emailOrUsername);
        }

        if (optional.isEmpty()) return "redirect:/login?error=not_found";

        User user = optional.get();
        if (!passwordEncoder.matches(password, user.getPassword())) {
            return "redirect:/login?error=wrong_password";
        }

        String code = String.valueOf(new Random().nextInt(899999) + 100000); // 6-digit
        user.setVerificationCode(code);
        userRepo.save(user);

        mailService.send2FACode(user.getEmail(), code);

        session.setAttribute("authUserId", user.getId());
        return "redirect:/verify";
    }
    @PostMapping("/verify")
    public String verifyCode(@RequestParam String code, HttpSession session) {
        Long userId = (Long) session.getAttribute("authUserId");
        if (userId == null) return "redirect:/login";

        User user = userRepo.findById(userId).orElse(null);
        if (user == null || !code.equals(user.getVerificationCode())) {
            return "redirect:/verify?error=invalid";
        }

        session.setAttribute("loggedInUser", user.getId());
        return "redirect:/";
    }

    @GetMapping("/register")
    public String showRegisterForm() {
        return "register"; // → loads register.html
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // → loads login.html
    }

    @GetMapping("/verify")
    public String showVerifyPage() {
        return "verify"; // → loads verify.html
    }


    @PostMapping("/submit")
    public String submitAnswers(@RequestParam Map<String, String> params, Model model) {
        int score = 0;
        int total = 0;

        Map<Long, Long> selectedAnswerIds = new HashMap<>(); // Question ID → Selected Answer ID
        Map<Long, Boolean> correctness = new HashMap<>();     // Question ID → was correct

        for (String key : params.keySet()) {
            if (key.startsWith("q_")) {
                Long qId = Long.parseLong(key.substring(2));
                Long answerId = Long.parseLong(params.get(key));
                selectedAnswerIds.put(qId, answerId);

                Answer ans = answerRepo.findById(answerId).orElse(null);
                if (ans != null && ans.isCorrect()) {
                    score++;
                    correctness.put(qId, true);
                } else {
                    correctness.put(qId, false);
                }
                total++;
            }
        }

        model.addAttribute("score", score);
        model.addAttribute("total", total);
        model.addAttribute("selected", selectedAnswerIds);
        model.addAttribute("correctness", correctness);

        // send all questions + answers again
        Long testId = Long.parseLong(params.get("testId"));
        List<Question> questions = questionRepo.findByTestId(testId);
        Map<Long, List<Answer>> answers = new HashMap<>();
        for (Question q : questions) {
            answers.put(q.getId(), answerRepo.findByQuestionId(q.getId()));
        }

        model.addAttribute("questions", questions);
        model.addAttribute("answers", answers);

        return "result";
    }

    @PostMapping("/test/{testId}/question")
    public String submitQuestion(
            @PathVariable Long testId,
            @RequestParam Long questionId,
            @RequestParam(required = false) Long answerId,
            @RequestParam int currentIndex,
            Model model,
            HttpSession session) {


        List<Question> questions = questionRepo.findByTestId(testId);
        // ✅ Prevent IndexOutOfBounds
        if (currentIndex >= questions.size()) {
            int finalScore = session.getAttribute("score") != null ? (int) session.getAttribute("score") : 0;
            model.addAttribute("score", finalScore);
            model.addAttribute("total", questions.size());
            return "result"; // Redirect to result page
        }
        Question currentQuestion = questions.get(currentIndex);
        List<Answer> allAnswers = answerRepo.findByQuestionId(currentQuestion.getId());

        boolean isCorrect = false;
        if (answerId != null) {
            Answer selected = answerRepo.findById(answerId).orElse(null);
            isCorrect = selected != null && selected.isCorrect();
            if (isCorrect) {
                int score = session.getAttribute("score") != null ? (int) session.getAttribute("score") : 0;
                session.setAttribute("score", ++score);
            }
        }

        Long correctAnswerId = allAnswers.stream()
                .filter(Answer::isCorrect)
                .map(Answer::getId)
                .findFirst()
                .orElse(null);

        int progress = (int) (((currentIndex + 1) * 100.0) / questions.size());

        model.addAttribute("question", currentQuestion);
        model.addAttribute("answers", allAnswers);
        model.addAttribute("testId", testId);
        model.addAttribute("currentIndex", currentIndex);
        model.addAttribute("totalQuestions", questions.size());
        model.addAttribute("progress", progress);
        model.addAttribute("feedback", answerId == null ? "❌ No answer selected." : (isCorrect ? "✅ Correct!" : "❌ Incorrect."));
        model.addAttribute("correct", isCorrect);
        model.addAttribute("correctAnswerId", correctAnswerId);
        model.addAttribute("showNext", false);
        if (answerId != null) {
            // this was a submission, not a next-click
            model.addAttribute("selectedAnswerId", answerId);
        } else {
            // reset for new question
            model.addAttribute("selectedAnswerId", null);
        }

        return "take_test";
    }

}

