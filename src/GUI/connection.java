package GUI;

import javax.swing.*;
import java.sql.*;

public class connection {
    private Connection con;
    private PreparedStatement stmt;
    private String query;

    public connection() throws SQLException {
        con= DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","MAHcs6602021.");
    }
    public customer login(String user,String pass) throws SQLException {
        query="SELECT balance FROM users WHERE username ='"+user+"' AND password ='"+pass+"'";
        System.out.println(query);
        stmt=con.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        customer c = null;
        if(rs.next())
        {
            System.out.println("exist");
            //int bal= Integer.parseInt(rs.getString(1));
            float bal= Float.parseFloat(rs.getString(1));
            System.out.println(bal);
            c=new customer(user,bal);
        }
        else
        {System.out.println("not exist");
            c=null;}
        return c;
    }

    public void signup(JFrame temp,String user,String pass,String gen,String date,String balance) throws SQLException {
        int bal = Integer.parseInt(balance);
        System.out.println(bal);
        System.out.println(user);
        System.out.println(pass);
        System.out.println(gen);
        System.out.println(date);
        Statement stmt=con.createStatement();
        query="INSERT INTO `users` (`username`, `password`,`gender`, `date`,`balance`)"
                + "VALUES('" +user+"','"+pass+"','"+gen+"','"+date+"','"+bal+"')";
        System.out.println("INSERT INTO `users`" + " (`username`, `password`,`gender`, `date`,`balance`)"
                + "VALUES('" +user+"','"+pass+"','"+gen+"','"+date+"','"+bal+"')");
       // stmt.executeUpdate(query); // record added.
        if(stmt.executeUpdate(query)>0)
        {
            JOptionPane.showMessageDialog(temp,"Record Inserted","Message",JOptionPane.INFORMATION_MESSAGE);
        }
        else
            JOptionPane.showMessageDialog(temp,"Record Not Inserted","Message",JOptionPane.WARNING_MESSAGE);
        con.close();
    }


}