import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.util.Date;
public class Curency_converter {

	private JFrame frame;
	private JTextField t1;
	private JTextField t2;
	String[] currencyunits= {
			"Units",
			"US Dollar",
			"Pakistani Rupees",
			"Indian Rupees",
			"Canadian Dollar",
			
	};
	double US_Dollar=1.31;
		double	Canadian_Dollar=1.71;
		double	Indian_Rupee=95.21;
		double	Pakistani_Rupee=162.74;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Curency_converter window = new Curency_converter();
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
	public Curency_converter() {
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
		
		JLabel lblNewLabel = new JLabel("Curency converter");
		lblNewLabel.setBackground(new Color(192, 192, 192));
		lblNewLabel.setForeground(new Color(0, 128, 192));
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 19));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(117, 0, 188, 39);
		frame.getContentPane().add(lblNewLabel);
		
		JComboBox secondcountry = new JComboBox();
		secondcountry.setBackground(new Color(255, 0, 0));
		secondcountry.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				//int position=secondcountry.getSelectedIndex();
			//	secondcurrencyunit.setText(currencyunit[position]);
				frame.getContentPane().add(secondcountry);
			}
		});
		secondcountry.setModel(new DefaultComboBoxModel(new String[] {"choose one...", "USA", "Pakistan", "India", "Canada"}));
		secondcountry.setBounds(228, 70, 122, 22);
		frame.getContentPane().add(secondcountry);
		
		JComboBox firstcountry = new JComboBox();
		firstcountry.setBackground(new Color(255, 0, 0));
		firstcountry.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				//int position=firstcountry.getSelectedIndex();
					//	firstcurrencyunit.setText(currencyunit[position]);
						frame.getContentPane().add(firstcountry);
			}
			        
		});
		firstcountry.setModel(new DefaultComboBoxModel(new String[] {"choose one...", "USA", "Pakistan", "India", "Canada"}));
		firstcountry.setBounds(30, 70, 122, 22);
		frame.getContentPane().add(firstcountry);
		
		t1 = new JTextField();
		t1.setBackground(new Color(64, 128, 128));
		t1.setBounds(40, 104, 86, 20);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setBackground(new Color(64, 128, 128));
		t2.setColumns(10);
		t2.setBounds(252, 103, 86, 20);
		frame.getContentPane().add(t2);
		
		JLabel lblNewLabel_1 = new JLabel("To currency");
		lblNewLabel_1.setForeground(new Color(0, 128, 192));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(233, 50, 105, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_4 = new JLabel("From currency");
		lblNewLabel_1_4.setForeground(new Color(0, 128, 192));
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setBounds(30, 45, 122, 14);
		frame.getContentPane().add(lblNewLabel_1_4);
		
		JLabel secondcurrencyunit = new JLabel("Units");
		secondcurrencyunit.setHorizontalAlignment(SwingConstants.CENTER);
		secondcurrencyunit.setBounds(279, 134, 46, 14);
		frame.getContentPane().add(secondcurrencyunit);
		
		JButton btnNewButton = new JButton("Convert");
		btnNewButton.setBackground(new Color(0, 0, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//convert currency
			double amountToChange=Double.parseDouble(t1.getText());	
			double amountInPounds=0;
			switch(firstcountry.getSelectedItem().toString()) {
			case "USA": amountInPounds=amountToChange / US_Dollar;
			case"Pakistan": amountInPounds=amountToChange / Pakistani_Rupee;
			case"India": amountInPounds=amountToChange / Indian_Rupee;
			case"Canada": amountInPounds=amountToChange / Canadian_Dollar;
			}
			//amount changed in pounds
			//double amountChanged=Double.parseDouble(t2.getText());	
			 double amountChanged=0;
			switch(secondcountry.getSelectedItem().toString()) {
			case "USA": amountChanged=amountInPounds * US_Dollar;
			break;
			case"Pakistan": amountChanged=amountInPounds * Pakistani_Rupee;
			break;
			case"India": amountChanged=amountInPounds * Indian_Rupee;
			break;
			case"Canada": amountChanged=amountInPounds * Canadian_Dollar;
			break;
			default:amountChanged=amountInPounds=0;
			break;
			}
			String value=String.format("%.2f",amountChanged);//after decimal point only  2 digit appear
			t2.setText(value);
			
			
			
			
			
			
			
			
			
			}
			
		});
		btnNewButton.setBounds(37, 160, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBackground(new Color(0, 0, 255));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			firstcountry.setSelectedIndex(0);
			secondcountry.setSelectedIndex(0);
			t1.setText(null);
			t2.setText(null);
			
			
			
			
			
			
			}
		});
		btnReset.setBounds(161, 160, 89, 23);
		frame.getContentPane().add(btnReset);
		
		JButton btnNewButton_1_1 = new JButton("Exit");
		btnNewButton_1_1.setBackground(new Color(0, 0, 255));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			System.exit(0);}//this will exit it
		});
		btnNewButton_1_1.setBounds(272, 159, 89, 23);
		frame.getContentPane().add(btnNewButton_1_1);
	}
}
