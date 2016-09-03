package ingram.jr.cipherCollection.ciphers;

import java.util.HashMap;


/**Each letter in the key is given a value (A: 1, B: 2) ect. The plaintext is then encrypted by: Ci = (Pi + Li) % 26. 
 * Ci represents ciphertext letter.
 * Pi represents plaintext letter.
 * Ki represents key letter (wraps around if word longer than key).
 * 
 * @author JRIngram
 * @version 1.0.0
 * @since 0.3.0
 * @see Cipher
 *
 */
public class Vigenere extends Cipher{

	private HashMap<String, Integer> characterValues;
	private String[] keyCharacters;

	public Vigenere(){
		characterValues = new HashMap<String, Integer>();
		for(int i = 0; i < alphabet.length; i++){
			characterValues.put(alphabet[i], i);
		}
	}
	
	/** Encrypts the plaintext.
	 *  NOTE: Although non-alphabetical characters aren't shifted, the position of the key will move as if it had been. e.g. "A@B" with key: "Ab" would be encrypted to "A@B"
	 *   
	 *  @param word The plaintext to be encrypted.
	 */
	@Override
	public void encrypt(String word) {
		StringBuilder sb = new StringBuilder("");
		setWordCharacters(word);
		for(int i = 0; i < wordCharacters.length; i++){
			if(wordCharacters[i].matches("[a-zA-Z]")){
				Integer val = (characterValues.get(wordCharacters[i]) + (characterValues.get(keyCharacters[i % keyCharacters.length]))) % 26;
				for(HashMap.Entry<String, Integer> letterValuePair : characterValues.entrySet()){
					if(val.equals(letterValuePair.getValue())){
						sb.append(letterValuePair.getKey());
					}
				}
			}else{
				sb.append(wordCharacters[i]);
			}
		}
		encryptedWord = sb.toString();
	}
	
	/**Decrypts the ciphertext.
	 * NOTE: Although non-alphabetical characters aren't shifted, the position of the key will move as if it had been. e.g. "A@B" with key: "Ab" would be decrypted to "A@B"
	 *   
	 *  @param word The ciphertext to be encrypted.
	 */
	@Override
	public void decrypt(String wordToBeDecrypted) {
		StringBuilder sb = new StringBuilder("");
		setWordCharacters(wordToBeDecrypted.toUpperCase());
		for(int i = 0; i < wordCharacters.length; i++){
			if(wordCharacters[i].matches("[a-zA-z]")){
				Integer val = (characterValues.get(wordCharacters[i]) + (26 - (characterValues.get(keyCharacters[i % keyCharacters.length])))) % 26;
				for(HashMap.Entry<String, Integer> letterValuePair : characterValues.entrySet()){
					if(val.equals(letterValuePair.getValue())){
						sb.append(letterValuePair.getKey());
					}
				}
			}else{
				sb.append(wordCharacters[i]);
			}
		}
		encryptedWord = sb.toString();
	}
	
	/**Sets the characters in KeyCharacters array to allow proper encryption/decryption.
	 * 
	 * @param key The key to encrypt or decrypt with.
	 * @throws IllegalArguementException If the key contains no alphabetical character. Key defaults to "A".
	 */
	public void setKeyCharacters(String key){
		keyCharacters = key.toUpperCase().split("");
		try{
			for(String character : keyCharacters){
				if(!character.matches("[a-zA-Z]") || key == null){
					throw new IllegalArgumentException();
				}
			}
		}catch(IllegalArgumentException e){
			String defaultKey = "a";
			System.out.println("Illegal key set! Key defaults to 'A'.");
			keyCharacters = defaultKey.toUpperCase().split("");
		}
	}
}

