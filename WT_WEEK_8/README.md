### Calculator Web Application

- Firstly, create a `HTML` file named as `calculator_servlet.html` (The name of `HTML` file can be anything but, better to keep an easy one) add the necessary code in it.
- Secondly, a `JSP` file named as `result.jsp` and add the necessary code in it.
- Now, create a `Java` file named as `CalculatorServlet.java` (This name should be absolute with no changes, if you done any make sure to change in the `HTML` file too) add the necessary code in it.
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

- Let's execute the program by going to the tomcat server by typing [`http://localhost:8080`]() in the browser address bar.
- Now in the address bar replace it with this url [`http://localhost:8080/examples/calculator_servlet.html`]()
- That's it now you can access the web application with ease.

<font color="red">Note : </font>

- Donot close the cmd window that appeared when you clicked the `Tomcat10.exe`
