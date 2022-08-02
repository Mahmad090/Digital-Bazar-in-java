package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu implements ActionListener {
    private customer c;
    private Sell s;
    private GUI.buy b;
    private  rent r;
    private  Borrowed B;
    JFrame main=new JFrame("Main Menu");
    ImageIcon buy = new ImageIcon("D:\\java\\Project\\practice\\img\\Buy.png");
    ImageIcon sell= new ImageIcon("D:\\java\\Project\\practice\\img\\sell.png");
    ImageIcon rent = new ImageIcon("D:\\java\\Project\\practice\\img\\rent.png");
    ImageIcon balance = new ImageIcon("D:\\java\\Project\\practice\\img\\balance.png");
    ImageIcon borrow = new ImageIcon("D:\\java\\Project\\practice\\img\\borrow.png");

    JTextField empty=new JTextField(3);
    JTextField empty0=new JTextField(3);
    JLabel _buy = new JLabel(buy);
    JLabel _sell = new JLabel(sell);
    JLabel _rent = new JLabel(rent);
    JLabel _balance=new JLabel(balance);
    JLabel _borrow=new JLabel(borrow);
    JButton bborrow=new JButton("Borrow");
    JButton bbalance=new JButton("Balance");
    JButton bsell=new JButton("Sell");
    JButton bbuy=new JButton("Buy");
    JButton brent=new JButton("Rent");
    JTextField empty1=new JTextField(3);
    JTextField empty5=new JTextField(3);
    JTextField empty2=new JTextField(16);
    JTextField empty3=new JTextField(16);
    JTextField empty4=new JTextField(16);
    JTextField empty6=new JTextField(16);
    public MainMenu(customer temp)
    {
        c=temp;
        empty.setEditable(false);
        empty.setBorder(null);
        empty.setBackground(Color.ORANGE);
        empty5.setEditable(false);
        empty5.setBorder(null);
        empty5.setBackground(Color.orange);
        empty6.setEditable(false);
        empty6.setBorder(null);
        empty6.setBackground(Color.orange);
        empty0.setEditable(false);
        empty0.setBorder(null);
        empty0.setBackground(Color.ORANGE);
        empty1.setEditable(false);
        empty1.setBorder(null);
        empty1.setBackground(Color.ORANGE);
        empty2.setEditable(false);
        empty2.setBorder(null);
        empty2.setBackground(Color.ORANGE);
        empty3.setEditable(false);
        empty3.setBorder(null);
        empty3.setBackground(Color.ORANGE);
        empty4.setEditable(false);
        empty4.setBorder(null);
        empty4.setBackground(Color.ORANGE);
        bbuy.addActionListener( this);
        bbalance.addActionListener( this);
        brent.addActionListener( this);
        bsell.addActionListener( this);
        bborrow.addActionListener(this);
        _balance.setBounds(0,0,200,200);
        _sell.setBounds(0,0,200,200);
        _rent.setBounds(0,0,200,200);
        _buy.setBounds(0,0,200,200);
        _borrow.setBounds(0,0,200,200);
        bsell.setBounds(100,0,10,20);
        brent.setBounds(100,0,10,20);
        bbalance.setBounds(100,0,10,20);
        bbuy.setBounds(0,0,10,20);
        main.add(_buy);
        main.add(empty);
        main.add(_sell);
        main.add(empty0);
        main.add(_rent);
        main.add(empty1);
        main.add(_borrow);
        main.add(empty5);
        main.add(_balance);
        main.add(bbuy);
        main.add(empty2);
        main.add(bsell);
        main.add(empty3);
        main.add(brent);
        main.add(empty4);
        main.add(bborrow);
        main.add(empty6);
        main.add(bbalance);
        main.setBounds(150,100,1200,280);
        main.setVisible(true);
        main.setLayout(new FlowLayout(FlowLayout.CENTER));
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // main.setResizable(false);
        main.getContentPane().setBackground(Color.orange);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
if(e.getSource().equals(bsell))
{
    main.dispose();
    s=new Sell(c,main);
} else if (e.getSource().equals(bbuy)) {
    main.dispose();
     b=new buy(c,main);
} else if (e.getSource().equals(brent)) {
    main.dispose();
    r=new rent(c,main);
} else if (e.getSource().equals(bborrow)) {
    main.dispose();
    B=new Borrowed(main,c);
}

    }
}