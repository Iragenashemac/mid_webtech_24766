<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Membership Requests</title>
</head>
<body>
<h2>Pending Membership Requests</h2>
<table border="1">
    <tr>
        <th>User</th>
        <th>Membership Type</th>
        <th>Status</th>
    </tr>
    <c:forEach var="membership" items="${pendingRequests}">
        <tr>
            <td>${membership.user.username}</td>
            <td>${membership.type}</td>
            <td>${membership.status}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
