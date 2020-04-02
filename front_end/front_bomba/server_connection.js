function attBody(obj){
    let converted = JSON.parse(obj);
    let bomba = document.getElementById("estado");
    let cx = document.getElementById("caixa");
    bomba.innerHTML = "Estado:"+converted.estado+"-"+"Litros:"+converted.litros;
    cx.style.height = converted.litros+"px";
}
 

try{
    let connection = new WebSocket('ws://localhost:6790');
    let messageCounter = 0;

    connection.onopen = function (event) {
        connection.send(`Conexão com o servidor bem sucedida.`); // Manda mensagem ao efetuar a conexão.
        console.log(`Conectado com: ${connection.url}.`);
    };
    // Log errors
    connection.onerror = function (event) {
      console.log(`Erro ${event}!`);
    };

    // Log messages from the server
    connection.onmessage = function (e) {
        console.log(`Message from server: ${e.data}`);//Mostra os dados recebidos do servidor.
        messageCounter++;
        connection.send(`Confirmação de recepção de dados da bomba dagua n° ${messageCounter}.`);
        //A cada mensagem recebida do servidor, manda a confirmação de que os dados foram realmente recebidos.
        attBody(e.data);
    };

    connection.onclose = function (){
      console.log(`Conexão encerrada.`);
      //document.write("Falha de conexão");
    }
    function click(){
      connection.close();
    }
 }
 catch(error){
   console.error(`Falha de conexão.`);
 }
 