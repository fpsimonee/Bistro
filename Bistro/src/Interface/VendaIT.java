/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;


import Persistence.VendaDAO;
import Pojo.ItemVenda;
import Pojo.Produto;
import Pojo.Venda;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.awt.Component;
//import javax.swing.DefaultListCellRenderer;
//import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;

/**
 *
 * @author felipe
 */
public class VendaIT extends javax.swing.JFrame {

    /**
     * Creates new form Venda
     */
    public VendaIT() {
        initComponents();
    }

    public void AdicionaTabela() {
        String a = jTextFieldCodProduto.getText();
        String b = jTextFieldQtdProduto.getText();
        String c = jTextFieldUnitPrice.getText().replaceAll(",", ".");
        int CodProduto = Integer.parseInt(a);
        int QtdProduto = Integer.parseInt(b);
        double unitPrice = Double.parseDouble(c);
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.addRow(new Object[]{CodProduto, QtdProduto, unitPrice, (QtdProduto * unitPrice)});
        // final da parte que adiciona na Tabela
    }

    // Indice da tabela começa em 0 então faço -1 para, o usuario digitar de 1 .... n 
    // na hora de excluir um item do Pedido 
    public void RemoveItem(int id) {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        try{
        modelo.removeRow(id-1);
        } catch(ArrayIndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null, "A linha já foi Excluída ou não existe!");
        }
    }    
    public void inserirItemvenda(ItemVenda item){
      try{
        
        // controler para manter ou nao o item, dependendo do status da venda 
        Produto produto = new Produto();
        
        String aux1;
        String aux2;
        String aux3;
        String aux4;
        
        for(int i=0;i<jTable1.getRowCount();i++){
            // pega a linha i e seleciona o valor da coluna que eu definir
            // Pego o Codigo do Produto
           aux1 = (String) jTable1.getValueAt(i, 0);
           item.setCodigoProduto(Integer.parseInt(aux1));
           
           // Pego a quantidade do Produto 
           aux2 = (String) jTable1.getValueAt(i, 1);
           item.setQuantidade(Integer.parseInt(aux2));
           
           // Pego o preço Unitario do produto 
           aux3 = (String) jTable1.getValueAt(i, 2);
           item.setUnitprice(Float.parseFloat(aux3));
           
           // Pego o Valor Total item 
           aux4 = (String) jTable1.getValueAt(i, 3);
           item.setPriceItem(Float.parseFloat(aux4));
        
        }

      }catch(Exception e){
          JOptionPane.showMessageDialog(null, "Erro ao persistir objeto item venda: "+ e.getMessage());
      }
    
    }
    
    public int geraCodigoVenda(){
       int max_id = new VendaDAO().max_id();
       return max_id; 
    }
    
    public String CurrentData (){
       
       Date date = new Date();       
       SimpleDateFormat formatador = new SimpleDateFormat();
       String data = formatador.format(date);       
       return data;
    
    }
    
// Calculo do Valor total mas nao funcionou 
//    public void CalculaprecoTotal() {
//        BigDecimal total = BigDecimal.ZERO;
//
//        for (int i = 0; i < jTable1.getRowCount(); i++) {
//
//            String valor = jTable1.getValueAt(i, 3) + "";
//            BigDecimal v1 = new BigDecimal(valor.replace(",", "."));
//            total = total.add(v1);
//            System.out.println(total);
//        }
//        jTextFieldPrecoTotal.setText(String.valueOf(total));
//    }
    
//    Função para pegar a data corrente 
//    public String mostraData() {
//        Date data = new Date();
//        String date = data.getDay() + "/" + data.getMonth() + "/" + data.getYear();
//        return date;
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldCodProduto = new javax.swing.JTextField();
        jTextFieldQtdProduto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButtonSalvar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonAdd = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldUnitPrice = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButtonExcluirItem = new javax.swing.JButton();
        jTextFieldExcluirItem = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Codigo");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Produto", "Qtd", "Unit Price", "Valor Total"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setHeaderValue("Codigo Produto");
            jTable1.getColumnModel().getColumn(1).setHeaderValue("Qtd");
            jTable1.getColumnModel().getColumn(2).setHeaderValue("Unit Price");
            jTable1.getColumnModel().getColumn(3).setHeaderValue("Valor Total");
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, 375, 275));

        jLabel4.setText("Itens da Venda");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(324, 22, -1, -1));

        jLabel5.setText("Codigo Produto");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 120, 20));

        jTextFieldCodProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCodProdutoActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldCodProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, 44, -1));
        getContentPane().add(jTextFieldQtdProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, 45, -1));

        jLabel6.setText("Qtd");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, 40, -1));

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(424, 420, 80, -1));

        jButtonCancelar.setText("Cancelar");
        getContentPane().add(jButtonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 420, 84, -1));

        jButtonAdd.setText("Add");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, 80, -1));

        jLabel3.setText("Unit Price");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 80, -1));

        jTextFieldUnitPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUnitPriceActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldUnitPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, 50, -1));

        jLabel8.setText("Cancela Item: ");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 430, 120, -1));

        jButtonExcluirItem.setText("Excluir");
        jButtonExcluirItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirItemActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonExcluirItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 420, 82, -1));
        getContentPane().add(jTextFieldExcluirItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 420, 35, -1));

        jTextField1.setEditable(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 70, -1));

        jLabel2.setText("Data");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 130, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldCodProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCodProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCodProdutoActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        // TODO add your handling code here:
//        Venda nova = new Venda();
//        
//        VendaDAO dao = new VendaDAO();
//        
//        nova.setCodigoPedido(dao.max_id());
//        nova.setData();
//        
//        try {
//            dao.inserir(dao);
//        } catch (SQLException ex) {
//            Logger.getLogger(Venda.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        // TODO add your handling code here:
        this.AdicionaTabela();
        jTextField2.setText(this.CurrentData());
        String ID = String.valueOf("1"); // alterar o valor do valueof p/ this.geracodigo()
        jTextField1.setText(ID);
        
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jTextFieldUnitPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldUnitPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldUnitPriceActionPerformed

    private void jButtonExcluirItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirItemActionPerformed
        // TODO add your handling code here:
        int id = Integer.parseInt(jTextFieldExcluirItem.getText());
        this.RemoveItem(id);
    }//GEN-LAST:event_jButtonExcluirItemActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jTextField2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Venda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Venda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Venda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Venda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VendaIT().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonExcluirItem;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextFieldCodProduto;
    private javax.swing.JTextField jTextFieldExcluirItem;
    private javax.swing.JTextField jTextFieldQtdProduto;
    private javax.swing.JTextField jTextFieldUnitPrice;
    // End of variables declaration//GEN-END:variables
}