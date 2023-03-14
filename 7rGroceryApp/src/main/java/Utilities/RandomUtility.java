package Utilities;

import java.math.BigInteger;
import java.util.Random;

public class RandomUtility {

	public int randomnumbers() {
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(10000);
		return randomInt;
	}

	public String randomPassword() {

		String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lower = "abcdefghijklmnopqrstuvwxyz";
		String num = "0123456789";
		String character = "!@#$%^&*-_=+|;:,<.>/?";
		String combination = upper + lower + num + character;
		int len = 8;
		char[] pwd = new char[8];
		Random r = new Random();
		for (int i = 0; i < len; i++) {
			pwd[i] = combination.charAt(r.nextInt(combination.length()));
		}
		String password = new String(pwd);
		return password;

	}

	public String randomPhoneNumber() {
		Random rand = new Random();
	//	long number = (long) Math.floor(Math.random() * 9_000_000_000L) + 900_000_000L;
		long num = (long)  9000000000L+(rand.nextLong(900000000)); 
		String phno = String.valueOf(num);
		return phno;
	}

}
