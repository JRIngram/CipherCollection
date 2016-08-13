package ingram.jr.cipherCollection.gui;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/** Superclass for GUI Tabs.
 * 
 * @version 1.0.0
 * @author JRIngram
 *
 */
public class Tab {
	protected JPanel cipherPanel;
	protected JPanel buttonPanel;
	protected JPanel inputPanel;
	protected JPanel outputPanel;
	protected JPanel cipherIO;
	protected JButton encryptButton;
	protected JButton decryptButton;
	private JButton quitButton;
	protected JLabel cipherExplanation;
	protected JLabel inputHeader;
	protected JLabel outputHeader;
	protected JTextArea cipherInputBox;
	protected JTextArea outputBox;
	
	public Tab(){
		outputHeader = new JLabel("Output:");
		cipherPanel = new JPanel(new BorderLayout());
		
		//Setting up superclass input panel
		inputPanel = new JPanel(new BorderLayout());	
		inputHeader = new JLabel("Input:");
		cipherInputBox = new JTextArea("Input");
		cipherInputBox.setLineWrap(true);
		cipherInputBox.setRows(3);
		
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
		outputBox = new JTextArea();
		outputBox.setLineWrap(true);
		outputBox.setRows(3);
		outputBox.setEditable(false);
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
				int quit = JOptionPane.showConfirmDialog(null,"Are you sure you want to quit?", "Quit?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(quit == 0){
					System.exit(0);
				}
			}
		});
	}
	
	/**Adds the input/output headers and textboxes to their respective panels.
	 * 
	 */
	protected void addInputOutputBoxes(){
		inputPanel.add(inputHeader, BorderLayout.NORTH);
		inputPanel.add(cipherInputBox, BorderLayout.CENTER);
		outputPanel.add(outputHeader, BorderLayout.NORTH);
		outputPanel.add(outputBox, BorderLayout.CENTER);
	}
	
	/** Returns the cipherPanel, which has been created during the construction of the subclass.
	 * 
	 * @return The cipher tab that has been created.
	 */
	
	public JPanel getTab(){
		return cipherPanel;
	}
}
