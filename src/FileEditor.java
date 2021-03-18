import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileEditor extends JFrame implements ActionListener{

	private JFrame fileEditorTitle, fileEdit;
	private JTextField fileNameField;
	static FileEditor window;
	private JButton okButton, cancleButton; 
	private JLabel fileNameLabel;
	private JLabel creatorLabel;
	static String fileName;
	PrintWriter out;
	FileWriter output;
	BufferedWriter bw, bt;
	File file, tempFile;
	JTextField inputMessage;
	static String response;
	GUI mywindow;
	

	/** 
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					window = new FileEditor();
					window.fileEditorTitle.setVisible(true);
				} catch (Exception e) 
				
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FileEditor() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		
		
		fileEditorTitle = new JFrame();
		fileEditorTitle.setTitle("File Editor");
		fileEditorTitle.setBounds(100, 100, 450, 242);
		fileEditorTitle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fileEditorTitle.getContentPane().setLayout(null);
		
		fileNameLabel = new JLabel("Enter File Name :");
		fileNameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		fileNameLabel.setBounds(39, 43, 125, 26);
		fileEditorTitle.getContentPane().add(fileNameLabel);
		
		fileNameField = new JTextField();
		fileNameField.setFont(new Font("Tahoma", Font.BOLD, 14));
		fileNameField.setBounds(187, 45, 192, 26);
		fileEditorTitle.getContentPane().add(fileNameField);
		fileNameField.setColumns(10);
		
		creatorLabel = new JLabel("Created By PoMmi");
		creatorLabel.setForeground(Color.BLUE);
		creatorLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 11));
		creatorLabel.setBounds(325, 178, 109, 14);
		fileEditorTitle.getContentPane().add(creatorLabel);
		
		
		//Button Action
		okButton = new JButton("OK");
		okButton.addActionListener(this);
		okButton.setBackground(Color.GREEN);
		okButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		okButton.setBounds(89, 110, 119, 38);
		fileEditorTitle.getContentPane().add(okButton);
		
		
		cancleButton = new JButton("Cancle");
		cancleButton.addActionListener(this);
		cancleButton.setBackground(new Color(255, 0, 0));
		cancleButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		cancleButton.setBounds(232, 110, 119, 38);
		fileEditorTitle.getContentPane().add(cancleButton);
		

	}
	


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		fileEdit = new JFrame("Input");
		
		if (e.getSource() == okButton)
		{
				if (fileNameField.getText().isEmpty())
				{
				
					JOptionPane.showMessageDialog(fileEditorTitle, "Please enter file Name.", "Error Message", JOptionPane.ERROR_MESSAGE);
				
				}
			
				else
				{
				
				
					fileName = fileNameField.getText();
				
						int returnValue = JOptionPane.showConfirmDialog(
								fileEditorTitle,
								"Do you want to Create file " + "\"" + fileName + ".txt\"" ,
								"Message",
								JOptionPane.YES_NO_CANCEL_OPTION);
				
				
				
						if (returnValue == 0)
						{
							
							
					
							file = new File(fileName + ".txt");
							
							if (file.exists() && file.isFile())
							{
								file.delete();
							}
							
							boolean fCrated = false;
				
							try {
								fCrated = file.createNewFile();
								
								mywindow = new GUI();
								window.fileEditorTitle.setVisible(false);
								
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									JOptionPane.showMessageDialog(fileEditorTitle, "There is no file. \nPlease enter file Name.", "Error Message", JOptionPane.ERROR_MESSAGE);
								}

							
				
					
					
						
					
					
				}
				else if (returnValue == 1)
				{
					tempFile = new File(fileName + ".txt");
					// check if there is a file or not
					if (tempFile.exists())
					{
					
					mywindow = new GUI();
					window.fileEditorTitle.setVisible(false);
					}
					
					else
					{
						JOptionPane.showMessageDialog(fileEditorTitle, "There is no "+ fileName + ".txt file. \nPlease make the file.", "Error Message", JOptionPane.ERROR_MESSAGE);
					}
				
				}
				else if (returnValue == 2)
				{
					window.fileEditorTitle.setVisible(false);
				}
				
			}
			
			
		}
		
		else if (e.getSource() == cancleButton) 
		{
			window.fileEditorTitle.setVisible(false);
		}
		
		
	}
}
















