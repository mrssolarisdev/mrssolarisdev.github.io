<?php

require_once('redir_home_auth_index.php');
?>

<html>
  <head>
    <meta charset="utf-8" />
    <title>App Help Desk</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script type="module">
      
    </script>
    <style>
      .card-login {
        padding: 30px 0 0 0;
        width: 350px;
        margin: 0 auto;
      }
      .error{
        font-weight: bold; 
        margin: 8px;
      }
      input{
        caret-color:orange;
      }
    </style>
  </head>

  <body>

    <nav class="navbar navbar-dark bg-dark">
      <a class="navbar-brand" href="#">
        
      </a>
      
    </nav>

    <div class="container">    
      <div class="row">

        <div class="card-login">
          <div class="card">
            <div class="card-header">
              Login
            </div>
            <div class="card-body">
              <form action="valida_login.php"  method="post">
                <div class="form-group">
                  <input type="email" class="form-control" placeholder="E-mail" name="email" required>

                </div>
                <div class="form-group">
                  <input type="password" class="form-control" placeholder="Senha" name="password" required>
                </div>

                <?php
                if(isset($_GET['error']) && $_GET['error'] === 'error_auth'){
                
                ?>
                 <script type="text/javascript">
                    let email = document.getElementsByTagName('input')[0];
                    let key = document.getElementsByTagName('input')[1];

                    email.classList.add('is-invalid');
                    key.classList.add('is-invalid');
                  </script>
                  <div class="text-danger error"> Usuário ou senha inválidos</div>
                <?
                  }
                ?>

                <?php
                if(isset($_GET['error']) && $_GET['error'] === 'empty_form'){
                
                ?>
                  <div class="text-danger error"> Faça login para continuar</div>

                <?
                  }
                ?>
                <?php
                if(isset($_GET['error']) && $_GET['error'] === 'login_fatal'){
                
                ?>
                  <div class="text-danger error">Erro. Tente novamente mais tarde</div>

                <?
                  }
                ?>
                <button class="btn btn-lg btn-info btn-block" type="submit">Entrar</button>
              </form>
              <div id=""><a href="password_recovery.php">Esqueci a senha</a></div>
            </div>
          </div>
        </div>
    </div>
  </body>
  </html>