<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Select Membership</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
    <div class="container mx-auto p-4">
        <h2 class="text-2xl mb-4">Select Your Membership</h2>
        <form action="saveMembership.jsp" method="post">
            <label for="membershipType" class="block mb-2">Choose Membership Type:</label>
            <select id="membershipType" name="membershipType" class="w-full p-2 mb-4 border rounded">
                <option value="gold">Gold - 50 Rwf per day, up to 5 books</option>
                <option value="silver">Silver - 30 Rwf per day, up to 3 books</option>
                <option value="striver">Striver - 10 Rwf per day, up to 2 books</option>
            </select>
            <input type="submit" value="Save Membership" class="button-blue w-full p-2 rounded cursor-pointer">
        </form>
    </div>
</body>
</html>
