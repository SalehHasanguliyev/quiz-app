package com.quizgame.quizapp.service;

import com.quizgame.quizapp.entity.Question;
import com.quizgame.quizapp.repository.QuestionRepository;
import com.quizgame.quizapp.request.QuestionAddRequest;
import com.quizgame.quizapp.response.QuestionResponse;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data

public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public ResponseEntity<List<Question>> getAllQuestions() {

        QuestionResponse response = new QuestionResponse();

        List<Question> questionList = questionRepository.findAll();
        response.setQuestions(questionList);

        try {
            return new ResponseEntity<>(questionRepository.findAll(), HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
        }
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {

        try {
            return new ResponseEntity<>(questionRepository.findByCategory(category), HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> addQuestion(QuestionAddRequest addQuestion) {

        Question question = new Question();

        question.setQuestionTitle(addQuestion.getQuestionTitle());
        question.setOption1(addQuestion.getOption1());
        question.setOption2(addQuestion.getOption2());
        question.setOption3(addQuestion.getOption3());
        question.setOption4(addQuestion.getOption4());
        question.setRightAnswer(addQuestion.getRightAnswer());
        question.setDifficultyLevel(addQuestion.getDifficultyLevel());
        question.setCategory(addQuestion.getCategory());

        questionRepository.save(question);

        return new ResponseEntity("Question added successfully!", HttpStatus.CREATED);
    }
}
