<?php
  session_start();
  
  if(isset($_SESSION['autenticado']) && $_SESSION['autenticado'] === 'yes'){
      header('Location: home.php');
  }
?>