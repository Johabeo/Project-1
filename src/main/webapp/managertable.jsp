<%@ page import="java.util.*"%>
<%@ page import="com.dto.Ticket"%>

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
        <a href="logout" class="output btn">Logout</a>
        <form method="post" action="view" style="inline">
          <input type="number" name="employeeId" placeholder="Enter Employee ID" />
          <input type="text" name="status" placeholder="Enter Status"/>
          <input type="submit" class="output btn" value="Search" />
        </form>
        <table class="table">
          <thead>
            <tr>
              <th scope="col">id</th>
              <th scope="col">Expense</th>
              <th scope="col">EmployeeId</th>
              <th scope="col">UserName</th>
              <th scope="col">Reason</th>
              <th scope="col">Status</th>
            </tr>
          </thead>
          <tbody>
            <%
                List<Ticket> tickets = (List<Ticket>) session.getAttribute("tickets");
                for(Ticket t : tickets){
            %>
              <tr>
                <th scope="row" class="output"><%= t.getId()%></th>
                <td class="output"><%= t.getExpense()%></td>
                <td class="output"><%= t.getEmployeeId()%></td>
                <td class="output"><%= t.getEmployeeName()%></td>
                <td class="output"><%= t.getReason()%></td>
                <td class="output"><%= t.getStatus().toUpperCase()%>
                <% if (t.getStatus().equalsIgnoreCase("pending")) { %>
                <form method="post" action="approve" style="display:inline">
                  <input type="hidden" name="ticketId" value=<%= t.getId()%> />
                  <input type="submit" class="output btn btn-success" value="Approve" />
                </form>
                <form method="post" action="deny" class="output" style="display:inline">
                  <input type="hidden" name="ticketId" value=<%= t.getId()%> />
                  <input type="submit" class="output btn btn-danger" value="Deny" />
                </form>
                <% } %>
                </td>
              </tr>
            <% } %>
    </div>
  </body>
</html>