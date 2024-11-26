package Bamking;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.PreparedStatement;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Deposite extends JFrame implements ActionListener{
JButton deposit,btn2;
String pin;
JTextField amount;
	Deposite(String pin){
		this.pin=pin;
		ImageIcon i1=new ImageIcon(getClass().getResource("/icons/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
	    ImageIcon i3=new ImageIcon(i2);
	    JLabel image=new JLabel(i3);
	    image.setBounds(0,0,900,900);
	    add(image);

		JLabel text=new JLabel("Enter the amount");
		text. setBounds(170,300,700,35);
		text.setForeground(Color.white);
		text.setFont(new Font("System", Font.BOLD, 16)); 
		image.add(text);
		
		 amount=new JTextField();
		amount.setBounds(170,350,320,40);
		amount.setFont(new Font("System", Font.BOLD, 16)); 
		image.add(amount);
		
		 deposit=new JButton("Deposite");
		deposit.setBounds(355,400,150,30);
		deposit.setFont(new Font("System", Font.BOLD, 16)); 
		deposit.addActionListener(this);
		image.add(deposit);
		
		 btn2=new JButton("Back");
		btn2.setBounds(355,440,150,30);
		btn2.setFont(new Font("System", Font.BOLD, 16)); 
		btn2.addActionListener(this);
		image.add(btn2);
		
		
		
	    setSize(900,900);
		setLocation(300,0);
		setVisible(true);
		setUndecorated(true);
	    setLayout(null);
		
	}
	public void actionPerformed(ActionEvent e) {
	    if (e.getSource() == deposit) {
	        String number = amount.getText();
	        Date data = new Date();
	        
	        if (number.equals("")) {
	            JOptionPane.showMessageDialog(null, "Please enter your amount:");
	        } else {
	            try {
	                Conn conn = new Conn();
	         
	                String query = "INSERT INTO deposite (pin, data,  amount) VALUES (?, ?, ?)";
	                PreparedStatement pstmt = conn.c.prepareStatement(query);
	                pstmt.setString(1, pin);
	                pstmt.setDate(2, new java.sql.Date(data.getTime())); // Use java.sql.Date for SQL
	               
	                pstmt.setString(3, number);

	                pstmt.executeUpdate();
	                JOptionPane.showMessageDialog(null, "Rs " + number + " deposited successfully");
	                setVisible(false);
	                new Transaction(pin).setVisible(true);
	            } catch (Exception ae) {
	                System.out.println(ae);
	            }
	        }
	    } else if (e.getSource() == btn2) {
	        setVisible(false);
	        new Transaction(pin).setVisible(true);
	    }
	}

	
	
	public static void main(String args[]){
		new Deposite("");
	}
}
