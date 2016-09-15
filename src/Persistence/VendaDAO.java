/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

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
            JOptionPane.showMessageDialog(null, "Problemas de Conexão com banco de dados.");
        } catch (ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "Problema de Driver do banco de dados.");
        }
    }

    @Override
    public void inserir(Object obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList consultar(Object obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Object obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(Object obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int max_id()  {
        int max_id = 0; 
        String query = "select max(cod_venda) from vendas"; // Função sql que retorna o maximo de determinada coluna, logo, neste caso o maximo de ID, 
                                                            // venda que é o codigo que precisamos. 
        try{
        PreparedStatement stm = con.prepareStatement(query);
        ResultSet rs = stm.executeQuery();        
        max_id = rs.getInt("max(cod_produto)");
        }catch(SQLException e){
          JOptionPane.showMessageDialog(null, "Problemas de conexão com o banco de dados.");
        }
        return max_id;
    }
}
