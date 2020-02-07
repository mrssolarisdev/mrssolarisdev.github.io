
package apsest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

class LeitorArquivo {
    // ESTRUTURAS DE DADOS E VARIÁVEIS
    //ESTAS VARIAVEIS MUDAM AS CORES DA SAÍDA NO CONSOLE
    private static final String CSI = "\u001B[";
    private static final String RED = CSI + "31" + "m";
    private static final String PINK = CSI + "35" + "m";
    private static final String YELLOW = CSI + "33" + "m";
    private static final String GREEN = CSI + "32" + "m";
    
    private static final String BADACT_TXT = RED + "Algo deu errado";
    private static final String STACK_ERROR = RED + "Erro na linha: ";
    private static final String SUCCESS_TXT = PINK + "Item Removido:";
    private static final String FATAL = RED + "EXECUÇÃO PARADA, FALTA O CARACTERE DE ABERTURA CORRESPONDENTE Á: ";
    protected static final String SUCCESS = GREEN + "Arquivo BALANCEADO";
    protected static final String FAIL = RED + "Arquivo DESBALANCEADO";
    private static final String STACK_A = "Pilha atualmente contém os símbolos:";
    
    //PILHA DE SIMBOLOS
    private static Stack pilha = new Stack();
    private static int line=-1;
    
    // ENUMERADORES - TABELA DE SIMBOLOS ASCII
    private enum Aberturas {
        PARENTESE("\u0028"), COLCHETE("\u005B"), CHAVE("\u007B"), ASPA_DUPLA("\""), ASPA_SIMPLES("\u0027");
        
        private String symbol;
        
        Aberturas(String s){
            this.symbol = s;
        }
        
        private String getSymbol(){
            return this.symbol;
        }
        
        //System.out.println(Aberturas.ASPA_DUPLA.getSymbol()); modo de ler cada simbolo
    }
    private enum Fechamentos {
        PARENTESE("\u0029"), COLCHETE("\u005D"), CHAVE("\u007D"), ASPA_DUPLA("\""), ASPA_SIMPLES("\u0027");
        
        private String symbol;
        
        Fechamentos(String s){
            this.symbol = s;
        }
        
        private String getSymbol(){
            return this.symbol;
        }
    }
    
    
    
    
    
    //MÉTODOS
    public static boolean lerArquivo (String caminhoArquivo) throws FileNotFoundException, Exception {
        boolean retornoPrincipal=false;
        try{
            ArrayList linhas = new ArrayList();
            File arquivo = new File(caminhoArquivo);
            BufferedReader leitorArquivo = new BufferedReader(new FileReader(arquivo));
            String s;
            int i=0;
            
            while( (s = leitorArquivo.readLine()) != null) {	
                String str = new String(s.getBytes(),"UTF-8");//setei a leitura para UTF-8
                linhas.add(str);
                /*System.out.println(linhas.get(i));
                i++; //para ver o arquivo sendo lido na prática, descomente essa zona*/
            }
            
            leitorArquivo.close();
            retornoPrincipal = balancear(linhas,leitorArquivo);
            }
            catch(Exception e){
            System.out.println(BADACT_TXT);
            }
        return retornoPrincipal;
    }
    
    private static boolean balancear(ArrayList arr, BufferedReader s){
        int linha = 0;
        char item =' ';
            pilha.makeEmpty();
           ArrayList clone = arr;
           String correspondente=null;
           boolean error=false;
           
        try{
           
// Eu ia usar switch, mas dá um erro especifico de "char cannot be deferenced", 
//os enums são Strings e os caracteres da linha em cada indice viram chars com o charAt(), o unico modo que encontrei de conseguir 
//comparar os dois, foi usando o charAt do outro lado da expressão.

           for(int i=0; i<clone.size();i++){  
               linha=i+1;//pega o valor da linha no momento
               for(int j=0; j<clone.get(i).toString().length();j++){
//O segundo for é pra garantir que todos os caracteres de abertura presentes na linha vão ser adcionados na pilha
                item = clone.get(i).toString().charAt(j);
                   //System.out.println(item);
               if(clone.get(i).toString().charAt(j)==(Aberturas.PARENTESE.getSymbol().charAt(0))){
                    pilha.push(Aberturas.PARENTESE.getSymbol());
                    //se o caractere sendo lido atualmente for igual a um parentese, um parentese é adcionado na pilha
                }
                if(clone.get(i).toString().charAt(j)==(Aberturas.COLCHETE.getSymbol().charAt(0))){
                    pilha.push(Aberturas.COLCHETE.getSymbol());
                }
                if(clone.get(i).toString().charAt(j)==(Aberturas.CHAVE.getSymbol().charAt(0))){
                    pilha.push(Aberturas.CHAVE.getSymbol());
                }
                if(clone.get(i).toString().charAt(j)==(Aberturas.ASPA_SIMPLES.getSymbol().charAt(0))){
                    pilha.push(Aberturas.ASPA_SIMPLES.getSymbol());
                }
                if(clone.get(i).toString().charAt(j)==(Aberturas.ASPA_DUPLA.getSymbol().charAt(0))){
                    pilha.push(Aberturas.ASPA_DUPLA.getSymbol());
                }
                if(clone.get(i).toString().charAt(j)==(Fechamentos.PARENTESE.getSymbol().charAt(0))){
                        correspondente=Aberturas.PARENTESE.getSymbol();
   /*se o caractere sendo lido atualmente for equivalente a um parentese, um parentese é retirado na pilha
      * Se um caractere de fechamento é encontrado mas a pilha está vazia, a linha tem erro.
        */              
                        if(!pilha.isEmpty()){
                            if(pilha.top().toString().equals(correspondente)){
                                pilha.pop();
                                error=false;
                                System.out.println(SUCCESS_TXT+correspondente);
                            }
                /*Se a pilha não está vazia, um caractere de fechamento é encontrado, mas não
                 *corresponde ao topo da pilha, a linha tem erro.
                 */
                            else{
                                error = true;
                                break;
                            }
                        }
                        else{
                            error=true;
                            break;
                        }
                           
                    }
                    if(clone.get(i).toString().charAt(j)==(Fechamentos.CHAVE.getSymbol().charAt(0))){
                        correspondente=Aberturas.CHAVE.getSymbol();
                        
                        if(!pilha.isEmpty()){
                            if(pilha.top().toString().equals(correspondente)){
                                pilha.pop();
                                error=false;
                                System.out.println(SUCCESS_TXT+correspondente);
                            }
                            else{
                                error = true;
                                break;
                            }
                        }
                        else{
                            error=true;
                            break;
                        }
                    }
                    if(clone.get(i).toString().charAt(j)==(Fechamentos.COLCHETE.getSymbol().charAt(0))){
                        correspondente=Aberturas.COLCHETE.getSymbol();
                        
                        if(!pilha.isEmpty()){
                            if(pilha.top().toString().equals(correspondente)){
                                pilha.pop();
                                error=false;
                                System.out.println(SUCCESS_TXT+correspondente);
                            }
                            else{
                                error = true;
                                break;
                            }
                        }
                        else{
                            error=true;
                            break;
                        }
                    }
                    if(clone.get(i).toString().charAt(j)==(Fechamentos.ASPA_SIMPLES.getSymbol().charAt(0))){
                        correspondente=Aberturas.ASPA_SIMPLES.getSymbol();
                       
                        if(!pilha.isEmpty()){
                            if(pilha.top().toString().equals(correspondente)){
                                pilha.pop();
                                error=false;
                                System.out.println(SUCCESS_TXT+correspondente);
                            }
                            else{
                                error = true;
                                break;
                            }
                        }
                        else{
                            error=true;
                            break;
                        }
                    }
                    
                    if(clone.get(i).toString().charAt(j)==(Fechamentos.ASPA_DUPLA.getSymbol().charAt(0))){
                        correspondente=Aberturas.ASPA_DUPLA.getSymbol();
                       
                        if(!pilha.isEmpty()){
                            if(pilha.top().toString().equals(correspondente)){
                                pilha.pop();
                                error=false;
                                System.out.println(SUCCESS_TXT+correspondente);
                            }
                            else{
                                error = true;
                                break;
                            }
                        }
                        else{
                            error=true;
                            break;
                        }
                    }
                
               }
               if(error){
                System.out.println(STACK_ERROR+linha);
                line = linha; //
                System.out.println(FAIL);
                System.out.println(STACK_A);
                pilha.printStack();
                return false;
               }
           }
           if(!pilha.isEmpty()){
               //se a pilha ainda tem caracteres de abertura, é pq não há um caractere de fechamento
               //correspondente a ele, portanto, erro.
               System.out.println(STACK_ERROR+linha);
               line = linha;
               System.out.println(STACK_A);
               pilha.printStack();
               System.out.println(FAIL);
               return false;
           }
           if(pilha.isEmpty()){
                System.out.println(SUCCESS);
                return true;
           }
            
        }
        catch(Exception e){
           System.out.println(STACK_ERROR+linha);
           line = linha;;
           System.out.println(FATAL+item);
           return false;
        }
        return true;
        
    }

    public static int getLine() {
        return  LeitorArquivo.line;
    }

}
