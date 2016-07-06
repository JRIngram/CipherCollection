package ingram.jr.cipherCollection;
import ingram.jr.cipherCollection.ciphers.Atbash;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;

/** User interface for the cipher collection.
 * 
 *  @author JRIngram
 *
 */

public class CollectionGUI{
	//Relevant to all sections.
	private JTabbedPane tabs;
	private JFrame mainframe;
	private JLabel inputHeader;
	private JLabel outputHeader;
	private JPanel atbashPanel;
	
	/** Constructs GUI with tabs for each of the developed ciphers.
	 * <p>Currently these Ciphers include:</p>
	 * <ul>
	 * 	<li>Atbash</li>
	 * </ul>
	 */
	
	public CollectionGUI(){
		mainframe = new JFrame("Cipher Collection\t0.1.1");
		inputHeader = new JLabel("Input:");
		outputHeader = new JLabel("Output:");
		tabs = new JTabbedPane();
		mainframe.setDefaultCloseOperation(0);
		createAtbashDisplay();
		tabs.add("Atbash", atbashPanel);
		mainframe.add(tabs);
		mainframe.pack();
		mainframe.setVisible(true);
	}
	
	/** Adds the JButtons to the buttonPanel.
	 * 	Adds tool tips to both buttons and adds the ActionListener to the quit button. 
	 * 
	 * @param buttonPanel The specific panel the buttons will belong to.
	 * @param encrypt The encryption JButton.
	 * @param quit The quit JButton.
	 */
	private void createButtons(JPanel buttonPanel, JButton encrypt, JButton decrypt ,JButton quit){
		buttonPanel.add(encrypt);
		encrypt.setToolTipText("Encrypts the current input text.");
		buttonPanel.add(decrypt);
		decrypt.setToolTipText("Decrypts the current output text.");
		buttonPanel.add(quit);
		quit.setToolTipText("Quits the program.");
		quit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int quit = JOptionPane.showConfirmDialog(mainframe,"Are you sure you want to quit?", "Quit?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(quit == 0){
					System.exit(0);
				}
			}
		});
	}
	
	/** Creates the tab for the Atbash display.
	 * <p>Additionally creates action listeners for the encrypt and decrypt button.
	 */
	private void createAtbashDisplay(){
		Atbash atbash = new Atbash();
		atbashPanel = new JPanel(new BorderLayout());
		JPanel atbashIO = new JPanel(new BorderLayout());
		JPanel atbashInput = new JPanel(new BorderLayout());
		JPanel atbashOutput = new JPanel(new BorderLayout());
		JPanel buttonPanel = new JPanel(new FlowLayout());
		JLabel atbashExplanation = new JLabel("Substitutes 'A' for 'Z', 'B' for 'Y', 'C' for 'X' ect.");
		JTextArea atbashInputBox = new JTextArea("Input");
		atbash.encrypt(atbashInputBox.getText());
		JTextArea atbashOutputBox = new JTextArea(atbash.getEncryptedWord());
		JButton encryptButton = new JButton("Encrypt"); 
		JButton decryptButton = new JButton("Decrypt");
		JButton quitButton = new JButton("Quit");
		atbashOutputBox.setEditable(false);
		atbashInputBox.setRows(3);
		atbashOutputBox.setRows(3);
		
		atbashPanel.add(atbashExplanation, BorderLayout.NORTH);
		
		atbashIO.add(atbashInput, BorderLayout.NORTH);
		atbashInput.add(inputHeader, BorderLayout.NORTH);
		atbashInput.add(atbashInputBox, BorderLayout.CENTER);
		
		atbashIO.add(atbashOutput, BorderLayout.CENTER);
		atbashOutput.add(outputHeader, BorderLayout.NORTH);
		atbashOutput.add(atbashOutputBox, BorderLayout.CENTER);
				
		atbashPanel.add(atbashIO, BorderLayout.CENTER);
		
		createButtons(buttonPanel, encryptButton, decryptButton, quitButton);
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
		atbashPanel.add(buttonPanel, BorderLayout.SOUTH);
	}

	
}