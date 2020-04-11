package GUI;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class AddAccount extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public AddAccount() {
		setTitle("Add Account");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddCurrentAccount = new JButton("Add Saving Account");
		btnAddCurrentAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!GUIForm.addsavingsaccount.isVisible())
				{
					GUIForm.addsavingsaccount.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(getComponent(0), "Already Opened", "Warning", 0);
				}
			
				
				dispose();
			}
		});
		btnAddCurrentAccount.setBounds(118, 56, 193, 38);
		contentPane.add(btnAddCurrentAccount);
		
		JButton button = new JButton("Add Current Account");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!GUIForm.addcurrentacc.isVisible())
				{
					GUIForm.addcurrentacc.setVisible(true);
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(getComponent(0), "Already Opened", "Warning", 0);
				}
				
				
			}
		});
		button.setBounds(118, 124, 193, 38);
		contentPane.add(button);
		
		JButton btnAddStudentAccount = new JButton("Add Student Account");
		btnAddStudentAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!GUIForm.addstudentaccount.isVisible())
				{
					
					GUIForm.addstudentaccount.setVisible(true);
					dispose();
				}
				
				else
				{
					JOptionPane.showMessageDialog(getComponent(0), "Already Opened", "Warning", 0);
				}
			
			}
			
			
		});
		btnAddStudentAccount.setBounds(118, 190, 193, 38);
		contentPane.add(btnAddStudentAccount);
		
		JLabel lblAddAccount = new JLabel("Add Account");
		lblAddAccount.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAddAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddAccount.setBounds(108, 11, 210, 34);
		contentPane.add(lblAddAccount);
	}
}
