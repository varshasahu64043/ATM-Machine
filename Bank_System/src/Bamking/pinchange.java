package Bamking;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.PreparedStatement;

import javax.swing.*;
public class pinchange extends JFrame implements ActionListener {
	String pin;
	JButton change,back;
	JTextField pin1,pin2;
	pinchange(String pin){
this.pin=pin;
		
		
		ImageIcon i1=new ImageIcon(getClass().getResource("/icons/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(700, 900, Image.SCALE_DEFAULT);
	    ImageIcon i3=new ImageIcon(i2);
	    JLabel image=new JLabel(i3);
	    image.setBounds(0,0,700,900);
	    add(image);
	    JLabel text=new JLabel("CHANGE YOUR PIN");
		text. setBounds(240,210,700,35);
		text.setForeground(Color.white);
		text.setFont(new Font("System", Font.BOLD, 16)); 
		image.add(text);
		
		   JLabel pintext=new JLabel("NEW PIN:");
			pintext. setBounds(220,320,150,35);
			pintext.setForeground(Color.white);
			pintext.setFont(new Font("System", Font.BOLD, 16)); 
			image.add(pintext);
			
			pin1=new JTextField();
			pin1.setFont(new Font("System", Font.BOLD, 16)); 
			pin1. setBounds(350,320,150,25);
			image.add(pin1);
			
			  JLabel repintext=new JLabel("Re-Enter PIN:");
				repintext. setBounds(220,360,150,35);
				repintext.setForeground(Color.white);
				repintext.setFont(new Font("System", Font.BOLD, 16)); 
				image.add(repintext);
				
				 pin2=new JTextField();
				pin2.setFont(new Font("System", Font.BOLD, 16)); 
				pin2. setBounds(350,360,150,25);
				image.add(pin2);
				
				 change=new JButton("Change");
					change.setBounds(355,400,130,30);
					change.setFont(new Font("System", Font.BOLD, 16)); 
					change.addActionListener(this);
					image.add(change);
					
					 back=new JButton("Back");
					back.setBounds(355,440,130,30);
					back.setFont(new Font("System", Font.BOLD, 16)); 
					back.addActionListener(this);
					image.add(back);
					
	    setSize(900,900);
		setLocation(300,0);
		setVisible(true);
		setUndecorated(true);
	    setLayout(null);
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==change){
			try{
		String npin=pin1.getText();
		String rpin=pin2.getText();

        if (!npin.equals(rpin)) {
            JOptionPane.showMessageDialog(null, "PINs do not match. Please re-enter.");
            return;
        }
        if (npin.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter the new PIN.");
            return;
        }
        if (rpin.equals("")) {
            JOptionPane.showMessageDialog(null, "Please re-enter the new PIN.");
            return;
        }

		 Conn conn = new Conn();
         String query = "UPDATE deposite SET pin=? WHERE pin=?";
         String query1 = "UPDATE login SET pin=? WHERE pin=?";
         String query2 = "UPDATE signup3 SET pin=? WHERE pin=?";

         // Using prepared statements to prevent SQL injection
         PreparedStatement pst1 = conn.c.prepareStatement(query);
         pst1.setString(1, rpin);
         pst1.setString(2, npin);
         pst1.executeUpdate();

         PreparedStatement pst2 = conn.c.prepareStatement(query1);
         pst2.setString(1, rpin);
         pst2.setString(2, npin);
         pst2.executeUpdate();
         PreparedStatement pst3 = conn.c.prepareStatement(query2);
         pst3.setString(1, rpin);
         pst3.setString(2, npin);
         pst3.executeUpdate();
		
		
		 JOptionPane.showMessageDialog(null, "pinchange sucessfully:");
		setVisible(false);
		new Transaction(rpin).setVisible(true);

		
		}
	catch(Exception ae){
		System.out.print(ae);
	}
	
	}else{
		setVisible(false);
		new Transaction(pin).setVisible(true);
	}
	}
	public static void main(String args[]){
		new pinchange("");
	}
}
