package AuxiliarDataStructures;

public interface IStack <T> {

	void push(T ele);
	T peek();
	T pop();
	int size();
	boolean isEmpty();

}
