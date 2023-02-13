package password_generator;

import java.io.Serializable;
import java.util.ArrayList;

public class Password extends PasswordGenerator implements Serializable {

	private static final long serialVersionUID = 161119192315184L;

	private final String password;
	transient static final ArrayList<Password> passwords = PasswordGenerator.getPasswords();

	Password(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	boolean matches() {
		return getPassword().matches(Constants.REGEX);
	}

	boolean isUnique() {
		for (Password pass : PasswordGenerator.getPasswords())
			if (getPassword().equals(pass.getPassword()))
				return false;
		return true;
	}

	@Override
	public String toString() {
		return password;
	}

}
