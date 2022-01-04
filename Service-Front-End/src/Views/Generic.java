/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import javax.swing.*;

/**
 *
 * @author THL
 */
public class Generic {
    
    public Generic(){}
    
    public void cenetricon(String src, JLabel pn)
    {
       ImageIcon iconlog = new ImageIcon(src);
       iconlog.setImage(iconlog.getImage().getScaledInstance(pn.getWidth(), pn.getHeight(), 1));
       pn.setIcon(iconlog);
    }
    
}
