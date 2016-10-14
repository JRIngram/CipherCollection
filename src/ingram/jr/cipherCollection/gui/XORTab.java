package ingram.jr.cipherCollection.gui;

//TODO Check that the strings are only alphabetical!

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import ingram.jr.cipherCollection.ciphers.XOR;

public class XORTab extends TakesUserTextKeyTab {
	private JPanel keyPanel;
	private JLabel keyLabel;
	private JTextArea keyInput;
	private JScrollPane keyScrollPane;
	
	public XORTab(){
		XOR xor = new XOR();
		keyPanel = new JPanel(new BorderLayout());
		keyLabel = new JLabel("Enter an alphabetical key the same length as the input.");
		keyLabel.setForeground(Color.BLACK);
		keyInput = new JTextArea("ImKey");
		
		keyScrollPane = new JScrollPane(keyInput, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		keyPanel.add(keyLabel, BorderLayout.NORTH);
		keyPanel.add(keyScrollPane, BorderLayout.CENTER);
		
		addCipherExplanation("Performs a binary XOR operation on each letter in the input and its corresponding letter in the key.");
		addInputOutputBoxes();
		cipherIO.add(inputPanel, BorderLayout.NORTH);
		cipherIO.add(keyPanel, BorderLayout.CENTER);
		cipherIO.add(outputPanel, BorderLayout.SOUTH);
		cipherPanel.add(cipherIO, BorderLayout.CENTER);
		xor.setKey(keyInput.getText());
		xor.encrypt(cipherInputBox.getText());
		cipherOutputBox.setText(xor.getEncryptedWord());
		
		/**
		 * Checks if the user's key is acceptable.
		 */
		keyInput.getDocument().addDocumentListener(new DocumentListener(){
			@Override
			public void insertUpdate(DocumentEvent e) {
				if(cipherInputBox.getText().length() == keyInput.getText().length()){
					enforceCheckValues(true, keyLabel);
				}else{
					enforceCheckValues(false, keyLabel);
				}		
			}
 
			@Override
			public void removeUpdate(DocumentEvent e) {
				if(cipherInputBox.getText().length() == keyInput.getText().length()){
					enforceCheckValues(true, keyLabel);
				}else{
					enforceCheckValues(false, keyLabel);
				}	
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				//Not used as plaintext document.				
			}
			
		});
		
		/**
		 * Checks if the user's cipher/plaintext is acceptable is acceptable. 
		 */
		cipherInputBox.getDocument().addDocumentListener(new DocumentListener(){
			//Calculates how many characters there should be if the user is entering binary.
			int letterNum = keyInput.getText().length();
			int binaryLength = (letterNum - 1) + (letterNum * 7);
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				if(cipherInputBox.getText().length() == keyInput.getText().length() || cipherInputBox.getText().length() == binaryLength){
					enforceCheckValues(true, keyLabel);
				}else{
					enforceCheckValues(false, keyLabel);
				}		
			}
 
			@Override
			public void removeUpdate(DocumentEvent e) {
				if(cipherInputBox.getText().length() == keyInput.getText().length() || cipherInputBox.getText().length() == binaryLength){
					enforceCheckValues(true, keyLabel);
				}else{
					enforceCheckValues(false, keyLabel);
				}	
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				//Not used as plaintext document.				
			}
		});
		
		createCoreButtons();
		
		/**
		 * When the encrypt button is pressed, the input box value is encrypted and displayed in the output box.
		 */
		encryptButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				xor.setKey(keyInput.getText());
				xor.encrypt(cipherInputBox.getText());
				cipherOutputBox.setText(xor.getEncryptedWord());
			}
			
		});
		
		/**
		 * When the decrypt button is pressed, the input box value is decrypted and displayed in the output box.
		 */
		decryptButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				xor.setKey(keyInput.getText());		
				xor.decrypt(cipherInputBox.getText());
				cipherOutputBox.setText(xor.getEncryptedWord());
			}
			
		});
	}
}
