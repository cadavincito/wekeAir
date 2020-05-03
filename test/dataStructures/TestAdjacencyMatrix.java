package dataStructures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.City;

class TestAdjacencyMatrix {

		AdjacencyMatrix<City> adjacencyMatrix;
		void setupScenario1() {
			adjacencyMatrix = new AdjacencyMatrix<City>(false);
		}
		
		//graph with 10 vertexes
		void setupScenario2() {
			adjacencyMatrix = new AdjacencyMatrix<City>(false);
			for(int i = 0; i<10; i++) {
				Vertex<City> vi = new Vertex<City>(new City(i+"",""));
				adjacencyMatrix.addVertex(vi);
			}
		}

		void setupScenario3() {
			adjacencyMatrix = new AdjacencyMatrix<City>(false);
			for(int i = 0; i<30; i++) {
				Vertex<City> vi = new Vertex<City>(new City(i+"",""));
				adjacencyMatrix.addVertex(vi);
			}
		}

		
		@Test
		void AdjacencyMatrixTest(){
			setupScenario1();
			assertTrue(adjacencyMatrix!=null);	
		}
		
		
		//the assertion that the vertex was added
		//and the size of the matrix is equal to
		//the amount of added nodes is made
		@Test
		void addVertexTest1() {
			setupScenario1();
			Vertex<City> vi = new Vertex<City>(new City(10+"",""));
			boolean b = adjacencyMatrix.addVertex(vi);
			
			assertTrue(b&&(adjacencyMatrix.getSize()==1));
			
		}
		
		@Test
		void addVertexTest2() {
			setupScenario2();
			Vertex<City> vi = new Vertex<City>(new City(10+"",""));
			boolean b = adjacencyMatrix.addVertex(vi);
			
			assertTrue(b&&(adjacencyMatrix.getSize()==11));
			
		}		
		//we test when the graph is full 
		@Test
		void addVertexTest3() {
			setupScenario3();
			Vertex<City> vi = new Vertex<City>(new City(30+"",""));
			boolean b = adjacencyMatrix.addVertex(vi);
			assertTrue(b&&(adjacencyMatrix.getSize()==31));
		}
		
		
		@Test
		void removeVertexTest1() {
			setupScenario1();
			Vertex<City> vi = new Vertex<City>(new City(0+"",""));
			boolean b = adjacencyMatrix.removeVertex(vi);
			assertTrue(!b);
		
		}
		
		@Test
		void removeVertexTest2() {
			setupScenario2();
			Vertex<City> vi = new Vertex<City>(new City(0+"",""));
			boolean b = adjacencyMatrix.removeVertex(vi);
			
			assertTrue(b&&adjacencyMatrix.getSize()==9);
		}
		
		@Test
		void removeVertexTest3() {
			setupScenario3();
			Vertex<City> vi = new Vertex<City>(new City(0+"",""));
			boolean b = adjacencyMatrix.removeVertex(vi);
			assertTrue(b&&adjacencyMatrix.getSize()==29);
		}
		
		//test for adding an unweighted edge
		//the graph is empty, therefore an
		//edge can�t be added
		@Test
		void addEdgeTest1() {
			setupScenario2();
			Vertex<City> vi = new Vertex<City>(new City(0+"",""));
			Vertex<City> va = new Vertex<City>(new City(1+"",""));
			boolean b = adjacencyMatrix.addEdge(vi, va);
			assertTrue(!b);
		}
		
		//test for adding a unweighted edge
		//when the graph is not empty
		@Test
		void addEdgeTest2() {
			setupScenario2();
			Vertex<City> vi = new Vertex<City>(new City(0+"",""));
			Vertex<City> va = new Vertex<City>(new City(1+"",""));
			boolean b = adjacencyMatrix.addEdge(vi, va);
			assertTrue(b);
		}
		
		//test for adding a unweighted edge
		//when the matrix is full
		@Test
		void addEdgeTest3() {
			setupScenario3();
			Vertex<City> vi = new Vertex<City>(new City(0+"",""));
			Vertex<City> va = new Vertex<City>(new City(1+"",""));
			
			boolean b = adjacencyMatrix.addEdge(vi, va);
			assertTrue(b);
		}

		//test for adding a weighted edge
		//the graph is empty, therefore an
		//edge can�t be added
		@Test
		void addWeightedEdgeTest1() {
			setupScenario1();
			Vertex<City> vi = new Vertex<City>(new City(0+"",""));
			Vertex<City> va = new Vertex<City>(new City(1+"",""));
			boolean b = adjacencyMatrix.addEdge(vi, va,100);
			assertTrue(b);
		}
		
		//test for adding a weighted edge
		@Test
		void addWeightedEdgeTest2() {
			setupScenario1();
			Vertex<City> vi = new Vertex<City>(new City(0+"",""));
			Vertex<City> va = new Vertex<City>(new City(1+"",""));
			boolean b = adjacencyMatrix.addEdge(vi, va,200);
			assertTrue(b);
		}
		
		//test for adding a weighted edge
		@Test
		void addWeightedEdgeTest3() {
			setupScenario3();
			Vertex<City> vi = new Vertex<City>(new City(9+"",""));
			Vertex<City> va = new Vertex<City>(new City(10+"",""));
			boolean b = adjacencyMatrix.addEdge(vi, va,300);
			assertTrue(b);
		}

}
