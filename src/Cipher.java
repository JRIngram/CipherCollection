
public abstract class Cipher {
	protected final String[] alphabet;
	protected String[] wordCharacters; 
	protected String encryptedWord;
	
	public Cipher(){
		alphabet = new String[26];
		alphabet[0]  = "a";
		alphabet[1]  = "b";
		alphabet[2]  = "c";
		alphabet[3]  = "d";
		alphabet[4]  = "e";
		alphabet[5]  = "f";
		alphabet[6]  = "g";
		alphabet[7]  = "h";
		alphabet[8]  = "i";
		alphabet[9]  = "j";
		alphabet[10]  = "k";
		alphabet[11]  = "l";
		alphabet[12]  = "m";
		alphabet[13]  = "n";
		alphabet[14]  = "o";
		alphabet[15]  = "p";
		alphabet[16]  = "q";
		alphabet[17]  = "r";
		alphabet[18]  = "s";
		alphabet[19]  = "t";
		alphabet[20]  = "u";
		alphabet[21]  = "v";
		alphabet[22]  = "w";
		alphabet[23]  = "x";
		alphabet[24]  = "y";
		alphabet[25]  = "z";
	}
	
	public abstract void encrypt(String word);
	
	//Splits the words into individual characters.
	public void setWordCharacters(String word){
			word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
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
