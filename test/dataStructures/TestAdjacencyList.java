package dataStructures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.City;

class TestAdjacencyList {

	private AdjacencyList<City> adjacencylist;
	
	private void setupScenario1() {
		
		this.adjacencylist = new AdjacencyList<City>(false);
	}
	
	//Graph with 10 vertexes
		void setupScenario2() {
			
			adjacencylist = new AdjacencyList<City>(false);
			
			for(int i = 0; i<10; i++) {
				
				Vertex<City> vi = new Vertex<City>(new City(i+"", ""));
				adjacencylist.addVertex(vi);
			}
		}

		//Graph with 30 vertexes
		void setupScenario3() {
			
			adjacencylist = new AdjacencyList<City>(false);
			for(int i = 0; i<30; i++) {
				Vertex<City> vi = new Vertex<City>(new City(i+"", ""));
				adjacencylist.addVertex(vi);
			}
		}
		
	@Test
	void testAdjacencyList() {
			
		setupScenario1();
			
		assertTrue(this.adjacencylist.isDirected() == false);
		assertTrue(this.adjacencylist.getVertex() != null);
		assertTrue(this.adjacencylist.getGraph() != null);

	}
	

	@Test
	void AddVertexTest1() {
		
		setupScenario1();
		
		Vertex<City> vi = new Vertex<City>(new City(4+"", ""));
		boolean b = this.adjacencylist.addVertex(vi);
		
		boolean c = this.adjacencylist.getVertex().contains(vi);
		
		assertTrue(b&&c&&adjacencylist.getSize()==1);
	}
	
	
	@Test
	void AddVertexTest2() {
		setupScenario2();
		Vertex<City> vi = new Vertex<City>(new City(47+"", ""));
		boolean b = this.adjacencylist.addVertex(vi);
		
		assertTrue(b&&adjacencylist.getSize()==11);
	}
	
	@Test
	void AddVertexTest3() {
		setupScenario3();
		Vertex<City> vi = new Vertex<City>(new City(47+"", ""));
		boolean b = this.adjacencylist.addVertex(vi);
		
		assertTrue(b&&adjacencylist.getSize()==31);
	}


	@Test
	 void removeVertexTest1() {
		setupScenario1();
		Vertex<City> vi = new Vertex<City>(new City(0+"", ""));
		boolean b = adjacencylist.removeVertex(vi);
		assertTrue(!b);
		
	}
	
	@Test
	 void removeVertexTest2() {
		setupScenario2();
		Vertex<City> vi = new Vertex<City>(new City(0+"", ""));
		boolean b = adjacencylist.removeVertex(vi);
		assertTrue(b&&adjacencylist.getSize()==9);
		
	}
	
	@Test
	 void removeVertexTest3() {
		setupScenario3();
		Vertex<City> vi = new Vertex<City>(new City(0+"", ""));
		boolean b = adjacencylist.removeVertex(vi);
		assertTrue(b&&adjacencylist.getSize()==29);
	}

	//test for adding an unweighted edge
	//the graph is empty, therefore an
	//edge can´t be added
	@Test
	 void addEdgeTest1() {
		setupScenario1();
		Vertex<City> vi = new Vertex<City>(new City(0+"", ""));
		Vertex<City> va = new Vertex<City>(new City(1+"", ""));
		boolean b = adjacencylist.addEdge(vi,va);
		assertTrue(!b);
	}
	
	//test for adding a unweighted edge
	//when the graph is not empty
	@Test
	 void addEdgeTest2() {
		setupScenario2();
		Vertex<City> vi = new Vertex<City>(new City(0+"", ""));
		Vertex<City> va = new Vertex<City>(new City(1+"", ""));
		boolean b = adjacencylist.addEdge(vi,va);
		assertTrue(b);
	}
	
	@Test
	 void addEdgeTest3() {
		setupScenario3();
		Vertex<City> vi = new Vertex<City>(new City(0+"", ""));
		Vertex<City> va = new Vertex<City>(new City(1+"", ""));
		boolean b = adjacencylist.addEdge(vi,va);
		assertTrue(b);
	}

	@Test
	 void addEdgeWeightedTest1() {
		setupScenario1();
		Vertex<City> vi = new Vertex<City>(new City(0+"", ""));
		Vertex<City> va = new Vertex<City>(new City(1+"", ""));
		boolean b = adjacencylist.addEdge(vi,va,100);
		assertTrue(!b);
	}
	
	@Test
	 void addEdgeWeightedTest2() {
		setupScenario2();
		Vertex<City> vi = new Vertex<City>(new City(0+"", ""));
		Vertex<City> va = new Vertex<City>(new City(1+"", ""));
		boolean b = adjacencylist.addEdge(vi,va,200);
		assertTrue(b);
		
	}
	
	@Test
	 void addEdgeWeightedTest3() {
		setupScenario3();
		Vertex<City> vi = new Vertex<City>(new City(4+"", ""));
		Vertex<City> va = new Vertex<City>(new City(10+"", ""));
		boolean b = adjacencylist.addEdge(vi,va,1000);
		assertTrue(b);
	}
	
	
	@Test
	void searchIndexTest1() {
	setupScenario2();
	Vertex<City> vi = new Vertex<City>(new City(0+"",""));
	int a = adjacencylist.searchIndex(vi);
	int b = 0;
	
	assertEquals(a,b);
	
	
	}
	
	@Test
	void searchIndexTest2() {
	setupScenario1();
	Vertex<City> vi = new Vertex<City>(new City(0+"",""));
	int a = adjacencylist.searchIndex(vi);
	int b = -1;
	
	assertEquals(a,b);
	
	
	}
	
	@Test
	void searchIndexTest3() {
	setupScenario3();
	Vertex<City> vi = new Vertex<City>(new City(19+"",""));
	int a = adjacencylist.searchIndex(vi);
	int b = 19;
	
	assertEquals(a,b);
	
	
	}

}