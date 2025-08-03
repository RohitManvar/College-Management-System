package admin;

//import java.awt.HeadlessException;
import javax.swing.*;
import java.sql.*;

public class StudentProfile extends JFrame
{
    String um,pass;
    JLabel l1,l2,lrllno,ladd,lphono,ldob,l10,l12,laadhar,lco,ldep,lem,lum,lpass;    
    
    StudentProfile() 
    {   
        super("Profile");
        setLayout(null);
        setSize(600,300);
        setLocation(500,250);
        setVisible (true); 
        
        JLabel lbl= new JLabel("SureName  :");
        lbl.setBounds(40,20,100,20);
        add(lbl);
        l1=new JLabel();
        l1.setBounds(120,20,100,20);    
        add(l1);
        
        JLabel lbl2= new JLabel("Name  :");
        lbl2.setBounds(300,20,100,20);
        add(lbl2);
        l2=new JLabel();
        l2.setBounds(380,20,100,20);    
        add(l2);
        
        JLabel lbl3= new JLabel("Roll_No  :");
        lbl3.setBounds(40,40,100,20);
        add(lbl3);
        lrllno=new JLabel();
        lrllno.setBounds(120,40,100,20);    
        add(lrllno);
        
        JLabel lbl4= new JLabel("Address  :");
        lbl4.setBounds(300,40,100,20);
        add(lbl4);
        ladd=new JLabel();
        ladd.setBounds(380,40,100,20);    
        add(ladd);
        
        JLabel lbl5= new JLabel("Phone_No  :");
        lbl5.setBounds(40,60,100,20);
        add(lbl5);
        lphono=new JLabel();
        lphono.setBounds(120,60,100,20);    
        add(lphono);
        
        JLabel lbl6= new JLabel("Date_of_Birth  :");
        lbl6.setBounds(300,60,100,20);
        add(lbl6);
        ldob=new JLabel();
        ldob.setBounds(390,60,100,20);    
        add(ldob);
        
        JLabel lbl7= new JLabel("10th_Per  :");
        lbl7.setBounds(40,80,100,20);
        add(lbl7);
        l10=new JLabel();
        l10.setBounds(120,80,100,20);    
        add(l10);
        
        JLabel lbl8= new JLabel("12th_Per  :");
        lbl8.setBounds(300,80,100,20);
        add(lbl8);
        l12=new JLabel();
        l12.setBounds(380,80,100,20);    
        add(l12);
        
        JLabel lbl9= new JLabel("Aadhar_Card_No  :");
        lbl9.setBounds(40,100,120,20);
        add(lbl9);
        laadhar=new JLabel();
        laadhar.setBounds(155,100,100,20);    
        add(laadhar);
        
        JLabel lbl10= new JLabel("Course  :");
        lbl10.setBounds(300,100,100,20);
        add(lbl10);
        lco=new JLabel();
        lco.setBounds(380,100,100,20);    
        add(lco);
        
        JLabel lbl11= new JLabel("Department  :");
        lbl11.setBounds(40,120,100,20);
        add(lbl11);
        ldep=new JLabel();
        ldep.setBounds(120,120,100,20);    
        add(ldep);
        
        JLabel lbl12= new JLabel("Email_ID  :");
        lbl12.setBounds(300,120,100,20);
        add(lbl12);
        lem=new JLabel();
        lem.setBounds(380,120,150,20);    
        add(lem);
        
        JLabel lbl13= new JLabel("Username  :");
        lbl13.setBounds(40,140,100,20);
        add(lbl13);
        lum=new JLabel();
        lum.setBounds(120,140,100,20);    
        add(lum);
        
        JLabel lbl14= new JLabel("Password  :");
        lbl14.setBounds(300,140,100,20);
        add(lbl14);
        lpass=new JLabel();
        lpass.setBounds(380,140,100,20);    
        add(lpass);        
        
        try
        {
            Conn c = new Conn();
            Statement s=c.c.createStatement();
            ResultSet rs=s.executeQuery("select * from username");
            while(rs.next())
            {
                 um=rs.getString("UNM");
                 pass=rs.getString("PASS");
                 //System.out.println(um+" "+pass);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }        
        try
        {
            Conn c = new Conn();
            Statement s=c.c.createStatement();
            ResultSet rs=s.executeQuery("select * from student where Username='"+um+"'");
            while(rs.next())
            {
            l1.setText(rs.getString("Name"));           
            l2.setText(rs.getString("Father_Name"));
            lrllno.setText(rs.getString("Roll_No"));
            ladd.setText(rs.getString("Address"));
            lphono.setText(rs.getString("Phone_No"));
            ldob.setText(rs.getString("Date_of_Birth"));
            l10.setText(rs.getString("10th_Per"));
            l12.setText(rs.getString("12th_Per"));
            laadhar.setText(rs.getString("Aadhar_Card_No"));
            lco.setText(rs.getString("Course"));
            ldep.setText(rs.getString("Department"));
            lem.setText(rs.getString("Email_ID"));
            lum.setText(rs.getString("Username"));
            lpass.setText(rs.getString("Password"));
            }
        }
        catch(Exception e)
        {
           e.printStackTrace();
        }
        
//        if(EmployeeHome.)
//        {
//            
//        }
//        else
//        {
//            
//        }
        
        
        
    }   
    public static void main(String[]args)
    {
        new StudentProfile();
    }
}
