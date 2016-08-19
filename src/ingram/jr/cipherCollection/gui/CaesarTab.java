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
 * @see Caesar
 * @see Tab
 * @see CollectionGUI
 * */
public class CaesarTab extends Tab{
	private Caesar caesar;
	private JPanel keyPanel;
	private JLabel keyValueLabel;
	private JSlider keySlider;
	
	/**Constructs Caesar Tab.
	 * 
	 */
	public CaesarTab(){
		super();
		caesar = new Caesar();
		cipherIO = new JPanel(new BorderLayout());
		keyPanel = new JPanel(new BorderLayout());
		inputPanel = new JPanel(new BorderLayout());
		outputPanel = new JPanel(new BorderLayout());
		cipherExplanation = new JLabel();
		
		//Sets initial value of the key and sets-up key slider.
		caesar.setKey(13);
		keySlider = new JSlider(0,25,caesar.getKey());
		keyValueLabel = new JLabel("Key Value: " + keySlider.getValue());
		caesar.encrypt(cipherInputBox.getText());
		keySlider.setMinorTickSpacing(1);
		keySlider.setMajorTickSpacing(5);
		keySlider.setPaintTicks(true);
		keySlider.setPaintLabels(true);
		cipherOutputBox.setText(caesar.getEncryptedWord());
		
		addCipherExplanation("<html>Shifts all lets in the input string by the key amount.<br>e.g. If the key is 1 A = B, B = C... Z = A.</html>");
		
		keyPanel.add(keyValueLabel, BorderLayout.NORTH);
		keyPanel.add(keySlider,BorderLayout.CENTER);		
		inputPanel.add(keyPanel, BorderLayout.SOUTH);
		
		addInputOutputBoxes();
		cipherIO.add(inputPanel, BorderLayout.NORTH);
		cipherIO.add(outputPanel, BorderLayout.CENTER);
		cipherPanel.add(cipherIO, BorderLayout.CENTER);

		createCoreButtons();
		
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
				caesar.encrypt(cipherInputBox.getText());
				cipherOutputBox.setText(caesar.getEncryptedWord());
			}
			
		});
		
		/**When the decrypt button is pressed, the input box value is decrypted and displayed in the output box.
		 */
		decryptButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				caesar.decrypt(cipherInputBox.getText());
				cipherOutputBox.setText(caesar.getEncryptedWord());
			}
		});
		

	}
}
