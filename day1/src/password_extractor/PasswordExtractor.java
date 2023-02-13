package password_extractor;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class PasswordExtractor {

	final static List<password_generator.Password> passwords = readPasswords();

	public static void main(String[] args) {System.out.println(passwords);}

	static List<password_generator.Password> readPasswords() {
		List<password_generator.Password> passwords = new ArrayList<>();

		ObjectInputStream reader = null;

		password_generator.Password password;

		System.out.println("------------");
		int inc = 1;
		try {
			reader = new ObjectInputStream(new FileInputStream(
					"C:\\Users\\FoxMulder\\eclipse-workspace\\day1\\src\\password_generator\\passwords.ser"));
			while ((password = (password_generator.Password) reader.readObject()) != null) {
				passwords.add((password_generator.Password) password);
				System.out.println(inc + " password");
				System.out.println((password_generator.Password) password);
				System.out.println("------------");
				inc++;
			}
		} catch (IOException | ClassNotFoundException e) {

		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return passwords;
	}

}
