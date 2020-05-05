package AuxiliarDataStructures;

public interface IUnionFind<E> {
	
	public  void makeSet();
	public  int find(int node);
	public void union (int node1 ,int node2);

}
