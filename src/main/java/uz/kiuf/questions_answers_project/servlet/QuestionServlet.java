package uz.kiuf.questions_answers_project.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.kiuf.questions_answers_project.beans.Answer_Base;
import uz.kiuf.questions_answers_project.beans.Question;
import uz.kiuf.questions_answers_project.service.AnswerBaseService;
import uz.kiuf.questions_answers_project.service.QuestionService;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import static uz.kiuf.questions_answers_project.enums.Q_Number.NUMBER_OF_QUESTIONS;

@WebServlet("/questions")
public class QuestionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        QuestionService dao = new QuestionService();
        List<Question> questionList = dao.getQuestions(15);

        request.setAttribute("questions", questionList);

        request.getRequestDispatcher("/savollar.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int full_score = 0;
        System.out.println("isisisisisisisi");
        for (int i = 0; i < 10; i++) {
            String value = request.getParameter("q" + i);
            System.out.println(value);
            System.out.println("ishladi");
            full_score += Integer.parseInt(value);
        }
        String sender = String.valueOf(request.getParameter("sender"));
        sender = sender.equals("") ? "unknown_user" : sender;
        Answer_Base answer = new Answer_Base();
        answer.setScore(full_score);
        answer.setSender(sender);
        answer.setAge(Integer.valueOf(request.getParameter("age")));
        answer.setCreated_date(new Timestamp(System.currentTimeMillis()));

        AnswerBaseService answerBaseService = new AnswerBaseService();
        answerBaseService.addAnswer(answer);
        String message = "Javobingiz uchun rahmat! Sizning ishtirokingiz biz uchun muhimdir!";
        if (full_score >= 25) message += "\nIltimos internetdan foydalanishni biroz kamaytiring";
        if (full_score < 25 && full_score > 15) message += "\nSizning internet foydalanish darajangiz o`rtacha hisoblandi.Shunday davom eting";
        if (full_score <= 15) message += "\nSiz internet zarar tegmaydigan darajada foydalanar ekansiz. Ajoyib natija!";
        request.setAttribute("message", message);
        request.getRequestDispatcher("/answer.jsp").forward(request, response);
    }
}
