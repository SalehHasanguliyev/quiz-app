package com.quizgame.quizapp.controller;

import com.quizgame.quizapp.entity.Question;
import com.quizgame.quizapp.entity.QuestionWrapper;
import com.quizgame.quizapp.entity.Response;
import com.quizgame.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/quiz")

public class QuizController {

    @Autowired
    QuizService service;

    @PostMapping(path = "/create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){

    return service.createQuiz(category, numQ, title);

    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){

        return service.getQuizQuestions(id);
    }

    @PostMapping(path = "/submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){

    return service.calculateResult(id, responses);
    }

}
