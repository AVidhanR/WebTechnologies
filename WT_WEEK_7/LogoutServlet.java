import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        long startTime = (long) session.getAttribute("startTime");
        long duration = System.currentTimeMillis() - startTime;
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>Thank You " + session.getAttribute("name") + "</h2>");
        out.println("<p>Your session duration was " + duration + " milliseconds.</p>");
        session.invalidate();
    }
}
