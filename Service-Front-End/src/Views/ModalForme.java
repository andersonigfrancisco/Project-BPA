/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

/**
 *
 * @author THL
 */
public class ModalForme extends JFrame{
    
    public ModalForme(JFrame form){
        
        if(form!=null){
            JInternalFrame iframe  = new JInternalFrame("Modal");
            add(iframe);
            setExtendedState(MAXIMIZED_BOTH);
            setLayout(new GridLayout(1, 2));
            setUndecorated(true);
            setBackground(new Color(58, 58, 0, 58));
            setLocationRelativeTo(null);
            setVisible(true);
            form.setVisible(true);
        }       
        else{
            Frame[] frames = getFrames(); 
        
            for (int i = 0; i < frames.length; i++) 
            { 
                if(i!=1)
                    frames[i].dispose();
            }
            /*
            for (Frame frame : frames)
                System.out.println(frame.getName() + ": " + frame.getClass());
            }
            */
        }
    }
}
