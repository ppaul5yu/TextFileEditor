import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class reading extends FileEditor implements ActionListener{

	JFrame frames;
	Scanner myReader;
	String data;
	static reading window;
	JLabel message;
	FileReader reader;
	BufferedReader br;
	File myObj;
	JScrollPane scrollableTextAera;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new reading();
					window.frames.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public reading() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		

		
		frames = new JFrame(FileEditor.fileName + ".txt");
		frames.setBounds(100, 100, 558, 412);
		frames.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frames.getContentPane().setLayout(null);
		
		JLabel cratorName = new JLabel("Created By iPretom");
		cratorName.setForeground(Color.BLUE);
		cratorName.setFont(new Font("Segoe Print", Font.BOLD, 11));
		cratorName.setBounds(423, 339, 119, 23);
		frames.getContentPane().add(cratorName);
		
		JButton returnButton = new JButton("Return");
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frames.dispose();
				
			}
		});
		returnButton.setBackground(Color.GREEN);
		returnButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		returnButton.setBounds(133, 302, 89, 23);
		frames.getContentPane().add(returnButton);
		
		JButton cancleButton = new JButton("Cancle");
		cancleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		cancleButton.setBackground(Color.RED);
		cancleButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		cancleButton.setBounds(288, 302, 89, 23);
		frames.getContentPane().add(cancleButton);
		
		JLabel messageTitle = new JLabel("Message:");
		messageTitle.setFont(new Font("Tahoma", Font.BOLD, 13));
		messageTitle.setForeground(Color.BLUE);
		messageTitle.setBounds(21, 11, 64, 24);
		frames.getContentPane().add(messageTitle);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		
		textArea.setBounds(51, 46, 432, 224);
		frames.getContentPane().add(textArea);
		
		scrollableTextAera = new JScrollPane(textArea);
		scrollableTextAera.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollableTextAera.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		frames.getContentPane().add(scrollableTextAera);
		scrollableTextAera.setBounds(51, 46, 432, 224);
		
		try
		{
			reader = new FileReader(FileEditor.fileName + ".txt");
			br = new BufferedReader(reader);
			textArea.read(br, null);
			br.close();
			textArea.requestFocus();
		}
		catch (Exception e)
		{
			JOptionPane.showConfirmDialog(null, e);
		}
		
		
	}
}
