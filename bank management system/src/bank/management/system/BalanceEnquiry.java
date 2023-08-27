
package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class BalanceEnquiry extends JFrame implements ActionListener{
    String pinNumber;
    JButton backButton;
    public BalanceEnquiry(String pinNumber) {
        this.pinNumber=pinNumber;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel imageJLabel=new JLabel(i3);
        imageJLabel.setBounds(0,0,900,900);
        add(imageJLabel);
           int balance=0;
           try{
                Conn c=new Conn();
                ResultSet rs= c.s.executeQuery("select * from bank where pinNumber = '"+pinNumber+"'");
             
                while(rs.next())
                {
                    if(rs.getString("type").equals("Deposit"))
                    {
                        balance+=Integer.parseInt(rs.getString("amount"));
                    }else if(rs.getString("type").equals("Withdraw")){
                        balance-=Integer.parseInt(rs.getString("amount"));
                    }
                }
                
            }catch(Exception e)
            {
                System.err.print(e);
            }
           
           JLabel balanceJLabel=new JLabel("Your Current Account Balance is:"+balance);
           balanceJLabel.setForeground(Color.WHITE);
           balanceJLabel.setFont(new Font("Raleway",Font.BOLD,14));
           balanceJLabel.setBounds(170,300,400,30);
           imageJLabel.add(balanceJLabel);
           
        backButton=new JButton("Back");
        backButton.setBounds(355,490,150,30);
        backButton.addActionListener(this);
        imageJLabel.add(backButton);
        
         setSize(900,900);
        setLocation(350,0);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
        new Transactions(pinNumber).setVisible(true);
    }
    
 }
