package uz.kiuf.questions_answers_project.service;

import uz.kiuf.questions_answers_project.beans.Answer_Base;
import uz.kiuf.questions_answers_project.dao.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnswerBaseService {
    public String addAnswer(Answer_Base answer_base) {
        int rowsAffected = 0;
        Connection connection = DBConnection.getConnectionToDatabase();

        try {

            String insertQuery = "insert into answer_base(score,sender,age,created_date) values(?,?,?,?)";

            PreparedStatement statement = connection.prepareStatement(insertQuery);
            statement.setInt(1, answer_base.getScore());
            statement.setString(2, answer_base.getSender());
            statement.setInt(3, answer_base.getAge());
            statement.setTimestamp(4, new Timestamp(System.currentTimeMillis()));

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
        return rowsAffected>0?"Successfully answered":"Something went wrong!";
    }

    public List<Answer_Base> getResults() {
        List<Answer_Base> answerBaseList = new ArrayList<>();
        Answer_Base answer_base = null;
        try {
            Connection connection = DBConnection.getConnectionToDatabase();

            String sql = "select * from answer_base order by created_date asc";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                answer_base = new Answer_Base();
                answer_base.setId(resultSet.getInt("id"));
                answer_base.setScore(resultSet.getInt("score"));
                answer_base.setSender(resultSet.getString("sender"));
                answer_base.setAge(resultSet.getInt("age"));
                answer_base.setCreated_date(resultSet.getTimestamp("created_date"));
                answerBaseList.add(answer_base);
            }
            connection.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return answerBaseList;
    }
}