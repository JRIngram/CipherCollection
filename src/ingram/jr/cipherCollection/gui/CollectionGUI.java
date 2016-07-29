package ingram.jr.cipherCollection.gui;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;


/** User interface for the cipher collection.
 * 
 *  @author JRIngram
 *
 */

public class CollectionGUI{
	private JTabbedPane tabs;
	private JFrame mainframe;
	private AtbashTab atbashTab;
	private CaesarTab caesarTab;
	
	/** Constructs GUI with tabs for each of the developed ciphers.
	 * <p>Currently these Ciphers include:</p>
	 * <ul>
	 * 	<li>Atbash</li>
	 *  <li>Caesar</li>
	 * </ul>
	 */
	public CollectionGUI(){
		mainframe = new JFrame("Cipher Collection\tV0.2.0");
		tabs = new JTabbedPane();
		mainframe.setDefaultCloseOperation(0);
		atbashTab = new AtbashTab();
		caesarTab = new CaesarTab();
		tabs.add("Atbash", atbashTab.getTab());
		tabs.add("Caesar", caesarTab.getTab());
		mainframe.add(tabs);
		mainframe.pack();
		mainframe.setVisible(true);
	}
	

	
}