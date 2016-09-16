/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Pojo.Venda;
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
public class VendaDAO implements InterDAO {
    
    private Connection con;
    
    public VendaDAO() {
        
        try {
            this.con = new CriaConexao().getCon();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problemas de Conexão com banco de dados."+ex.getMessage());
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Problema de Driver do banco de dados."+e.getMessage());
        }
    }
    
    @Override
    public void inserir(Object obj) throws SQLException {
        Venda venda = (Venda) obj;
        String query = " ";
        
        try {
            query = "Insert into vendas (cod_venda,data_venda,vlr_total) "
                    + "values (?,?,?)";
            PreparedStatement stm = con.prepareStatement(query);
            stm.setInt(1, venda.getCodigoPedido());
            stm.setString(2, venda.getData());
            stm.setDouble(3, venda.getVlr_total());
            stm.execute();
            JOptionPane.showMessageDialog(null, "Venda Inciada com sucesso! Não esquece de finaliza-la para dados consistentes");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Problemas de conexão com o banco de dados. "
                    + "Venda não Finalizada."+e.getMessage());
        }
    }

    // Utilizada para tela que vai listar todas as vendas
    @Override
    public ArrayList consultar(Object obj) throws SQLException {
        Venda venda = (Venda) obj; // cast do objeto para um objeto venda
        ArrayList<Venda> vet = new ArrayList<Venda>();
        
        String query = "SELECT * FROM VENDAS";
        
        try {
            PreparedStatement stm = con.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            
            while (rs.next()) {
                Venda novo = new Venda(venda.getCodigoPedido());
                //novo.setCodigoPedido(rs.getInt(1));
                novo.setData(rs.getString(2));
                novo.setVlr_total(rs.getDouble(3));
                vet.add(novo);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Problemas de Conexão com banco de dados.");
        }
        
        return vet;
    }

    // Utilizo para encontrar uma unica Venda
    public Venda consultar(int Codigo) throws SQLException {
        Venda venda = new Venda(Codigo); // cast do objeto para um objeto venda
        ArrayList<Venda> vet = new ArrayList<Venda>();
        
        String query = "SELECT * FROM VENDAS WHERE COD_VENDA = ?";
        
        try {
            PreparedStatement stm = con.prepareStatement(query);
            stm.setInt(1, Codigo);
            ResultSet rs = stm.executeQuery();
            
            while (rs.next()) {
//               Venda novo = new Venda();
                venda.setCodigoPedido(rs.getInt(1));
                venda.setData(rs.getString(2));
                venda.setVlr_total(rs.getDouble(3));
                
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Problemas de Conexão com banco de dados.");
        }
        
        return venda;
    }
    
    @Override
    public void atualizar(int Codigo, Object obj) throws SQLException {
        Venda venda = (Venda) obj;
        String query = " ";
        
        try {
            query = "UPDATE VENDAS SET "
                    + "COD_VENDA = ? ,"
                    + "DATA_VENDA = ?,"
                    + "VLR_TOTAL = ? "
                    + "WHERE COD_VENDA = ?";
            PreparedStatement stm = con.prepareStatement(query);
            stm.setInt(1, Codigo);
            stm.setString(2, venda.getData());
            stm.setDouble(3, venda.getVlr_total());
            stm.setInt(4, Codigo);
            stm.execute();
            JOptionPane.showMessageDialog(null, "Venda finalizada com sucesso!");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Problemas de conexão com o banco de dados. "
                    + "Venda não Finalizada."+e.getMessage());
        }
    }
    
    @Override
    public void remover(Object obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int max_id() {
        int max_id = 0;
        String query = "select max(cod_venda) from vendas"; // Função sql que retorna o maximo de determinada coluna, logo, neste caso o maximo de ID, 
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
}
