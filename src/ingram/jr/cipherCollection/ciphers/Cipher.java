package ingram.jr.cipherCollection.ciphers;

/**Abstract superclass for ciphers.
 * 
 * @author JRIngram
 * @version 1.0.0
 * @since 0.1.0
 */
public abstract class Cipher {
	protected final String[] alphabet;
	protected String[] wordCharacters; 
	protected String encryptedWord;
	
	/**Fills the alphabet array with the relevant capital letters.
	 * 
	 */
	public Cipher(){
		alphabet = new String[26];
		alphabet[0]  = "A";
		alphabet[1]  = "B";
		alphabet[2]  = "C";
		alphabet[3]  = "D";
		alphabet[4]  = "E";
		alphabet[5]  = "F";
		alphabet[6]  = "G";
		alphabet[7]  = "H";
		alphabet[8]  = "I";
		alphabet[9]  = "J";
		alphabet[10]  = "K";
		alphabet[11]  = "L";
		alphabet[12]  = "M";
		alphabet[13]  = "N";
		alphabet[14]  = "O";
		alphabet[15]  = "P";
		alphabet[16]  = "Q";
		alphabet[17]  = "R";
		alphabet[18]  = "S";
		alphabet[19]  = "T";
		alphabet[20]  = "U";
		alphabet[21]  = "V";
		alphabet[22]  = "W";
		alphabet[23]  = "X";
		alphabet[24]  = "Y";
		alphabet[25]  = "Z";
	}
	
	/**Abstract method to encrypt the desired string.
	 * 
	 * @param word The word to be encrypted
	 */
	public abstract void encrypt(String word);
	
	/**Abstract method to decrypt the desired string.
	 * 
	 * @param wordToBeDecrypted The word to be encrypted
	 */
	
	public abstract void decrypt(String wordToBeDecrypted);
	
	/**Splits the words into individual characters.
	 * 
	 * @param word The word are encrypting.
	 */
	public void setWordCharacters(String word){
			word = word.toUpperCase();
			wordCharacters = word.split("");		
	}
	
	/**Returns encrypted word.
	 * 
	 * @return The word we've previously encrypted.
	 */
	public String getEncryptedWord(){
		return encryptedWord; 
	}
	
}