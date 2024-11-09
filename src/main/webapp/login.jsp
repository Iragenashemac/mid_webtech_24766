<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="style.css"> <!-- Link to your CSS file -->
</head>
<body>
    <div class="container">
        <h2>Login</h2>
        <form action="login" method="post"> <!-- The form action is now "login" -->
            <div class="form-group">
                <label for="phone">Phone Number:</label>
                <input type="text" id="phone" name="phoneNumber" required>
            </div>

            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>
            </div>

            <button type="submit">Login</button>
        </form>
        <p>Don't have an account? <a href="signup">Create an account</a></p> <!-- Changed to use "signup" -->
    </div>
    
    <% String error = request.getParameter("error"); %>
    <% if (error != null) { %>
        <p style="color:red;"><%= error %></p>
    <% } %>
</body>
</html>
