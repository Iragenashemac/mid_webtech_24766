<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Fined Books</title>
</head>
<body>
<h2>Fined Books</h2>
<table border="1">
    <tr>
        <th>Book</th>
        <th>Borrowed By</th>
        <th>Due Date</th>
        <th>Fine</th>
    </tr>
    <c:forEach var="finedBook" items="${finedBooks}">
        <tr>
            <td>${finedBook.book.title}</td>
            <td>${finedBook.user.username}</td>
            <td>${finedBook.dueDate}</td>
            <td>${finedBook.fine}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
