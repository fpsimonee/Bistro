/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Pojo.Produto;
import java.util.ArrayList;

/**
 *
 * @author felipe
 */
public class ControllerProduto {
    private ArrayList<Produto> lista;
    private static ControllerProduto instanceCont;
    
     public ControllerProduto(){
      this.lista = new ArrayList<Produto>();
    }
    
    // Obtendo uma unica instancia desta classe, afinal é um controller
    public static ControllerProduto obterInstancia(){
       if(instanceCont == null)
          instanceCont = new ControllerProduto();
       // se a variável estática for nula, eu crio uma instancia. Caso contrário, 
       // eu já tenho um instancia da classe, logo, so retorno esta instancia.
       return instanceCont;
    }
    
    public ArrayList<Produto> listarTodos(){
       return this.lista;
    }
    
    // Aplicaçao vai ser simples então vou verificar pelo descricao
    public int verificaExistencia(Produto prod){
    int retorno = -1; // caso negativo 
    
        for(int i= 0; i< this.lista.size();i++){
         if(prod.getDescricao().trim().equalsIgnoreCase(this.lista.get(i).getDescricao().trim()))
             retorno = i;
             break; //sai do laço retornando o indice se existir produto na lista 
        }
        return retorno;
    }
    
    // pensar em como inserir a questão do codigo aqui 
    public void inserir(Produto prod) throws Exception{
      if(prod == null)
          throw new Exception("Cliente não foi cadastrado!");
          
      if(prod.getDescricao()== null)
          throw new Exception("Informe a Descricao do produto.");
      
      if(prod.getDescricao().trim().equals(""))
          throw new Exception("Informe a Descricao do produto.");
      
       if(prod.getPrice() == 0)
          throw new Exception("Informe o Preco do Produto.");   
      
      if(this.verificaExistencia(prod) >= 0)
          throw new Exception("Produto informado já foi cadastrado.");
      
      this.lista.add(prod);
    
    }
    
    public void remover(Produto prod) throws Exception{
      if(prod == null)
          throw new Exception("Cliente não foi cadastrado!");
      
      if(prod.getDescricao()== null)
          throw new Exception("Informe a Descricao do produto.");
      
      if(prod.getDescricao().trim().equals(""))
          throw new Exception("Informe a Descricao do produto.");     
       
      
       if(this.verificaExistencia(prod) == -1)
          throw new Exception("Produto informado não foi cadastrado.");
      
      this.lista.remove(this.verificaExistencia(prod));
    }
    
    public void atualizar(Produto prod) throws Exception{
    if(prod == null)
          throw new Exception("Cliente não foi cadastrado!");
          
      if(prod.getDescricao()== null)
          throw new Exception("Informe a Descricao do produto.");
      
      if(prod.getDescricao().trim().equals(""))
          throw new Exception("Informe a Descricao do produto.");
      
       if(prod.getPrice() == 0)
          throw new Exception("Informe o Preco do Produto.");       
       
      if(this.verificaExistencia(prod) >= 0)
          throw new Exception("Produto informado já foi cadastrado.");
      
      this.lista.set(this.verificaExistencia(prod),prod);   
    
    }
    
}
