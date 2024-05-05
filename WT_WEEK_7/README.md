### Greeting's Web Application

- Firstly, create a `HTML` file named as `welcome_servlet.html` (The name of `HTML` file can be anything but, better to keep an easy one) add the necessary code in it.

```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>WelcomeServlet</title>
  </head>
  <body>
    <h1>Enter Your Name:</h1>
    <form action="WelcomeServlet" method="post">
      <input type="text" name="name" />
      <input type="submit" value="Submit" />
    </form>
  </body>
</html>
```

- Secondly, create a `Java` file named as `WelcomeServlet.java` and `LogoutServlet.java`(This name should be absolute no changes, if you done any make sure to change in the `HTML` file too) add teh necessary code in them.

```java
//WelcomeServlet.java
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

```

- The below code is to be in `LogoutServlet.java`

```java
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

```

- Now, Start the Tomcat server but double clicking `Tomcat10.exe` and leave the cmd window be.
- **Path to find Tomcat10.exe is** [`Program Files\Apache Software Foundation\Tomcat 10.1\bin`]()
- After that, double click the `startup.bat` for our benefit.
- Place the `welcome_servlet.html` in this path [`Program Files\Apache Software Foundation\Tomcat 10.1\webapps\examples`]()

- Now, compile the `WelcomeServlet.java`, `LogoutServlet.java` and then the class files are generated `WelcomeServlet.class`, `LogoutServlet.class` place these four file in (classes folder) this path [`Program Files\Apache Software Foundation\Tomcat 10.1\webapps\examples\WEB-INF\classes`]()

- Update the existing `web.xml` available in the path `` with the below data

```xml
<servlet>
        <servlet-name>WelcomeServlet</servlet-name>
        <servlet-class>WelcomeServlet</servlet-class>
</servlet>
<servlet>
        <servlet-name>LogoutServlet</servlet-name>
        <servlet-class>LogoutServlet</servlet-class>
</servlet>
<servlet-mapping>
        <servlet-name>LogoutServlet</servlet-name>
        <url-pattern>/LogoutServlet</url-pattern>
</servlet-mapping>
<servlet-mapping>
        <servlet-name>WelcomeServlet</servlet-name>
        <url-pattern>/WelcomeServlet</url-pattern>
</servlet-mapping>
<servlet>
        <servlet-name>LogoutServlet</servlet-name>
        <servlet-class>LogoutServlet</servlet-class>
</servlet>
<servlet-mapping>
        <servlet-name>LogoutServlet</servlet-name>
        <url-pattern>/LogoutServlet</url-pattern>
</servlet-mapping>
```

- Let's execute the program by going to the tomcat server by typing [`http://localhost:8080`]() in the browser address bar.
- Now in the address bar replace it with this url [`http://localhost:8080/examples/welcome_servlet.html`]()
- That's it now you can access the web application with ease.

<font color="red">Note : </font>

- Donot close the cmd window that appeared when you clicked the `Tomcat10.exe`
