package Bamking;
import java.util.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.sql.PreparedStatement;

public class signup3 extends JFrame  implements ActionListener{
JButton b1,b2;
	JLabel l1, type, l3, l4, card, no,ne,pin,cd,cm,serv;
	JRadioButton r1, r2, r3, r4;
JCheckBox c1,c2,c3,c4,c5,c6,c7;
String application_form_no;

	signup3( String application_form_no) {
this.application_form_no=application_form_no;
		
		setSize(850, 820);
		setTitle("Bank Form");
		l1 = new JLabel("Page 3:Account Details");
		l1.setFont(new Font("Raleway", Font.BOLD, 22));
		l1.setBounds(280, 40, 400, 40);
		add(l1);

		type = new JLabel("Account type:");
		type.setFont(new Font("Raleway", Font.BOLD, 22));
		type.setBounds(100, 140, 200, 40);
		add(type);

		r1 = new JRadioButton("Saving Account");
		r1.setBounds(100, 180, 250, 30);
		r1.setFont(new Font("Raleway", Font.BOLD, 16));
		r1.setBackground(Color.white);
		add(r1);

		r2 = new JRadioButton("Current Account");
		r2.setBounds(350, 180, 250, 30);
		r2.setFont(new Font("Raleway", Font.BOLD, 16));
		r2.setBackground(Color.white);
		add(r2);

		r3 = new JRadioButton("FDC Account");
		r3.setBounds(100, 220, 250, 30);
		r2.setFont(new Font("Raleway", Font.BOLD, 16));
		r3.setBackground(Color.white);
		add(r3);

		r4 = new JRadioButton("Recurrent");
		r4.setBounds(350, 220, 250, 30);
		r4.setFont(new Font("Raleway", Font.BOLD, 16));
		r4.setBackground(Color.white);
		add(r4);

		ButtonGroup maritalGroup = new ButtonGroup();
		maritalGroup.add(r1);
		maritalGroup.add(r2);
		maritalGroup.add(r3);
		maritalGroup.add(r4);

		card = new JLabel("Card Number:");
		card.setFont(new Font("Raleway", Font.BOLD, 22));
		card.setBounds(100, 280, 200, 40);
		add(card);

		no = new JLabel("XXXX-XXXXX-XXXX-4184");
		no.setFont(new Font("Raleway", Font.BOLD, 22));
		no.setBounds(350, 280, 280, 40);
		add(no);

		cd = new JLabel("Your 16 Digit Card_Details:");
		cd.setFont(new Font("Raleway", Font.BOLD, 12));
		cd.setBounds(100, 310, 300, 20);
		add(cd);
		pin = new JLabel("PIN Number:");
		pin.setFont(new Font("Raleway", Font.BOLD, 22));
		pin.setBounds(100, 370, 200, 40);
		add(pin);

		ne = new JLabel("XXXX");
		ne.setFont(new Font("Raleway", Font.BOLD, 22));
		ne.setBounds(350, 370, 280, 40);
		add(ne);
		cm = new JLabel("Your 16 Digit Card_Details:");
		cm.setFont(new Font("Raleway", Font.BOLD, 12));
		cm.setBounds(100, 400, 300, 20);
		add(cm);
		serv = new JLabel("Service Required:");
		serv.setFont(new Font("Raleway", Font.BOLD, 22));
		serv.setBounds(100, 440, 200, 40);
		add(serv);

         c1=new JCheckBox("ATM CARD");
         c1.setBackground(Color.WHITE);
         c1.setFont(new Font("Raleway",Font.BOLD,16));
         c1.setBounds(100,500,200,30);
		add(c1);
         c2=new JCheckBox("Net Banking");
         c2.setBackground(Color.WHITE);
         c2.setFont(new Font("Raleway",Font.BOLD,16));
         c2.setBounds(400,500,200,30);
		add(c2);
         c3=new JCheckBox("Email & SMS Alerts");
         c3.setBackground(Color.WHITE);
         c3.setFont(new Font("Raleway",Font.BOLD,16));
         c3.setBounds(100,550,200,30);
		add(c3);
         c4=new JCheckBox("Mobile Banking");
         c4.setBackground(Color.WHITE);
         c4.setFont(new Font("Raleway",Font.BOLD,16));
         c4.setBounds(400,550,200,30);
		add(c4);
         c5=new JCheckBox("CheckBook");
         c5.setBackground(Color.WHITE);
         c5.setFont(new Font("Raleway",Font.BOLD,16));
         c5.setBounds(100,600,200,30);
		add(c5);
         c6=new JCheckBox("E Statement");
         c6.setBackground(Color.WHITE);
         c6.setFont(new Font("Raleway",Font.BOLD,16));
         c6.setBounds(400,600,200,30);
		add(c6);
         
		b1=new JButton("Cancel");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.RED);
		b1.setBounds(250,650,100,30);
		b1.addActionListener(this);
		add(b1);
		
		b2=new JButton("OK");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.GREEN);
		b2.setBounds(450,650,100,30);
		b2.addActionListener(this);
		add(b2);

		setLocation(350, 10);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==b2){
			String accounttype=null;
			if(r1.isSelected()){
				accounttype="Saving Account";
			}
			else if(r2.isSelected()){
				accounttype="FDC Account";
			}else if(r3.isSelected()){
				accounttype="Current Account";
			}else if(r4.isSelected()){
				accounttype="Recurrent Deposite Accont";
			}
			
			Random random=new Random();
			String no= ""+ Math.abs((random.nextLong() %90000000L)+50409396000000L);
			
			String ne=""+ Math.abs((random.nextLong() %90000000L)+1000L);

			String facility="";
			if(c1.isSelected()){
				facility =facility+ "ATM Card";
			}
			else if(c2.isSelected())
			{
				facility =facility+ "Internet Banking";
			}
			else if(c3.isSelected())
			{
				facility =facility+ "Email & SMS ";
			}
			else if(c4.isSelected())
			
			{
				facility =facility+ "Mobile Banking";
			}
				else if(c5.isSelected())
				{
					facility =facility+ "CheckBook";
				}
					else if(c6.isSelected())
					{
						facility =facility+ "E-Statement";

					}
			try {
			    if (accounttype == null || accounttype.isEmpty()) {
			        JOptionPane.showMessageDialog(null, "Account Type is Required");
			    } else {
			        Conn conn = new Conn();

			        // Use proper SQL syntax without quotes around the column names
			        String query = "INSERT INTO signup3 (application_form_no, type, card, pin, serv) VALUES (?, ?, ?, ?, ?)";
			        String query2 = "INSERT INTO login (application_form_no, card, pin) VALUES (?, ?, ?)";

			        // Using PreparedStatement to prevent SQL injection
			        PreparedStatement pstmt1 = conn.c.prepareStatement(query);
			        pstmt1.setString(1, application_form_no);
			        pstmt1.setString(2,"" );
			        pstmt1.setString(3, no);  // Updated to use the generated card number
			        pstmt1.setString(4, ne);   // Updated to use the generated PIN
			        pstmt1.setString(5, facility);
			        pstmt1.executeUpdate();

			        PreparedStatement pstmt2 = conn.c.prepareStatement(query2);
			        pstmt2.setString(1, application_form_no);
			        pstmt2.setString(2, no);  // Same card number
			        pstmt2.setString(3, ne);   // Same PIN
			        pstmt2.executeUpdate();

			        JOptionPane.showMessageDialog(null, "Card: " + no + "\nPIN: " + ne);
			    }
			
			
				setVisible(false);
				new Transaction(ne).setVisible(true);
			
			
			}catch (Exception ae) {
			    System.out.print(ae);
			}

		}	else if(e.getSource()==b1){
			setVisible(false);
			new Login().setVisible(true);
			}
		}
				
	public static void main(String args[]) {
		new signup3("");
	}
}
