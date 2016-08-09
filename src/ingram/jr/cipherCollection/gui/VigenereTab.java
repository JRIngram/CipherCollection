package ingram.jr.cipherCollection.gui;

import ingram.jr.cipherCollection.ciphers.Vigenere;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class VigenereTab extends Tab{
	private Vigenere vigenere;
	private JPanel vigenereIO;
	private JPanel vigenereInput;
	private JPanel vigenereOutput;
	private JPanel vigenereKeyInput;
	private JLabel vigenereExplantion;
	private JLabel vigenereKeyPrompt;
	private JTextArea vigenereInputBox;
	private JTextArea vigenereKeyBox;
	private JTextArea vigenereOutputBox;
	
	
	public VigenereTab(){
		super();
		vigenere = new Vigenere();
		vigenereIO = new JPanel(new BorderLayout());
		vigenereInput = new JPanel(new BorderLayout());
		vigenereKeyInput = new JPanel(new BorderLayout());
		vigenereOutput = new JPanel(new BorderLayout());
		vigenereExplantion = new JLabel("<html><p>Each letter in they key has a value associated with it(A: 0, B: 1, C: 2)</p>"
				+ "<p>The key cycles through the key one letter at a time.</p>"
				+ "<p>It shifts a letter in the word by a value dependent on the key.</p>"
				+ "<p>The key wraps.</p>"
				+ "<p>e.g. 'abcd' encrypted by key 'ab' would shift to:'acce'</p></html>");
		vigenereKeyPrompt = new JLabel("Enter an alphabetical string:");
		vigenereInputBox = new JTextArea("Input");
		vigenereInputBox.setRows(3);
		vigenereKeyBox = new JTextArea("b");
		vigenere.setKeyCharacters(vigenereKeyBox.getText());
		vigenere.encrypt(vigenereInputBox.getText());
		vigenereOutputBox = new JTextArea(vigenere.getEncryptedWord());
		
		//Set-up options for input/output textboxes.
		vigenereInputBox.setRows(3);
		vigenereKeyBox.setRows(3);
		vigenereOutputBox.setRows(3);
		vigenereOutputBox.setEditable(false);
		
		//Set-up for the individual Input and Output Panels.
		vigenereInput.add(vigenereExplantion, BorderLayout.NORTH);
		vigenereInput.add(inputHeader, BorderLayout.CENTER);
		vigenereInput.add(vigenereInputBox, BorderLayout.SOUTH);
		
		vigenereKeyInput.add(vigenereKeyPrompt, BorderLayout.NORTH);
		vigenereKeyInput.add(vigenereKeyBox, BorderLayout.SOUTH);
		
		vigenereOutput.add(outputHeader, BorderLayout.NORTH);
		vigenereOutput.add(vigenereOutputBox, BorderLayout.SOUTH);
		
		vigenereIO.add(vigenereInput, BorderLayout.NORTH);
		vigenereIO.add(vigenereKeyInput, BorderLayout.CENTER);
		vigenereIO.add(vigenereOutput, BorderLayout.SOUTH);
		cipherPanel.add(vigenereIO, BorderLayout.CENTER);
		
		createCoreButtons();
		cipherPanel.add(buttonPanel, BorderLayout.SOUTH);
		
		/*When Encrypt button is pressed:
		 * The key characters are set and then the world is encrypted.
		 */
		encryptButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				vigenere.setKeyCharacters(vigenereKeyBox.getText());
				vigenere.encrypt(vigenereInputBox.getText());
				vigenereOutputBox.setText(vigenere.getEncryptedWord());
			}
		});
		
		decryptButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				vigenere.setKeyCharacters(vigenereKeyBox.getText());
				vigenere.decrypt(vigenereInputBox.getText());
				vigenereOutputBox.setText(vigenere.getEncryptedWord());
			}
			
		});
	}

}
