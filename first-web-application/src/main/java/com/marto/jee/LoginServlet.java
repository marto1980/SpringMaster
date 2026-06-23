package com.marto.jee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login.do", "/"})
public class LoginServlet extends HttpServlet {

  private UserValidationService service = new UserValidationService();

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String name = request.getParameter("name");
    String password = request.getParameter("password");
    boolean isUserValid = service.isUserValid(name, password);
    if (isUserValid) {
      request.setAttribute("name", name);
      request.setAttribute("password", password);
      request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);
    } else {
      request.setAttribute("errorMessage", "Invalid Credentials!");
      request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
    }
  }
}
