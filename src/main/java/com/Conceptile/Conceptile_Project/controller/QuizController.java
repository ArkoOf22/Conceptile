package com.Conceptile.Conceptile_Project.controller;

import com.Conceptile.Conceptile_Project.dto.UserStats;
import com.Conceptile.Conceptile_Project.model.Question;
import com.Conceptile.Conceptile_Project.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    // API to get a random question
    @GetMapping("/random-question")
    public ResponseEntity<Question> getRandomQuestion() {
        return quizService.getRandomQuestion()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }

    // API to submit an answer
    @PostMapping("/submit-answer")
    public ResponseEntity<String> submitAnswer(
            @RequestParam Long userId,
            @RequestParam Long questionId,
            @RequestParam String answer
    ) {
        boolean isCorrect = quizService.submitAnswer(userId, questionId, answer);
        return isCorrect
                ? ResponseEntity.ok("Correct Answer!")
                : ResponseEntity.ok("Incorrect Answer!");
    }

    // API to get user stats
    @GetMapping("/user-stats/{userId}")
    public ResponseEntity<UserStats> getUserStats(@PathVariable Long userId) {
        return quizService.getUserStats(userId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}

