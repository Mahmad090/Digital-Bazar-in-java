package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MainPanel implements ActionListener {
    private Login l;
    private signup s;
    JFrame f0 = new JFrame("Digital Bazar");
    ImageIcon log = new ImageIcon("D:\\java\\Project\\practice\\img\\login.png");
    ImageIcon sig= new ImageIcon("D:\\java\\Project\\practice\\img\\signup.png");
    JTextField empty=new JTextField(10);
    JTextField empty0=new JTextField(21);
    JLabel login = new JLabel(log);
    JLabel signup = new JLabel(sig);
    JButton _log=new JButton("Log In");
    JButton _sign=new JButton("Sign up");
    public MainPanel()
    {

        empty.setEditable(false);
        empty.setBorder(null);
        empty.setBackground(Color.ORANGE);

        empty0.setEditable(false);
        empty0.setBorder(null);
        empty0.setBackground(Color.ORANGE);

        _log.addActionListener( this);
        _sign.addActionListener(this);
        f0.add(login);
        f0.add(empty);
        f0.add(signup);
        f0.add(_log);
        f0.add(empty0);
        f0.add(_sign);
        f0.setBounds(600,100,600,300);
        f0.setVisible(true);
        f0.setLayout(new FlowLayout(FlowLayout.CENTER));
        f0.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f0.setResizable(false);
        f0.getContentPane().setBackground(Color.orange);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(_log))
        {
            f0.setVisible(false);
            try {
                l=new Login();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } else if (e.getSource().equals(_sign)) {
            f0.setVisible(false);
            try {
                s=new signup(f0);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}