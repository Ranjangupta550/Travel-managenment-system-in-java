package travel.managnment.system;

import javax.swing.ImageIcon;

import java.awt.Image; //Image class abailabe in side awt pakage

// import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Splash extends JFrame implements Runnable {
    Thread thread;

    Splash() {
        // setSize(1200, 600);

        // setLocation(180, 150);
        ImageIcon i1 = new ImageIcon(
                ClassLoader.getSystemResource("icons/WhatsApp Image 2023-12-26 at 18.55.14_56eb90fd.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 500,0);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel images = new JLabel(i3);
        add(images);

        setVisible(true);
        thread=new Thread(this);
        thread.start();
        
    }
    public void run(){
        try{
            Thread.sleep(4000);
            setVisible(false);
            new Login();
        }
        catch(Exception e){

        }
    }

    public static void main(String[] args) {
        // new Splash(); 
        Splash frame = new Splash();
        int x=1;
        for(int i=1;i<=500;x+=7,i+=6){
            frame.setLocation(750-(x+i)/2,400-(i/2));
            frame.setSize(x+i, i);
            try {
                Thread.sleep(8);
            } catch (Exception e) {
               
            }
        }
    }
}
