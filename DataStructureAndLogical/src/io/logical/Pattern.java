package io.logical;

public class Pattern {

	public static void drawPyramidPattern() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5 - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
	
	public static void main(String[] args) {
		drawPyramidPattern();
	}
}
