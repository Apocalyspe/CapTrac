<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<title>Login</title>
<head>
<meta charset="ISO-8859-1">
</head>
<script>

</script>
<body>


<h2>Login to continue</h2> <p><a href="/Register.jsp">sign up</a></p>
    <div>
        <form action="/login">
            <label>Mob. Number: </label><input type="text" name="userID"><br><br>
            <label>Password: </label><input type="text" name="password"><br><br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="submit" name="login" value="Login"> <a href="/ChangePWD.jsp">Forgot Password</a>
            <p> ${message}</p>
        </form>
    </div>
</body>

</html>