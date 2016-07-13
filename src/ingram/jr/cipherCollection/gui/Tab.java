package ingram.jr.cipherCollection.gui;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import javax.swing.JButton;

public class Tab {
	private JButton quitButton;
	protected JPanel buttonPanel;
	protected JButton encryptButton;
	protected JButton decryptButton;
	protected JLabel inputHeader;
	protected JLabel outputHeader;
	
	
	public Tab(){
		inputHeader = new JLabel("Input:");
		outputHeader = new JLabel("Output:");
		encryptButton = new JButton("Encrypt");
		decryptButton = new JButton("Decrypt");
		quitButton = new JButton("Quit");
		buttonPanel = new JPanel(new FlowLayout());
	}
	
	//protected void createEncryptDecryptButtons();
	
	/** Adds the  JButtons to the buttonPanel.
	 * 	Adds tool tips to both buttons and adds the ActionListener to the quit button. 
	 * 
	 * @param buttonPanel The specific panel the buttons will belong to.
	 * @param encrypt The encryption JButton.
	 * @param quit The quit JButton.
	 */
	
	protected void createCoreButtons(){
		buttonPanel.add(encryptButton);
		encryptButton.setToolTipText("Encrypts the current input text.");
		buttonPanel.add(decryptButton);
		decryptButton.setToolTipText("Decrypts the current output text.");
		buttonPanel.add(quitButton);
		quitButton.setToolTipText("Quits the program.");
		quitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int quit = JOptionPane.showConfirmDialog(null,"Are you sure you want to quit?", "Quit?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(quit == 0){
					System.exit(0);
				}
			}
		});
	}
}
