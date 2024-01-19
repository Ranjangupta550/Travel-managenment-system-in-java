package travel.managnment.system;

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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import java.sql.*;

public class ForgetPassword extends JFrame implements ActionListener {

    // making globle variabl
    JTextField tusername, tname, tsecurityquestion, tanswer;
    JButton search, retrieve;
    JTextField tpassword;
    JButton back;

    ForgetPassword() {
        setBounds(300, 200, 820, 380);
        getContentPane().setBackground(new Color(0, 0, 0));
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setBounds(30, 30, 500, 280);
        p1.setBackground(new Color(0, 0, 0));
        p1.setLayout(null);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/ForgetPAsswordPNG.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580, 70, 230, 230);
        add(image);

        // username
        JLabel username = new JLabel("Username:");
        username.setBounds(40, 20, 140, 28);
        username.setForeground(new Color(255,255,255));
        username.setFont(new Font("SAN_SERIF", Font.BOLD, 20));

        p1.add(username);

        tusername = new JTextField();
        tusername.setBounds(180, 20, 150, 28);
        tusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tusername);

        // name
        JLabel name = new JLabel("Name:");
        name.setBounds(40, 60, 140, 28);
        name.setForeground(new Color(255,255,255));
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 20));

        p1.add(name);

        tname = new JTextField();
        tname.setBounds(180, 60, 150, 28);
        tname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tname);

        // security question
        JLabel securityquestion = new JLabel("security ques:");
        securityquestion.setBounds(40, 100, 200, 28);
        securityquestion.setForeground(new Color(255,255,255));
        securityquestion.setFont(new Font("SAN_SERIF", Font.BOLD, 20));

        p1.add(securityquestion);

        tsecurityquestion = new JTextField();
        tsecurityquestion.setBounds(180, 100, 150, 28);
        tsecurityquestion.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tsecurityquestion);

        // answer
        JLabel answer = new JLabel("Answer:");
        answer.setBounds(40, 140, 200, 28);
        answer.setForeground(new Color(255,255,255));
        answer.setFont(new Font("SAN_SERIF", Font.BOLD, 20));

        p1.add(answer);

        tanswer = new JTextField();
        tanswer.setBounds(180, 140, 150, 28);
        tanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tanswer);

        // password
        JLabel password = new JLabel("password:");
        password.setBounds(40, 180, 200, 28);
        password.setForeground(new Color(255,255,255));
        password.setFont(new Font("SAN_SERIF", Font.BOLD, 20));

        p1.add(password);

        tpassword = new JTextField();
        tpassword.setBounds(180, 180, 150, 28);
        tpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tpassword);

        // ?buttion

        // search button

        search = new JButton("Search");
        search.setBounds(350, 20, 105, 28);
        search.setBackground(new Color(254, 28, 28));
        search.setForeground(new Color(255, 255, 255));
        search.setBorder(new LineBorder(new Color(254, 28, 28)));
        search.addActionListener(this); // ?event on click for buttion
        p1.add(search);
        // retrive buttion
        retrieve = new JButton("retrive");
        retrieve.setBounds(350, 140, 105, 28);
        retrieve.setBackground(new Color(254, 28, 28));
        retrieve.setForeground(new Color(255, 255, 255));
        retrieve.setBorder(new LineBorder(new Color(254, 28, 28)));
        p1.add(retrieve);
        retrieve.addActionListener(this); // ?event on click for buttion

        // backbutton
        back = new JButton("Back");
        back.setBounds(180, 220, 105, 28);
        back.setBackground(new Color(254, 28, 28));
        back.setForeground(new Color(255, 255, 255));
        back.setBorder(new LineBorder(new Color(254, 28, 28)));
        back.addActionListener(this); // ?event on click for buttion
        p1.add(back);

        setVisible(true);
    }

    // action listner function override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            try {
                // ? its a DDl command
                // ?hitting commad quary by text field according to user
                String quary = "SELECT *  From  account where username = '" + tusername.getText() + "'";
                Connect c = new Connect();
                ResultSet rs = c.s.executeQuery(quary); // ddl command so we execute it by executeQuary(quary)
                // ? c.s.executeQuery(quary) --> return statmenet are stored in ResultSet rs
                while (rs.next()) {
                    tname.setText(rs.getString("name")); // return that value what we pass
                    tsecurityquestion.setText(rs.getString("security"));
                    // ?setText() set the value
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == retrieve) {
                  try {
                String quary = "SELECT *  From  account where answer = '" + tanswer.getText() + "' AND username = '"+tusername.getText()+"'";
                Connect c = new Connect();
                ResultSet rs = c.s.executeQuery(quary);
                // ? c.s.executeQuery(quary) --> return statmenet are stored in ResultSet rs
                while (rs.next()) {
                    tpassword.setText(rs.getString("password")); // return that value what we pass
                    // tsecurityquestion.setText(rs.getString("security"));
                    // ?setText() set the value
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {

        new ForgetPassword();
    }
}
