package ingram.jr.cipherCollection.gui;
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
	private JTabbedPane tabs;
	private JFrame mainframe;
	private AtbashTab atbashPanel;
	
	/** Constructs GUI with tabs for each of the developed ciphers.
	 * <p>Currently these Ciphers include:</p>
	 * <ul>
	 * 	<li>Atbash</li>
	 * </ul>
	 */
	public CollectionGUI(){
		mainframe = new JFrame("Cipher Collection\t0.1.1");
		tabs = new JTabbedPane();
		mainframe.setDefaultCloseOperation(0);
		atbashPanel = new AtbashTab();
		//createAtbashDisplay();
		tabs.add("Atbash", atbashPanel.getTab());
		mainframe.add(tabs);
		mainframe.pack();
		mainframe.setVisible(true);
	}
	

	
}