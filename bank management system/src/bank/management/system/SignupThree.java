
package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class SignupThree extends JFrame implements ActionListener{
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    public SignupThree(String formno) {
        this.formno=formno;
        setLayout(null);
        JLabel l1=new JLabel("Page-3:Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);
        
        
        JLabel type=new JLabel("Account Type");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,140,200,30);
        add(type);
        
        r1=new JRadioButton("Savings Account");
         r1.setFont(new Font("Raleway",Font.BOLD,16));
         r1.setBounds(100,190,200,30);
         r1.setBackground(Color.WHITE);
         add(r1);
         r2=new JRadioButton("Current Account");
         r2.setFont(new Font("Raleway",Font.BOLD,16));
         r2.setBounds(450,190,200,30);
         r2.setBackground(Color.WHITE);
         add(r2);
         r3=new JRadioButton("Fixed Deposit Account");
         r3.setFont(new Font("Raleway",Font.BOLD,16));
         r3.setBackground(Color.WHITE);
         r3.setBounds(100,240,300,30);
         add(r3);
         r4=new JRadioButton("Recurring Account");
         r4.setFont(new Font("Raleway",Font.BOLD,16));
         r4.setBounds(450,240,300,30);
         r4.setBackground(Color.WHITE);
         add(r4);
        
         ButtonGroup accountsButtonGroup=new ButtonGroup();
         accountsButtonGroup.add(r1);
         accountsButtonGroup.add(r2);
          accountsButtonGroup.add(r3);
         accountsButtonGroup.add(r4);
         
         
         JLabel card=new JLabel("Card Number:");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,300,200,30);
        add(card);
        
        
        JLabel number=new JLabel("XXXX-XXXX-XXXX-5148");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(330,300,300,30);
        add(number);
        
        JLabel cardDetails=new JLabel("(Your 16 digit Card Number)");
        cardDetails.setFont(new Font("Raleway",Font.BOLD,12));
        cardDetails.setBounds(100,320,300,30);
        add(cardDetails);
        
         JLabel pin=new JLabel("PIN Number:");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,350,200,30);
        add(pin);
        
        
        JLabel Pnumber=new JLabel("XXXX");
        Pnumber.setFont(new Font("Raleway",Font.BOLD,22));
        Pnumber.setBounds(330,350,300,30);
        add(Pnumber);
        
         JLabel pindetails=new JLabel("(Your 4 digit PIN Number)");
        pindetails.setFont(new Font("Raleway",Font.BOLD,12));
        pindetails.setBounds(100,370,300,30);
        add(pindetails);
        
        
        JLabel services=new JLabel("Services Required:");
        services.setFont(new Font("Raleway",Font.BOLD,22));
        services.setBounds(100,450,300,30);
        add(services);
        
        
        c1=new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
          c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,500,200,30);
        add(c1);
         c2=new JCheckBox("Check Book");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,500,200,30);
        add(c2);
         c3=new JCheckBox("Internet Banking");
        c3.setBackground(Color.WHITE);
        c3.setBounds(100,550,250,30);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        add(c3);
         c4=new JCheckBox("Mobile Banking");
        c4.setBackground(Color.WHITE);
        c4.setBounds(350,550,250,30);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        add(c4);
         c5=new JCheckBox("EMAIL & SMS Alerts");
        c5.setBackground(Color.WHITE);
        c5.setBounds(100,600,200,30);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        add(c5);
         c6=new JCheckBox("E-Statements");
        c6.setBackground(Color.WHITE);
        c6.setBounds(350,600,200,30);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        add(c6);
         c7=new JCheckBox("I hereby declares that above entered details are correct to the best of  my knowledge ");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100,680,800,30);
        add(c7);
        
        submit=new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,16));
        submit.setBounds(250,720,100,30);
        submit.addActionListener(this);
        add(submit);
        
        
        cancel=new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,16));
        cancel.setBounds(420,720,100,30);
        cancel.addActionListener(this);
        add(cancel);
        getContentPane().setBackground(Color.WHITE);
            setSize(850,820);
          setVisible(true);
          setLocation(350,0);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==submit)
        {
            String accountTypeString="";
            if(r1.isSelected())
            {
                accountTypeString="Savings Account";
            }else if(r2.isSelected())
            {
                accountTypeString="Current Account";
            }else if(r3.isSelected())
            {
                accountTypeString="Fixed Deposit Account";
            }else if(r4.isSelected())
            {
                accountTypeString="Recurring Account";
            }
            Random random=new Random();
            String cardNumberString=""+Math.abs((random.nextLong()% 9000000000000000L) + 1000000000000000L);
            String pinNumberString=""+(random.nextInt(9000) + 1000);
            
            String facilityString="";
            
           if(c1.isSelected())
           {
               facilityString+=" ATM card";
           }
           if(c2.isSelected())
           {
               facilityString+=" Chcek book";
           }
           if(c3.isSelected())
           {
               facilityString+=" Internet Banking";
           }
           if(c4.isSelected())
           {
               facilityString+=" Mobile banking";
           }
           if(c5.isSelected())
           {
               facilityString+=" Email and Sms Alerts";
           }
           if(c6.isSelected())
           {
               facilityString+=" E-statements";
           }
           
           String declerationString="";
           if(c7.isSelected())
           {
               declerationString="Accepted";
           }
           try{
            if((accountTypeString.equals(""))|| (facilityString.equals("")) ||  (declerationString.equals("")))
            {
                JOptionPane.showMessageDialog(null, "All filleds are required");
            }else{
                Conn c=new Conn();
                String query1="insert into signupthree values('"+formno+"','"+accountTypeString+"','"+cardNumberString+"','"+pinNumberString+"','"+facilityString+"')";
                String query2="insert into login values('"+formno+"','"+cardNumberString+"','"+pinNumberString+"')";
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null,"Card Number: " +cardNumberString+ "\n Pin: "+pinNumberString);
                setVisible(false);
                new Deposit(pinNumberString).setVisible(true);
            }
               
           }catch(Exception e)
           {
               System.out.print(e);
           }
        }else if(ae.getSource()==cancel)
        {
            setVisible(false);
            new Login().setVisible(true);
        }
    }
     
}
