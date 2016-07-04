package ingram.jr.cipherCollection.ciphers;

public class Atbash extends Cipher {
	private String[] reverseAlphabet;
	
	public Atbash(){
		super();
		reverseAlphabet = new String[26];
		setReverseAlphabet();
	}
	
	public void encrypt(String word){
		StringBuilder sb = new StringBuilder();
		setWordCharacters(word.toUpperCase());
		for(int i = 0; i < wordCharacters.length; i++){
			boolean matched = false;
			for(int c = 0; c < alphabet.length; c++){
				if(wordCharacters[i].equals(getAlphabetLetter(c).toUpperCase())){
					//Isn't being called! Workout pls!
					sb.append(getReverseAlphabetLetter(c));
					matched = true;
					break;
				}
			}
			if(!matched){
				sb.append(wordCharacters[i]);
			}
		}
		setEncryptedWord(sb.toString());
	}
	
	public void decrypt(String encryptedWord){
		encrypt(encryptedWord);
	}
	
	public void setReverseAlphabet(){
		int reverseCount = 0;
		for(int i = 25; i >= 0; i--){
			reverseAlphabet[reverseCount] = getAlphabetLetter(i);	
			reverseCount++; 
		}
	}
	
	public String getReverseAlphabetLetter(int index){
		return reverseAlphabet[index];
	}
}