package travel.managnment.system;




import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Signup extends JFrame implements ActionListener {    
    
    //??implements ActionListene for action event
    JButton createButton,backButton; //define globaly to use in Action listner
     JTextField tusername,tname,tpassword,tsecurity;
     Choice qsecurity;

    Signup(){ //signup page
        setBounds(350,200,850,450); //set size and frame pos
        getContentPane().setBackground(Color.GRAY);
        setLayout(null);

        JPanel p1=new JPanel(); //customise frame
        p1.setBackground(new Color(0, 0, 0));
        p1.setBounds(0,0,460,450);
        p1.setLayout(null);
        add(p1);
        //image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/Screenshot 2023-12-26 155802.png"));
        Image i2=i1.getImage().getScaledInstance(390, 450,Image.SCALE_SMOOTH);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image=new JLabel(i3);//i,age icon creat
        image.setBounds(460,0,390,450);
        add(image);//add on frame
     

        //for username 

         JLabel username = new JLabel("Username:");
         username.setFont(new Font("SAN_SERIF",Font.BOLD,20));
         username.setForeground(new Color(255,255,255));
         username.setBounds(70,20,210,30);
         p1.add(username);


        //textField for ussername
         tusername=new JTextField();
        tusername.setBounds(70,55,260,30);
        tusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tusername);
        setVisible(true);



        //lable for name

        JLabel name = new JLabel("Name:");
         name.setFont(new Font("SAN_SERIF",Font.BOLD,20));
         name.setForeground(new Color(255,255,255));
         name.setBounds(70,90,210,30);
         p1.add(name);
        //textField for name

         tname=new JTextField();
        tname.setBounds(70,125,260,30);
        tname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tname);

        //lable for password
        JLabel password = new JLabel("Password:");
         password.setFont(new Font("SAN_SERIF",Font.BOLD,20));
         password.setForeground(new Color(255,255,255));
         password.setBounds(70,160,210,30);
         p1.add(password);
        //textField for password

       tpassword=new JTextField();
        tpassword.setBounds(70,195,260,30);
        tpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tpassword);

        //text lable for security question
        JLabel security = new JLabel("Security Ques:");
         security.setFont(new Font("SAN_SERIF",Font.BOLD,20));
         security.setForeground(new Color(255,255,255));
         security.setBounds(70,232,150,30);
         p1.add(security);

         //Choice security question
        qsecurity =new Choice();
         qsecurity.add("What is pet name?");
         qsecurity.add("What is your favourite place?");
         qsecurity.add("What is your school name?");
         qsecurity.add("What is your favourite movie?");
         qsecurity.setBounds(70,268,155,25);
         p1.add(qsecurity);
        //swcurity qustext field
         tsecurity=new JTextField();
        tsecurity.setBounds(230,266,100,25);
        tsecurity.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tsecurity);

        //Buttion

        //create button
        createButton=new JButton("Create");
        createButton.setBounds(70,300,105,35);
        createButton.setBackground(new Color(254,28,28));
        createButton.setForeground(new Color(255,255,255));
        createButton.setBorder(new LineBorder(new Color(254,28,28)));
        createButton.addActionListener(this); //?event on click for buttion
        p1.add(createButton);
        //back buttion
        backButton=new JButton("Back");
        backButton.setBounds(227,300,105,35);
        backButton.setBackground(new Color(254,28,28));
        backButton.setForeground(new Color(255,255,255));
        backButton.setBorder(new LineBorder(new Color(254,28,28)));
        backButton.addActionListener(this); //?event on click for buttion
        p1.add(backButton);


        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){ //?ActionEvent ae give source of event 


        if(ae.getSource()==createButton){ //give source of buttion call
            String username=tusername.getText(); //? getText()  function return string 
            String name=tname.getText(); //
            String password=tpassword.getText(); 
            String question=qsecurity.getSelectedItem(); //?getSelectedItem() return choiceof selected item
            String answer=tsecurity.getText();

            String quary ="insert into account values ('"+username+"','"+name+"','"+password+"','"+question+"','"+answer+"')";
            try {
                Connect c=new Connect();
                c.s.executeUpdate(quary);

                JOptionPane.showMessageDialog(null, "Account Created Sucessfully"); //popup message

                setVisible(false);
                new Login();


            } catch (Exception e) {
               e.printStackTrace();
            }

        }
        else if(ae.getSource()==backButton){
            setVisible(false);
            new Login();
        }

    }
    public static void main(String[] args) {
        new Signup();
    }
}
