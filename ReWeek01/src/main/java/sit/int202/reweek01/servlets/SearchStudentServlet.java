package sit.int202.reweek01.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.reweek01.models.Student;
import sit.int202.reweek01.models.StudentRepository;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SearchStudentServlet", value = "/search-student")
public class SearchStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentRepository studentRepository = new StudentRepository();
        String paramId = request.getParameter("id");
        Integer id = null;
        if (paramId != null) {
            try {
                id = Integer.valueOf(paramId);
            } finally {
            }
        }
        Student student = studentRepository.find(id);
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<body style='padding: 100px'>");
            out.println("<h3>Student List ::</h3><hr>");
            out.println("<table>");
            if (student != null) {
                out.println("<tr><td>Id: </td> <td>" + student.getId() + "</td></tr>");
                out.println("<tr><td>Name: </td> <td>" + student.getName() + "</td></tr>");
                out.println("<tr><td>GPAX: </td> <td>" + student.getGpax() + "</td></tr>");
                out.println("<tr><td colspan='2'><hr></td></tr>");
            } else {
                out.println("<tr><td> Student ID: '" + paramId + "' does not exist !!</td></tr>");
            }
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
