package com.Conceptile.Conceptile_Project.service;

import com.Conceptile.Conceptile_Project.dto.UserStats;
import com.Conceptile.Conceptile_Project.model.App_User;
import com.Conceptile.Conceptile_Project.model.Question;
import com.Conceptile.Conceptile_Project.repository.QuestionRepository;
import com.Conceptile.Conceptile_Project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class QuizService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private UserRepository userRepository;

    private final Random random = new Random();

    // Retrieve a random question
    public Optional<Question> getRandomQuestion() {
        List<Question> questions = questionRepository.findAll();
        System.out.println("Questions in DB: " + questions.size());
        if (questions.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(questions.get(random.nextInt(questions.size())));
    }

    // Submit an answer and update user stats
    public boolean submitAnswer(Long userId, Long questionId, String answer) {
        Optional<Question> questionOptional = questionRepository.findById(questionId);
        Optional<App_User> userOptional = userRepository.findById(userId);

        if (questionOptional.isEmpty() || userOptional.isEmpty()) {
            return false;
        }

        Question question = questionOptional.get();
        App_User user = userOptional.get();

        boolean isCorrect = question.getCorrectOption().equalsIgnoreCase(answer);
        user.setTotalQuestionsAnswered(user.getTotalQuestionsAnswered() + 1);

        if (isCorrect) {
            user.setCorrectAnswers(user.getCorrectAnswers() + 1);
        } else {
            user.setIncorrectAnswers(user.getIncorrectAnswers() + 1);
        }

        userRepository.save(user);
        return isCorrect;
    }

    // Retrieve quiz stats for a user
    public Optional<UserStats> getUserStats(Long userId) {
        Optional<App_User> userOptional = userRepository.findById(userId);
        return userOptional.map(user -> new UserStats(
                user.getName(),
                user.getCorrectAnswers(),
                user.getIncorrectAnswers(),
                user.getTotalQuestionsAnswered()
        ));
    }
}
