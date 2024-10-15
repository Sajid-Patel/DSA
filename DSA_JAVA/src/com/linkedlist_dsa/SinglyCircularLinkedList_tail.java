package com.linkedlist_dsa;

/*
 SinglyCircularLinkedList : First <- Tail 
             ------------------------------------------------------
 traverse =  |--[previous|97]<----[previous|98]<----[previous|99]<--|
                   node3               node2             node1
 */

public class SinglyCircularLinkedList_tail {

	public static void main(String[] args) {

		// Create circular linked list: 97, 98, 99
		NodeSCLL2 last = new NodeSCLL2(97);
		last.pre = new NodeSCLL2(98);
		last.pre.pre = new NodeSCLL2(99);
		NodeSCLL2 first = last.pre.pre;
		first.pre = last;

		System.out.print("Original list: ");
		display(first);

		// Insert 4 at the beginning
		first = insertatbegining(first, 96);

		System.out.print("List after inserting 96 at the beginning: ");
		display(first);
	}

	static NodeSCLL2 insertatbegining(NodeSCLL2 first, int value) {

		NodeSCLL2 newNode = new NodeSCLL2(value);

		if (first == null) {
			newNode.pre = newNode;
			return newNode;

		}
		newNode.pre = first.pre;
		first.pre = newNode;
		return first;

	}

	public static void display(NodeSCLL2 last) {
		if (last == null)

			return;

		NodeSCLL2 tail = last.pre;

		while (true) {
			System.out.print(tail.data + " ");
			tail = tail.pre;

			if (tail == last.pre)
				break;
		}
		System.out.println();

	}
}

class NodeSCLL2 {
	NodeSCLL2 pre;
	int data;

	NodeSCLL2(int value) {
		pre = null;
		data = value;

	}
}