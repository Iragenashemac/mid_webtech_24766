<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>All Books</title></head>
<body>
<h2>Library Books</h2>
<table border="1">
    <tr>
        <th>Book ID</th>
        <th>Title</th>
        <th>Author</th>
        <th>ISBN</th>
    </tr>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.bookId}</td>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.isbn}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
