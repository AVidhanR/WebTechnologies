### Make sure to have...

- MySQL Community Server (comes with MySQLWorkbench) - [`download here`](https://dev.mysql.com/downloads/file/?id=526408)
- Tomcat 10.1 - [`download here`](https://dlcdn.apache.org/tomcat/tomcat-10/v10.1.23/bin/apache-tomcat-10.1.23.exe)
- IntelliJ IDEA - [`download here`](https://www.jetbrains.com/idea/download/download-thanks.html?platform=windows&code=IIC)
- mysql-connector-j-8.3.0.jar file - [`download here`](https://dev.mysql.com/downloads/file/?id=525082)

---

- Create a new `HTML` file `loginWeek13.html` and add the below code.

```html
<form action="loginWeek13.jsp" method="post">
  User name :<input type="text" name="user" /> password :<input
    type="password"
    name="pwd"
  />
  <input type="submit" />
</form>
```

- Create a new `JSP` file `loginWeek13.jsp` and add the below code.

```java
<%@ page import ="java.sql.*" %>
<%@ page import ="jakarta.sql.*" %>
<%
    String userid=request.getParameter("user");
    String pwd=request.getParameter("pwd");

    // <!-- Class.forName("com.mysql.jdbc.Driver");  -->
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");

    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery("select * from users where user_id='"+userid+"'");
    if(rs.next()) {
        if(rs.getString(2).equals(pwd)) {
            out.println("welcome "+userid);
        }
        else {
            out.println("Invalid password try again");
        }
    }
    else {
        response.sendRedirect("loginWeek13.html");
    }
%>

```

- Create a Schema `test` (if already exists leave it)
- Create a table `users` in the selected schema `test`

```sql
CREATE TABLE users (
  user_id varchar(50) PRIMARY KEY,
  password varchar(50)
);

INSERT INTO users VALUES("AVidhanR", "vinnu");

```
