package Bamking;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.*;
public class Login extends JFrame implements ActionListener {
JButton btn,btn1,btn2;
JTextField t1;
JPasswordField pass;

    Login() {
        this.setSize(600, 600);
        this.setTitle("Bank System");

        // Load image using getClass().getResource
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/icons/1.png"));
      Image i2=imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
      ImageIcon i3=new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(30,30,100,100);
        add(label);
        
        JLabel label1 = new JLabel("Welcome to ATM");
        label1.setFont(new Font("Osward",Font.BOLD, 38));
        label1.setBounds(200,40,400,40);
        add(label1);
        
        JLabel label2 = new JLabel("Card No:");
        label2.setFont(new Font("Osward",Font.BOLD, 28));
        label2.setBounds(120,150,150,40);
        add(label2);

        t1=new JTextField();
        t1.setBounds(300,150,230,30);
        t1.setFont(new Font("Arial",Font.BOLD,14));
        add(t1);
        
        JLabel label3 = new JLabel("PIN :");
        label3.setFont(new Font("Osward",Font.BOLD, 28));
        label3.setBounds(120,220,250,40);
        add(label3);
        
         pass=new JPasswordField();
        pass.setBounds(300,220,230,30);
        pass.setFont(new Font("Arial",Font.BOLD,14));
        add(pass);
        
         btn=new JButton("SIGN_IN");
        btn.setBounds(300,300,100,30);
        btn.setBackground(Color.BLACK);
        btn.setForeground(Color.WHITE);
        btn.addActionListener(this);
        add(btn);
        
         btn1=new JButton("CLEAR");
        btn1.setBounds(420,300,100,30);
        btn1.setBackground(Color.BLACK);
        btn1.setForeground(Color.WHITE);
        btn1.addActionListener(this);
        add(btn1);
        
        btn2=new JButton("Sign_up");
        btn2.setBounds(300,350,100,30);
        btn2.setBackground(Color.BLACK);
        btn2.setForeground(Color.WHITE);
        btn2.addActionListener(this);
        add(btn2);
        getContentPane().setBackground(Color.WHITE);
        this.setLayout(null);
        this.setVisible(true);
        this.setLocation(350,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            t1.setText("");
            pass.setText("");
        } else if (e.getSource() == btn) {
            Conn conn = new Conn();
            String card = t1.getText().trim(); // Get card number from t1
            String pin = pass.getText().trim();

            // Clean up the SQL query
            String query = "SELECT * FROM login WHERE card = '" + card + "' AND pin = '" + pin + "'";
            
            try {
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Transaction(pin).setVisible(true); // Ensure Transaction class is implemented
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            } catch (Exception ae) {
                JOptionPane.showMessageDialog(null, "Error: " + ae.getMessage());
            }
        } else if (e.getSource() == btn2) {
            setVisible(false);
            new Signup().setVisible(true); // Ensure Signup class is implemented
        }
    }

public static void main(String args[]){
	 new Login();
}
}
