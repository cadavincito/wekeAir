package dataStructures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AdjacencyMatrixTest<V> {
	AdjacencyMatrix<Integer> am;
	void setupScenario1() {
	am = new AdjacencyMatrix<Integer>(false);
	}
	
	//graph with 10 vertexes
	void setupScenario2() {
		am = new AdjacencyMatrix<Integer>(false);
		for(int i = 0; i<10; i++) {
			Vertex<Integer> vi = new Vertex<Integer>(i);
			am.addVertex(vi);
		}
	}

	void setupScenario3() {
		am = new AdjacencyMatrix<Integer>(false);
		for(int i = 0; i<30; i++) {
			Vertex<Integer> vi = new Vertex<Integer>(i);
			am.addVertex(vi);
		}
	}

	
	//the assertion that the vertex was added
	//and the size of the matrix is equal to
	//the amount of added nodes is made
	@Test
	void addVertexTest1() {
		setupScenario1();
		Vertex<Integer> vi = new Vertex<Integer>(4);
		boolean b = am.addVertex(vi);
		
		assertTrue(b&&(am.getSize()==1));
		
	}
	
	@Test
	void addVertexTest2() {
		setupScenario2();
		Vertex<Integer> vi = new Vertex<Integer>(4);
		boolean b = am.addVertex(vi);
		assertTrue(b&&(am.getSize()==11));
		
	}
	
	//we test when the graph is full 
	@Test
	void addVertexTest3() {
		setupScenario3();
		Vertex<Integer> vi = new Vertex<Integer>(4);
		boolean b = am.addVertex(vi);
		assertTrue(b&&(am.getSize()==31));
		
	}

	@Test
	void extendMatrixTest1() {
		setupScenario3();
		Vertex<Integer> vi = new Vertex<Integer>(4);
		boolean b = am.addVertex(vi);
	}
	
	@Test
	void extendMatrixTest2() {
		
		
	}
	
	@Test
	void removeVertexTest1() {
			setupScenario2();
	
	}
	
	@Test
	void removeVertexTest2() {
	
	}
	
	@Test
	void removeVertexTest3() {
	
	}

	//test for adding a unweighted edge
	@Test
	void addEdgeTest1() {
		setupScenario2();
		Vertex<Integer> vi = new Vertex<Integer>(0);
		Vertex<Integer> va = new Vertex<Integer>(1);
		boolean b = am.addEdge(vi, va);
		assertTrue(b);
	}
	
//	test for adding a unweighted edge
//	when the graph is empty
	@Test
	void addEdgeTest2() {
		setupScenario1();
		Vertex<Integer> vi = new Vertex<Integer>(24);
		Vertex<Integer> va = new Vertex<Integer>(25);
		boolean b = am.addEdge(vi, va);
		assertTrue(b);
	}
	
	//test for adding a unweighted edge
	//when the matrix is full
	@Test
	void addEdgeTest3() {
		setupScenario3();
		Vertex<Integer> vi = new Vertex<Integer>(14);
		Vertex<Integer> va = new Vertex<Integer>(15);
		boolean b = am.addEdge(vi, va);
		assertTrue(b);
	}

	//test for adding a weighted edge
	@Test
	void addWeightedEdgeTest1() {
		setupScenario1();
		Vertex<Integer> vi = new Vertex<Integer>(24);
		Vertex<Integer> va = new Vertex<Integer>(25);
		boolean b = am.addEdge(vi, va,100);
		assertTrue(b);
	}
	
	//test for adding a weighted edge
	@Test
	void addWeightedEdgeTest2() {
		setupScenario1();
		Vertex<Integer> vi = new Vertex<Integer>(24);
		Vertex<Integer> va = new Vertex<Integer>(25);
		boolean b = am.addEdge(vi, va,200);
		assertTrue(b);
	}
	
	//test for adding a weighted edge
	@Test
	void addWeightedEdgeTest3() {
		setupScenario3();
		Vertex<Integer> vi = new Vertex<Integer>(14);
		Vertex<Integer> va = new Vertex<Integer>(15);
		boolean b = am.addEdge(vi, va,300);
		assertTrue(b);
	}
	
}
