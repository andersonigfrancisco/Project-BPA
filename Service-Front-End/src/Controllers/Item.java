/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Controllers.Coin.Coin;
import Controllers.TypeAccount.TypeAccount;
import java.util.List;
import java.util.Vector;
import javax.swing.JComboBox;

/**
 *
 * @author THL
 */
public class Item
{
    public Item(){}
    private int key;
    private String value;
 
    public Item(int id, String description)
    {
        this.key = id;
        this.value = description;
    }
 
    public int getId()
    {
        return key;
    }
 
    public String getDescription()
    {
        return value;
    }
 
    public String toString()
    {
        return value;
    }
       
    public void getdatacmb(JComboBox cmb,List<Coin> index) throws Exception {
             
        
        for(int i=0;i<index.size();i++)
        {
           cmb.addItem( new Item(index.get(i).id, index.get(i).sigla) );
        }
       
    }
    
    public void getdatacmbtypeacount(JComboBox cmb,List<TypeAccount> index) throws Exception {
             
        for(int i=0;i<index.size();i++)
        {
           cmb.addItem( new Item(index.get(i).id, index.get(i).designation) );
        }
       
    }
}