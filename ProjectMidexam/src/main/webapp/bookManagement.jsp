<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Manage Books</title>
</head>
<body>
    <h1>Manage Books</h1>
    <form action="BookManagementServlet" method="post">
        <input type="hidden" name="action" value="add">
        <!-- Form fields for Book details like title, author, etc. -->
        <button type="submit">Add Book</button>
    </form>
</body>
</html>
