import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class WelcomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");

        HttpSession session = request.getSession();
        session.setAttribute("name", name);
        session.setAttribute("startTime", System.currentTimeMillis());

        out.println("<h2>Hello " + name + "</h2>");
        out.println("<p align='right'>Session started at " + session.getAttribute("startTime") + "</p>");
        out.println("<form action='LogoutServlet' method='post'>");
        out.println("<input type='submit' value='Logout'>");
        out.println("</form>");
    }
}
