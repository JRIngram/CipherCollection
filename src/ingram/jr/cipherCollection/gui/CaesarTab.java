package ingram.jr.cipherCollection.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JSlider;
import ingram.jr.cipherCollection.ciphers.Caesar;

/**Creates the GUI tab for the Caesar cipher.
 * @version 1.0.0
 * @since 0.2.0
 * @see Tab
 * @see CollectionGUI
 * */
public class CaesarTab extends Tab{
	private Caesar caesar;
	private JPanel caesarIO;
	private JLabel caesarExplanation;
	private JPanel caesarInput;
	private JPanel caesarOutput;
	private JPanel keyPanel;
	private JLabel keyValueLabel;
	private JTextArea caesarInputBox;
	private JSlider keySlider;
	private JTextArea caesarOutputBox;
	
	/**Constructs Caesar Tab.
	 * 
	 */
	public CaesarTab(){
		super();
		caesar = new Caesar();
		caesar.setKey(13);
		caesarIO = new JPanel(new BorderLayout());
		keyPanel = new JPanel(new BorderLayout());
		caesarInput = new JPanel(new BorderLayout());
		caesarOutput = new JPanel(new BorderLayout());
		caesarExplanation = new JLabel("<html>Shifts all lets in the input string by the key amount.<br>e.g. If the key is 1 A = B, B = C... Z = A.</html>");
		keyValueLabel = new JLabel("Key Value: " + caesar.getKey());
		keySlider = new JSlider(0,25,13);
		caesar.setKey(keySlider.getValue());
		caesarInputBox = new JTextArea("Input");
		caesar.encrypt(caesarInputBox.getText());
		caesarOutputBox = new JTextArea(caesar.getEncryptedWord());
		
		//Set-up options for the input/output texboxes.
		caesarOutputBox.setEditable(false);
		caesarInputBox.setRows(3);
		caesarOutputBox.setRows(3);
		
		//Set-up options for the key slider.
		keySlider.setMinorTickSpacing(1);
		keySlider.setMajorTickSpacing(5);
		keySlider.setPaintTicks(true);
		keySlider.setPaintLabels(true);

		cipherPanel.add(caesarExplanation, BorderLayout.NORTH);		

		caesarIO.add(caesarInput, BorderLayout.NORTH);
		caesarInput.add(inputHeader, BorderLayout.NORTH);
		caesarInput.add(caesarInputBox, BorderLayout.CENTER);
		keyPanel.add(keyValueLabel, BorderLayout.NORTH);
		keyPanel.add(keySlider,BorderLayout.CENTER);		
		caesarInput.add(keyPanel, BorderLayout.SOUTH);
		
		caesarIO.add(caesarOutput, BorderLayout.CENTER);
		caesarOutput.add(outputHeader, BorderLayout.NORTH);
		caesarOutput.add(caesarOutputBox, BorderLayout.CENTER);
		
		cipherPanel.add(caesarIO, BorderLayout.CENTER);
		
		createCoreButtons();
		cipherPanel.add(buttonPanel, BorderLayout.SOUTH);
		
		/**When the slider changes position the Key Value label is updated to show the new value.
		 */
		keySlider.addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent e) {
				caesar.setKey(keySlider.getValue());
				keyValueLabel.setText("Key Value: " + caesar.getKey());
			}
		});
		
		/**When the encrypt button is pressed, the input box value is encrypted and displayed in the output box.
		 */
		encryptButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				caesar.encrypt(caesarInputBox.getText());
				caesarOutputBox.setText(caesar.getEncryptedWord());
			}
			
		});
		
		/**When the decrypt button is pressed, the input box value is decrypted and displayed in the output box.
		 */
		decryptButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				caesar.decrypt(caesarInputBox.getText());
				caesarOutputBox.setText(caesar.getEncryptedWord());
			}
		});
		

	}
}
