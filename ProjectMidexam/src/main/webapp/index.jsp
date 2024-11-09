<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>AUCA Library Management System</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&amp;display=swap" rel="stylesheet"/>
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
        #showcase {
            min-height: 400px;
            background: url('https://placehold.co/1200x400') no-repeat 0 -400px;
            text-align: center;
            color: #fff;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
        }
        #showcase h1 {
            margin-top: 100px;
            font-size: 55px;
            margin-bottom: 10px;
            color: #2e8b57; /* Sea green color */
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5); /* Adding shadow for better visibility */
        }
        #showcase p {
            font-size: 20px;
            color: #2e8b57; /* Sea green color */
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5); /* Adding shadow for better visibility */
        }
        .button_1 {
            height: 38px;
            background: #77aaff;
            border: 0;
            padding-left: 20px;
            padding-right: 20px;
            color: #fff;
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
        .form-container input[type="password"] {
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
        .book-gallery {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-around;
            margin-top: 20px;
        }
        .book-item {
            background: #fff;
            padding: 10px;
            margin: 10px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            text-align: center;
            width: 30%;
        }
        .book-item img {
            max-width: 100%;
            border-radius: 5px;
        }
        .book-item h3 {
            margin: 10px 0;
        }
        footer {
            padding: 20px;
            margin-top: 20px;
            color: #fff;
            background-color: #2e8b57; /* Sea green color */
            text-align: center;
        }
    </style>
</head>
<body>
    <header>
        <div class="container">
            <div id="branding">
                <h1>
                    <span class="highlight">
                        Library
                    </span>
                    Management
                </h1>
            </div>
            <nav>
                <ul>
                    <li class="current">
                        <a href="#">
                            Home
                        </a>
                    </li>
                    <li>
                        <a href="login.jsp">
                            Sign In
                        </a>
                    </li>
                    <li>
                        <a href="signup.jsp">
                            Register
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
    </header>
    <section id="showcase">
        <div class="container">
            <h1>
                Welcome to the Library
            </h1>
            <p>
                Manage your book borrowing and membership with ease.
            </p>
        </div>
    </section>
    <div class="container">
        <div class="book-gallery">
            <div class="book-item">
                <img alt="Cover of the book 'Introduction to Java' with a blue background and Java logo" height="300" src="https://storage.googleapis.com/a1aa/image/PB3pvpDpdmpgMZFfH7EHIaklrYoea3PaGufnQWWP15T89leOB.jpg" width="200"/>
                <h3>
                    Introduction to Java
                </h3>
                <p>
                    Learn the basics of Java programming with this comprehensive guide.
                </p>
            </div>
            <div class="book-item">
                <img alt="Cover of the book 'Advanced CSS Techniques' with a stylish design and CSS logo" height="300" src="https://storage.googleapis.com/a1aa/image/NySMDVWYsyqxFRo5acLgmg6meRiarPFwEQVkDrJMfia5eleOB.jpg" width="200"/>
                <h3>
                    Advanced CSS Techniques
                </h3>
                <p>
                    Master the art of CSS with advanced techniques and tips.
                </p>
            </div>
            <div class="book-item">
                <img alt="Cover of the book 'Database Management Systems' with a database icon and modern design" height="300" src="https://storage.googleapis.com/a1aa/image/QgrwkOc2VSZJC1dQjNYvX3V2eVeKbpOzRpNNxeNwoxv49leOB.jpg" width="200"/>
                <h3>
                    Database Management Systems
                </h3>
                <p>
                    Understand the fundamentals of database management systems.
                </p>
            </div>
            <div class="book-item">
                <img alt="Cover of the book 'Python Programming' with a python logo and green background" height="300" src="https://storage.googleapis.com/a1aa/image/DQwQ8Fka22KwH93flyt1KGknkLiatywJPPbOMIqXgnkgfSvTA.jpg" width="200"/>
                <h3>
                    Python Programming
                </h3>
                <p>
                    Get started with Python programming with this beginner-friendly book.
                </p>
            </div>
            <div class="book-item">
                <img alt="Cover of the book 'Web Development with JavaScript' with a JavaScript logo and web design elements" height="300" src="https://storage.googleapis.com/a1aa/image/tyJFCpXdauosBFE3HDEYgqXwQYsjeVWUginh11ynEvMcfSvTA.jpg" width="200"/>
                <h3>
                    Web Development with JavaScript
                </h3>
                <p>
                    Learn how to build dynamic websites using JavaScript.
                </p>
            </div>
            <div class="book-item">
                <img alt="Cover of the book 'Machine Learning Basics' with a robot icon and tech design" height="300" src="https://storage.googleapis.com/a1aa/image/fVXjkaAwJ3DTueHTbgbh0hoS8XhwsdK2bAdEwmFZrBXntSp9Q.jpg" width="200"/>
                <h3>
                    Machine Learning Basics
                </h3>
                <p>
                    Understand the basics of machine learning and its applications.
                </p>
            </div>
        </div>
    </div>
    <footer>
        <p>
            AUCA Library Management System &copy; 2024
        </p>
    </footer>
</body>
</html>
