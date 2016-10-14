package ingram.jr.cipherCollection.ciphers;


//TODO Add checks for stringToChar!

public class XOR extends Cipher{
	
	private static Character[] keyCharacters;
	
	public XOR(){
		super();
	}
		
	@Override
	public void encrypt(String word) {
		Character[] wordCharacters = stringToCharArray(word);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < wordCharacters.length; i++){
			char wordChar = wordCharacters[i];
			String encryptedChar = Integer.toBinaryString(wordChar ^ keyCharacters[i]);
			while(encryptedChar.length() != 7){
				encryptedChar = "0" + encryptedChar;
			}
			sb.append(encryptedChar + " ");
		}
		encryptedWord = sb.toString();
	}

	@Override
	public void decrypt(String wordToBeDecrypted) {
		String[] binaryLetters = wordToBeDecrypted.split(" ");
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < binaryLetters.length; i++){	
			Integer keyCharacter = (int) keyCharacters[i];
			String keyCharacterBinaryString = Integer.toBinaryString(keyCharacter);
			String decryptedVal = XOROperation(binaryLetters[i].toString(), keyCharacterBinaryString);
			Character decryptedChar = (char) binaryToDecimal(decryptedVal);
			sb.append(decryptedChar);
		}
		encryptedWord = sb.toString();
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
	
	/**
	 * Performs an XOR between two binary Strings. 
	 * @param binaryOne
	 * @param binaryTwo
	 * @return
	 */
	private String XOROperation(String binaryOne, String binaryTwo){
		StringBuilder xorResult = new StringBuilder();
		try{
			//Checks if the two parameters are strings of the same length.
			if(binaryOne.length() == binaryTwo.length()){
				String[] binaryOneCharacters = binaryOne.split("");
				String[] binaryTwoCharacters = binaryTwo.split("");
				
				for(int i = 0; i < binaryOne.length(); i++){
					//Checks if the strings only contain 1s and 0s and assigns XOR operation. 
					if((binaryOneCharacters[i].equals("0") || binaryOneCharacters[i].equals("1")) && (binaryTwoCharacters[i].equals("0") || binaryTwoCharacters[i].equals("1"))){
						//If characters are the same: append 0; else append 1.
						if(binaryOneCharacters[i].equals(binaryTwoCharacters[i])){
							xorResult.append("0");
						}else{
							xorResult.append("1");
						}
					}else{
						throw new IllegalArgumentException("Inputs must consist of only 0s and 1s!");
					}	
				}
			}else{
				throw new IllegalArgumentException("Inputs must be the same length!");
			}
			
		}catch(Exception e){
			System.out.println(e.getMessage());
			xorResult.append("0000000");
		}
		return xorResult.toString();
	}
	
	/** Converts a binary string to a decimal double.
	 * 
	 * @param binaryString A string of binary characters.
	 * @return
	 */
	
	private int binaryToDecimal(String binaryString){
		String[] binaryCharacters = binaryString.split("");
		Double decimalValue = new Double(0);
		int powerCounter = 0;
		for(int i = binaryCharacters.length - 1; i >= 0; i--){
			if(binaryCharacters[i].equals("1")){
				decimalValue = decimalValue + (Math.pow(2, powerCounter));
			}
			powerCounter++;
		}
		return decimalValue.intValue();
	}

}
