<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Captrac</title>
</head>
<script type="text/javascript">
function showAlert(){
alert("Successfully added the expense");
}

</script>
<body>

	<form action="/submitexpense">
		<label for="fname">Account Id: </label>
 		<input type="text" id="fname" name="accountid"><br><br>
  		<label for="fname">Expense Type: </label>
 		<input type="text" id="fname" name="ExpenseType"><br><br>
  		<label for="lname">Expense amount:</label>
  		<input type="text" id="lname" name="amount"><br><br>
  		<button type="submit" onclick="showAlert()">Add</button>
	</form>
	
		
</body>
</html>