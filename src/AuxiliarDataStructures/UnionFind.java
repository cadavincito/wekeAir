package AuxiliarDataStructures;

import dataStructures.Vertex;

public class UnionFind<E> implements IUnionFind<E>{
	
	private Vertex<E>[] vertexes;
	private int[] parents;
	
	public UnionFind(Vertex<E>[] vertexes) {
		this.vertexes = vertexes;
		parents = new int[vertexes.length];
	}

	@Override
	public void makeSet() {
		for (int i = 0; i < parents.length ; i++) {
			parents[i] = i;
        }
	}

	@Override
	public int find(int node) {
		
		if(parents[node]!=node)
			return find(parents[node]);
		
        return node;
	}

	@Override
	public void union(int node1, int node2) {
		 int x = find(node1);
         int y = find(node2);
       
         parents[y] = x;
		
	}

} //end of class
