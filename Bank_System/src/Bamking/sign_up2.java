package Bamking;

import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.sql.*;

public class sign_up2 extends JFrame implements ActionListener {
	long random;
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l0;
	JTextField t1, t2, t3, t4, t6, t7, t8;
	JButton button1;
	JRadioButton yes, no, syes, sno;
	JDateChooser dateChooser;
	JComboBox religion, cat, in, Q, P;
static String application_form_no;
	sign_up2(String application_form_no)
	{
		
		setSize(800, 800);
		setTitle("New Account Application System");
		Random ram = new Random();
		random = Math.abs(ram.nextLong() % 9000L + 1000L);

		l2 = new JLabel("Page 2: Additional Details");
		l2.setBounds(140, 70, 600, 40);
		l2.setFont(new Font("Osward", Font.BOLD, 24));
		add(l2);

		l3 = new JLabel("Religion:");
		l3.setBounds(100, 140, 100, 30);
		l3.setFont(new Font("Osward", Font.BOLD, 20));
		add(l3);
		String valreligion[] = { "Hindu", "Muslim", "Sikh", "Christan", "Other" };
		religion = new JComboBox(valreligion);
		religion.setBounds(300, 140, 400, 30);
		religion.setBackground(Color.WHITE);
		add(religion);
		l4 = new JLabel("Category:");
		l4.setBounds(100, 180, 140, 30);
		l4.setFont(new Font("Osward", Font.BOLD, 20));
		add(l4);
		String category[] = { "Genral", "SC", "OBC", "ST", "Other" };
		cat = new JComboBox(category);
		cat.setBounds(300, 180, 400, 30);
		cat.setBackground(Color.WHITE);
		add(cat);

		l5 = new JLabel("Income:");
		l5.setBounds(100, 220, 100, 30);
		l5.setFont(new Font("Osward", Font.BOLD, 20));
		add(l5);
		String income[] = { "Null", "<1,50,000", "<2,50,000", "<50000", "<upto10,00,000" };
		in = new JComboBox(income);
		in.setBounds(300, 220, 400, 30);
		in.setBackground(Color.WHITE);
		add(in);

		l6 = new JLabel("Education Quali:");
		l6.setBounds(100, 260, 320, 30);
		l6.setFont(new Font("Osward", Font.BOLD, 20));
		add(l6);
		String edu[] = { "Non-Graduation", "Graduated", "Post-Graduated", "Doctrate", "<other" };
		Q = new JComboBox(edu);
		Q.setBounds(300, 260, 400, 30);
		Q.setBackground(Color.WHITE);
		add(Q);

		l8 = new JLabel("Occuption:");
		l8.setBounds(100, 340, 100, 30);
		l8.setFont(new Font("Osward", Font.BOLD, 20));
		add(l8);

		String Occ[] = { "Salaried", "SelfEmployeed", "Businessman", "Student", "<other" };
		P = new JComboBox(Occ);
		P.setBounds(300, 340, 400, 30);
		P.setBackground(Color.WHITE);
		add(P);

		l0 = new JLabel("Pan No:");
		l0.setBounds(100, 380, 100, 30);
		l0.setFont(new Font("Osward", Font.BOLD, 20));
		add(l0);

		t6 = new JTextField();
		t6.setBounds(300, 380, 400, 30);
		t6.setFont(new Font("Arial", Font.BOLD, 15));
		add(t6);

		JLabel l10 = new JLabel("Adhar No:");
		l10.setBounds(100, 420, 100, 30);
		l10.setFont(new Font("Osward", Font.BOLD, 20));
		add(l10);

		t7 = new JTextField();
		t7.setBounds(300, 420, 400, 30);
		t7.setFont(new Font("Arial", Font.BOLD, 15));
		add(t7);

		JLabel l11 = new JLabel("Senior Citizen:");
		l11.setBounds(100, 460, 140, 30);
		l11.setFont(new Font("Osward", Font.BOLD, 20));
		add(l11);

		yes = new JRadioButton("Yes");
		yes.setBounds(300, 460, 90, 30);
		yes.setBackground(Color.BLACK);
		yes.setForeground(Color.WHITE);
		add(yes);

		no = new JRadioButton("No");
		no.setBounds(400, 460, 90, 30);
		no.setBackground(Color.BLACK);
		no.setForeground(Color.WHITE);
		add(no);

		ButtonGroup grp = new ButtonGroup();
		grp.add(yes);
		grp.add(no);

		JLabel l1 = new JLabel("Existing Acoount:");
		l1.setBounds(100, 500, 140, 30);
		l1.setFont(new Font("Osward", Font.BOLD, 20));
		add(l1);
		syes = new JRadioButton("Yes");
		syes.setBounds(300, 500, 90, 30);
		syes.setBackground(Color.BLACK);
		syes.setForeground(Color.WHITE);
		add(syes);

		sno = new JRadioButton("No");
		sno.setBounds(400, 500, 90, 30);
		sno.setBackground(Color.BLACK);
		sno.setForeground(Color.WHITE);
		add(sno);

		ButtonGroup group = new ButtonGroup();
		group.add(syes);
		group.add(sno);

		button1 = new JButton("Next");
		button1.setBackground(Color.BLACK);
		button1.setForeground(Color.WHITE);
		button1.setFont(new Font("Raleway", Font.BOLD, 14));
		button1.setBounds(620, 600, 80, 30);
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
//            String name = t1.getText();
        	String application_form_no=""+random;
            String sreligion = (String)religion.getSelectedItem();
            String category  = (String)cat.getSelectedItem();
            String income = (String)in.getSelectedItem();
            String education  = (String)Q.getSelectedItem();
            String occuption  = (String)P.getSelectedItem();
            
            String pan = t6.getText();
            String adhar = t7.getText();
            String seniorcitizen = yes.isSelected() ? "Yes" : no.isSelected() ? "No" : "";
            String exitingaccount = syes.isSelected() ? "Yes" : sno.isSelected() ? "No" : "";
            


            // Database insertion
            Conn c = new Conn();
            String sql = "INSERT INTO signup2 (application_form_no, sreligion, category, income, education, occupation, pan, adhar, seniorcitizen, exitingaccount) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            try (PreparedStatement pstmt = c.c.prepareStatement(sql)) {
              pstmt.setString(1, application_form_no);
                pstmt.setString(2,sreligion );
                pstmt.setString(3,category );
                pstmt.setString(4, income);
                pstmt.setString(5, education);
                pstmt.setString(6, occuption);
                pstmt.setString(7, pan);
                pstmt.setString(8, adhar);
                pstmt.setString(9, seniorcitizen);
                pstmt.setString(10, exitingaccount);
                
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "Data successfully saved!");
                setVisible(false);
                new signup3(application_form_no).setVisible(true);
            }
            
            
        	catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error saving data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

	public static void main(String[] args) {
		new sign_up2(application_form_no);
	}
}
