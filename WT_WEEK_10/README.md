## Code Walkthrough 

- Create a new `JSP` file i.e. `register.jsp` and add the following code.

```java
<%@ page import="java.sql.*" %>
<% try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "root");
      Statement stmt = con.createStatement();
      ResultSet rS = stmt.executeQuery("SELECT * FROM users;"); %>

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

    <% } catch (Exception e) {
      out.println("Error: " + e.getMessage());
    } %>
  </body>
</html>
```

- Create a new Schema `users`
- Create a new table `users` (name of the table and schema can be same) in the selected schema ``users`

```sql
CREATE TABLE users (
  id INT,
  name VARCHAR(50),
  password VARCHAR(50),
  email VARCHAR(50),
  phone_number VARCHAR(50)
);

INSERT INTO users VALUES (1, "AVidhanR", "1234567", "avr@gmail.com", "9988776655");
```
