package com.queue;

import java.util.Scanner;

public class QueueDataStructure {

	static Node entry;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int choice = 0;

		while (choice != 4) {
			System.out.println("1. EnQueue Data");
			System.out.println("2. DeQueue Data");
			System.out.println("3. Show");
			System.out.println("4. Exit");
			System.out.println("Enter your choice:");

			choice = scan.nextInt();
			switch (choice) {

			case 1:
				enqueue();
				break;

			case 2:
				dequeu();
				break;

			case 3:
				display();
				break;

			case 4:
				System.out.println("Thank You");
				break;

			default:
				System.out.println("Please enter valid choice");

			}
		}

	}

	private static void display() {

		if (entry == null) {
			System.out.println("Empty Queue");
		} else {
			System.out.println("Printing Queue");

			Node traveler = entry;
			while (traveler != null) {
				System.out.println(traveler.data + " ");
				traveler = traveler.previous;
			}
		}
	}

	private static void dequeu() {
		if (entry == null) {
			System.out.println("Empty Queue");
		} else {
			entry = entry.previous;
			System.out.println("Node Deleted");
		}

	}

	private static void enqueue() {
		System.out.println("Enter data to be Inserted in Queue");
		Scanner scan = new Scanner(System.in);
		int item = scan.nextInt();

		Node newNode = new Node(item);

		if (entry == null) {
			entry = newNode;
			System.out.println("Entry is Empty");

		} else {

			Node traveler = entry;
			while (traveler.previous != null) {
				traveler = traveler.previous;

			}
			traveler.previous = newNode;
		}
		System.out.println("Node Inserted");
	}

}
