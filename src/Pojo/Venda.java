/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojo;

import java.util.ArrayList;

/**
 *
 * @author felipe
 */
public class Venda {
    private String data;
    private int CodigoPedido;
    private ArrayList<ItemVenda> itensDaVenda;
    
    
    public Venda(int CodigoCliente){
      this.itensDaVenda = new ArrayList<ItemVenda>();
      
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getCodigoPedido() {
        return CodigoPedido;
    }

    public void setCodigoPedido(int CodigoPedido) {
        this.CodigoPedido = CodigoPedido;
    }

    public ArrayList<ItemVenda> getItensDaVenda() {
        return itensDaVenda;
    }

    public void setItensDaVenda(ArrayList<ItemVenda> itensDaVenda) {
        this.itensDaVenda = itensDaVenda;
    }  
    
    public float getValorTotal(){
      float retorno = 0;
      for(int i=0; i<this.itensDaVenda.size();i++){
       float valor = (this.itensDaVenda.get(i).getQuantidade()*this.itensDaVenda.get(i).getUnitprice());
       retorno = retorno + valor;
      }
      return retorno; 
    }
    
    
}
