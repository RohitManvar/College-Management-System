//package university;
//
//import java.awt.*;
//import java.sql.*;
//import javax.swing.*;
//import net.proteanit.sql.DbUtils;
//
//public class BachelorCourse extends JFrame {
//
//    JTable table,table2,table3;
//
//    BachelorCourse() {
//        
//        setSize(900, 700);
//        setLocation(400, 100);
//        setVisible(true);
//        setLayout(null);
//
//        JLabel lbl1 = new JLabel("Bachelor Course ");
//        lbl1.setFont(new Font("serif", Font.BOLD, 20));
//        lbl1.setBounds(260, 20, 300, 20);
//        add(lbl1);
//
//        table = new JTable();
//        table2 = new JTable();
//        table3 = new JTable();
//               
//        //Commerce
//
//        JLabel lbl2 = new JLabel("Commerce Course");
//        lbl2.setFont(new Font("serif", Font.BOLD, 30));
//        lbl2.setBounds(10, 80, 250, 30);
//        add(lbl2);
//
//        try {
//            Conn c = new Conn();
//            String query = "SELECT Course, COUNT(*) as Count FROM student WHERE Course ='BBA' || Course ='B.Com' || Course ='BComs Hons' || Course ='CA' || Course ='BFA' || Course ='I-MBA' || Course ='BMS' || Course ='CS' GROUP BY Course";
//            ResultSet rs = c.s.executeQuery(query);
//            
//            table.setModel(DbUtils.resultSetToTableModel(rs));
////            table.setBounds(300 , 100 , 300, 60);
////            add(table);
////            //rs.next();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        JScrollPane jsp = new JScrollPane(table);
//        jsp.setBounds(50, 200, 200, 200);
// //       jsp.setFont(new Font("serif",Font.BOLD,60));
//        add(jsp);
//        
//        //Science
//
//        JLabel lbl3 = new JLabel("Scince Course ");
//        lbl3.setFont(new Font("serif", Font.BOLD, 30));
//        lbl3.setBounds(340, 80, 250, 20);
//        add(lbl3);
//        
//        table2 = new JTable();            
//        try {
//            Conn c = new Conn();
//            String query2 = "SELECT Course, COUNT(*) as Count FROM student WHERE Course = 'BCA' || Course = 'BSc.IT' || Course = 'BTECH' || Course = 'BArch' || Course = 'BDS' || Course = 'MMBS' || Course = 'MBBS' || Course = 'BDT' || Course = 'BAMS' || Course = 'BHMS' || Course = 'BUMS' GROUP BY Course";
//            ResultSet rs2 = c.s.executeQuery(query2);
//            
//            table2.setModel(DbUtils.resultSetToTableModel(rs2));
////            table.setBounds(300 , 100 , 300, 60);
////            add(table);
////            //rs.next();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        JScrollPane jsp2 = new JScrollPane(table2);
//        jsp2.setBounds(330, 200, 200, 200);
// //       jsp2.setFont(new Font("serif",Font.BOLD,60));
//        add(jsp2);
//        
//        //Engineering and Technology
//  
//        JLabel lbl4 = new JLabel("Arts Course ");
//        lbl4.setFont(new Font("serif", Font.BOLD, 30));
//        lbl4.setBounds(610, 80, 250, 20);
//        add(lbl4);
//        
//        table3 = new JTable();            
//        try {
//            Conn c = new Conn();
//            String query3 = "SELECT Course, COUNT(*) as Count FROM student WHERE Course = 'BA in Humanities' || Course = 'BA in Arts' || Course = 'BFA(Fine Arts)' || Course ='BDes in Animation' || Course ='BDes in Desgin' || Course ='BJMC' || Course ='BHM' || Course ='BJ' || Course ='BMM' GROUP BY Course";
//            ResultSet rs3 = c.s.executeQuery(query3);
//            
//            table3.setModel(DbUtils.resultSetToTableModel(rs3));
////            table.setBounds(300 , 100 , 300, 60);
////            add(table);
////            //rs.next();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        JScrollPane jsp3 = new JScrollPane(table3);
//        jsp3.setBounds(600, 200, 200, 200);
// //       jsp3.setFont(new Font("serif",Font.BOLD,60));
//        add(jsp3);
//            
//    }
//
//    public static void main(String[] args) {
//        new BachelorCourse();
//    }
//}

package admin;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class BachelorCourse extends JFrame {

    JTable table, table2, table3;
    JLabel l1,l2,l3,l4;
            
    BachelorCourse() {
        super("Bachelor Courses");
        setSize(900, 700);
        setLocation(400, 100);
        setVisible(true);
        setLayout(null);

        l1= new JLabel("Bachelor Course");
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
            String query = "SELECT Course, COUNT(*) as Count FROM student WHERE Course ='BBA' || Course ='B.Com' || Course ='BComs Hons' || Course ='CA' || Course ='BFA' || Course ='I-MBA' || Course ='BMS' || Course ='CS' GROUP BY Course";
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
            String query2 = "SELECT Course, COUNT(*) as Count FROM student WHERE Course = 'BCA' || Course = 'BSc.IT' || Course = 'BTECH' || Course = 'BArch' || Course = 'BDS' || Course = 'MMBS' || Course = 'MBBS' || Course = 'BDT' || Course = 'BAMS' || Course = 'BHMS' || Course = 'BUMS' GROUP BY Course";
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
            String query3 = "SELECT Course, COUNT(*) as Count FROM student WHERE Course = 'BA in Humanities' || Course = 'BA in Arts' || Course = 'BFA(Fine Arts)' || Course ='BDes in Animation' || Course ='BDes in Desgin' || Course ='BJMC' || Course ='BHM' || Course ='BJ' || Course ='BMM' GROUP BY Course";
            ResultSet rs3 = c.s.executeQuery(query3);

            table3.setModel(DbUtils.resultSetToTableModel(rs3));
        } catch (Exception e) {
            e.printStackTrace();
        }
        JScrollPane jsp3 = new JScrollPane(table3);
        jsp3.setBounds(600, 200, 200, 200);
        add(jsp3);

    }

    public static void main(String[] args) {
        new BachelorCourse();
    }
}
