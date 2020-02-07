class Despesa{
	constructor(ano,mes,dia,tipo,descricao,valor){
		this.ano = ano;
		this.mes = mes;
		this.dia = dia;
		this.tipo = tipo;
		this.descricao =  descricao;
		this.valor = valor;
	}
	validarDados(){
		for(let i in this){
			if(this[i] == undefined || this[i] == "" || this[i] == null || this[i] == "tipo" || this[i] == "ano" || this[i] == "mes" )
				return false;
		}
		return true;
	}

}

class BD{
	constructor(){
		let id = window.localStorage.getItem('id');
		if(id===null){
			id = window.localStorage.setItem('id',0);
		}
	}
	getProxID(){
		let proxID = window.localStorage.getItem('id');
		return parseInt(++proxID);
	}
	gravar(d){
		let id = this.getProxID();

		window.localStorage.setItem(id,JSON.stringify(d));
		window.localStorage.setItem('id', id);
	}
	recuperarTodosRegistros(){
		let id = window.localStorage.getItem('id');
		let despesas = Array();
		let despesa;
		for (let i = 1; i<= id ;i++){
			despesa = JSON.parse(window.localStorage.getItem(i));
			if(despesa!=null || despesa != undefined){//caso tenha um index que foi removido, o indice percorrido na iteração terá valor null, entao ele não é incluido no array
				despesa.id = i;
				despesas.push(despesa);
			}
		}
		return despesas;
	}
	pesquisar(despesa){
		let despesasFiltradas = Array();

		despesasFiltradas =	this.recuperarTodosRegistros();
		let len = despesasFiltradas.length;
		let check = false;

		if(despesa.ano != ""){
			despesasFiltradas = despesasFiltradas.filter(d => d.ano === despesa.ano);
			check=true;
		}

		if(despesa.mes !=""){
			despesasFiltradas = despesasFiltradas.filter(d => d.mes === despesa.mes);
			check=true;
		}
		
		if(despesa.dia !=""){
			despesasFiltradas = despesasFiltradas.filter(d => d.dia === despesa.dia);
			check=true;
		}
		if(despesa.tipo !=""){
			despesasFiltradas = despesasFiltradas.filter(d => d.tipo === despesa.tipo);
			check=true;
		}
		if(despesa.descricao !=""){
			despesasFiltradas = despesasFiltradas.filter(d => d.descricao.toLowerCase() === despesa.descricao.toLowerCase() );
			check=true;
		}
		if(despesa.valor !=""){
			despesasFiltradas = despesasFiltradas.filter(d => d.valor === despesa.valor);
			check=true;
		}
		if(len === despesasFiltradas.length){
			if( check == false){
				mudarModal("Campos não preenchidos","Preencha os campos","Voltar","modal-header text-danger","btn btn-danger",true);
				return;
			}
			else
				console.log('todos os itens do localStorage correspondem a busca')
		}

		return despesasFiltradas;
	}

	remover(id){
		window.localStorage.removeItem(id);
	}

}

function mudarModal(msgTitulo, msgCorpo, msgBotao, classeHeader, classeBotao, check =false){
	let titulo = document.getElementById('modalTitle');
	let corpo = document.getElementsByClassName('modal-body')[0];
	let header = document.getElementById('modal-header');

	titulo.innerHTML = msgTitulo;
	corpo.innerHTML = msgCorpo;
	header.className = classeHeader;
	if(!check){
// o index tem que ter um botão de confirmar pra poder voltar pra a tela, mas a tela de consulta mostra um modal sem botão.
//pra ser posivel usar a mesma função nos dois lugares, coloquei a parte de resgatar o botão e o personalizar, somente no caso de a checagem
//de botão continuar falsa, o que é o caso de a função na parte do index não modificar o parametro check da função. Já no caso de exclusão de 
//registro, a funcao é chamada passando true, ou seja, não entra aqui e não tenta resgatar no dom, um botão que não existe. Então o modal no modo
//de exclusao de registro nao mostra seu botão.
		let botao = document.getElementById('modal-button');
		botao.innerHTML = msgBotao;
		botao.className= classeBotao;
	}

	$('#modalGravacao').modal('show');

}
function limparCampos(ano, mes, dia, tipo, desc, valor){
	ano.value = "ano";
	mes.value = "mes";
	dia.value = "";
	tipo.value = "tipo";
	desc.value = "";
	valor.value = "";
}
const bd = new BD();


function registrar() {
		const ano = document.getElementById('ano');
		const mes = document.getElementById('mes');
		const dia = document.getElementById('dia');
		let tipo = document.getElementById('tipo');
		const descricao = document.getElementById('descricao');
		const valor = document.getElementById('valor');

			let despesa = new Despesa(
				ano.value,
				mes.value,
				dia.value,
				tipo.value,
				descricao.value,
				valor.value
			);

			 //text-danger

			if(despesa.validarDados()){
				bd.gravar(despesa);
				mudarModal("Registro inserido com sucesso","Despesa foi cadastrada com sucesso", "Voltar","modal-header text-success", "btn btn-success" );	
				limparCampos(ano, mes, dia, tipo, descricao, valor);
			}
			else{
				mudarModal("Erro na gravação","Existem campos obrigatórios que não foram preenchidos", "Voltar e corrigir","modal-header text-danger", "btn btn-danger" );
				limparCampos(ano, mes, dia, tipo, descricao, valor);
			}

		
}

function recuperarRegistros(despesas = Array(), filtro = false){
	if(despesas.length == 0 && filtro == false){//entao aqui ele chega vazio, assim como no metodo de carregar como no load da pagina
		despesas = bd.recuperarTodosRegistros();
	}
	if(despesas.length == 0 && filtro == true){//entao aqui ele chega vazio, assim como no metodo de carregar como no load da pagina
		mudarModal("Sem registros","Nenhuma despesa encontrada", "Voltar e corrigir","modal-header text-info", "btn btn-warning", true);	
	}
	
	let listaDespesas = document.getElementById('listaDespesas');
	listaDespesas.innerHTML = "";

	despesas.forEach(
		d =>{
			let linha = listaDespesas.insertRow();

			d.dia = d.dia < 10 ? "0" + d.dia : d.dia;
			d.mes = d.mes < 10 ? "0" + d.mes : d.mes;

			linha.insertCell(0).innerHTML = `${d.dia}/${d.mes}/${d.ano}`;
			switch(parseInt(d.tipo)){
				case 1: d.tipo = "Alimentação"; break;
				case 2: d.tipo = "Educação"; break;
				case 3: d.tipo = "Lazer"; break;
				case 4: d.tipo = "Saúde"; break;
				case 5: d.tipo = "Transporte"; break;
				default: d.tipo = "Outros"; break;

			}
			linha.insertCell(1).innerHTML = `${d.tipo}`;
			linha.insertCell(2).innerHTML = `${d.descricao}`;
			linha.insertCell(3).innerHTML = `${d.valor}`;

			let btn = document.createElement('button');
			btn.className = "btn btn-danger";
			btn.innerHTML = '<i class="fas fa-times"</i>';
			btn.id = `despesa_id_${d.dia}`;

			btn.addEventListener('click', ()=>{
				bd.remover(d.id);
				mudarModal("Registro excluído com sucesso","Despesa foi excluída com sucesso", "Voltar","modal-header text-success", "btn btn-success",true );
				setTimeout(()=> {window.location.reload()}, 2000);
			})
			linha.insertCell(4).append(btn);
		}
	);
}

function pesquisarDespesa(){
	let ano, mes, dia, tipo, descricao,valor;
	ano = document.getElementById('ano').value;
	mes = document.getElementById('mes').value;
	dia = document.getElementById('dia').value;
	tipo = document.getElementById('tipo').value;
	descricao = document.getElementById('descricao').value;
	valor = document.getElementById('valor').value;

	let despesa = new Despesa(ano,mes,dia,tipo,descricao,valor);

	let despesasRetorno = bd.pesquisar(despesa);//entao esse array pode até estar vazio

	recuperarRegistros(despesasRetorno,true);//mas como aqui tem true
}


// o array volta cheio, se todos os campos estavam vazios, pq ele não entra em nenhum dos ifs. e se ele tiver encontrado como resultado, todos os itens do aray.
// e volta vazio se ele tiver entrado num if mas a comparação nao foi bem sucedida.
// assim o array vai chegar vazio no metodo de popular a tabela em dois casos: NO CASO DO LOAD DA PAGINA OU SE A CHAVE PROCURADA NAO ERA VAZIA MAS TAMBEM NAO FOI ENCONTRADa.
// ENTAO SO DIZER despesas.length == 0 NÃO É O BASTANTE PRA DIZER QUE PORQUE O ARRAY PASSADO ESTÁ VAZIO O METODO DEVE EXECUTAR A RECUPERACAO EM LOCALSTORAGE