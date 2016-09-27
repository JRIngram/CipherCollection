package ingram.jr.cipherCollection.gui;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;


/** User interface for the cipher collection.
 * 
 *  @author JRIngram
 *	@version 1.0.0
 *	@since 0.1.0
 */

public class CollectionGUI{
	private JTabbedPane tabs;
	private JFrame mainframe;
	private AtbashTab atbashTab;
	private CaesarTab caesarTab;
	private VigenereTab vigenereTab;
	private XORTab xorTab;
	
	/** Constructs GUI with tabs for each of the developed ciphers.
	 * <p>Currently these Ciphers include:</p>
	 * <ul>
	 * 	<li>Atbash</li>
	 *  <li>Caesar</li>
	 *  <li>Vigenere</li>
	 * </ul>
	 */
	public CollectionGUI(){
		mainframe = new JFrame("Cipher Collection\tV0.3.1");
		mainframe.setMinimumSize(new Dimension(500,380));
		tabs = new JTabbedPane();
		mainframe.setDefaultCloseOperation(0);
		atbashTab = new AtbashTab();
		caesarTab = new CaesarTab();
		vigenereTab = new VigenereTab();
		xorTab = new XORTab();
		tabs.add("Atbash", atbashTab.getTab());
		tabs.add("Caesar", caesarTab.getTab());
		tabs.add("Vigenere", vigenereTab.getTab());
		tabs.add("XOR", xorTab.getTab());
		mainframe.add(tabs);
		mainframe.pack();
		mainframe.setVisible(true);
	}
	

	
}