package admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeHome extends JFrame implements ActionListener {
    
    // Employee info
    private String username;
    
    // Components
    private JPanel sidebarPanel, mainContentPanel, headerPanel, contentPanel;
    private JLabel lblWelcome, lblTitle, lblUserInfo;
    private List<JButton> sidebarButtons;
    
    // Custom colors for employee theme (slightly different from admin)
    private final Color PRIMARY_COLOR = new Color(46, 204, 113); // Green theme for employees
    private final Color SECONDARY_COLOR = new Color(39, 174, 96);
    private final Color ACCENT_COLOR = new Color(52, 152, 219);
    private final Color SIDEBAR_COLOR = new Color(34, 49, 63);
    private final Color BACKGROUND_COLOR = new Color(236, 240, 241);
    private final Color CARD_COLOR = Color.WHITE;
    private final Color TEXT_COLOR = new Color(44, 62, 80);
    private final Color WHITE = Color.WHITE;
    
    // Sidebar button references
    private JButton btnProfile, btnAddStudent, btnStudentDetails, btnBachelorCourse, btnMasterCourse;
    private JButton btnExamDetails, btnEnterMarks, btnUpdateStudent, btnNotepad, btnCalculator, btnExit;
    
    public EmployeeHome(String username) {
        super("University Management System - Employee Dashboard");
        this.username = username != null ? username : "Employee";
        
        initializeComponents();
        setupLayout();
        setupStyling();
        setupEventHandlers();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(1200, 700));
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void initializeComponents() {
        // Main panels
        sidebarPanel = new JPanel();
        headerPanel = new JPanel();
        mainContentPanel = new JPanel();
        contentPanel = new JPanel();
        
        // Header components
        lblTitle = new JLabel("Employee Dashboard");
        lblWelcome = new JLabel("Welcome, " + username);
        lblUserInfo = new JLabel("Logged in as: " + username + " (Employee)");
        
        // Initialize sidebar buttons list
        sidebarButtons = new ArrayList<>();
        
        // Create sidebar buttons
        btnProfile = createSidebarButton("My Profile", "icons/profile.png");
        btnAddStudent = createSidebarButton("Add Student", "icons/add-student.png");
        btnStudentDetails = createSidebarButton("Student Details", "icons/student-details.png");
        btnBachelorCourse = createSidebarButton("Bachelor Courses", "icons/bachelor.png");
        btnMasterCourse = createSidebarButton("Master Courses", "icons/master.png");
        btnExamDetails = createSidebarButton("Examination Details", "icons/exam.png");
        btnEnterMarks = createSidebarButton("Enter Marks", "icons/marks.png");
        btnUpdateStudent = createSidebarButton("Update Student", "icons/update-student.png");
        btnNotepad = createSidebarButton("Notepad", "icons/notepad.png");
        btnCalculator = createSidebarButton("Calculator", "icons/calculator.png");
        btnExit = createSidebarButton("Logout", "icons/exit.png");
    }
    
    private JButton createSidebarButton(String text, String iconPath) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.PLAIN, 14));
        button.setForeground(WHITE);
        button.setBackground(SIDEBAR_COLOR);
        button.setBorder(new EmptyBorder(15, 20, 15, 20));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
        button.setPreferredSize(new Dimension(250, 50));
        
        // Add hover effect
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(PRIMARY_COLOR);
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(SIDEBAR_COLOR);
            }
        });
        
        sidebarButtons.add(button);
        return button;
    }
    
    private void setupLayout() {
        setLayout(new BorderLayout());
        
        // Setup sidebar
        setupSidebar();
        
        // Setup header
        setupHeader();
        
        // Setup main content area
        setupMainContent();
        
        // Add panels to frame
        add(sidebarPanel, BorderLayout.WEST);
        add(headerPanel, BorderLayout.NORTH);
        add(mainContentPanel, BorderLayout.CENTER);
    }
    
    private void setupSidebar() {
        sidebarPanel.setLayout(new BorderLayout());
        sidebarPanel.setPreferredSize(new Dimension(280, 0));
        sidebarPanel.setBackground(SIDEBAR_COLOR);
        
        // Sidebar header
        JPanel sidebarHeader = new JPanel();
        sidebarHeader.setBackground(SECONDARY_COLOR);
        sidebarHeader.setPreferredSize(new Dimension(280, 80));
        sidebarHeader.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
        
        JLabel sidebarTitle = new JLabel("EMPLOYEE PANEL");
        sidebarTitle.setFont(new Font("Arial", Font.BOLD, 18));
        sidebarTitle.setForeground(WHITE);
        sidebarHeader.add(sidebarTitle);
        
        // Sidebar content
        JPanel sidebarContent = new JPanel();
        sidebarContent.setLayout(new BoxLayout(sidebarContent, BoxLayout.Y_AXIS));
        sidebarContent.setBackground(SIDEBAR_COLOR);
        sidebarContent.setBorder(new EmptyBorder(10, 0, 10, 0));
        
        // Add sections with separators
        addSidebarSection(sidebarContent, "PERSONAL", btnProfile);
        
        addSidebarSection(sidebarContent, "STUDENT MANAGEMENT", 
                         btnAddStudent, btnStudentDetails, btnUpdateStudent);
        
        addSidebarSection(sidebarContent, "ACADEMIC", 
                         btnBachelorCourse, btnMasterCourse);
        
        addSidebarSection(sidebarContent, "EXAMINATIONS", 
                         btnExamDetails, btnEnterMarks);
        
        addSidebarSection(sidebarContent, "UTILITIES", 
                         btnNotepad, btnCalculator);
        
        // Add logout button at bottom
        sidebarContent.add(Box.createVerticalGlue());
        addSidebarSection(sidebarContent, "", btnExit);
        
        JScrollPane scrollPane = new JScrollPane(sidebarContent);
        scrollPane.setBorder(null);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        
        sidebarPanel.add(sidebarHeader, BorderLayout.NORTH);
        sidebarPanel.add(scrollPane, BorderLayout.CENTER);
    }
    
    private void addSidebarSection(JPanel parent, String sectionTitle, JButton... buttons) {
        if (!sectionTitle.isEmpty()) {
            parent.add(Box.createVerticalStrut(10));
            
            JLabel sectionLabel = new JLabel(sectionTitle);
            sectionLabel.setFont(new Font("Arial", Font.BOLD, 12));
            sectionLabel.setForeground(new Color(149, 165, 166));
            sectionLabel.setBorder(new EmptyBorder(5, 20, 5, 20));
            sectionLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            parent.add(sectionLabel);
            
            parent.add(Box.createVerticalStrut(5));
        }
        
        for (JButton button : buttons) {
            parent.add(button);
            parent.add(Box.createVerticalStrut(2));
        }
    }
    
    private void setupHeader() {
        headerPanel.setLayout(new BorderLayout());
        headerPanel.setBackground(WHITE);
        headerPanel.setBorder(new CompoundBorder(
            new MatteBorder(0, 0, 1, 0, new Color(189, 195, 199)),
            new EmptyBorder(15, 30, 15, 30)
        ));
        headerPanel.setPreferredSize(new Dimension(0, 80));
        
        // Left side - Title and welcome
        JPanel leftHeader = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        leftHeader.setBackground(WHITE);
        
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitle.setForeground(PRIMARY_COLOR);
        
        lblWelcome.setFont(new Font("Arial", Font.PLAIN, 14));
        lblWelcome.setForeground(TEXT_COLOR);
        
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
        titlePanel.setBackground(WHITE);
        titlePanel.add(lblTitle);
        titlePanel.add(Box.createVerticalStrut(5));
        titlePanel.add(lblWelcome);
        
        leftHeader.add(titlePanel);
        
        // Right side - User info
        JPanel rightHeader = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        rightHeader.setBackground(WHITE);
        
        lblUserInfo.setFont(new Font("Arial", Font.PLAIN, 14));
        lblUserInfo.setForeground(TEXT_COLOR);
        rightHeader.add(lblUserInfo);
        
        headerPanel.add(leftHeader, BorderLayout.WEST);
        headerPanel.add(rightHeader, BorderLayout.EAST);
    }
    
    private void setupMainContent() {
        mainContentPanel.setLayout(new BorderLayout());
        mainContentPanel.setBackground(BACKGROUND_COLOR);
        
        contentPanel.setLayout(new GridLayout(2, 3, 20, 20));
        contentPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
        contentPanel.setBackground(BACKGROUND_COLOR);
        
        // Add dashboard cards for employee functions
        addDashboardCard("My Profile", "View and edit profile", PRIMARY_COLOR, "👤");
        addDashboardCard("Students", "Manage student records", ACCENT_COLOR, "👨‍🎓");
        addDashboardCard("Courses", "Academic programs", new Color(155, 89, 182), "📚");
        addDashboardCard("Examinations", "Exam management", new Color(241, 196, 15), "📝");
        addDashboardCard("Marks", "Grade management", new Color(231, 76, 60), "📊");
        addDashboardCard("Tools", "Utility applications", new Color(52, 73, 94), "🛠️");
        
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        
        mainContentPanel.add(scrollPane, BorderLayout.CENTER);
    }
    
    private void addDashboardCard(String title, String description, Color color, String icon) {
        JPanel card = new JPanel();
        card.setLayout(new BorderLayout());
        card.setBackground(CARD_COLOR);
        card.setBorder(new CompoundBorder(
            new LineBorder(new Color(189, 195, 199), 1),
            new EmptyBorder(20, 20, 20, 20)
        ));
        card.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // Card header with icon
        JPanel cardHeader = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        cardHeader.setBackground(CARD_COLOR);
        
        JLabel iconLabel = new JLabel(icon);
        iconLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 32));
        iconLabel.setForeground(color);
        
        JPanel iconPanel = new JPanel();
        iconPanel.setBackground(color.brighter().brighter());
        iconPanel.setBorder(new EmptyBorder(10, 15, 10, 15));
        iconPanel.add(iconLabel);
        
        cardHeader.add(iconPanel);
        
        // Card content
        JPanel cardContent = new JPanel();
        cardContent.setLayout(new BoxLayout(cardContent, BoxLayout.Y_AXIS));
        cardContent.setBackground(CARD_COLOR);
        cardContent.setBorder(new EmptyBorder(15, 0, 0, 0));
        
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(TEXT_COLOR);
        
        JLabel descLabel = new JLabel(description);
        descLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        descLabel.setForeground(new Color(127, 140, 141));
        
        cardContent.add(titleLabel);
        cardContent.add(Box.createVerticalStrut(5));
        cardContent.add(descLabel);
        
        // Hover effect
        card.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                card.setBackground(color.brighter().brighter().brighter());
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                card.setBackground(CARD_COLOR);
            }
        });
        
        card.add(cardHeader, BorderLayout.NORTH);
        card.add(cardContent, BorderLayout.CENTER);
        
        contentPanel.add(card);
    }
    
    private void setupStyling() {
        // Additional styling is handled in component creation methods
    }
    
    private void setupEventHandlers() {
        // Add action listeners to all sidebar buttons
        for (JButton button : sidebarButtons) {
            button.addActionListener(this);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        
        try {
            switch (command) {
                case "Logout":
                    int choice = JOptionPane.showConfirmDialog(
                        this,
                        "Are you sure you want to logout?",
                        "Confirm Logout",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                    );
                    if (choice == JOptionPane.YES_OPTION) {
                        setVisible(false);
                        // Return to login screen
                        new LoginMain();
                    }
                    break;
                    
                case "Calculator":
                    try {
                        Runtime.getRuntime().exec("calc.exe");
                    } catch (Exception e) {
                        // Try alternative calculator commands for different OS
                        try {
                            Runtime.getRuntime().exec("gnome-calculator");
                        } catch (Exception e2) {
                            JOptionPane.showMessageDialog(this, "Calculator not found on this system.");
                        }
                    }
                    break;
                    
                case "Notepad":
                    try {
                        Runtime.getRuntime().exec("notepad.exe");
                    } catch (Exception e) {
                        // Try alternative text editor commands
                        try {
                            Runtime.getRuntime().exec("gedit");
                        } catch (Exception e2) {
                            JOptionPane.showMessageDialog(this, "Text editor not found on this system.");
                        }
                    }
                    break;
                    
                case "My Profile":
                    new EmployeeProfile(username);
                    break;
                    
                case "Add Student":
                    new AddStudent();
                    break;
                    
                case "Student Details":
                    new StudentDeatils();
                    break;
                    
                case "Bachelor Courses":
                    new BachelorCourse();
                    break;
                    
                case "Master Courses":
                    new MasterCourse();
                    break;
                    
                case "Update Student":
                    new UpdateStudent();
                    break;
                    
                case "Enter Marks":
                    new EnterMarks();
                    break;
                    
                case "Examination Details":
                    new ExaminationDeatils();
                    break;
                    
                default:
                    JOptionPane.showMessageDialog(this, 
                        "Feature '" + command + "' is available for employees!", 
                        "Information", 
                        JOptionPane.INFORMATION_MESSAGE);
                    break;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                "Error opening " + command + ": " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
         
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new EmployeeHome("TestEmployee");
            }
        });
    }
}   
