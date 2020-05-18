package AuxiliarDataStructures;

import java.util.ArrayList;
import java.util.List;

import dataStructures.Vertex;

public class UnionFind<V> implements IUnionFind<V>{
	
	private ArrayList<Vertex<V>> vertexes;
	private int[] parents;
	
	public UnionFind(List<Vertex<V>> list) {
		this.vertexes = (ArrayList<Vertex<V>>) list;
		parents = new int[vertexes.size()];
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
