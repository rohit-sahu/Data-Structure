package io.ds;

public class DynamicStack {

	private int MAX = 100;//default
	private int top;
	private int[] data;
	
	public DynamicStack() {
		super();
		this.top = -1;
		data = new int[MAX];
	}
	
	public DynamicStack(int size) {
		super();
		this.MAX = size;
		this.top = -1;
		data = new int[MAX];
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
			this.data[++this.top] = data;
			return true;
		}
	}

	public int pop() {
		if (this.top < 0) {
			System.out.println("Stack Underflow");
			return 0;
		} else {
			int x = data[this.top--];
			return x;
		}
	}

	public int peek() {
		if (this.top < 0) {
			System.out.println("Stack Underflow");
			return 0;
		} else {
			int x = data[this.top];
			return x;
		}
	}
	
	public static void main(String[] args) {
		DynamicStack s = new DynamicStack(10);
		s.push(10);
		s.push(20);
		s.push(30);
		System.out.println(s.pop() + " Popped from stack");
		System.out.println(s.pop() + " Popped from stack");
		System.out.println(s.pop() + " Popped from stack");
		System.out.println(s.pop() + " Popped from stack");
		System.out.println(s.pop() + " Popped from stack");
		System.out.println(s.pop() + " Popped from stack");
	}
}
