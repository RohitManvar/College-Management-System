
package admin;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;


public class MasterCourse extends JFrame
{
    JTable table,table2,table3;
    JLabel l1,l2,l3,l4;
    MasterCourse()
    {
        super("Master Courses");
        setSize(900, 700);
        setLocation(400, 100);
        setVisible(true);
        setLayout(null);

        l1= new JLabel("Master Courses");
        l1.setBounds(300, 40, 230, 50);
        l1.setFont(new Font("serif",Font.BOLD,30));
        add(l1);
        
        l2= new JLabel("Commerce");
        l2.setBounds(100, 140, 100, 40);
        l2.setFont(new Font("serif",Font.BOLD,20));
        add(l2);

        l3= new JLabel("Science");
        l3.setBounds(395, 140, 95, 40);
        l3.setFont(new Font("serif",Font.BOLD,20));
        add(l3);

        l4= new JLabel("Arts");
        l4.setBounds(680, 140, 50, 40);
        l4.setFont(new Font("serif",Font.BOLD,20));
        add(l4);

        table = new JTable();
        table2 = new JTable();
        table3 = new JTable();

        // Commerce      

        try {
            Conn c = new Conn();
            String query = "SELECT Course, COUNT(*) as Count FROM student WHERE Course ='I-MBA' || Course ='MBA' || Course ='M.Com' || Course ='MMS' GROUP BY Course";// || Course ='BFA' || Course ='I-MBA' || Course ='BMS' || Course ='CS' GROUP BY Course";
            ResultSet rs = c.s.executeQuery(query);

            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(50, 200, 200, 200);
        add(jsp);

        // Science
        
        table2 = new JTable();
        try {
            Conn c = new Conn();
            String query2 = "SELECT Course, COUNT(*) as Count FROM student WHERE Course = 'MMBS' || Course = 'MBBS' GROUP BY Course";// || Course = 'BTECH' || Course = 'BArch' || Course = 'BDS' || Course = 'MMBS' || Course = 'MBBS' || Course = 'BDT' || Course = 'BAMS' || Course = 'BHMS' || Course = 'BUMS' GROUP BY Course";
            ResultSet rs2 = c.s.executeQuery(query2);

            table2.setModel(DbUtils.resultSetToTableModel(rs2));
        } catch (Exception e) {
            e.printStackTrace();
        }
        JScrollPane jsp2 = new JScrollPane(table2);
        jsp2.setBounds(330, 200, 200, 200);
        add(jsp2);

        // Arts
        
        table3 = new JTable();
        try {
            Conn c = new Conn();
            String query3 = "SELECT Course, COUNT(*) as Count FROM student WHERE Course = 'MJ' || Course = 'MA in Arts' || Course = 'MFA(Fine Arts)' || Course ='MA in Humanities' || Course ='MJMC' || Course ='MHM' || Course ='MJ' GROUP BY Course";// || Course ='BDes in Desgin'    || Course ='BMM' ;
            ResultSet rs3 = c.s.executeQuery(query3);

            table3.setModel(DbUtils.resultSetToTableModel(rs3));
        } catch (Exception e) {
            e.printStackTrace();
        }
        JScrollPane jsp3 = new JScrollPane(table3);
        jsp3.setBounds(600, 200, 200, 200);
        add(jsp3);        
        
 
    }
    public static void main(String[]args)
    {
        new MasterCourse();
    }
}
