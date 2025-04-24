package com.stack;

import java.util.Scanner;

public class StackDataStructure {

	static Node base = null;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int choice = 0;
		while (choice != 4) {

			System.out.println("1. Push Data");
			System.out.println("2. Pop Data");
			System.out.println("3. Display");
			System.out.println("4. Exit");

			choice = scan.nextInt();
			switch (choice) {
			case 1:
				push();
				break;

			case 2:
				pop();
				break;

			case 3:
				display();
				break;

			case 4:
				System.out.println("Thank you");
				break;

			default:
				System.out.println("Wrong Choice");

			}
		}

	}

	static void pop() {
		if (base == null) {
			System.out.println("Empty Stack");
		} else {
			base = base.below;

			System.out.println("Node Poped");

		}
	}

	static void push() {
		System.out.println("Enter data to Push");
		Scanner scan = new Scanner(System.in);

		int insert = scan.nextInt();
		Node newNode = new Node(insert);

		newNode.below = base;
		base = newNode;
		System.out.println("Node Pushed");

	}

	static void display() {

		if (base == null) {
			System.out.println(" Empty Stack ");
		} else {
			Node traveler = base;
			while (traveler != null) {
				System.out.println(traveler.data + " ");
				traveler = traveler.below;
			}

		}
	}
}
