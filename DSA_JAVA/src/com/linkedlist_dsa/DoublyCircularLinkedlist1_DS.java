package com.linkedlist_dsa;

import java.util.Scanner;

public class DoublyCircularLinkedlist1_DS {
	static NodeDCLL1 head = null;
	static NodeDCLL1 tail = null;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean repeat = true;
		display();
		do {
			System.out.println("DO you want to add Nodes to Doubly Circular Linked List,  Enter 1 (yes) or 0 (no)");
			if (1 == scan.nextInt()) {
				System.out.println("Enter Data : ");
				String data = scan.next();

				addInDoublyLinkedList(data, scan);
				display();
				System.out.println("Do you want to contineu adding Nodes, Enter 1 (yes) or 0 (no)");

				if (1 != scan.nextInt()) {
					System.out.println("Thank You");
					repeat = false;
				}
			} else {
				System.out.println("Thank You");
				repeat = false;
			}
		} while (repeat);

	}

	private static void display() {
		NodeDCLL1 traveler = head;
		System.out.println("The Doubly Circular Linked List is : ");
		if (head == null) {
			System.out.println("Doubly Circular Linked List is Empty");

		} else {
			while (traveler != tail) {
				System.out.println(" " + traveler.data);
				traveler = traveler.next;
			}
			System.out.println(" " + traveler.data);
			System.out.println();
		}
	}

	private static void addInDoublyLinkedList(String data, Scanner scan) {
		NodeDCLL1 newNode = new NodeDCLL1();
		newNode.data = data;
		if (head == null) {
			newNode.next = newNode;
			newNode.prev = newNode;
			head = newNode;
			tail = newNode;
		} else {
			System.out.println("Do you want to add Node at the :    S (begining)   M (middle)  E (end) ");
			String choice = scan.next();
			switch (choice) {
			case "S":
				insertAtStartofDCLL(newNode);
				break;

			case "M":
				System.out.println("Enter the Index number you want to inserd Node");
				Scanner sc = new Scanner(System.in);
				int index = sc.nextInt();
				if (index == 0) {
					insertAtStartofDCLL(newNode);
					break;
				}
				int count = 1;// count of nodes
				NodeDCLL1 traveler = head;
				while (index != 1 && traveler != tail) {
					traveler = traveler.next;
					index--;
					count++;
				}
				if (index == 1) {
					traveler.next.prev = newNode;
					newNode.next = traveler.next;
					traveler.next = newNode;
					traveler = null;
					if (traveler == tail) {
						tail = newNode;
					}
				} else {
					System.out.println("The Index you suggested is not possible as the DLL is having " + count
							+ " Nodes and max Index can be " + count);

				}
				break;

			case "E":
				insertAtEndofDCLL(newNode);
				break;
			default:
				System.out.println("You entered unexpected choice");

			}

		}

	}

	private static void insertAtEndofDCLL(NodeDCLL1 newNode) {
		newNode.next = head;
		newNode.prev = tail;
		head.prev = newNode;
		tail.next = newNode;
		tail = newNode;
	}

	private static void insertAtStartofDCLL(NodeDCLL1 newNode) {
		newNode.next = head;
		newNode.prev = tail;
		head.prev = newNode;
		tail.next = newNode;
		head = newNode;
	}

}

class NodeDCLL1 {
	Object data; // accepts data
	NodeDCLL1 next; // stores address of next node
	NodeDCLL1 prev; // stores address of previous node
}