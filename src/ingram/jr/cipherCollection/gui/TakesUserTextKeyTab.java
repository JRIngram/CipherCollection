package ingram.jr.cipherCollection.gui;

import java.awt.Color;

import javax.swing.JLabel;

public class TakesUserTextKeyTab extends Tab {
	
	public TakesUserTextKeyTab(){
		super();
	}
	
	/** Changes colour of PQExplanation and if the Encrypt/Decrypt buttons are enables based on the values of P and Q.
	 * Deactivates the buttons and changes PQExplanation to red if PQ are not prime.
	 * Changes PQExplanation to black and reactivates the buttons if prime.
	 * 
	 * @param The result of the enforced check.
	 * @param The label which prompts to user.
	 * @return Result of the check.
	 */
	public boolean enforceCheckValues(boolean checkResult, JLabel checkLabel){
		if(checkResult){
			changeLabelToRed(false, checkLabel);
			setButtonEnabled(true);
			return true;
		}else{
			changeLabelToRed(true, checkLabel);
			setButtonEnabled(false);
			return false;
		}
	}
	
	/**Sets if the Encrypt and Decrypt buttons are enabled.
	 * 
	 * @param buttonEnabled
	 */
	public void setButtonEnabled(boolean buttonEnabled){
		if(buttonEnabled){
			encryptButton.setEnabled(true);
			decryptButton.setEnabled(true);
		}
		else{
			encryptButton.setEnabled(false);
			decryptButton.setEnabled(false);
		}
	}
	
	
	/**Changes the colour of the label depending on the boolean parameter 
	 * If the parameter is true, and the label is red, the label turns to black.
	 * Else, if the parameter is false, and the label is black, the label turns to red. 
	 * @param correctInputs A boolean value to choose whether to set label to red or not (which turns label to black).
	 */
	private void changeLabelToRed(boolean changeToRed, JLabel label){
		if(changeToRed){
			if(label.getForeground().equals(Color.BLACK)){
				label.setForeground(Color.RED);
			}
		}
		else{ 
			if(label.getForeground().equals(Color.RED)){
				label.setForeground(Color.BLACK);
			}
		}
	}
}
