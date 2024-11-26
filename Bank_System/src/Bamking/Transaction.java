package Bamking;
import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
public class Transaction extends JFrame implements ActionListener {
JButton deposite,btn1,btn2,btn3,btn4,btn5,btn6;
String pin;

	Transaction(String pin){
		this.pin=pin;
	ImageIcon i1=new ImageIcon(getClass().getResource("/icons/atm.jpg"));
	Image i2=i1.getImage().getScaledInstance(700, 900, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image=new JLabel(i3);
    image.setBounds(0,0,700,900);
    add(image);
		
		JLabel text=new JLabel("Please select your Transaction");
		text. setBounds(220,210,700,35);
		text.setForeground(Color.white);
		text.setFont(new Font("System", Font.BOLD, 16)); 
		image.add(text);
		    
		deposite=new JButton("Deposite");
		deposite.setBounds(210,280,120,30);
		deposite.addActionListener(this);
		image.add(deposite);
		
		btn1=new JButton("withdraw");
		btn1.setBounds(350,280,120,30);
		btn1.addActionListener(this);
	    image.add(btn1);
		
		btn2=new JButton("fastCash");
		btn2.setBounds(210,330,120,30);
		btn2.addActionListener(this);
		image.add(btn2);
		
		btn3=new JButton("ministatement");
		btn3.setBounds(350,330,120,30);
		btn3.addActionListener(this);
		image.add(btn3);
		
		btn4=new JButton("pinchange");
		btn4.setBounds(210,380,120,30);
		btn4.addActionListener(this);
		image.add(btn4);

		btn5=new JButton("Balance Enquiry");
		btn5.setBounds(350,380,120,30);
		btn5.addActionListener(this);
		image.add(btn5);

		btn6=new JButton("Exit");
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
			System.exit(0);
		}else if(e.getSource()==deposite){
			setVisible(false);
			new Deposite(pin).setVisible(true);
		}
		else if(e.getSource()==btn1){
			setVisible(false);
			new withdraw(pin).setVisible(true);
		}else if(e.getSource()==btn4){
			setVisible(false);
			new pinchange(pin).setVisible(true);
		}else if(e.getSource()==btn5){
			setVisible(false);
			new balanceEnq(pin).setVisible(true);
		}else if(e.getSource()==btn3){
			setVisible(false);
			new ministatement(pin).setVisible(true);
		}else if(e.getSource()==btn2){
			setVisible(false);
			new FastCash(pin).setVisible(true);
		}


		
		
	}
	
	
	
	
	
	public static void main(String args[]){
		new Transaction("");
	}
}
