package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class checkfine {
    JFrame frame = new JFrame("Sold Objects");
    private String[] Day = new String[31];
    private String[] Month = new String[12];
    private String[] Year = new String[33];
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
    JLabel[] borrower;
    JLabel[] fine;
    JLabel[] day;
    JLabel[] month;
    JLabel[] year;
    JLabel[] rentday;
    JButton back = new JButton("Back");
    private customer c;

    public void dateInitialize() {
        for (int i = 0; i < 31; i++) {
            Day[i] = Integer.toString(i + 1);
        }
        for (int i = 0; i < 12; i++) {
            Month[i] = Integer.toString(i + 1);
        }
        for (int i = 0; i < 33; i++) {
            Year[i] = Integer.toString(1990 + i);
        }

    }

    public checkfine(customer ctemp, JFrame t) throws SQLException {
        c = ctemp;
        temp = t;
        int i = 0;
        Connection con;
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "MAHcs6602021.");
        Statement statement = con.createStatement();
        System.out.println("select count(*) from borrowed where seller='" + c.getUsername() + "'");
        ResultSet resultSet = statement.executeQuery("select count(*) from borrowed where seller='" + c.getUsername() + "'");
        while (resultSet.next()) {
            i = resultSet.getInt(1);
            System.out.println(i);
        }
        System.out.println(i);
        p = new JPanel[i];
        type = new JLabel[i];
        id = new JLabel[i];
        price = new JLabel[i];
        cat = new JLabel[i];
        comp = new JLabel[i];
        a = new JLabel[i];
        b = new JLabel[i];
        borrower = new JLabel[i];
        seller = new JLabel[i];
        fine = new JLabel[i];
        rentday = new JLabel[i];
        day = new JLabel[i];
        month = new JLabel[i];
        year = new JLabel[i];
        i = 0;
        resultSet = statement.executeQuery("select * from borrowed where seller='" + c.getUsername() + "'");
        while (resultSet.next()) {
            if (resultSet.getString("seller").equals(c.getUsername())) {
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
                borrower[i] = new JLabel(resultSet.getString("borrower"));
                fine[i] = new JLabel(resultSet.getString("fine"));
                rentday[i] = new JLabel(String.valueOf(resultSet.getInt("rentdays")));
                day[i] = new JLabel(resultSet.getString("day"));
                month[i] = new JLabel(resultSet.getString("month"));
                year[i] = new JLabel(resultSet.getString("year"));
                p[i].add(type[i]);
                p[i].add(id[i]);
                p[i].add(price[i]);
                p[i].add(cat[i]);
                p[i].add(comp[i]);
                p[i].add(a[i]);
                p[i].add(b[i]);
                p[i].add(seller[i]);
                p[i].add(borrower[i]);
                p[i].add(fine[i]);
                p[i].add(rentday[i]);
                p[i].add(day[i]);
                p[i].add(month[i]);
                p[i].add(year[i]);
                frame.add(p[i]);
            }
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
        JLabel lid = new JLabel("Enter id to check fine");
        JTextField _id = new JTextField(10);
        JButton submit = new JButton("Check");
        JButton back = new JButton("Back");
        frame.add(lid);
        frame.add(_id);
        frame.add(submit);
        frame.add(back);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                JFrame date = new JFrame("Enter date");
                dateInitialize();
                JComboBox jc_day = new JComboBox(Day);
                JComboBox jc_mon = new JComboBox(Month);
                JComboBox jc_year = new JComboBox(Year);
                JButton enter = new JButton("Submit");
                JButton back = new JButton("Back");
                back.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        date.dispose();
                        frame.setVisible(true);
                    }
                });
                date.add(jc_day);
                date.add(jc_mon);
                date.add(jc_year);
                date.add(enter);
                enter.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            int fine;
                            fine=c.checkfine(date, _id.getText(), Integer.parseInt(Day[jc_day.getSelectedIndex()]), Integer.parseInt(Month[jc_mon.getSelectedIndex()]),Integer.parseInt(Year[jc_year.getSelectedIndex()]));
                            System.out.println(fine);
                            JOptionPane.showMessageDialog(date,"Fine:"+fine,"Fine",JOptionPane.INFORMATION_MESSAGE);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                });
                date.setVisible(true);
                date.setBounds(200,200,300,200);
                date.setLayout(new FlowLayout());
                date.getContentPane().setBackground(Color.orange);
                date.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
        frame.setBounds(600, 100, 500, 300);
        frame.getContentPane().setBackground(Color.orange);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
