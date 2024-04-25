> register.jsp

```html
<%@ page import="java.sql.*" %>  
<%
  try {
    Class.forName("com.mysql.cj.jdbc.Driver");  
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "root");
    Statement stmt = con.createStatement();
    ResultSet rS = stmt.executeQuery("SELECT * FROM users;");
%>

<!DOCTYPE html>
<html>
<head>
  <title>Registered Users</title>
</head>
<body>
  <h1>Registered Users</h1>
  <table border="1">
    <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Email</th>
      <th>Phone Number</th>
    </tr>
    <% while (rS.next()) { %>
      <tr>
        <td><%= rS.getInt(1) %></td>
        <td><%= rS.getString(2) %></td>
        <td><%= rS.getString(4) %></td>
        <td><%= rS.getString(3) %></td>
      </tr>
    <% } %>
  </table>

<% 
  } catch (Exception e) {
    out.println("Error: " + e.getMessage());
  } 
%>

</body>
</html>


```
