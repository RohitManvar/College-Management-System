package admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class StudentHome extends JFrame implements ActionListener {
    
    // Student info
    private String username;
    private String rollNo;
    
    // Components
    private JPanel sidebarPanel, mainContentPanel, headerPanel, contentPanel;
    private JLabel lblWelcome, lblTitle, lblUserInfo;
    private List<JButton> sidebarButtons;
    
    // Custom colors for student theme (purple/blue theme)
    private final Color PRIMARY_COLOR = new Color(155, 89, 182); // Purple theme for students
    private final Color SECONDARY_COLOR = new Color(142, 68, 173);
    private final Color ACCENT_COLOR = new Color(52, 152, 219);
    private final Color SIDEBAR_COLOR = new Color(44, 62, 80);
    private final Color BACKGROUND_COLOR = new Color(236, 240, 241);
    private final Color CARD_COLOR = Color.WHITE;
    private final Color TEXT_COLOR = new Color(44, 62, 80);
    private final Color WHITE = Color.WHITE;
    
    // Sidebar button references
    private JButton btnProfile, btnCourseDetails, btnExamResults, btnLogout;
    
    public StudentHome(String username) {
        super("University Management System - Student Portal");
        this.username = username != null ? username : "Student";
        
        initializeComponents();
        setupLayout();
        setupStyling();
        setupEventHandlers();
        setupWindowCloseHandler();
        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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
        lblTitle = new JLabel("Student Portal");
        lblWelcome = new JLabel("Welcome, " + username);
        lblUserInfo = new JLabel("Logged in as: " + username + " (Student)");
        
        // Initialize sidebar buttons list
        sidebarButtons = new ArrayList<>();
        
        // Create sidebar buttons (limited to student functions)
        btnProfile = createSidebarButton("My Profile", "icons/profile.png");
        btnCourseDetails = createSidebarButton("Course Details", "icons/courses.png");
        btnExamResults = createSidebarButton("Examination & Results", "icons/results.png");
        btnLogout = createSidebarButton("Logout", "icons/logout.png");
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
        
        JLabel sidebarTitle = new JLabel("STUDENT PORTAL");
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
        addSidebarSection(sidebarContent, "ACADEMIC", btnCourseDetails, btnExamResults);
        
        // Add logout button at bottom
        sidebarContent.add(Box.createVerticalGlue());
        addSidebarSection(sidebarContent, "", btnLogout);
        
        JScrollPane scrollPane = new JScrollPane(sidebarContent);
        scrollPane.setBorder(null);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        
        sidebarPanel.add(sidebarHeader, BorderLayout.NORTH);
        sidebarPanel.add(scrollPane, BorderLayout.CENTER);
    }
    
    private void addSidebarSection(JPanel parent, String sectionTitle, JButton... buttons) {
        if (!sectionTitle.isEmpty()) {
            parent.add(Box.createVerticalStrut(15));
            
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
            parent.add(Box.createVerticalStrut(3));
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
        
        // Right side - User info and current time
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
        
        // Create welcome message panel
        JPanel welcomePanel = createWelcomePanel();
        
        // Create quick access cards
        contentPanel.setLayout(new GridLayout(1, 3, 20, 20));
        contentPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
        contentPanel.setBackground(BACKGROUND_COLOR);
        
        // Add dashboard cards for student functions
        addDashboardCard("My Profile", "View personal information and academic records", PRIMARY_COLOR, "👤");
        addDashboardCard("Courses", "View enrolled courses and syllabus", ACCENT_COLOR, "📚");
        addDashboardCard("Results", "Check examination results and grades", new Color(231, 76, 60), "📊");
        
        // Create main content with welcome and cards
        JPanel mainContent = new JPanel(new BorderLayout());
        mainContent.setBackground(BACKGROUND_COLOR);
        mainContent.add(welcomePanel, BorderLayout.NORTH);
        mainContent.add(contentPanel, BorderLayout.CENTER);
        
        JScrollPane scrollPane = new JScrollPane(mainContent);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        
        mainContentPanel.add(scrollPane, BorderLayout.CENTER);
    }
    
    private JPanel createWelcomePanel() {
        JPanel welcomePanel = new JPanel();
        welcomePanel.setLayout(new BorderLayout());
        welcomePanel.setBackground(PRIMARY_COLOR);
        welcomePanel.setBorder(new EmptyBorder(40, 30, 40, 30));
        
        JLabel welcomeTitle = new JLabel("Welcome to Your Student Portal");
        welcomeTitle.setFont(new Font("Arial", Font.BOLD, 28));
        welcomeTitle.setForeground(WHITE);
        welcomeTitle.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel welcomeText = new JLabel("Access your academic information, view courses, and check results");
        welcomeText.setFont(new Font("Arial", Font.PLAIN, 16));
        welcomeText.setForeground(WHITE);
        welcomeText.setHorizontalAlignment(SwingConstants.CENTER);
        
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setBackground(PRIMARY_COLOR);
        textPanel.add(welcomeTitle);
        textPanel.add(Box.createVerticalStrut(10));
        textPanel.add(welcomeText);
        
        welcomePanel.add(textPanel, BorderLayout.CENTER);
        
        return welcomePanel;
    }
    
    private void addDashboardCard(String title, String description, Color color, String icon) {
        JPanel card = new JPanel();
        card.setLayout(new BorderLayout());
        card.setBackground(CARD_COLOR);
        card.setBorder(new CompoundBorder(
            new LineBorder(new Color(189, 195, 199), 1),
            new EmptyBorder(30, 25, 30, 25)
        ));
        card.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // Card header with icon
        JPanel cardHeader = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        cardHeader.setBackground(CARD_COLOR);
        
        JLabel iconLabel = new JLabel(icon);
        iconLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 48));
        iconLabel.setForeground(color);
        
        JPanel iconPanel = new JPanel();
        iconPanel.setBackground(color.brighter().brighter());
        iconPanel.setBorder(new EmptyBorder(20, 25, 20, 25));
        iconPanel.add(iconLabel);
        
        cardHeader.add(iconPanel);
        
        // Card content
        JPanel cardContent = new JPanel();
        cardContent.setLayout(new BoxLayout(cardContent, BoxLayout.Y_AXIS));
        cardContent.setBackground(CARD_COLOR);
        cardContent.setBorder(new EmptyBorder(20, 0, 0, 0));
        
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(TEXT_COLOR);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel descLabel = new JLabel("<html><center>" + description + "</center></html>");
        descLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        descLabel.setForeground(new Color(127, 140, 141));
        descLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        cardContent.add(titleLabel);
        cardContent.add(Box.createVerticalStrut(10));
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
            
            @Override
            public void mouseClicked(MouseEvent e) {
                // Handle card clicks
                switch (title) {
                    case "My Profile":
                        actionPerformed(new ActionEvent(btnProfile, ActionEvent.ACTION_PERFORMED, "My Profile"));
                        break;
                    case "Courses":
                        actionPerformed(new ActionEvent(btnCourseDetails, ActionEvent.ACTION_PERFORMED, "Course Details"));
                        break;
                    case "Results":
                        actionPerformed(new ActionEvent(btnExamResults, ActionEvent.ACTION_PERFORMED, "Examination & Results"));
                        break;
                }
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
    
    private void setupWindowCloseHandler() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                handleLogout();
            }
        });
    }
    
    private void handleLogout() {
        try {
            Conn c = new Conn();
            String query = "DELETE FROM username";
            c.s.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
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
                        handleLogout();
                        new Studentlogout();
                        setVisible(false);
                    }
                    break;
                    
                case "My Profile":
                    new StudentProfile();
                    break;
                    
                case "Course Details":
                    new StudentCourse(username);
                    break;
                    
                case "Examination & Results":
                    // Get student roll number from database
                    try {
                        Conn c = new Conn();
                        Statement s = c.c.createStatement();
                        ResultSet rs = s.executeQuery("SELECT * FROM student WHERE Username='" + username + "'");
                        
                        if (rs.next()) {
                            rollNo = rs.getString("Roll_No");
                            new Marks1(rollNo);
                        } else {
                            JOptionPane.showMessageDialog(this, 
                                "Student record not found. Please contact administrator.", 
                                "Error", 
                                JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(this, 
                            "Database error: " + e.getMessage(), 
                            "Error", 
                            JOptionPane.ERROR_MESSAGE);
                        e.printStackTrace();
                    }
                    break;
                    
                default:
                    JOptionPane.showMessageDialog(this, 
                        "Feature '" + command + "' is available in student portal!", 
                        "Information", 
                        JOptionPane.INFORMATION_MESSAGE);
                    break;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                "Error accessing " + command + ": " + e.getMessage(), 
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
                new StudentHome("TestStudent");
            }
        });
    }
}
