package password_generator;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public final class Constants {

	public static final String REGEX = "^(?=.*[A-Za-z])(?=.*\\\\d)(?=.*[$&+,:;=?@#|'<>.-^*()%!])[A-Za-z\\\\d$&+,:;=?@#|'<>.-^*()%!]{8,}$";

	public static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
	public static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String DIGITS = "0123456789";
	public static final String SPECIAL_SYMBOLS = "!@#$%&*()_+-=[]|,./?><";

	public static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%&*()_+-=[]|,./?><0123456789abcdefghijklmnopqrstuvwxyz";
	
	public static final String FILE_PATH = "C:\\Users\\FoxMulder\\eclipse-workspace\\day1\\src\\password_generator\\passwords.ser";
	
	public static final Scanner SCANNER = new Scanner(System.in);
	
	public static final Random RANDOM = new Random();

	public static final Pattern PATTERN = Pattern.compile(Constants.REGEX);

}
