
package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
public class SignupTwo extends JFrame implements ActionListener{
    JTextField pan,aadhar;
   JRadioButton syes,sno,eAyes,eAno;
   JComboBox religions,occupations,educationalDetails,incomes,categories;
     JButton nextButton;
     String formno;
     SignupTwo(String formno) {
         this.formno=formno;
           setTitle("NEW APPLICATION FORM-2");
         setLayout(null);
          JLabel AdditonalDetails=new JLabel("Page 2: Additional Details");
         AdditonalDetails.setFont(new Font("Raleway",Font.BOLD,22));
         AdditonalDetails.setBounds(290,80,400,30);
         add(AdditonalDetails);
         
          JLabel religion=new JLabel("Religion:");
         religion.setFont(new Font("Raleway",Font.BOLD,22));
         religion.setBounds(100,140,100,30);
         add(religion);
         
         String valReligion[]={"Hindu","Muslim","Sikh","Christan","Other"};
          religions= new JComboBox(valReligion);
         religions.setBounds(300,140,400,30);
         religions.setBackground(Color.WHITE);
         add(religions);
         
         JLabel category=new JLabel("Category:");
         category.setFont(new Font("Raleway",Font.BOLD,22));
         category.setBounds(100,190,200,30);
         add(category);
         
          String valCategory[]={"GENERAL","SC","ST","OBC","Others"};
          categories= new JComboBox(valCategory);
         categories.setBounds(300,190,400,30);
         categories.setBackground(Color.WHITE);
         add(categories);
         
          JLabel income=new JLabel("Income:");
         income.setFont(new Font("Raleway",Font.BOLD,22));
         income.setBounds(100,240,200,30);
         add(income);
         
            String valIncomes[]={"Null","<1,00,000","<2,50,000","<5,00,000","Upto 10,00,000"};
          incomes= new JComboBox(valIncomes);
         incomes.setBounds(300,240,400,30);
         incomes.setBackground(Color.WHITE);
         add(incomes);
         
         
         JLabel educational=new JLabel("Educational");
         educational.setFont(new Font("Raleway",Font.BOLD,22));
         educational.setBounds(100,290,200,30);
         add(educational);
         
        
          JLabel qualification=new JLabel("Qualification:");
         qualification.setFont(new Font("Raleway",Font.BOLD,22));
         qualification.setBounds(100,315,200,30);
         add(qualification);
         
          String educationValues[]={"Non-Graduation","Graduation","Post-Graduation","Doctrate","Other"};
           educationalDetails= new JComboBox(educationValues);
          educationalDetails.setBounds(300,315,400,30);
          educationalDetails.setBackground(Color.WHITE);
          add(educationalDetails);
         
         
          JLabel maritalStatus=new JLabel("Occupation:");
         maritalStatus.setFont(new Font("Raleway",Font.BOLD,22));
         maritalStatus.setBounds(100,390,200,30);
         add(maritalStatus); 
         
             String valOccupation[]={"Govt-Employed","Private-Employed","Self-Employed","Student","Other"};
          occupations= new JComboBox(valOccupation);
         occupations.setBounds(300,390,400,30);
         occupations.setBackground(Color.WHITE);
         add(occupations);
         
         JLabel panNumber=new JLabel("PAN Number:");
         panNumber.setFont(new Font("Raleway",Font.BOLD,22));
         panNumber.setBounds(100,440,200,30);
         add(panNumber);
         
          pan=new JTextField();
         pan.setFont(new Font("Raleway",Font.BOLD,22));
         pan.setBounds(300,440,400,30);
         add(pan);
         
          JLabel aaNumber=new JLabel("Aadhar Number:");
         aaNumber.setFont(new Font("Raleway",Font.BOLD,22));
         aaNumber.setBounds(100,490,200,30);
         add(aaNumber);
         
          aadhar=new JTextField();
         aadhar.setFont(new Font("Raleway",Font.BOLD,22));
         aadhar.setBounds(300,490,400,30);
         add(aadhar);
         
         JLabel seniorC=new JLabel("Senior Citizen:");
         seniorC.setFont(new Font("Raleway",Font.BOLD,22));
         seniorC.setBounds(100,540,200,30);
         add(seniorC);
         
          syes=new JRadioButton("YES");
         syes.setFont(new Font("Raleway",Font.BOLD,12));
         syes.setBounds(320,540,100,30);
         syes.setBackground(Color.WHITE);
         add(syes);
        sno=new JRadioButton("NO");
         sno.setFont(new Font("Raleway",Font.BOLD,12));
         sno.setBounds(450,540,100,30);
          sno.setBackground(Color.WHITE);
         add(sno);
         ButtonGroup SeniosCGroup=new ButtonGroup();
         SeniosCGroup.add(syes);
         SeniosCGroup.add(sno);
         
         
         JLabel eAccount=new JLabel("Exiting Account:");
         eAccount.setFont(new Font("Raleway",Font.BOLD,22));
         eAccount.setBounds(100,590,200,30);
         add(eAccount);
         
         eAyes=new JRadioButton("YES");
         eAyes.setFont(new Font("Raleway",Font.BOLD,12));
         eAyes.setBounds(320,590,100,30);
          eAyes.setBackground(Color.WHITE);
         add(eAyes);
        eAno=new JRadioButton("NO");
         eAno.setFont(new Font("Raleway",Font.BOLD,12));
         eAno.setBounds(450,590,100,30);
          eAno.setBackground(Color.WHITE);
         add(eAno);
         ButtonGroup existingAGroup=new ButtonGroup();
         existingAGroup.add(eAyes);
         existingAGroup.add(eAno);
         
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
       
         String religionString=(String)religions.getSelectedItem();//to retrive the value inside the textfield
         String categoryString=(String)categories.getSelectedItem();
         String educationString=(String)educationalDetails.getSelectedItem();
         String occupationString=(String)occupations.getSelectedItem();
         String incomeString=(String)incomes.getSelectedItem();
         String panString=pan.getText();
         String aadharString=aadhar.getText();
         String seniorCitizenString=null;
         if(syes.isSelected())
         {
             seniorCitizenString="YES";
         }else if(sno.isSelected())
         {
             seniorCitizenString="NO";
         }
         String exiztingAccountString=null;
         if(eAyes.isSelected())
         {
             exiztingAccountString="YES";
         }else if(eAno.isSelected())
         {
             exiztingAccountString="NO";
         }
         
         try{
             if((panString.equals("")) || (aadharString.equals(""))){
                 JOptionPane.showMessageDialog(null, "All filleds are required");
             }else{
                 Conn c=new Conn();
                 String query="insert into signuptwo values('"+formno+"','"+religionString+"','"+categoryString+"','"+educationString+"','"+occupationString+"','"+incomeString+"','"+panString+"','"+aadharString+"','"+seniorCitizenString+"','"+exiztingAccountString+"')";
                 c.s.executeUpdate(query);
                 setVisible(false);
                 new SignupThree(formno).setVisible(true);
             }
             
         }catch(Exception e){
             System.out.println(e);
         }
     }
    
   
}
