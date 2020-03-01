**HTML**

O html = **hypertext markup language **

marca o que é cada parte do texto, indica ao interpretador o que é o que
o que é o video, uma div etc.


**LISTAS**

```<ol> Ordened List- - Lista ordenada- numeros
<ul> Unordened List - Lista nao ordenada
<li> List item - Item da lista
 ul type : circle, disc, square
 ol type : 1, A, a, I e i(algarismos romanos)
 ```


**TABELAS**
 
 ```<table>``` tabela TODAS DEVEM COMEÇAR ASSIM  
 

 ```<tr>``` table row - linha da tabela  
 
 ```<td>``` table data  - itens da tabela  
 
 ```<th>``` table header - cabeçalho da tabela  
 
 ```<td colspan="2"``` - column spansion - expansão da coluna nesse caso
 uma coluna ocupa o espaço de 2  
 
 ```<td rowspan="2"``` - row spansion - expansão da linha, nesse
 caso uma linha ocupa o espaço de duas  
 
 ```<thead>``` Header da tabela, geralmente engloba uma ```<tr>``` que tem elementos ```<th>``` dentro, serve pra agrupar os elementos do cabeçalho da tabela.  
 
 ```<tbody>``` Corpo da tabela, engloba tudo que forem dados que não fazem parte do header da tabela, agrupa trs que tem tds.
 Mais do que isso, ele tem uma barra de scroll, que só aparece nele(no thead nao). É bom pra impressão, pois, se eu fosse
 imprimir uma tabela, o header da tabela apareceria em cada folha, se não tivesse esse atributo, desse modo aparece só 
 na primeira.  
 
 ```<tfoot>``` O footer da tabela, do mesmo modo que a theader, só aparece uma vez em impressões.  
 
 atributo scope:
	```<th scope="col">Month</th>```  
  
nesse exemplo, diz que essa th é um table header de uma coluna, poderia ser row, e então seria o header de uma linha.

 
>Comentar html <! -- conteudo -->  

>Comentar css /* conteudo */


**INPUTS**

TIPOS:   

```color```  
```date```  
```search```  
```range```  
```email```  
```url```  
```number(campo que seria campo giratório em java(spinner)```  
```text```  
```password```  
```button```  
```submit```  
```radio```  
```checkbox```  
```file```  

**FORM**

```<form>``` Formulário (INPUTS DEVEM ESTAR DENTRO DE UM FORMULARIO, POIS O BOTÃO DE ENVIAR PARA UM BANCO DE DADOS, PEGA OS DADOS DAS INPUTS QUE ESTÃO DENTRO DESTE FORM, E ENVIA PELA REQUISIÇÃO).

***INPUT PARA TEXTO***
```<input type="text" name="Alguma coisa aqui">```  

***INPUT PARA SENHA***
```<input type="password" name"Nome exibido no browser">```  

***INPUT PARA EMAIL***
```<input type="email" name="nome" placeholder="Insira seu email.." required="">```  


***INPUT PARA NUMERO(SPINNER)***
```<input type="number" name="qtd" id="qtd">```  

O number tem parametros especificos:
	```min="numero"```    
    
    
	``` max="numero" ```  
  
ASSIM A SETA SO DEIXA VOCE IR ATÉ O NUMERO DETERMINADO, SE PASSAR DO ESPECIFICADO A CERTA TRAVA, SE DIGITAR ALGO MAIOR OU MENOR E TENTAR ENVIAR, O BOTÃO NÃO DEIXA.

Tem também o:
	```step="numero"```  

DEFINE DE QUANTO EM QUANTO A QUANTIDADE NA CAIXA CONTARÁ


***INPUT PARA URL***
```<input type="url" name="url" id="url" placeholder="ex: http://www..."```  

[ESSA INPUT SÓ ACEITA URL COM HTTP:// ENTÃO É UTIL DEIXAR ISSO CLARO NO PLACEHOLDER]

***INPUT PARA PESQUISA***
```<input type="search" id="search">```

***INPUT PARA CONTROLE DESLIZANTE***
```<input type="range" id="range">``` 

PARA ELE TAMBEM SE APLICA O MAXIMO E MINIMO:
	```max="numero"```
	```min="numero"```
  
  E UM VALOR NO QUAL ELE JÁ VEM CONFIGURADO:
	```value="numero"```  
  NAO PEGA EM NAVEGADORES DEFASADOS

SE PEDIR PRA RESGATAR O VALUE, ELE RETORNA O VALOR ONDE A BARRA DE SELEÇÃO DO RANGE ESTÁ
TESTE:
```
<!DOCTYPE html>
<html>
<body>

<input type="range" id="ta" min="0" max="5" step="1">
<script type="text/javascript">
	let d = document.getElementById('ta');

	d.addEventListener('change',
    ()=>{
    	console.warn(d.value);
	}
    );


</script>
</body>
</html>

```
Para estilizar a range:

```
input[type=range] {
  -webkit-appearance: none; /* remove estilo padrão do browser */
}

/* estiliza o marcador móvel */

input[type=range]::-webkit-slider-thumb {
  -webkit-appearance: none; /* remove estilo padrão do browser */
  background: red;
  height: 30px;
  border-radius: 50%;
  width: 30px;
}
/* estiliza barra*/

input[type=range]::-webkit-slider-runnable-track {
  width: 100%;
  height: 30px;
  background: blue;
}
```

Como não tem como colocar indicadores do valor pelo html, podemos colocar um norte para o usuario, usando js.

Assim:
```
 <input id="idade" type="range" min="18" max="120" value="18" onchange="mostrarIdade(this.value)" />
 <span id="exibeIdade">18</span>

  function mostrarIdade(novoValor) {
       document.getElementById("exibeIdade").innerHTML = novoValor;
  }
```

****UTILIZA PREFIXOS DE COMPATIBILIDADE MOZ E MS****


***INPUT PARA DATA***
```<input type="date" id="date">```
[---------NAO PEGA EM NAVEGADORES DEFASADOS----------]

***INPUT PARA COR***
```<input type="color" id="color">```
DA PRA DEFINIR A COR NA QUAL ELE VEM AO CARREGAR A PAGINA
```value="corHex"```

***INPUT PARA BOTÃO***
```<input type="button" value="Nome exibido no lugar">``` 

***INPUT PARA ENVIAR UM ARQUIVO PARA UM SERVIDOR***
```<input type="Submit" value="Nome exibido no lugar"> ```

***BOTÕES DE RADIO***
```<input type="radio" name="nome exibido no browser"> value="Nome exibido no lugar">``` 

***BOTÕES DE CHECKBOX***
```<input type="checkbox" name="Nome exibido"> ```

***INPUT PARA ARQUIVO***
```<input type="file" id="arquivo">```






**ATRIBUTOS DAS INPUTS**

```placeholder ``` -> PLACEHOLDER É O TEXTO DENTRO DA INPUT QUE APARECE NO CAMPO  

```value``` -> É exibido como o nome nos botões, campos de texto e também o valor das inputs de entrada de dados enviado depois do processamento.  

```name```-> referencia ao que foi inserido na caixa, aparece no browser nomeando duas inputs do tipo radio, você as agrupa,
fazendo com que só uma possa ser selecionada, no checkbox, mesmo com nomes iguais, você pode selecionar quantas quiser. Também se refere ao indice que a informação da input vai estar quando for enviada através de post ou get nas super globais $_GET e $_POST. 

```id``` -> Identificador único de um elemento.  

```required``` ->Impede que o campo fique vazio ao enviar dados de um form" SE USA ASSIM: required="required" ou: required(sem valores)
ou required=""  

```autofocus```-> diz a caixa que deve aparecer selecionada assim que a pagina carrega, indicando ao usuario por onde ele deve começar.


***CAIXA DE SELEÇÃO(COMBOBOX)***
```<select name="estado"> </select>``` -> Cria uma caixa de seleção

***OPÇÕES DE UMA CAIXA DE SELEÇÃO(COMBOBOX)***
```<option value="Bahia">BA</option>``` -> Cria opções dentro de uma caixa de seleção // Nesse caso, o nome estado irá receber o valor bahia.  


***AREA DE TEXTO***
```<textarea></textarea>```  


***RETIRA A OPCAO DE AUMENTAR A TEXTAREA***
```<textarea style="resize: none"></textarea>```  


>Fieldsets são tags que agrupam dados semelhantes

```<fieldset>
</fieldset>	
```  

>Legend é a legenda do fieldset

```<legend> </legend>```

>Label é a etiqueta, o rotulo de uma input(nome que vem antes)
```<label></label>```  


for: > id que associa um input a uma label(quando voce clica na label ela te leva pro input)
>QUANDO O ID NO FOR TEM O MESMO NOME QUE O DE UMA INPUT, AO CLICAR VOCE É LEVADO PARA A INPUT  


```<label for="nome">Nome</label>```  

```<input type="text" name="nome" id="nome">```



>Há como fazer isso sem precisar do id, assim :   

```<label>Nome:
	<input type="text" name="nome">
</label>
```

>Type é o tipo de input no qual o estilo vai ser aplicado, os que nao forem especificados não sofrem alteração  

```
input[type="text"].tague{
}
```

>PARA MAIS DE UM  

```
input[type="number"], [type="submit"]{
	width: 80px;
}
```


>PARA EXIBIR AS LABELS ACIMA DAS FIELDS É SÓ MUDAR O DISPLAY PRA BLOCK



>PRA FAZER AQUELAS AREAS DE TEXTO QUE TEM UM ICONE DO LADO PRIMEIRO DÊ UM PADDING-LEFT PRA AFASTAR O TEXTO DENTRO
CRIE UMA SEGUNDA CLASSE COM O ICONE E COLOQUE NA INPUT DEPOIS POSICIONE COM BACKGROUND POSITION O BACKGROUND 
QUE TU COLOCOU ALI (OLHE A PASTA AUTENTICAÇÃO INTERFACE PARA ENTENDER DO QUE SE TRATA).  

>QUANDO O INPUT ESTÁ SELECIONADO, PARA PERSONALIZAR OQ ACONTECE NA SELEÇÃO USE:  

```
classedoinput :focus{

}
```
