package admin;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class StudentHome extends JFrame implements ActionListener
{
//    JLabel l1;
      String um,unm,rllno;
//    JTable table;
   StudentHome(String unm)
   {
       super("Student Home");
        setSize(1504,850);
        this.unm=unm;
        um=unm;
        System.out.println(um);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Logo/facebook_profile_image.png"));
        Image i2 = i1.getImage().getScaledInstance(500,450,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        //image.setBounds(350,0,200,200);
        add(image);
      
        JMenuBar mb = new JMenuBar();
        
        //Standard and Faculty add data
        
        
        JMenu Profile  = new JMenu("Profile");
        Profile.setForeground(Color.RED);
        mb.add(Profile);
        
        JMenuItem pro  = new JMenuItem("Profile");
        pro.setBackground(Color.WHITE);
        pro.addActionListener(this);
        Profile.add(pro);
        
        //Details of standard and faculty
//        JMenu details  = new JMenu("View Details");
//        details.setForeground(Color.RED);
//        mb.add(details);
//        
//       
//        
//        JMenuItem sutdentdetails  = new JMenuItem("Student Deatils");
//        sutdentdetails.setBackground(Color.WHITE);
//        sutdentdetails.addActionListener(this);
//        details.add(sutdentdetails);
        
        //Course
        
        JMenu course  = new JMenu("Course");
        course.setForeground(Color.RED);
        mb.add(course);
        
        JMenuItem bachelorcourse  = new JMenuItem("Course Details");
        bachelorcourse.setBackground(Color.WHITE);
        bachelorcourse.addActionListener(this);
        course.add(bachelorcourse);
               
//        JMenuItem mastercourse  = new JMenuItem("Master Courses");
//        mastercourse.setBackground(Color.WHITE);
//        mastercourse.addActionListener(this);
//        course.add(mastercourse);
//        
//        JMenuItem phdcourse  = new JMenuItem("PHD Courses");
//        phdcourse.setBackground(Color.WHITE);
//        phdcourse.addActionListener(this);
//        course.add(phdcourse);
        

        
//        //Leave Details
//        JMenu leavedeatils   = new JMenu("Leave Details");
//        leavedeatils.setForeground(Color.RED);
//        mb.add(applyleave);
//        
//        JMenuItem facultyleavedetails  = new JMenuItem("Faculty Leave Deatils");
//        facultyleavedetails.setBackground(Color.WHITE);
//        leavedeatils.add(facultyleavedetails);
//        
//        JMenuItem studentleavedetails  = new JMenuItem("Student Leave Deatils");
//        studentleavedetails.setBackground(Color.WHITE);
//        leavedeatils.add(studentleavedetails);
        
        //Exams Deatisl
        JMenu exam   = new JMenu("Examination");
        exam.setForeground(Color.RED);
        mb.add(exam);
        
        JMenuItem examinationdetails  = new JMenuItem("Examination & Result");
        examinationdetails.setBackground(Color.WHITE);
        examinationdetails.addActionListener(this);
        exam.add(examinationdetails);
        
//        JMenuItem entermarks  = new JMenuItem("Student Enter Marks ");
//        entermarks.setBackground(Color.WHITE);
//        entermarks.addActionListener(this);
//        exam.add(entermarks);
 
        
        
        //Fee  Deatils
//        JMenu fee  = new JMenu(" Fee Deatils");
//        fee.setForeground(Color.RED);
//        mb.add(fee);
        
//        JMenuItem feestructure  = new JMenuItem("Fee Structure");
//        feestructure.setBackground(Color.WHITE);
//        feestructure.addActionListener(this);
//        fee.add(feestructure);
        
//        JMenuItem feeform  = new JMenuItem("Student Fee Deatils");
//        feeform.setBackground(Color.WHITE);
//        feeform.addActionListener(this);
//        fee.add(feeform);
        
        //Utilty
//        JMenu utilty  = new JMenu("Utilty");
//        utilty.setForeground(Color.RED);
//        mb.add(utilty);
//        
//        
//        
//        JMenuItem notepad  = new JMenuItem("NotePad");
//        notepad.setBackground(Color.WHITE);
//        notepad.addActionListener(this);
//        utilty.add(notepad);
//        
//        JMenuItem calc  = new JMenuItem("Calculator");
//        calc.setBackground(Color.WHITE);
//        calc.addActionListener(this);
//        utilty.add(calc);
        
        
        //Exit
        JMenu exit  = new JMenu("Exit");
        exit.setForeground(Color.RED);
        mb.add(exit);
        
        
        JMenuItem ex  = new JMenuItem("Logout");
        ex.setBackground(Color.WHITE);
        ex.addActionListener(this);
        exit.add(ex);
        
        addWindowListener(new java.awt.event.WindowAdapter() {
    @Override
    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
//        if (JOptionPane.showConfirmDialog(null, "Are you sure you want to close this window?", "Close Window?", 
//            JOptionPane.YES_NO_OPTION,
//            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){    
//        }
        try
        {
            Conn c = new Conn();
            String qu="delete from username";
            c.s.executeUpdate(qu);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
});
        
        setJMenuBar(mb);
        setVisible(true);
   }  
   public void actionPerformed(ActionEvent ae)
   {
     String msg = ae.getActionCommand();
     
       switch (msg) {
           case "Logout":
               new Studentlogout();
               setVisible(false);
               break;
//           case "Calculator":
//               try
//               {
//                   Runtime.getRuntime().exec("calc.exe");
//               }
//               catch(Exception e)
//               {
//                   System.out.println(e);
//               }     break;
//           case "NotePad":
//               try
//               {
//                   Runtime.getRuntime().exec("notepad.exe");
//               }
//               catch(Exception e)
//               {
//                   System.out.println(e);
//               }      break;
           
//           case"Student Deatils":
//               new StudentDeatils();
//               break;
           
           case"Course Details":
               new StudentCourse(unm);
               break;
//           case"Master Courses":
//               new SMasterCourse();
//               break;
//           case"PHD Courses":
//               new SPHDCourse();
//               break;          
//           case"Student Enter Marks ":
//               new SEnterMarks();
//               break;
           case"Examination & Result":
                   try
                 {
                     Conn c = new Conn();
                     Statement s=c.c.createStatement();
                     ResultSet rs=s.executeQuery("select * from student where Username='"+um+"'");
                     while(rs.next())
                     {

                          rllno=rs.getString("Roll_No");
         //                 cou=rs.getString("Course");
         //                 dep=rs.getString("Department");
                          //System.out.println(rllno+" "+cou+""+dep+"");

                     }
                 }
                 catch(Exception e)
                 {
                     e.printStackTrace();
                 }
               new Marks1(rllno);
               break;
//           case"Fee Structure":
//               new SFeeStructure();
//               break;
//           case"Student Fee Deatils":
//               new StudentFeeForm();
//               break;
           case"Profile":
               new StudentProfile();
               break;    
           default:
               break;
       }
       
    }
    public static void main(String[]args)
    {
     new StudentHome("");
    }
}