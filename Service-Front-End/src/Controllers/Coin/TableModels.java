/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Coin;


import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author THL
 */
public class TableModels extends AbstractTableModel {
    
   private ArrayList<Coin> ListCoin;
   private String[] Colunas = {"id","Designação","Sigla"};;
   
   public TableModels()
   {
       this.ListCoin = new ArrayList<Coin>();
   }   
    public void getdata(List<Coin> index) throws Exception {
        ListCoin.clear(); 
        for(int i=0;i<index.size();i++)
        {
            ListCoin.add(index.get(i));
            fireTableDataChanged();
        }
    }
    @Override
    public int getRowCount() {
        return this.ListCoin.size();
    }
    
    public int deleteElement(int rowIndex) {
       fireTableDataChanged();
        return ListCoin.get(rowIndex).id;
    }

    @Override
    public int getColumnCount() {
        return Colunas.length;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        switch(columnIndex)
        {
            case 0: 
                return this.ListCoin.get(rowIndex).getId();
            case 1: 
                return this.ListCoin.get(rowIndex).getDesignation();
            case 2: 
                return this.ListCoin.get(rowIndex).getSigla();
            default:
                return this.ListCoin.get(rowIndex);
        } 
    }
    @Override
    public String getColumnName(int columnIndex) {
        return this.Colunas[columnIndex];
    }
}
