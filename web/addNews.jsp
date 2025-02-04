<%@ page import="database.NewsCategories" %>
<%@ page import="java.util.List" %>
<%@ page import="database.DBConnector" %><%--
  Created by IntelliJ IDEA.
  User: Farabi
  Date: 25/01/2025
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>

<div class="container">

    <form class="form-control" action="/addNews" method="post">

        <label class="form-label">Title:</label>
        <input class="form-control" type="text" name="title" placeholder="Enter Title">

        <label class="form-label">Content</label>
        <input class="form-control" type="text" name="content" placeholder="Enter Content">

        <%
            List<NewsCategories> categories = (List<NewsCategories>) request.getAttribute("categories");
            if(categories!= null && !categories.isEmpty()){
                for(NewsCategories cat: categories){



        %>


        <select class="form-control">
            <option value="<%=cat.getId()%>" > <%=cat.getName()%> </option>

        </select>

        <%
                }
            }
        %>
        <button type="submit">Login</button>

    </form>

</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
