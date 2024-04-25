```html
<!DOCTYPE html>
<html>
  <head>
    <style>
      div.box {
        margin: 2px;
        border: 1px solid pink;
        padding: 10px;
        background-color: #e3e3e3;
      }
    </style>
  </head>
  <body>
    <%@ page import="java.sql.*" %> 
    <%@ page import="jakarta.sql.*" %> 
    <% String user_name=request.getParameter("username"); 
    String password=request.getParameter("password");
    if(user_name==null||password==null||user_name.trim().equals("")||password.trim().equals("")){
    out.print("<p>Please Fill the Fields</p>"); 
  } else { 
    try { 
      Class.forName("com.mysql.jdbc.Driver"); 
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
      PreparedStatement ps2=con.prepareStatement("select * from users where user_id='"+user_name+"'"); 
      ResultSet rs=ps2.executeQuery(); 
      if(rs.next()) {
        if(rs.getString(2).equals(password)) { 
          out.println("welcome"+user_name); 
        }
        else { 
          out.println("Invalid password try again"); 
        } 
      } else {
        response.sendRedirect("login.html"); 
      } 
      con.close(); 
    } catch(Exception e) {
      out.print(e);
    } 
  }//end of else %>
  </body>
</html>

```