package com.mycompany.ums;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
//import javax.swing.border.EmptyBorder;


public class Ums extends JFrame implements ActionListener
{
    JButton b1,b2,b3reg,b4,b5;
    JLabel lbl,lblpass;
    JTextField t1;
    JPasswordField p1;
    
    Ums()
    {
        super("Login");
        setLayout(null);
        //setBorder(new EmptyBorder(20,3,10,3));
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("logo/logn3.png"));
        Image i2 = i1.getImage().getScaledInstance(250,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(320,15,250,200);
        add(image);
       
        lbl= new JLabel("Username  :");
        lbl.setBounds(40,20,100,20);
        add(lbl);
        
        
        t1=new JTextField();
        t1.setBounds(120,20,150,20);
        add(t1);
 
        lblpass= new JLabel("Password  :");
        lblpass.setBounds(40,70,100,20);
        add(lblpass);       
        
        p1= new JPasswordField();
        p1.setBounds(120,70,150,20);
        add(p1);
        
        b1= new JButton("Admin");
        b1.setBounds(30,140,80,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);
        
//        b2= new JButton("Cancel");
//        b2.setBounds(180,180,80,20);
//        b2.setBackground(Color.WHITE);
//        b2.setForeground(Color.DARK_GRAY);
//        b2.addActionListener(this);
//        add(b2); 
//        
//        b3reg =new JButton("Sign Up");
//        b3reg.setBounds(40,180,80,20);
//        b3reg.setBackground(Color.WHITE);
//        b3reg.setForeground(Color.DARK_GRAY);
//        b3reg.setFont(new Font("serif",Font.BOLD,13));
//        b3reg.addActionListener(this);
//        add(b3reg);
        
        b4= new JButton("Employee");
        b4.setBounds(115,140,90,30);
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.addActionListener(this);
        add(b4);
        
        b5= new JButton("Student");
        b5.setBounds(210,140,80,30);
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        b5.addActionListener(this);
        add(b5);
        
        
        
        setSize(600,300);
        setLocation(500,250);
        setVisible (true); 
        
    }
        public void actionPerformed(ActionEvent ae)
        {
            
                if(ae.getSource() == b1)
                {
                        String username = t1.getText();
                        String password = p1.getText();
//                        SProjectS sd =new SProjectS();
//                        sd.l1.setText(t1.getText());
                        
                        String query = "select * from login where Username = '"+username+"' and Password = '"+password+ "'";
                        
                        try
                        {
                            Conn c = new Conn();
//                            PreparedStatement preparedStatement = c.c.prepareStatement("select * from login where Username like ? and Password like ?");
//                            preparedStatement.setString(1, username);
//                            preparedStatement.setString(2, password);
//                            ResultSet rs = preparedStatement.executeQuery();
                              ResultSet rs = c.s.executeQuery(query);

                            if(rs.next())
                            {
                               setVisible(false);
                               new AdminHome();
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null,"Inavalid Username and Password");
                                //setVisible(false);
                                t1.setText(null);
                                p1.setText(null);
                            }
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();
                        }
                }
                else if(ae.getSource() == b4)
                {
                    String username = t1.getText();
                    String password = p1.getText();
//                    SProjectS sd =new SProjectS();
//                    sd.l1.setText(t1.getText());
                    
                        String query = "select * from teacher where Username = '"+username+"' and Password = '"+password+ "'";
                        
                        try
                        {
                            Conn c = new Conn();
//                            PreparedStatement preparedStatement = c.c.prepareStatement("select * from login where Username like ? and Password like ?");
//                            preparedStatement.setString(1, username);
//                            preparedStatement.setString(2, password);
//                            ResultSet rs = preparedStatement.executeQuery();
                              ResultSet rs = c.s.executeQuery(query);
                              
                            if(rs.next())
                            {
                               setVisible(false);
                               new EmployeeHome(t1.getText());
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null,"Inavalid Username and Password");
                                //setVisible(false);
                                t1.setText(null);
                                p1.setText(null);
                            }
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();
                        }
                }
                else if(ae.getSource() == b5)
                {
                    String username = t1.getText();
                    String password = p1.getText();
                        
                        
                        String query = "select * from student where Username = '"+username+"' and Password = '"+password+ "'";
                        
                        try
                        {
                            Conn c = new Conn();
//                            PreparedStatement preparedStatement = c.c.prepareStatement("select * from login where Username like ? and Password like ?");
//                            preparedStatement.setString(1, username);
//                            preparedStatement.setString(2, password);
//                            ResultSet rs = preparedStatement.executeQuery();
                              ResultSet rs = c.s.executeQuery(query);

                            if(rs.next())
                            {
                                try
                                {
//                                    Conn con = new Conn();
//                                    Statement s=c.c.createStatement();
//                                    s
                                    PreparedStatement ps = c.c.prepareStatement("insert into username (UNM,PASS) values(?,?)");
                                    ps.setString(1, username);
                                    ps.setString(2, password);
                                    ps.executeUpdate();
                                }
                                catch(Exception e)
                                {
                                    System.out.println(e);
                                }
                                
                               setVisible(false);
                               new StudentHome(t1.getText());
                               //new SProfile();
//                                SProfile sd =new SProfile();
//                                sd.l1.setText(username);
//                                //sd.setVisible(false);
                                
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null,"Inavalid Username and Password");
                                //setVisible(false);
                                t1.setText(null);
                                p1.setText(null);
                            }
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();
                        }
                }
//                else if(ae.getSource() == b3)
//                {
//                    setVisible(false);
//                    new RegistrationForm();
//                }
//                else if(ae.getSource() == b2)
//                {
//                    setVisible(false);
//                }

        }
        public static void main(String[]args)
        {
            new Ums( );
        }
}
