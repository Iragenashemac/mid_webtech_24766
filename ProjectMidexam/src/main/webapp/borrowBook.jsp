<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Borrow Book</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
    <div class="container mx-auto p-4">
        <h2 class="text-2xl mb-4">Borrow Book</h2>
        <form action="borrowBookAction.jsp" method="post">
            <label for="bookId" class="block mb-2">Enter Book ID:</label>
            <input type="text" id="bookId" name="bookId" class="w-full p-2 mb-4 border rounded" required>
            <input type="submit" value="Borrow Book" class="button-blue w-full p-2 rounded cursor-pointer">
        </form>
    </div>
</body>
</html>
