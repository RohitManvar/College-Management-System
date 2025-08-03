
package admin;

import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class StudentCourse extends JFrame
{
    String unm,cou,dep;
    String rllno;
    String um,pass;
    
    StudentCourse(String unm)
    {
        super("Subjects");
        setSize(900, 700);
        setLocation(300, 70);
        setLayout(null);
        this.unm = unm;
        um = unm;
        
        
        JLabel lbldep = new JLabel("Department :");      
        lbldep.setBounds(300, 30, 200, 20);
        lbldep.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lbldep);
        
        JLabel txdep =new JLabel();
        txdep.setBounds(460, 25, 130, 30);
        txdep.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(txdep);
        
        JLabel lblcou = new JLabel("Course :");      
        lblcou.setBounds(300, 70, 100, 20);
        lblcou.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lblcou);
        
        JLabel txcou =new JLabel();
        txcou.setBounds(460, 65, 200, 30);
        txcou.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(txcou);       
        
        //sem 1
        
        JLabel lblsem1 = new JLabel("Semester   :  1");      
        lblsem1.setBounds(95, 140, 150, 20);
        lblsem1.setFont(new Font("Tahoma", Font.PLAIN, 19));
        add(lblsem1);
        
        JLabel lblsub = new JLabel("Subjects ");      
        lblsub.setBounds(230, 180, 200, 20);
        lblsub.setFont(new Font("Tahoma", Font.PLAIN, 19));
        add(lblsub);
                
        JLabel s1 =new JLabel("hii");
        s1.setBounds(110, 210, 330, 20);
        s1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(s1);
        
        JLabel s2 =new JLabel("hello");
        s2.setBounds(110, 240, 330, 20);
        s2.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(s2);
        
        JLabel s3 =new JLabel("byee");
        s3.setBounds(110, 270, 330, 20);
        s3.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(s3);
        
        JLabel s4 =new JLabel("simle");
        s4.setBounds(110, 300, 330, 20);
        s4.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(s4);
        
        JLabel s5 =new JLabel("bro");
        s5.setBounds(110, 330, 330, 20);
        s5.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(s5);
        
        //sem 2
        
        JLabel lblsem2 = new JLabel("Semester   :  2");      
        lblsem2.setBounds(480, 140, 150, 20);
        lblsem2.setFont(new Font("Tahoma", Font.PLAIN, 19));
        add(lblsem2);
        
        JLabel lblsub2 = new JLabel("Subjects ");      
        lblsub2.setBounds(610, 180, 200, 20);
        lblsub2.setFont(new Font("Tahoma", Font.PLAIN, 19));
        add(lblsub2);
                
        JLabel s6 =new JLabel("hii");
        s6.setBounds(500, 210, 330, 20);
        s6.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(s6);
        
        JLabel s7 =new JLabel("hello");
        s7.setBounds(500, 240, 330, 20);
        s7.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(s7);
        
        JLabel s8 =new JLabel("byee");
        s8.setBounds(500, 270, 330, 20);
        s8.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(s8);
        
        JLabel s9 =new JLabel("simle");
        s9.setBounds(500, 300, 330, 20);
        s9.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(s9);
        
        JLabel s10 =new JLabel("bro");
        s10.setBounds(500, 330, 330, 20);
        s10.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(s10);
        
        //sem 3
        
        JLabel lblsem3 = new JLabel("Semester   :  3");      
        lblsem3.setBounds(95, 380, 150, 20);
        lblsem3.setFont(new Font("Tahoma", Font.PLAIN, 19));
        add(lblsem3);
        
        JLabel lblsub3 = new JLabel("Subjects ");      
        lblsub3.setBounds(230, 420, 200, 20);
        lblsub3.setFont(new Font("Tahoma", Font.PLAIN, 19));
        add(lblsub3);
                
        JLabel s11 =new JLabel("hii");
        s11.setBounds(110, 450, 330, 20);
        s11.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(s11);
        
        JLabel s12 =new JLabel("hello");
        s12.setBounds(110, 480, 330, 20);
        s12.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(s12);
        
        JLabel s13 =new JLabel("byee");
        s13.setBounds(110, 510, 330, 20);
        s13.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(s13);
        
        JLabel s14 =new JLabel("simle");
        s14.setBounds(110, 540, 330, 20);
        s14.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(s14);
        
        JLabel s15 =new JLabel("bro");
        s15.setBounds(110, 570, 330, 20);
        s15.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(s15);
        
        //sem 4
        
        JLabel lblsem4 = new JLabel("Semester   :  4");      
        lblsem4.setBounds(480, 380, 150, 20);
        lblsem4.setFont(new Font("Tahoma", Font.PLAIN, 19));
        add(lblsem4);
        
        JLabel lblsub4 = new JLabel("Subjects ");      
        lblsub4.setBounds(610, 420, 200, 20);
        lblsub4.setFont(new Font("Tahoma", Font.PLAIN, 19));
        add(lblsub4);
                
        JLabel s16 =new JLabel("hii");
        s16.setBounds(500, 450, 330, 20);
        s16.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(s16);
        
        JLabel s17 =new JLabel("hello");
        s17.setBounds(500, 480, 330, 20);
        s17.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(s17);
        
        JLabel s18 =new JLabel("byee");
        s18.setBounds(500, 510, 330, 20);
        s18.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(s18);
        
        JLabel s19 =new JLabel("simle");
        s19.setBounds(500, 540, 330, 20);
        s19.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(s19);
        
        JLabel s20 =new JLabel("bro");
        s20.setBounds(500, 570, 330, 20);
        s20.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(s20);
        
        try
        {
            Conn c = new Conn();
            Statement s=c.c.createStatement();
            ResultSet rs=s.executeQuery("select * from student where Username='"+um+"'");
            while(rs.next())
            {
                 
                 rllno=rs.getString("Roll_No");
                 cou=rs.getString("Course");
                 dep=rs.getString("Department");
                 //System.out.println(rllno+" "+cou+""+dep+"");
                 
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        if(cou.equals("BCA"))
        {
            txdep.setText("Science");
            txcou.setText("BCA");
            //sem 1
            s1.setText("( 1 )  ->   FUNDAMENTALS OF COMPUTER");
            s2.setText("( 2 )  ->   ENGLISH");
            s3.setText("( 3 )  ->   PROGRAMMING IN C");
            s4.setText("( 4 )  ->   MATHEMATICAL");
            s5.setText("( 5 )  ->   C PRACTICAL");
            //sem 2
            s6.setText("( 1 )  ->   COMPUTER ORGANIZATION AND ARCHITECTURE");
            s7.setText("( 2 )  ->   DATA STRUCTURE USING C");
            s8.setText("( 3 )  ->   WEB PROGRAMMING -I");
            s9.setText("( 4 )  ->   MATHEMATICAL");
            s10.setText("( 5 )  ->   ENGLISH");
            //sem 3
            s11.setText("( 1 )  ->   ADVANCED ENGLISH");
            s12.setText("( 2 )  ->   OPERATING SYSTEM");
            s13.setText("( 3 )  ->   RELATIONAL DATABASE MANAGEMENT");
            s14.setText("( 4 )  ->   OOP WITH C++");
            s15.setText("( 5 )  ->   DATA SCIENCE USING PYTHON");
            //sem 4
            s16.setText("( 1 )  ->   SYSTEM ANALYSIS AND DESIGN");
            s17.setText("( 2 )  ->   PROGRAMMING WITH JAVA");
            s18.setText("( 3 )  ->   WEB PROGRAMMING -II");
            s19.setText("( 4 )  ->   APPLIED DATA SCIENCE USING PYTHON");
            s20.setText("( 5 )  ->   EFFECTIVE COMMUNICATIVE SKILLS");
        }
        else if(cou.equals("BBA"))
        {
            
            txdep.setText("Commerce");
            txcou.setText("BBA");
            //sem 1
            s1.setText("( 1 )  ->   Microeconomics");
            s2.setText("( 2 )  ->   Finacial Accounting");
            s3.setText("( 3 )  ->   Essentials of IT");
            s4.setText("( 4 )  ->   Principles of Management");
            s5.setText("( 5 )  ->   Quantitative");
            //sem 2
            s6.setText("( 1 )  ->   Organizational Behavior");
            s7.setText("( 2 )  ->   Business Economics I");
            s8.setText("( 3 )  ->   Business Statistics");
            s9.setText("( 4 )  ->   IATA Travel & Tourism");
            s10.setText("( 5 )  ->   Enrichment course");
            //sem 3
            s11.setText("( 1 )  ->   Marketing Management	");
            s12.setText("( 2 )  ->   Research Methodology");
            s13.setText("( 3 )  ->   Financial Management	");
            s14.setText("( 4 )  ->   Business Economics II	");
            s15.setText("( 5 )  ->   Open Elective I	");
            //sem 4
            s16.setText("( 1 )  ->   Business Communication II");
            s17.setText("( 2 )  ->   Cargo Handling");
            s18.setText("( 3 )  ->   Programme Elective 1");
            s19.setText("( 4 )  ->   Market Research");
            s20.setText("( 5 )  ->   Open Elective 2");
        }
        else if(cou.equals("BA in Humanities"))
        {
            txdep.setText("Arts");
            txcou.setText("BA in Humanities");
            //sem 1
            s1.setText("( 1 )  ->   English Communication");
            s2.setText("( 2 )  ->   Development of Psychological Thought");
            s3.setText("( 3 )  ->   Political Science");
            s4.setText("( 4 )  ->   Language");
            s5.setText(" ");
            //sem 2
            s6.setText("( 1 )  ->   Youth, Gender, and Identity");
            s7.setText("( 2 )  ->   Psychological Research");
            s8.setText("( 3 )  ->   Emotional Intelligence");
            s9.setText("( 4 )  ->   Professional Communication");
            s10.setText(" ");
            //sem 3
            s11.setText("( 1 )  ->   Social & Political Philosophy");
            s12.setText("( 2 )  ->   Continental Philosophy");
            s13.setText("( 3 )  ->   Writing Skills");
            s14.setText("( 4 )  ->   Canadian Literature");
            s15.setText("( 5 )  ->   Elective");
            //sem 4
            s16.setText("( 1 )  ->   Western Philosophy: Descartes to Kant");
            s17.setText("( 2 )  ->   Text of Western Philosophy");
            s18.setText("( 3 )  ->   Life Skills");
            s19.setText("( 4 )  ->   American Literature");
            s20.setText("( 5 )  ->   Cultural Education I");
        }
        setVisible(true);
    }
    public static void main(String [] args)
    {
        new StudentCourse("");
    }
}
