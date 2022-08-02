package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Filter implements ActionListener {
    JFrame temp;
    String Type;
    JFrame filter=new JFrame("Apply Filter");
    JButton date=new JButton("Sort by Date");
    JButton price=new JButton("Sort by Price");
    JButton range=new JButton("200-1000");
    JButton backe=new JButton("Back");
    customer ct;
    public Filter(String type, JFrame t,customer c)
    {
     temp=t;
     ct=c;
     this.Type=type;
     filter.add(date);
     filter.add(price);
     filter.add(range);
     filter.add(backe);
     backe.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             filter.dispose();
             temp.setVisible(true);
         }
     });
     date.addActionListener(this);
     price.addActionListener(this);
     range.addActionListener(this);
     filter.setVisible(true);
     filter.setBounds(200,300,200,200);
     filter.setLayout(new FlowLayout());
     filter.getContentPane().setBackground(Color.orange);
     filter.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame product=new JFrame(String.valueOf(Type));
         if (e.getSource().equals(date)) {
            filter.dispose();
            JPanel[] p;
            JLabel[] type;
            JLabel[] id;
            JLabel[] price;
            JLabel[] cat1;
            JLabel[] comp;
            JLabel[] a1;
            JLabel[] b1;
            JLabel[] seller;
            JLabel[] install;
            JLabel[] day;
            JLabel[] month;
            JLabel[] year;
            JButton[] msg;
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
                resultSet = statement.executeQuery("select count(*) from products where type='"+Type+"' And seller !='"+ct.getUsername()+"'");
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
            install=new JLabel[i];
            day=new JLabel[i];
            month=new JLabel[i];
            year=new JLabel[i];
            i = 0;
            try {
                System.out.println("select * from products where type='"+Type+"' And seller !='"+ct.getUsername()+"' ORDER by year desc");
                resultSet = statement.executeQuery("select * from products where type='"+Type+"' And seller !='"+ct.getUsername()+"' ORDER by year desc ");
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
                    install[i]=new JLabel(resultSet.getString("installment"));
                    p[i].add(type[i]);
                    p[i].add(id[i]);
                    p[i].add(price[i]);
                    p[i].add(cat1[i]);
                    p[i].add(comp[i]);
                    p[i].add(a1[i]);
                    p[i].add(b1[i]);
                    p[i].add(seller[i]);
                    p[i].add(install[i]);
                    p[i].add(day[i]);
                    p[i].add(month[i]);
                    p[i].add(year[i]);
                    product.add(p[i]);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                i++;
            }

        } else if (e.getSource().equals(price)) {
            filter.dispose();
            JPanel[] p;
            JLabel[] type;
            JLabel[] id;
            JLabel[] price;
            JLabel[] cat1;
            JLabel[] comp;
            JLabel[] a1;
            JLabel[] b1;
            JLabel[] seller;
            JLabel[] install;
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
                resultSet = statement.executeQuery("select count(*) from products where type='"+Type+"' And seller !='"+ct.getUsername()+"'");
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
            install=new JLabel[i];
            day=new JLabel[i];
            month=new JLabel[i];
            year=new JLabel[i];
            i = 0;
            try {
                resultSet = statement.executeQuery("select * from products where type='"+Type+"' And seller !='"+ct.getUsername()+"' ORDER by price");
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
                    install[i]=new JLabel(resultSet.getString("installment"));
                    p[i].add(type[i]);
                    p[i].add(id[i]);
                    p[i].add(price[i]);
                    p[i].add(cat1[i]);
                    p[i].add(comp[i]);
                    p[i].add(a1[i]);
                    p[i].add(b1[i]);
                    p[i].add(seller[i]);
                    p[i].add(install[i]);
                    p[i].add(day[i]);
                    p[i].add(month[i]);
                    p[i].add(year[i]);

                    product.add(p[i]);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                i++;
            }
        } else if (e.getSource().equals(range)) {
            filter.dispose();
            JPanel[] p;
            JLabel[] type;
            JLabel[] id;
            JLabel[] price;
            JLabel[] cat1;
            JLabel[] comp;
            JLabel[] a1;
            JLabel[] b1;
            JLabel[] seller;
            JLabel[] install;
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
                resultSet = statement.executeQuery("select count(*) from products where type='"+Type+"' And seller !='"+ct.getUsername()+"'");
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
            install=new JLabel[i];
            day=new JLabel[i];
            month=new JLabel[i];
            year=new JLabel[i];
            i = 0;
            try {
                System.out.println("select * from products where type='"+Type+"' And seller !='"+ct.getUsername()+"' and price between 200 and 1000");
                resultSet = statement.executeQuery("select * from products where type='"+Type+"' And seller !='"+ct.getUsername()+"' and price between 200 and 1000");
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
                    install[i]=new JLabel(resultSet.getString("installment"));
                    p[i].add(type[i]);
                    p[i].add(id[i]);
                    p[i].add(price[i]);
                    p[i].add(cat1[i]);
                    p[i].add(comp[i]);
                    p[i].add(a1[i]);
                    p[i].add(b1[i]);
                    p[i].add(seller[i]);
                    p[i].add(install[i]);
                    p[i].add(day[i]);
                    p[i].add(month[i]);
                    p[i].add(year[i]);

                    product.add(p[i]);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                i++;
            }
        }
        JLabel id=new JLabel("Enter id to buy");
        JTextField _id=new JTextField(10);
        JButton buy=new JButton("Buy");
        JButton back=new JButton("Back");
        product.add(id);
        product.add(_id);
        product.add(buy);
        product.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                product.dispose();
            }
        });
        buy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(_id.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(product,"Please fill id","Alert",JOptionPane.WARNING_MESSAGE);
                }
                else {
                    product.dispose();
                    JFrame m = new JFrame("Buy");
                    JTextField _msq = new JTextField(10);
                    JLabel lmsq = new JLabel("Message");
                    JButton msq = new JButton("Send");
                    JButton Buy = new JButton("Buy");
                    m.add(lmsq);
                    m.add(_msq);
                    m.add(msq);
                    m.add(Buy);
                    m.setVisible(true);
                    m.setBounds(250, 50, 500, 600);
                    m.setResizable(false);
                    m.setLayout(new FlowLayout());
                    m.getContentPane().setBackground(Color.orange);
                    m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    Buy.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                ct.buy(m, _id.getText());
                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    });
                    msq.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                ct.message(m,_id.getText(),_msq.getText());
                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    });
                }
            }
        });
        product.setVisible(true);
        product.setBounds(250,50,500,600);
        product.setResizable(false);
        product.setLayout(new FlowLayout());
        product.getContentPane().setBackground(Color.orange);
        product.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
