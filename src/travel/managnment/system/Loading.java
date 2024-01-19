package travel.managnment.system;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class Loading extends JFrame implements Runnable {  //?for multithreading//
     Thread t;
     JProgressBar progress;
    public String username;

    public void run(){ //override
        try {
            boolean dashboardCreated = false; // Flag to track whether DashBoard is already created

            for(int i=0;i<=101;i++){
                int max=progress.getMaximum();
                int value=progress.getValue();
                if (value<max) {
                    progress.setValue(progress.getValue()+1);

                }
                else if(!dashboardCreated){
                    setVisible(false);
                    new DashBoard(username);
                    dashboardCreated=true;
                }
                Thread.sleep(30);
            }
            
        } catch (Exception e) {
           e.printStackTrace();
        }
    }

    Loading(String username){
        this.username=username;//local variable into global variable
        t=new Thread(this);
        setBounds(500,200,650,400);
        getContentPane().setBackground(new Color(0, 0, 0));
        setLayout(null);


        //?  Lable Section?//
        JLabel text=new JLabel("Travel and Tourism Application");
        text.setBounds(50,20,600,40);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("SAN_SERIF",Font.BOLD,35));
        add(text);

        JLabel pleasewait=new JLabel("Loaading Please wait...");
        pleasewait.setBounds(230,140,150,30);
        pleasewait.setForeground(Color.WHITE);
        pleasewait.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        add(pleasewait);

        JLabel Lusername =new JLabel("Welcome "+ username);
        Lusername.setBounds(20,310,400,30);
        Lusername.setForeground(Color.red);
        Lusername.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(Lusername);


        //?progress bar

        progress = new JProgressBar(); //add progresss bar
        progress.setBounds(150,100,300,30);
        progress.setStringPainted(true);//percentage
        add(progress);
        t.start();
        setVisible(true);
        
    }

    public static void main(String[] args) {
        new Loading("");
    }
}
