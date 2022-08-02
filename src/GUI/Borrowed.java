package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Borrowed {
    private String[] Day=new String[31];
    private String[] Month=new String[12];
    private String[] Year=new String[33];
    JFrame temp;
    private customer ct;
    JButton back=new JButton("Back");
    JTextField _bid=new JTextField(10);
    JLabel bid=new JLabel("Enter id to borrow:");
    JButton enter=new JButton("Borrow");
    JFrame borrow=new JFrame("Borrow");
    public void dateInitialize()
    {
        for(int i=0;i<31;i++)
        {
            Day[i]=Integer.toString(i+1);
        }
        for(int i=0;i<12;i++)
        {
            Month[i]=Integer.toString(i+1);
        }
        for(int i=0;i<33;i++)
        {
            Year[i]=Integer.toString(1990+i);
        }

    }

    public Borrowed(JFrame t,customer c)
    {
        temp=t;
        ct=c;
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                borrow.dispose();
                temp.setVisible(true);
            }
        });
        JPanel[] p;
        JLabel[] type;
        JLabel[] id;
        JLabel[] price;
        JLabel[] cat1;
        JLabel[] comp;
        JLabel[] a1;
        JLabel[] b1;
        JLabel[] seller;
        JLabel[] fine;
        JLabel[] rentday;
        JLabel[] day;
        JLabel[] month;
        JLabel[] year;
        int i = 0;
        Connection con;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "MAHcs6602021.");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        Statement statement = null;
        try {
            statement = con.createStatement();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery("select count(*) from rental where seller!='"+ct.getUsername()+"'");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        while (true) {
            try {
                if (!resultSet.next()) break;
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            try {
                i = resultSet.getInt(1);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            System.out.println(i);
        }
        p=new JPanel[i];
        type=new JLabel[i];
        id=new JLabel[i];
        price=new JLabel[i];
        cat1 =new JLabel[i];
        comp=new JLabel[i];
        a1 =new JLabel[i];
        b1 =new JLabel[i];
        seller=new JLabel[i];
        fine=new JLabel[i];
        rentday=new JLabel[i];
        day=new JLabel[i];
        month=new JLabel[i];
        year=new JLabel[i];
        i = 0;
        try {
            resultSet = statement.executeQuery("select * from rental where seller!='"+ct.getUsername()+"'");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        while (true) {
            try {
                if (!resultSet.next()) break;
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            try {
                System.out.println(i);
                p[i] = new JPanel();
                try {
                    type[i] = new JLabel(resultSet.getString("type"));
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    id[i] = new JLabel(resultSet.getString("id"));
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    price[i] = new JLabel(String.valueOf(resultSet.getFloat("price")));
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    cat1[i] = new JLabel(resultSet.getString("category"));
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                comp[i] = new JLabel(resultSet.getString("a"));
                a1[i] = new JLabel(resultSet.getString("b"));
                b1[i] = new JLabel(resultSet.getString("c"));
                day[i]=new JLabel(resultSet.getString("day")+"-");
                month[i]=new JLabel(resultSet.getString("month")+"-");
                year[i]=new JLabel(resultSet.getString("year"));

                seller[i] = new JLabel(resultSet.getString("seller"));
                fine[i]=new JLabel(resultSet.getString("fine"));
                rentday[i]=new JLabel(String.valueOf(resultSet.getInt("rentdays")));
                p[i].add(type[i]);
                p[i].add(id[i]);
                p[i].add(price[i]);
                p[i].add(cat1[i]);
                p[i].add(comp[i]);
                p[i].add(a1[i]);
                p[i].add(b1[i]);
                p[i].add(seller[i]);
                p[i].add(fine[i]);
                p[i].add(rentday[i]);
                p[i].add(day[i]);
                p[i].add(month[i]);
                p[i].add(year[i]);

                borrow.add(p[i]);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            i++;
        }
        borrow.add(bid);
        borrow.add(_bid);
        borrow.add(enter);
        borrow.add(back);
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            borrow.dispose();
            JFrame date=new JFrame("Enter date");
            dateInitialize();
            JComboBox jc_day=new JComboBox(Day);
            JComboBox jc_mon=new JComboBox(Month);
            JComboBox jc_year=new JComboBox(Year);
            JButton submit=new JButton("Submit");
            JButton back=new JButton("Back");
            back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    date.dispose();
                    borrow.setVisible(true);
                }
            });
            date.add(jc_day);
            date.add(jc_mon);
            date.add(jc_year);
            date.add(submit);
            submit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        ct.borrow(date, _bid.getText(), Day[jc_day.getSelectedIndex()],Month[jc_mon.getSelectedIndex()],Year[jc_year.getSelectedIndex()]);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
            date.setLayout(new FlowLayout());
            date.setVisible(true);
            date.setBounds(100,100,400,200);
            date.setBackground(Color.orange);
            date.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
        borrow.setLayout(new FlowLayout());
        borrow.setVisible(true);
        borrow.setBounds(100,100,400,600);
        borrow.setBackground(Color.orange);
        borrow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}
