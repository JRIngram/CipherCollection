package ingram.jr.cipherCollection;
import ingram.jr.cipherCollection.gui.AtbashTab;
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
	
	/** Displays and constructs GUI with tabs for each of the developed ciphers.
	 */
	public CollectionGUI(){
		mainframe = new JFrame("Cipher Collection\t0.1.2");
		tabs = new JTabbedPane();
		atbashTab = new AtbashTab();
		mainframe.setDefaultCloseOperation(0);
		tabs.add("Atbash", atbashTab.getTab());
		mainframe.add(tabs);
		mainframe.pack();
		mainframe.setVisible(true);
	}

}