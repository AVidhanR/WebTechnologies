## Code Walkthrough 

- Firstly, Open `Program Files\Apache Software Foundation\Tomcat10.1\webapps\examples` and add the below `login.html` and `login.jsp`
- Start the `Tomcat Server`
- Start the `MySQL Server`
- Type in `http://localhost:8080/examples/login.html`

- Add the below code in created new file `login.html`

```html
<form action="login.jsp" method="post">
  User name :<input type="text" name="user" /> password :<input
    type="password"
    name="pwd"
  />
  <input type="submit" />
</form>
```

- Add the below code in created new file `login.jsp`

```java
<%@ page import ="java.sql.*" %>
<%@ page import ="jakarta.sql.*" %>
<%
    String userid = request.getParameter("user");
    String pwd = request.getParameter("pwd");

    // <!-- Class.forName("com.mysql.jdbc.Driver");  no need-->
    Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/test","root","root"
    );

    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery(
        "select * from users where user_id='"+userid+"'"
    );
    if(rs.next()) {
        if(rs.getString(2).equals(pwd)) {
            out.println("welcome "+userid);
        }
        else {
            out.println("Invalid password try again");
        }
    } else {
        response.sendRedirect("login.html");
    }
    con.close();
%>

```

- Create a Schema `test`
- Create a table `users` in the selected schema `test`

```sql
CREATE TABLE users (
  user_id varchar(50) PRIMARY KEY,
  password varchar(50)
);

INSERT INTO users VALUES("AVidhanR", "vinnu");

```

_By AVidhanR_
