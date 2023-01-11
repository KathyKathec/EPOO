/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.epoo;

import static com.mycompany.epoo.FrameTransportadora.PATH_Caminhao;
import static com.mycompany.epoo.FrameTransportadora.PATH_Historial;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author UTEC-5695
 */
public class Estruturas {
    
    public static ArrayList<Transportadora> cargaCaminhao =Arquivos.Ler(PATH_Caminhao);

    public static ArrayList<Transportadora> stock= new ArrayList<>(); 
    
    public static ArrayList<Transportadora> historial=Arquivos.Ler(PATH_Historial);

   public static Stack <Transportadora> pilhaEncomenda = new Stack<>();
    
   
   
    
   
 
    public static void atualizaCaminhao() {
   
   cargaCaminhao.clear();
   
    for(int i=0; i<pilhaEncomenda.size(); i++){
        Transportadora t=pilhaEncomenda.get(i);
       cargaCaminhao.add(t);
        
        }
        try {
            Arquivos.EscritaCargas(cargaCaminhao, PATH_Caminhao);
        } catch (IOException ex) {
            Logger.getLogger(Estruturas.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }

   
    public static void carregarCaminhao(){// este metodo vai popular o caminhao
   
    Collections.sort(cargaCaminhao);
        for(int i=0; i<cargaCaminhao.size(); i++){
        Transportadora t=cargaCaminhao.get(i);
       pilhaEncomenda.push(t);
        
        }
                
                }
   /* public ArrayList<Transportadora> arrayOrdenado(){
        Collections.sort(cargaCaminhao);
        return  cargaCaminhao;
        
    }
    */

    static String getStringPilhaEncomenda() {
    String registros="Lista de encomendas para entregar:"+"\n";
    int j=0;
        for (int i=pilhaEncomenda.size()-1; i>=0; i--) {
                    Transportadora t=pilhaEncomenda.get(i);
                    registros+=j+" - "+ "Cliente Destino: "+t.getNomeClienteDestino()+"\n "+ "\n "+
                  "Volume da carga: "+String.valueOf(t.getVolumeCarga())+
                  "\n "+ "\n "+"Distancia: "+String.valueOf(t.getDistancaoCidadeDestino()) +  "\n" + "\n ";
            j++;
        }
    return registros;
    
    }
     static String getStringHistorial() {
    String registros="Lista de encomendas entregues:"+"\n";
    int i=0;
        for (Transportadora t : historial) {
                    registros+=i+" - "+ "Cliente Destino: "+t.getNomeClienteDestino()+"\n "+ "\n "+
                  "Volume da carga: "+String.valueOf(t.getVolumeCarga())+
                  "\n "+ "\n "+"Distancia: "+String.valueOf(t.getDistancaoCidadeDestino()) +  "\n" + "\n ";
            i++;
        }
    return registros;
    
    }
    public static void descarregaCaminhao() {
             
        historial.add(pilhaEncomenda.peek());
        
         JOptionPane.showMessageDialog(null,pilhaEncomenda.peek().getNomeClienteDestino()+"\n"+pilhaEncomenda.peek().getDistancaoCidadeDestino(),"Entrega feita com sucesso para:",0);
        pilhaEncomenda.pop();
        
                
    }
    public static void guardaHistorial(){
         try {
    
            Arquivos.EscritaCargas(historial, PATH_Historial);
        } catch (IOException ex) {
            Logger.getLogger(Estruturas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
     public static String cidade() {
           if(pilhaEncomenda.peek().getDistancaoCidadeDestino()==400){
               return "Rio Grande";
           }else {
               if(pilhaEncomenda.peek().getDistancaoCidadeDestino()==340){
                   return "Pelotas";
               }else{
                   return "Bage";
               }
           }
    
        
         
        
                
    }
   
   
   
   
}
