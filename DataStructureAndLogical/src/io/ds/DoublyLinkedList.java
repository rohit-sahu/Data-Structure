package io.ds;

public class DoublyLinkedList {

	Node head;

	static class Node {

		int data;
		Node previous;
		Node next;

		public Node(int data, Node previous, Node next) {
			super();
			this.data = data;
			this.previous = previous;
			this.next = next;
		}

		public Node(int data) {
			super();
			this.data = data;
		}
	}

	public void push(int data) {
		Node node = new Node(data);
		node.next = head;
		node.previous = null;
		if (head != null) {
			head.previous = node;
		}
		head = node;
	}

	public void append(int data) {
		Node node = new Node(data);
		Node last = head;
		if (head == null) {
			node.previous = null;
			head = node;
		} else {
			/* Iterate to last element of list */
			while (last.next != null) {
				last = last.next;
			}
			last.next = node;
			node.previous = last;
		}
	}

	public void insertAfter(Node node, int data) {
		/* 1. check if the given prev_node is NULL */
		if (node == null) {
			System.out.println("The given previous node cannot be NULL ");
			return;
		}
		/* 2. allocate node 3. put in the data */
		Node new_node = new Node(data);

		/* 4. Make next of new node as next of prev_node */
		new_node.next = node.next;

		/* 5. Make the next of prev_node as new_node */
		node.next = new_node;

		/* 6. Make prev_node as previous of new_node */
		node.previous = node;

		/* 7. Change previous of new_node's next node */
		if (new_node.next != null)
			new_node.next.previous = new_node;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
