/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.epoo;

/**
 *
 * @author Kat
 */
public class Transportadora implements Comparable<Transportadora>{
    
   //constante para o valor do KM
public static float valorKm = (float) 1.17;
//Atributos
    private int id;
    private float distancaoCidadeDestino ;
    private double valorDaCarga;
    private String nomeClienteDestino;
    private String enderecoClienteDestino;
    private String telefoneClienteDestino;
    private String nomeRemetente;
    private String enderecoRemetente;
    private String telefoneRemetente;
    private float volumeCarga ;

    Transportadora(){
        
    }
    Transportadora(String nome, String nomeDes, float vol, float distancia, double valorCarga) {
        this.nomeRemetente=nome;
        this.nomeClienteDestino=nomeDes;
        this.volumeCarga=vol;
        this.distancaoCidadeDestino=distancia;
        this.valorDaCarga=valorCarga;
    }

//Metodos
    public int getId() {return id;}
    public void setId(int id) {this.id = id; }
  
    
    public void setValorDaCarga(double valorDaCarga){
        this.valorDaCarga=valorDaCarga;
    }
    public double getValorDaCarga(){
        return this.valorDaCarga;
    }
    
    public float getDistancaoCidadeDestino() {return distancaoCidadeDestino;}
    public void setDistancaoCidadeDestino(float distancaoCidadeDestino) {
        this.distancaoCidadeDestino = distancaoCidadeDestino;
    }

    public String getNomeClienteDestino() {return nomeClienteDestino;}
    public void setNomeClienteDestino(String nomeClienteDestino) {
        this.nomeClienteDestino = nomeClienteDestino;
    }

    public String getEnderecoClienteDestino() {return enderecoClienteDestino;}
    public void setEnderecoClienteDestino(String enderecoClienteDestino) {
        this.enderecoClienteDestino = enderecoClienteDestino;
    }

    public String getTelefoneClienteDestino() {return telefoneClienteDestino;}
    public void setTelefoneClienteDestino(String telefoneClienteDestino) {
        this.telefoneClienteDestino = telefoneClienteDestino;
    }

    public String getNomeRemetente() {return nomeRemetente;}
    public void setNomeRemetente(String nomeRemetente) {
        this.nomeRemetente = nomeRemetente;
    }

    public String getEnderecoRemetente() {return enderecoRemetente;}
    public void setEnderecoRemetente(String enderecoRemetente) {
        this.enderecoRemetente = enderecoRemetente;
    }

    public String getTelefoneRemetente() {return telefoneRemetente;}
    public void setTelefoneRemetente(String telefoneRemetente) {
        this.telefoneRemetente = telefoneRemetente;
    }

    public float getVolumeCarga() {
        return volumeCarga;
    }
    public void setVolumeCarga(float volumeCarga) {
        this.volumeCarga = volumeCarga;
    }

    @Override
    public int compareTo(Transportadora t) {
        if(this.distancaoCidadeDestino>t.getDistancaoCidadeDestino()){
            return -1; //este metodo compara as distacias, se for maior vai para frente (izquerda)
        } if(this.distancaoCidadeDestino<t.getDistancaoCidadeDestino()){
            return 1; // si es menor a la derecha
        }
        return 0;// si son iguales permanecen en la misma posicion
        
    }
}
