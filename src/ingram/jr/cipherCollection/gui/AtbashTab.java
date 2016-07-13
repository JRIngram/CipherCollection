package ingram.jr.cipherCollection.gui;

import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import ingram.jr.cipherCollection.ciphers.Atbash;

/** Constructs Atbash tabs for CipherCollectionGUI of the developed ciphers.
 * @author JRIngram
 * @see CollectionGUI
 */

public class AtbashTab extends Tab {
	private Atbash atbash;
	private JPanel atbashIO;
	private JPanel atbashInput;
	private JPanel atbashOutput;
	private JLabel atbashExplanation;
	private JTextArea atbashInputBox;
	private JTextArea atbashOutputBox;
	
	/** Creates the tab for the Atbash display.
	 * <p>Additionally creates action listeners for the encrypt and decrypt button.
	 */
	
	public AtbashTab(){
		super();
		atbash = new Atbash();
		cipherPanel = new JPanel(new BorderLayout());
		atbashIO = new JPanel(new BorderLayout());
		atbashInput = new JPanel(new BorderLayout());
		atbashOutput = new JPanel(new BorderLayout());
		atbashExplanation = new JLabel("Substitutes 'A' for 'Z', 'B' for 'Y', 'C' for 'X' ect.");
		atbashInputBox = new JTextArea("Input");
		atbash.encrypt(atbashInputBox.getText());
		atbashOutputBox = new JTextArea(atbash.getEncryptedWord());
		atbashOutputBox.setEditable(false);
		atbashInputBox.setRows(3);
		atbashOutputBox.setRows(3);
		
		cipherPanel.add(atbashExplanation, BorderLayout.NORTH);
		
		atbashIO.add(atbashInput, BorderLayout.NORTH);
		atbashInput.add(inputHeader, BorderLayout.NORTH);
		atbashInput.add(atbashInputBox, BorderLayout.CENTER);
		
		atbashIO.add(atbashOutput, BorderLayout.CENTER);
		atbashOutput.add(outputHeader, BorderLayout.NORTH);
		atbashOutput.add(atbashOutputBox, BorderLayout.CENTER);
				
		cipherPanel.add(atbashIO, BorderLayout.CENTER);
		
		createCoreButtons();
		cipherPanel.add(buttonPanel, BorderLayout.SOUTH);
		
		encryptButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				atbash.encrypt(atbashInputBox.getText());
				atbashOutputBox.setText(atbash.getEncryptedWord());
			}
		});
		
		decryptButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				atbashInputBox.setText(atbash.getEncryptedWord());
				atbash.encrypt(atbash.getEncryptedWord());
				atbashOutputBox.setText(atbash.getEncryptedWord());
			}
		});
	}
}
