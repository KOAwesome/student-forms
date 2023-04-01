package Student;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class registeration_page {

	private JFrame frame;
	private JTextField n;
	private JTextField eml;
	private JTextField mks;
	private JTextField b;
	private JTextField s;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registeration_page window = new registeration_page();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public registeration_page() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("name");
		lblNewLabel.setBounds(40, 62, 61, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("email");
		lblEmail.setBounds(40, 88, 61, 16);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblMarks = new JLabel("marks");
		lblMarks.setBounds(40, 116, 61, 16);
		frame.getContentPane().add(lblMarks);
		
		JLabel lblBranch = new JLabel("branch");
		lblBranch.setBounds(40, 144, 61, 16);
		frame.getContentPane().add(lblBranch);
		
		JLabel lblSection = new JLabel("section");
		lblSection.setBounds(40, 172, 61, 16);
		frame.getContentPane().add(lblSection);
		
		n = new JTextField();
		n.setBounds(113, 57, 130, 26);
		frame.getContentPane().add(n);
		n.setColumns(10);
		
		eml = new JTextField();
		eml.setColumns(10);
		eml.setBounds(113, 88, 130, 26);
		frame.getContentPane().add(eml);
		
		mks = new JTextField();
		mks.setColumns(10);
		mks.setBounds(113, 111, 130, 26);
		frame.getContentPane().add(mks);
		
		b = new JTextField();
		b.setColumns(10);
		b.setBounds(113, 139, 130, 26);
		frame.getContentPane().add(b);
		
		s = new JTextField();
		s.setColumns(10);
		s.setBounds(113, 167, 130, 26);
		frame.getContentPane().add(s);
		
		JButton b1 = new JButton("submit");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = n.getText();
				String email = eml.getText();
				float marks = Float.parseFloat(mks.getText());
				String branch = b.getText();
				String section = s.getText();
				
				try {
				Connection dbs = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/student","root","mass32610");
				String q = " insert into std_data values('"+name+"', '"+email+"','"+marks+"','"+branch+"', '"+section+"') ";
				Statement sta = dbs.createStatement();
				sta.executeUpdate(q);
				dbs.close();
				frame.dispose();
		
				} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		b1.setBounds(113, 217, 117, 29);
		frame.getContentPane().add(b1);
	}

}
