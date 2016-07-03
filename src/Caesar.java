import java.util.Scanner;
public class Caesar extends Cipher {
	
	private Scanner input;
	int shift;
	public Caesar(){
		super();
		input = new Scanner(System.in); 
	}
	
	public void encrypt(String word) {
		StringBuilder sb = new StringBuilder();
		setWordCharacters(word);
		setShift();
		for(int i = 0; i < wordCharacters.length; i++){
			for(int c = 0; c <= alphabet.length; c++){
				if(wordCharacters[i].equals(alphabet[c])){
					int newIndex = c + shift % 26;
					sb.append(alphabet[newIndex]);
				}
			}
		}
		setEncryptedWord(sb.toString());
	}
	
	public void setShift(){
		System.out.print("How much would you like to shift the word by?\n> ");
		shift = input.nextInt();
		if(shift <= 0){
			System.out.println("The shift must be an integer above 0!");
			setShift();
		}
	}

}
