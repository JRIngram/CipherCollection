package ingram.jr.cipherCollection.ciphers;


//TODO Add checks for stringToChar!
public class XOR extends Cipher{
	
	private static Character[] keyCharacters;
	
	public XOR(){
		super();
		//TESTING
		setKey("Hello");
		for(char keyChar : keyCharacters){
			System.out.println(keyChar);
		}
		encrypt("apple");
	}
		
	@Override
	public void encrypt(String word) {
		Character[] wordCharacters = stringToCharArray(word);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < wordCharacters.length; i++){
			char wordChar = wordCharacters[i];
			char keyChar = keyCharacters[i];
			String encryptedChar = Integer.toBinaryString(wordChar ^ keyChar);
			while(encryptedChar.length() != 8){
				encryptedChar = "0" + encryptedChar;
			}
			sb.append(encryptedChar + " ");
		}
		encryptedWord = sb.toString();
	}

	@Override
	public void decrypt(String wordToBeDecrypted) {
		// TODO Auto-generated method stub
		
	}
	
	public void setKey(String key){
		keyCharacters = stringToCharArray(key);
	}
	
	/**Converts a String into a Character array.
	 * 
	 * @param word The String to be converted into a Character array
	 * @return A Character array with each index representing a different letter in the parameter.
	 * @throws IllegalArgumentException If the word parameter contains characters that are not letters.
	 */
	private Character[] stringToCharArray(String word) throws IllegalArgumentException{
		Character[] stringCharacters = new Character[word.length()];
		String[] charsToCheck = word.toUpperCase().split("");
		try{
			for(int i = 0; i < word.length(); i++){
				if(!charsToCheck[i].matches("[a-zA-Z]")){
					throw new IllegalArgumentException("The String must be alphabetical only!");
				}else{
					stringCharacters[i] = word.toUpperCase().charAt(i);
				}
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
			for(int i = 0; i < word.length(); i++){
				stringCharacters[i] = 'a';
			}
		}finally{
			return stringCharacters;
		}
	} 

}
