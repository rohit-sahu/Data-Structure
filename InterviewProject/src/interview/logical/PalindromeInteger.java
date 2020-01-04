package interview.logical;

public class PalindromeInteger {

	private static boolean isPalindrome(int input) {
		int reverse = 0;
		int palindrome = input;
		while (palindrome != 0) {
			int remainder = palindrome % 10;
			reverse = reverse * 10 + remainder;
            palindrome = palindrome / 10;
		}
		if (input == reverse) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		int input = 1001;
		System.out.println(isPalindrome(input));
	}
}
