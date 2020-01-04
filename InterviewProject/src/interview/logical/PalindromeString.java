package interview.logical;

public class PalindromeString {

	private static boolean isPalindrome(String str) {
		if (str.equals(reverse(str))) {
			return true;
		}
		return false;
	}
	
	private static String reverse(String str) {
		String output = "";
		if (str == null || str.isEmpty() || str.isBlank()) {
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
		if (str == null || str.isEmpty() || str.isBlank()) {
			return str;
		}
		return str.charAt(str.length() - 1) + reverseUsingRecurssive(str.substring(0, str.length() - 1));
	}

	public static void main(String[] args) {
		String str = "BOB";
		System.out.println(isPalindrome(str));
	}
}
