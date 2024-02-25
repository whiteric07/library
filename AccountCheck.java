package controller;

import java.util.HashMap;
import controller.User;

public class AccountCheck {

		public boolean checkAccountNameExistence(String inputAccountName,
				HashMap<String, User> hashMap) {

			if (hashMap == null)
				return false;

			if (hashMap.containsKey(inputAccountName))
				return true;
			else
				return false;

		}
		
		public boolean checkPassword(String inputAccountName, String inputPassword,
				HashMap<String, User> hashMap) {

			if (hashMap == null)
				return false;

			User user = hashMap.get(inputAccountName);

			String passwordOnRecord = user.getPassword();
			if (inputPassword.equals(passwordOnRecord))
				return true;
			else
				return false;

		}

		public User addNewUser(String accountName,
				String password, HashMap<String, User> hashMap) {

			User user = new User();
			user.setAccountName(accountName);
			user.setPassword(password);

			hashMap.put(accountName, user);
			
			return user;
		}
		
	}
