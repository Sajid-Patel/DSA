package com.linkedlist_dsa;

import java.util.Scanner;

public class LinkedList2 {
	static Node2 head = null;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int choice = 0;

		while (choice != 9) {

			System.out.println("----------------Main Menu----------------");
			System.out.println("Choose one option from the following");
			System.out.println("-----------------------------------------------------");
			System.out.println("1. Insert in begining");
			System.out.println("2. Insert in last");
			System.out.println("3. Insert at random location");
			System.out.println("4. Delete from begiining");
			System.out.println("5. Delete from last");
			System.out.println("6. Delete Node after specified location");
			System.out.println("7. Search for an element");
			System.out.println("8. Show");
			System.out.println("9. Exit");
			System.out.println("Enter your choice:");

			choice = scan.nextInt();
			switch (choice) {
			case 1:
				beginingnsert();
				break;

			case 2:
				lastinsert();
				break;

			case 3:
				randominsert();
				break;

			case 4:
				begin_delete();
				break;

			case 5:
				last_delete();
				break;

			case 6:
				random_delete();
				break;

			case 7:
				search();
				break;

			case 8:
				display();
				break;

			case 9:
				System.out.println("Session Successfully Loged out ");
				System.out.println("Thank You");
				break;

			default:
				System.out.println("Please enter valid choice");
			}

		}
	}

	private static void display() {

		if (head == null) {
			System.out.println("Empty LinkedList");

		} else {
			System.out.println("Printing Values.....");
			Node2 temp = head;
			while (temp != null) {
				System.out.println(temp.data);
				temp = temp.next;
			}
		}
	}

	private static void search() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter item which you want to search:");
		int item = scanner.nextInt();
		Node2 temp = head;
		int i = 0;

		while (temp != null) {
			if (temp.data == item) {
				System.out.println("Item found at location " + (i + 1));
				return;
			}
			temp = temp.next;
			i++;
		}
		System.out.println("Item not found");
	}

	private static void random_delete() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the location of the node after which you want to perform deletion:");
		int loc = scanner.nextInt();
		Node2 temp = head;
		Node2 nodetoDelete = null;

		for (int i = 0; i < loc; i++) {
			if (temp == null) {
				System.out.println("Can't delete");
				return;
			}
			nodetoDelete = temp;
			temp = temp.next;
		}

		if (nodetoDelete != null && temp != null) {
			nodetoDelete.next = temp.next;
			System.out.println("Deleted node at location " + (loc + 1));
		}
	}

	private static void last_delete() {
		if (head == null) {
			System.out.println("List is empty");
		} else if (head.next == null) {
			head = null;
			System.out.println("Only node of the list deleted");
		} else {
			Node2 temp = head;
			while (temp.next.next != null) {
				temp = temp.next;
			}
			temp.next = null;
			System.out.println("Deleted Node from the last");
		}

	}

	private static void begin_delete() {
		if (head == null) {
			System.out.println("List is empty");
		} else {
			head = head.next;
			System.out.println("Node deleted from the beginning");
		}
	}

	private static void randominsert() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter element value:");
		int item = scanner.nextInt();
		System.out.println("Enter the location after which you want to insert:");
		int loc = scanner.nextInt();

		Node2 newNode = new Node2(item);
		Node2 temp = head;
		for (int i = 0; i < loc; i++) {
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

	private static void lastinsert() {
		System.out.println("Enter data to be Inserted at last in LinkedList");
		Scanner scan = new Scanner(System.in);
		int item = scan.nextInt();

		Node2 newNode = new Node2(item);

		if (head == null) {
			head = newNode;
			System.out.println("Overflow");

		} else {
			Node2 temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;

		}
		System.out.println("Node inserted");
	}

	private static void beginingnsert() {
		System.out.println("Enter data to be Inserted at begning in LinkedList");
		Scanner scan = new Scanner(System.in);
		int item = scan.nextInt();

		Node2 newNode = new Node2(item);

		newNode.next = head;
		head = newNode;
		System.out.println("Node Inserted");

	}

}

class Node2 {

	int data;

	Node2 next;

	Node2(int data) {
		this.data = data;
		this.next = null;
	}

}
