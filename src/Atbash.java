
public class Atbash extends Cipher {
	private String[] reverseAlphabet;
	
	public Atbash(){
		super();
		reverseAlphabet = new String[26];
		setReverseAlphabet();
	}
	
	public void encrypt(String word){
		StringBuilder sb = new StringBuilder();
		setWordCharacters(word);
		for(int i = 0; i < wordCharacters.length; i++){
			System.out.print(wordCharacters[i]);
			for(int c = 0; c < alphabet.length; c++){
				if(wordCharacters[i].equals(getAlphabetLetter(c))){
					sb.append(getReverseAlphabetLetter(c));
					System.out.println(" = " + getReverseAlphabetLetter(c));
					break;
				}
				else{
					sb.append("");
				}
			}
		}
		setEncryptedWord(sb.toString());
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
