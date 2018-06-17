<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE>
<html>
<head>
    <title>Art of Universe</title>
    <link rel="stylesheet" href="../static/global.css">
</head>
<body class="main-body">
<h1>The Art Of Universe</h1>
<div class="log-in">
    <form:form action="${pageContext.request.contextPath}/authenticate-user" method="post">
        <div class="container">
            <h1>Sign In</h1>

            <label for="email"><b>User name</b></label>
            <input id="email" type="text" placeholder="Enter Name" name="username" required>

            <label for="psw"><b>Password</b></label>
            <input id="psw" type="password" placeholder="Enter Password" name="password" required>

            <div>
                <button type="submit" class="signupbtn">Sign In</button>
            </div>
        </div>
    </form:form>
</div>
</body>
</html>