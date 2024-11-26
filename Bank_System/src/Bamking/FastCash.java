package Bamking;
import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.*;
public class FastCash extends JFrame implements ActionListener {
JButton deposite,btn1,btn2,btn3,btn4,btn5,btn6;
String pin;

FastCash(String pin){
		this.pin=pin;
	ImageIcon i1=new ImageIcon(getClass().getResource("/icons/atm.jpg"));
	Image i2=i1.getImage().getScaledInstance(700, 900, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image=new JLabel(i3);
    image.setBounds(0,0,700,900);
    add(image);
		
		JLabel text=new JLabel("Enter  amount you withdraw");
		text. setBounds(220,210,700,35);
		text.setForeground(Color.white);
		text.setFont(new Font("System", Font.BOLD, 16)); 
		image.add(text);
		    
		deposite=new JButton("Rs100");
		deposite.setBounds(210,280,120,30);
		deposite.addActionListener(this);
		image.add(deposite);
		
		btn1=new JButton("Rs500");
		btn1.setBounds(350,280,120,30);
		btn1.addActionListener(this);
	    image.add(btn1);
		
		btn2=new JButton("Rs1000");
		btn2.setBounds(210,330,120,30);
		btn2.addActionListener(this);
		image.add(btn2);
		
		btn3=new JButton("Rs5000");
		btn3.setBounds(350,330,120,30);
		btn3.addActionListener(this);
		image.add(btn3);
		
		btn4=new JButton("Rs10000");
		btn4.setBounds(210,380,120,30);
		image.add(btn4);

		btn5=new JButton("Rs15000");
		btn5.setBounds(350,380,120,30);
		btn5.addActionListener(this);
		image.add(btn5);

		btn6=new JButton("back");
		btn6.setBounds(210,420,120,30);
		btn6.addActionListener(this);
		image.add(btn6);
		
	setSize(900,900);
	setLocation(300,0);
	setVisible(true);
	setUndecorated(true);
    setLayout(null);
	
}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==btn6){
			setVisible(false);
			new Transaction(pin).setVisible(true);
		}else {	
			String amount=((JButton)e.getSource()).getText().substring(2);
		Conn conn=new Conn();
		try{
			
			ResultSet rs=conn.s.executeQuery("select * from deposite where pin=' "+pin+" ' ");
			int balance=0;
			while(rs.next()){
				if(rs.getString(amount).equals("Deposite"));{
				balance +=Integer.parseInt(rs.getString("amount"));
				
			}
			}
			if(e.getSource()!= btn6 && balance<Integer.parseInt(amount)){
				JOptionPane.showMessageDialog(null, "insufficent amount");
			}
			 Date data = new Date();
			 String query = "INSERT INTO deposite (pin, data,  amount) VALUES (?, ?, ?)";
             PreparedStatement pstmt = conn.c.prepareStatement(query);
             pstmt.setString(1, pin);
             pstmt.setDate(2, new java.sql.Date(data.getTime())); // Use java.sql.Date for SQL
            
             pstmt.setString(3, amount);

             pstmt.executeUpdate();
             JOptionPane.showMessageDialog(null, "Rs " + amount + " deposited successfully");

		}catch(Exception ae){
			System.out.print(ae);
		
		}
	}
	
	}
	
	
	
	public static void main(String args[]){
		new FastCash("");
	}
}
