package controller;

import java.io.Serializable;

	public class User implements Serializable{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String accountName;
		private String password;
		
		public String getAccountName() {
			return accountName;
		}
		public void setAccountName(String accountName) {
			this.accountName = accountName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
	}
	
