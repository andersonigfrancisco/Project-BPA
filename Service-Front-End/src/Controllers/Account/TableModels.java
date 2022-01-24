/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author THL
 */
public class TableModels extends AbstractTableModel {
    
   private  ArrayList<Account> ListAccount;
   private  String[] Colunas = {"Numero da conta","Iban","Estado","Montante","Nome da empresa","Nif","Designação","Descrição","Tipo de Conta","Tipo de Moeda","Data de abertura da conta"};
   
   public TableModels()
   {
       this.ListAccount = new ArrayList<Account>();
   }   
    public void getdata(List<Account> index) throws Exception {
        ListAccount.clear(); 
        for(int i=0;i<index.size();i++)
        {
            ListAccount.add(index.get(i));
            fireTableDataChanged();
        }
    }
    
   
    @Override
    public int getRowCount() {
        return this.ListAccount.size();
    }
    
    public int deleteElement(int rowIndex) {
       fireTableDataChanged();
        return ListAccount.get(rowIndex).id;
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
                return this.ListAccount.get(rowIndex).getAccountnumber();
            case 1: 
                return this.ListAccount.get(rowIndex).getIban();
            case 2: 
                return this.ListAccount.get(rowIndex).getStatus();
            case 3: 
                return this.ListAccount.get(rowIndex).getAmount();
            case 4: 
                return this.ListAccount.get(rowIndex).getPerson().firtname;
            case 5: 
                return this.ListAccount.get(rowIndex).getPerson().nif;
            case 6: 
                return this.ListAccount.get(rowIndex).getTypeAccount().designation;
            case 7: 
                return this.ListAccount.get(rowIndex).getCoin().sigla;
            case 8: 
                return this.ListAccount.get(rowIndex).getOpenat();
            default:
                return this.ListAccount.get(rowIndex);
        } 
    }
    @Override
    public String getColumnName(int columnIndex) {
        return this.Colunas[columnIndex];
    }
}


 