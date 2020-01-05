package io.ds;

public class LinkedList {

    Node head;

    /**
     * Given a key, add the first occurrence of key in linked list
     *
     * @param a
     * @return boolean
     */
    public boolean add(Integer a) {
        Node node = new Node(a, null);
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

    /**
     * Given a key, deletes the first occurrence of key in linked list
     *
     * @param key
     * @return boolean
     */
    public boolean deleteNode(int key) {
        // Store head node
        Node temp = head, prev = null;

        // If head node itself holds the key to be deleted
        if (temp != null && temp.data == key) {
            head = temp.next; // Changed head
            return true;
        }

        // Search for the key to be deleted, keep track of the
        // previous node as we need to change temp.next
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }

        // If key was not present in linked list
        if (temp == null)
            return false;

        // Unlink the node from linked list
        prev.next = temp.next;
        return true;
    }

    /**
     * Given a reference (pointer to pointer) to the head of a list
     * and a position, deletes the node at the given position.
     *
     * @param position
     */
    public boolean deleteNodeByPosition(int position) {
        // If linked list is empty
        if (head == null)
            return false;

        // Store head node
        Node temp = head;

        // If head needs to be removed
        if (position == 0) {
            head = temp.next;   // Change head
            return true;
        }

        // Find previous node of the node to be deleted
        for (int i = 0; temp != null && i < position - 1; i++)
            temp = temp.next;

        // If position is more than number of ndoes
        if (temp == null || temp.next == null)
            return false;

        // Node temp->next is the node to be deleted
        // Store pointer to the next of node to be deleted
        Node next = temp.next.next;

        temp.next = next;  // Unlink the deleted node from list
        return true;
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
