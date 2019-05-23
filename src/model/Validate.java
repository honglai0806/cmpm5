package model;

public class Validate {

	public static boolean checkFormatName(String name) {
		return name.matches("\\w{2,30}");
	}

// /w nếu k muốn là mail
	public static boolean checkFormatEmail(String emailOrPhone) {
		return emailOrPhone.matches("[\\w.-]+@gmail\\.com");
	}

	public static boolean checkFormatPass(String password) {
		return password.matches("\\w{2,30}");
	}

	public static boolean checPass(String pass, String repassword) {

		return pass.equals(repassword);

	}

	public static void main(String[] args) {
		System.out.println(checkFormatName("234"));

	}

}
