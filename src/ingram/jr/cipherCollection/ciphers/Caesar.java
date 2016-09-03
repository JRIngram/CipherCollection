package ingram.jr.cipherCollection.ciphers;

/**Caesar Shift cipher, which shifts all letters in the plaintext by the key amount.
 * e.g. If key: 1, and plaintext is "abc", the ciphertext will be "bcd". 
 * e.g. If key: 25, and plaintext is "abc", the ciphertext will be "zab".
 * @author JRIngram
 * @version 1.0.0
 * @since 0.2.0
 * @see Cipher
 *
 */

public class Caesar extends Cipher {
	private int key;
	
	/**Constructs caesar cipher with default key of 1.
	 * 
	 */
	public Caesar(){
		super();
		key = 1;
	}
	
	/** Encrypts the plaintext by shifting each letter in the plaintext by key.
	 *  @param word The plaintext that the cipher will shift.
	 */

	@Override
	public void encrypt(String word) {
		StringBuilder sb = new StringBuilder("");
		try{
			setWordCharacters(word);
			for(int i = 0; i < wordCharacters.length; i++){
				boolean matched = false;
				for(int c = 0; c < alphabet.length; c++){
					if(wordCharacters[i].equals(alphabet[c])){
						sb.append(alphabet[(c + key) % alphabet.length]);
						matched = true;
					}
				}
				if(!matched){
					sb.append(wordCharacters[i]);
				}
			}
		}
		catch(ArrayIndexOutOfBoundsException e){
			sb.append("Key must be a positive number!");
		}
		finally{
			encryptedWord = sb.toString();		
		}

	}
	
	
	/** Decrypts the ciphertext by shifting each letter in the ciphertext by 26-key.
	 *  @param wordToBeDecrypted The ciphertext to be decrypted
	 *
	 */
	@Override
	public void decrypt(String wordToBeDecrypted){
		setKey(26-key);
		encrypt(wordToBeDecrypted);
	}
	
	/**Sets the key for the plaintext to be shift by or ciphertext to be decrypted by.
	 * 
	 * @param key Value of the key to encrypt/decrypt by.
	 */
	
	public void setKey(int key){
		this.key = key;
	}
	
	/** Returns the value of the current key.
	 * 
	 * @return Value of the current key
	 */
	public int getKey(){
		return key;
	}

}
