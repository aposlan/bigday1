package password_generator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.regex.Matcher;

public class PasswordGenerator {

	private static ArrayList<Password> passwords = new ArrayList<>();

	static Matcher matcher;

	protected static ArrayList<Password> getPasswords() {
		return passwords;
	}

	public static void main(String[] args) throws IOException {

		/*
		 * 
		 * ALTHOUGH THE SECOND WAY SEEMS WAY FASTER AND EASIER, -> WHICH IT IS, THE
		 * PASSWORD ITSELF ISN'T AS STRONG AND AS -> "RANDOM" AS THE FIRST WAY OF
		 * GENERATING A PASSWORD.
		 * 
		 */

		final ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(Constants.FILE_PATH));

		final int passwordsToGenerate = Constants.SCANNER.nextInt();

		// 1ST WAY OF GENERATING A RANDOM PASSWORD

		ArrayList<String> chars = new ArrayList<>();
		chars.add(Constants.LOWER);
		chars.add(Constants.UPPER);
		chars.add(Constants.DIGITS);
		chars.add(Constants.SPECIAL_SYMBOLS);
		Password password;

		for (int i = 0; i < passwordsToGenerate/2; i++) {
			String pass = "";
			matcher = Constants.PATTERN.matcher(pass);
			while (!matcher.matches()) {
				pass = "";
				for (int j = 0; j < 12; j++) {
					String charCattegory = chars.get(Constants.RANDOM.nextInt(chars.size()));
					pass += charCattegory.charAt(Constants.RANDOM.nextInt(charCattegory.length()));
				}
			}

			password = new Password(pass);

			if (password.isUnique()) {
				try {
					writer.writeObject(password);
					System.out.println("Successfully written password! :)");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		// 2ND WAY OF GENERATING A RANDOM PASSWORD

		for (int i = 0; i < Math.ceil((double) passwordsToGenerate / 2); i++) {
			String pass = "";
			matcher = Constants.PATTERN.matcher(pass);
			while (!matcher.matches()) {
				pass = "";
				for (int j = 0; j < 12; j++)
					pass += Constants.CHARACTERS.charAt(Constants.RANDOM.nextInt(Constants.CHARACTERS.length()));
			}

			password = new Password(pass);

			if (password.isUnique()) {
				try {
					writer.writeObject(password);
					System.out.println("Successfully written password! :)");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		Constants.SCANNER.close();
		writer.close();

	}

}