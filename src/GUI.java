import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JToggleButton;
import javax.swing.JTextPane;

public class GUI extends FileEditor implements ActionListener{

	private JFrame frame, fileEdit;
	private JButton sendButton;
	private JEditorPane messagePane;
	FileWriter out;
	BufferedWriter outing;
	reading readwindow;
	JButton readButton;
	static GUI window;
	JLabel titleMessage;
	JScrollPane scrollableTextAera;

	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		

		frame = new JFrame("Input Message");
		frame.setBounds(100, 100, 450, 468);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		titleMessage = new JLabel("Type Message ...");
		titleMessage.setForeground(Color.BLUE);
		titleMessage.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		titleMessage.setBounds(45, 22, 231, 23);
		frame.getContentPane().add(titleMessage);
		
		JLabel cratorName = new JLabel("Created By iPretom");
		cratorName.setForeground(Color.BLUE);
		cratorName.setFont(new Font("Segoe Print", Font.BOLD, 11));
		cratorName.setBounds(305, 395, 119, 23);
		frame.getContentPane().add(cratorName);
		
		messagePane = new JEditorPane();
		messagePane.setBounds(60, 56, 450, 189);
		frame.getContentPane().add(messagePane);
		
		scrollableTextAera = new JScrollPane(messagePane);
		scrollableTextAera.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollableTextAera.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		frame.getContentPane().add(scrollableTextAera);
		scrollableTextAera.setBounds(60, 56, 307, 189);
		
		JButton btnCancle = new JButton("Cancle");
		btnCancle.setBackground(Color.RED);
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		btnCancle.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancle.setBounds(252, 333, 89, 23);
		frame.getContentPane().add(btnCancle);
		
		sendButton = new JButton("Send");
		sendButton.setBackground(Color.GRAY);
		sendButton.addActionListener(this);
		sendButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		sendButton.setBounds(177, 288, 89, 23);
		frame.getContentPane().add(sendButton);
		
		readButton = new JButton("Read");
		readButton.addActionListener(this);
		readButton.setBackground(Color.GREEN);
		readButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		readButton.setBounds(116, 333, 89, 23);
		frame.getContentPane().add(readButton);
		

	}
	
	public void actionPerformed(ActionEvent e){
		
		if (e.getSource() == sendButton)
		{
			if (messagePane.getText().isEmpty())
			{
				fileEdit = new JFrame("Input");
				
				JOptionPane.showMessageDialog(fileEdit, "Text is empty.. Please Enter the text.", "Error Message", JOptionPane.ERROR_MESSAGE);
			}
			
			else
			{
				try {
					out = new FileWriter(FileEditor.window.fileName + ".txt", true);
					outing = new BufferedWriter(out);
					outing.write(messagePane.getText() + "\n");
					outing.close();
			
					JOptionPane.showMessageDialog(fileEdit, "Message has been Submitted to "+ FileEditor.window.fileName +".txt");
					
					messagePane.setText("");
					
			
				
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(frame, "There is no file. \nPlease enter file.", "Error Message", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
			
		}
		
		else if (e.getSource() == readButton)
		{
			readwindow = new reading();
			readwindow.frames.setVisible(true);
			
			
		}
		
		
	}
}
