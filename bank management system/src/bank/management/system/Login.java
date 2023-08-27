
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
    JButton signInButton,clearButton,signUpButton;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login(){
          setTitle("AUTOMATED TELLER MACHINE");
          setLayout(null);
          ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
          Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT); 
          ImageIcon i3=new ImageIcon(i2);
          JLabel label = new JLabel(i3);
          label.setBounds(70,10,100,100);
          add(label);
          JLabel text=new JLabel("Welcome to ATM");
          text.setFont(new Font("Osward",Font.BOLD,40));
          text.setBounds(200,40,400,40);
          add(text);
          JLabel cardno=new JLabel("Card No:");
          cardno.setFont(new Font("Raleway",Font.BOLD,28));
          cardno.setBounds(120,150,150,40);
          add(cardno);
           cardTextField=new JTextField();
          cardTextField.setBounds(300,150,250,40);
          cardTextField.setFont(new Font("Raleway",Font.BOLD,15));
          add(cardTextField);
          JLabel Pin=new JLabel("PIN:");
          Pin.setFont(new Font("Raleway",Font.BOLD,28));
          Pin.setBounds(120,220,150,40);
          add(Pin);
            pinTextField=new JPasswordField();
            pinTextField.setBounds(300,220,250,40);
            pinTextField.setFont(new Font("Raleway",Font.BOLD,15));
            add(pinTextField);
          
           signInButton=new JButton("SIGN IN");
          signInButton.setBounds(300,300,100,30);
          signInButton.setBackground(Color.BLACK);
          signInButton.setForeground(Color.WHITE);
           signInButton.addActionListener(this);
          add(signInButton);
           clearButton=new JButton("CLEAR");
          clearButton.setBounds(450,300,100,30);
          clearButton.setBackground(Color.BLACK);
          clearButton.setForeground(Color.WHITE);
           clearButton.addActionListener(this);
           add(clearButton);
           signUpButton=new JButton("SIGN UP");
          signUpButton.setBounds(300,350,250,30);
          signUpButton.setBackground(Color.BLACK);
          signUpButton.setForeground(Color.WHITE);
          signUpButton.addActionListener(this);
          add(signUpButton);
          
          getContentPane().setBackground(Color.white);
          
          
          
          setSize(800,480);
          setVisible(true);
          setLocation(350,200);
          
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==clearButton)
        {
                pinTextField.setText("");
                cardTextField.setText("");
        }else if(ae.getSource()==signInButton)
        {
         Conn c=new Conn();
         String cardNumberString=cardTextField.getText();
         String PinString=pinTextField.getText();
         String query="select * from login where cardNumber = '"+cardNumberString+"' and pinNumber = '"+PinString+"'";
         try{
            ResultSet rs= c.s.executeQuery(query);
            if(rs.next())
            {
                setVisible(false);
                new Transactions(PinString).setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
            }
         }catch(Exception e)
         {
             System.out.print(e);
         }
            
        }else if(ae.getSource()==signUpButton)
        {
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
    public static void main(String args[])
    {
        new Login();
    }
}
