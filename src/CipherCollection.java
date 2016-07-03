import java.util.Scanner;

public class CipherCollection {
	private static Atbash a;
	private static Caesar c;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		CollectionGUI gui = new CollectionGUI();
		a = new Atbash();
		c = new Caesar();
		System.out.print("What word would you like to encrypt?\n> ");
		String word = input.nextLine();
		a.encrypt(word);
		System.out.println("Encrytpion: " + a.getEncryptedWord().toUpperCase());
	}

}
