package io.ds;

public class LinkedList {

	Node head;
	
	public boolean add(Integer a) {
		Node node = new Node(0, null);
		if (this.head == null) {
			this.head = node;
			return true;
		} else {
			Node last = this.head;
			while (last.next != null) {
				last = last.next;
			} 
			last.next = node;
			return true;
		}
	}
	
	static class Node {
		int data;
		Node next;
		
		public Node(int data, Node next) {
			super();
			this.data = data;
			this.next = next;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + ", next=" + next + "]";
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
