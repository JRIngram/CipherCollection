package ingram.jr.cipherCollection.ciphers;

/**Atbash cipher which encrypted by reversing the alphabet, such that A = Z, B = Y, C = X ect.
 * 
 * @author JRIngram
 * @version 1.0.0
 * @see Cipher
 *
 */
public class Atbash extends Cipher {
	private String[] reverseAlphabet;
	
	/**Creates instance of Atbash cipher and fills reverse alphabet array.
	 * 	
	 */
	public Atbash(){
		super();
		reverseAlphabet = new String[26];
		//Sets the reverse alphabet.
		int reverseCount = 0;
		for(int i = 25; i >= 0; i--){
			reverseAlphabet[reverseCount] = getAlphabetLetter(i);	
			reverseCount++; 
		}
	}
	
	/**Encrypts the plaintext by reversing the letters.
	 * @param word The plaintext that is going to be encrypted.
	 */
	@Override
	public void encrypt(String word){
		StringBuilder sb = new StringBuilder();
		setWordCharacters(word.toUpperCase());
		for(int i = 0; i < wordCharacters.length; i++){
			boolean matched = false;
			for(int c = 0; c < alphabet.length; c++){
				if(wordCharacters[i].equals(getAlphabetLetter(c).toUpperCase())){
					sb.append(reverseAlphabet[c]);
					matched = true;
					break;
				}
			}
			if(!matched){
				sb.append(wordCharacters[i]);
			}
		}
		encryptedWord = sb.toString();
	}
	
	/**Decrypts the ciphertext.
	 * Due to Atbash's relative ease, it is simply decrypted in the same way the words are encrypted.
	 * 
	 * @param encryptedWord The ciphertext that is being decrypted.
	 */
	
	@Override
	public void decrypt(String encryptedWord){
		encrypt(encryptedWord);
	}
	
}