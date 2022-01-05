/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

/**
 *
 * @author THL
 */
public class ModalForme extends JFrame{
    
    public ModalForme(JFrame form){
        
        int i = 2;
        addMouseListener(new MouseAdapter() {
                @Override 
                public void mouseClicked(MouseEvent e) {
                    Frame[] frames = getFrames(); 
                    for (int j=i; j < frames.length; j++) 
                    { 
                        frames[j].dispose(); 
                    }
               }
            });
        
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
        
            for (int j = i; j < frames.length; j++) 
            { 
                frames[j].dispose();
            }
            /*
            for (Frame frame : frames)
                System.out.println(frame.getName() + ": " + frame.getClass());
            }
            */
        }
    }
}
