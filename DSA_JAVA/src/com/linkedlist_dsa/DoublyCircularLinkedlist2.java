package com.linkedlist_dsa;

import java.util.Scanner;

public class DoublyCircularLinkedlist2 {

	private NodeDCLL2 head;

	public void insertionBeginning() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Item value: ");
		int item = scanner.nextInt();
		NodeDCLL2 newNode = new NodeDCLL2(item);

		if (head == null) {
			head = newNode;
			head.next = head;
			head.prev = head;
		} else {
			NodeDCLL2 tail = head.prev;
			tail.next = newNode;
			newNode.prev = tail;
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
		System.out.println("Node inserted");
	}

	private void randominsert() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter element value:");
		int item = scanner.nextInt();
		System.out.println("Enter the index after which you want to insert:");
		int location = scanner.nextInt();

		NodeDCLL2 newNode = new NodeDCLL2(item);
		NodeDCLL2 temp = head;
		for (int i = 0; i < location; i++) {
			if (temp == null) {
				System.out.println("Can't insert");
				return;
			}
			temp = temp.next;
		}
		newNode.next = temp.next;
		temp.next = newNode;
		System.out.println("Node inserted");

	}

	public void insertionLast() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter value: ");
		int item = scanner.nextInt();
		NodeDCLL2 newNode = new NodeDCLL2(item);

		if (head == null) {
			head = newNode;
			head.next = head;
			head.prev = head;
		} else {
			NodeDCLL2 tail = head.prev;
			tail.next = newNode;
			newNode.prev = tail;
			newNode.next = head;
			head.prev = newNode;
		}
		System.out.println("Node inserted");
	}

	public void deletionBeginning() {
		if (head == null) {
			System.out.println("UNDERFLOW");
			return;
		} else if (head.next == head) {
			head = null;
			System.out.println("Node deleted");
			return;
		} else {
			NodeDCLL2 tail = head.prev;
			tail.next = head.next;
			head.next.prev = tail;
			head = head.next;
		}
		System.out.println("Node deleted");
	}

	private void random_delete() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the index of the node after which you want to perform deletion:");
		int location = scanner.nextInt();
		NodeDCLL2 temp = head;
		NodeDCLL2 nodetoDelete = null;

		for (int i = 0; i < location; i++) {
			if (temp == null) {
				System.out.println("Can't delete");
				return;
			}
			nodetoDelete = temp;
			temp = temp.next;
		}

		if (nodetoDelete != null && temp != null) {
			nodetoDelete.next = temp.next;
			System.out.println("Deleted node at location " + (location + 1));
		}
	}

	public void deletionLast() {
		if (head == null) {
			System.out.println("UNDERFLOW");
			return;
		} else if (head.next == head) {
			head = null;
			System.out.println("Node deleted");
			return;
		} else {
			NodeDCLL2 tail = head.prev;
			tail.prev.next = head;
			head.prev = tail.prev;
			System.out.println("Node deleted");
		}
	}

	public void display() {
		if (head == null) {
			System.out.println("Nothing to print");
			return;
		}
		NodeDCLL2 current = head;
		System.out.println("Printing values...");
		do {
			System.out.println(current.data);
			current = current.next;
		} while (current != head);
	}

	public void search() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter item which you want to search: ");
		int item = scanner.nextInt();
		NodeDCLL2 current = head;
		int index = 0;

		if (current == null) {
			System.out.println("Empty List");
			return;
		}

		do {
			if (current.data == item) {
				System.out.println("Item found at location " + (index + 1));
				return;
			}
			current = current.next;
			index++;
		} while (current != head);

		System.out.println("Item not found");
	}

	public static void main(String[] args) {
		DoublyCircularLinkedlist2 list = new DoublyCircularLinkedlist2();
		Scanner scanner = new Scanner(System.in);
		int choice = 0;

		while (choice != 7) {
			System.out.println("********* Main Menu *********");
			System.out.println("1. Insert in Beginning");
			System.out.println("2. Insert after Index");
			System.out.println("3. Insert at Last");
			System.out.println("4. Delete from Beginning");
			System.out.println("5. Delete after Index");
			System.out.println("6. Delete from Last");
			System.out.println("7. Search");
			System.out.println("8. Show");
			System.out.println("9. Exit");
			System.out.print("Enter your choice: ");

			choice = scanner.nextInt();
			switch (choice) {

			case 1:
				list.insertionBeginning();
				break;

			case 2:
				list.randominsert();
				break;

			case 3:
				list.insertionLast();
				break;
			case 4:
				list.deletionBeginning();
				break;

			case 5:
				list.random_delete();
				break;

			case 6:
				list.deletionLast();
				break;
			case 7:
				list.search();
				break;
			case 8:
				list.display();
				break;
			case 9:
				System.exit(0);
			default:
				System.out.println("Please enter a valid choice.");
			}
		}
	}
}

class NodeDCLL2 {
	NodeDCLL2 prev;
	NodeDCLL2 next;
	int data;

	public NodeDCLL2(int data) {
		this.data = data;
	}
}
