package travel.managnment.system;

import java.awt.Color;

import javax.swing.JFrame;

public class UpdatePersonalDetails extends JFrame{
    UpdatePersonalDetails(){
        setBounds(450,200,850,550);
        getContentPane().setBackground(new Color(0,0,0));
        setLayout(null);
        setVisible(true);
        
    }
    public static void main(String[] args) {
        new UpdatePersonalDetails();
    }
}
