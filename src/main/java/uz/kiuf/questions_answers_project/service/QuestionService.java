package uz.kiuf.questions_answers_project.service;

import uz.kiuf.questions_answers_project.beans.Question;
import uz.kiuf.questions_answers_project.dao.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionService {
    /**
     * @param question
     * @return String message
     */
    public String addQuestion(Question question) {
        int rowsAffected = 0;
        Connection connection = DBConnection.getConnectionToDatabase();

        try {

            String insertQuery = "insert into questions(question,option_1,option_2,option_3,created_by) values(?,?,?,?,?)";

            PreparedStatement statement = connection.prepareStatement(insertQuery);
            statement.setString(1, question.getQuestion());
            statement.setString(2, question.getOption_1());
            statement.setString(3, question.getOption_2());
            statement.setString(4, question.getOption_3());

            rowsAffected = statement.executeUpdate();
            connection.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return rowsAffected > 0 ? "Question added" : "Any error occured! Try again";
    }

    /**
     * @param number - number of questions
     * @return List of questions
     */
    public List<Question> getQuestions(int number) {
        List<Question> questionList = new ArrayList<>();
        Question question = null;
        try {
            Connection connection = DBConnection.getConnectionToDatabase();

            String sql = "select * from questions order by random() limit ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, number);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                question = new Question();
                question.setQuestion(resultSet.getString("question"));
                question.setOption_1(resultSet.getString("option_1"));
                question.setOption_2(resultSet.getString("option_2"));
                question.setOption_3(resultSet.getString("option_3"));
                questionList.add(question);
            }
            connection.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return questionList;
    }
}
