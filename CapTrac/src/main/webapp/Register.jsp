<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
 </head>
    <body>
    <h2>
           Sign up 
     </h2>
        <div class="regform">
            <form action="/Register.jsp">
                <label>     Username:      </label><input type="text" name="username"></input><br><br>
                <label>Type your password: </label><input type="text" name="password"><br><br>
                <label>Retype the password:</label><input type="text" name="password"><br><br>
                <label>Provide Email-Id:   </label><input type="text" name="email"><br><br>
                <input type="submit" value="Sign up">
            </form>
        </div>
    </body>
</html>