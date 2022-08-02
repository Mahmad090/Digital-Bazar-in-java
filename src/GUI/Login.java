package GUI;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

public class Login {

    private connection c;
    private customer cus;
    public Login() throws SQLException {
        JFrame f1=new JFrame("Log In");
        JLabel user=new JLabel("Enter Username:");
        JLabel pass=new JLabel("Enter Password:");
        JTextField _user=new JTextField(20);
        JTextField empty=new JTextField(30);
        empty.setEditable(false);
        empty.setBackground(Color.orange);
        empty.setBorder(null);
        JTextField empty0=new JTextField(30);
        empty0.setEditable(false);
        empty0.setBackground(Color.orange);
        empty0.setBorder(null);
        JTextField _pass=new JTextField(20);
        JButton sub=new JButton("LogIn");
        f1.add(user);
        f1.add(_user);
        f1.add(empty);
        f1.add(pass);
        f1.add(_pass);
        f1.add(empty0);
        f1.add(sub);
        sub.addActionListener(e1 -> {
            if(_user.getText().equals("")||_pass.getText().equals(""))
            {
                JOptionPane.showMessageDialog(f1,"Please filled All Fields","Alert",JOptionPane.WARNING_MESSAGE);
            }
            else
            {
                try {
                    c=new connection();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                MainMenu m;
                try {
                    cus=c.login(_user.getText(),_pass.getText());
                    if(cus==null)
                    {
                        JOptionPane.showMessageDialog(f1,"User Not exist","Alert",JOptionPane.WARNING_MESSAGE);
                    }
                    else {
                        f1.setVisible(false);
                        m = new MainMenu(cus);
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

            }
        });
        f1.setBounds(600,100,400,200);
        f1.setVisible(true);
        f1.setLayout(new FlowLayout(FlowLayout.CENTER));
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setResizable(false);
        f1.getContentPane().setBackground(Color.orange);
    }
}
