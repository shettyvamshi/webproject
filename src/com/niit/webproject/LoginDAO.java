package com.niit.webproject;

public class LoginDAO{
	
	public boolean isValidUser(String userid , String password){
		
		if(userid.equals(password)){
			return true;
		}
		else{
			return false;
			
		}
	}
}
	


