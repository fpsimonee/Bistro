/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author felipe
 */
public interface InterDAO{
    public void inserir(Object obj) throws SQLException;
    public ArrayList consultar(Object obj) throws SQLException;
    public void atualizar(int Codigo, Object obj) throws SQLException;
    public void remover(Object obj) throws SQLException;
    
}
