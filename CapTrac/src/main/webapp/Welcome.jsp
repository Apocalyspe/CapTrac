<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<link rel="stylesheet" type="text/css" href="/css/mystyle.css" media="screen"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<meta charset="ISO-8859-1">
<title>CapTrac</title>
<script src="/js/script.js"></script>
<body>


 <div class="btn-group">
 
    	<h2 align="Left">${greeting} ${name}</h2>
    	
    	<div align="right">
    		<form action="/logout" align="right"><input type= "submit" value="Logout"></form>
    	</div>
    	
    	<div class="balance-update">
    		
	 		<button type="submit" id="addexpense_button" onclick="addexpense_div()">Add expense</button>
  			<button type="submit" id="schedule_button" onclick="schedule_div()">Schedule Salary</button>
      		<button type="submit" id="delete_button" onclick="delete_div()">View Expense</button>
      		
  		</div>

 	 	<div  class="addexpense" id="addexpense_div">
 	 	
        	<form action="/addexpense">
            	<label>Expense-Type: </label>	<input type="text" name="ExpenseType"><br><br>
            	<label>Amount: </label>			<input type="text" name="amount"><br><br>
            	<label>Date: </label>			<input type = "datetime-local" name= "timestamp" pattern = "yyyy-MM-dd HH:mm:ss"><br><br>
            	<label>Remark: </label>			<input type="text" name="Remark"><br><br>
            	<input type="submit" name="expense" value="Add Expense"> 
            	${ message }
        	</form>
        	
  		</div>
    
    	<div id="schedule_div">
    
      		<form action="/schedule">
      		
        		<label>Schedule: </label>
        		
          		  <select name="Expense_type" id="expense_type">
          			<option value="Credit">Credit</option>
           			<option value="Debit">Debit</option>
          		  </select><br><br>
          		  
        		<label>Action: </label>
        		
          		  <select name="option" id="options">
            		<option value="Daily">Daily</option>
            		<option value="weekly">Weekly</option>
            		<option value="Monthly">Monthly</option>
           		  </select><br><br>
           		
        		<label>Amount: </label>			<input type="text" name="amount"><br><br>
        		
       			<input type="submit" name="expense" value="Add Expense">
       			 
      		</form>
      
    	</div>

    	<div id="delete_div">
      		<form action="/viewexpenses"><br>
        		<h5>View you Transaction history</h5>
        		<label>From: </label><input type="date" name="date">&nbsp;&nbsp;&nbsp;&nbsp;<label>To: </label><input type="date" name="date"><br><br>
        		<h5>Recent transactions</h5>
        			<ul align="left">
          				<li>Adele</li>
          				<li>{}<span class="close"></span></li>
          				<li>{}<span class="close"></span></li>
         				<li>{}<span class="close"></span></li>
          				<li>{}<span class="close"></span></li>
          				<li>{}<span class="close"></span></li>
          				<li>{}</li>
        			</ul>
		    </form>
    	</div>

  </div>
	
</body>
</html>