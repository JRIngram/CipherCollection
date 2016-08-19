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
 * @see Tab
 * @see Atbash
 */

public class AtbashTab extends Tab {
	private Atbash atbash;
	
	/** Creates the tab for the Atbash display.
	 * <p>Additionally creates action listeners for the encrypt and decrypt button.
	 */
	public AtbashTab(){
		super();
		atbash = new Atbash();
		cipherIO = new JPanel(new BorderLayout());
		inputPanel = new JPanel(new BorderLayout());
		outputPanel = new JPanel(new BorderLayout());
		atbash.encrypt(cipherInputBox.getText());
		cipherOutputBox = new JTextArea(atbash.getEncryptedWord());
		
		cipherPanel.add(cipherExplanation, BorderLayout.NORTH);
		addCipherExplanation("Substitutes 'A' for 'Z', 'B' for 'Y', 'C' for 'X' ect.");
		
		addInputOutputBoxes();
		cipherIO.add(inputPanel, BorderLayout.NORTH);	
		cipherIO.add(outputPanel, BorderLayout.CENTER);
				
		cipherPanel.add(cipherIO, BorderLayout.CENTER);
		
		createCoreButtons();
		
		encryptButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				atbash.encrypt(cipherInputBox.getText());
				cipherOutputBox.setText(atbash.getEncryptedWord());
			}
		});
		
		decryptButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				atbash.encrypt(cipherInputBox.getText());
				cipherOutputBox.setText(atbash.getEncryptedWord());
			}
		});
	}
}
