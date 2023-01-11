/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.epoo;

import com.opencsv.CSVReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/** para funcionar corretamente importar dependencia de open csv v3.8
 *	<groupId>com.opencsv</groupId>
	<artifactId>opencsv</artifactId>
	<version>3.8</version>
 * @author Kat
 */
public class Arquivos {
    
    public static void EscritaCargas (ArrayList<Transportadora> t, String path) throws IOException {
  
                try {
                    
                File x = new File(path);
               
                    
            FileWriter fw = new FileWriter(x); 
           
         BufferedWriter bf=new BufferedWriter(fw);
         PrintWriter writer = new PrintWriter(bf);
      
         //{"Nome do Remetente","Destinatario","Volume de carga","Distancia em Km","Valor total"});
		
         
         for(int i=0; i<t.size(); i++){
             writer.println(t.get(i).getNomeRemetente()+","+t.get(i).getNomeClienteDestino()
                     +","+t.get(i).getVolumeCarga()+","+t.get(i).getDistancaoCidadeDestino()
                     +","+t.get(i).getValorDaCarga());
                     }
         
         writer.close();
         bf.close();
         fw.close();
                }
         catch(IOException e){
                 e.getStackTrace();
                 JOptionPane.showMessageDialog(null, "Erro na escrita de dados...");
                 }
         
    }

    //*************************************************************************************  ler
     public static ArrayList<Transportadora> Ler(String path) {
       
         ArrayList<Transportadora>tr = new ArrayList<>();
         
         
    File arquivo = new File( path);
    CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(arquivo), ',');
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Arquivos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Arquivo nao encontrado!");
        }

    // ler linha a linha
		String[] record;
        try {
            while ((record = reader.readNext()) != null) {
                Transportadora t = new Transportadora();
                t.setNomeRemetente(record[0]);
                t.setNomeClienteDestino(record[1]);
                t.setVolumeCarga(Float.parseFloat(record[2]));
                t.setDistancaoCidadeDestino(Float.parseFloat(record[3]));
                t.setValorDaCarga(Double.parseDouble(record[4]));
                tr.add(t);
                
            }
            
            reader.close();
        } catch (IOException ex) {
            Logger.getLogger(Arquivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tr;
	}
} 
