
package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.sql.*;
import javax.swing.JOptionPane;
import java.util.Date;

public class Fastcash extends JFrame implements ActionListener {
       
    
    JButton button200,button100,button500,button2000,button5000,button10000,backbutton;
    String pinNumber;
    public Fastcash(String pinNumber) {
        this.pinNumber=pinNumber;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image  i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("Please Select a Withdrawl Amount");
        text.setBounds(210,300,700,35);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setForeground(Color.WHITE);
        image.add(text);
        
         button100=new JButton("100");
        button100.setBounds(170,415,150,30);
        button100.addActionListener(this);
        image.add(button100);
        
          button200=new JButton("200");
        button200.setBounds(355,415,150,30);
        button200.addActionListener(this);
        image.add(button200);
        
          button500=new JButton("500");
        button500.setBounds(170,450,150,30);
        button500.addActionListener(this);
        image.add(button500);
        
          button2000=new JButton("2000");
        button2000.setBounds(355,450,150,30);
        button2000.addActionListener(this);
        image.add(button2000);
        
          button5000=new JButton("5000");
        button5000.setBounds(170,485,150,30);
        button5000.addActionListener(this);
        image.add(button5000);
        
          button10000 =new JButton("10000");
        button10000.setBounds(355,485,150,30);
        button10000.addActionListener(this);
        image.add(button10000);
        
         backbutton=new JButton("Back");
        backbutton.setBounds(355,520,150,30);
        backbutton.addActionListener(this);
        image.add(backbutton);
        
        
        
        
        
        setSize(900,900);
        setLocation(350,0);
        setUndecorated(true);
         setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==backbutton)
        {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
            
        }else {
            String amountString=((JButton)ae.getSource()).getText();
            
            try{
                Conn c=new Conn();
                ResultSet rs= c.s.executeQuery("select * from bank where pinNumber = '"+pinNumber+"'");
                int balance=0;
                while(rs.next())
                {
                    if(rs.getString("type").equals("Deposit"))
                    {
                        balance+=Integer.parseInt(rs.getString("amount"));
                    }else if(rs.getString("type").equals("Withdraw")){
                        balance-=Integer.parseInt(rs.getString("amount"));
                    }
                    
                    if(ae.getSource()!=backbutton && balance<Integer.parseInt(amountString))
                    {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }
                        
                    Date date=new Date();
                    String query ="insert into bank values('"+pinNumber+"','"+date+"','Withdraw','"+amountString+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs "+amountString+" Debited Successfully");
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }
                
            }catch(Exception e)
            {
                System.err.print(e);
            }
        }
    }
    

}
