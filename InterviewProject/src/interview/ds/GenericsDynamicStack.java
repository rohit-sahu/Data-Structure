package interview.ds;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Implementing Stack using generics 
 * 
 * @author rohit
 *
 * @param <E>
 */
public class GenericsDynamicStack<E> {

	private int MAX;
	private int size;
	private int top;
	private E[] data;
	
	public GenericsDynamicStack() {
		this(10);
	}
	
	public GenericsDynamicStack(int size) {
		super();
		this.MAX = size;
		this.top = -1;
		@SuppressWarnings("unchecked")
		final E[] arr = (E[]) Array.newInstance(Object.class, this.MAX);
		this.data = arr;
	}
	
	public boolean isEmpty() {
		if (this.top == -1) {
			return true;
		}
		return false;
	}

	public boolean push(E data) {
		if (this.top >= MAX - 1) {
			System.out.println("Stack Overflow");
			return false;
		} else {
			this.data[++this.top] = data;
			this.size++;
			return true;
		}
	}

	public E pop() {
		if (this.top < 0) {
			System.out.println("Stack Underflow");
			return null;
		} else {
			E x = data[this.top--];
			this.size--;
			return x;
		}
	}

	public E peek() {
		if (this.top < 0) {
			System.out.println("Stack Underflow");
			return null;
		} else {
			E x = data[this.top];
			return x;
		}
	}
	
	public int getSize() {
		return this.size;
	}
	
	/*public GenericsDynamicStack<E> sort() {
		GenericsDynamicStack<E> dynamicStack = new GenericsDynamicStack<E>(this.MAX);
		while (!this.isEmpty()) {
			E temp = this.pop();
			while (!dynamicStack.isEmpty() && dynamicStack.peek().compareTo(temp) > 0) {
				this.push(dynamicStack.pop());
			}
			dynamicStack.push(temp);
		}
		return dynamicStack;
	}*/

	@Override
	public String toString() {
		return "GenericsDynamicStack [top=" + top + ", data=" + Arrays.toString(data) + "]";
	}
	
	public static void main(String[] args) {
		GenericsDynamicStack<Integer> s = new GenericsDynamicStack<Integer>(10);
		s.push(30);
		s.push(10);
		s.push(20);
		//s = s.sort();
		System.out.println(s.toString());
		System.out.println(s.pop() + " Popped from stack");
		System.out.println(s.pop() + " Popped from stack");
		System.out.println(s.pop() + " Popped from stack");
		System.out.println(s.pop() + " Popped from stack");
		
		GenericsDynamicStack<Character> c = new GenericsDynamicStack<Character>(10);
		c.push('R');
		c.push('o');
		c.push('h');
		c.push('i');
		c.push('t');
		System.out.println(c.toString() + c.getSize());
		
		StringBuilder sb = new StringBuilder(c.getSize());
		final int len = c.getSize() -1;
		for (int i = 0; i <= len; i++) {
			sb.append(c.pop());
		}
		System.out.println(sb.toString());
		System.out.println("Size : " + c.getSize());
		System.out.println("Top : " + c.top);
	}
}
