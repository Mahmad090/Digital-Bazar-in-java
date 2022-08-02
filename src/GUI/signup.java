package GUI;

//import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class signup {
    private String[] day=new String[31];
    private String[] month=new String[12];
    private String[] year=new String[33];
    private final int size=6;
    connection c=new connection();
    JFrame jrf=new JFrame("Sign Up Form");

    JLabel jlfname=new JLabel("Username: ");
    JLabel jlpass=new JLabel("  Password: ");
    JLabel jlgender=new JLabel(" Gender: ");
    JLabel jldob=new JLabel("Date of Birth: ");
    JTextField jtfname=new JTextField(20);
    JTextField []jtempty=new JTextField[size];


    JPasswordField jp=new JPasswordField(20);
    JRadioButton jr_m=new JRadioButton("Male");
    JRadioButton jr_f=new JRadioButton("Female");
    ButtonGroup bg_g=new ButtonGroup();
    JLabel bal=new JLabel("Balance");
    JTextField _bal=new JTextField(20);
    JButton jb_sub=new JButton("Submit");
    JButton jb_clear=new JButton("Clear");
    JButton jb_back=new JButton("Back");
JFrame temp;
   public signup(JFrame back) throws SQLException {
       temp=back;
        createForm();
    }
    public void dateInitialize()
    {
        for(int i=0;i<31;i++)
        {
            day[i]=Integer.toString(i+1);
        }
        for(int i=0;i<12;i++)
        {
            month[i]=Integer.toString(i+1);
        }
        for(int i=0;i<33;i++)
        {
            year[i]=Integer.toString(1990+i);
        }

    }
    public void emptyTextField()
    {
        for(int i=0;i<size;i++)
        {
            jtempty[i]=new JTextField(30);
            jtempty[i].setEditable(false);
            jtempty[i].setBorder(null);
            jtempty[i].setBackground(Color.ORANGE);
        }
    }
    public void createForm()
    {
        dateInitialize();
        emptyTextField();
       jr_m.setActionCommand("male");
       jr_f.setActionCommand("female");

        JComboBox jc_day=new JComboBox(day);
        JComboBox jc_mon=new JComboBox(month);
        JComboBox jc_year=new JComboBox(year);
        jrf.add(jtempty[0]);

        jrf.add(jlfname);
        jrf.add(jtfname);
        jrf.add(jtempty[1]);

        jrf.add(jlpass);
        jrf.add(jp);
        jrf.add(jtempty[2]);
        jrf.add(bal);
        jrf.add(_bal);
        jrf.add(jtempty[5]);
        jr_m.setBackground(Color.ORANGE);
        jr_f.setBackground(Color.ORANGE);
        bg_g.add(jr_m);
        bg_g.add(jr_f);

        jrf.add(jlgender);
        jrf.add(jr_m);
        jrf.add(jr_f);
        jrf.add(jtempty[3]);

        jrf.add(jldob);
        jrf.add(jc_day);
        jrf.add(jc_mon);
        jrf.add(jc_year);
        jrf.add(jtempty[4]);

        jrf.add(jb_sub);
        jrf.add(jb_clear);
        jrf.add(jb_back);
        jb_back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jrf.dispose();
                temp.setVisible(true);
            }
        });
        jb_sub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String gen;
                    if(jr_m.isSelected())
                        gen="male";
                    else
                        gen="female";
                    c.signup(jrf,jtfname.getText(),String.valueOf(jp.getPassword()),gen,day[jc_day.getSelectedIndex()]+"-"+month[jc_mon.getSelectedIndex()]+"-"+year[jc_year.getSelectedIndex()],_bal.getText());
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                //;

            }
        });
        jb_clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jp.setText("");
                jr_f.setSelected(false);
                jr_m.setSelected(false);
                jtfname.setText(" ");
                _bal.setText("");
                jc_day.setSelectedIndex(0);
                jc_mon.setSelectedIndex(0);
                jc_year.setSelectedIndex(0);

            }
        });
        jrf.setLayout(new FlowLayout());
        jrf.setSize(350,200);
        jrf.setResizable(false);
        jrf.setBounds(600,100,350,350);
        jrf.setVisible(true);
        jrf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jrf.getContentPane().setBackground(Color.ORANGE);
    }
}