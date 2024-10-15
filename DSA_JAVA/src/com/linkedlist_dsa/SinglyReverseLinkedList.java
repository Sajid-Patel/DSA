package com.linkedlist_dsa;

import java.util.Scanner;

public class SinglyReverseLinkedList {
	static NodeSRLL head;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int choice = 0;

		while (choice != 4) {
			System.out.println("1. Insert Next");
			System.out.println("2. Enter value and Show revers");
			System.out.println("3. Display");
			System.out.println("4. Exit");

			choice = scan.nextInt();
			switch (choice) {
			case 1:
				lastinsert();
				break;

			case 2:
				reverslogic();
				break;

			case 3:
				display();
				break;

			case 4:
				System.out.println("Session Successfully Loged out ");
				System.out.println("Thank You");
				break;

			default:
				System.out.println("Please enter valid choice");

			}
		}

	}

	private static void lastinsert() {
		System.out.println("Enter data to be Inserted at last in LinkedList");
		Scanner scan = new Scanner(System.in);
		int item = scan.nextInt();

		NodeSRLL newNode = new NodeSRLL(item);

		if (head == null) {
			head = newNode;
			System.out.println("Overflow");

		} else {
			NodeSRLL temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;

		}
		System.out.println("Node inserted");
	}

	private static void reverslogic() {
		System.out.println("Enter data to be Inserted in reverse LinkedList");
		Scanner scan = new Scanner(System.in);
		int item = scan.nextInt();

		NodeSRLL newNode = new NodeSRLL(item);
		NodeSRLL temp = head;
		// pointer of node which is before temp
		NodeSRLL tempBefore = temp;
		temp = temp.next;
		// the pointer of the node which is next to temp
		NodeSRLL tempAfter = temp.next;
		/*
		 * here the node pointed by tempBefore is the first node of singly ll, so while
		 * reversing this first node will become last, and next of last in singly ll is
		 * null
		 */
		tempBefore.next = null;
		while (temp != null) {
			temp.next = tempBefore;
			tempBefore = temp;
			temp = tempAfter;
			if (temp != null)
				tempAfter = temp.next;

		}
		head = tempBefore;
		display();
	}

	static void display() {

		if (head == null) {
			System.out.println("Empty Linked List");
		} else {
			System.out.println("Printing Values");
			NodeSRLL temp = head;
			while (temp != null) {
				System.out.println(temp.data);
				temp = temp.next;

			}

		}
	}
}

class NodeSRLL {
	Object data;
	NodeSRLL next;

	NodeSRLL(int data) {
		this.data = data;
		this.next = null;
	}

}