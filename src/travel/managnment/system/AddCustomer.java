package travel.managnment.system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.border.LineBorder;


public class AddCustomer extends JFrame implements ActionListener {
    JLabel lableusername,lablename;
    JTextField Tnumber,tcountry,taddress,tphone,temail;
    JComboBox<String> comboid; //for drop down menu
    
    JRadioButton rmale,rfemale;

    JButton add,back;

    AddCustomer(String username1){
        setBounds(450,200,850,550);
        getContentPane().setBackground(new Color(0,0,0));
        setLayout(null);

        //?Lables & text fields ----------------------------------------------------------
        JLabel username=new JLabel("Username");
        username.setBounds(30,50,150,25);
        username.setForeground(new Color(255,255,255));
        add(username);


        lableusername=new JLabel();
        lableusername.setBounds(220,50,150,25);
        lableusername.setForeground(new Color(255,0,0));
        add(lableusername);


        JLabel id=new JLabel("ID");
        id.setBounds(30,90,150,25);
        id.setForeground(new Color(255,255,255));
        add(id);
       
      
        comboid=new JComboBox<>(new String[] {"Passport","Adhar Card","Voter Id","Drivng Lisence","Pan Card"});
        comboid.setBounds(220,90,150,25);
        comboid.setBackground(new Color(234,234,234));
        comboid.setBorder(BorderFactory.createEmptyBorder());
        add(comboid);

        
        JLabel number=new JLabel("ID Number");
        number.setBounds(30,130,150,25);
        number.setForeground(new Color(255,255,255));
        add(number);

        Tnumber=new JTextField();
        Tnumber.setBounds(220,130,150,25);
        Tnumber.setBorder(BorderFactory.createEmptyBorder());
       
        add(Tnumber);
       

        JLabel name=new JLabel();
        name.setBounds(30,170,150,25);
        name.setForeground(new Color(255,255,255));
        add(name);


        lablename=new JLabel();
        lablename.setBounds(220,170,150,25);
        lablename.setForeground(new Color(255,0,0));
        add(lablename);

        JLabel gender=new JLabel("Gender");
        gender.setBounds(30,210,150,25);
        gender.setForeground(new Color(255,255,255));
        add(gender);


        rmale=new JRadioButton("Male");
        rmale.setBounds(220,210,70,25);
        rmale.setBackground(new Color(255,255,255));
        add(rmale);
        rfemale=new JRadioButton("Female");
        rfemale.setBounds(300,210,70,25);
        rfemale.setBackground(new Color(255,255,255));
        add(rfemale);

        ButtonGroup bg=new ButtonGroup(); //for select one buttion on single time
        bg.add(rfemale);
        bg.add(rmale);



        JLabel country=new JLabel("Country");
        country.setBounds(30,250,150,25);
        country.setForeground(new Color(255,255,255));
        add(country);

        tcountry=new JTextField();
        tcountry.setBounds(220,250,150,25);
        tcountry.setBorder(BorderFactory.createEmptyBorder());

        add(tcountry);


        JLabel address=new JLabel("Address");
        address.setBounds(30,290,150,25);
        address.setForeground(new Color(255,255,255));
        add(address);

        taddress=new JTextField();
        taddress.setBounds(220,290,150,25);
        taddress.setBorder(BorderFactory.createEmptyBorder());
        add(taddress);
        

        JLabel phone=new JLabel("Phone");
        phone.setBounds(30,330,150,25);
        phone.setForeground(new Color(255,255,255));
        add(phone);

        tphone=new JTextField();
        tphone.setBounds(220,330,150,25);
        tphone.setBorder(BorderFactory.createEmptyBorder());
        add(tphone);


        JLabel email=new JLabel("Email");
        email.setForeground(new Color(255,255,255));
        email.setBounds(30,370,150,25);
        add(email);

        temail=new JTextField();
        temail.setBounds(220,370,150,25);
        temail.setBorder(BorderFactory.createEmptyBorder());
        add(temail);
        
        //button
        add=new JButton("Add");  //jButtion class for creatbutton
        add.setBounds(70, 430, 100, 25);
        add.setBackground(new Color(254,28,28));
        add.setForeground(new Color(255,255,255));
        add.setBorder(new LineBorder(new Color(254,28,28)));
        add.addActionListener(this);
        add(add);

        back=new JButton("Back");  //jButtion class for creatbutton
        back.setBounds(220, 430, 100, 25);
        back.setBackground(new Color(254,28,28));
        back.setForeground(new Color(255,255,255));
        back.setBorder(new LineBorder(new Color(254,28,28)));
        back.addActionListener(this);
        add(back);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/travelling.png"));
        Image i2=i1.getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 50, 400, 400);
        add(image);
       
        try {
            Connect c=new Connect();
            ResultSet rs=c.s.executeQuery("select * from account where username = '"+username1+"'");
            while (rs.next()) {
                lableusername.setText(rs.getString("username"));
                lablename.setText(rs.getString("name"));
                 
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
       




        
        
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==add) {
            String username=lableusername.getText();
            String id=(String)comboid.getSelectedItem();//getSelectedItem(); return obj
            String number =Tnumber.getText();
            String name=lablename.getText();
            String gender=null;
            if (rmale.isSelected()) {
                gender="Male";
            }
            else{
                gender="Female";

            }
            String country=tcountry.getText();
            String address=taddress.getText();
            String phone=tphone.getText();
            String email=temail.getText();
            try {
                Connect c=new Connect();
                String quary="insert into customer values ('"+username+"','"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+address+"','"+phone+"','"+email+"')";
                c.s.executeUpdate(quary);//dml command 
                JOptionPane.showMessageDialog(null,"Customer details Added Sucessfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddCustomer("");
    }
    
    
}
