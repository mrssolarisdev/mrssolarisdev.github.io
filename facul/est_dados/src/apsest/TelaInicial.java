/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apsest;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;



/**
 *
 * @author Roverson
 */
public class TelaInicial extends javax.swing.JFrame {
    
private static final String FILE_ERROR="Escolha um arquivo válido";
private static final String SUCCESS = "Arquivo BALANCEADO";
private static final String FAIL = "Arquivo DESBALANCEADO";
private static final String AT_LINE = "Erro na linha: ";
private static final String QUEBRA = "\n";
//NÃO IMPORTEI ESSAS MESMAS VARIAVEIS DA OUTRA CLASSE POIS CODIGOS DE COR EM ANSI NÃO FUNCIONAM NO OPTIONPANE
    /**
     * Creates new form Select1
     */
    public TelaInicial() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmp_caminho = new javax.swing.JTextField();
        btn_compilar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jButton1.setBackground(new java.awt.Color(102, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Procurar arquivo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Unicode MS", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 0));
        jLabel1.setText("Balanceador de símbolos");

        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Arquivos: Java, C, C++, Python, txt, Javascript etc.");

        btn_compilar.setBackground(new java.awt.Color(102, 0, 0));
        btn_compilar.setForeground(new java.awt.Color(255, 255, 255));
        btn_compilar.setText("Compilar");
        btn_compilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_compilarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btn_compilar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmp_caminho, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(62, 62, 62))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmp_caminho, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(btn_compilar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       JFileChooser fileChooser = new JFileChooser();// cria um file chooser
       fileChooser.setDialogTitle("Selecione o arquivo");//Seta o titulo da janela aberta
       fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);// seleciona somente arquivos
       
       FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos de texto","c","cpp","java","py","txt","js");//arquivos aceitos na aplicação, pode adicionar mais
       
       fileChooser.setFileFilter(filter);// o file chooser só abrirá os arquivos setados no filter acima
       
      int retorno = fileChooser.showOpenDialog(this);//coloca ele como visivel
      
      if(retorno == JFileChooser.APPROVE_OPTION){//capta o retorno da janela, caso um arquivo seja escolhido, o caminho do arquivo vai para o campo de texto.
          File file = fileChooser.getSelectedFile();//pega o arquivo selecionado
          cmp_caminho.setText(file.getPath());//coloca o caminho para o arquivo no campo de texto
          System.out.println(cmp_caminho.getText());//caminho para o arquivo, pode desativar
      }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_compilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_compilarActionPerformed
        if(!cmp_caminho.getText().equals("")){//se o campo não estiver vazio
            try {
                String caminho = cmp_caminho.getText(); //pega o caminho do arquivo no campo
                boolean retorno=false; //retorno da funcao de leitorArquivo
                System.out.println(caminho);
                retorno = LeitorArquivo.lerArquivo(caminho);//capta o retorno
                
                if(retorno){
                    JOptionPane.showMessageDialog(rootPane, SUCCESS);//se o arquivo está balanceado(return true), Sucesso
                }
                else
                    JOptionPane.showMessageDialog(rootPane, FAIL+QUEBRA+AT_LINE+LeitorArquivo.getLine());// se está desbalanceado(return false), Falha na linha X
            } catch (Exception ex) {
                Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            JOptionPane.showMessageDialog(rootPane, FILE_ERROR);//Se o caminho para o arquivo está vazio
        }
    }//GEN-LAST:event_btn_compilarActionPerformed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_compilar;
    private javax.swing.JTextField cmp_caminho;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

