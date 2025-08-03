
package admin;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class StudentDeatils extends JFrame implements ActionListener
        
{
    Choice crollno;
    JTable table;
    JButton search,print,update,add,cancel;
    
    StudentDeatils()
    {
        super("Student Details");
        JLabel heading1 = new JLabel("Student Details");
        heading1.setBounds(530, 10, 500, 50);
        heading1.setFont(new Font("serif",Font.BOLD,50));
        heading1.setForeground(Color.BLUE);
        add(heading1);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Search by Roll Number");
        heading.setBounds(20,20,150,20);
        add(heading);
        
        crollno  = new Choice();
        crollno.setBounds(180,20,150,20);
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
        
        table = new JTable();
        
        try
        {
            Conn c = new Conn();
            ResultSet rs =c.s.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
//            while(rs.next())
//            {
//                crollno.add(rs.getString("Roll_No"));
//            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);
        
        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);
        
        add = new JButton("Add");
        add.setBounds(120, 70, 80, 20);
        add.addActionListener(this);
        add(add);
        
        update = new JButton("Update");
        update.setBounds(320, 70, 80, 20);
        update.addActionListener(this);
        add(update);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(420, 70, 80, 20);
        cancel.addActionListener(this);
        add(cancel);

        print = new JButton("Print");
        print.setBounds(220, 70, 80, 20);
        print.addActionListener(this);
        add(print);
        
        
        setSize(900,700);
        setLocation(300,100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == search)
        {     
            try
            {      

                Conn c = new Conn();
                ResultSet rs =c.s.executeQuery("select * from student where Roll_No='"+crollno.getSelectedItem()+"'");
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e)
            {
                e.printStackTrace();
            } 
        }
        else if(ae.getSource() == print)
        {
            try
            {
                table.print();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == add)
        {
            setVisible(false);
            new AddStudent();
        }
        else if(ae.getSource() == update)
        {
                 setVisible(false);
                 new UpdateStudent();        
        }
        else if(ae.getSource() == cancel)
        {
                 setVisible(false);
        }
             
    }
    
    public static void main(String[]args)
    {
        new StudentDeatils();
    }
    
}

