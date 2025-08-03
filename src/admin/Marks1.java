/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admin;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author marth
 */
public class Marks1 extends JFrame implements ActionListener
{
    String rllno;
    String um,unm;
    JButton cancel;
    
    Marks1(String unm)
    {
        super("Results");
        this.unm = unm;
        um = unm;
        setSize(500, 750);
        setLocation(500, 100);
        setLayout(null);
        //System.out.println(rllno);
        getContentPane().setBackground(Color.WHITE);
        
//         try
//        {
//            Conn c = new Conn();
//            ResultSet rs =c.s.executeQuery("select * from student");
//            while(rs.next())
//            {
//                rllno.equals((rs.getString("Roll_No")));
//            }
//        }
//        catch(Exception e)
//        {
//            e.printStackTrace();
//        }
        
        JLabel heading = new JLabel("Delhi Technical Univeristy");
        heading.setBounds(100, 10, 500, 25);
        heading.setFont(new Font("Tahoma", Font.BOLD, 22));
        add(heading);
        
        JLabel subheading = new JLabel("Result of Examination 2022");
        subheading.setBounds(112, 50, 500, 20);
        subheading.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(subheading);
        
        JLabel lblnm = new JLabel("First Name :");      
        lblnm.setBounds(60, 100, 100, 20);
        lblnm.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblnm);
        
        JLabel txnm =new JLabel();
        txnm.setBounds(190, 96, 100, 30);
        txnm.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(txnm);
        
        JLabel lbllnm = new JLabel("Last Name :");      
        lbllnm.setBounds(60, 140, 100, 20);
        lbllnm.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lbllnm);
        
        JLabel txlnm =new JLabel();
        txlnm.setBounds(190, 136, 100, 30);
        txlnm.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(txlnm);
        
        JLabel lblrollno = new JLabel("Roll Number :");
        lblrollno.setBounds(60, 180, 120, 20);
        lblrollno.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblrollno);
        
        JLabel lblrllno = new JLabel();
        lblrllno.setBounds(190, 180, 100, 20);
        lblrllno.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblrllno);
                
        JLabel course = new JLabel("Course :");      
        course.setBounds(60, 220, 100, 20);
        course.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(course);
        
        JLabel cours1 =new JLabel();
        cours1.setBounds(190, 216, 100, 30);
        cours1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(cours1);
        
        JLabel lblsem = new JLabel("Semester :");
        lblsem.setBounds(60, 300, 100, 20);
        lblsem.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblsem);
        
        JLabel lblsemester = new JLabel();
        lblsemester.setBounds(190, 300, 100, 20);
        lblsemester.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblsemester);
        
        JLabel lbldep = new JLabel("Department :");
        lbldep.setBounds(60, 260, 120, 20);
        lbldep.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lbldep);
        
        JLabel lbldepartment = new JLabel();
        lbldepartment.setBounds(190, 260, 100, 20);
        lbldepartment.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lbldepartment);
        
        
        
        JLabel sub1 = new JLabel();
        sub1.setBounds(100, 350, 500, 20);
        sub1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub1);
        
        JLabel sub2 = new JLabel();
        sub2.setBounds(100, 380, 500, 20);
        sub2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub2);
        
        JLabel sub3 = new JLabel();
        sub3.setBounds(100, 410, 500, 20);
        sub3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub3);
        
        JLabel sub4 = new JLabel();
        sub4.setBounds(100, 440, 500, 20);
        sub4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub4);
        
        JLabel sub5 = new JLabel();
        sub5.setBounds(100, 470, 500, 20);
        sub5.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub5);
        
//        try
//        {
//            Conn c = new Conn();
//            Statement s=c.c.createStatement();
//            ResultSet rs=s.executeQuery("select * from student where Username='"+um+"'");
//            while(rs.next())
//            {
//                 
//                 rllno=rs.getString("Roll_No");
//                 //System.out.println(um+" "+pass);
//            }
//        }
//        catch(Exception e)
//        {
//            e.printStackTrace();
//        }
        
        try {
           Conn c = new Conn();
            
            ResultSet rs = c.s.executeQuery("select * from subjects where Roll_No = '"+um+"'");
            while(rs.next()) {
                sub1.setText(rs.getString("Subject1"));
                sub2.setText(rs.getString("Subject2"));
                sub3.setText(rs.getString("Subject3"));
                sub4.setText(rs.getString("Subject4"));
                sub5.setText(rs.getString("Subject5"));
            }           
            ResultSet rs2 = c.s.executeQuery("select * from marks where Roll_No = '"+um+"'");
            while(rs2.next()) {
                sub1.setText(sub1.getText() + "------------" + rs2.getString("Marks1"));
                sub2.setText(sub2.getText() + "------------" + rs2.getString("Marks2"));
                sub3.setText(sub3.getText() + "------------" + rs2.getString("Marks3"));
                sub4.setText(sub4.getText() + "------------" + rs2.getString("Marks4"));
                sub5.setText(sub5.getText() + "------------" + rs2.getString("Marks5"));
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        try
        {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student where Roll_No='"+um+"'");
            //String query = "select * from student where Roll_No='"+rollno+"'";
            while(rs.next())
            {
                txnm.setText(rs.getString("Name"));
                txlnm.setText(rs.getString("Father_Name"));
                lblrllno.setText(rs.getString("Roll_No"));
                cours1.setText(rs.getString("Course"));                
                lbldepartment.setText(rs.getString("Department"));
            }
            String query1 = "select * from marks where Roll_No = '"+um+"'";
            ResultSet rs1 = c.s.executeQuery(query1);
            while(rs1.next())
            {
                lblsemester.setText(rs1.getString("Semester"));
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        cancel = new JButton("Back");
        cancel.setBounds(250, 550, 120, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }
    
    public static void main(String[] args) {
        new Marks1("");
    }
}
