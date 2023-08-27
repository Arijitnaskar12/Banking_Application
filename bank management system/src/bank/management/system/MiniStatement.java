
package bank.management.system;

import java.awt.Color;
import javax.swing.*;
import javax.swing.JLabel;
import java.sql.*;


public class MiniStatement extends JFrame {
    String pinNumber;
    public MiniStatement(String pinNumber) {
        this.pinNumber=pinNumber;
        setTitle("Mini Statement");
        setLayout(null);
        
        JLabel miniJLabel=new JLabel();
        miniJLabel.setBounds(20,140,400,200);
        add(miniJLabel);
        
        JLabel bankJLabel=new JLabel("Indian Kinara Bank");
        bankJLabel.setBounds(150,20,200,20);
        add(bankJLabel);
        
         JLabel cardJLabel=new JLabel();
        cardJLabel.setBounds(20,80,300,20);
        add(cardJLabel);
        
        JLabel balanceJLabel=new JLabel();
        balanceJLabel.setBounds(20,400,300,20);
        add(balanceJLabel);
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from login Where pinNumber = '"+pinNumber+"'");
            while(rs.next())
            {
                cardJLabel.setText("Card No: "+rs.getString("cardNumber").substring(0,4)+"XXXXXXXX"+rs.getString("cardNumber").substring(12));
            }
        }catch(Exception e){
            System.out.print(e);
        }
        int bal=0;
         try{
            Conn c=new Conn();
            
            ResultSet rs=c.s.executeQuery("select * from bank Where pinNumber = '"+pinNumber+"'");
            while(rs.next())
            {
               miniJLabel.setText(miniJLabel.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
                if(rs.getString("type").equals("Deposit"))
                    {
                        bal+=Integer.parseInt(rs.getString("amount"));
                    }else if(rs.getString("type").equals("Withdraw")){
                        bal-=Integer.parseInt(rs.getString("amount"));
                    }
                        
            }
        }catch(Exception e){
            System.out.print(e);
        }
        balanceJLabel.setText("Your Current Account Balance is:"+bal);
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    
       
}
