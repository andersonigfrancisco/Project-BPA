/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Client;

import Controllers.Coin.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author THL
 */
public class TableModels extends AbstractTableModel {
    
   private ArrayList<Person> ListPerson;
   private String[] Colunas = {"id","Primeiro Nome","Ultimo Nome","Nif","Genero","Tipo de Pessoa","Data de Criação"};
   
   public TableModels()
   {
       this.ListPerson = new ArrayList<Person>();
   }   
    public void getdata(List<Person> index) throws Exception {
        ListPerson.clear(); 
        for(int i=0;i<index.size();i++)
        {
            if(index.get(i).Persontype.equals("Singular"))
            {
                ListPerson.add(index.get(i));
                fireTableDataChanged();
            }
           
        }
    }
    @Override
    public int getRowCount() {
        return this.ListPerson.size();
    }
    
    public int deleteElement(int rowIndex) {
       fireTableDataChanged();
        return ListPerson.get(rowIndex).id;
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
                return this.ListPerson.get(rowIndex).getId();
            case 1: 
                return this.ListPerson.get(rowIndex).getFirtName();
            case 2: 
                return this.ListPerson.get(rowIndex).getLastName();
            case 3: 
                return this.ListPerson.get(rowIndex).getNif();
            case 4: 
                return this.ListPerson.get(rowIndex).getGender();
            case 5: 
                return this.ListPerson.get(rowIndex).getPersontype();
            case 6: 
                return this.ListPerson.get(rowIndex).getCreatedat();
            default:
                return this.ListPerson.get(rowIndex);
        } 
    }
    @Override
    public String getColumnName(int columnIndex) {
        return this.Colunas[columnIndex];
    }
}
