package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class ActiveRent{
    JFrame frame = new JFrame("Buy Objects");
    JFrame temp;
    JPanel[] p;
    JLabel[] type;
    JLabel[] id;
    JLabel[] price;
    JLabel[] cat;
    JLabel[] comp;
    JLabel[] a;
    JLabel[] b;
    JLabel[] seller;
    JLabel[] buyer;
    JLabel[] fine;
    JLabel[] rentday;
    JButton back = new JButton("Back");
    private customer c;

    ActiveRent(JFrame t, customer ctemp) throws SQLException {
        c = ctemp;
        temp = t;
        int i = 0;
        Connection con;
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "MAHcs6602021.");
        Statement statement = con.createStatement();
        System.out.println("select count(*) from rental where seller='"+c.getUsername()+"'");
        ResultSet resultSet = statement.executeQuery("select count(*) from rental where seller='"+c.getUsername()+"'");
        while (resultSet.next()) {
            i = resultSet.getInt(1);
            System.out.println(i);
        }
        System.out.println(i);
        p=new JPanel[i];
        type=new JLabel[i];
        id=new JLabel[i];
        price=new JLabel[i];
        cat=new JLabel[i];
        comp=new JLabel[i];
        a=new JLabel[i];
        b=new JLabel[i];
        buyer=new JLabel[i];
        seller=new JLabel[i];
        fine=new JLabel[i];
        rentday=new JLabel[i];
        i = 0;
        resultSet = statement.executeQuery("select * from rental where seller='"+c.getUsername()+"'");
        while (resultSet.next()) {
                System.out.println(i);
                p[i] = new JPanel();
                type[i] = new JLabel(resultSet.getString("type"));
                id[i] = new JLabel(resultSet.getString("id"));
                price[i] = new JLabel(String.valueOf(resultSet.getFloat("price")));
                cat[i] = new JLabel(resultSet.getString("category"));
                comp[i] = new JLabel(resultSet.getString("a"));
                a[i] = new JLabel(resultSet.getString("b"));
                b[i] = new JLabel(resultSet.getString("c"));
                seller[i] = new JLabel(resultSet.getString("seller"));
                fine[i]=new JLabel(resultSet.getString("fine"));
                rentday[i]=new JLabel(String.valueOf(resultSet.getInt("rentdays")));
                p[i].add(type[i]);
                p[i].add(id[i]);
                p[i].add(price[i]);
                p[i].add(cat[i]);
                p[i].add(comp[i]);
                p[i].add(a[i]);
                p[i].add(b[i]);
                p[i].add(seller[i]);
                p[i].add(fine[i]);
                p[i].add(rentday[i]);
                frame.add(p[i]);
            i++;
        }
        frame.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                temp.setVisible(true);
            }
        });
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
        frame.setBounds(600, 100, 600, 300);
        frame.getContentPane().setBackground(Color.orange);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}