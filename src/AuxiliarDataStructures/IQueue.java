package AuxiliarDataStructures;

public interface IQueue<T> {

	void add(T element);
	T poll();
	T peek();
	boolean isEmpty();
	void clear();
	int size();
	boolean contains(T element);
	
}
