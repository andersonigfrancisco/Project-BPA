/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.TypeAccount;

import Controllers.Coin.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author THL
 */
public class TableModels extends AbstractTableModel {
    
   private ArrayList<TypeAccount> ListTypeAccount;
   private String[] Colunas = {"id","Designação","Codigo","Descrição"};
   
   public TableModels()
   {
       this.ListTypeAccount = new ArrayList<TypeAccount>();
   }   
    public void getdata(List<TypeAccount> index) throws Exception {
        ListTypeAccount.clear(); 
        for(int i=0;i<index.size();i++)
        {
            ListTypeAccount.add(index.get(i));
            fireTableDataChanged();
        }
    }
    
    
    
    @Override
    public int getRowCount() {
        return this.ListTypeAccount.size();
    }
    
    public int deleteElement(int rowIndex) {
       fireTableDataChanged();
        return ListTypeAccount.get(rowIndex).id;
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
                return this.ListTypeAccount.get(rowIndex).getId();
            case 1: 
                return this.ListTypeAccount.get(rowIndex).getDesignation();
            case 2: 
                return this.ListTypeAccount.get(rowIndex).getCode();
            case 3: 
                return this.ListTypeAccount.get(rowIndex).getDescription();
            default:
                return this.ListTypeAccount.get(rowIndex);
        } 
    }
    @Override
    public String getColumnName(int columnIndex) {
        return this.Colunas[columnIndex];
    }
}
