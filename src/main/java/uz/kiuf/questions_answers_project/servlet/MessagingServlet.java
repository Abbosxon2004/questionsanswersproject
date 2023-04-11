package uz.kiuf.questions_answers_project.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.kiuf.questions_answers_project.beans.Answer_Base;
import uz.kiuf.questions_answers_project.beans.Messaging;
import uz.kiuf.questions_answers_project.service.AnswerBaseService;
import uz.kiuf.questions_answers_project.service.MessagingService;

import java.io.IOException;
import java.sql.Timestamp;

@WebServlet("/contact")
public class MessagingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Messaging messaging = new Messaging();
        messaging.setName(String.valueOf(request.getParameter("name")));
        messaging.setEmail(String.valueOf(request.getParameter("email")));
        messaging.setPhone_number(String.valueOf(request.getParameter("phone_number")));
        messaging.setMessage(String.valueOf(request.getParameter("message")));
        messaging.setSent_date(new Timestamp(System.currentTimeMillis()));

        MessagingService messagingService = new MessagingService();
        messagingService.addMessage(messaging);

        String message = "Javobingiz uchun rahmat! Sizning ishtirokingiz biz uchun muhimdir!";
        request.setAttribute("message", message);

        request.getRequestDispatcher("/contact.jsp").forward(request, response);
    }
}
