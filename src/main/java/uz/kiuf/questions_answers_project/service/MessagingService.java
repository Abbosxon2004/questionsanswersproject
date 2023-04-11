package uz.kiuf.questions_answers_project.service;

import uz.kiuf.questions_answers_project.beans.Answer_Base;
import uz.kiuf.questions_answers_project.beans.Messaging;
import uz.kiuf.questions_answers_project.dao.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MessagingService {
    public String addMessage(Messaging messaging) {
        int rowsAffected = 0;
        Connection connection = DBConnection.getConnectionToDatabase();

        try {

            String insertQuery = "insert into messaging(name,phone_number,email,message,sent_date) values(?,?,?,?,?)";

            PreparedStatement statement = connection.prepareStatement(insertQuery);
            statement.setString(1, messaging.getName());
            statement.setString(2, messaging.getPhone_number());
            statement.setString(3, messaging.getEmail());
            statement.setString(4, messaging.getMessage());
            statement.setTimestamp(5, new Timestamp(System.currentTimeMillis()));

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
        return rowsAffected>0?"Your message sent":"Something went wrong!";
    }

    public List<Messaging> getMessages() {
        List<Messaging> messagingList = new ArrayList<>();
        Messaging message = null;
        try {
            Connection connection = DBConnection.getConnectionToDatabase();

            String sql = "select * from messaging order by created_date asc";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                message = new Messaging();
                message.setId(resultSet.getInt("id"));
                message.setName(resultSet.getString("name"));
                message.setPhone_number(resultSet.getString("phone_number"));
                message.setEmail(resultSet.getString("email"));
                message.setMessage(resultSet.getString("message"));
                message.setSent_date(resultSet.getTimestamp("sent_time"));
                messagingList.add(message);
            }
            connection.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return messagingList;
    }
}
