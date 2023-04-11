package uz.kiuf.questions_answers_project.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Answer_Base {
    private Integer id;
    private Integer score;
    private String sender;
    private Integer age;
    private Timestamp created_date;
}
