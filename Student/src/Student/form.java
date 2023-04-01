package Student;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class form {

	private JFrame frame;
	private JTextField it1;
	private JTextField t1;
	private JTextField it2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					form window = new form();
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
	public form() {
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
		
		JLabel lblNewLabel = new JLabel("Sno");
		lblNewLabel.setBounds(49, 43, 61, 16);
		frame.getContentPane().add(lblNewLabel);
		
		it1 = new JTextField();
		it1.setBounds(107, 38, 130, 26);
		frame.getContentPane().add(it1);
		it1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("name");
		lblNewLabel_1.setBounds(49, 96, 61, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		t1 = new JTextField();
		t1.setColumns(10);
		t1.setBounds(107, 91, 130, 26);
		frame.getContentPane().add(t1);
		
		JLabel lblNewLabel_2 = new JLabel("marks");
		lblNewLabel_2.setBounds(49, 141, 61, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		it2 = new JTextField();
		it2.setColumns(10);
		it2.setBounds(107, 136, 130, 26);
		frame.getContentPane().add(it2);
		
		JButton btnNewButton = new JButton("Query");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				String sno = it1.getText();
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/student","root","mass32610");
					String q = "select name,marks from std_data where sno = ?";
					PreparedStatement pst1 = con.prepareStatement(q);
					pst1.setString(1, sno);
					ResultSet rs = pst1.executeQuery();
					rs.next();
		
					t1.setText(rs.getString(1));
					it2.setText(""+rs.getFloat(2));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(280, 38, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Marks and Name Identify");
		lblNewLabel_3.setBounds(155, 6, 211, 16);
		frame.getContentPane().add(lblNewLabel_3);
	}
}
