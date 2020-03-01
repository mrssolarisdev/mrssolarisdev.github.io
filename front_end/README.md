**html**

o html = **hypertext markup language **

marca o que é cada parte do texto, indica ao interpretador o que é o que
o que é o video, uma div etc.


**listas**

```<ol> ordened list- - lista ordenada- numeros
<ul> unordened list - lista nao ordenada
<li> list item - item da lista
 ul type : circle, disc, square
 ol type : 1, a, a, i e i(algarismos romanos)
 ```


**tabelas**
 
 ```<table>``` tabela todas devem começar assim  
 

 ```<tr>``` table row - linha da tabela  
 
 ```<td>``` table data  - itens da tabela  
 
 ```<th>``` table header - cabeçalho da tabela  
 
 ```<td colspan="2"``` - column spansion - expansão da coluna nesse caso
 uma coluna ocupa o espaço de 2  
 
 ```<td rowspan="2"``` - row spansion - expansão da linha, nesse
 caso uma linha ocupa o espaço de duas  
 
 ```<thead>``` header da tabela, geralmente engloba uma ```<tr>``` que tem elementos ```<th>``` dentro, serve pra agrupar os elementos do cabeçalho da tabela.  
 
 ```<tbody>``` corpo da tabela, engloba tudo que forem dados que não fazem parte do header da tabela, agrupa trs que tem tds.
 mais do que isso, ele tem uma barra de scroll, que só aparece nele(no thead nao). é bom pra impressão, pois, se eu fosse
 imprimir uma tabela, o header da tabela apareceria em cada folha, se não tivesse esse atributo, desse modo aparece só 
 na primeira.  
 
 ```<tfoot>``` o footer da tabela, do mesmo modo que a theader, só aparece uma vez em impressões.  
 
 atributo scope:
	```<th scope="col">month</th>```  
  
nesse exemplo, diz que essa th é um table header de uma coluna, poderia ser row, e então seria o header de uma linha.

 
>comentar html <! -- conteudo -->  

>comentar css /* conteudo */


**inputs**

tipos:   

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

**form**

```<form>``` formulário (inputs devem estar dentro de um formulario, pois o botão de enviar para um banco de dados, pega os dados das inputs que estão dentro deste form, e envia pela requisição).

***input para texto***
```<input type="text" name="alguma coisa aqui">```  

***input para senha***
```<input type="password" name"nome exibido no browser">```  

***input para email***
```<input type="email" name="nome" placeholder="insira seu email.." required="">```  


***input para numero(spinner)***
```<input type="number" name="qtd" id="qtd">```  

o number tem parametros especificos:
	```min="numero"```    
    
    
	``` max="numero" ```  
  
assim a seta so deixa voce ir até o numero determinado, se passar do especificado a certa trava, se digitar algo maior ou menor e tentar enviar, o botão não deixa.

tem também o:
	```step="numero"```  

define de quanto em quanto a quantidade na caixa contará


***input para url***
```<input type="url" name="url" id="url" placeholder="ex: http://www..."```  

[essa input só aceita url com http:// então é util deixar isso claro no placeholder]

***input para pesquisa***
```<input type="search" id="search">```

***input para controle deslizante***
```<input type="range" id="range">``` 

para ele tambem se aplica o maximo e minimo:
	```max="numero"```
	```min="numero"```
  
  e um valor no qual ele já vem configurado:
	```value="numero"```  
  nao pega em navegadores defasados

se pedir pra resgatar o value, ele retorna o valor onde a barra de seleção do range está
teste:
```
<!doctype html>
<html>
<body>

<input type="range" id="ta" min="0" max="5" step="1">
<script type="text/javascript">
	let d = document.getelementbyid('ta');

	d.addeventlistener('change',
    ()=>{
    	console.warn(d.value);
	}
    );


</script>
</body>
</html>

```
para estilizar a range:

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

como não tem como colocar indicadores do valor pelo html, podemos colocar um norte para o usuario, usando js.

assim:
```
 <input id="idade" type="range" min="18" max="120" value="18" onchange="mostraridade(this.value)" />
 <span id="exibeidade">18</span>

  function mostraridade(novovalor) {
       document.getelementbyid("exibeidade").innerhtml = novovalor;
  }
```

****utiliza prefixos de compatibilidade moz e ms****


***input para data***
```<input type="date" id="date">```
[---------nao pega em navegadores defasados----------]

***input para cor***
```<input type="color" id="color">```
da pra definir a cor na qual ele vem ao carregar a pagina
```value="corhex"```

***input para botão***
```<input type="button" value="nome exibido no lugar">``` 

***input para enviar um arquivo para um servidor***
```<input type="submit" value="nome exibido no lugar"> ```

***botões de radio***
```<input type="radio" name="nome exibido no browser"> value="nome exibido no lugar">``` 

***botões de checkbox***
```<input type="checkbox" name="nome exibido"> ```

***input para arquivo***
```<input type="file" id="arquivo">```






**atributos das inputs**

```placeholder ``` -> placeholder é o texto dentro da input que aparece no campo  

```value``` -> é exibido como o nome nos botões, campos de texto e também o valor das inputs de entrada de dados enviado depois do processamento.  

```name```-> referencia ao que foi inserido na caixa, aparece no browser nomeando duas inputs do tipo radio, você as agrupa,
fazendo com que só uma possa ser selecionada, no checkbox, mesmo com nomes iguais, você pode selecionar quantas quiser. também se refere ao indice que a informação da input vai estar quando for enviada através de post ou get nas super globais $_get e $_post. 

```id``` -> identificador único de um elemento.  

```required``` ->impede que o campo fique vazio ao enviar dados de um form" se usa assim: required="required" ou: required(sem valores)
ou required=""  

```autofocus```-> diz a caixa que deve aparecer selecionada assim que a pagina carrega, indicando ao usuario por onde ele deve começar.


***caixa de seleção(combobox)***
```<select name="estado"> </select>``` -> cria uma caixa de seleção

***opções de uma caixa de seleção(combobox)***
```<option value="bahia">ba</option>``` -> cria opções dentro de uma caixa de seleção // nesse caso, o nome estado irá receber o valor bahia.  


***area de texto***
```<textarea></textarea>```  


***retira a opcao de aumentar a textarea***
```<textarea style="resize: none"></textarea>```  


>fieldsets são tags que agrupam dados semelhantes

```<fieldset>
</fieldset>	
```  

>legend é a legenda do fieldset

```<legend> </legend>```

>label é a etiqueta, o rotulo de uma input(nome que vem antes)
```<label></label>```  


for: > id que associa um input a uma label(quando voce clica na label ela te leva pro input)
>quando o id no for tem o mesmo nome que o de uma input, ao clicar voce é levado para a input  


```<label for="nome">nome</label>```  

```<input type="text" name="nome" id="nome">```



>há como fazer isso sem precisar do id, assim :   

```<label>nome:
	<input type="text" name="nome">
</label>
```

>type é o tipo de input no qual o estilo vai ser aplicado, os que nao forem especificados não sofrem alteração  

```
input[type="text"].tague{
}
```

>para mais de um  

```
input[type="number"], [type="submit"]{
	width: 80px;
}
```


>para exibir as labels acima das fields é só mudar o display pra block



>pra fazer aquelas areas de texto que tem um icone do lado primeiro dê um padding-left pra afastar o texto dentro
crie uma segunda classe com o icone e coloque na input depois posicione com background position o background 
que tu colocou ali (olhe a pasta autenticação interface para entender do que se trata).  

>quando o input está selecionado, para personalizar oq acontece na seleção use:  

```
classedoinput :focus{

}
```
