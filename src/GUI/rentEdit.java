package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class rentEdit {
    String[] ram = new String[4];
    String[] rom = new String[4];
    String[] gen = new String[4];
    JFrame edit = new JFrame("Edit it");
    JLabel price = new JLabel("Price:");
    JLabel comp = new JLabel("Company:");
    JComboBox _rom;
    JTextField _price = new JTextField(10);
    JTextField _comp = new JTextField(10);
    JFrame temp;
    JComboBox _ram;
    JComboBox _gen;
    customer tc;


    JLabel fine=new JLabel("Fine:");
    JTextField _fine=new JTextField(10);
    JLabel rentday=new JLabel("Days to Rent :");
    JTextField _rentday=new JTextField(10);
    rentEdit(String _id, JFrame temp, customer t) throws SQLException {
        tc = t;
        this.temp = temp;
        edit.add(price);
        edit.add(_price);
        edit.add(comp);
        edit.add(_comp);
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "MAHcs6602021.");
        Statement stmt = con.createStatement();
        //query="SELECT balance FROM `users` WHERE `username` =? AND `password` =?";
        String query = "SELECT type FROM rental WHERE id='" + _id + "' And seller='"+t.getUsername()+"'";
        System.out.println(query);
        ResultSet rs = stmt.executeQuery(query);
        String type = null;
        if (rs.next()) {
            type = rs.getString(1);
            System.out.println(type);
        }
        if(type==null)
        {
            JOptionPane.showMessageDialog(this.temp,"Product Not Exist","Alert",JOptionPane.WARNING_MESSAGE);
            temp.setVisible(true);
            edit.dispose();
        }
        else   if (type.equals("Laptop")) {
            JLabel lram = new JLabel("Ram:");
            ram[0] = "2";
            ram[1] = "4";
            ram[2] = "8";
            ram[3] = "16";
            _ram = new JComboBox(ram);
            JLabel lgen = new JLabel("Generation:");

            gen[0] = "5";
            gen[1] = "6";
            gen[2] = "7";
            ram[3] = "8";
            _gen = new JComboBox(gen);
            JButton sub = new JButton("Submit");
            JButton back = new JButton("Back");
            edit.add(lram);
            edit.add(_ram);
            edit.add(lgen);
            edit.add(_gen);
            edit.add(fine);
            edit.add(_fine);
            edit.add(rentday);
            edit.add(_rentday);
            edit.add(sub);
            edit.add(back);
            edit.setLayout(new FlowLayout());
            edit.setVisible(true);
            edit.getContentPane().setBackground(Color.orange);
            edit.setBounds(600,100,300,450);
            edit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            sub.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        boolean flag;
                        flag=tc.rentedit(Float.parseFloat(_price.getText()),_comp.getText(),ram[_ram.getSelectedIndex()],gen[_gen.getSelectedIndex()],_id,_fine.getText(), Integer.parseInt(_rentday.getText()));
                        if(flag==true)
                        {
                            JOptionPane.showMessageDialog(edit,"Record Updated Successfullly ","Message",JOptionPane.INFORMATION_MESSAGE);
                        }
                        else  JOptionPane.showMessageDialog(edit,"Record Not Updated","Alert",JOptionPane.WARNING_MESSAGE);

                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
            back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    edit.dispose();
                    temp.setVisible(true);
                }
            });
        } else if (type.equals("Mobile")) {
            JLabel lram = new JLabel("Ram:");
            ram[0] = "2";
            ram[1] = "4";
            ram[2] = "8";
            ram[3] = "16";
            _ram = new JComboBox(ram);
            JLabel lrom=new JLabel("Rom:");

            rom[0]="16";rom[1]="32";rom[2]="64";rom[3]="128";
            _rom=new JComboBox(rom);

            JButton sub = new JButton("Submit");
            JButton back = new JButton("Back");
            edit.add(lram);
            edit.add(_ram);
            edit.add(lrom);
            edit.add(_rom);
            edit.add(fine);
            edit.add(_fine);
            edit.add(rentday);
            edit.add(_rentday);
            edit.add(sub);
            edit.add(back);
            edit.setLayout(new FlowLayout());
            edit.setVisible(true);
            edit.getContentPane().setBackground(Color.orange);
            edit.setBounds(600,100,300,450);
            edit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            sub.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        boolean flag;
                        flag=tc.rentedit(Float.parseFloat(_price.getText()),_comp.getText(),ram[_ram.getSelectedIndex()],rom[_rom.getSelectedIndex()],_id,_fine.getText(), Integer.parseInt(_rentday.getText()));
                        if(flag==true)
                        {
                            JOptionPane.showMessageDialog(edit,"Record Updated Successfullly ","Message",JOptionPane.INFORMATION_MESSAGE);
                        }
                        else  JOptionPane.showMessageDialog(edit,"Record Not Updated","Alert",JOptionPane.WARNING_MESSAGE);

                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
            back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    edit.dispose();
                    temp.setVisible(true);
                }
            });

        } else if (type.equals("Air_condition")) {
            JLabel lwar = new JLabel("Warrenty:");
            ram[0] = "1";
            ram[1] = "2";
            ram[2] = "3";
            ram[3] = "4";
            _ram = new JComboBox(ram);//used as warrenty
            JLabel lmodel=new JLabel("Model:");
            JTextField mod=new JTextField(10);
            JButton sub = new JButton("Submit");
            JButton back = new JButton("Back");
            edit.add(lwar);
            edit.add(_ram);
            edit.add(lmodel);
            edit.add(mod);
            edit.add(fine);
            edit.add(_fine);
            edit.add(rentday);
            edit.add(_rentday);
            edit.add(sub);
            edit.add(back);
            edit.setLayout(new FlowLayout());
            edit.setVisible(true);
            edit.getContentPane().setBackground(Color.orange);
            edit.setBounds(600,100,300,450);
            edit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            sub.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        boolean flag;
                        flag=tc.rentedit(Float.parseFloat(_price.getText()),_comp.getText(),ram[_ram.getSelectedIndex()],mod.getText(),_id,_fine.getText(),Integer.parseInt(_rentday.getText()));
                        if(flag==true)
                        {
                            JOptionPane.showMessageDialog(edit,"Record Updated Successfullly ","Message",JOptionPane.INFORMATION_MESSAGE);
                        }
                        else  JOptionPane.showMessageDialog(edit,"Record Not Updated","Alert",JOptionPane.WARNING_MESSAGE);

                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
            back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    edit.dispose();
                    temp.setVisible(true);
                }
            });
        } else if (type.equals("Bike")) {
            JLabel lwar = new JLabel("Warrenty:");
            ram[0] = "1";
            ram[1] = "2";
            ram[2] = "3";
            ram[3] = "4";
            _ram = new JComboBox(ram);//used as warrenty
            JLabel lmodel = new JLabel("Model:");
            JTextField mod = new JTextField(10);
            JButton sub = new JButton("Submit");
            JButton back = new JButton("Back");
            edit.add(lwar);
            edit.add(_ram);
            edit.add(lmodel);
            edit.add(mod);
            edit.add(fine);
            edit.add(_fine);
            edit.add(rentday);
            edit.add(_rentday);
            edit.add(sub);
            edit.add(back);
            edit.setLayout(new FlowLayout());
            edit.setVisible(true);
            edit.getContentPane().setBackground(Color.orange);
            edit.setBounds(600, 100, 300, 450);
            edit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            sub.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        boolean flag;
                        flag = tc.rentedit(Float.parseFloat(_price.getText()), _comp.getText(), ram[_ram.getSelectedIndex()], mod.getText(), _id,_fine.getText(),Integer.parseInt(_rentday.getText()));
                        if (flag == true) {
                            JOptionPane.showMessageDialog(edit, "Record Updated Successfullly ", "Message", JOptionPane.INFORMATION_MESSAGE);
                        } else
                            JOptionPane.showMessageDialog(edit, "Record Not Updated", "Alert", JOptionPane.WARNING_MESSAGE);

                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
            back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    edit.dispose();
                    temp.setVisible(true);
                }
            });
        }
        else if (type.equals("Car")) {
            JLabel lwar = new JLabel("Warrenty:");
            ram[0] = "1";
            ram[1] = "2";
            ram[2] = "3";
            ram[3] = "4";
            _ram = new JComboBox(ram);//used as warrenty
            JLabel lmodel = new JLabel("Model:");
            JTextField mod = new JTextField(10);
            JButton sub = new JButton("Submit");
            JButton back = new JButton("Back");
            edit.add(lwar);
            edit.add(_ram);
            edit.add(lmodel);
            edit.add(mod);
            edit.add(fine);
            edit.add(_fine);
            edit.add(rentday);
            edit.add(_rentday);
            edit.add(sub);
            edit.add(back);
            edit.setLayout(new FlowLayout());
            edit.setVisible(true);
            edit.getContentPane().setBackground(Color.orange);
            edit.setBounds(600, 100, 300, 450);
            edit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            sub.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        boolean flag;
                        flag = tc.rentedit(Float.parseFloat(_price.getText()), _comp.getText(), ram[_ram.getSelectedIndex()], mod.getText(),_id,_fine.getText(),Integer.parseInt(_rentday.getText()));
                        if (flag == true) {
                            JOptionPane.showMessageDialog(edit, "Record Updated Successfullly ", "Message", JOptionPane.INFORMATION_MESSAGE);
                        } else
                            JOptionPane.showMessageDialog(edit, "Record Not Updated", "Alert", JOptionPane.WARNING_MESSAGE);

                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
            back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    edit.dispose();
                    temp.setVisible(true);
                }
            });
        }
        else if (type.equals("Bed")) {
            JLabel lwar = new JLabel("Warrenty:");
            ram[0] = "1";
            ram[1] = "2";
            ram[2] = "3";
            ram[3] = "4";
            _ram = new JComboBox(ram);//used as warrenty
            JLabel lmodel = new JLabel("Model:");
            JTextField mod = new JTextField(10);
            JButton sub = new JButton("Submit");
            JButton back = new JButton("Back");
            edit.add(lwar);
            edit.add(_ram);
            edit.add(lmodel);
            edit.add(mod);
            edit.add(fine);
            edit.add(_fine);
            edit.add(rentday);
            edit.add(_rentday);
            edit.add(sub);
            edit.add(back);
            edit.setLayout(new FlowLayout());
            edit.setVisible(true);
            edit.getContentPane().setBackground(Color.orange);
            edit.setBounds(600, 100, 300, 450);
            edit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            sub.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        boolean flag;
                        flag = tc.rentedit(Float.parseFloat(_price.getText()), _comp.getText(), ram[_ram.getSelectedIndex()], mod.getText(), _id,_fine.getText(),Integer.parseInt(_rentday.getText()));
                        if (flag == true) {
                            JOptionPane.showMessageDialog(edit, "Record Updated Successfullly ", "Message", JOptionPane.INFORMATION_MESSAGE);
                        } else
                            JOptionPane.showMessageDialog(edit, "Record Not Updated", "Alert", JOptionPane.WARNING_MESSAGE);

                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
            back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    edit.dispose();
                    temp.setVisible(true);
                }
            });
        }
        else if (type.equals("Chair")) {
            JLabel lwar = new JLabel("Warrenty:");
            ram[0] = "1";
            ram[1] = "2";
            ram[2] = "3";
            ram[3] = "4";
            _ram = new JComboBox(ram);//used as warrenty
            JLabel lmodel = new JLabel("Model:");
            JTextField mod = new JTextField(10);
            JButton sub = new JButton("Submit");
            JButton back = new JButton("Back");
            edit.add(lwar);
            edit.add(_ram);
            edit.add(lmodel);
            edit.add(mod);
            edit.add(fine);
            edit.add(_fine);
            edit.add(rentday);
            edit.add(_rentday);
            edit.add(sub);
            edit.add(back);
            edit.setLayout(new FlowLayout());
            edit.setVisible(true);
            edit.getContentPane().setBackground(Color.orange);
            edit.setBounds(600, 100, 300, 450);
            edit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            sub.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        boolean flag;
                        flag = tc.rentedit(Float.parseFloat(_price.getText()), _comp.getText(), ram[_ram.getSelectedIndex()], mod.getText(), _id,_fine.getText(),Integer.parseInt(_rentday.getText()));
                        if (flag == true) {
                            JOptionPane.showMessageDialog(edit, "Record Updated Successfullly ", "Message", JOptionPane.INFORMATION_MESSAGE);
                        } else
                            JOptionPane.showMessageDialog(edit, "Record Not Updated", "Alert", JOptionPane.WARNING_MESSAGE);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
            back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    edit.dispose();
                    temp.setVisible(true);
                }
            });
        }
        else if (type.equals("Table")) {
            JLabel lwar = new JLabel("Warrenty:");
            ram[0] = "1";
            ram[1] = "2";
            ram[2] = "3";
            ram[3] = "4";
            _ram = new JComboBox(ram);//used as warrenty
            JLabel lmodel = new JLabel("Model:");
            JTextField mod = new JTextField(10);
            JButton sub = new JButton("Submit");
            JButton back = new JButton("Back");
            edit.add(lwar);
            edit.add(_ram);
            edit.add(lmodel);
            edit.add(mod);
            edit.add(fine);
            edit.add(_fine);
            edit.add(rentday);
            edit.add(_rentday);
            edit.add(sub);
            edit.add(back);
            edit.setLayout(new FlowLayout());
            edit.setVisible(true);
            edit.getContentPane().setBackground(Color.orange);
            edit.setBounds(600, 100, 300, 450);
            edit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            sub.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        boolean flag;
                        flag = tc.rentedit(Float.parseFloat(_price.getText()), _comp.getText(), ram[_ram.getSelectedIndex()], mod.getText(), _id,_fine.getText(),Integer.parseInt(_rentday.getText()));
                        if (flag == true) {
                            JOptionPane.showMessageDialog(edit, "Record Updated Successfullly ", "Message", JOptionPane.INFORMATION_MESSAGE);
                        } else
                            JOptionPane.showMessageDialog(edit, "Record Not Updated", "Alert", JOptionPane.WARNING_MESSAGE);

                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
            back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    edit.dispose();
                    temp.setVisible(true);
                }
            });
        }
    }
}