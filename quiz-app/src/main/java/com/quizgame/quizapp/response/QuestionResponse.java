package com.quizgame.quizapp.response;

import com.quizgame.quizapp.entity.Question;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter

public class QuestionResponse {

    private List<Question> questions;

}
