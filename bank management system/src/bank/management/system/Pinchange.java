
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Pinchange extends JFrame implements ActionListener {
    String pinNumber;
    JPasswordField npinField,rnpinField;
    JButton changeButton,backButton;
    public Pinchange(String pinNumber) {
        setLayout(null);
        this.pinNumber=pinNumber;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel imageJLabel=new JLabel(i3);
        imageJLabel.setBounds(0,0,900,900);
        add(imageJLabel);
           
        JLabel text =new JLabel("Change Your Pin");
        text.setForeground(Color.WHITE);
        text.setBounds(250,280,500,35);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        imageJLabel.add(text);
        
        JLabel pintext =new JLabel("New Pin: ");
        pintext.setForeground(Color.WHITE);
        pintext.setBounds(165  ,320,180,25);
        pintext.setFont(new Font("Raleway",Font.BOLD,16));
        imageJLabel.add(pintext);
        
        npinField=new JPasswordField();
        npinField.setBounds(330,320,180,25);
         npinField.setFont(new Font("Raleway",Font.BOLD,25));
         imageJLabel.add(npinField);
        
        JLabel repintext =new JLabel("Re-enter  New Pin: ");
        repintext.setForeground(Color.WHITE);
        repintext.setBounds(165  ,360,180,25);
        repintext.setFont(new Font("Raleway",Font.BOLD,16));
        imageJLabel.add(repintext);
        
          rnpinField=new JPasswordField();
        rnpinField.setBounds(330,360,180,25);
         rnpinField.setFont(new Font("Raleway",Font.BOLD,25));
         imageJLabel.add(rnpinField);
        
         changeButton=new JButton("Change");
         changeButton.setBounds(355,485,150,30);
         changeButton.addActionListener(this);
         imageJLabel.add(changeButton);
         
         
         backButton=new JButton("Back");
         backButton.setBounds(355,520,150,30);
         backButton.addActionListener(this);
         imageJLabel.add(backButton);
        
        
        
        
           setSize(900,900);
        setLocation(350,0);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==changeButton)
        {
         String newPinString=npinField.getText();
         String renewPinString=rnpinField.getText();
         if(newPinString.equals("") || renewPinString.equals(""))
         {
             JOptionPane.showMessageDialog(null, "Please Enter the New Pin");
             return;
         }else if(!newPinString.equals(renewPinString))
         {
             JOptionPane.showMessageDialog(null, "Entered Pin Doesn't Match");
             return;
         }else{
             try{
                 Conn c=new Conn();
                 
                 String query1="update bank set pinNumber = '"+newPinString+"' where pinNumber = '"+pinNumber+"'";
                  String query2="update login set pinNumber = '"+newPinString+"' where pinNumber = '"+pinNumber+"'";
                   String query3="update signupthree set pinNumber = '"+newPinString+"' where pinNumber = '"+pinNumber+"'";
                   c.s.executeUpdate(query1);
                   c.s.executeUpdate(query2);
                   c.s.executeUpdate(query3);
                    JOptionPane.showMessageDialog(null, "Pin changed Successfully");
                    setVisible(false);
                    new Transactions(newPinString).setVisible(true);
             }catch(Exception e)
             {
                 System.out.print(e);
             }
         }
        }else if(ae.getSource()==backButton)
        {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }
    
   
}
