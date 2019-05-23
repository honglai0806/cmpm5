package model;

public class StringUtil {
	public static String getString(String value) {
		return value == null ? "" : value;
	}

	public static String getString(Object value) {
		return value == null ? "" : String.valueOf(value);
	}

	public boolean checkPass(String s1, String s2) {
		return s1.equals(s2);

	}

	public static void main(String[] args) {
		StringUtil stringUtil = new StringUtil();
		stringUtil.checkPass("abc", "abc");
	}
}
