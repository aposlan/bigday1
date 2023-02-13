package password_extractor;

import java.io.Serializable;
import java.util.ArrayList;

import password_generator.Constants;
import password_generator.PasswordGenerator;

public class Password extends PasswordGenerator implements Serializable {

	private static final long serialVersionUID = 161119192315184L;

	private final String password;
	transient static final ArrayList<password_generator.Password> passwords = PasswordGenerator.getPasswords();

	Password(String password) {
		this.password = password;
	}

	private String getPassword() {
		return password;
	}

	boolean matches() {
		return password.matches(Constants.REGEX);
	}

	boolean isUnique() {
		for (password_generator.Password pass : PasswordGenerator.getPasswords())
			if (getPassword().equals(pass.getPassword()))
				return false;
		return true;
	}

	@Override
	public String toString() {
		return password;
	}

}
