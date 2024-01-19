package travel.managnment.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class DashBoard extends JFrame implements ActionListener {
    public String username;
    JButton addPersonalDetails,updatePersonalDetails, viewPersonalDetails,deletPersonalDetails,checkPackages, bookPackages,viewPackages,viewhotles,bookhotle,about,calculator,paytm,destination,viewbookedhotle;



    DashBoard(String username){
        this.username=username;
        // setBounds(0,0,1600,1000);
        setExtendedState(JFrame.MAXIMIZED_BOTH);//auto set size accordiing to screen
        setLayout(null);


        //? Header section-------------------------------------------------------------------------
        //pannel 1
        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBounds(0,0,1600,70);
        p1.setBackground(new Color(0, 0, 0));
        add(p1);
   
        //icon
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/R name icon.png"));
        Image i2=i1.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(20,10,50,50);
        p1.add(icon);

        //heading text

        JLabel heading =new JLabel("Ranjan's Travelling");
        heading.setBounds(90,10,300,50);
        heading.setForeground(new Color(225,225,225));
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,30));
        p1.add(heading);

        //?Header end------------------------------------------------------------------------------

        //?hero section----------------------------------------------------------------------------
        //left-side pannel
        JPanel p2=new JPanel();
        p2.setLayout(null);
        p2.setBounds(0,70,300,900);
        p2.setBackground(new Color(0, 0, 0));
        add(p2);

        //?image
       
        //? left-side button
         addPersonalDetails=new JButton("Add Personal Details");
        addPersonalDetails.setBounds(0,0,300,50);
        addPersonalDetails.setBackground(new Color(0,0,0));
        addPersonalDetails.setForeground(Color.WHITE);
        addPersonalDetails.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        addPersonalDetails.setBorder(new LineBorder(new Color(0,0,0)));
        addPersonalDetails.addActionListener(this);
        p2.add(addPersonalDetails);


         updatePersonalDetails=new JButton("Update Personal Details");
        updatePersonalDetails.setBounds(0,50,300,50);
        updatePersonalDetails.setBackground(new Color(0,0,0));
        updatePersonalDetails.setForeground(Color.WHITE);
        updatePersonalDetails.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        updatePersonalDetails.setBorder(new LineBorder(new Color(0,0,0)));
        p2.add(updatePersonalDetails);

         viewPersonalDetails=new JButton("View Details");
        viewPersonalDetails.setBounds(0,100,300,50);
        viewPersonalDetails.setBackground(new Color(0,0,0));
        viewPersonalDetails.setForeground(Color.WHITE);
        viewPersonalDetails.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        viewPersonalDetails.setBorder(new LineBorder(new Color(0,0,0)));
        p2.add(viewPersonalDetails);

        
         deletPersonalDetails=new JButton("Delet Personal Details");
        deletPersonalDetails.setBounds(0,150,300,50);
        deletPersonalDetails.setBackground(new Color(0,0,0));
        deletPersonalDetails.setForeground(Color.WHITE);
        deletPersonalDetails.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        deletPersonalDetails.setBorder(new LineBorder(new Color(0,0,0)));
        p2.add(deletPersonalDetails);


         checkPackages=new JButton("Check Packages");
        checkPackages.setBounds(0,200,300,50);
        checkPackages.setBackground(new Color(0,0,0));
        checkPackages.setForeground(Color.WHITE);
        checkPackages.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        checkPackages.setBorder(new LineBorder(new Color(0,0,0)));
        p2.add(checkPackages);


        
         bookPackages=new JButton("Book Packages");
        bookPackages.setBounds(0,250,300,50);
        bookPackages.setBackground(new Color(0,0,0));
        bookPackages.setForeground(Color.WHITE);
        bookPackages.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        bookPackages.setBorder(new LineBorder(new Color(0,0,0)));
        p2.add(bookPackages);


         viewPackages=new JButton("View Packages");
        viewPackages.setBounds(0,300,300,50);
        viewPackages.setBackground(new Color(0,0,0));
        viewPackages.setForeground(Color.WHITE);
        viewPackages.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        viewPackages.setBorder(new LineBorder(new Color(0,0,0)));
        p2.add(viewPackages);

         viewhotles=new JButton("View Hotles");
        viewhotles.setBounds(0,350,300,50);
        viewhotles.setBackground(new Color(0,0,0));
        viewhotles.setForeground(Color.WHITE);
        viewhotles.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        viewhotles.setBorder(new LineBorder(new Color(0,0,0)));
        p2.add(viewhotles);


         bookhotle=new JButton("Book Hotle");
        bookhotle.setBounds(0,400,300,50);
        bookhotle.setBackground(new Color(0,0,0));
        bookhotle.setForeground(Color.WHITE);
        bookhotle.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        bookhotle.setBorder(new LineBorder(new Color(0,0,0)));
        p2.add(bookhotle);

         viewbookedhotle=new JButton("View Booked Hotle");
        viewbookedhotle.setBounds(0,450,300,50);
        viewbookedhotle.setBackground(new Color(0,0,0));
        viewbookedhotle.setForeground(Color.WHITE);
        viewbookedhotle.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        viewbookedhotle.setBorder(new LineBorder(new Color(0,0,0)));
        p2.add(viewbookedhotle);

        
          destination=new JButton("Destinations");
        destination.setBounds(0,500,300,50);
        destination.setBackground(new Color(0,0,0));
        destination.setForeground(Color.WHITE);
        destination.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        destination.setBorder(new LineBorder(new Color(0,0,0)));
        p2.add(destination);

         
          paytm=new JButton("Payment");
        paytm.setBounds(0,550,300,50);
        paytm.setBackground(new Color(0,0,0));
        paytm.setForeground(Color.WHITE);
        paytm.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        paytm.setBorder(new LineBorder(new Color(0,0,0)));
        p2.add(paytm);

          calculator=new JButton("Calculator");
        calculator.setBounds(0,600,300,50);
        calculator.setBackground(new Color(0,0,0));
        calculator.setForeground(Color.WHITE);
        calculator.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        calculator.setBorder(new LineBorder(new Color(0,0,0)));
        p2.add(calculator);

          about=new JButton("About");
        about.setBounds(0,650,300,50);
        about.setBackground(new Color(0,0,0));
        about.setForeground(Color.WHITE);
        about.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        about.setBorder(new LineBorder(new Color(0,0,0)));
        p2.add(about);

         ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/2st welcome image.jpg"));
        Image i5=i4.getImage().getScaledInstance(1300, 800, Image.SCALE_SMOOTH);
        ImageIcon i6=new ImageIcon(i5);
        JLabel image=new JLabel(i6);
        image.setBounds(150, 0, 1450, 800);
        add(image);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==addPersonalDetails) {
            new AddCustomer(username);
        }
    }


    public static void main(String[] args) {
        new DashBoard("");
    }
}
