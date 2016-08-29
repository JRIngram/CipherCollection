package ingram.jr.cipherCollection.gui;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/** Superclass for GUI Tabs.
 * 
 * @version 1.0.0
 * @since 0.2.0
 * @author JRIngram
 *
 */
public class Tab {
	protected JPanel cipherPanel;
	private JPanel buttonPanel;
	protected JPanel inputPanel;
	protected JPanel outputPanel;
	protected JPanel cipherIO;
	protected JButton encryptButton;
	protected JButton decryptButton;
	private JButton quitButton;
	private JLabel cipherExplanation;
	private JLabel inputHeader;
	private JLabel outputHeader;
	protected JScrollPane inputScrollPane;
	protected JScrollPane outputScrollPane;
	protected JTextArea cipherInputBox;
	protected JTextArea cipherOutputBox;
	
	protected Tab(){
		cipherPanel = new JPanel(new BorderLayout());
		cipherIO = new JPanel(new BorderLayout());
		cipherExplanation = new JLabel();
		
		//Setting up superclass input panel
		inputPanel = new JPanel(new BorderLayout());	
		inputHeader = new JLabel("Input:");
		cipherInputBox = new JTextArea("Input");
		cipherInputBox.setLineWrap(true);
		cipherInputBox.setWrapStyleWord(true);
		cipherInputBox.setRows(5);
		
		//Setting up button panel
		buttonPanel = new JPanel(new FlowLayout());
		encryptButton = new JButton("Encrypt");
		encryptButton.setToolTipText("Encrypts the current input text.");
		decryptButton = new JButton("Decrypt");
		decryptButton.setToolTipText("Decrypts the current output text.");
		quitButton = new JButton("Quit");
		quitButton.setToolTipText("Quits the program.");
		
		//Setting up output panel
		outputPanel = new JPanel(new BorderLayout());
		outputHeader = new JLabel("Output:");
		cipherOutputBox = new JTextArea();
		cipherOutputBox.setLineWrap(true);
		cipherOutputBox.setWrapStyleWord(true);
		cipherOutputBox.setRows(5);
		cipherOutputBox.setEditable(false);
	}
	
	
	/** Adds the  JButtons to the buttonPanel.
	 * 	Adds tool tips to both buttons and adds the ActionListener to the quit button. 
	 * 
	 * @param buttonPanel The specific panel the buttons will belong to.
	 * @param encrypt The encryption JButton.
	 * @param quit The quit JButton.
	 */
	
	protected void createCoreButtons(){
		buttonPanel.add(encryptButton);
		buttonPanel.add(decryptButton);
		buttonPanel.add(quitButton);
		quitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					int quit = JOptionPane.showConfirmDialog(null,"Are you sure you want to quit?", "Quit?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(quit == 0){
						System.exit(0);
					}
				}catch(Exception exc){
					System.exit(0);
				}
			}
		});
		cipherPanel.add(buttonPanel, BorderLayout.SOUTH);
	}
	
	/**Adds the input/output headers and textboxes to their respective panels.
	 * 
	 */
	protected void addInputOutputBoxes(){
		inputPanel.add(inputHeader, BorderLayout.NORTH);
		inputScrollPane = new JScrollPane(cipherInputBox, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		inputPanel.add(inputScrollPane, BorderLayout.CENTER);
		outputPanel.add(outputHeader, BorderLayout.NORTH);
		outputScrollPane = new JScrollPane(cipherOutputBox,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		outputPanel.add(outputScrollPane, BorderLayout.CENTER);
	}
	
	/** Returns the cipherPanel, which has been created during the construction of the subclass.
	 * 
	 * @return The cipher tab that has been created.
	 */
	
	public JPanel getTab(){
		return cipherPanel;
	}
	
	/** Sets the cipher explanation text and places it in the North of the cipherPanel.
	 * 
	 * @param cipherExplanation The JLabel object for explanation for the cipher.
	 * @param explanation The explanation which the JLabel will display.
	 */
	protected void addCipherExplanation(String explanation){
		cipherExplanation.setText(explanation);
		cipherPanel.add(cipherExplanation, BorderLayout.NORTH);
	}
}
