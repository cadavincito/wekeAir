package dataStructures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.City;

class TestAdjacencyList {

	private AdjacencyList<City> adjacencylist;
	
	private void setUpScenario1() {
		
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
			
			for(int i = 0; i<10; i++) {
				
				Vertex<City> vi = new Vertex<City>(new City(i+"", ""));
				adjacencylist.addVertex(vi);
			}
		}
		
	@Test
	void testAdjacencyList() {
			
		setUpScenario1();
			
		assertTrue(this.adjacencylist.isDirected() == false);
		assertTrue(this.adjacencylist.getVertex() != null);
		assertTrue(this.adjacencylist.getGraph() != null);

	}
	

	@Test
	void testAddVertex() {
		
		setUpScenario1();
		
		Vertex<City> vi = new Vertex<City>(new City(4+"", ""));
		boolean b = this.adjacencylist.addVertex(vi);
		assertTrue(b);
		
		boolean c = this.adjacencylist.getVertex().contains(vi);
		
		assertTrue(c);
	}

//	@Test
//	void testRemoveVertex() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testAddEdgeVertexOfVVertexOfV() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testAddEdgeVertexOfVVertexOfVDouble() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetSize() {
//		fail("Not yet implemented");
//	}

}
