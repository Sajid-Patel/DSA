package com.linkedlist_dsa;

/*
 SinglyCircularLinkedList : Head -> last 
             ----------------------------------
 traverse =  |-->[5|next]->[6|next]->[7|next]--|
                   node1   node2       node3
 */
public class SinglyCircularLinkedList_head {

	public static void main(String[] args) {

		// Create circular linked list: 5, 6, 7
		NodeSCLL1 first = new NodeSCLL1(5);
		first.next = new NodeSCLL1(6);
		first.next.next = new NodeSCLL1(7);
		NodeSCLL1 last = first.next.next;
		last.next = first;

		System.out.print("Original list: ");
		display(last);

		// Insert 4 at the beginning
		last = insertatbegining(last, 4);

		System.out.print("List after inserting 4 at the beginning: ");
		display(last);
	}

	static NodeSCLL1 insertatbegining(NodeSCLL1 last, int value) {

		NodeSCLL1 newNode = new NodeSCLL1(value);

		if (last == null) {
			newNode.next = newNode;
			return newNode;

		}
		newNode.next = last.next;
		last.next = newNode;
		return last;

	}

	public static void display(NodeSCLL1 last) {
		if (last == null)

			return;

		NodeSCLL1 head = last.next;

		while (true) {
			System.out.print(head.data + " ");
			head = head.next;

			if (head == last.next)
				break;
		}
		System.out.println();

	}
}

class NodeSCLL1 {

	int data;
	NodeSCLL1 next;

	NodeSCLL1(int value) {
		data = value;
		next = null;
	}
}