package GUI;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class customer {
    private String username;
    private float balance;
    private Connection con;
    private String query;

    public customer() throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "MAHcs6602021.");
        this.username = " ";
        this.balance = 0;
    }

    public customer(String username, float balance) throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "MAHcs6602021.");
        this.username = username;
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public float getBalance() {
        return balance;
    }
    public void sell(Frame temp, String type, String id, float price, String cat, String a, String b, String c, String install, int day, int month, int year) throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "MAHcs6602021.");
        Statement stmt = con.createStatement();
        System.out.println(install);
        //query="SELECT balance FROM `users` WHERE `username` =? AND `password` =?";
        query = "INSERT INTO `products`" + " (`type`, `seller`,`price`, `category`,`id`,`a`,`b`,`c`,`installment`,`day`,`month`,`year`)"
                + "VALUES('" + type + "','" + username + "','" + price + "','" + cat + "','" + id + "','" + a + "','" + b + "','" + c + "','" + install + "','" + day + "','" + month + "','" + year + "')";
        if (stmt.executeUpdate(query) > 0) {
            JOptionPane.showMessageDialog(temp, "Record Inserted", "Message", JOptionPane.INFORMATION_MESSAGE);
        } else
            JOptionPane.showMessageDialog(temp, "Record Not Inserted", "Message", JOptionPane.WARNING_MESSAGE);
        con.close();
    }

    public void remove(String id, JFrame temp) throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "MAHcs6602021.");
        Statement stmt = con.createStatement();
        //query="SELECT balance FROM `users` WHERE `username` =? AND `password` =?";
        query = "DELETE  FROM products where id='" + id + "' And seller='" + username + "'";
        System.out.println(query);
        if (stmt.executeUpdate(query) > 0) {
            JOptionPane.showMessageDialog(temp, "Record Deleted", "Message", JOptionPane.INFORMATION_MESSAGE);
        } else
            JOptionPane.showMessageDialog(temp, "Record Not Deleted", "Message", JOptionPane.WARNING_MESSAGE);
        con.close();
    }
    public void removerent(String id, JFrame temp) throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "MAHcs6602021.");
        Statement stmt = con.createStatement();
        //query="SELECT balance FROM `users` WHERE `username` =? AND `password` =?";
        query = "DELETE  FROM rental where id='" + id + "' And seller='" + username + "'";
        System.out.println(query);
        if (stmt.executeUpdate(query) > 0) {
            JOptionPane.showMessageDialog(temp, "Record Deleted", "Message", JOptionPane.INFORMATION_MESSAGE);
        } else
            JOptionPane.showMessageDialog(temp, "Record Not Deleted", "Message", JOptionPane.WARNING_MESSAGE);
        con.close();
    }
    public void buy(JFrame temp, String id) throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "MAHcs6602021.");
        Statement stmt = con.createStatement();
        ResultSet resultSet;

        try {
            resultSet = stmt.executeQuery("select * from products where id='" + id + "'");
            System.out.println("select * from products where id='" + id + "'");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        String type="",cat="",a="",b="",c="",day="",month="",year="",seller="",install=" ";
        float price = 0;
        while (true) {
            try {
                if (!resultSet.next()) break;
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            try {
                type = resultSet.getString("type");
                price = resultSet.getFloat("price");
                cat = resultSet.getString("category");
                a = resultSet.getString("a");
                b = resultSet.getString("b");
                c = resultSet.getString("c");
                day = resultSet.getString("day");
                month = resultSet.getString("month");
                year = resultSet.getString("year");
                seller = resultSet.getString("seller");
                install = resultSet.getString("installment");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
            if(balance<price)
            {
                JOptionPane.showMessageDialog(temp,"You have less balance in your account","Alert Message",JOptionPane.WARNING_MESSAGE);
            }
            else
            {
                query = "INSERT INTO `sold`  (`type`, `seller`,`price`, `category`,`id`,`a`,`b`,`c`,`installment`,`day`,`month`,`year`,`buyer`)"
                        + "VALUES('" + type + "','" + seller + "','" + price + "','" + cat + "','" + id + "','" + a + "','" + b + "','" + c + "','" + install + "','" + day + "','" + month + "','" + year + "','"+username+"')";
            System.out.println(query);
            if (stmt.executeUpdate(query) > 0) {
                JOptionPane.showMessageDialog(temp, "Buyed", "Message", JOptionPane.INFORMATION_MESSAGE);
                balance=balance-price;
                query = "update users set balance='" + balance + "' where username='"+username+"'";
                System.out.println(query);
                stmt.executeUpdate(query);
                query = "update users set balance=balance+'" + price + "' where username='"+seller+"'";
                System.out.println(query);
                stmt.executeUpdate(query);
            } else
                JOptionPane.showMessageDialog(temp, "Not Buyed", "Message", JOptionPane.WARNING_MESSAGE);
            }
        query = "DELETE  FROM products where id='" + id + "'";
        System.out.println(query);
        stmt.executeUpdate(query) ;

           // System.out.println(type+" "+id+" "+price+" "+cat+" "+a+" "+b+" "+c+" "+seller);


        con.close();
    }
    public void sellrent(Frame temp, String type, String id, float price, String cat, String a, String b, String c, String fine, int day, int month, int year,int rentday) throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "MAHcs6602021.");
        Statement stmt = con.createStatement();
        //query="SELECT balance FROM `users` WHERE `username` =? AND `password` =?";
        query = "INSERT INTO `rental`" + " (`type`, `seller`,`price`, `category`,`id`,`a`,`b`,`c`,`day`,`month`,`year`,`fine`,`rentdays`)"
                + "VALUES('" + type + "','" + username + "','" + price + "','" + cat + "','" + id + "','" + a + "','" + b + "','" + c + "','" + day + "','" + month + "','" + year + "','"+fine+"','"+rentday+"')";
        if (stmt.executeUpdate(query) > 0) {
            JOptionPane.showMessageDialog(temp, "Record Inserted", "Message", JOptionPane.INFORMATION_MESSAGE);
        } else
            JOptionPane.showMessageDialog(temp, "Record Not Inserted", "Message", JOptionPane.WARNING_MESSAGE);
        con.close();
    }
    public void message(JFrame temp, String id, String msq) throws SQLException {

        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "MAHcs6602021.");
        Statement stmt = con.createStatement();
        query="SELECT seller FROM products WHERE id ='"+id+"'";
        System.out.println(query);
        stmt=con.prepareStatement(query);
        ResultSet rs = stmt.executeQuery(query);
        String reciever  = null;
        if(rs.next()){
            reciever = rs.getString(1);
            System.out.println(reciever);
        }
        query = "INSERT INTO `message`  (`sender`, `receiver`,`message`,`productid`)"
                + "VALUES('" + username + "','" + reciever + "','" + msq + "','"+id+"')";
        System.out.println(query);
        if (stmt.executeUpdate(query) > 0) {
            JOptionPane.showMessageDialog(temp, "Record Inserted", "Message", JOptionPane.INFORMATION_MESSAGE);
        } else
            JOptionPane.showMessageDialog(temp, "Record Not Inserted", "Message", JOptionPane.WARNING_MESSAGE);
        con.close();
    }
    public void borrow(JFrame temp, String id,String day,String month,String year) throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "MAHcs6602021.");
        Statement stmt = con.createStatement();
        ResultSet resultSet;

        try {
            resultSet = stmt.executeQuery("select * from rental where id='" + id + "'");
            System.out.println("select * from rental where id='" + id + "'");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        String type="",cat="",a="",b="",c="",seller="",fine=" ";
        float price = 0;
        int rentday=0;
        while (true) {
            try {
                if (!resultSet.next()) break;
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            try {
                type = resultSet.getString("type");
                price = resultSet.getFloat("price");
                cat = resultSet.getString("category");
                a = resultSet.getString("a");
                b = resultSet.getString("b");
                c = resultSet.getString("c");
                seller = resultSet.getString("seller");
                fine = resultSet.getString("fine");
                rentday=resultSet.getInt("rentdays");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        if(balance<price)
        {
            JOptionPane.showMessageDialog(temp,"You have less balance in your account","Alert Message",JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            query = "INSERT INTO `borrowed`  (`type`, `seller`,`price`, `category`,`id`,`a`,`b`,`c`,`fine`,`day`,`month`,`year`,`borrower`,`rentdays`)"
                    + "VALUES('" + type + "','" + seller + "','" + price + "','" + cat + "','" + id + "','" + a + "','" + b + "','" + c + "','" + fine + "','" + day + "','" + month + "','" + year + "','"+username+"','"+rentday+"')";
            System.out.println(query);
            if (stmt.executeUpdate(query) > 0) {
                JOptionPane.showMessageDialog(temp, "Borrowed", "Message", JOptionPane.INFORMATION_MESSAGE);
                balance=balance-price;
                query = "update users set balance='" + balance + "' where username='"+username+"'";
                System.out.println(query);
                stmt.executeUpdate(query);
                query = "update users set balance=balance+'" + price + "' where username='"+seller+"'";
                System.out.println(query);
                stmt.executeUpdate(query);
            } else
                JOptionPane.showMessageDialog(temp, "Not Buyed", "Message", JOptionPane.WARNING_MESSAGE);
        }
        query = "DELETE  FROM rental where id='" + id + "'";
        System.out.println(query);
        stmt.executeUpdate(query) ;

        // System.out.println(type+" "+id+" "+price+" "+cat+" "+a+" "+b+" "+c+" "+seller);


        con.close();
    }
    public int checkfine(JFrame temp, String id,int day,int month,int year) throws SQLException {
        int checkfine= 0;
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "MAHcs6602021.");
        Statement stmt = con.createStatement();
        ResultSet resultSet;
        try {
            resultSet = stmt.executeQuery("select * from borrowed where id='" + id + "'");
            System.out.println("select * from borrowed where id='" + id + "'");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        int Day= 0,Month= 0,Year= 0,fine= 0;
        int rentdays = 0;
        while (true) {
            try {
                if (!resultSet.next()) break;
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            try {
                Day = Integer.parseInt(resultSet.getString("day"));
                Month = Integer.parseInt(resultSet.getString("month"));
                Year = Integer.parseInt(resultSet.getString("year"));
                fine = Integer.parseInt(resultSet.getString("fine"));
                rentdays = resultSet.getInt("rentdays");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        checkfine=((((year-Year)*365)+((month-Month)*30)+(day-Day))-rentdays)*fine;
        return checkfine;
    }
        public boolean edit ( float a, String b, String c, String d, String id) throws SQLException {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "MAHcs6602021.");
            PreparedStatement ps = null;
            String query = "update products set price='" + a + "',a='" + b + "',b='" + c + "',c='" + d + "' where Id='" + id + "' AND seller='" + username + "'";
            System.out.println(query);
            ps = con.prepareStatement(query);
            if (ps.executeUpdate() > 0) {
                System.out.println("Record is updated successfully......");
                return true;
            } else return false;
        }
    public boolean rentedit ( float a, String b, String c, String d, String id,String fine,int rentday) throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "MAHcs6602021.");
        PreparedStatement ps = null;
        String query = "update rental set price='" + a + "',a='" + b + "',b='" + c + "',c='" + d + "',fine='"+fine+"',rentdays='"+rentday+"' where Id='" + id + "' AND seller='" + username + "'";
        System.out.println(query);
        ps = con.prepareStatement(query);
        if (ps.executeUpdate() > 0) {
            System.out.println("Record is updated successfully......");
            return true;
        } else return false;
    }
}