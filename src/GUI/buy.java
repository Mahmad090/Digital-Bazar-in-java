package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.concurrent.atomic.AtomicReference;

public class buy implements ActionListener {
    JFrame temp;
    Filter f;
    ActiveBuy ab;
    JFrame buy=new JFrame("Buy Product");
    JButton enter=new JButton("Enter Product Category");
    JButton view=new JButton("View Buy Products");
    JButton back=new JButton("Back");
    private customer ct;
    public buy(customer c, JFrame t)
    {
        ct=c;
        temp=t;
        buy.add(enter);
        buy.add(view);
        buy.add(back);
        back.addActionListener(this);
        view.addActionListener(this);
        enter.addActionListener(this);
        buy.setVisible(true);
        buy.setBounds(600,300,200,200);
        buy.setLayout(new FlowLayout());
        buy.setResizable(false);
        buy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buy.getContentPane().setBackground(Color.orange);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
if(e.getSource().equals(back))
{
    buy.dispose();
    temp.setVisible(true);
} else if (e.getSource().equals(enter)) {
    buy.setVisible(false);
    JFrame a=new JFrame("Enter Category");
    JButton enter=new JButton("Enter");
    String[] cat=new String[3];
    cat[0]="Electronics";
    cat[1]="Vehical";
    cat[2]="Furniture";
    JButton back=new JButton("Back");
    JComboBox _cat=new JComboBox(cat);
    a.add(_cat);
    a.add(enter);
    a.add(back);
    back.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            a.dispose();
            buy.setVisible(true);
        }
    });
    a.setVisible(true);
    a.setBounds(600,300,200,100);
    a.setLayout(new FlowLayout());
    a.setResizable(false);
    a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    a.getContentPane().setBackground(Color.orange);
    enter.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            a.dispose();
            JFrame b = new JFrame("Search By Name");
            JButton filter=new JButton("Apply Filter");

            if(cat[_cat.getSelectedIndex()].equals("Electronics")) {

               String[]  elect=new String[3];
               elect[0]="Laptop";
               elect[1]="Mobile";
               elect[2]="Air_Condition";
               JButton enter=new JButton("Search");
               AtomicReference<JButton> back= new AtomicReference<>(new JButton("Back"));
             JComboBox _elect=new JComboBox(elect);
             b.add(_elect);
             b.add(enter);
             b.add(filter);
             b.add(back.get());
                filter.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        b.dispose();
                        Filter f=new Filter(elect[_elect.getSelectedIndex()],b,ct);
                    }
                });
             back.get().addActionListener(e1 -> {
                 b.dispose();
                 a.setVisible(true);
             });
             enter.addActionListener(e12 -> {
                  b.dispose();
                 JButton ba=new JButton("Back");
                  JFrame product=new JFrame(String.valueOf(elect[_elect.getSelectedIndex()]));
                  JPanel[] p;
                  JLabel[] type;
                  JLabel[] id;
                  JLabel[] price;
                  JLabel[] cat1;
                  JLabel[] comp;
                 JLabel[] day;
                 JLabel[] month;
                 JLabel[] year;
                  JLabel[] a1;
                  JLabel[] b1;
                  JLabel[] seller;
                  JLabel[] install;
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
                  System.out.println("select count(*) from products where type='"+elect[_elect.getSelectedIndex()]+"'");
                  ResultSet resultSet = null;
                  try {
                      resultSet = statement.executeQuery("select count(*) from products where type='"+elect[_elect.getSelectedIndex()]+"' And seller !='"+ct.getUsername()+"'");
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
                 day=new JLabel[i];
                 month=new JLabel[i];
                 year=new JLabel[i];
                 type=new JLabel[i];
                 id=new JLabel[i];
                 price=new JLabel[i];
                 cat1 =new JLabel[i];
                 comp=new JLabel[i];
                 a1 =new JLabel[i];
                 b1 =new JLabel[i];
                 seller=new JLabel[i];
                 install=new JLabel[i];
                 i = 0;
                 try {
                     resultSet = statement.executeQuery("select * from products where type='"+elect[_elect.getSelectedIndex()]+"' And seller !='"+ct.getUsername()+"'");
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
                             seller[i] = new JLabel(resultSet.getString("seller"));
                             install[i]=new JLabel(resultSet.getString("installment"));
                         day[i]=new JLabel(resultSet.getString("day")+"-");
                         month[i]=new JLabel(resultSet.getString("month")+"-");
                         year[i]=new JLabel(resultSet.getString("year"));
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
                 product.add(ba);
                 ba.addActionListener(new ActionListener() {
                     @Override
                     public void actionPerformed(ActionEvent e) {
                         product.dispose();
                         b.setVisible(true);
                     }
                 });
                 product.setVisible(true);
                 product.setBounds(250,50,500,600);
                 product.setResizable(false);
                 product.setLayout(new FlowLayout());
                 product.getContentPane().setBackground(Color.orange);
                 product.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              });
            } else if (cat[_cat.getSelectedIndex()].equals("Vehical")) {
                String[]  elect=new String[2];
                elect[0]="Car";
                elect[1]="Bike";
                JButton enter=new JButton("Search");
                JButton back=new JButton("Back");
                JComboBox _elect=new JComboBox(elect);
                b.add(_elect);
                b.add(enter);
                b.add(filter);
                filter.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        b.dispose();
                        Filter f=new Filter(elect[_elect.getSelectedIndex()],b,ct);
                    }
                });
                b.add(back);
                back.addActionListener(e1 -> {
                    b.dispose();
                    a.setVisible(true);
                });
                enter.addActionListener(e12 -> {
                    b.dispose();
                    JButton ba=new JButton("Back");
                    JFrame product=new JFrame(String.valueOf(elect[_elect.getSelectedIndex()]));
                    JPanel[] p;
                    JLabel[] type;
                    JLabel[] id;
                    JLabel[] price;
                    JLabel[] cat1;
                    JLabel[] day;
                    JLabel[] month;
                    JLabel[] year;
                    JLabel[] comp;
                    JLabel[] a1;
                    JLabel[] b1;
                    JLabel[] seller;
                    JLabel[] install;
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
                    System.out.println("select count(*) from products where type='"+elect[_elect.getSelectedIndex()]+"'");
                    ResultSet resultSet = null;
                    try {
                        resultSet = statement.executeQuery("select count(*) from products where type='"+elect[_elect.getSelectedIndex()]+"' And seller !='"+ct.getUsername()+"'");
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
                        resultSet = statement.executeQuery("select * from products where type='"+elect[_elect.getSelectedIndex()]+"' And seller !='"+ct.getUsername()+"'");
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
                            seller[i] = new JLabel(resultSet.getString("seller"));
                            install[i]=new JLabel(resultSet.getString("installment"));
                            day[i]=new JLabel(resultSet.getString("day")+"-");
                            month[i]=new JLabel(resultSet.getString("month")+"-");
                            year[i]=new JLabel(resultSet.getString("year"));
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
                    product.add(ba);
                    ba.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            product.dispose();
                            b.setVisible(true);
                        }
                    });
                    product.setVisible(true);
                    product.setBounds(250,50,500,600);
                    product.setResizable(false);
                    product.setLayout(new FlowLayout());
                    product.getContentPane().setBackground(Color.orange);
                    product.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                });
            } else if (cat[_cat.getSelectedIndex()].equals("Furniture")) {
                String[]  elect=new String[3];
                elect[0]="Bed";
                elect[1]="Chair";
                elect[2]="Table";
                JButton enter=new JButton("Search");
                JButton back=new JButton("Back");
                JComboBox _elect=new JComboBox(elect);
                b.add(_elect);
                b.add(enter);
                b.add(filter);
                filter.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        b.dispose();
                        f=new Filter(elect[_elect.getSelectedIndex()],b,ct);
                    }
                });
                b.add(back);
                back.addActionListener(e1 -> {
                    b.dispose();
                    a.setVisible(true);
                });
                enter.addActionListener(e12 -> {
                    b.dispose();
                    JButton ba=new JButton("Back");
                    JFrame product=new JFrame(String.valueOf(elect[_elect.getSelectedIndex()]));
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
                    System.out.println("select count(*) from products where type='"+elect[_elect.getSelectedIndex()]+"'");
                    ResultSet resultSet = null;
                    try {
                        resultSet = statement.executeQuery("select count(*) from products where type='"+elect[_elect.getSelectedIndex()]+"' And seller !='"+ct.getUsername()+"'");
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
                        resultSet = statement.executeQuery("select * from products where type='"+elect[_elect.getSelectedIndex()]+"' And seller !='"+ct.getUsername()+"'");
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
                            seller[i] = new JLabel(resultSet.getString("seller"));
                            install[i]=new JLabel(resultSet.getString("installment"));
                            day[i]=new JLabel(resultSet.getString("day")+"-");
                            month[i]=new JLabel(resultSet.getString("month")+"-");
                            year[i]=new JLabel(resultSet.getString("year"));
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
                    product.add(ba);
                    ba.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            product.dispose();
                            b.setVisible(true);
                        }
                    });
                    product.setVisible(true);
                    product.setBounds(250,50,500,600);
                    product.setResizable(false);
                    product.setLayout(new FlowLayout());
                    product.getContentPane().setBackground(Color.orange);
                    product.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                });
            }

            b.setVisible(true);
            b.setBounds(600,300,200,150);
            b.setLayout(new FlowLayout());
            b.setResizable(false);
            b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            b.getContentPane().setBackground(Color.orange);
        }
    });
} else if (e.getSource().equals(view)) {
    buy.setVisible(false);
    try {
        ab=new ActiveBuy(buy,ct);
    } catch (SQLException ex) {
        throw new RuntimeException(ex);
    }
}
    }
}