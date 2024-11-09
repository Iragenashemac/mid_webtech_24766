<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Borrowed Books</title>
</head>
<body>
<h2>Borrowed Books</h2>
<table border="1">
    <tr>
        <th>Book</th>
        <th>Borrowed By</th>
        <th>Due Date</th>
    </tr>
    <c:forEach var="borrowedBook" items="${borrowedBooks}">
        <tr>
            <td>${borrowedBook.book.title}</td>
            <td>${borrowedBook.user.username}</td>
            <td>${borrowedBook.dueDate}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
