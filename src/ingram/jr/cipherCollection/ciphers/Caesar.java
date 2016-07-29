package ingram.jr.cipherCollection.ciphers;

public class Caesar extends Cipher {
	private int key;
	
	public Caesar(){
		super();
		key = 1;
	}

	@Override
	public void encrypt(String word) {
		StringBuilder sb = new StringBuilder("");
		try{
			setWordCharacters(word.toUpperCase());
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

	@Override
	public void decrypt(String wordToBeDecrypted){
		setKey(26-key);
		encrypt(wordToBeDecrypted);
	}
	
	public void setKey(int key){
		this.key = key;
	}
	
	public int getKey(){
		return key;
	}

}
