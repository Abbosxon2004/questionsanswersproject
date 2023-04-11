package uz.kiuf.questions_answers_project.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Messaging {
    private Integer id;
    private String name;
    private String phone_number;
    private String email;
    private String message;
    private Timestamp sent_date;
}
