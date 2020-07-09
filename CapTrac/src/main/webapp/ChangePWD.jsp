<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Password</title>
</head>
<script>
    function display(){
        
        document.getElementById('demo').innerHTML="Email-id verified";
        
        document.getElementById("demo2").innerHTML = "<label>Type New Password:  </label><input type='text' name='newpwd'>";
        document.getElementById("demo4").innerHTML = "<label>Re-Type Password:    </label><input type='text'>";
        document.getElementById("demo3").innerHTML = "<input type='submit' id='submit' value='Change Password' onclick='myform()'>";
        document.getElementById("demo5").innerHTML = " ";
        //else{
        //document.getElementById('demo').innerHTML="Incorrect Email-id";
        //}
    }

    function myform(){
        document.getElementById("submit").action = '/changepass';
    }

</script>
<body>
	<h2>Provide your details</h2>
    <div>
        <form id="myform">
            <label>Registered email-id:  </label><input type="text" name="email">&nbsp;&nbsp;&nbsp;&nbsp;<p2 id="demo5"><input type="submit" value="Verify" onclick="display()"></p2>
            <p2 id="demo"></p2><br><br>
            <p2 id="demo2"></p2><br><br>
            <p2 id="demo4"></p2><br><br>
            <p2 id="demo3"></p2>
        </form>
    </div>
</body>

</html>