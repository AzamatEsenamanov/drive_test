package com.drive.testsite.controller;

import com.drive.testsite.entity.Answer;
import com.drive.testsite.entity.Question;
import com.drive.testsite.repositary.AnswerRepository;
import com.drive.testsite.repositary.QuestionRepository;
import com.drive.testsite.repositary.TestRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TestController {
    private final TestRepository testRepo;
    private final QuestionRepository questionRepo;
    private final AnswerRepository answerRepo;

    public TestController(TestRepository testRepo, QuestionRepository questionRepo, AnswerRepository answerRepo) {
        this.testRepo = testRepo;
        this.questionRepo = questionRepo;
        this.answerRepo = answerRepo;
    }

    @GetMapping("/")
    public String listTests(Model model) {
        model.addAttribute("tests", testRepo.findAll());
        return "test_list";
    }

    @GetMapping("/test/{id}")
    public String takeTest(@PathVariable Long id, Model model) {
        List<Question> questions = questionRepo.findByTestId(id);
        Map<Long, List<Answer>> answers = new HashMap<>();
        for (Question q : questions) {
            answers.put(q.getId(), answerRepo.findByQuestionId(q.getId()));
        }

        model.addAttribute("testId", id);
        model.addAttribute("questions", questions);
        model.addAttribute("answers", answers);
        return "take_test";
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
            @RequestParam Long answerId,
            @RequestParam int currentIndex,
            Model model,
                HttpSession session) {

        List<Question> questions = questionRepo.findByTestId(testId);
        Question currentQuestion = questions.get(currentIndex);
        Answer selected = answerRepo.findById(answerId).orElse(null);

        int score = session.getAttribute("score") != null ? (int) session.getAttribute("score") : 0;
        if (selected != null && selected.isCorrect()) {
            score++;
            model.addAttribute("feedback", "✅ Correct!");
            model.addAttribute("correct", true);
        } else {
            model.addAttribute("feedback", "❌ Incorrect.");
            model.addAttribute("correct", false);
        }

        session.setAttribute("score", score);

        int nextIndex = currentIndex + 1;
        if (nextIndex >= questions.size()) {
            model.addAttribute("score", score);
            model.addAttribute("total", questions.size());
            return "result"; // final page
        }

        Question nextQuestion = questions.get(nextIndex);
        List<Answer> nextAnswers = answerRepo.findByQuestionId(nextQuestion.getId());

        model.addAttribute("question", nextQuestion);
        model.addAttribute("answers", nextAnswers);
        model.addAttribute("currentIndex", nextIndex);
        model.addAttribute("totalQuestions", questions.size());
        model.addAttribute("testId", testId);

        return "take_test";
    }


}

