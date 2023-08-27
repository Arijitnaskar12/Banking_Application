
package bank.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;

public class Withdraw extends JFrame implements ActionListener{

    
    JButton withdraw,back;
    String pinNumber;
    JTextField amount;
    public Withdraw(String pinNumber) {
        this.pinNumber=pinNumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("Enter The Amount You Want to Withdraw");
        text.setBounds(170,300,400,20);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setForeground(Color.WHITE);
        image.add(text);
        
         amount=new JTextField();
        amount.setBounds(170,350,320,30);
         amount.setFont(new Font("Raleway",Font.BOLD,22));
         image.add(amount);
        
         withdraw=new JButton("Withdraw");
        withdraw.setBounds(355,485,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
          back=new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        
        
        setSize(900,900);
        setLocation(350,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==withdraw){
            String  InputAmountString=amount.getText();
            Date date=new Date();
            
            if(InputAmountString.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please Enter The Amount You Want To Withdraw");
            }else{
                try{
                Conn c=new Conn();
                String query ="insert into bank values('"+pinNumber+"','"+date+"','Withdraw','"+InputAmountString+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+InputAmountString+" Withdraw Successfully");
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }catch(Exception e)
                {
                    System.out.println(e);
                }
            }
            
        }else if(ae.getSource()==back)
        {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }
       
}
