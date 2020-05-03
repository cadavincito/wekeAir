package AuxiliarDataStructures;

import java.util.ArrayList;

public class Stack<T> implements IStack<T> {

	private Node<T> top;
	private int size;

	public Stack() {
		this.size = 0;
	}
	
	@Override
	public T peek() {
		
		if(top != null)
			return top.value;
		else
			return null;
	}

	@Override
	public T pop() {

		if (!isEmpty()) {
			Node<T> aux = top;
			this.top = top.prev;
			return aux.value;
			
		} else
			return null;

	}
	
	@Override
	public void push(T ele) {

		Node<T> newNode = new Node<T>(top, null, ele);
		
		if(top != null)	
			this.top.setNext(newNode);
		
		this.top = newNode;
		size++;
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return top == null;
	}

	public class Node<T> {

		private Node<T> prev;
		private Node<T> next;
		private T value;

		public Node(Node<T> prev, Node<T> next, T value) {

			this.prev = prev;
			this.next = next;
			this.value = value;
		}

		public Node<T> getPrev() {
			return prev;
		}

		public void setPrev(Node<T> prev) {
			this.prev = prev;
		}

		public Node<T> getNext() {
			return next;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}

		public T getValue() {
			return value;
		}

		public void setValue(T value) {
			this.value = value;
		}

	}

}
