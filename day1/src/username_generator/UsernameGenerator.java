package username_generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class UsernameGenerator {

	static final List<String> USERNAMES = new ArrayList<>();
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		String email = "";
		
		while(email!="break"){
			email = s.nextLine();
			System.out.println(usernameGenerator(email));
		}
		
		s.close();
		
	}
	
	static String usernameGenerator(String email) {
		
		String username = email.split("@")[0].toLowerCase();
		
		Random rand = new Random();
		
		if(!USERNAMES.contains(email.split("@")[0])) {
			USERNAMES.add(username);
			return username;
		}
		username += rand.nextInt(1024);
		while(USERNAMES.contains(username))
			username = email.split("@")[0].toLowerCase() + rand.nextInt();
		return username;
		
	}
	
}
