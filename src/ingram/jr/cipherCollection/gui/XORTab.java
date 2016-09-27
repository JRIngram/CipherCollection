package ingram.jr.cipherCollection.gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class XORTab extends TakesUserTextKeyTab {
	private JPanel keyPanel;
	private JLabel keyLabel;
	private JTextArea keyInput;
	private JScrollPane keyScrollPane;
	
	public XORTab(){
		keyPanel = new JPanel(new BorderLayout());
		keyLabel = new JLabel("Enter an alphabetical key the same length as the input.");
		keyLabel.setForeground(Color.BLACK);
		keyInput = new JTextArea("ImKey");
		
		keyScrollPane = new JScrollPane(keyInput, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		keyPanel.add(keyLabel, BorderLayout.NORTH);
		keyPanel.add(keyScrollPane, BorderLayout.CENTER);
		
		addCipherExplanation("HELLO!");
		createCoreButtons();
		addInputOutputBoxes();
		cipherIO.add(inputPanel, BorderLayout.NORTH);
		cipherIO.add(keyPanel, BorderLayout.CENTER);
		cipherIO.add(outputPanel, BorderLayout.SOUTH);
		cipherPanel.add(cipherIO, BorderLayout.CENTER);
		
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
		
		cipherInputBox.getDocument().addDocumentListener(new DocumentListener(){
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
	}
}
