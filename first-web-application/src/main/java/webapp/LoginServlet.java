package webapp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * Browser sends Http Request to Web Server
 *
 * Code in Web Server => Input:HttpRequest, Output: HttpResponse
 * Jakarta EE with Servlets
 *
 * Web Server responds with Http Response
 */

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Yahoo!!!!!!!!</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("My First Modern Jetty Servlet via Java 25!");
    out.println("</body>");
    out.println("</html>");
  }
}
