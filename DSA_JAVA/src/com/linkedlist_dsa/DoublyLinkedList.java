package com.linkedlist_dsa;

public class DoublyLinkedList {
	static NodeDLL head;
	static NodeDLL tail;

	public static void main(String[] args) {
		System.out.println("Doubly Linked List");

		insertAtEnd(2);
		insertAtEnd(3);
		insertAtEnd(4);
		insertAtEnd(5);

		System.out.print("After insertion at tail: ");
		display(head);

		System.out.print("After insertion at head: ");
		insertAtBeginning(1);
		display(head);

		insertAtIndex(6, 2);
		System.out.print("After insertion at 2nd position: ");
		display(head);

		deleteAtBeginning();
		System.out.print("After deletion at the beginning: ");
		display(head);

		deleteAtEnd();
		System.out.print("After deletion at the end: ");
		display(head);

		deleteAtIndex(2);
		System.out.print("After deletion at 2nd position: ");
		display(head);
	}

	public static void insertAtBeginning(int data) {
		NodeDLL temp = new NodeDLL(data);
		if (head == null) {
			head = temp;
			tail = temp;
		} else {
			temp.next = head;
			head.prev = temp;
			head = temp;
		}
	}

	public static void deleteAtBeginning() {
		if (head == null) {
			return;
		}

		if (head == tail) {
			head = null;
			tail = null;
			return;
		}

		NodeDLL temp = head;
		head = head.next;
		head.prev = null;
		temp.next = null;
	}

	public static void insertAtIndex(int data, int position) {
		NodeDLL temp = new NodeDLL(data);
		if (position == 1) {
			insertAtBeginning(data);
		} else {
			NodeDLL current = head;
			int currPosition = 1;
			while (current != null && currPosition < position) {
				current = current.next;
				currPosition++;
			}
			if (current == null) {
				insertAtEnd(data);
			} else {
				temp.next = current;
				temp.prev = current.prev;
				current.prev.next = temp;
				current.prev = temp;
			}
		}
	}

	public static void deleteAtIndex(int position) {
		if (head == null) {
			return;
		}

		if (position == 1) {
			deleteAtBeginning();
			return;
		}

		NodeDLL current = head;
		int count = 1;

		while (current != null && count != position) {
			current = current.next;
			count++;
		}

		if (current == null) {
			System.out.println("Position wrong");
			return;
		}

		if (current == tail) {
			deleteAtEnd();
			return;
		}

		current.prev.next = current.next;
		current.next.prev = current.prev;
		current.prev = null;
		current.next = null;
	}

	private static void deleteAtEnd() {

		if (tail == null) {
			return;
		}

		if (head == tail) {
			head = null;
			tail = null;
			return;
		}

		NodeDLL temp = tail;
		tail = tail.prev;
		tail.next = null;
		temp.prev = null;
	}

	public static void insertAtEnd(int data) {
		NodeDLL temp = new NodeDLL(data);
		if (tail == null) {
			head = temp;
			tail = temp;
		} else {
			tail.next = temp;
			temp.prev = tail;
			tail = temp;
		}
	}

	static void iterateForward() {

		NodeDLL current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}

	}

	static void iterateBackward() {

		NodeDLL current = tail;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.prev;
		}

	}

	static void display(NodeDLL head) {
		NodeDLL temp = head;
		while (temp != null) {
			System.out.print(temp.data + "  ");
			temp = temp.next;
		}
		System.out.println("NULL");
	}

}

class NodeDLL {
	Object data;
	NodeDLL prev;
	NodeDLL next;

	NodeDLL(int data) {
		this.data = data;
		this.prev = null;
		this.next = null;
	}
}