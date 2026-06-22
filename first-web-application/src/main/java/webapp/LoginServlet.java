package webapp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login.do", "/"})
public class LoginServlet extends HttpServlet {

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setAttribute("name", request.getParameter("name"));
    request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);
  }
}
