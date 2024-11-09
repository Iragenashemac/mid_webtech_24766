<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Registrar Dashboard</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <style>
        body {
            font-family: 'Roboto', sans-serif;
            background-color: #f4f4f4;
        }
        .highlight {
            color: #77aaff;
        }
        .button-blue {
            background: #64b5f6;
            color: #fff;
        }
        .button-blue:hover {
            background: #42a5f5;
        }
        .button-green {
            background: #66bb6a;
            color: #fff;
        }
        .button-green:hover {
            background: #4caf50;
        }
        .button-yellow {
            background: #ffeb3b;
            color: #000;
        }
        .button-yellow:hover {
            background: #fdd835;
        }
        .button-orange {
            background: #ffa726;
            color: #fff;
        }
        .button-orange:hover {
            background: #fb8c00;
        }
        .button-red {
            background: #ef5350;
            color: #fff;
        }
        .button-red:hover {
            background: #e53935;
        }
        .nav-blue a {
            color: #90caf9;
        }
    </style>
</head>
<body>
    <header class="bg-green-700 text-white p-4 flex justify-between items-center">
        <div id="branding">
            <h1 class="text-2xl"><span class="highlight">Library</span> Management</h1>
        </div>
        <nav>
            <ul class="flex space-x-4">
                <li class="nav-blue"><a href="#">Registrar Dashboard</a></li>
                <li><a href="#">Logout</a></li>
            </ul>
        </nav>
    </header>

    <div class="container mx-auto p-4">
        <div class="text-center my-6">
            <h2 class="text-2xl">Registrar Dashboard: (the username)</h2>
        </div>

        <div class="form-container bg-white p-6 rounded-lg shadow-md mb-6">
            <h2 class="text-xl mb-4">View Membership Requests</h2>
            <form action="viewMembershipRequests.jsp" method="post">
                <input type="submit" value="View Requests" class="button-blue w-full p-2 rounded cursor-pointer">
            </form>
        </div>

        <div class="form-container bg-white p-6 rounded-lg shadow-md mb-6">
            <h2 class="text-xl mb-4">View All Books</h2>
            <form action="viewAllBooks.jsp" method="post">
                <input type="submit" value="View Books" class="button-green w-full p-2 rounded cursor-pointer">
            </form>
        </div>

        <div class="form-container bg-white p-6 rounded-lg shadow-md mb-6">
            <h2 class="text-xl mb-4">View All Users</h2>
            <form action="viewAllUsers.jsp" method="post">
                <input type="submit" value="View Users" class="button-yellow w-full p-2 rounded cursor-pointer">
            </form>
        </div>

        <div class="form-container bg-white p-6 rounded-lg shadow-md mb-6">
            <h2 class="text-xl mb-4">View All Borrowed Books</h2>
            <form action="viewAllBorrowedBooks.jsp" method="post">
                <input type="submit" value="View Borrowed Books" class="button-orange w-full p-2 rounded cursor-pointer">
            </form>
        </div>

        <div class="form-container bg-white p-6 rounded-lg shadow-md mb-6">
            <h2 class="text-xl mb-4">View All Fined Books</h2>
            <form action="viewAllFinedBooks.jsp" method="post">
                <input type="submit" value="View Fined Books" class="button-red w-full p-2 rounded cursor-pointer">
            </form>
        </div>
    </div>

    <footer class="bg-green-700 text-white text-center p-4 mt-6">
        <p>Library Management System &copy; 2023</p>
    </footer>
</body>
</html>
