package sit.int202.reweek01.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.reweek01.models.Student;
import sit.int202.reweek01.models.StudentRepository;

import java.io.IOException;

@WebServlet(name = "AddStudentServlet", value = "/add-new-student")
public class AddStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/StudentForm.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String gpax = request.getParameter("gpax");
        if(id.trim().length()==0 || name.trim().length()==0 || gpax.trim().length()==0){
            request.setAttribute("msg","Invalid data");
            getServletContext().getRequestDispatcher("/StudentForm.jsp").forward(request,response);
            return ;
        }
        Student student = new Student(Integer.valueOf(id),name,Double.valueOf(gpax));
        StudentRepository studentRepository = new StudentRepository();
        studentRepository.save(student);
//        getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
        request.setAttribute("student",student);
        getServletContext().getRequestDispatcher("/StudentInfo.jsp").forward(request,response);
    }
}
