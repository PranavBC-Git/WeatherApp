<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width , initial-scale=1">
    <div class="img">
       <img src="https://cdna.pcpartpicker.com/static/forever/img/pcpp-logo.svg" alt="logo">
    </div>
	<title>SIGN UP</title>
	<link rel="stylesheet" type="text/css" href="signup.css">
     
     <h1>Registration</h1>
</head>
<body>
<div class="box">
     <form action="signup-check.php" method="post">
     	<h2>SIGN UP</h2>
          <hr>
     	<?php if (isset($_GET['error'])) { ?>
     		<p class="error"><?php echo $_GET['error']; ?></p>
     	<?php } ?>

          <?php if (isset($_GET['success'])) { ?>
               <p class="success"><?php echo $_GET['success']; ?></p>
          <?php } ?>

         
          <?php if (isset($_GET['name'])) { ?>
               <input type="text" name="name" placeholder="Name"
                      value="<?php echo $_GET['name']; ?>"><br>
          <?php }else{ ?>
               <input type="text" name="name" placeholder="Name"><br>
          <?php }?>

         
          <?php if (isset($_GET['uname'])) { ?>
               <input type="text"  name="uname" placeholder="User Name"
                      value="<?php echo $_GET['uname']; ?>"><br>
          <?php }else{ ?>
               <input type="text" 
                      name="uname" 
                      placeholder="User Name"><br>
          <?php }?>

    	
     	<input type="password" 
                 name="password" 
                 placeholder="Password"><br>

          
          <input type="password" 
                 name="re_password" 
                 placeholder="Re_Password"><br>

     	<button type="submit">Sign Up</button>
          <br>
          <a href="login.php" class="ca">Already have an account?</a>
     </form>
 </div>
</body>
</html>