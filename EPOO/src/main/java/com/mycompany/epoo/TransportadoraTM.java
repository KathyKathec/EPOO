/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.epoo;


import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author K
 */
public class TransportadoraTM extends AbstractTableModel  {
    
   // private List<String[]> cargas;
    private ArrayList <Transportadora> registro;
    private String[] colunas = new String[]{"Nome do Remetente","Destinatario","Volume de carga","Distancia em Km","Valor total"};
    
    public TransportadoraTM() {
    }
    
    public TransportadoraTM(ArrayList<Transportadora> lista) {
        registro = new ArrayList<Transportadora>(lista);
    }
    public ArrayList<Transportadora> returnArray(){
        return this.registro;
    }
 
    
    @Override
    public int getColumnCount() {        
        return colunas.length;
    }
    
    @Override
    public int getRowCount() {
        return registro.size();
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        
        switch(columnIndex){
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return Float.class;
            case 3:
                return Float.class;
            case 4:
                return Double.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }/*
    public Object getValue() {
        Transportadora t = linhas.f
        
    }*/
    
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Transportadora t = registro.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return t.getNomeRemetente();
            case 1:
                return t.getNomeClienteDestino();
            case 2:
                return t.getVolumeCarga();
            case 3:
                return t.getDistancaoCidadeDestino();
            case 4:
                return t.getValorDaCarga();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    //pegar uma linha, por ex 0, e devolver um array de string, esse array de string tem que ser os novos dados inseridos no arrayList
    // https://www.youtube.com/watch?v=hFOKyKtiZ5o&t=120s
    /*
    
    public List<String[]> getValue(int rowIndex) {
        Transportadora t = linhas.get(rowIndex);
        List<String[]> dados;
        String[] array;
       // System.out.println(t.toString()); //teste
        t.getNomeRemetente().toString()
        
        
       List<String[]>list;
         list= 
                 /*{t.getNomeRemetente(),t.getNomeClienteDestino(),t.getVolumeCarga(),t.getDistancaoCidadeDestino(),t.getValorDaCarga()};
        return dados;
        
     return dados;
                 }
        */
    @Override
    //modifica na linha e coluna especificada
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Transportadora t = registro.get(rowIndex); // Carrega o item da linha que deve ser modificado

        switch (columnIndex) { // Seta o valor do campo respectivo
            case 0:
                t.setNomeRemetente(aValue.toString());
                break;
            case 1:
                t.setNomeClienteDestino(aValue.toString());
                break;
            case 2:
                t.setVolumeCarga(Float.parseFloat(aValue.toString()));
                break;
            case 3:
                t.setDistancaoCidadeDestino(Float.parseFloat(aValue.toString()));
                break;
            case 4:
                t.setValorDaCarga(Double.parseDouble(aValue.toString()));
                break;
            default:
                // Isto não deveria acontecer...             
        }
        fireTableCellUpdated(rowIndex, columnIndex);
     }
    
    //modifica na linha especificada
    public void setValueAt(Transportadora aValue, int rowIndex) {
        Transportadora t = registro.get(rowIndex); // Carrega o item da linha que deve ser modificado
        
        t.setNomeRemetente(aValue.getNomeRemetente());
        t.setNomeClienteDestino(aValue.getNomeClienteDestino());
        t.setVolumeCarga(aValue.getVolumeCarga());
        t.setDistancaoCidadeDestino(aValue.getDistancaoCidadeDestino());
        t.setValorDaCarga(aValue.getValorDaCarga());
        
        fireTableCellUpdated(rowIndex, 0);
        fireTableCellUpdated(rowIndex, 1);
        fireTableCellUpdated(rowIndex, 2);
        fireTableCellUpdated(rowIndex, 3);
        fireTableCellUpdated(rowIndex, 4);
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    //pega os registros da lista e array list transportadora
    public Transportadora getTransportadora(int indiceLinha) {
        return registro.get(indiceLinha);
    }
    
    public void addTransportadora(Transportadora t) {
        // Adiciona o registro.
        registro.add(t);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }
    
     /* Remove a linha especificada. */
    public void remove(int indiceLinha) {
        registro.remove(indiceLinha);
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }
      

    /* Adiciona uma lista de transportadora ao final dos registros. */
    public void addLista(List<Transportadora> t) {
        // Pega o tamanho antigo da tabela.
        int tamanhoAntigo = getRowCount();

        // Adiciona os registros.
        registro.addAll(t);
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }

    /* Remove todos os registros. */
    public void limpar() {
        registro.clear();
        fireTableDataChanged();
    }

    /* Verifica se este table model esta vazio. */
    public boolean isEmpty() {
        return registro.isEmpty();
    }   
    
    
}
