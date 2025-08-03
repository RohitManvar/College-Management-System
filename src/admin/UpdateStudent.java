package admin;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


public class UpdateStudent extends JFrame implements ActionListener
{
    JTextField t1nm,t1fnm,t1address,t1phone,t1email,t1pass;
    JLabel  lblrllno,t1xii,t1x,dcdob;
    Choice crollno;
    JButton update,cancel;
    JComboBox d,c3;
    
    UpdateStudent()
    {
        super("Update Student Data");
        setSize(820,620);
        setLocation(350,50);
        
        setLayout(null);
        
        
        
        JLabel heading = new JLabel("Update Student Details");
        heading.setBounds(250, 20, 500, 50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);

        JLabel lblsearch = new JLabel("Search by Roll Number");
        lblsearch.setBounds(50,105,240,30);
        lblsearch.setFont(new Font("serif",Font.BOLD,22));
        add(lblsearch);
        
        crollno  = new Choice();
        crollno.setBounds(300,110,150,20);
        add(crollno);
        
        try
        {
            Conn c = new Conn();
            ResultSet rs =c.s.executeQuery("select * from student");
            while(rs.next())
            {
                crollno.add(rs.getString("Roll_No"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
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
        
        JLabel lblrollno = new JLabel("Employee_ID : ");
        lblrollno.setBounds(50,200,200,30);
        lblrollno.setFont(new Font("serif",Font.BOLD,20));
        add(lblrollno);
        
        lblrllno = new JLabel();
        lblrllno.setBounds(200,200,200,30);
        lblrllno.setFont(new Font("serif",Font.BOLD,20));
        add(lblrllno);
        
        JLabel lbldob = new JLabel("DATE OF BIRTH :");
        lbldob.setBounds(400,200,200,30);
        lbldob.setFont(new Font("serif",Font.BOLD,20));
        add(lbldob);
        
        dcdob = new JLabel();
        dcdob.setBounds(600,200,150,30);
        dcdob.setFont(new Font("serif",Font.BOLD,20));
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

        t1x = new JLabel();
        t1x.setBounds(600,300,150,30);
        t1x.setFont(new Font("Monospaced",Font.BOLD,17));
        add(t1x);
        
        JLabel lblxii = new JLabel("Class XII (%) : ");
        lblxii.setBounds(50,350,200,30);
        lblxii.setFont(new Font("serif",Font.BOLD,20));
        add(lblxii);

        t1xii = new JLabel();
        t1xii.setBounds(200,350,150,30);
        t1xii.setFont(new Font("Monospaced",Font.BOLD,17));
        add(t1xii);

        JLabel lblaadharno = new JLabel("Aadhar Number : ");
        lblaadharno.setBounds(400,350,200,30);
        lblaadharno.setFont(new Font("serif",Font.BOLD,20));
        add(lblaadharno);

        JLabel t1aadhar = new JLabel();
        t1aadhar.setBounds(600,350,150,30);
        t1aadhar.setFont(new Font("Monospaced",Font.BOLD,17));
        add(t1aadhar);
        
        JLabel lblUsername = new JLabel("Username : ");
        lblUsername.setBounds(50,450,200,30);
        lblUsername.setFont(new Font("serif",Font.BOLD,20));
        add(lblUsername);

        JLabel t1usernm = new JLabel();
        t1usernm.setBounds(200, 450, 150, 30);
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
            
        JLabel cou  = new JLabel();
        cou.setBounds(600, 400, 180, 30);
        cou.setFont(new Font("Monospaced",Font.BOLD,17));
        add(cou);
        
        
//        c3 = new JComboBox();
//        c3.setBounds(200,400,150,30);
//        //c3.addActionListener(this);
//        add(c3);
        
//        c3 = new JTextField();
//        c3.setBounds(200,300,150,30);
//        c3.setFont(new Font("Monospaced",Font.BOLD,17));
//        add(c3);
        
        JLabel lblbranch = new JLabel("Department");
        lblbranch.setBounds(50,400,200,30);
        lblbranch.setFont(new Font("serif", Font.BOLD, 20));
        add(lblbranch);
        
        JLabel dep  = new JLabel();
        dep.setBounds(200,400,180,30);
        dep.setFont(new Font("Monospaced",Font.BOLD,17));
        add(dep);
        
        //String a[] ={"Science","Commerce","Arts"};
//        d = new JComboBox();
//        d.setBounds(600, 400, 150, 30);
//        //d.addActionListener(this);
//        add(d);
//        d.addItem("Science");
//        d.addItem("Commerce");
//        d.addItem("Arts");
        
//        d = new JTextField();
//        d.setBounds(200,300,150,30);
//        d.setFont(new Font("Monospaced",Font.BOLD,17));
//        add(d);
                     
        try
        {
            Conn c = new Conn();
            String query = "select * from student where Roll_No='"+crollno.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next())
            {
                t1nm.setText(rs.getString("Name"));
                t1fnm.setText(rs.getString("Father_Name"));
                lblrllno.setText(rs.getString("Roll_No"));
                dcdob.setText(rs.getString("Date_of_Birth"));
                t1address.setText(rs.getString("Address"));
                t1phone.setText(rs.getString("Phone_No"));
                t1email.setText(rs.getString("Email_ID"));
                t1x.setText(rs.getString("10th_Per"));
                t1xii.setText(rs.getString("12th_Per"));
                t1pass.setText(rs.getString("Password"));
                t1usernm.setText(rs.getString("Username"));
                t1aadhar.setText(rs.getString("Aadhar_Card_No"));
                //c3.setText(rs.getString("Qualification"));
                //d.setText(rs.getString("Department"));
//                c3.setSelectedItem(rs.getString("Course"));
//                d.setSelectedItem(rs.getString("Department"));
                cou.setText(rs.getString("Course"));
                dep.setText(rs.getString("Department"));
             }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
//        d.addActionListener(new ActionListener()
//        {
//            public void actionPerformed(ActionEvent e)
//            {
//                          
//        });
        crollno.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie)
            {
            try
            {
            Conn c = new Conn();
            String query = "select * from student where Roll_No='"+crollno.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next())
            {
                t1nm.setText(rs.getString("Name"));
                t1fnm.setText(rs.getString("Father_Name"));
                lblrllno.setText(rs.getString("Roll_No"));
                dcdob.setText(rs.getString("Date_of_Birth"));
                t1address.setText(rs.getString("Address"));
                t1phone.setText(rs.getString("Phone_No"));
                t1email.setText(rs.getString("Email_ID"));
                t1x.setText(rs.getString("Date_of_Birth"));
                t1xii.setText(rs.getString("12th_Per"));
                t1aadhar.setText(rs.getString("Aadhar_Card_No"));
                t1pass.setText(rs.getString("Password"));
                t1usernm.setText(rs.getString("Username"));
                //c3.setText(rs.getString("Qualification"));
                //d.setText(rs.getString("Department"));
//                c3.setSelectedItem(rs.getObject("Course"));
//                d.setSelectedItem(rs.getObject("Department"));
                cou.setText(rs.getString("Course"));
                dep.setText(rs.getString("Department"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
            }
        });
        
        update = new JButton("Update");
        update.setBounds(250, 500, 120, 30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        update.setFont(new Font("Tahoma",Font.BOLD,15));
        add(update);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(450, 500, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));
        add(cancel);
        
        setVisible(true);
        //Arts
//        c3.addItem(" ");
//        c3.addItem("< Arts Course >");
//        c3.addItem("BA in Arts");
//        c3.addItem("BFA(Fine Arts)");
//        c3.addItem("BDes in Animation");
//        c3.addItem("BDes in Design");
//        c3.addItem("BJMC");
//        c3.addItem("BHM");
//        c3.addItem("BJ");
//        c3.addItem("BMM");
//        //Science
//        c3.addItem(" ");
//        c3.addItem("< Science Course >");
//        c3.addItem("BSc.IT");
//        c3.addItem("B.Tech");
//        c3.addItem("BArch");
//        c3.addItem("MMBS");
//        c3.addItem("BDS");
//        c3.addItem("BDT");
//        c3.addItem("BAMS");
//        c3.addItem("BHMS");
//        c3.addItem("BUMS");
//        c3.addItem("MBBS");
//        c3.addItem("BCA");
//        //Commerce 
//        c3.addItem(" ");
//        c3.addItem("< Commerce Course >");
//        c3.addItem("BBA");
//        c3.addItem("I-MBA");
//        c3.addItem("B.Com");
//        c3.addItem("BCom Hons");
//        c3.addItem("CA");
//        c3.addItem("BFA");
//        c3.addItem("BMS");
//        c3.addItem("CS");
    }
    public void actionPerformed(ActionEvent ae) 
    {
//           if (ae.getSource() == d) 
//           {
//                try 
//                {
//                    if (d.getSelectedItem().equals("Science")) 
//                    {
//                        c3.removeAllItems();
//                        c3.addItem("BSc.IT");
//                        c3.addItem("B.Tech");
//                        c3.addItem("BArch");
//                        c3.addItem("MMBS");
//                        c3.addItem("BDS");
//                        c3.addItem("BDT");
//                        c3.addItem("BAMS");
//                        c3.addItem("BHMS");
//                        c3.addItem("BUMS");
//                        c3.addItem("MBBS");
//                        c3.addItem("BCA");
//                                                //c3.setSelectedItem(null);
//                    }
//                    else if (d.getSelectedItem().equals("Commerce")) 
//                    {
//                            c3.removeAllItems();
//                            c3.addItem("BBA");
//                            c3.addItem("I-MBA");
//                            c3.addItem("B.Com");
//                            c3.addItem("BCom Hons");
//                            c3.addItem("CA");
//                            c3.addItem("BFA");
//                            c3.addItem("BMS");
//                            c3.addItem("CS");
//                            //c3.setSelectedItem(null);
//                    }
//                    else if (d.getSelectedItem().equals("Arts")) 
//                    {
//                            c3.removeAllItems();
//                            c3.addItem("BA in Humanities");
//                            c3.addItem("BA in Arts");
//                            c3.addItem("BFA(Fine Arts)");
//                            c3.addItem("BDes in Animation");
//                            c3.addItem("BDes in Design");
//                            c3.addItem("BJMC");
//                            c3.addItem("BHM");
//                            c3.addItem("BJ");
//                            c3.addItem("BMM");
//                            //c3.setSelectedItem(null);
//                    }
//                } 
//                catch(Exception e)
//                {
//                    System.out.println(ae);
//                }
//            }
             
    if(ae.getSource().equals(update))
    {
            try
            {
            String name = t1nm.getText();
            String fname = t1fnm.getText();
            String rollno = lblrllno.getText();
            String address = t1address.getText();
            String phone = t1phone.getText();
            String email = t1email.getText();
            String pass = t1pass.getText();
//            String course = cou.getText();
//            String dep = this.dep.getText();
//            
//            String course = (String) c3.getSelectedItem();
//            String dep = (String) d.getSelectedItem();
           
           
            String query= "UPDATE student set Name='"+name+"',Father_Name='"+fname+"', Roll_No='"+rollno+"',Address='"+address+"',Phone_No='"+phone+"',Email_ID='"+email+"',Password='"+pass+"' where Roll_NO='"+rollno+"'";

//                Conn c = new Conn();
//                if (t1nm.getText().equals("")|| t1fnm.getText().equals("") || labelrollno.getText().equals("") || t1address.getText().equals("") || t1phone.getText().equals("") || t1email.getText().equals("")|| t1aadhar.getText().equals("")) 
//                {
//                    JOptionPane.showMessageDialog(null, "Please enter all details");
//                } 
//                else 
//                {
//                    c.s.executeUpdate(query);
//                    JOptionPane.showMessageDialog(null, "Student details are Upadate successfully");
//                    setVisible(false);
//                }   
                Conn c = new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Student details are Upadate successfully");
                setVisible(false);
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
        new UpdateStudent();
    }  
}
