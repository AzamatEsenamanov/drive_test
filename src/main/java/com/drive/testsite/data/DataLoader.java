
package com.drive.testsite.data;

import com.drive.testsite.entity.Answer;
import com.drive.testsite.entity.Question;
import com.drive.testsite.entity.Test;
import com.drive.testsite.repositary.AnswerRepository;
import com.drive.testsite.repositary.QuestionRepository;
import com.drive.testsite.repositary.TestRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final TestRepository testRepo;
    private final QuestionRepository questionRepo;
    private final AnswerRepository answerRepo;

    public DataLoader(TestRepository testRepo, QuestionRepository questionRepo, AnswerRepository answerRepo) {
        this.testRepo = testRepo;
        this.questionRepo = questionRepo;
        this.answerRepo = answerRepo;
    }

    @Override
    public void run(String... args) {
        if (testRepo.count() == 0) {
            Test test = new Test();
            test.setTitle("English Proficiency Test for CDL Holders");
            test.setPaid(false);
            testRepo.save(test);

            String[] questions = {
                    "You see a sign that says \"Low Clearance - 12'6\". What should you do?",
                    "During a roadside inspection, the officer asks, \"May I see your logbook?\" What do you do?",
                    "If your vehicle starts to hydroplane, you should:",
                    "You’re driving in fog. What’s the best way to see the road ahead?",
                    "What is the primary purpose of a pre-trip inspection?",
                    "When should you use your vehicle’s horn?",
                    "What should you do if your brakes fail while driving?",
                    "How often must you inspect cargo during a trip?",
                    "What does a flashing red traffic light mean?",
                    "How can you identify a tire blowout?",
                    "When backing a large vehicle, you should:",
                    "Which of the following is a sign of aggressive driving?",
                    "What is the proper hand signal for a right turn?",
                    "If you are drowsy while driving, the best thing to do is:",
                    "When approaching a railroad crossing without signals, you should:",
                    "A retarder is used to:",
                    "When driving down a long hill, you should:",
                    "What is the safe following distance in good conditions?",
                    "Which document must be kept in the vehicle at all times?",
                    "If your vehicle catches fire, what should you do first?",
                    "If stopped on a hill, how can you prevent rollback?",
                    "When should you dim your headlights?",
                    "What should you do before changing lanes?",
                    "What’s the maximum blood alcohol concentration (BAC) allowed for CDL drivers?",
                    "If a tire fails, what should you avoid doing?",
                    "How can you test hydraulic brakes for leaks?",
                    "What is the minimum tread depth for front tires?",
                    "When is it necessary to use wheel chocks?",
                    "When loading cargo, you must:",
                    "You must complete a new logbook page:",
                    "When should you check your mirrors for a lane change?",
                    "Which of the following is NOT a cause of vehicle fires?",
                    "If you see a hazard ahead, you should:",
                    "When driving at night, always:",
                    "To correct a rear-wheel skid, you should:",
                    "When should you downshift?",
                    "What’s the purpose of a header board?",
                    "Overloading a vehicle can cause:",
                    "How do you recognize a distracted driver?",
                    "When transporting hazardous materials, you must:",
                    "What should you do when approaching a work zone?",
                    "You’re stopped behind a school bus. What should you do?",
                    "What is the proper way to enter a curve?",
                    "How often should you inspect your mirrors?",
                    "What’s the best way to avoid a crash?",
                    "Which of the following is a sign of a drunk driver?",
                    "You see a broken yellow line. What does it mean?",
                    "What should you do if your vehicle stalls on a railroad track?",
                    "How should you secure loose cargo?",
                    "What does the term “GVWR” mean?",
                    "Which system cools the engine?",
                    "You’re stuck in traffic on a hot day. How can you prevent overheating?",
                    "What should you do if a tire is under-inflated?",
                    "What is the minimum depth for rear tires?",
                    "When should you use your hazard lights?",
                    "What is a safe speed on wet roads?",
                    "When turning, when should you signal?",
                    "You see white smoke from the exhaust. What could it mean?",
                    "If a driver cuts you off, you should:",
                    "What is the most important reason to inspect your vehicle before driving?",
                    "What is the legal BAC limit for commercial drivers?",
                    "You must stop for a school bus if:",
                    "A driver license can be revoked for:",
                    "Which of these is NOT part of the pre-trip inspection?",
                    "What is an ABS system?",
                    "How far should reflective triangles be placed behind a vehicle?",
                    "You notice a coolant leak. You should:",
                    "When descending a steep hill, use:",
                    "What’s the purpose of cargo tie-downs?",
                    "You’re approaching a sharp curve. You should:",
                    "What is the best way to check for blind spots?",
                    "How do you check for air brake leaks?",
                    "When parking on an incline, always:",
                    "If you are colorblind, you should:",
                    "Which light color means ‘proceed with caution’?",
                    "What is the best method to merge onto a highway?",
                    "You are driving in winter. What should you check?",
                    "A fire extinguisher is required if:",
                    "Which gear should you use to start on icy roads?",
                    "You must use a spotter when:",
                    "What does a steady yellow light mean?",
                    "Which is a sign of tire wear?",
                    "What should you do when passing another vehicle?",
                    "What is a ‘no-zone’?",
                    "The best way to handle fatigue is to:",
                    "When is a vehicle considered oversized?",
                    "What should you do if your engine overheats?",
                    "You should always slow down before:",
                    "An air compressor cuts in at what PSI?",
                    "How often should you check tire pressure?",
                    "What is the safest way to handle a sharp turn?",
                    "What’s the legal tread depth for front tires?",
                    "What is the penalty for refusing a BAC test?",
                    "When should you adjust your mirrors?",
                    "What is a walk-around inspection?",
                    "What does a placard on a vehicle mean?",
                    "A triangle symbol with a red border means:",
                    "How do you know if brakes are fading?",
                    "What is the best method to handle a tailgater?",
                    "Which mirror shows the largest blind spot?",
                    "What does a double solid yellow line mean?",
                    "How do you handle hydroplaning?",
                    "What does a tire pressure monitoring system do?",
                    "How should you respond to road rage?",
                    "What is the first step in a pre-trip inspection?"
            };

            for (int i = 0; i < questions.length; i++) {
                Question q = new Question();
                q.setTest(test);
                q.setText(questions[i]);
                questionRepo.save(q);
                answerRepo.save(new Answer("Correct answer for Q" + (i + 1), true, q));
                answerRepo.save(new Answer("Wrong answer 1 for Q" + (i + 1), false, q));
                answerRepo.save(new Answer("Wrong answer 2 for Q" + (i + 1), false, q));
                answerRepo.save(new Answer("Wrong answer 3 for Q" + (i + 1), false, q));
            }
        }
    }
}
