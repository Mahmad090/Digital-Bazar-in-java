package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Objects;

public class rent implements ActionListener {
    JFrame sell = new JFrame("Sell");
    JLabel user = new JLabel();
    JPanel p0 = new JPanel();
    JPanel p1 = new JPanel();
    JScrollPane sc = new JScrollPane();
    JLabel balance = new JLabel();
    JLabel balanceL = new JLabel("Balance:");
    JLabel userL = new JLabel("User:");
    JLabel Pinfo = new JLabel("Product Information:");
    JButton binfo = new JButton("information");
    JButton bactive = new JButton("Active");
    JButton bfine = new JButton("Fine");
    JLabel active = new JLabel("Active Product List:");
    JLabel fine = new JLabel("Check Fine:");
    JButton back = new JButton("Go Back");
    JFrame temp = new JFrame();
   private customer ctemp;

    rent(customer c, JFrame f) {
        ctemp = c;
        temp = f;
        user.setText(c.getUsername());
        balance.setText(String.valueOf(c.getBalance()));
        p0.add(userL);
        p0.add(user);
        p0.add(balanceL);
        p0.add(balance);
        binfo.addActionListener(this);
        bactive.addActionListener(this);
        back.addActionListener(this);
        bfine.addActionListener(this);
        p0.setBounds(180, 0, 200, 20);
        p1.add(Pinfo);
        p1.add(binfo);
        p1.add(active);
        p1.add(bactive);
        p1.add(fine);
        p1.add(bfine);
        p1.add(back);
        p1.setBackground(Color.orange);
        p0.setBackground(Color.orange);
        p1.setBounds(50, 0, 130, 300);
        sell.add(p1);
        sell.add(p0);
        sell.setLayout(null);
        sell.setVisible(true);
        sell.setBounds(600, 100, 400, 300);
        sell.getContentPane().setBackground(Color.orange);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (Objects.equals(e.getSource(), back)) {
            sell.dispose();
            temp.setVisible(true);
        } else if (Objects.equals(e.getSource(), binfo)) {
            sell.setVisible(false);
            rent_info p = new rent_info(ctemp, sell);
        } else if (Objects.equals(e.getSource(), bactive)) {
            sell.setVisible(false);
            try {
                ActiveRent a = new ActiveRent(sell, ctemp);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } else if (e.getSource().equals(bfine)) {
            sell.setVisible(false);
            try {
                checkfine cf=new checkfine(ctemp,sell);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
