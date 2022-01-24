/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Client;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author THL
 */
public class TableModelscompany extends AbstractTableModel {
    
   private final ArrayList<Companies> ListCompanies;
   private final String[] Colunas = {"id","Nome da empresa","Nif","Designação","Descrição","Data de Criação"};
   
   public TableModelscompany()
   {
       this.ListCompanies = new ArrayList<Companies>();
   }   
    public void getdata(List<Companies> index) throws Exception {
        ListCompanies.clear(); 
        for(int i=0;i<index.size();i++)
        {
            ListCompanies.add(index.get(i));
            fireTableDataChanged();
        }
    }
    @Override
    public int getRowCount() {
        return this.ListCompanies.size();
    }
    
    public int deleteElement(int rowIndex) {
       fireTableDataChanged();
        return ListCompanies.get(rowIndex).id;
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
                return this.ListCompanies.get(rowIndex).getId();
            case 1: 
                return this.ListCompanies.get(rowIndex).getPerson().firtname;
            case 2: 
                return this.ListCompanies.get(rowIndex).getPerson().nif;
            case 3: 
                return this.ListCompanies.get(rowIndex).getDesignation();
            case 4: 
                return this.ListCompanies.get(rowIndex).getDescription();
            case 5: 
                return this.ListCompanies.get(rowIndex).getCreatedat();
            default:
                return this.ListCompanies.get(rowIndex);
        } 
    }
    @Override
    public String getColumnName(int columnIndex) {
        return this.Colunas[columnIndex];
    }
}
