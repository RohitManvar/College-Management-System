package admin;

import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;

public class RegistrationForm extends JFrame implements ActionListener
{
    JButton b4,b5;
    JTextField t3,t4,t2,t5;
    JPasswordField p3;
    JDateChooser dcdob;
    //JLabel l3;
    JRadioButton r1,r2;
    
    RegistrationForm()
    {
        setLayout(null);
        setSize(600,650);
        setLocation(400,150);
        
        JLabel lbl1 = new JLabel("Registration ");
        lbl1.setBounds(230, 10, 200, 38);
        lbl1.setFont(new Font("serif",Font.BOLD,25));
        add(lbl1);
                
        JLabel lbl = new JLabel("Enter Username :");
        lbl.setBounds(30 ,62, 330, 30);
        lbl.setFont(new Font("serif",Font.ROMAN_BASELINE,20));
        add(lbl);
        
        t3=new JTextField();
        t3.setBounds(360,67,150,25);
        t3.setFont(new Font("Monospaced",Font.BOLD,20));
        add(t3);
    
        JLabel lblpass = new JLabel("Enter Password :");
        lblpass.setBounds(30, 130, 330, 30);
        lblpass.setFont(new Font("serif",Font.ROMAN_BASELINE,20));
        add(lblpass);
        
        p3 = new JPasswordField();
        p3.setBounds(360, 138, 150, 25);
        p3.setFont(new Font("Monospaced",Font.BOLD,20));
        add(p3);
        
        JLabel mobileno =new JLabel("Enter Your Mobile no :");
        mobileno.setBounds(30, 198, 330, 30);
        mobileno.setFont(new Font("serif",Font.ROMAN_BASELINE,20));
        add(mobileno);
        
        t4=new JTextField();
        t4.setBounds(360,201,150,25);
        add(t4);
        
        JLabel email =new JLabel("Enter Email_ID :");
        email.setBounds(30, 266, 330, 30);
        email.setFont(new Font("serif",Font.ROMAN_BASELINE,20));
        add(email);
        
        t5=new JTextField();
        t5.setBounds(360,270,150,25);
        t5.setFont(new Font("Monospaced",Font.BOLD,20));
        add(t5);
        
        JLabel city =new JLabel("Enter City :");
        city.setBounds(30, 334, 330, 30);
        city.setFont(new Font("serif",Font.ROMAN_BASELINE,20));
        add(city);
        
        t2=new JTextField();
        t2.setBounds(360,338,150,25);
        t2.setFont(new Font("Monospaced",Font.BOLD,20));
        add(t2);
        
        JLabel gen =new JLabel("Gender :");
        gen.setBounds(30, 400, 330, 30);
        gen.setFont(new Font("serif",Font.ROMAN_BASELINE,20));
        add(gen);
        
        r1 = new JRadioButton("Male");
        r1.setBounds(360,409,80,25);
        r1.setFont(new Font("Monospaced",Font.BOLD,20));
        add(r1);
                
        r2 = new JRadioButton("Female");
        r2.setBounds(450,409,100,25);
        r2.setFont(new Font("Monospaced",Font.BOLD,20));
        add(r2);
        
        JLabel lbldob = new JLabel("DATE OF BIRTH :");
        lbldob.setBounds(30,465,330,30);//30, 400, 330, 30
        lbldob.setFont(new Font("serif",Font.ROMAN_BASELINE,20));
        add(lbldob);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(360 ,465,150,25);//360,409,80,25
        add(dcdob);
        
        ButtonGroup b1 =new ButtonGroup();
        b1.add(r1);
        b1.add(r2);
        
        
        
        b4 = new JButton("Submit");
        b4.setBounds(140,545,120,30);
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.addActionListener(this);
        add(b4);
    
        b5 = new JButton("Reset");
        b5.setBounds(330,542,120,30);
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        b5.addActionListener(this);
        add(b5);
        
        setVisible (true);
        
    }
    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource() == b4)
        {
            String uname = t3.getText();
            String mobno = t4.getText();
            String pass = p3.getText();
            String emial = t5.getText();
            String city = t2.getText();
            String gender = "";
            if (r1.isSelected()) {
                gender = "Male";
            } else if (r2.isSelected()) {
                gender = "Female";
            }
            String dob= ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            
            
            //String query="INSERT INTO EMPLOYEE (Username, Password, Mobile) VALUES ('"+uname+"','"+pass+"','"+mobno+"')";
            
                try
                {
                    Conn c = new Conn();
                    
                    PreparedStatement ps = c.c.prepareStatement("INSERT INTO Login (Username, Password, MobileNo,Email_ID,City,Gender,Date_of_Birth) VALUES (?,?,?,?,?,?,?)");
                    ps.setString(1, uname);
                    ps.setString(2, pass);  
                    ps.setString(3, mobno); 
                    ps.setString(4, emial);
                    ps.setString(5, city);
                    ps.setString(6, gender);
                    ps.setString(7, dob);
                    
                    //ResultSet rs = c.s.executeQuery(query);
             
                    int rs = ps.executeUpdate();
                            
                    if(rs > 0)
                    {
                        JOptionPane.showMessageDialog(null,"ID is Registered");
                        setVisible(false);
                        new LoginMain();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Error");
                        //setVisible(false);
                    }
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
        }
        else if(ae.getSource() == b5)
        {
            t3.setText(null);
            t4.setText(null);
            p3.setText(null);
            t5.setText(null);
            t2.setText(null);
            dcdob.setCalendar(null);
            r1.setSelected(false);
            r2.setSelected(false);
        }
    }
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
   
    public static void main(String[]args)
    {
        new RegistrationForm();
    }
}