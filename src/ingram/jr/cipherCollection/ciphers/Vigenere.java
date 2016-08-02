package ingram.jr.cipherCollection.ciphers;

import java.util.HashMap;
public class Vigenere extends Cipher{

	private HashMap<String, Integer> characterValues;
	private String[] keyCharacters;

	public Vigenere(){
		characterValues = new HashMap<String, Integer>();
		for(int i = 0; i < alphabet.length; i++){
			characterValues.put(alphabet[i], i);
		}
	}

	//Ci = Ti + Ki mod 26
	@Override
	public void encrypt(String word) {
		StringBuilder sb = new StringBuilder("");
		setWordCharacters(word.toUpperCase());
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
		System.out.println(encryptedWord);
	}

	@Override
	public void decrypt(String wordToBeDecrypted) {
		// TODO Auto-generated method stub

	}

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
