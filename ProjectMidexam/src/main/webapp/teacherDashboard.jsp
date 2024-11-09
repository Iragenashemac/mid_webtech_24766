<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Teacher Dashboard</title>
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
                <li class="nav-blue"><a href="#">Teacher Dashboard</a></li>
                <li><a href="#">Logout</a></li>
            </ul>
        </nav>
    </header>

    <div class="container mx-auto p-4">
        <div class="text-center my-6">
            <h2 class="text-2xl">Teacher Dashboard: ${username}</h2> <!-- Dynamic Username Display -->
        </div>

        <div class="flex justify-center space-x-4 mb-6">
            <button class="button-blue p-2 rounded">Membership</button>
            <button class="button-green p-2 rounded">Available Books</button>
            <button class="button-yellow p-2 rounded">My Books</button>
        </div>

        <div class="form-container bg-white p-6 rounded-lg shadow-md mb-6">
            <h2 class="text-xl mb-4">Select Membership</h2>
            <form action="selectMembership.jsp" method="post">
                <label for="membership" class="block mb-2">Choose Membership:</label>
                <select id="membership" name="membership" class="w-full p-2 mb-4 border rounded">
                    <option value="gold">Gold - 50 Rwf per day, up to 5 books</option>
                    <option value="silver">Silver - 30 Rwf per day, up to 3 books</option>
                    <option value="striver">Striver - 10 Rwf per day, up to 2 books</option>
                </select>
                <input type="submit" value="Select Membership" class="button-blue w-full p-2 rounded cursor-pointer">
            </form>
        </div>

        <div class="form-container bg-white p-6 rounded-lg shadow-md mb-6">
            <h2 class="text-xl mb-4">Borrow a Book</h2>
            <form action="borrowBook.jsp" method="post">
                <label for="bookId" class="block mb-2">Book ID:</label>
                <input type="text" id="bookId" name="bookId" required class="w-full p-2 mb-4 border rounded">
                <input type="submit" value="Borrow Book" class="button-blue w-full p-2 rounded cursor-pointer">
            </form>
        </div>

        <div class="borrowed-books bg-white p-6 rounded-lg shadow-md">
            <h3 class="text-2xl mb-4 text-green-700">My Borrowed Books</h3>
            <ul>
                <li class="bg-gray-100 p-4 mb-4 rounded shadow">
                    <strong>Book ID:</strong> 12345
                    <span><strong>Title:</strong> Introduction to Java</span>
                    <span><strong>Borrow Date:</strong> 2023-10-01</span>
                    <span><strong>Due Date:</strong> 2023-10-15</span>
                    <span><strong>Fine:</strong> 0 Rwf</span>
                </li>
                <li class="bg-gray-100 p-4 mb-4 rounded shadow">
                    <strong>Book ID:</strong> 67890
                    <span><strong>Title:</strong> Advanced CSS Techniques</span>
                    <span><strong>Borrow Date:</strong> 2023-10-05</span>
                    <span><strong>Due Date:</strong> 2023-10-19</span>
                    <span><strong>Fine:</strong> 0 Rwf</span>
                </li>
                <li class="bg-gray-100 p-4 mb-4 rounded shadow">
                    <strong>Book ID:</strong> 11223
                    <span><strong>Title:</strong> Database Management Systems</span>
                    <span><strong>Borrow Date:</strong> 2023-10-10</span>
                    <span><strong>Due Date:</strong> 2023-10-24</span>
                    <span><strong>Fine:</strong> 0 Rwf</span>
                </li>
            </ul>
        </div>
    </div>

    <footer class="bg-green-700 text-white text-center p-4 mt-6">
        <p>Library Management System &copy; 2023</p>
    </footer>
</body>
</html>
