package ingram.jr.cipherCollection.gui;

//TODO Check that the strings are only alphabetical or binary (allow more length for binary)!

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
	private int binaryLength;
	
	/**
	 * Constructs the tab for the XOR cipher.  
	 */
	public XORTab(){
		XOR xor = new XOR();
		binaryLength = 0; //Used to calculate the length of input if it
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
				setEnabledButtons();	
			}
 
			@Override
			public void removeUpdate(DocumentEvent e) {
				setEnabledButtons();
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
			@Override
			public void insertUpdate(DocumentEvent e){
				setEnabledButtons();
			}
 
			@Override
			public void removeUpdate(DocumentEvent e){
				setEnabledButtons();
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
	
	/**
	 * Checks if the input in the input box is a binary string or alphabetical
	 * If binary: encrypt button is disabled and checks if string is the binary length.
	 * If alphabetical: decrypt is disabled and checks if the string and key are the same length. 
	 */
	private void setEnabledButtons(){
		int letterNum = keyInput.getText().length();
		int spaces = letterNum - 1;
		binaryLength = (letterNum - 1) + (letterNum * 7);
		if(cipherInputBox.getText().length() == keyInput.getText().length()
				&& cipherInputBox.getText().matches("^[a-zA-Z]+$")){
			enforceCheckValues(true, keyLabel);
			decryptButton.setEnabled(false);
		}else if((cipherInputBox.getText().length() == binaryLength 
				&& cipherInputBox.getText().matches("^[01 ]+$"))
				&& cipherInputBox.getText().split(" ").length - 1 == spaces){
			enforceCheckValues(true, keyLabel);
			encryptButton.setEnabled(false);
		}else{
			enforceCheckValues(false, keyLabel);
		}
	}
}
