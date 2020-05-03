package dataStructures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AdjacencyListTest<V> {
	
	AdjacencyList<Integer> al;
	
	void setupScenario1() {
		al = new AdjacencyList<Integer>(false);
		
	}
	
	//Graph with 10 vertexes
	void setupScenario2() {
		al = new AdjacencyList<Integer>(false);
		
		Vertex<Integer> va = new Vertex<Integer>(0);
		Vertex<Integer> ve = new Vertex<Integer>(1);
		Vertex<Integer> vi = new Vertex<Integer>(2);
		Vertex<Integer> vo = new Vertex<Integer>(3);
		Vertex<Integer> vu = new Vertex<Integer>(4);
		Vertex<Integer> vb = new Vertex<Integer>(5);
		Vertex<Integer> vc = new Vertex<Integer>(6);
		Vertex<Integer> vd = new Vertex<Integer>(7);
		Vertex<Integer> vf = new Vertex<Integer>(8);
		Vertex<Integer> vg = new Vertex<Integer>(9);
		//Add the vertexes to the structure
		
		al.addVertex(va);
		al.addVertex(ve);
		al.addVertex(vi);
		al.addVertex(vo);
		al.addVertex(vu);
		al.addVertex(vb);
		al.addVertex(vc);
		al.addVertex(vd);
		al.addVertex(vf);
		al.addVertex(vg);
		
		
	}

	//Graph with 30 vertexes
	void setupScenario3() {
		al = new AdjacencyList<Integer>(false);
		for(int i = 0; i<30; i++) {
			Vertex<Integer> vi = new Vertex<Integer>(i);
			al.addVertex(vi);
		}
	}

	@Test
	 void addVertexTest1() {
		setupScenario1();
		Vertex<Integer> vi = new Vertex<Integer>(4);
		boolean b = al.addVertex(vi);
		assertTrue(b&&al.getSize()==1);
	}
	
	@Test
	 void addVertexTest2() {
		setupScenario2();
		Vertex<Integer> vt = new Vertex<Integer>(44);
		boolean b = al.addVertex(vt);
		System.out.println(al.getSize());
		assertTrue(b&&al.getSize()==11);
		
	}
	
	@Test
	 void addVertexTest3() {
		setupScenario3();
		Vertex<Integer> vt = new Vertex<Integer>(24);
		boolean b = al.addVertex(vt);
		assertTrue(b&&al.getSize()==31);
		
	}

	@Test
	 void removeVertexTest1() {
		setupScenario3();
		Vertex<Integer> vi = new Vertex<Integer>(0);
		boolean b = al.addVertex(vi);
		assertTrue(b);
		
	}
	
	@Test
	 void removeVertexTest2() {
		setupScenario3();
		
		
		
		
	}
	
	@Test
	 void removeVertexTest3() {
		setupScenario3();
		Vertex<Integer> vi = new Vertex<Integer>(0);
		boolean b = al.addVertex(vi);
		assertTrue(b);
	}

	@Test
	 void addEdgeTest1() {
		setupScenario2();
		Vertex<Integer> vi = new Vertex<Integer>(0);
		Vertex<Integer> va = new Vertex<Integer>(1);
		boolean b = al.addEdge(vi,va);
		assertTrue(b);
	}
	
	@Test
	 void addEdgeTest2() {
		setupScenario2();
		Vertex<Integer> va = new Vertex<Integer>(0);
		Vertex<Integer> vi = new Vertex<Integer>(2);
		boolean b = al.addEdge(vi,va);
		assertTrue(b);
	}
	
	@Test
	 void addEdgeTest3() {
		setupScenario1();
		Vertex<Integer> vi = new Vertex<Integer>(4);
		Vertex<Integer> va = new Vertex<Integer>(4);
		boolean b = al.addEdge(vi,va);
		assertTrue(b);
	}

	@Test
	 void addEdgeWeightedTest1() {
		// TODO Auto-generated method stub
		
	}
	
	@Test
	 void addEdgeWeightedTest2() {
		// TODO Auto-generated method stub
		
	}
	
	@Test
	 void addEdgeWeightedTest3() {
		// TODO Auto-generated method stub
		
	}

}
