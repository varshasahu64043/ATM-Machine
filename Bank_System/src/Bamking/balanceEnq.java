package Bamking;
import java.awt.event.*;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.sql.ResultSet;
public class balanceEnq extends JFrame implements ActionListener{
	String pin;
//	String pinchange;
	JButton back;
	balanceEnq(String pin){
	
		this.pin=pin;
//		this.pinchange=pinchange;
		
		ImageIcon i1=new ImageIcon(getClass().getResource("/icons/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(700, 900, Image.SCALE_DEFAULT);
	    ImageIcon i3=new ImageIcon(i2);
	    JLabel image=new JLabel(i3);
	    image.setBounds(0,0,700,900);
	    add(image);
	    back=new JButton("Back");
		back.setBounds(350,380,120,30);
		back.addActionListener(this);
		image.add(back);
		Conn con=new Conn();
		try{
			ResultSet rs=con.s.executeQuery("select * from deposite where pin='"+pin+" ' ");
			int balance =0;
			while(rs.next()){
				if(rs.getString("amount").equals("amount")){
					balance+= Integer.parseInt(rs.getString("amount"));
					
				}
				else {balance -= Integer.parseInt(rs.getString("amount"));

			}
		}
		}catch(Exception ae){
			System.out.print(ae);
		}
	
		
		setSize(900,900);
		setLocation(300,0);
		setVisible(true);
		setUndecorated(true);
	    setLayout(null);
		
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==back){
		setVisible(false);
		new Transaction(pin).setVisible(true);
		}
	}
	
	
	public static void main(String args[]){
		new balanceEnq("");
	}
}
	