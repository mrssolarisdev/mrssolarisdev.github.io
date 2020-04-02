<?php
	session_start();
	if(!isset($_SESSION['autenticado']) || $_SESSION['autenticado'] === 'no'){
	  header('Location: index.php?error=login_unauthorized');
	}
?>

<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!--Favicon-->
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
    <meta http-equiv="Pragma" content="no-cache" />
    <meta http-equiv="Expires" content="0" />
     <title>Bomba dagua</title>
     
     <script type="module" src="server_connection.js">
     </script>
     
     <link rel="stylesheet" type="text/css" href="style.css">
  </head>

  <body>
    <header id="header">
      <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
          <a href="" class="text-secondary navbar-brand text-light">Home</a>
          <ul class="navbar-nav ml-auto">
              <li class="nav-item"><a class="nav-link">Bem vindo <?php $_SESSION['username'] ?></a></li>
              <li class="nav-item"><a class="nav-link" href="logout.php">Logout</a></li>
          </ul>
      </nav>
    </header>
    
    <div id="content">
      <h2 class="lead" style="font-size:2.25rem; color: var(--purple);">Quantidade de água</h2>
      <div id="box-data">
        <span class="lead pos">Caixa d'água:</span>
        <span class="box-1">1</span>
        <input type="radio" name="box">
        <span class="box-2">2</span>
        <input type="radio" name="box">
      </div>

      <section class="row">
        <section id="bomba" class="col-12 col-md-6 sect-1 mr-3">
          <section id="rule">
            <div class="trace">
              <div class="cm"></div>
              <div class="cm"><span class="title">100L</span></div>
              <div class="cm"><span class="title">80L</span></div>
              <div class="cm"><span class="title">60L</span></div>
              <div class="cm"><span class="title">40L</span></div>
            </div>
          </section>
          <div id="water-box">
            <div id="water"><!--Para alterar o nivel da agua é só aumentar o top desse elemento
                            a água é empurrada pra baixo e como a classe pai tem overflow hidden
                            não é possivel ver a div escapando-->
              <div id="waves">
                <div id="wave" class="wave1"></div>
                <div id="wave" class="wave2"></div>      
                <div id="wave" class="wave3"></div>
              </div>  
              <div id="water-lvl"></div>
            </div>
          </div>
        </section>


        <section class="col-12 col-md-5 ml-5">
          <h2 class="lead" style="font-size:2.25rem; color: var(--purple);">Estado da bomba</h2>
          <section class="sect-1 mb-5 p-4">
            <span>Status:</span><input type="checkbox" name="" id="btn-bomba">
            <span id="result" style="position: relative;left: 35px;">Desligada</span>
            <div class="pt-3">
              <span>Litros por segundo:</span>
              <span style="color: #42a6ff;
              font-size: 20px;
              font-weight: 600;">2</input>
              <span style="font-weight:lighter;">L/s</span>
            </div>
          </section>

          <h2 class="lead" style="font-size:2.25rem; color: var(--purple);">Capacidade</h2>
          <section class="sect-1 p-5">
            <div class="percent">
              <svg>
                <circle cx="80" cy="80" r="80"></circle>
              </svg>
              <div class="number">
                <h2>90<span class="color">%</span></h2>
                
              </div>
            </div>
          </section>
        </section>

      </section>
      
      <script type="text/javascript" defer>
        let status = document.querySelectorAll('input')[2];
        console.log(status);
        let span = document.getElementById('result');
        status.addEventListener('change', 
        () => {
          if(status.checked)
           span.innerHTML = `Ligada`;
          else
            span.innerHTML = `Desligada`;
        });
     </script>
      
 
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  </body>
</html>