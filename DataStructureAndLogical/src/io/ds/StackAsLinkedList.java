package io.ds;

/**
 * Implementing stack using queue. Resizeable Stack.
 * 
 * @author rohit
 *
 */
public class StackAsLinkedList<E> {

	private int size;
	StackNode<E> root;

	static class StackNode<E> {
		E data;
		StackNode<E> next;

		StackNode(E data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "StackNode [data=" + data + ", next=" + next + "]";
		}
	}

	public boolean isEmpty() {
		if (root == null) {
			return true;
		} else
			return false;
	}

	public void push(E data) {
		StackNode<E> newNode = new StackNode<E>(data);
		if (root == null) {
			root = newNode;
		} else {
			StackNode<E> temp = root;
			root = newNode;
			newNode.next = temp;
		}
		this.size++;
		System.out.println(data + " pushed to stack");
		System.out.println(root);
	}

	public E pop() {
		E popped = null;
		if (root == null) {
			System.out.println("Stack is Empty");
		} else {
			popped = root.data;
			root = root.next;
			this.size--;
		}
		return popped;
	}

	public E peek() {
		if (root == null) {
			System.out.println("Stack is empty");
			return null;
		} else {
			return root.data;
		}
	}

	public int getSize() {
		return this.size;
	}

	@Override
	public String toString() {
		return "StackAsLinkedList [root=" + root + "]";
	}

	public static void main(String[] args) {

		StackAsLinkedList<Integer> sll = new StackAsLinkedList<Integer>();
		sll.push(10);
		sll.push(20);
		sll.push(30);
		System.out.println(sll.toString());
		System.out.println(sll.pop() + " popped from stack");
		System.out.println("Top element is " + sll.peek());
		
		StackAsLinkedList<Character> slc = new StackAsLinkedList<Character>();
		slc.push('R');
		slc.push('o');
		slc.push('h');
		slc.push('i');
		slc.push('t');
		StringBuilder sb = new StringBuilder(slc.getSize());
		int size = slc.getSize();
		for (int i = 0; i <= size - 1; i++) {
			sb.append(slc.pop());
		}
		System.out.println(sb.toString());
	}
}
