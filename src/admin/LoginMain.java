package admin;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;

public class LoginMain extends JFrame implements ActionListener {
    private JButton btnAdmin, btnEmployee, btnStudent, btnExit;
    private JLabel lblTitle, lblUsername, lblPassword, lblWelcome;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JPanel mainPanel, loginPanel, buttonPanel, headerPanel;
    
    // Custom colors for modern design
    private final Color PRIMARY_COLOR = new Color(41, 128, 185);
    private final Color SECONDARY_COLOR = new Color(52, 73, 94);
    private final Color ACCENT_COLOR = new Color(46, 204, 113);
    private final Color BACKGROUND_COLOR = new Color(236, 240, 241);
    private final Color TEXT_COLOR = new Color(44, 62, 80);
    private final Color WHITE = Color.WHITE;
    
    public LoginMain() {
        super("College Management System - Login");
        initializeComponents();
        setupLayout();
        setupStyling();
        setupEventHandlers();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
    
    private void initializeComponents() {
        // Main panels
        mainPanel = new JPanel(new BorderLayout());
        headerPanel = new JPanel();
        loginPanel = new JPanel();
        buttonPanel = new JPanel();
        
        // Labels
        lblTitle = new JLabel("College Management System", JLabel.CENTER);
        lblWelcome = new JLabel("Please select your role and login", JLabel.CENTER);
        lblUsername = new JLabel("Username:");
        lblPassword = new JLabel("Password:");
        
        // Input fields
        txtUsername = new JTextField(20);
        txtPassword = new JPasswordField(20);
        
        // Buttons
        btnAdmin = new JButton("Admin Login");
        btnEmployee = new JButton("Employee Login");
        btnStudent = new JButton("Student Login");
        btnExit = new JButton("Exit");
    }
    
    private void setupLayout() {
        // Header panel
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.setBorder(new EmptyBorder(30, 20, 20, 20));
        headerPanel.add(lblTitle);
        headerPanel.add(Box.createVerticalStrut(10));
        headerPanel.add(lblWelcome);
        
        // Login panel with GridBagLayout for better control
        loginPanel.setLayout(new GridBagLayout());
        loginPanel.setBorder(new CompoundBorder(
            new TitledBorder(BorderFactory.createLineBorder(PRIMARY_COLOR, 2), 
                           "Login Credentials", 
                           TitledBorder.CENTER, 
                           TitledBorder.TOP,
                           new Font("Arial", Font.BOLD, 14),
                           PRIMARY_COLOR),
            new EmptyBorder(20, 30, 20, 30)
        ));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        
        // Username row
        gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.EAST;
        loginPanel.add(lblUsername, gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        loginPanel.add(txtUsername, gbc);
        
        // Password row
        gbc.gridx = 0; gbc.gridy = 1; gbc.fill = GridBagConstraints.NONE; gbc.anchor = GridBagConstraints.EAST;
        loginPanel.add(lblPassword, gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        loginPanel.add(txtPassword, gbc);
        
        // Button panel
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 20));
        buttonPanel.setBorder(new EmptyBorder(20, 20, 30, 20));
        buttonPanel.add(btnAdmin);
        buttonPanel.add(btnEmployee);
        buttonPanel.add(btnStudent);
        buttonPanel.add(btnExit);
        
        // Main panel assembly
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(loginPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        add(mainPanel);
    }
    
    private void setupStyling() {
        // Main panel styling
        mainPanel.setBackground(BACKGROUND_COLOR);
        headerPanel.setBackground(BACKGROUND_COLOR);
        loginPanel.setBackground(WHITE);
        buttonPanel.setBackground(BACKGROUND_COLOR);
        
        // Title styling
        lblTitle.setFont(new Font("Arial", Font.BOLD, 28));
        lblTitle.setForeground(PRIMARY_COLOR);
        
        lblWelcome.setFont(new Font("Arial", Font.PLAIN, 16));
        lblWelcome.setForeground(TEXT_COLOR);
        
        // Label styling
        Font labelFont = new Font("Arial", Font.BOLD, 14);
        lblUsername.setFont(labelFont);
        lblUsername.setForeground(TEXT_COLOR);
        lblPassword.setFont(labelFont);
        lblPassword.setForeground(TEXT_COLOR);
        
        // Input field styling
        Font inputFont = new Font("Arial", Font.PLAIN, 14);
        txtUsername.setFont(inputFont);
        txtUsername.setBorder(new CompoundBorder(
            new LineBorder(PRIMARY_COLOR, 1),
            new EmptyBorder(8, 10, 8, 10)
        ));
        txtUsername.setPreferredSize(new Dimension(200, 35));
        
        txtPassword.setFont(inputFont);
        txtPassword.setBorder(new CompoundBorder(
            new LineBorder(PRIMARY_COLOR, 1),
            new EmptyBorder(8, 10, 8, 10)
        ));
        txtPassword.setPreferredSize(new Dimension(200, 35));
        
        // Button styling
        styleButton(btnAdmin, PRIMARY_COLOR);
        styleButton(btnEmployee, ACCENT_COLOR);
        styleButton(btnStudent, new Color(155, 89, 182));
        styleButton(btnExit, new Color(231, 76, 60));
        
        // Add hover effects
        addHoverEffect(btnAdmin, PRIMARY_COLOR);
        addHoverEffect(btnEmployee, ACCENT_COLOR);
        addHoverEffect(btnStudent, new Color(155, 89, 182));
        addHoverEffect(btnExit, new Color(231, 76, 60));
    }
    
    private void styleButton(JButton button, Color color) {
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(color);
        button.setForeground(WHITE);
        button.setBorder(new EmptyBorder(12, 20, 12, 20));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setPreferredSize(new Dimension(140, 45));
    }
    
    private void addHoverEffect(JButton button, Color originalColor) {
        Color hoverColor = originalColor.darker();
        
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(hoverColor);
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(originalColor);
            }
        });
    }
    
    private void setupEventHandlers() {
        btnAdmin.addActionListener(this);
        btnEmployee.addActionListener(this);
        btnStudent.addActionListener(this);
        btnExit.addActionListener(this);
        
        // Add Enter key support
        KeyAdapter enterKeyListener = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    // Default to student login on Enter
                    performLogin("student");
                }
            }
        };
        
        txtUsername.addKeyListener(enterKeyListener);
        txtPassword.addKeyListener(enterKeyListener);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnAdmin) {
            performLogin("admin");
        } else if (ae.getSource() == btnEmployee) {
            performLogin("employee");
        } else if (ae.getSource() == btnStudent) {
            performLogin("student");
        } else if (ae.getSource() == btnExit) {
            int choice = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to exit?",
                "Confirm Exit",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
            );
            if (choice == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }
    
    private void performLogin(String userType) {
        String username = txtUsername.getText().trim();
        String password = new String(txtPassword.getPassword());
        
        // Input validation
        if (username.isEmpty() || password.isEmpty()) {
            showErrorMessage("Please enter both username and password.");
            return;
        }
        
        // Show loading cursor
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        
        try {
            boolean loginSuccessful = authenticateUser(username, password, userType);
            
            if (loginSuccessful) {
                showSuccessMessage("Login successful! Welcome " + username);
                setVisible(false);
                
                // Open appropriate home screen
                switch (userType) {
                    case "admin":
                        new AdminHome();
                        break;
                    case "employee":
                        new EmployeeHome(username);
                        break;
                    case "student":
                        // Store username for student session
                        storeStudentSession(username, password);
                        new StudentHome(username);
                        break;
                }
            } else {
                showErrorMessage("Invalid username or password for " + userType + " login.");
                clearFields();
            }
        } catch (Exception e) {
            showErrorMessage("Database connection error. Please try again later.");
            e.printStackTrace();
        } finally {
            setCursor(Cursor.getDefaultCursor());
        }
    }
    
    private boolean authenticateUser(String username, String password, String userType) throws SQLException {
        String tableName;
        switch (userType) {
            case "admin":
                tableName = "login";
                break;
            case "employee":
                tableName = "teacher";
                break;
            case "student":
                tableName = "student";
                break;
            default:
                return false;
        }
        
        // Use prepared statement to prevent SQL injection
        String query = "SELECT * FROM " + tableName + " WHERE Username = ? AND Password = ?";
        
        Conn c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            c = new Conn();
            ps = c.c.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            
            return rs.next();
        } finally {
            // Clean up resources
            if (rs != null) {
                try { rs.close(); } catch (SQLException e) { /* ignore */ }
            }
            if (ps != null) {
                try { ps.close(); } catch (SQLException e) { /* ignore */ }
            }
            // Note: Connection cleanup depends on your Conn class implementation
        }
    }
    
    private void storeStudentSession(String username, String password) {
        Conn c = null;
        PreparedStatement ps = null;
        
        try {
            c = new Conn();
            ps = c.c.prepareStatement("INSERT INTO username (UNM, PASS) VALUES (?, ?)");
            ps.setString(1, username);
            ps.setString(2, password);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error storing student session: " + e.getMessage());
        } finally {
            // Clean up resources
            if (ps != null) {
                try { ps.close(); } catch (SQLException e) { /* ignore */ }
            }
            // Note: Connection cleanup depends on your Conn class implementation
        }
    }
    
    private void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(
            this,
            message,
            "Login Error",
            JOptionPane.ERROR_MESSAGE
        );
    }
    
    private void showSuccessMessage(String message) {
        JOptionPane.showMessageDialog(
            this,
            message,
            "Login Successful",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
    
    private void clearFields() {
        txtUsername.setText("");
        txtPassword.setText("");
        txtUsername.requestFocus();
    }
    
    public static void main(String[] args) {
        // Set system look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Run on EDT
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LoginMain();
            }
        });
    }
}
