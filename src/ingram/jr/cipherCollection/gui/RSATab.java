package ingram.jr.cipherCollection.gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JLabel;
import ingram.jr.cipherCollection.ciphers.RSA;

public class RSATab extends TakesUserTextKeyTab {
	private RSA rsa;
	private JPanel rsaInputPanel;
	private JPanel pqPanel;
	private JPanel pqInputPanel;
	private JLabel pqExplanation;
	private JLabel pLabel;
	private JTextArea pInput;
	private JLabel qLabel;
	private JTextArea qInput;
	
	private JPanel nmPanel;
	private JLabel nLabel;
	private JTextArea nDisplay;
	private JLabel mLabel;
	private JTextArea mDisplay;

	private JPanel edPanel;
	private JPanel edInputPanel;
	private JLabel edExplanation;
	private JLabel eLabel;
	private JTextArea eInput;
	private JLabel dLabel;
	private JTextArea dDisplay;
	
	public RSATab(){
		super();
		rsa = new RSA();
		rsaInputPanel = new JPanel(new BorderLayout());
		pqPanel = new JPanel(new BorderLayout());
		pqInputPanel = new JPanel(new FlowLayout());
		pqExplanation = new JLabel("P and Q must both be prime numbers.");
		pqExplanation.setHorizontalAlignment(JLabel.CENTER);
		pqExplanation.setForeground(Color.BLACK);
		pLabel = new JLabel("p: ");
		pInput = new JTextArea("53");
		pInput.setColumns(10);
		pInput.getDocument().addDocumentListener(new DocumentListener(){	
			@Override
			public void insertUpdate(DocumentEvent e) {
				checkorrectPDEInputs();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				checkorrectPDEInputs();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				//Not used as PlainDocument.
			}	
		});
		
		qLabel = new JLabel("q: ");
		qInput = new JTextArea("61");
		qInput.setColumns(10);	
		qInput.getDocument().addDocumentListener(new DocumentListener(){	
			@Override
			public void insertUpdate(DocumentEvent e) {
				checkorrectPDEInputs();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				checkorrectPDEInputs();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				//Not used as PlainDocument.
			}
		});
		pqInputPanel.add(pLabel);
		pqInputPanel.add(pInput);
		pqInputPanel.add(qLabel);
		pqInputPanel.add(qInput);
		pqPanel.add(pqExplanation, BorderLayout.NORTH);
		pqPanel.add(pqInputPanel, BorderLayout.CENTER);
		rsaInputPanel.add(pqPanel, BorderLayout.NORTH);
		nmPanel = new JPanel(new FlowLayout());
		nLabel = new JLabel("n: ");
		nDisplay = new JTextArea("3233");
		nDisplay.setEditable(false);
		nDisplay.setColumns(10);
		mLabel = new JLabel("m: ");
		mDisplay = new JTextArea("3120");
		mDisplay.setColumns(10);
		mDisplay.setEditable(false);
		nmPanel.add(nLabel);
		nmPanel.add(nDisplay);
		nmPanel.add(mLabel);
		nmPanel.add(mDisplay);
		rsaInputPanel.add(nmPanel, BorderLayout.CENTER);
		
		edPanel = new JPanel(new BorderLayout());
		edInputPanel = new JPanel(new FlowLayout());
		edExplanation = new JLabel("e must hold true for: 1 < e < m");
		edExplanation.setHorizontalAlignment(JLabel.CENTER);
		edExplanation.setForeground(Color.BLACK);
		eLabel = new JLabel("e: ");
		eInput = new JTextArea("1013");	
		eInput.setColumns(10);
		eInput.getDocument().addDocumentListener(new DocumentListener(){
			@Override
			public void insertUpdate(DocumentEvent e) {
				enforceCheckValues(checkCorrectEInput(), edExplanation);
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				enforceCheckValues(checkCorrectEInput(), edExplanation);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				//Not used as PlainDocument.
			}	
		});
		dLabel = new JLabel("d: ");
		dDisplay = new JTextArea("77");
		dDisplay.setEditable(false);
		dDisplay.setColumns(10);
		edInputPanel.add(eLabel);
		edInputPanel.add(eInput);
		edInputPanel.add(dLabel);
		edInputPanel.add(dDisplay);
		edPanel.add(edExplanation, BorderLayout.NORTH);
		edPanel.add(edInputPanel, BorderLayout.CENTER);
		rsaInputPanel.add(edPanel, BorderLayout.SOUTH);
		
		rsa.encrypt(cipherInputBox.getText());
		cipherOutputBox.setText(rsa.getEncryptedWord());
		inputPanel.add(rsaInputPanel, BorderLayout.SOUTH);
		cipherIO.add(inputPanel, BorderLayout.NORTH);
		cipherIO.add(outputPanel, BorderLayout.CENTER);
		cipherPanel.add(cipherIO, BorderLayout.CENTER);
		addInputOutputBoxes();
		createCoreButtons();
		
		encryptButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(checkorrectPDEInputs()){
					rsa.encrypt(cipherInputBox.getText());
					cipherOutputBox.setText(rsa.getEncryptedWord());
				}
			}
			
		});
		
		decryptButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//Add a check to make sure all characters are numerical!
				if(checkorrectPDEInputs()){
					rsa.decrypt(cipherInputBox.getText());
					cipherOutputBox.setText(rsa.getEncryptedWord());
				}
				
			}});
	}
	
	private boolean checkorrectPDEInputs(){
		if(enforceCheckValues(checkCorrectPQInput(), pqExplanation) &&	enforceCheckValues(checkCorrectEInput(), edExplanation)){
			return true;
		}else{
			return false;
		}
	}
	
	/**Checks if the values of p and q are both prime numbers.
	 * 	
	 * @return False if both p and q are not prime. 
	 */
	private boolean checkCorrectPQInput(){
		boolean correctInputs = true;
		try{
			rsa.setPQAndDerivatives(Integer.parseInt(pInput.getText()), Integer.parseInt(qInput.getText()));
			Integer nValue = rsa.getN();
			Integer mValue = rsa.getM();
			nDisplay.setText(nValue.toString());
			mDisplay.setText(mValue.toString());
			if(pqExplanation.getForeground().equals(Color.RED)){
				pqExplanation.setForeground(Color.BLACK);
			}
		}catch(IllegalArgumentException ex){
			if(pqExplanation.getForeground().equals(Color.BLACK)){
				pqExplanation.setForeground(Color.RED);
			}
			correctInputs = false;
		}
		return correctInputs;
	}
	
	private boolean checkCorrectEInput(){
		boolean correctInputs = true;
		try{
			rsa.setE(Integer.parseInt(eInput.getText()));
			rsa.setD();
			Integer dValue = rsa.getD();
			dDisplay.setText(dValue.toString());
			if(edExplanation.getForeground().equals(Color.RED)){
				edExplanation.setForeground(Color.BLACK);
			}
		}catch(IllegalArgumentException ex){
			if(edExplanation.getForeground().equals(Color.BLACK)){
				edExplanation.setForeground(Color.RED);
			}
			correctInputs = false;
		}
		return correctInputs;
	}	
}