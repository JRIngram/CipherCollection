import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class CollectionGUI {
	//Relevant to all sections.
	private JTabbedPane tabs;
	private JFrame mainframe;
	private JLabel inputHeader;
	private JLabel outputHeader;
	private JPanel buttonPanel;
	private JButton	encryptButton;
	private JButton quitButton;
	private JPanel atbashPanel;
	
	public CollectionGUI(){
		mainframe = new JFrame("Cipher Collection");
		buttonPanel = new JPanel(new FlowLayout());
		inputHeader = new JLabel("Input:");
		outputHeader = new JLabel("Output:");
		encryptButton = new JButton("Encrypt");
		quitButton = new JButton("Quit");
		buttonPanel.add(encryptButton);
		buttonPanel.add(quitButton);
		tabs = new JTabbedPane();
		createAtbashDisplay();
		tabs.add("Atbash", atbashPanel);
		mainframe.add(tabs);
		mainframe.pack();
		mainframe.setVisible(true);
	}
	
	//Creates the tab for the Atbash display
	private void createAtbashDisplay(){
		//Atbash
		atbashPanel = new JPanel(new BorderLayout());
		JPanel atbashIO = new JPanel(new BorderLayout());
		JPanel atbashInput = new JPanel(new BorderLayout());
		JPanel atbashOutput = new JPanel(new BorderLayout());
		JLabel atbashExplanation = new JLabel("Substitutes 'A' for 'Z', 'B' for 'Y', 'C' for 'X' ect.");
		JTextArea atbashInputBox = new JTextArea("Input");
		JTextArea atbashOutputBox = new JTextArea("rmkfg");
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
		atbashPanel.add(buttonPanel, BorderLayout.SOUTH);
	}

	
}
