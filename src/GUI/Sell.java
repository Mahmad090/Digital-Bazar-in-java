package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Objects;

public class Sell implements ActionListener {
    JFrame sell=new JFrame("Sell");
    Product_info p;
    JLabel user=new JLabel();
    JPanel p0=new JPanel();
    JPanel p1=new JPanel();
    Active a;
    JLabel balance=new JLabel();
    JLabel balanceL=new JLabel("Balance:");
    JLabel userL=new JLabel("User:");
    JLabel Pinfo=new JLabel("Product Information:");
    JButton binfo=new JButton("information");
    JButton bactive=new JButton("Active");
    JButton bsold=new JButton("Sold");
    JLabel active=new JLabel("Active Product List:");
    JLabel sold=new JLabel("Sold Product List:");
    JButton back=new JButton("Go Back");
    JFrame temp;
    ActiveSold as;
    private customer ctemp;
    Sell(customer c,JFrame f)
    {
        ctemp=c;
        temp=f;
        user.setText(c.getUsername());
        balance.setText(String.valueOf(c.getBalance()));
        p0.add(userL);
        p0.add(user);
        p0.add(balanceL);
        p0.add(balance);
        binfo.addActionListener(this);
        bactive.addActionListener(this);
        back.addActionListener(this);
        bsold.addActionListener(this);
        p0.setBounds(180,0,200,20);
        p1.add(Pinfo);
        p1.add(binfo);
        p1.add(active);
        p1.add(bactive);
        p1.add(sold);
        p1.add(bsold);
        p1.add(back);
        p1.setBackground(Color.orange);
        p0.setBackground(Color.orange);
        p1.setBounds(50,0,130,300);
        sell.add(p1);
        sell.add(p0);
        sell.setLayout(null);
        sell.setVisible(true);
        sell.setBounds(600,100,400,300);
        sell.getContentPane().setBackground(Color.orange);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
      if(Objects.equals(e.getSource(), back))
      {
          sell.dispose();
          temp.setVisible(true);
      }
      else if(Objects.equals(e.getSource(), binfo))
      {
          sell.setVisible(false);
          p=new Product_info(ctemp,sell);
      } else if (Objects.equals(e.getSource(),bactive)) {
          sell.setVisible(false);
          try {
              a=new Active(sell,ctemp);
          } catch (SQLException ex) {
              throw new RuntimeException(ex);
          }
      } else if (e.getSource().equals(bsold)) {
          sell.setVisible(false);
          try {
              as =new ActiveSold(sell,ctemp);
          } catch (SQLException ex) {
              throw new RuntimeException(ex);
          }
      }
    }
}