### Calculator Web Application

- Firstly, create a `HTML` file named as `calculator_servlet.html` (The name of `HTML` file can be anything but, better to keep an easy one) add the necessary code in it.

```html
<!DOCTYPE html>
<html>
  <head>
    <title>Calculator</title>
  </head>
  <body>
    <h1>Calculator</h1>
    <form action="CalculatorServlet" method="post">
      <input type="text" name="number1" />
      <select name="operator">
        <option value="+">+</option>
        <option value="-">-</option>
        <option value="/">/</option>
        <option value="*">*</option>
        <option value="%">%</option>
      </select>
      <input type="text" name="number2" />
      <input type="submit" value="Calculate" />
    </form>
  </body>
</html>
```

- Secondly, a `JSP` file named as `result.jsp` and add the necessary code in it.

```java
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Result</title>
  </head>
  <body>
    <h2>Result: <%= request.getAttribute("result") %></h2>
  </body>
</html>

```

- Now, create a `Java` file named as `CalculatorServlet.java` (This name should be absolute with no changes, if you done any make sure to change in the `HTML` file too) add the necessary code in it.

```java

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        double num1 = Double.parseDouble(request.getParameter("number1"));
        double num2 = Double.parseDouble(request.getParameter("number2"));
        String operator = request.getParameter("operator");
        double result = 0;

        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    result = Double.NaN; // Handle division by zero
                }
                break;
            case "%":
                result = num1 % num2;
                break;
        }
        request.setAttribute("result", result);
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}

```

- Now, Start the Tomcat server but double clicking `Tomcat10.exe` and leave the cmd window be.
- **Path to find Tomcat10.exe is** [`Program Files\Apache Software Foundation\Tomcat 10.1\bin`]()
- After that, double click the `startup.bat` for our benefit.
- Place the `calculator_servlet.html` in this path [`Program Files\Apache Software Foundation\Tomcat 10.1\webapps\examples`]()
- Now, compile the `CalculatorServlet.java` and then a class file is generated `CalculatorServlet.class` place these two file in (classes folder) this path [`Program Files\Apache Software Foundation\Tomcat 10.1\webapps\examples\WEB-INF\classes`]()
- Update the existing `web.xml` available in the path [`Program Files\Apache Software Foundation\Tomcat 10.1\webapps\examples\WEB-INF`]() with the below data

```xml
<servlet>
    <servlet-name>CalculatorServlet</servlet-name>
    <servlet-class>CalculatorServlet</servlet-class>
</servlet>
<servlet-mapping>
    <servlet-name>CalculatorServlet</servlet-name>
    <url-pattern>/CalculatorServlet</url-pattern>
</servlet-mapping>
```

- Let's execute the program by going to the tomcat server by typing [`http://localhost:8080`](http://localhost:8080) in the browser address bar.
- Now in the address bar replace it with this url [`http://localhost:8080/examples/calculator_servlet.html`]()
- That's it now you can access the web application with ease.

<font color="red">Note : </font>

- Donot close the cmd window that appeared when you clicked the `Tomcat10.exe`
