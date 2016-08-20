package ingram.jr.cipherCollection.gui;

import ingram.jr.cipherCollection.ciphers.Vigenere;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**Creates the GUI tab for the Vigenere cipher.
 * @version 1.0.0
 * @since 0.3.0
 * @see Tab
 * @see CollectionGUI
 * @see Vigenere
 * */
public class VigenereTab extends Tab{
	private Vigenere vigenere;
	private JPanel vigenereKeyInput;
	private JLabel vigenereKeyPrompt;
	private JTextArea vigenereKeyBox;
	
	/**Constructs Vigenere Tab
	 * 
	 */
	public VigenereTab(){
		super();
		vigenere = new Vigenere();
		vigenereKeyInput = new JPanel(new BorderLayout());
		vigenereKeyPrompt = new JLabel("Enter an alphabetical string:");
		vigenereKeyBox = new JTextArea("b");
		vigenere.setKeyCharacters(vigenereKeyBox.getText());
		vigenere.encrypt(cipherInputBox.getText());
		cipherOutputBox.setText(vigenere.getEncryptedWord());
		
		addCipherExplanation("<html><p>Each letter in the key has a value associated with it (A: 0, B: 1, C: 2)</p>"
				+ "<p>The key continuously iterates over itself by one letter at a time.</p>"
				+ "<p>It shifts a letter in the plaintext by a value dependent on the key.</p>"
				+ "<p>e.g. 'abcd' encrypted by key 'ab' would shift to:'acce'</p></html>");
		addInputOutputBoxes();
		
		//Set-up for the individual key inputs.
		vigenereKeyBox.setRows(3);
		vigenereKeyInput.add(vigenereKeyPrompt, BorderLayout.NORTH);
		vigenereKeyInput.add(vigenereKeyBox, BorderLayout.SOUTH);
		
		//Add the seperate IOs to the cipherIO panel
		cipherIO.add(inputPanel, BorderLayout.NORTH);
		cipherIO.add(vigenereKeyInput, BorderLayout.CENTER);
		cipherIO.add(outputPanel, BorderLayout.SOUTH);
		
		cipherPanel.add(cipherIO, BorderLayout.CENTER);
		
		createCoreButtons();
		
		/**When encrypt button is pressed: The key characters are set and then the plaintext is encrypted.
		 */
		encryptButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				vigenere.setKeyCharacters(vigenereKeyBox.getText());
				vigenere.encrypt(cipherInputBox.getText());
				cipherOutputBox.setText(vigenere.getEncryptedWord());
			}
		});
		
		/**When decrypt button is pressed: The key characters are set and then the ciphertext is decrypted.
		 */
		decryptButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				vigenere.setKeyCharacters(vigenereKeyBox.getText());
				vigenere.decrypt(cipherInputBox.getText());
				cipherOutputBox.setText(vigenere.getEncryptedWord());
			}
			
		});
	}

}
