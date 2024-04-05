package com.quizgame.quizapp.controller;

import com.quizgame.quizapp.entity.Question;
import com.quizgame.quizapp.request.QuestionAddRequest;
import com.quizgame.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/question")

public class QuestionController {

    @Autowired
    private QuestionService service;

    @GetMapping(path = "/allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions() {

        return service.getAllQuestions();
    }

    @GetMapping(path = "/category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category) {

        return service.getQuestionsByCategory(category);

    }

    @PostMapping(path = "/add")
    public ResponseEntity<String> addQuestion(@RequestBody QuestionAddRequest addQuestion){

        return service.addQuestion(addQuestion);
    }

}
