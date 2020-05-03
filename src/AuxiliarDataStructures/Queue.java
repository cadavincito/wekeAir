package AuxiliarDataStructures;

public class Queue<T> implements IQueue<T> {

	private Node<T> head;
	private Node<T> butt;
	private int size;

	public Queue() {
		this.size = 0;
	}

	public Queue(Queue<T> copy) {
		
		if(copy != null){
			Node<T> nod = copy.head;
		
			addAll(nod);		
		}
	}

	public void addAll(Node<T> nod) {

		if (nod != null) {
			this.add(nod.getE());
			nod = nod.getNext();
			addAll(nod);
		}
	}

	@Override
	public void add(T element) {
	
		if(size == 0)
			this.butt = null;
		
		Node<T> b = butt;
		Node<T> toInsert = new Node<T>(element, null, b);
		this.butt = toInsert;

		if (b == null)
			head = toInsert;
		else
			b.next = toInsert;

		size++;
	}

	@Override
	public void clear() {
		this.head = null;
		this.butt = null;

	}

	@Override
	public T poll() {

		Node<T> unlinked = head;
		if (head != null) {
			this.head = head.next;
			if (head != null)
				head.setPrev(null);
			size--;
		}
		if(unlinked == null)
			return null;
		else
			return unlinked.e;
	}

	@Override
	public T peek() {

		if(head != null)
			return head.e;
		else
			return null;
	}

	public boolean isEmpty() {
		if (size == 0)
			return true;
		else
			return false;
	}

	@Override
	public int size() {

		return size;
	}

	public Node<T> getHead() {
		return head;
	}

	public void setHead(Node<T> head) {
		this.head = head;
	}

	public Node<T> getButt() {
		return butt;
	}

	public void setButt(Node<T> butt) {
		this.butt = butt;
	}
	
	@Override
	public boolean contains(T element) {
		
		boolean contains = false;
		boolean stop = false;
		
		Node<T> temp = this.head;
		
		for (int i = 0; i < this.size && !stop; i++) {
			
			if(temp == null) {
				stop = true;
			}
			else if(temp.getE().equals(element)) {
				stop = true;
				contains = true;
			}
			else {
				
				temp = temp.next;
			}
		}
		
		return contains;
	}

	public class Node<T> {

		private T e;

		private Node<T> next;
		private Node<T> prev;

		public Node(T e, Node<T> next, Node<T> prev) {

			this.e = e;
			if(next != null)
				next.setPrev(this);
			this.next = next;
			if(prev != null)
				prev.setNext(this);
			this.prev = prev;
			
		}

		public T getE() {
			return e;
		}

		public void setE(T e) {
			this.e = e;
		}

		public Node<T> getNext() {
			return next;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}

		public Node<T> getPrev() {
			return prev;
		}

		public void setPrev(Node<T> prev) {
			this.prev = prev;
		}

	}

}
