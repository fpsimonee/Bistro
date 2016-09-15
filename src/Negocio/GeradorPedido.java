/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author felipe
 */
public class GeradorPedido {
    private static int ID = 100;
   
    public static int getProximoPedido(){
     return ID++;
    }
}
