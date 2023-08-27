
package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
public class SignupOne extends JFrame implements ActionListener{
    long random;
    JTextField nameTextField,fnameTextField,emailTextField,addressTextField,cityTextField,stateTextField,pincodeTextField;
   JRadioButton maleButton,femaleButton,others,married,unmarried;
     JButton nextButton;
     JDateChooser dateChooser;
     SignupOne() {
           setTitle("NEW APPLICATION FORM-1");
         setLayout(null);
          Random ran=new Random();
          random=Math.abs((ran.nextLong()%9000L)+1000L);
         JLabel formno=new JLabel("APPLICATION FORM NO-"+random);
         formno.setFont(new Font("Raleway",Font.BOLD,38));
         formno.setBounds(140,20,600,40);
         add(formno);
          JLabel personalDetails=new JLabel("Page 1: Personal Details");
         personalDetails.setFont(new Font("Raleway",Font.BOLD,22));
         personalDetails.setBounds(290,80,400,30);
         add(personalDetails);
         
          JLabel name=new JLabel("Name:");
         name.setFont(new Font("Raleway",Font.BOLD,22));
         name.setBounds(100,140,100,30);
         add(name);
         
           nameTextField=new JTextField();
         nameTextField.setFont(new Font("Raleway",Font.BOLD,22));
         nameTextField.setBounds(300,140,400,30);
         add(nameTextField);
         
         JLabel fname=new JLabel("Father's Name:");
         fname.setFont(new Font("Raleway",Font.BOLD,22));
         fname.setBounds(100,190,200,30);
         add(fname);
         
          fnameTextField=new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,22));
         fnameTextField.setBounds(300,190,400,30);
         add(fnameTextField);
         
         
          JLabel dob=new JLabel("Date Of Birth:");
         dob.setFont(new Font("Raleway",Font.BOLD,22));
         dob.setBounds(100,240,200,30);
         add(dob);
         
          dateChooser=new JDateChooser();
         dateChooser.setBounds(300,240,400,30);
         dateChooser.setFont(new Font("Raleway",Font.BOLD,22));
         dateChooser.setForeground(Color.BLACK);
         add(dateChooser);
         
         
         JLabel gender=new JLabel("Gender:");
         gender.setFont(new Font("Raleway",Font.BOLD,22));
         gender.setBounds(100,290,200,30);
         add(gender);
         
          maleButton=new JRadioButton("Male");
         maleButton.setBounds(300,290,60,30);
         maleButton.setBackground(Color.WHITE);
         add(maleButton);
         
           femaleButton=new JRadioButton("Female");
         femaleButton.setBounds(450,290,120,30);
          femaleButton.setBackground(Color.WHITE);
         add(femaleButton);
         
           others=new JRadioButton("Others");
         others.setBounds(600,290,120,30);
          others.setBackground(Color.WHITE);
         add(others);
         
         ButtonGroup genderGroup=new ButtonGroup();
         genderGroup.add(maleButton);
         genderGroup.add(femaleButton);
         genderGroup.add(others);
         
         
          JLabel email=new JLabel("Email Address:");
         email.setFont(new Font("Raleway",Font.BOLD,22));
         email.setBounds(100,340,200,30);
         add(email);
         
          emailTextField=new JTextField();
         emailTextField.setFont(new Font("Raleway",Font.BOLD,22));
         emailTextField.setBounds(300,340,400,30);
         add(emailTextField);
         
         
          JLabel maritalStatus=new JLabel("Marital Status:");
         maritalStatus.setFont(new Font("Raleway",Font.BOLD,22));
         maritalStatus.setBounds(100,390,200,30);
         add(maritalStatus); 
         
           married=new JRadioButton("Married");
         married.setBounds(300,390,100,30);
         married.setBackground(Color.WHITE);
         add(married);
         
           unmarried=new JRadioButton("Unmarried");
         unmarried.setBounds(450,390,120,30);
          unmarried.setBackground(Color.WHITE);
         add(unmarried);
         
         ButtonGroup maritalgroup=new ButtonGroup();
         maritalgroup.add(married);
         maritalgroup.add(unmarried);
         
         JLabel address=new JLabel("Address:");
         address.setFont(new Font("Raleway",Font.BOLD,22));
         address.setBounds(100,440,200,30);
         add(address);
         
          addressTextField=new JTextField();
         addressTextField.setFont(new Font("Raleway",Font.BOLD,22));
         addressTextField.setBounds(300,440,400,30);
         add(addressTextField);
         
          JLabel city=new JLabel("City:");
         city.setFont(new Font("Raleway",Font.BOLD,22));
         city.setBounds(100,490,200,30);
         add(city);
         
          cityTextField=new JTextField();
         cityTextField.setFont(new Font("Raleway",Font.BOLD,22));
         cityTextField.setBounds(300,490,400,30);
         add(cityTextField);
         
         JLabel state=new JLabel("State:");
         state.setFont(new Font("Raleway",Font.BOLD,22));
         state.setBounds(100,540,200,30);
         add(state);
         
          stateTextField=new JTextField();
         stateTextField.setFont(new Font("Raleway",Font.BOLD,22));
         stateTextField.setBounds(300,540,400,30);
         add(stateTextField);
         
         
         JLabel pinCode=new JLabel("Pincode:");
         pinCode.setFont(new Font("Raleway",Font.BOLD,22));
         pinCode.setBounds(100,590,200,30);
         add(pinCode);
         
          pincodeTextField=new JTextField();
         pincodeTextField.setFont(new Font("Raleway",Font.BOLD,22));
         pincodeTextField.setBounds(300,590,400,30);
         add(pincodeTextField);
         
          nextButton=new JButton("Next");
         nextButton.setBackground(Color.BLACK);
         nextButton.setForeground(Color.WHITE);
         nextButton.setFont(new Font("Raleway",Font.BOLD,22) );
         nextButton.setBounds(600,650,100,30);
         nextButton.addActionListener(this);
         add(nextButton);
         
         getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
     public void actionPerformed(ActionEvent ae)
     {
         String formno=""+random;
         String name=nameTextField.getText();//to retrive the value inside the textfield
         String fname=fnameTextField.getText();
         String dob=((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
         String gender=null;
         if(maleButton.isSelected())
         {
             gender="Male";
         }else if(femaleButton.isSelected())
         {
             gender="Female";
         }else if(others.isSelected()){
             gender="Others";
         }
         String email=emailTextField.getText();
         String marital=null;
         if(married.isSelected())
         {
             marital="Married";
         }else if(unmarried.isSelected())
         {
             marital="Unmarried";
         }
         String address=addressTextField.getText();
         String city =cityTextField.getText();
         String state=stateTextField.getText();
         String pincode=pincodeTextField.getText();
         
         try{
             if((name.equals("")) || (fname.equals("")) || (email.equals(""))|| (city.equals("")) || (state.equals(""))|| (pincode.equals("")) || (address.equals(""))|| (gender.equals(""))|| (marital.equals(""))|| (dob.equals(""))){
                 JOptionPane.showMessageDialog(null, "All filleds are required");
             }else{
                 Conn c=new Conn();
                 String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
                 c.s.executeUpdate(query);
                 
                 setVisible(false);
                 new SignupTwo(formno).setVisible(true);
             }
             
         }catch(Exception e){
             System.out.println(e);
         }
     }
    
   
}

