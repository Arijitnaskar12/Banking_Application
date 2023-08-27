
package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Transactions extends JFrame implements ActionListener {
       
    
    JButton cashwithdrawButton,depositButton,fastcashButton,balanceButton,pinchangeButton,ministatementButton,exitButton;
    String pinNumber;
    public Transactions(String pinNumber) {
        this.pinNumber=pinNumber;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image  i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("Please select your transaction");
        text.setBounds(210,300,700,35);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setForeground(Color.WHITE);
        image.add(text);
        
         depositButton=new JButton("Deposit");
        depositButton.setBounds(170,415,150,30);
        depositButton.addActionListener(this);
        image.add(depositButton);
        
          cashwithdrawButton=new JButton("Cash Withdraw");
        cashwithdrawButton.setBounds(355,415,150,30);
        cashwithdrawButton.addActionListener(this);
        image.add(cashwithdrawButton);
        
          fastcashButton=new JButton("Fast Cash");
        fastcashButton.setBounds(170,450,150,30);
        fastcashButton.addActionListener(this);
        image.add(fastcashButton);
        
          ministatementButton=new JButton("Mini Statement");
        ministatementButton.setBounds(355,450,150,30);
        ministatementButton.addActionListener(this);
        image.add(ministatementButton);
        
          pinchangeButton=new JButton("Pin Change");
        pinchangeButton.setBounds(170,485,150,30);
        pinchangeButton.addActionListener(this);
        image.add(pinchangeButton);
        
          balanceButton=new JButton("Balance Enquiry");
        balanceButton.setBounds(355,485,150,30);
        balanceButton.addActionListener(this);
        image.add(balanceButton);
        
         exitButton=new JButton("Exit");
        exitButton.setBounds(355,520,150,30);
        exitButton.addActionListener(this);
        image.add(exitButton);
        
        
        
        
        
        setSize(900,900);
        setLocation(350,0);
        setUndecorated(true);
         setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==depositButton)
        {
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
            
        }else if(ae.getSource()==cashwithdrawButton)
        {
            setVisible(false);
            new Withdraw(pinNumber).setVisible(true);
        }else if(ae.getSource()==fastcashButton)
        {
            setVisible(false);
            new Fastcash(pinNumber).setVisible(true);
        }else if(ae.getSource()==ministatementButton)
        {
            setVisible(false);
         new MiniStatement(pinNumber).setVisible(true);
         
        }else if(ae.getSource()==balanceButton)
        {
            setVisible(false);
            new BalanceEnquiry(pinNumber).setVisible(true);
            
        }else if(ae.getSource()==pinchangeButton)
        {
            setVisible(false);
            new Pinchange(pinNumber).setVisible(true);
            
        }else if(ae.getSource()==exitButton)
        {
            System.exit(0);
        }
    }
    
  
}
