package interview.ds;

import java.util.Arrays;

public class Stack {

	private static final int MAX = 100;

	private int top;

	private int[] a = new int[MAX];

	public Stack() {
		super();
		this.top = -1;
	}

	public boolean isEmpty() {
		if (this.top == -1) {
			return true;
		}
		return false;
	}

	public boolean push(int data) {
		if (this.top >= MAX - 1) {
			System.out.println("Stack Overflow");
			return false;
		} else {
			this.a[++this.top] = data;
			return true;
		}
	}

	public int pop() {
		if (this.top < 0) {
			System.out.println("Stack Underflow" + this.top);
			return 0;
		} else {
			int x = a[this.top--];
			return x;
		}
	}

	public int peek() {
		if (this.top < 0) {
			System.out.println("Stack Underflow");
			return 0;
		} else {
			int x = a[this.top];
			return x;
		}
	}

	@Override
	public String toString() {
		return "Stack [a=" + Arrays.toString(a) + "]";
	}
	
	public static void main(String[] args) {
		Stack s = new Stack();
		s.push(10);
		s.push(20);
		s.push(30);
		System.out.println(s);
		System.out.println(s.pop() + " Popped from stack");
		System.out.println(s.pop() + " Popped from stack");
		System.out.println(s.pop() + " Popped from stack");
		System.out.println(s.pop() + " Popped from stack");
		System.out.println(s.pop() + " Popped from stack");
		System.out.println(s.pop() + " Popped from stack");
	}
}
