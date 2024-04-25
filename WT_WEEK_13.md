> loginWeek13.html

```html
<form action="loginWeek13.jsp" method="post">
  User name :<input type="text" name="user" /> password :<input
    type="password"
    name="pwd"
  />
  <input type="submit" />
</form>

```
> loginWeek13.jsp

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
