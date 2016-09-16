/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Pojo.ItemVenda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author felipe
 */
public class ItemVendaDAO implements InterDAO {

    private Connection con;

    public ItemVendaDAO() {
        try {
            this.con = new CriaConexao().getCon();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problemas de Conexão com banco de dados." + ex.getMessage());
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Problema de Driver do banco de dados." + e.getMessage());
        }
    }

    // operaçção não usual, vamos ter aqui uma sobrecarga para poder utilizar a inserção. 
    @Override
    public void inserir(Object obj) throws SQLException {
//        ItemVenda item = (ItemVenda) obj;
//        String query = " ";
//
//        try {
//            query = "Insert into itens_venda ("
//                    + "cod_venda,"
//                    + "cod_produto,"
//                    + "qtd_produto,"
//                    + "valor_unit) "
//                    + "values "
//                    + "(?,?,?)";
//            PreparedStatement stm = con.prepareStatement(query);
//            stm.setInt(1, item.);
//            stm.setString(2, venda.getData());
//            stm.setDouble(3, venda.getVlr_total());
//            stm.execute();
//            JOptionPane.showMessageDialog(null, "Venda finalizada com sucesso!");
//
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Problemas de conexão com o banco de dados. "
//                    + "Venda não Finalizada." + e.getMessage());
//        }

    }
    public void inserir(Object obj, int cod_venda) throws SQLException {
        ItemVenda item = (ItemVenda) obj;
        String query = " ";

        try {
            query = "Insert into itens_venda (cod_itens_venda,"
                    + "cod_venda,"
                    + "cod_produto,"
                    + "qtd_produto,"
                    + "valor_unit) "
                    + "values "
                    + "(?,?,?,?,?)";
            PreparedStatement stm = con.prepareStatement(query);
            stm.setInt(1, max_id());
            stm.setInt(2, cod_venda);
            stm.setInt(3, item.getCodigoProduto());
            stm.setInt(4, item.getQuantidade());
            stm.setDouble(5, item.getUnitprice());
            stm.execute();
            JOptionPane.showMessageDialog(null, "Venda finalizada com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Problemas de conexão com o banco de dados. "
                    + "Venda não Finalizada." + e.getMessage());
        }

    }
    
    

    @Override
    public ArrayList consultar(Object obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(int Codigo, Object obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(Object obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int max_id() {
        int max_id = 0;
        String query = "select max(cod_itens_venda) from itens_venda"; // Função sql que retorna o maximo de determinada coluna, logo, neste caso o maximo de ID, 
        // venda que é o codigo que precisamos. 
        try {
            PreparedStatement stm = con.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
            max_id = rs.getInt(1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Problemas de conexão com o banco de dados."+e.getMessage());
        }
        return max_id+1;
    }
    
     public double sum_id(int cod_venda) {
        int sum = 0;
        String query = "SELECT SUM(qtd_produto*valor_unit) as total_venda FROM itens_venda where cod_venda=?"; // Função sql que retorna o maximo de determinada coluna, logo, neste caso o maximo de ID, 
        // venda que é o codigo que precisamos. 
        try {
            PreparedStatement stm = con.prepareStatement(query);
            stm.setInt(1, cod_venda);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
            sum = rs.getInt(1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Problemas de conexão com o banco de dados."+e.getMessage());
        }
        return sum;
    }

}
