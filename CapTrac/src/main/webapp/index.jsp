<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style>
.btn-group button {
  background-color: #4CAF50; /* Green background */
  border: 1px solid green; /* Green border */
  color: white; /* White text */
  padding: 10px 24px; /* Some padding */
  cursor: pointer; /* Pointer/hand icon */
  float: left; /* Float the buttons side by side */
}

.btn-group button:not(:last-child) {
  border-right: none; /* Prevent double borders */
}

/* Clear floats (clearfix hack) */
.btn-group:after {
  content: "";
  clear: both;
  display: table;
}

/* Add a background color on hover */
.btn-group button:hover {
  background-color: #3e8e41;
}
</style>
<head>
<meta charset="ISO-8859-1">
<title>Captrac</title>
</head>
<body>

	<div class="btn-group">
  		<button type="submit" formaction="/addexpense">Add expense</button>
  		<button type="submit" formaction="/schedulesalary">Schedule Salary</button>
  		<button type="submit" formaction="/deleteexpense">Delete Expense</button>
	</div>
	
</body>
</html>