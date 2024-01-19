package travel.managnment.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame; //JFrame class availabe inside swing pakage ;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;//for  border

public class Login extends JFrame implements ActionListener{

        JTextField Tusernamae,Tpassword;
         JButton forget,login,signup;
        Login(){
            //defining constructor
            setSize(900,400);//frame for login window (both fun sinzide Jframe class)
            setLocation(300,200);//position of frame for login window
            setLayout(null);//to set default layout null (swing)
            getContentPane().setBackground(new Color(0,0,0));

            //login left side
            JPanel left_login_side=new JPanel(); //JPanel used to modify our window
            left_login_side.setBackground(new Color(0,0,0));//set background() used to set backgrount of frame ,create color obj for pass rgb value 
            left_login_side.setBounds(0, 0,400,400);
            left_login_side.setLayout(null);//to use p1.setbound()//if not null default center
            add(left_login_side);
            ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/Screenshot 2023-12-28 170948.png"));
            Image i2=i1.getImage().getScaledInstance(400, 400,Image.SCALE_SMOOTH);
            ImageIcon i3= new ImageIcon(i2);
            JLabel image=new JLabel(i3);//i,age icon creat
            image.setBounds(0,0,400,400);
            left_login_side.add(image);//add on frame

            //login side
            
            JPanel right_login_side=new JPanel();
            right_login_side.setLayout(null);
            right_login_side.setBackground(new Color(0,0,0));
            right_login_side.setBounds(420,30,440,300);
            add(right_login_side);
            //userlogin
            JLabel username=new JLabel("Username:");
            username.setBounds(60,20,110,50);
            username.setForeground(new Color(255,255,255));
            username.setFont(new Font("SAN_SERIF",Font.BOLD,20));
            right_login_side.add(username);
            Tusernamae=new JTextField();
            Tusernamae.setBounds(60,70,300,30);
            Tusernamae.setBorder(BorderFactory.createEmptyBorder());
            right_login_side.add(Tusernamae);
            //user password
            JLabel password=new JLabel("Password:");
            password.setBounds(60,100,110,50);
            password.setForeground(new Color(255,255,255));
            password.setFont(new Font("SAN_SERIF",Font.BOLD,20));
            right_login_side.add(password);
            Tpassword=new JTextField();
            Tpassword.setBounds(60,150,300,30);
            Tpassword.setBorder(BorderFactory.createEmptyBorder());
            right_login_side.add(Tpassword);
            
          
           
            // lodin button
            login=new JButton("Login");  //jButtion class for creatbutton
            login.setBounds(60, 200, 110, 30);
            login.setBackground(new Color(254,28,28));
            login.setForeground(new Color(255,255,255));
            login.setBorder(new LineBorder(new Color(254,28,28)));
            login.addActionListener(this);
            right_login_side.add(login);

            // signup button
            signup=new JButton("Sign up");  //jButtion class for creatbutton
            signup.setBounds(250, 200, 110, 30);
            signup.setBackground(new Color(254,28,28));
            signup.setForeground(new Color(255,255,255));
            signup.setBorder(new LineBorder(new Color(254,28,28)));
            signup.addActionListener(this);
            right_login_side.add(signup);

            //forget password
             forget=new JButton("Forget");  //jButtion class for creatbutton
            forget.setBounds(60, 245, 110, 30);
            forget.setBackground(new Color(254,28,28));
            forget.setForeground(new Color(255,255,255));
            forget.setBorder(new LineBorder(new Color(254,28,28)));
            forget.addActionListener(this);


            

            right_login_side.add(forget);

            //trouble login
            JLabel trouble_login=new JLabel("Trouble login in...");
            trouble_login.setBounds(175,245,110,30);
            trouble_login.setForeground(new Color(254,28,28));
           
            right_login_side.add(trouble_login);
            setVisible(true);
        }
       public  void actionPerformed(ActionEvent ae){
          if (ae.getSource()==login) {
              try {
                String username=Tusernamae.getText();
                String password=Tpassword.getText();

                String query="select * from account where username = '"+username+"' AND password = '"+password+"'";
                Connect c=new Connect();
                ResultSet result=c.s.executeQuery(query);
                if (result.next()) {
                  setVisible(false);
                  new Loading(username);
                }
                else{
                  JOptionPane.showMessageDialog(null,"Incorrect username or password");
                }
              } catch (Exception e) {
                e.printStackTrace();
              }
          }
          else if(ae.getSource()==signup){
            setVisible(false);
            new Signup();
          }
          else {
                setVisible(false);
            new ForgetPassword();
          }
        }
    public static void main(String[] args) {
            new Login(); //login call
    }
}
