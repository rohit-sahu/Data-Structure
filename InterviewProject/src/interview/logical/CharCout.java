package interview.logical;

import java.util.Arrays;

public class CharCout {

	public static void main(String[] args) {
		String str = "aacbbcbcdb";
		char[] c = str.toCharArray();
		Arrays.sort(c);
		for (int i = 0; i < c.length; i++) {
			int count = 0;
			for (int j = 0; j < c.length; j++) {
				if (c[i] == c[j]) {
					count++;
				} else {
					break;
				}
			}
			System.out.println(c[i] + " - " + count);
		}
	}
}
