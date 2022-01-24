/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

/**
 *
 * @author THL
 */
public class MessageBox  extends JFrame{
    
    ImageIcon icon = new ImageIcon("src/imgs/logo.png");
    
     public MessageBox(){}
     
     public int show(String sms)
     {
         icon.setImage(icon.getImage().getScaledInstance(80, 100, 1));
        UIManager UI=new UIManager();
        UIManager.put("OptionPane.background",new ColorUIResource(255,255,255));
        UIManager.put("Panel.background",new ColorUIResource(255,255,255));
        UIManager.put("Button.background", Color.BLACK);
        UIManager.put("Button.foreground", Color.white);
        
        int input = JOptionPane.showConfirmDialog(null, sms, "Banco Popular de Angola",
	JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
        
        if(input!=0)
            new ModalForme(null);
        return input;
     }
}
