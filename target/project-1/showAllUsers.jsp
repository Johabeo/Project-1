<%@ page import="java.util.*"%>
<%@ page import="com.dto.User"%>

<!Doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
    <title>Table</title>
  </head>
  <body>
    <div class="noise"></div>
    <div class="overlay"></div>
    <div class="table-box">
        <a href="view" class="output btn">Requests</a>
    	<a href="logout" class="output btn">Logout</a>
        <table class="table">
          <thead>
            <tr>
              <th scope="col">EmployeeId</th>
              <th scope="col">UserType</th>
               <th scope="col">UserName</th>
            </tr>
          </thead>
          <tbody>
            <%
                List<User> users = (List<User>) session.getAttribute("users");
                for(User u : users){
            %>
              <tr>
                <th scope="row" class="output"><%= u.getId()%></th>
                <td class="output"><%= u.getUserType()%></td>
                <td class="output"><%= u.getUsername()%></td>
              </tr>
            <% } %>
    </div>
  </body>
</html>