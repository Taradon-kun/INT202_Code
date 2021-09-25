package sit.int202.register.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.register.models.Semester;

import java.io.IOException;

@WebServlet(name = "CoueseRegisterHistoryServlet", value = "/course-registered-history")
public class CoueseRegisterHistoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session==null || session.getAttribute("courseRegistered") == null) {
            request.setAttribute("message", "กรุณา ลงทะเบียนก่อน !!!");
        }
        getServletContext().getRequestDispatcher("/ShowRegisterHistory.jsp").forward(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
