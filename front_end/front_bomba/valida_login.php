<?php
    session_start();
    try{
        require_once('bd.php');

        $email = $_POST['emailLogin'];
        $key = $_POST['passwordLogin'];
        $auth = false;

        if(isset($_POST['emailLogin']) && isset($_POST['passwordLogin'])){
            if($pdo->query("SELECT count(*) FROM tabela WHERE Email = '$email' AND Senha = '$key'")->fetchColumn() > 0){
                #Seleciona o nome onde o email e a senha forem iguais aos pegos por post
                //logica pdo
            }
            else {
                $auth = false;
            }
        }
        else {
           header('Location: cadastro.php?error=empty_form');
        } 

        if($auth){
            $_SESSION['autenticado'] = 'yes';
            //dados
            header('Location: home.php');
        }
        else {
            $_SESSION['autenticado'] = 'no';
            header('Location: cadastro.php?error=error_auth');
        }

    }
    catch(PDOException $err){
       header('Location: cadastro.php?error=login_fatal');
    }
       