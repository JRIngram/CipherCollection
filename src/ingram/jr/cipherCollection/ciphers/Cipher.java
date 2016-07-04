package ingram.jr.cipherCollection.ciphers;

public abstract class Cipher {
	protected final String[] alphabet;
	protected String[] wordCharacters; 
	protected String encryptedWord;
	
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
	
	public abstract void encrypt(String word);
	
	public abstract void decrypt(String encryptedWord);
	
	//Splits the words into individual characters.
	public void setWordCharacters(String word){
			wordCharacters = word.split("");		
	}
	
	//Returns a specified letter from the alphabet
	public String getAlphabetLetter(int index){
		return alphabet[index];
	}
	
	//Returns encrypted word.
	public String getEncryptedWord(){
		return encryptedWord; 
	}
	
	//Sets the encrypted word.
	public void setEncryptedWord(String encryptedWord){
		this.encryptedWord = encryptedWord;
	}
}