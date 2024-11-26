package Bamking;
import java.sql.PreparedStatement;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.sql.*;

public class Signup extends JFrame implements ActionListener {
   
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l0;
    JTextField t1, t2, t3, t4, t6, t7, t8;
    JButton button1;
    JRadioButton male, female, MR, mrs;
    JDateChooser dateChooser;
Long random;
    Signup() {
        setSize(800, 800);
        setTitle("Banking System");
        Random ram = new Random();
        random = Math.abs(ram.nextLong() % 9000L + 1000L);

        l1 = new JLabel("APPLICATION FORM NO:" + random);
        l1.setBounds(140, 20, 600, 40);
        l1.setFont(new Font("Osward", Font.BOLD, 38));
        add(l1);

        l2 = new JLabel("Page 1: Personal Details");
        l2.setBounds(140, 70, 600, 40);
        l2.setFont(new Font("Osward", Font.BOLD, 24));
        add(l2);

        l3 = new JLabel("Name:");
        l3.setBounds(100, 140, 100, 30);
        l3.setFont(new Font("Osward", Font.BOLD, 20));
        add(l3);

        t1 = new JTextField();
        t1.setBounds(300, 140, 400, 30);
        t1.setFont(new Font("Arial", Font.BOLD, 15));
        add(t1);

        l4 = new JLabel("Father Name:");
        l4.setBounds(100, 180, 140, 30);
        l4.setFont(new Font("Osward", Font.BOLD, 20));
        add(l4);

        t2 = new JTextField();
        t2.setBounds(300, 180, 400, 30);
        t2.setFont(new Font("Arial", Font.BOLD, 15));
        add(t2);

        l5 = new JLabel("DOB:");
        l5.setBounds(100, 220, 100, 30);
        l5.setFont(new Font("Osward", Font.BOLD, 20));
        add(l5);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 220, 400, 30);
        add(dateChooser);

        l6 = new JLabel("Gender:");
        l6.setBounds(100, 260, 100, 30);
        l6.setFont(new Font("Osward", Font.BOLD, 20));
        add(l6);

        male = new JRadioButton("Male");
        male.setBounds(300, 260, 60, 30);
        male.setBackground(Color.white);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(370, 260, 80, 30);
        female.setBackground(Color.white);
        add(female);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        l7 = new JLabel("Address:");
        l7.setBounds(100, 300, 100, 30);
        l7.setFont(new Font("Osward", Font.BOLD, 20));
        add(l7);

        t3 = new JTextField();
        t3.setBounds(300, 300, 400, 30);
        t3.setFont(new Font("Arial", Font.BOLD, 15));
        add(t3);

        l8 = new JLabel("Email:");
        l8.setBounds(100, 340, 100, 30);
        l8.setFont(new Font("Osward", Font.BOLD, 20));
        add(l8);

        t4 = new JTextField();
        t4.setBounds(300, 340, 400, 30);
        t4.setFont(new Font("Arial", Font.BOLD, 15));
        add(t4);

        l9 = new JLabel("Marital Status:");
        l9.setBounds(100, 380, 140, 30);
        l9.setFont(new Font("Osward", Font.BOLD, 15));
        add(l9);

        MR = new JRadioButton("Married");
        MR.setBounds(300, 380, 90, 30);
        MR.setBackground(Color.white);
        add(MR);

        mrs = new JRadioButton("Unmarried");
        mrs.setBounds(420, 380, 100, 30);
        mrs.setBackground(Color.white);
        add(mrs);

        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(MR);
        maritalGroup.add(mrs);

        l0 = new JLabel("City:");
        l0.setBounds(100, 420, 100, 30);
        l0.setFont(new Font("Osward", Font.BOLD, 20));
        add(l0);

        t6 = new JTextField();
        t6.setBounds(300, 420, 400, 30);
        t6.setFont(new Font("Arial", Font.BOLD, 15));
        add(t6);

        JLabel l10 = new JLabel("Status:");
        l10.setBounds(100, 460, 100, 30);
        l10.setFont(new Font("Osward", Font.BOLD, 20));
        add(l10);

        t7 = new JTextField();
        t7.setBounds(300, 460, 400, 30);
        t7.setFont(new Font("Arial", Font.BOLD, 15));
        add(t7);

        JLabel l11 = new JLabel("Pincode:");
        l11.setBounds(100, 500, 100, 30);
        l11.setFont(new Font("Osward", Font.BOLD, 20));
        add(l11);

        t8 = new JTextField();
        t8.setBounds(300, 500, 400, 30);
        t8.setFont(new Font("Arial", Font.BOLD, 15));
        add(t8);

        button1 = new JButton("Next");
        button1.setBackground(Color.BLACK);
        button1.setForeground(Color.WHITE);
        button1.setFont(new Font("Raleway", Font.BOLD, 14));
        button1.setBounds(620, 560, 80, 30);
        button1.addActionListener(this);
        add(button1);

        setLocation(350, 10);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
        	String application_form_no=""+random;
            String name = t1.getText();
            String father_name = t2.getText();
            Date dob = dateChooser.getDate();
            String dobStr = dob != null ? new SimpleDateFormat("yyyy-MM-dd").format(dob) :null;
            String gender = male.isSelected() ? "Male" : female.isSelected() ? "Female" : null;
            String address = t3.getText();
            String email = t4.getText();
            String marital_status = MR.isSelected() ? "Married" : mrs.isSelected() ? "Unmarried" : "";
            String city = t6.getText();
            String status = t7.getText();
            String pincode = t8.getText();

            // Database insertion
           
           
                    try {
                        Conn c = new Conn();
                        String sql = "INSERT INTO user_details (application_form_no, name, father_name, dob, gender, address, email, marital_status, city, status, pincode) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                        PreparedStatement pstmt = c.c.prepareStatement(sql);
                        pstmt.setString(1, application_form_no);
                        pstmt.setString(2, name);
                        pstmt.setString(3, father_name);
                        pstmt.setString(4, dobStr);
                        pstmt.setString(5, gender);
                        pstmt.setString(6, address);
                        pstmt.setString(7, email);
                        pstmt.setString(8, marital_status);
                        pstmt.setString(9, city);
                        pstmt.setString(10, status);
                        pstmt.setString(11, pincode);

                        pstmt.executeUpdate();
                        JOptionPane.showMessageDialog(this, "Data successfully saved!");
                        setVisible(false);
                        new sign_up2(application_form_no).setVisible(true);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(this, "Error saving data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

                
   

    public static void main(String[] args) {
        new Signup();
    }
}
