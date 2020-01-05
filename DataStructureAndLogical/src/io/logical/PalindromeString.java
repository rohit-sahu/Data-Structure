package io.logical;

import java.util.Arrays;

public class PalindromeString {

	private static boolean isPalindrome(String str) {
		if (str.equals(reverse(str))) {
			return true;
		}
		return false;
	}

	private static boolean isPalindrome(String str1, String str2) {
		if (str1.equals(str2)) {
			return true;
		} else {
			char[] s1 = str1.toCharArray();
			char[] s2 = str2.toCharArray();
			Arrays.sort(s1);
			Arrays.sort(s2);
			return Arrays.equals(s1, s2);
		}
	}
	
	private static String reverse(String str) {
		String output = "";
		if (str == null || str.isEmpty()) {
			return str;
		}
		char[] cs = str.toCharArray();
		for (int i = cs.length -1; i >= 0; i--) {
			output += cs[i];
		}
		return output;
	}
	
	@SuppressWarnings("unused")
	private static String reverseUsingRecurssive(String str) {
		if (str == null || str.isEmpty()) {
			return str;
		}
		return str.charAt(str.length() - 1) + reverseUsingRecurssive(str.substring(0, str.length() - 1));
	}

	public static void main(String[] args) {
		String str = "BOB";
		System.out.println(isPalindrome(str));
		System.out.println(isPalindrome(str, "OBB"));
	}
}
