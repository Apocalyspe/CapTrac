<!DOCTYPE html>
<html>
<title>Change Password</title>
<head>
   <h2>Provide your details</h2>
</head>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<body>
    <div>
        <form id="myform" name="myform" action = "/checkuser">
            <label>Registered Mobile:  </label><input type="text" name="userID">&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="submit" id="btn" value="Verify">
            <br><br>${ message }<br><br>
		 </form>
            ${ code }
        	${changeMessage }      
    	<script>

			$('#myform').onclick(function( event ){
				$( "#myform" ).hide();
				event.preventDefault();
			});
		</script>  
    </div>
</body>

</html>