> login.html
```html
<form action="login.jsp" method="post">
  User name :<input type="text" name="user" /> password :<input
    type="password"
    name="pwd"
  />
  <input type="submit" />
</form>

```

> login.jsp

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
        response.sendRedirect("login.html"); 
    }
%>

```
_AVidhanR_
