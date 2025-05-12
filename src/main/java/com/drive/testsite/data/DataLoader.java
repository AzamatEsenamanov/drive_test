package com.drive.testsite.data;

import com.drive.testsite.entity.Answer;
import com.drive.testsite.entity.Question;
import com.drive.testsite.entity.Test;
import com.drive.testsite.repositary.AnswerRepository;
import com.drive.testsite.repositary.QuestionRepository;
import com.drive.testsite.repositary.TestRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {
    @Bean
    CommandLineRunner loadTestData(TestRepository testRepo, QuestionRepository questionRepo, AnswerRepository answerRepo) {
        return args -> {
            if (testRepo.count() == 0) {
                Test test = new Test();
                test.setTitle("English Proficiency Test for CDL Holders");
                test.setPaid(false);
                testRepo.save(test);

                Question q1 = new Question();
                q1.setTest(test);
                q1.setText("You see a sign that says \"Low Clearance - 12\'6\".\" What should you do?");
                questionRepo.save(q1);
                answerRepo.save(new Answer(null, "Speed up to pass quickly", false, q1));
                answerRepo.save(new Answer(null, "Ignore the sign", false, q1));
                answerRepo.save(new Answer(null, "Ensure your vehicle height is less than 12 feet 6 inches", true, q1));
                answerRepo.save(new Answer(null, "Call dispatch for instructions", false, q1));

                Question q2 = new Question();
                q2.setTest(test);
                q2.setText("During a roadside inspection, the officer asks, \"May I see your logbook?\" What do you do?");
                questionRepo.save(q2);
                answerRepo.save(new Answer(null, "Say you don't understand", false, q2));
                answerRepo.save(new Answer(null, "Hand over your logbook", true, q2));
                answerRepo.save(new Answer(null, "Ignore the request", false, q2));
                answerRepo.save(new Answer(null, "Show your driver's license instead", false, q2));

                Question q3 = new Question();
                q3.setTest(test);
                q3.setText("The dispatcher says, \"Your delivery is delayed due to weather.\" What does this mean?");
                questionRepo.save(q3);
                answerRepo.save(new Answer(null, "You should speed up", false, q3));
                answerRepo.save(new Answer(null, "You have to wait before delivering", true, q3));
                answerRepo.save(new Answer(null, "The delivery is canceled", false, q3));
                answerRepo.save(new Answer(null, "Change your delivery address", false, q3));

                Question q4 = new Question();
                q4.setTest(test);
                q4.setText("A sign reads \"Detour Ahead.\" What should you expect?");
                questionRepo.save(q4);
                answerRepo.save(new Answer(null, "Road closure", true, q4));
                answerRepo.save(new Answer(null, "Police checkpoint", false, q4));
                answerRepo.save(new Answer(null, "Rest area", false, q4));
                answerRepo.save(new Answer(null, "Weigh station", false, q4));

                Question q5 = new Question();
                q5.setTest(test);
                q5.setText("You hear on the radio: \"Expect delays due to construction on I-80 East.\" What should you do?");
                questionRepo.save(q5);
                answerRepo.save(new Answer(null, "Ignore the message", false, q5));
                answerRepo.save(new Answer(null, "Take an alternate route if possible", true, q5));
                answerRepo.save(new Answer(null, "Speed up to avoid delays", false, q5));
                answerRepo.save(new Answer(null, "Stop driving immediately", false, q5));

                Question q6 = new Question();
                q6.setTest(test);
                q6.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q6);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q6));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q6));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q6));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q6));

                Question q7 = new Question();
                q7.setTest(test);
                q7.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q7);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q7));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q7));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q7));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q7));

                Question q8 = new Question();
                q8.setTest(test);
                q8.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q8);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q8));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q8));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q8));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q8));

                Question q9 = new Question();
                q9.setTest(test);
                q9.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q9);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q9));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q9));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q9));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q9));

                Question q10 = new Question();
                q10.setTest(test);
                q10.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q10);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q10));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q10));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q10));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q10));

                Question q11 = new Question();
                q11.setTest(test);
                q11.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q11);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q11));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q11));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q11));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q11));

                Question q12 = new Question();
                q12.setTest(test);
                q12.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q12);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q12));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q12));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q12));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q12));

                Question q13 = new Question();
                q13.setTest(test);
                q13.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q13);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q13));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q13));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q13));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q13));

                Question q14 = new Question();
                q14.setTest(test);
                q14.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q14);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q14));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q14));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q14));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q14));

                Question q15 = new Question();
                q15.setTest(test);
                q15.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q15);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q15));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q15));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q15));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q15));

                Question q16 = new Question();
                q16.setTest(test);
                q16.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q16);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q16));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q16));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q16));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q16));

                Question q17 = new Question();
                q17.setTest(test);
                q17.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q17);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q17));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q17));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q17));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q17));

                Question q18 = new Question();
                q18.setTest(test);
                q18.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q18);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q18));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q18));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q18));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q18));

                Question q19 = new Question();
                q19.setTest(test);
                q19.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q19);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q19));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q19));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q19));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q19));

                Question q20 = new Question();
                q20.setTest(test);
                q20.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q20);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q20));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q20));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q20));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q20));

                Question q21 = new Question();
                q21.setTest(test);
                q21.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q21);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q21));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q21));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q21));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q21));

                Question q22 = new Question();
                q22.setTest(test);
                q22.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q22);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q22));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q22));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q22));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q22));

                Question q23 = new Question();
                q23.setTest(test);
                q23.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q23);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q23));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q23));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q23));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q23));

                Question q24 = new Question();
                q24.setTest(test);
                q24.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q24);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q24));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q24));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q24));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q24));

                Question q25 = new Question();
                q25.setTest(test);
                q25.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q25);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q25));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q25));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q25));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q25));

                Question q26 = new Question();
                q26.setTest(test);
                q26.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q26);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q26));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q26));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q26));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q26));

                Question q27 = new Question();
                q27.setTest(test);
                q27.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q27);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q27));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q27));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q27));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q27));

                Question q28 = new Question();
                q28.setTest(test);
                q28.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q28);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q28));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q28));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q28));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q28));

                Question q29 = new Question();
                q29.setTest(test);
                q29.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q29);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q29));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q29));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q29));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q29));

                Question q30 = new Question();
                q30.setTest(test);
                q30.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q30);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q30));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q30));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q30));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q30));

                Question q31 = new Question();
                q31.setTest(test);
                q31.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q31);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q31));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q31));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q31));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q31));

                Question q32 = new Question();
                q32.setTest(test);
                q32.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q32);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q32));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q32));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q32));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q32));

                Question q33 = new Question();
                q33.setTest(test);
                q33.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q33);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q33));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q33));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q33));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q33));

                Question q34 = new Question();
                q34.setTest(test);
                q34.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q34);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q34));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q34));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q34));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q34));

                Question q35 = new Question();
                q35.setTest(test);
                q35.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q35);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q35));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q35));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q35));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q35));

                Question q36 = new Question();
                q36.setTest(test);
                q36.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q36);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q36));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q36));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q36));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q36));

                Question q37 = new Question();
                q37.setTest(test);
                q37.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q37);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q37));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q37));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q37));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q37));

                Question q38 = new Question();
                q38.setTest(test);
                q38.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q38);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q38));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q38));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q38));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q38));

                Question q39 = new Question();
                q39.setTest(test);
                q39.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q39);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q39));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q39));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q39));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q39));

                Question q40 = new Question();
                q40.setTest(test);
                q40.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q40);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q40));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q40));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q40));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q40));

                Question q41 = new Question();
                q41.setTest(test);
                q41.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q41);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q41));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q41));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q41));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q41));

                Question q42 = new Question();
                q42.setTest(test);
                q42.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q42);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q42));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q42));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q42));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q42));

                Question q43 = new Question();
                q43.setTest(test);
                q43.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q43);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q43));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q43));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q43));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q43));

                Question q44 = new Question();
                q44.setTest(test);
                q44.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q44);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q44));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q44));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q44));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q44));

                Question q45 = new Question();
                q45.setTest(test);
                q45.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q45);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q45));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q45));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q45));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q45));

                Question q46 = new Question();
                q46.setTest(test);
                q46.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q46);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q46));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q46));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q46));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q46));

                Question q47 = new Question();
                q47.setTest(test);
                q47.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q47);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q47));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q47));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q47));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q47));

                Question q48 = new Question();
                q48.setTest(test);
                q48.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q48);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q48));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q48));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q48));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q48));

                Question q49 = new Question();
                q49.setTest(test);
                q49.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q49);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q49));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q49));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q49));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q49));

                Question q50 = new Question();
                q50.setTest(test);
                q50.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q50);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q50));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q50));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q50));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q50));

                Question q51 = new Question();
                q51.setTest(test);
                q51.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q51);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q51));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q51));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q51));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q51));

                Question q52 = new Question();
                q52.setTest(test);
                q52.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q52);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q52));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q52));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q52));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q52));

                Question q53 = new Question();
                q53.setTest(test);
                q53.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q53);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q53));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q53));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q53));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q53));

                Question q54 = new Question();
                q54.setTest(test);
                q54.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q54);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q54));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q54));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q54));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q54));

                Question q55 = new Question();
                q55.setTest(test);
                q55.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q55);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q55));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q55));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q55));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q55));

                Question q56 = new Question();
                q56.setTest(test);
                q56.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q56);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q56));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q56));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q56));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q56));

                Question q57 = new Question();
                q57.setTest(test);
                q57.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q57);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q57));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q57));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q57));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q57));

                Question q58 = new Question();
                q58.setTest(test);
                q58.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q58);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q58));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q58));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q58));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q58));

                Question q59 = new Question();
                q59.setTest(test);
                q59.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q59);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q59));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q59));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q59));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q59));

                Question q60 = new Question();
                q60.setTest(test);
                q60.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q60);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q60));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q60));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q60));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q60));

                Question q61 = new Question();
                q61.setTest(test);
                q61.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q61);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q61));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q61));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q61));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q61));

                Question q62 = new Question();
                q62.setTest(test);
                q62.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q62);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q62));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q62));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q62));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q62));

                Question q63 = new Question();
                q63.setTest(test);
                q63.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q63);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q63));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q63));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q63));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q63));

                Question q64 = new Question();
                q64.setTest(test);
                q64.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q64);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q64));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q64));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q64));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q64));

                Question q65 = new Question();
                q65.setTest(test);
                q65.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q65);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q65));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q65));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q65));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q65));

                Question q66 = new Question();
                q66.setTest(test);
                q66.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q66);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q66));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q66));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q66));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q66));

                Question q67 = new Question();
                q67.setTest(test);
                q67.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q67);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q67));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q67));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q67));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q67));

                Question q68 = new Question();
                q68.setTest(test);
                q68.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q68);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q68));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q68));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q68));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q68));

                Question q69 = new Question();
                q69.setTest(test);
                q69.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q69);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q69));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q69));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q69));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q69));

                Question q70 = new Question();
                q70.setTest(test);
                q70.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q70);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q70));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q70));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q70));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q70));

                Question q71 = new Question();
                q71.setTest(test);
                q71.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q71);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q71));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q71));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q71));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q71));

                Question q72 = new Question();
                q72.setTest(test);
                q72.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q72);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q72));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q72));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q72));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q72));

                Question q73 = new Question();
                q73.setTest(test);
                q73.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q73);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q73));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q73));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q73));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q73));

                Question q74 = new Question();
                q74.setTest(test);
                q74.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q74);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q74));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q74));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q74));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q74));

                Question q75 = new Question();
                q75.setTest(test);
                q75.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q75);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q75));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q75));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q75));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q75));

                Question q76 = new Question();
                q76.setTest(test);
                q76.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q76);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q76));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q76));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q76));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q76));

                Question q77 = new Question();
                q77.setTest(test);
                q77.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q77);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q77));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q77));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q77));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q77));

                Question q78 = new Question();
                q78.setTest(test);
                q78.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q78);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q78));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q78));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q78));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q78));

                Question q79 = new Question();
                q79.setTest(test);
                q79.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q79);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q79));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q79));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q79));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q79));

                Question q80 = new Question();
                q80.setTest(test);
                q80.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q80);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q80));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q80));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q80));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q80));

                Question q81 = new Question();
                q81.setTest(test);
                q81.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q81);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q81));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q81));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q81));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q81));

                Question q82 = new Question();
                q82.setTest(test);
                q82.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q82);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q82));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q82));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q82));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q82));

                Question q83 = new Question();
                q83.setTest(test);
                q83.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q83);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q83));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q83));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q83));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q83));

                Question q84 = new Question();
                q84.setTest(test);
                q84.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q84);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q84));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q84));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q84));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q84));

                Question q85 = new Question();
                q85.setTest(test);
                q85.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q85);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q85));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q85));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q85));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q85));

                Question q86 = new Question();
                q86.setTest(test);
                q86.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q86);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q86));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q86));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q86));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q86));

                Question q87 = new Question();
                q87.setTest(test);
                q87.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q87);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q87));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q87));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q87));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q87));

                Question q88 = new Question();
                q88.setTest(test);
                q88.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q88);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q88));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q88));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q88));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q88));

                Question q89 = new Question();
                q89.setTest(test);
                q89.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q89);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q89));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q89));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q89));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q89));

                Question q90 = new Question();
                q90.setTest(test);
                q90.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q90);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q90));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q90));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q90));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q90));

                Question q91 = new Question();
                q91.setTest(test);
                q91.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q91);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q91));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q91));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q91));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q91));

                Question q92 = new Question();
                q92.setTest(test);
                q92.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q92);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q92));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q92));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q92));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q92));

                Question q93 = new Question();
                q93.setTest(test);
                q93.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q93);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q93));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q93));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q93));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q93));

                Question q94 = new Question();
                q94.setTest(test);
                q94.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q94);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q94));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q94));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q94));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q94));

                Question q95 = new Question();
                q95.setTest(test);
                q95.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q95);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q95));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q95));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q95));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q95));

                Question q96 = new Question();
                q96.setTest(test);
                q96.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q96);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q96));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q96));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q96));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q96));

                Question q97 = new Question();
                q97.setTest(test);
                q97.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q97);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q97));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q97));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q97));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q97));

                Question q98 = new Question();
                q98.setTest(test);
                q98.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q98);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q98));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q98));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q98));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q98));

                Question q99 = new Question();
                q99.setTest(test);
                q99.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q99);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q99));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q99));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q99));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q99));

                Question q100 = new Question();
                q100.setTest(test);
                q100.setText("When approaching a traffic sign you do not understand, what should you do?");
                questionRepo.save(q100);
                answerRepo.save(new Answer(null, "Guess its meaning", false, q100));
                answerRepo.save(new Answer(null, "Ignore it and continue driving", false, q100));
                answerRepo.save(new Answer(null, "Slow down and try to interpret it", true, q100));
                answerRepo.save(new Answer(null, "Stop the truck immediately", false, q100));            }
        };
    }
}