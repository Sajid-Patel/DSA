package com.linkedlist_dsa;

import java.util.Scanner;

public class Linkedlist_DS {
	static NodeSCLL head = null;
	static NodeSCLL tail = null;

	public static void main(String[] args) {
		display();
		System.out.println("Enter how many numbers you want in LinkedList");
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		for (int i = 0; i < size; i++) {
			addNodesAtLast();
		}

		boolean repeat = false;

		System.out.println("Do you want to add more elements in Linked List Y / N ? ");
		if ("Y".equals(scan.next()))
			repeat = true;

		do {

			if (repeat) {

				System.out.println();
				System.out.println("Enter location of your choice");
				System.out.println(
						"FIRST(to add data at first) or MIDDLE(to add data at middle) or LAST(to add data at last) ");

				switch (scan.next().trim()) {
				case "FIRST":
					addNodesAtStart();
					break;

				case "MIDDLE":
					System.out.println("Yet to be programmed");
					break;

				case "LAST":
					addNodesAtLast();
					break;

				default:
					System.out.println("Choose among FIRST , MIDDLE , LAST only");
					System.out.println("Your choice is somethiing different");
					System.out.println("Thank You");

				}

				System.out.println("Do you want to repeat Y / N");
				if ("Y".equals(scan.next())) {
					repeat = true;
				} else {
					repeat = false;
				}
			}

			display();
		} while (repeat);
	}

	static void display() {
		if (head == null) {
			System.out.println("Empty LinkedList");
			return;
		}
		System.out.print("The List is : ");

		NodeSCLL traveller = null;
		traveller = head;
		do {
			System.out.print(" " + traveller.data);
			traveller = traveller.next;
		} while (traveller != null);

	}

	static void addNodesAtLast() {
		System.out.println("Enter data to be added in LinkedList");
		Scanner scan = new Scanner(System.in);
		int data = scan.nextInt();
		NodeSCLL node = new NodeSCLL();
		node.data = data;
		if (head == null) {
			// node.next==null
			head = node;
			tail = node;
		} else {
			tail.next = node;
			tail = node;
		}
	}

	static void addNodesAtStart() {

		System.out.println("Enter data to be added in LinkedList");
		Scanner scan = new Scanner(System.in);
		int data = scan.nextInt();
		NodeSCLL node = new NodeSCLL();
		node.data = data;
		if (head == null) {

			head = node;
			tail = node;
		} else {
			node.next = head;
			head = node;
		}

	}

}

class NodeSCLL {
	int data; // accepts data

	NodeSCLL next; // accepts memory address of next node ( NODE is a class and next is a variable
	// of type node class so it is non premitive )
}

// for creating node in C : struct Node{int data; struct Node * next; }
