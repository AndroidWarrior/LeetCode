package com.leetcode.www.datastructure.linked;

public class LinkedListSample<E> {

	private Node<E> header;

	private Node<E> Laster;

	private class Node<E> {
		Node<E> next;
		Node<E> prev;
		E data;

		Node(E e) {
			this.data = e;
		}
	}

	public void add(E e) {
		Node<E> node = new Node<E>(e);
		if (header == null) {
			header = node;
			return;
		}
		Node<E> temp = header;
		while (temp.next == null) {
			temp = temp.next;
		}
		temp.next = node;
	}

	public E delect(int index) {
		if (index < 0 || index > length()) {
			return null;
		}
		if (index == 1) {
			Node<E> delNode = header;
			header = header.next;
			return delNode.data;
		}

		Node<E> curNode = header.next;
		Node<E> preNode = header;
		int i = 2;
		while (curNode != null) {
			if (i == index) {
				preNode.next = curNode.next;
				curNode.next = null;
				curNode.prev = null;
				return curNode.data;
			}
			preNode = curNode;
			curNode = curNode.next;
			i++;
		}

		return null;
	}

	// public void orderList() {
	// Node<E> nextNode = null;
	// E temp = null;
	// Node<E> curNode = header;
	//
	// while(curNode.next != null) {
	// nextNode = curNode.next;
	// while(nextNode !=null) {
	// if(curNode.data > nextNode.data) {
	// temp = curNode.data;
	// curNode.data = nextNode.data;
	// nextNode.data = temp;
	// }
	// nextNode = nextNode.next;
	// }
	// curNode = curNode.next;
	// }
	//
	// }

	public Node<E> findElem(Node<E> head, int k) {
		if (k < 1) {
			return null;
		}

		Node<E> p1 = header;
		Node<E> p2 = header;
		for (int i = 0; i < k - 1; i++) {
			p1 = p1.next;
		}

		while (p1.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}

		return p2;

	}

	public int length() {
		int length = 0;
		Node<E> temp = header;
		while (temp != null) {
			length++;
			temp = temp.next;
		}
		return length;
	}

}
