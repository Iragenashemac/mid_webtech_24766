<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Librarian Dashboard</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
    <script src="https://cdn.tailwindcss.com"></script>
    <style>
        body {
            font-family: 'Roboto', sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 80%;
            margin: auto;
            overflow: hidden;
        }
        header {
            background: #2e8b57; /* Sea green color */
            color: #fff;
            padding-top: 30px;
            min-height: 70px;
            border-bottom: #77aaff 3px solid;
        }
        header a {
            color: #fff;
            text-decoration: none;
            text-transform: uppercase;
            font-size: 16px;
        }
        header ul {
            padding: 0;
            list-style: none;
        }
        header li {
            float: left;
            display: inline;
            padding: 0 20px 0 20px;
        }
        header #branding {
            float: left;
        }
        header #branding h1 {
            margin: 0;
        }
        header nav {
            float: right;
            margin-top: 10px;
        }
        header .highlight, header .current a {
            color: #77aaff;
            font-weight: bold;
        }
        header a:hover {
            color: #77aaff;
            font-weight: bold;
        }
        .button_1 {
            height: 38px;
            background: #77aaff;
            border: 0;
            padding-left: 20px;
            padding-right: 20px;
            color: #fff;
            margin-right: 10px;
            border-radius: 5px;
        }
        .button_1:hover {
            background: #0056b3;
        }
        .form-container {
            background: #fff;
            padding: 20px;
            margin: 20px 0;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        .form-container h2 {
            margin-bottom: 20px;
        }
        .form-container label {
            display: block;
            margin-bottom: 5px;
        }
        .form-container input[type="text"],
        .form-container input[type="password"],
        .form-container select {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .form-container input[type="submit"] {
            background: #77aaff;
            color: #fff;
            border: 0;
            padding: 10px;
            cursor: pointer;
            border-radius: 5px;
        }
        .form-container input[type="submit"]:hover {
            background: #0056b3;
        }
        .book-list, .member-list, .fine-list {
            margin-top: 20px;
        }
        .book-list h3, .member-list h3, .fine-list h3 {
            margin-bottom: 10px;
        }
        .book-list ul, .member-list ul, .fine-list ul {
            list-style: none;
            padding: 0;
        }
        .book-list ul li, .member-list ul li, .fine-list ul li {
            background: #fff;
            margin-bottom: 10px;
            padding: 10px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        footer {
            padding: 20px;
            margin-top: 20px;
            color: #fff;
            background-color: #2e8b57; /* Sea green color */
            text-align: center;
        }
        .librarian-banner {
            background: #2e8b57; /* Sea green color */
            color: #fff;
            text-align: center;
            padding: 20px 0;
            margin-bottom: 20px;
            font-size: 24px;
            font-weight: bold;
        }
        .search-container {
            background: #fff;
            padding: 20px;
            margin: 20px 0;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        .search-container h2 {
            margin-bottom: 20px;
        }
        .search-container label {
            display: block;
            margin-bottom: 5px;
        }
        .search-container input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .search-container input[type="submit"] {
            background: #77aaff;
            color: #fff;
            border: 0;
            padding: 10px;
            cursor: pointer;
            border-radius: 5px;
        }
        .search-container input[type="submit"]:hover {
            background: #0056b3;
        }
        .links-container {
            margin-top: 20px;
            text-align: center;
        }
        .links-container a {
            margin: 0 10px;
            color: #fff;
            text-decoration: none;
            font-weight: bold;
            padding: 10px 20px;
            border-radius: 5px;
        }
        .links-container a.borrowed-books {
            background: #ff6347; /* Tomato color */
        }
        .links-container a.approved-members {
            background: #4682b4; /* Steel blue color */
        }
        .links-container a.fined-members {
            background: #ff4500; /* Orange red color */
        }
        .links-container a.available-books {
            background: #32cd32; /* Lime green color */
        }
        /* New link for Approval Requests */
        .links-container a.approval-requests {
            background: #ffd700; /* Yellow color */
        }
        .links-container a:hover {
            opacity: 0.8;
        }
    </style>
</head>
<body>

<header>
    <div class="container">
        <div id="branding">
            <h1><span class="highlight">Library</span> Management</h1>
        </div>
        <nav>
            <ul>
                <li class="current"><a href="#">Dashboard</a></li>
                <li><a href="logout.jsp">Logout</a></li>
            </ul>
        </nav>
    </div>
</header>

<div class="librarian-banner">
    Librarian Dashboard
</div>

<div class="container">
    <div class="search-container">
        <h2>Search User Location</h2>
        <form action="searchLocation.jsp" method="post">
            <label for="phoneNumber">Phone Number:</label>
            <input type="text" id="phoneNumber" name="phoneNumber" required>
            <input type="submit" value="Search">
        </form>
        <div id="locationResult">
            <!-- Display location result here -->
        </div>
    </div>

    <div class="links-container">
        <a href="borrowedBooks.jsp" class="borrowed-books">Borrowed Books</a>
        <a href="approvedMembers.jsp" class="approved-members">Approved Members</a>
        <a href="finedMembers.jsp" class="fined-members">Fined Members</a>
        <a href="availableBooks.jsp" class="available-books">Available Books</a>
        <!-- New link for approval requests -->
        <a href="approvalRequests.jsp" class="approval-requests">Approval Requests</a>
    </div>

    <div class="form-container">
        <h2>Assign Book to Shelf</h2>
        <form action="assignBookToShelf.jsp" method="post">
            <label for="bookId">Book ID:</label>
            <input type="text" id="bookId" name="bookId" required>
            <label for="shelfId">Shelf ID:</label>
            <input type="text" id="shelfId" name="shelfId" required>
            <input type="submit" value="Assign">
        </form>
    </div>

    <div class="form-container">
        <h2>Assign Shelf to Room</h2>
        <form action="assignShelfToRoom.jsp" method="post">
            <label for="shelfId">Shelf ID:</label>
            <input type="text" id="shelfId" name="shelfId" required>
            <label for="roomId">Room ID:</label>
            <input type="text" id="roomId" name="roomId" required>
            <input type="submit" value="Assign">
        </form>
    </div>
</div>

<footer>
    <p>Library Management System &copy; 2024</p>
</footer>

</body>
</html>
