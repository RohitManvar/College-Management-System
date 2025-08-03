
package admin;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
//import java.sql.*;


public class AddStudent extends JFrame implements ActionListener
{
    JTextField t1nm,t1fnm,t1address,t1phone,t1email,t1x,t1xii,t1aadhar,t1usernm,t1pass;
    JLabel  labelrollno;
    JDateChooser dcdob;
    JComboBox c2,c1;
    JButton submit,cancel;
    
    Random ran=new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L)+1000L);
    
    Random ran1=new Random();
    long first = Math.abs((ran.nextLong() % 9000L)+1000L);
    
    AddStudent()
    {
        super("Add New Student");
        setSize(900,700);
        setLocation(350,50);
        
        setLayout(null);
        
        JLabel heading = new JLabel("New Student Details");
        heading.setBounds(310, 30, 500, 50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);

        JLabel lblnm = new JLabel("First Name : ");
        lblnm.setBounds(50,150,200,30);//50,250,200,30
        lblnm.setFont(new Font("serif",Font.BOLD,22));
        add(lblnm);

        t1nm = new JTextField();
        t1nm.setBounds(200,150,150,30);//200,250,150,30
        t1nm.setFont(new Font("Monospaced",Font.BOLD,17));
        add(t1nm); 
        
        JLabel lblfnm = new JLabel("Last Name : ");
        lblfnm.setBounds(400,150,200,30);
        lblfnm.setFont(new Font("serif",Font.BOLD,22));
        add(lblfnm);
        
        t1fnm = new JTextField();
        t1fnm.setBounds(600,150,150,30);
        t1fnm.setFont(new Font("Monospaced",Font.BOLD,17));
        add(t1fnm);
        
        JLabel lblrollno = new JLabel("Enrollment No : ");
        lblrollno.setBounds(50,200,200,30);
        lblrollno.setFont(new Font("serif",Font.BOLD,20));
        add(lblrollno);
        
        labelrollno = new JLabel("1533"+first4);
        labelrollno.setBounds(200,200,200,30);
        labelrollno.setFont(new Font("serif",Font.BOLD,20));
        add(labelrollno);
        
        JLabel lbldob = new JLabel("DATE OF BIRTH :");
        lbldob.setBounds(400,200,200,30);
        lbldob.setFont(new Font("serif",Font.BOLD,20));
        add(lbldob);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(600,200,150,30);
        add(dcdob);
        
        JLabel lbladdress = new JLabel("Address : ");
        lbladdress.setBounds(50,250,200,30);
        lbladdress.setFont(new Font("serif",Font.BOLD,20));
        add(lbladdress);

        t1address = new JTextField();
        t1address.setBounds(200,250,150,30);
        t1address.setFont(new Font("Monospaced",Font.BOLD,17));
        add(t1address);
        
        JLabel lblphone = new JLabel("Phone No. : ");
        lblphone.setBounds(400,250,200,30);
        lblphone.setFont(new Font("serif",Font.BOLD,20));
        add(lblphone);

        t1phone = new JTextField();
        t1phone.setBounds(600,250,150,30);
        t1phone.setFont(new Font("Monospaced",Font.BOLD,17));
        add(t1phone);
        
        JLabel lblemail = new JLabel("Enter Email ID : ");
        lblemail.setBounds(50,300,200,30);
        lblemail.setFont(new Font("serif",Font.BOLD,20));
        add(lblemail);

        t1email = new JTextField();
        t1email.setBounds(200,300,150,30);
        t1email.setFont(new Font("Monospaced",Font.BOLD,17));
        add(t1email);
        
        JLabel lblx = new JLabel("Class X(%) : ");
        lblx.setBounds(400,300,200,30);
        lblx.setFont(new Font("serif",Font.BOLD,20));
        add(lblx);

        t1x = new JTextField();
        t1x.setBounds(600,300,150,30);
        t1x.setFont(new Font("Monospaced",Font.BOLD,17));
        add(t1x);
        
        JLabel lblxii = new JLabel("Class XII (%) : ");
        lblxii.setBounds(50,350,200,30);
        lblxii.setFont(new Font("serif",Font.BOLD,20));
        add(lblxii);

        t1xii = new JTextField();
        t1xii.setBounds(200,350,150,30);
        t1xii.setFont(new Font("Monospaced",Font.BOLD,17));
        add(t1xii);

        JLabel lblaadharno = new JLabel("Aadhar Number : ");
        lblaadharno.setBounds(400,350,200,30);
        lblaadharno.setFont(new Font("serif",Font.BOLD,20));
        add(lblaadharno);

        t1aadhar = new JTextField();
        t1aadhar.setBounds(600,350,150,30);
        t1aadhar.setFont(new Font("Monospaced",Font.BOLD,17));
        add(t1aadhar);
        
        JLabel lblUsername = new JLabel("Username : ");
        lblUsername.setBounds(50,450,200,30);
        lblUsername.setFont(new Font("serif",Font.BOLD,20));
        add(lblUsername);

        t1usernm = new JTextField();
        t1usernm.setBounds(200,450,150,30);
        t1usernm.setFont(new Font("Monospaced",Font.BOLD,17));
        add(t1usernm);
        
        JLabel lblpass = new JLabel("Password : ");
        lblpass.setBounds(400,450,200,30);
        lblpass.setFont(new Font("serif",Font.BOLD,20));
        add(lblpass);

        t1pass = new JTextField();
        t1pass.setBounds(600,450,150,30);
        t1pass.setFont(new Font("Monospaced",Font.BOLD,17));
        add(t1pass);
        
        JLabel lblcourse = new JLabel("Course : ");
        lblcourse.setBounds(400, 400, 200, 30);
        lblcourse.setFont(new Font("serif",Font.BOLD,20));
        add(lblcourse);

        //String coursecs[] = {"BCA","BSc.IT","B.Tech","BArch","MMBS","BDS","BDT","BAMS","BHMS","BUMS","MBBS","BBA","I-MBA","B.Com","BCom Hons","CA","BFA","BMS","CS","BA in Humanities","BA in Arts","BFA(Fine Arts)","BDes in Animation","BDes in Desgin","BJMC","BHM","BJ","BMM"};
        c2 = new JComboBox();
        c2.setBounds(600, 400, 150, 30);
        c2.setBackground(Color.WHITE);
        add(c2);
        
        JLabel lblbranch = new JLabel("Department");
        lblbranch.setBounds(50,400,200,30);
        lblbranch.setFont(new Font("serif", Font.BOLD, 20));
        add(lblbranch);
        
        String a[] ={"Science","Commerce","Arts"};
        c1 = new JComboBox(a);
        c1.setBounds(200,400,150,30);
        c1.setBackground(Color.WHITE);
        c1.addActionListener(this);
        add(c1);
        
        
        submit = new JButton("Submit");
        submit.setBounds(250, 550, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma",Font.BOLD,15));
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(450, 550, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));
        add(cancel);
        
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae) 
    {
        if (ae.getSource() == c1) 
        {
            try {
                if (c1.getSelectedItem().equals("Science")) {
                    c2.removeAllItems();
                    c2.addItem("BSc.IT");
                    c2.addItem("B.Tech");
                    c2.addItem("BArch");
                    c2.addItem("MMBS");
                    c2.addItem("BDS");
                    c2.addItem("BDT");
                    c2.addItem("BAMS");
                    c2.addItem("BHMS");
                    c2.addItem("BUMS");
                    c2.addItem("MBBS");
                    c2.addItem("BCA");
                    //c2.setSelectedItem(null);
                } else if (c1.getSelectedItem().equals("Commerce")) {
                    c2.removeAllItems();
                    c2.addItem("BBA");
                    c2.addItem("I-MBA");
                    c2.addItem("B.Com");
                    c2.addItem("BCom Hons");
                    c2.addItem("CA");
                    c2.addItem("BFA");
                    c2.addItem("BMS");
                    c2.addItem("CS");
                    c2.addItem("MBA");
                    c2.addItem("M.Com");
                    c2.addItem("MMS");
                    //c2.setSelectedItem(null);
                } else if (c1.getSelectedItem().equals("Arts")) {
                    c2.removeAllItems();
                    c2.addItem("BA in Humanities");
                    c2.addItem("BA in Arts");
                    c2.addItem("BFA(Fine Arts)");
                    c2.addItem("BDes in Animation");
                    c2.addItem("BDes in Design");
                    c2.addItem("BJMC");
                    c2.addItem("BHM");
                    c2.addItem("BJ");
                    c2.addItem("BMM");
                    c2.addItem("MJ");
                    c2.addItem("MHM");
                    c2.addItem("MJMC");
                    c2.addItem("MA in Arts");
                    c2.addItem("MFA(Fine Arts)");
                    c2.addItem("MA in Humanities");
                    //c2.setSelectedItem(null);
                }
            } 
        catch (Exception e) 
        {
                e.printStackTrace();
        }
    }   
    if(ae.getSource().equals(submit))
    {
            String name = t1nm.getText();
            String fname = t1fnm.getText();
            String rollno = labelrollno.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String address = t1address.getText();
            String phone = t1phone.getText();
            String email = t1email.getText();
            String x = t1x.getText();
            String xii = t1xii.getText();
            String aadhar = t1aadhar.getText();
            String unm = t1usernm.getText();
            String pass = t1pass.getText();
            String course = (String) c2.getSelectedItem();
            String dep = (String) c1.getSelectedItem();
           
           
            String query= "INSERT INTO student (Name,Father_Name, Roll_No,Address,Phone_No,Date_of_Birth,10th_Per,12th_Per,Aadhar_Card_No,Course,Department,Email_ID,Username,Password) VALUES('"+name+"','"+fname+"','"+rollno+"','"+address+"','"+phone+"','"+dob+"','"+x+"','"+xii+"','"+aadhar+"','"+course+"','"+dep+"','"+email+"','"+unm+"','"+pass+"')";
            try
            {
                Conn c = new Conn();
                if (t1nm.getText().equals("") || t1fnm.getText().equals("") || labelrollno.getText().equals("") || t1address.getText().equals("") || t1phone.getText().equals("") || t1email.getText().equals("") || t1x.getText().equals("") || t1xii.getText().equals("") || t1aadhar.getText().equals("") || t1pass.getText().equals("") || t1usernm.getText().equals("") || c2.getSelectedItem().equals("") || c1.getSelectedItem().equals("")  ) 
                {
                    JOptionPane.showMessageDialog(null, "Please enter all details");
                } 
                else 
                {
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Student details are inserted successfully");
                    setVisible(false);
                }                
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(ae.getSource().equals(cancel))
        {
            setVisible(false);
        }
    }
    public static void main(String[]args)
    {
       new AddStudent(); 
    }
}
