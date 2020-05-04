package dataStructures;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

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

		void setupScenario4() {
			adjacencyMatrix = new AdjacencyMatrix<City>(false);
			for(int i = 0; i<30; i++) {
				Vertex<City> vi = new Vertex<City>(new City(i+"",""));
				adjacencyMatrix.addVertex(vi);
			}
			
			// 0 --- 1 && 0 ---- 2
			adjacencyMatrix.addEdge(adjacencyMatrix.getVertex().get(0), adjacencyMatrix.getVertex().get(1));
			adjacencyMatrix.addEdge(adjacencyMatrix.getVertex().get(0), adjacencyMatrix.getVertex().get(2));
			
			// 1 --- 3 && 1 ---- 4
			adjacencyMatrix.addEdge(adjacencyMatrix.getVertex().get(1), adjacencyMatrix.getVertex().get(3));
			adjacencyMatrix.addEdge(adjacencyMatrix.getVertex().get(1), adjacencyMatrix.getVertex().get(4));
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
			System.out.println(adjacencyMatrix.getSize());
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
			setupScenario1();
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
			Vertex<City> va = new Vertex<City>(new City(57+"",""));
			
			boolean b = adjacencyMatrix.addEdge(vi, va);
			assertTrue(!b);
		}

		//test for adding a weighted edge
		//the graph is empty, therefore an
		//edge cant be added
		@Test
		void addWeightedEdgeTest1() {
			setupScenario1();
			Vertex<City> vi = new Vertex<City>(new City(0+"",""));
			Vertex<City> va = new Vertex<City>(new City(1+"",""));
			boolean b = adjacencyMatrix.addEdge(vi, va,100);
			assertTrue(!b);
		}
		
		//test for adding a weighted edge
		@Test
		void addWeightedEdgeTest2() {
			setupScenario2();
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
		
		
		
//		@Test
//		void bfsTest1() {
//		setupScenario4();
//
//		List<Integer> a=adjacencyMatrix.bfs(adjacencyMatrix.getVertex().get(0));
//		
//		List<Integer> b = new ArrayList<Integer>();	
//		
//		for(int i = 0; i<5;i++){
//			b.add(i);
//		}
//			
//		assertEquals(a,b);
//		
//		
//		}
		
		
				@Test
				void searchIndexTest1() {
				setupScenario2();
				Vertex<City> vi = new Vertex<City>(new City(0+"",""));
				int a = adjacencyMatrix.searchIndex(vi);
				int b = 0;
				
				assertEquals(a,b);
				
				
				}
				
				@Test
				void searchIndexTest2() {
				setupScenario1();
				Vertex<City> vi = new Vertex<City>(new City(0+"",""));
				int a = adjacencyMatrix.searchIndex(vi);
				int b = -1;
				
				assertEquals(a,b);
				
				
				}
				
				@Test
				void searchIndexTest3() {
				setupScenario3();
				Vertex<City> vi = new Vertex<City>(new City(19+"",""));
				int a = adjacencyMatrix.searchIndex(vi);
				int b = 19;
				
				assertEquals(a,b);
				
				
				}


}
