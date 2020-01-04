package io.logical;

import java.util.Arrays;

public class StringMaxChar {

	static String str = "aaabbbcc bereatwrs";
	static String[][] charCount = new String[str.length()][2];
	static int maxCount = 0;
	public static void main(String[] args) {
		char[] c= str.toCharArray();
		Arrays.sort(c);
		System.out.println(c);
		for (int i = 0; i < c.length; i++) {
			int count = 1;
			charCount[i][0] = c[i] + "";
			if (i == c.length - 1) {
				charCount[i][1] = count + "";
			}
			for (int j = i + 1; j < c.length; j++) {
				if (c[i] == c[j]) {
					count++;
				} else {
					charCount[i][1] = count + "";
					i = j -1;
					if (maxCount <= count) {
						maxCount = count;
						System.out.println(maxCount);
					}
					break;
				}
			}
		}
		//System.out.println(charCount);
		/*for (int i = 0; i < str.length(); i++) {
			int count = 0;
			charCount[i][0] = str.charAt(i) + "";
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(i) == str.charAt(j)) {
					count = count + 1;
					charCount[i][1] = count + "";
				}
			}
			str = str.replace(str.charAt(i) + "", "");
		}*/
	}
}
