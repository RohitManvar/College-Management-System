package admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EmployeeHome extends JFrame implements ActionListener
{
    String um,unm;
   EmployeeHome(String unm)
   {
       super("Employee Home");
        setSize(1504,850);
        
        this.unm=unm;
        um=unm;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Logo/facebook_profile_image.png"));
        Image i2 = i1.getImage().getScaledInstance(500,450,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        //image.setBounds(350,0,200,200);
        add(image);
      
        JMenuBar mb = new JMenuBar();
        
        //Profile
        
        JMenu pf  = new JMenu("Profile");
        pf.setForeground(Color.RED);
        mb.add(pf);
        
        
        JMenuItem pfo  = new JMenuItem("Profile");
        pfo.setBackground(Color.WHITE);
        pfo.addActionListener(this);
        pf.add(pfo);
        
        //Standard and Faculty add data
        JMenu newinformation  = new JMenu("New Information");
        newinformation.setForeground(Color.RED);
        mb.add(newinformation);
        
        
        JMenuItem sutdentinfo  = new JMenuItem("New Add Student Data");
        sutdentinfo.setBackground(Color.WHITE);
        sutdentinfo.addActionListener(this);
        newinformation.add(sutdentinfo);
        
        
        //Details of standard and faculty
        JMenu details  = new JMenu("View Details");
        details.setForeground(Color.RED);
        mb.add(details);
        
        
        JMenuItem sutdentdetails  = new JMenuItem("Student Deatils");
        sutdentdetails.setBackground(Color.WHITE);
        sutdentdetails.addActionListener(this);
        details.add(sutdentdetails);
        
        //Course
        
        JMenu course  = new JMenu("Course Details");
        course.setForeground(Color.RED);
        mb.add(course);
        
        JMenuItem bachelorcourse  = new JMenuItem("Bachelor Courses");
        bachelorcourse.setBackground(Color.WHITE);
        bachelorcourse.addActionListener(this);
        course.add(bachelorcourse);
               
        JMenuItem mastercourse  = new JMenuItem("Master Courses");
        mastercourse.setBackground(Color.WHITE);
        mastercourse.addActionListener(this);
        course.add(mastercourse);
        
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
        
        JMenuItem examinationdetails  = new JMenuItem("Examination Deatils");
        examinationdetails.setBackground(Color.WHITE);
        examinationdetails.addActionListener(this);
        exam.add(examinationdetails);
        
        JMenuItem entermarks  = new JMenuItem("Student Enter Marks ");
        entermarks.setBackground(Color.WHITE);
        entermarks.addActionListener(this);
        exam.add(entermarks);
 
        //UpdateInfo
        JMenu UpdateInfo   = new JMenu("Update Deatils");
        UpdateInfo.setForeground(Color.RED);
        mb.add(UpdateInfo);
        
        JMenuItem updatestudentinfo  = new JMenuItem("Update Student Deatils");
        updatestudentinfo.setBackground(Color.WHITE);
        updatestudentinfo.addActionListener(this);
        UpdateInfo.add(updatestudentinfo);
        
        
        
        //Fee  Deatils
//        JMenu fee  = new JMenu(" Fee Deatils");
//        fee.setForeground(Color.RED);
//        mb.add(fee);
//        
//        JMenuItem feestructure  = new JMenuItem("Fee Structure");
//        feestructure.setBackground(Color.WHITE);
//        feestructure.addActionListener(this);
//        fee.add(feestructure);
//        
//        JMenuItem feeform  = new JMenuItem("Student Fee Deatils");
//        feeform.setBackground(Color.WHITE);
//        feeform.addActionListener(this);
        //fee.add(feeform);
        
        //Utilty
        JMenu utilty  = new JMenu("Utilty");
        utilty.setForeground(Color.RED);
        mb.add(utilty);
        
        
        
        JMenuItem notepad  = new JMenuItem("NotePad");
        notepad.setBackground(Color.WHITE);
        notepad.addActionListener(this);
        utilty.add(notepad);
        
        JMenuItem calc  = new JMenuItem("Calculator");
        calc.setBackground(Color.WHITE);
        calc.addActionListener(this);
        utilty.add(calc);
        
        
        //Exit
        JMenu exit  = new JMenu("Exit");
        exit.setForeground(Color.RED);
        mb.add(exit);
        
        
        JMenuItem ex  = new JMenuItem("Exit");
        ex.setBackground(Color.WHITE);
        ex.addActionListener(this);
        exit.add(ex);
        
        
        
        
        setJMenuBar(mb);
        
        setVisible(true);
   }  
   public void actionPerformed(ActionEvent ae)
   {
     String msg = ae.getActionCommand();
     
       switch (msg) {
           case "Exit":
               setVisible(false);
               break;
           case "Calculator":
               try
               {
                   Runtime.getRuntime().exec("calc.exe");
               }
               catch(Exception e)
               {
                   System.out.println(e);
               }     break;
           case "NotePad":
               try
               {
                   Runtime.getRuntime().exec("notepad.exe");
               }
               catch(Exception e)
               {
                   System.out.println(e);
               }      break;
           case "New Add Student Data":
               new AddStudent();
               break;
           case"Student Deatils":
               new StudentDeatils();
               break;
           case"Bachelor Courses":
               new BachelorCourse();
               break;
           case"Master Courses":
               new MasterCourse();
               break;
//           case"PHD Courses":
//               new EPHDCourse();
//               break;
           case"Update Student Deatils":
               new UpdateStudent();
               break;
           case"Student Enter Marks ":
               new EnterMarks();
               break;
           case"Examination Deatils":
               new ExaminationDeatils();
               break;
           case"Fee Structure":
               new FeeStructure();
               break;
           case"Student Fee Deatils":
               new StudentFeeForm();
               break;
           case"Profile":
               new EmployeeProfile(um);
               break;    
           default:
               break;
       }
       
    }
    public static void main(String[]args)
    {
     new EmployeeHome("");
    }
}