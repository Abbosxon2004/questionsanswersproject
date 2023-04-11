package uz.kiuf.questions_answers_project.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    private Integer id;
    private String question;
    private String option_1;
    private String option_2;
    private String option_3;
}
