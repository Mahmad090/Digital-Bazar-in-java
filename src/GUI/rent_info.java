package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

public class rent_info implements ActionListener {

    public void setfield(JButton b)
    {
        b.setSize(50,50);
    }
    JFrame ftemp;
    private String[] day=new String[31];
    private String[] month=new String[12];
    private String[] year=new String[33];
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
    JFrame f=new JFrame("Product Information");
    JButton insert=new JButton("Insert Product");
    JButton edit=new JButton("Edit Product");
    JButton remove=new JButton("Remove Product");
    JButton back=new JButton("Back");

    customer tc;
    rent_info(customer c,JFrame tf)
    {

        ftemp=tf;
        tc=c;
        insert.addActionListener(this);
        edit.addActionListener(this);
        remove.addActionListener(this);
        back.addActionListener(this);
        f.add(insert);
        f.add(edit);
        f.add(remove);
        f.add(back);
        f.setBounds(400,100,300,200);
        f.setVisible(true);
        f.setLayout(new FlowLayout());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(Color.orange);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(insert))
        {
            f.setVisible(false);
            dateInitialize();
            JComboBox jc_day=new JComboBox(day);
            JComboBox jc_mon=new JComboBox(month);
            JComboBox jc_year=new JComboBox(year);
            JLabel date=new JLabel("Current Date");
            Frame insert=new Frame("Insert Information");
            JLabel id=new JLabel("Product Id");
            JLabel fine=new JLabel("Fine:");
            JTextField _fine=new JTextField(10);
            JLabel rentday=new JLabel("Days to Rent :");
            JTextField _rentday=new JTextField(10);
            JTextField _id=new JTextField(15);
            String[]  ptype=new String[9];
            ptype[0]="Select";
            ptype[1]="Laptop";
            ptype[2]="Mobile";
            ptype[3]="Air Condition";
            ptype[4]="Car";
            ptype[5]="Bike";
            ptype[6]="Bed";
            ptype[7]="Chair";
            ptype[8]="Table";
            JComboBox type=new JComboBox(ptype);
            JLabel _type=new JLabel("Product Type:");
            insert.add(id);
            insert.add(_id);
            insert.add(_type);
            insert.add(type);
            insert.setLayout(new FlowLayout());
            insert.setVisible(true);
            insert.setBackground(Color.orange);
            insert.setBounds(400,100,230,150);

            type.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(type.getSelectedIndex()==0)
                    {
                        insert.setBounds(400,100,230,150);
                        System.out.println("nothing");
                    }
                    else if(type.getSelectedIndex()==1)
                    {
                        type.setEditable(false);
                        type.setEnabled(false);
                        insert.setBounds(400,100,230,500);
                        JLabel price=new JLabel("Price:");
                        JTextField _price=new JTextField(15);
                        JLabel comp=new JLabel("Company");
                        JTextField _comp=new JTextField(12);
                        JLabel lram=new JLabel("Ram:");
                        String [] ram=new String[4];
                        ram[0]="2";ram[1]="4";ram[2]="8";ram[3]="16";
                        JComboBox _ram=new JComboBox(ram);
                        JLabel lgen=new JLabel("Generation:");
                        String [] gen=new String[4];
                        gen[0]="5";gen[1]="6";gen[2]="7";ram[3]="8";
                        JComboBox _gen=new JComboBox(gen);
                        JButton sub=new JButton("Submit");
                        JButton back=new JButton("Back");
                        insert.add(price);
                        insert.add(_price);
                        insert.add(comp);
                        insert.add(_comp);
                        insert.add(lram);
                        insert.add(_ram);
                        insert.add(lgen);
                        insert.add(_gen);
                        insert.add(date);
                        insert.add(jc_day);
                        insert.add(jc_mon);
                        insert.add(jc_year);
                        insert.add(fine);
                        insert.add(_fine);
                        insert.add(rentday);
                        insert.add(_rentday);
                        insert.add(sub);
                        insert.add(back);
                        sub.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                try {
                                    tc.sellrent(insert,"Laptop",_id.getText(),Integer.parseInt(_price.getText()),"Electronic",_comp.getText(),ram[_ram.getSelectedIndex()],gen[_gen.getSelectedIndex()],_fine.getText(),Integer.parseInt(day[jc_day.getSelectedIndex()]),Integer.parseInt(month[jc_mon.getSelectedIndex()]),Integer.parseInt(year[jc_year.getSelectedIndex()]), Integer.parseInt(_rentday.getText()));
                                } catch (SQLException ex) {
                                    throw new RuntimeException(ex);
                                }
                            }
                        });
                        back.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                ftemp.setVisible(true);
                                insert.dispose();
                            }
                        });
                    }
                    else if(type.getSelectedIndex()==2)
                    {
                        type.setEditable(false);
                        type.setEnabled(false);
                        insert.setBounds(400,100,230,500);
                        JLabel price=new JLabel("Price:");
                        JTextField _price=new JTextField(15);
                        JLabel comp=new JLabel("Company");
                        JTextField _comp=new JTextField(12);
                        JLabel lram=new JLabel("Ram:");
                        String [] ram=new String[4];
                        ram[0]="2";ram[1]="4";ram[2]="8";ram[3]="16";
                        JComboBox _ram=new JComboBox(ram);
                        JLabel lrom=new JLabel("Rom:");
                        String [] rom=new String[4];
                        rom[0]="16";rom[1]="32";rom[2]="64";rom[3]="128";
                        JComboBox _rom=new JComboBox(rom);
                        JButton sub=new JButton("Submit");
                        JButton back=new JButton("back");
                        insert.add(comp);
                        insert.add(_comp);
                        insert.add(price);
                        insert.add(_price);
                        insert.add(lram);
                        insert.add(_ram);
                        insert.add(lrom);
                        insert.add(_rom);
                        insert.add(date);
                        insert.add(jc_day);
                        insert.add(jc_mon);
                        insert.add(jc_year);
                        insert.add(fine);
                        insert.add(_fine);
                        insert.add(rentday);
                        insert.add(_rentday);
                        insert.add(sub);
                        insert.add(back);
                        sub.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                try {
                                    tc.sellrent(insert,"Laptop",_id.getText(),Integer.parseInt(_price.getText()),"Electronic",_comp.getText(),ram[_ram.getSelectedIndex()],rom[_rom.getSelectedIndex()],_fine.getText(),Integer.parseInt(day[jc_day.getSelectedIndex()]),Integer.parseInt(month[jc_mon.getSelectedIndex()]),Integer.parseInt(year[jc_year.getSelectedIndex()]), Integer.parseInt(_rentday.getText()));
                                } catch (SQLException ex) {
                                    throw new RuntimeException(ex);
                                }
                            }
                        });
                        back.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                ftemp.setVisible(true);
                                insert.dispose();
                            }
                        });
                    } else if (type.getSelectedIndex()==3) {
                        type.setEditable(false);
                        type.setEnabled(false);
                        insert.setBounds(400,100,230,500);
                        JLabel price=new JLabel("Price:");
                        JTextField _price=new JTextField(15);
                        JLabel comp=new JLabel("Company");
                        JTextField _comp=new JTextField(12);
                        JLabel lwarrenty=new JLabel("Warrenty:");
                        String [] warrenty=new String[3];
                        warrenty[0]="1";warrenty[1]="2";warrenty[2]="3";
                        JComboBox _warrenty=new JComboBox(warrenty);
                        JLabel mod=new JLabel("Model");
                        JTextField _mod=new JTextField(12);
                        JButton sub=new JButton("Submit");
                        JButton back=new JButton("back");
                        insert.add(comp);
                        insert.add(_comp);
                        insert.add(price);
                        insert.add(_price);
                        insert.add(lwarrenty);
                        insert.add(_warrenty);
                        insert.add(mod);
                        insert.add(_mod);
                        insert.add(date);
                        insert.add(jc_day);
                        insert.add(jc_mon);
                        insert.add(jc_year);
                        insert.add(fine);
                        insert.add(_fine);
                        insert.add(rentday);
                        insert.add(_rentday);
                        insert.add(sub);
                        insert.add(back);
                        sub.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                try {
                                    tc.sellrent(insert,"Air_condition",_id.getText(),Integer.parseInt(_price.getText()),"Electronic",_comp.getText(),warrenty[_warrenty.getSelectedIndex()],_mod.getText(),_fine.getText(),Integer.parseInt(day[jc_day.getSelectedIndex()]),Integer.parseInt(month[jc_mon.getSelectedIndex()]),Integer.parseInt(year[jc_year.getSelectedIndex()]),Integer.parseInt(_rentday.getText()));
                                } catch (SQLException ex) {
                                    throw new RuntimeException(ex);
                                }
                            }
                        });
                        back.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                ftemp.setVisible(true);
                                insert.dispose();
                            }
                        });
                    } else if (type.getSelectedIndex()==4) {
                        type.setEditable(false);
                        type.setEnabled(false);
                        insert.setBounds(400,100,230,500);
                        JLabel price=new JLabel("Price:");
                        JTextField _price=new JTextField(15);
                        JLabel comp=new JLabel("Company");
                        JTextField _comp=new JTextField(12);
                        JLabel lwarrenty=new JLabel("Warrenty:");
                        String [] warrenty=new String[3];
                        warrenty[0]="1";warrenty[1]="2";warrenty[2]="3";
                        JComboBox _warrenty=new JComboBox(warrenty);
                        JLabel mod=new JLabel("Model");
                        JTextField _mod=new JTextField(12);
                        JButton sub=new JButton("Submit");
                        JButton back=new JButton("back");
                        insert.add(comp);
                        insert.add(_comp);
                        insert.add(price);
                        insert.add(_price);
                        insert.add(lwarrenty);
                        insert.add(_warrenty);
                        insert.add(mod);
                        insert.add(_mod);
                        insert.add(date);
                        insert.add(jc_day);
                        insert.add(jc_mon);
                        insert.add(jc_year);
                        insert.add(fine);
                        insert.add(_fine);
                        insert.add(rentday);
                        insert.add(_rentday);
                        insert.add(sub);
                        insert.add(back);
                        sub.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                try {
                                    tc.sellrent(insert,"Air_condition",_id.getText(),Integer.parseInt(_price.getText()),"Electronic",_comp.getText(),warrenty[_warrenty.getSelectedIndex()],_mod.getText(),_fine.getText(),Integer.parseInt(day[jc_day.getSelectedIndex()]),Integer.parseInt(month[jc_mon.getSelectedIndex()]),Integer.parseInt(year[jc_year.getSelectedIndex()]),Integer.parseInt(_rentday.getText()));
                                } catch (SQLException ex) {
                                    throw new RuntimeException(ex);
                                }
                            }
                        });
                        back.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                ftemp.setVisible(true);
                                insert.dispose();
                            }
                        });
                    } else if (type.getSelectedIndex()==5) {
                        type.setEditable(false);
                        type.setEnabled(false);
                        insert.setBounds(400,100,230,500);
                        JLabel price=new JLabel("Price:");
                        JTextField _price=new JTextField(15);
                        JLabel comp=new JLabel("Company");
                        JTextField _comp=new JTextField(12);
                        JLabel lwarrenty=new JLabel("Warrenty:");
                        String [] warrenty=new String[3];
                        warrenty[0]="1";warrenty[1]="2";warrenty[2]="3";
                        JComboBox _warrenty=new JComboBox(warrenty);
                        JLabel mod=new JLabel("Model");
                        JTextField _mod=new JTextField(12);
                        JButton sub=new JButton("Submit");
                        JButton back=new JButton("back");
                        insert.add(comp);
                        insert.add(_comp);
                        insert.add(price);
                        insert.add(_price);
                        insert.add(lwarrenty);
                        insert.add(_warrenty);
                        insert.add(mod);
                        insert.add(_mod);
                        insert.add(date);
                        insert.add(jc_day);
                        insert.add(jc_mon);
                        insert.add(jc_year);
                        insert.add(fine);
                        insert.add(_fine);
                        insert.add(rentday);
                        insert.add(_rentday);
                        insert.add(sub);
                        insert.add(back);
                        sub.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                try {
                                    tc.sellrent(insert,"Air_condition",_id.getText(),Integer.parseInt(_price.getText()),"Electronic",_comp.getText(),warrenty[_warrenty.getSelectedIndex()],_mod.getText(),_fine.getText(),Integer.parseInt(day[jc_day.getSelectedIndex()]),Integer.parseInt(month[jc_mon.getSelectedIndex()]),Integer.parseInt(year[jc_year.getSelectedIndex()]),Integer.parseInt(_rentday.getText()));
                                } catch (SQLException ex) {
                                    throw new RuntimeException(ex);
                                }

                            }
                        });
                        back.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                ftemp.setVisible(true);
                                insert.dispose();
                            }
                        });
                    } else if (type.getSelectedIndex()==6) {
                        type.setEditable(false);
                        type.setEnabled(false);
                        insert.setBounds(400,100,230,500);
                        JLabel price=new JLabel("Price:");
                        JTextField _price=new JTextField(15);
                        JLabel comp=new JLabel("Company");
                        JTextField _comp=new JTextField(12);
                        JLabel lwarrenty=new JLabel("Warrenty:");
                        String [] warrenty=new String[3];
                        warrenty[0]="1";warrenty[1]="2";warrenty[2]="3";
                        JComboBox _warrenty=new JComboBox(warrenty);
                        JLabel mod=new JLabel("Model");
                        JTextField _mod=new JTextField(12);
                        JButton sub=new JButton("Submit");
                        JButton back=new JButton("back");
                        insert.add(comp);
                        insert.add(_comp);
                        insert.add(price);
                        insert.add(_price);
                        insert.add(lwarrenty);
                        insert.add(_warrenty);
                        insert.add(mod);
                        insert.add(_mod);
                        insert.add(date);
                        insert.add(jc_day);
                        insert.add(jc_mon);
                        insert.add(jc_year);
                        insert.add(fine);
                        insert.add(_fine);
                        insert.add(rentday);
                        insert.add(_rentday);
                        insert.add(sub);
                        insert.add(back);
                        sub.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                try {
                                    tc.sellrent(insert,"Air_condition",_id.getText(),Integer.parseInt(_price.getText()),"Electronic",_comp.getText(),warrenty[_warrenty.getSelectedIndex()],_mod.getText(),_fine.getText(),Integer.parseInt(day[jc_day.getSelectedIndex()]),Integer.parseInt(month[jc_mon.getSelectedIndex()]),Integer.parseInt(year[jc_year.getSelectedIndex()]),Integer.parseInt(_rentday.getText()));
                                } catch (SQLException ex) {
                                    throw new RuntimeException(ex);
                                }
                            }
                        });
                        back.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                ftemp.setVisible(true);
                                insert.dispose();
                            }
                        });
                    } else if (type.getSelectedIndex()==7) {
                        type.setEditable(false);
                        type.setEnabled(false);
                        insert.setBounds(400,100,230,500);
                        JLabel price=new JLabel("Price:");
                        JTextField _price=new JTextField(15);
                        JLabel comp=new JLabel("Company");
                        JTextField _comp=new JTextField(12);
                        JLabel lwarrenty=new JLabel("Warrenty:");
                        String [] warrenty=new String[3];
                        warrenty[0]="1";warrenty[1]="2";warrenty[2]="3";
                        JComboBox _warrenty=new JComboBox(warrenty);
                        JLabel mod=new JLabel("Model");
                        JTextField _mod=new JTextField(12);
                        JButton sub=new JButton("Submit");
                        JButton back=new JButton("back");
                        insert.add(comp);
                        insert.add(_comp);
                        insert.add(price);
                        insert.add(_price);
                        insert.add(lwarrenty);
                        insert.add(_warrenty);
                        insert.add(mod);
                        insert.add(_mod);
                        insert.add(date);
                        insert.add(jc_day);
                        insert.add(jc_mon);
                        insert.add(jc_year);
                        insert.add(fine);
                        insert.add(_fine);
                        insert.add(rentday);
                        insert.add(_rentday);
                        insert.add(sub);
                        insert.add(back);
                        sub.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                try {
                                    tc.sellrent(insert,"Air_condition",_id.getText(),Integer.parseInt(_price.getText()),"Electronic",_comp.getText(),warrenty[_warrenty.getSelectedIndex()],_mod.getText(),_fine.getText(),Integer.parseInt(day[jc_day.getSelectedIndex()]),Integer.parseInt(month[jc_mon.getSelectedIndex()]),Integer.parseInt(year[jc_year.getSelectedIndex()]),Integer.parseInt(_rentday.getText()));
                                } catch (SQLException ex) {
                                    throw new RuntimeException(ex);
                                }
                            }
                        });
                        back.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                ftemp.setVisible(true);
                                insert.dispose();
                            }
                        });
                    } else if (type.getSelectedIndex()==8) {
                        type.setEditable(false);
                        type.setEnabled(false);
                        insert.setBounds(400,100,230,500);
                        JLabel price=new JLabel("Price:");
                        JTextField _price=new JTextField(15);
                        JLabel comp=new JLabel("Company");
                        JTextField _comp=new JTextField(12);
                        JLabel lwarrenty=new JLabel("Warrenty:");
                        String [] warrenty=new String[3];
                        warrenty[0]="1";warrenty[1]="2";warrenty[2]="3";
                        JComboBox _warrenty=new JComboBox(warrenty);
                        JLabel mod=new JLabel("Model");
                        JTextField _mod=new JTextField(12);
                        JButton sub=new JButton("Submit");
                        JButton back=new JButton("back");
                        insert.add(comp);
                        insert.add(_comp);
                        insert.add(price);
                        insert.add(_price);
                        insert.add(lwarrenty);
                        insert.add(_warrenty);
                        insert.add(mod);
                        insert.add(_mod);
                        insert.add(date);
                        insert.add(jc_day);
                        insert.add(jc_mon);
                        insert.add(jc_year);
                        insert.add(fine);
                        insert.add(_fine);
                        insert.add(rentday);
                        insert.add(_rentday);
                        insert.add(sub);
                        insert.add(back);
                        sub.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                try {
                                    tc.sellrent(insert,"Air_condition",_id.getText(),Integer.parseInt(_price.getText()),"Electronic",_comp.getText(),warrenty[_warrenty.getSelectedIndex()],_mod.getText(),_fine.getText(),Integer.parseInt(day[jc_day.getSelectedIndex()]),Integer.parseInt(month[jc_mon.getSelectedIndex()]),Integer.parseInt(year[jc_year.getSelectedIndex()]),Integer.parseInt(_rentday.getText()));
                                } catch (SQLException ex) {
                                    throw new RuntimeException(ex);
                                }
                            }
                        });
                        back.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                ftemp.setVisible(true);
                                insert.dispose();
                            }
                        });
                    }
                }
            });
        } else if (e.getSource().equals(edit)) {
            f.setVisible(false);
            JFrame edit=new JFrame("Edit");
            JLabel id=new JLabel("Enter id :");
            JTextField _id=new JTextField(10);
            JButton sub=new JButton("Search");
            JButton back=new JButton("Back");
            edit.add(id);
            edit.add(_id);
            edit.add(sub);
            edit.add(back);
            back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    edit.setVisible(false);
                    f.setVisible(true);
                }
            });
            sub.addActionListener(e1 -> {
                edit.setVisible(false);
                try {
                    rentEdit ed=new rentEdit(_id.getText(),edit,tc);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            });
            back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    edit.dispose();
                    f.setVisible(true);
                }
            });
            edit.setLayout(new FlowLayout(FlowLayout.CENTER));
            edit.setVisible(true);
            edit.setBackground(Color.orange);
            edit.setBounds(400,100,300,150);
            edit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } else if (e.getSource().equals(remove)) {
            f.setVisible(false);
            JFrame edit=new JFrame("Edit");
            JLabel id=new JLabel("Enter id :");
            JTextField _id=new JTextField(10);
            JButton sub=new JButton("Search");
            JButton back=new JButton("Back");
            edit.add(id);
            edit.add(_id);
            edit.add(sub);
            edit.add(back) ;
            back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    edit.setVisible(false);
                    f.setVisible(true);
                }
            });
            sub.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        tc.removerent(_id.getText(),ftemp);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
            edit.setLayout(new FlowLayout(FlowLayout.CENTER));
            edit.setVisible(true);
            edit.setBackground(Color.orange);
            edit.setBounds(400,100,300,150);
            edit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } else if (e.getSource().equals(back)) {
            f.dispose();
            ftemp.setVisible(true);
        }

        ftemp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}