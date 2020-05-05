package AuxiliarDataStructures;

import java.util.ArrayList;
import java.util.List;

import dataStructures.Vertex;

public class UnionFind<E> implements IUnionFind<E>{
	
	private ArrayList<Vertex<E>> vertexes;
	private int[] parents;
	
	public UnionFind(List<Vertex<E>> list) {
		this.vertexes = (ArrayList<Vertex<E>>) list;
		parents = new int[list.size()];
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
