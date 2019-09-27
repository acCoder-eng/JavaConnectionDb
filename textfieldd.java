package denem1;

import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.table.DefaultTableModel;


import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.sql.SQLException;
import java.awt.Color;

public class textfieldd {

	private JFrame frame;
	private JTable table;
	DBconnection x = new DBconnection();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					textfieldd window = new textfieldd();
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
	public textfieldd() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	
		frame = new JFrame();
		frame.setBounds(100, 100, 1136, 475);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JScrollPane jp = new JScrollPane();
		jp.setBackground(Color.WHITE);
		jp.setBounds(31, 24, 512, 98);
		frame.getContentPane().add(jp);
		
		table = new JTable();
		DefaultTableModel model = new DefaultTableModel(new String[]{"id", "name", "surname","email"}, 0);
		try {
			while(x.rs.next()) {
				int id = x.rs.getInt("id");
				String name = x.rs.getString("name");
			    String surname = x.rs.getString("surname");
			    String email = x.rs.getString("email");
				model.addRow(new Object[]{id,name,surname,email});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			x.con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table.setModel(model);
	
		jp.setViewportView(table);
	}
}
