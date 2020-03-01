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




***TAG AUDIO***

```<audio></audio>``` -> DEFINE UM AUDIO, LEVA ATRIBUTOS COMO:  


```controls``` - DEFINE QUE O AUDIO TEM CONTROLE DE VOLUME, ACELERAR ETC.  

```autoplay``` - DEFINE QUE O AUDIO COMEÇA SOZINHO.  

```loop```     - DEFINE QUE O AUDIO SE REPETE QUANDO ACABA.  

```preload```  - DEFINE QUE O AUDIO É CARREGADO JUNTO COM A PÁGINA.  

> O atributo preload é usado em elementos audio para carregar arquivos grandes. Ele pode assumir 3 valores:  

```"none"``` - Não carrega o arquivo.  

```"auto"``` - Carrega o arquivo.  

```"metadata"``` - Carrega apenas os meta dados do arquivo.  

```src```  - DEFINE DE ONDE O AUDIO É PEGO, MAS É MELHOR USAR A TAG SOURCE:

```<source></source>``` - DEFINE DE ONDE O AUDIO SERÁ PEGO, LEVA OS ATRIBUTOS:  

```
source="endereçoAudio.extensão"
type="extensao/extensao" // audio/mp3
```

***TAG VIDEO***

```<video></video>``` - DEFINE UM VIDEO, LEVA ATRIBUTOS COMO:    


```audioTracks`` - Returns an AudioTrackList object representing available audio tracks.    

```autoplay``` - Sets or returns whether the audio/video should start playing as soon as it is loaded.   

```buffered``` - Returns a TimeRanges object representing the buffered parts of the audio/video.  

```controller``` - Returns the MediaController object representing the current media controller of the audio/video.   

```controls``` - Sets or returns whether the audio/video should display controls (like play/pause etc.).  

```crossOrigin``` - Sets or returns the CORS settings of the audio/video.  

```currentSrc``` - Returns the URL of the current audio/video.  

```currentTime``` - Sets or returns the current playback position in the audio/video (in seconds).  

```defaultMuted``` - Sets or returns whether the audio/video should be muted by default.  

```defaultPlaybackRate``` - Sets or returns the default speed of the audio/video playback.  

```duration``` - Returns the length of the current audio/video (in seconds).  

```ended``` - Returns whether the playback of the audio/video has ended or not.  

```error``` - Returns a MediaError object representing the error state of the audio/video.
loop	Sets or returns whether the audio/video should start over again when finished
mediaGroup	Sets or returns the group the audio/video belongs to (used to link multiple audio/video elements)
muted	Sets or returns whether the audio/video is muted or not
networkState	Returns the current network state of the audio/video
paused	Returns whether the audio/video is paused or not
playbackRate	Sets or returns the speed of the audio/video playback
played	Returns a TimeRanges object representing the played parts of the audio/video
preload	Sets or returns whether the audio/video should be loaded when the page loads
readyState	Returns the current ready state of the audio/video
seekable	Returns a TimeRanges object representing the seekable parts of the audio/video
seeking	Returns whether the user is currently seeking in the audio/video
startDate	Returns a Date object representing the current time offset
textTracks	Returns a TextTrackList object representing the available text tracks
videoTracks	Returns a VideoTrackList object representing the available video tracks
volume	Sets or returns the volume of the audio/video
src      - DEFINE DE ONDE O AUDIO É PEGO, MAS É MELHOR USAR A TAG SOURCE:

<source></source> - DEFINE DE ONDE O VIDEO SERÁ PEGO, LEVA OS ATRIBUTOS:
source="endereçoVideo.extensão"
type="extensao/extensao" // video/mp4

Vários arquivos podem ser especificados utilizando o elemento <source> 
para disponibilizar vídeo ou áudio codificados em formatos diferentes para navegadores diferentes.
Por exemplo:

<video controls="">
  <source src="foo.ogg" type="video/ogg">
  <source src="foo.mp4" type="video/mp4">
  Seu navegador não suporta o elemento <code>video</code>.
</video>

Também é possível especificar os codecs que o arquivo de mídia requer; isso permite que o navegador
faça escolhas mais inteligentes:

<video controls="">
  <source src="foo.ogg" type="video/ogg; codecs=dirac, speex">
  Seu navegador não suporta o elemento <code>video</code>.
</video>

AS CLASSES PARA ESTILIZAR VIDEO:

.video:hover 
.player
.player .progress
.player .progress-bar
.player .button-holder
.player .progress-button
.player [class^="buffered"]
.player .play-pause
.player .play
.player .pause-button
.player .play .pause-button
.player .pause .play-button
.player .pause-button
.player .pause-button span
.player .pause-button span:first-of-type
.player .time
.player .stime .ttime
.player .play:hover,
.player .play:active
.pause-button:active span
.player .pause-button:hover span
.player .volume
.player .volume-icon
.player .volume-icon-hover
.player .volume-holder,
.player .valume-bar-holder
.player .volume-button
.player .volume-button-holder
.pplayer .volume-bar
.player .fullscreen
.player .fullscreen a
.player .volume-icon span
.player .volume-icon span:before
.player .volume-icon span:after
.player .volume-icon span:before
.player .volume-icon span:after
.player .v-change-X span:after onde X varia de 1 a 11 (ambos inclusos).


_______________________[HTML Audio/Video Methods]_______________________
Method	Description
addTextTrack()	Adds a new text track to the audio/video
canPlayType()	Checks if the browser can play the specified audio/video type
load()	Re-loads the audio/video element
play()	Starts playing the audio/video
pause()	Pauses the currently playing audio/video

