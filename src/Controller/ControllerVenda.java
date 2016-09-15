/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Pojo.Produto;
import Pojo.Venda;
import java.util.ArrayList;

/**
 *
 * @author felipe
 */
public class ControllerVenda {
    private ArrayList<Venda> lista;
    private static ControllerVenda instanceCont;
    
     public ControllerVenda(){
      this.lista = new ArrayList<Venda>();
    }
     
    // Obtendo uma unica instancia desta classe, afinal é um controller
    public static ControllerVenda obterInstancia(){
       if(instanceCont == null)
          instanceCont = new ControllerVenda();
       // se a variável estática for nula, eu crio uma instancia. Caso contrário, 
       // eu já tenho um instancia da classe, logo, so retorno esta instancia.
       return instanceCont;
    }
    
    public ArrayList<Venda> listarTodos(){
       return this.lista;
    }
    
    // Aplicaçao vai ser simples então vou verificar pelo Codigo
    public int verificaExistencia(Venda venda){
    int retorno = -1; // caso negativo 
    
        for(int i= 0; i< this.lista.size();i++){
         if(venda.getCodigoPedido() == this.lista.get(i).getCodigoPedido())
             retorno = i;
             break; //sai do laço retornando o indice se existir produto na lista 
        }
        return retorno;
    }
    
    // pensar em como inserir a questão do codigo aqui 
    public void inserir(Venda venda) throws Exception{
      if(venda == null)
          throw new Exception("Venda não finalizada!");
      
      // numero gerado automaticamente
      if(venda.getCodigoPedido() <= 0 )
          throw new Exception("Informe o código da Venda.");
      
      if(venda.getData() == null)
          throw new Exception("Informe a data da Venda."); 
      
      if(venda.getData().trim().equals(""))
          throw new Exception("Informe a data da Venda.");
      
      if(venda.getItensDaVenda().size() <=0)
          throw new Exception("Informe pelo menos um item para haver uma venda.");
       
      
      if(this.verificaExistencia(venda) >= 0)
          throw new Exception("A venda informada já foi cadastrado.");
      
      this.lista.add(venda);
    
    }
    
    public void remover(Venda venda) throws Exception{
      if(venda == null)
          throw new Exception("Venda não finalizada!");
      
      // numero gerado automaticamente
      if(venda.getCodigoPedido() <= 0 )
          throw new Exception("Informe o código da Venda.");
         
       if(this.verificaExistencia(venda) == -1)
          throw new Exception("A venda informada não foi realizada.");
      
      this.lista.remove(this.verificaExistencia(venda));
    }
    
    public void atualizar(Venda venda) throws Exception{
    if(venda == null)
          throw new Exception("Venda não finalizada!");
      
      // numero gerado automaticamente
      if(venda.getCodigoPedido() <= 0 )
          throw new Exception("Informe o código da Venda.");
      
      if(venda.getData() == null)
          throw new Exception("Informe a data da Venda."); 
      
      if(venda.getData().trim().equals(""))
          throw new Exception("Informe a data da Venda.");
      
       if(venda.getItensDaVenda().size() <=0)
          throw new Exception("Informe pelo menos um item para haver uma venda.");
             
      
      if(this.verificaExistencia(venda) >= 0)
          throw new Exception("A venda informada já foi cadastrado.");
      
      this.lista.set(this.verificaExistencia(venda),venda);   
    
    }
    
       
}
