package Bamking;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
public class ministatement extends JFrame {

    String pin;

    ministatement(String pin) {
        this.pin = pin;
        setSize(900, 900);
        setTitle("Mini Statement");

        // Set undecorated before setting visibility
        setUndecorated(true);
        JLabel mini = new JLabel();
        mini.setBounds(40, 120, 300, 20);
        mini.setFont(new Font("System", Font.BOLD, 16)); 
        add(mini);

        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(350, 20, 100, 20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(40, 80, 300, 20);
    	card.setFont(new Font("System", Font.BOLD, 16)); 
        add(card);

        try {
            Conn con = new Conn();
            ResultSet rs=con.s.executeQuery("select * from login where pin='89428920' ");
            while(rs.next()){
            	card.setText("card number:" + rs.getString("card").substring(0,4)+"XXXXX");
            }
        }catch(Exception e){
        	System.out.println(e);
        }

        try {
            Conn con = new Conn();
            ResultSet rs=con.s.executeQuery("select * from deposite where pin=' 50156511 ' ");
            while(rs.next()){
            	mini.setText("Amount:" + rs.getString("amount"));
            }
        }catch(Exception e){
        	System.out.println(e);
        }
        
        
        
        setSize(800,600);
        setLayout(null);
        setLocation(300, 0);
        setVisible(true);
    }

    public static void main(String args[]) {
        new ministatement("");
    }
}
