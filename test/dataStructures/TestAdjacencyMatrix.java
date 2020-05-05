package dataStructures;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.City;

class TestAdjacencyMatrix {
	
		//undirected graph with 0 vertexes
		AdjacencyMatrix<City> adjacencyMatrix;
		void setupScenario1() {
			adjacencyMatrix = new AdjacencyMatrix<City>(false);
		}
		
		//undirected graph with 10 vertexes
		void setupScenario2() {
			adjacencyMatrix = new AdjacencyMatrix<City>(false);
			for(int i = 0; i<10; i++) {
				Vertex<City> vi = new Vertex<City>(new City(i+"",""));
				adjacencyMatrix.addVertex(vi);
			}
		}
		
		
		//undirected graph with 30 vertexes
		void setupScenario3() {
			adjacencyMatrix = new AdjacencyMatrix<City>(false);
			for(int i = 0; i<30; i++) {
				Vertex<City> vi = new Vertex<City>(new City(i+"",""));
				adjacencyMatrix.addVertex(vi);
			}
		}

		//there are 4 edges in this graph
		//the graph is directed
		void setupScenario4() {
			adjacencyMatrix = new AdjacencyMatrix<City>(true);
			for(int i = 0; i<30; i++) {
				Vertex<City> vi = new Vertex<City>(new City(i+"",""));
				adjacencyMatrix.addVertex(vi);
			}
			
			// 0 ---> 1 && 0 ----> 2
			adjacencyMatrix.addEdge(adjacencyMatrix.getVertex().get(0), adjacencyMatrix.getVertex().get(1));
			adjacencyMatrix.addEdge(adjacencyMatrix.getVertex().get(0), adjacencyMatrix.getVertex().get(2));
			
			// 1 ---> 3 && 1 ----> 4
			adjacencyMatrix.addEdge(adjacencyMatrix.getVertex().get(1), adjacencyMatrix.getVertex().get(3));
			adjacencyMatrix.addEdge(adjacencyMatrix.getVertex().get(1), adjacencyMatrix.getVertex().get(4));
		}
				
		
		
		//graph with 30 vertexes
		//the graph is directed
		//there are 8 edges in this graph
		void setupScenario5() {
			
			adjacencyMatrix = new AdjacencyMatrix<City>(true);
			for(int i = 0; i<10; i++) {
				Vertex<City> vi = new Vertex<City>(new City(i+"",""));
				adjacencyMatrix.addVertex(vi);
			}
			
			// 0 ---> 1 && 0 ----> 2
			adjacencyMatrix.addEdge(adjacencyMatrix.getVertex().get(0), adjacencyMatrix.getVertex().get(1));
			adjacencyMatrix.addEdge(adjacencyMatrix.getVertex().get(0), adjacencyMatrix.getVertex().get(2));
			
			// 1 ---> 3 && 1 ----> 4
			adjacencyMatrix.addEdge(adjacencyMatrix.getVertex().get(1), adjacencyMatrix.getVertex().get(3));
			adjacencyMatrix.addEdge(adjacencyMatrix.getVertex().get(1), adjacencyMatrix.getVertex().get(4));
			
			// 3 ---> 5 && 3 ----> 6
			adjacencyMatrix.addEdge(adjacencyMatrix.getVertex().get(2), adjacencyMatrix.getVertex().get(5));
			adjacencyMatrix.addEdge(adjacencyMatrix.getVertex().get(2), adjacencyMatrix.getVertex().get(6));
			
			// 4 ---> 7 && 4 ----> 8
			adjacencyMatrix.addEdge(adjacencyMatrix.getVertex().get(3), adjacencyMatrix.getVertex().get(7));
			adjacencyMatrix.addEdge(adjacencyMatrix.getVertex().get(3), adjacencyMatrix.getVertex().get(8));
		}
		
		@Test
		void AdjacencyMatrixTest1(){
			setupScenario1();
			assertTrue(adjacencyMatrix!=null);	
		}
		
		//test creating a directed graph
		@Test
		void AdjacencyMatrixTest2(){
			adjacencyMatrix = new AdjacencyMatrix<City>(true);
			
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
		//edge cant be added
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
		//the graph is not directed
		@Test
		void addEdgeTest2() {
			setupScenario2();
			Vertex<City> vi = new Vertex<City>(new City(0+"",""));
			Vertex<City> va = new Vertex<City>(new City(1+"",""));
			boolean a = adjacencyMatrix.addEdge(vi, va);
			int b = adjacencyMatrix.getGraph()[0][1];
			int c = adjacencyMatrix.getGraph()[0][1];
			assertTrue(a&&(b==1)&&(c==1));
		}
		
		//test for adding a unweighted edge
		//when the matrix is full
		//the graph is not directed
		@Test
		void addEdgeTest3() {
			setupScenario3();
			Vertex<City> vi = new Vertex<City>(new City(0+"",""));
			Vertex<City> va = new Vertex<City>(new City(57+"",""));
			
			boolean b = adjacencyMatrix.addEdge(vi, va);
			assertTrue(!b);
		}
		
		//test for adding a unweighted edge
		//when the matrix is full
		//the graph is not directed
		@Test
		void addEdgeTest4() {
			setupScenario3();
			Vertex<City> vi = new Vertex<City>(new City(2+"",""));
			Vertex<City> va = new Vertex<City>(new City(10+"",""));
			boolean a = adjacencyMatrix.addEdge(vi, va);
			int b = adjacencyMatrix.getGraph()[2][10];
			int c = adjacencyMatrix.getGraph()[10][2];
			assertTrue(a&&(b==1)&&(c==1));
		}
		
		
		//test for adding a unweighted edge
		//when the matrix is full
		//the graph is directed
		@Test
		void addEdgeTest5() {
			setupScenario4();
			//must be 1 if there is a connection
			//must be 0 if there is not a connection
			int b = adjacencyMatrix.getGraph()[0][1];
			int c = adjacencyMatrix.getGraph()[1][0];
	
			assertTrue((b==1)&&(c==0));
		}		
		
		
		//test for adding a unweighted edge
		//when the matrix is full
		//the graph is directed
		@Test
		void addEdgeTest6() {
			setupScenario5();
			
			//must be 1 if there is a connection
			//must be 0 if there is not a connection
			int a = adjacencyMatrix.getGraph()[0][1];//1
			int b = adjacencyMatrix.getGraph()[1][0];//0
			
			int c = adjacencyMatrix.getGraph()[1][3];//1
			int d = adjacencyMatrix.getGraph()[3][1];//0
			
			int e = adjacencyMatrix.getGraph()[2][5];//1
			int f = adjacencyMatrix.getGraph()[5][2];//0
			
			int g = adjacencyMatrix.getGraph()[3][7];//1
			int h = adjacencyMatrix.getGraph()[7][3];//0
	
			assertTrue((a==1)&&(b==0)&&(c==1)&&(d==0)&&(e==1)&&(f==0)&&(g==1)&&(h==0));
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
		
		
		
<<<<<<< HEAD
		
				
//				@Test
//				void bfsTest1() {
//				setupScenario4();
//		
//				List<Integer> a=adjacencyMatrix.bfs(adjacencyMatrix.getVertex().get(0));
//				
//				List<Integer> b = new ArrayList<Integer>();	
//				
//				for(int i = 0; i<5;i++){
//					b.add(i);
//				}
//					
//				assertEquals(a,b);
//				
//				
//				}
//				
//				
//				@Test
//				void bfsTest2() {
//				setupScenario4();
//		
//				List<Integer> a=adjacencyMatrix.bfs(adjacencyMatrix.getVertex().get(0));
//				
//				List<Integer> b = new ArrayList<Integer>();	
//				
//				for(int i = 0; i<5;i++){
//					b.add(i);
//				}
//					
//				assertEquals(a,b);
//				
//				
//				}
				
		
						
=======
		@Test
		void bfsTest1() {
		setupScenario4();

		List<Integer> a=adjacencyMatrix.bfs(adjacencyMatrix.getVertex().get(0));
		
		
		for (int i = 0; i < adjacencyMatrix.getGraph()[0].length; i++) {
			
			System.out.println(Arrays.toString(adjacencyMatrix.getGraph()[i]));
		}
		
		List<Integer> b = new ArrayList<Integer>();	
		
		for(int i = 0; i<5;i++){
			b.add(i);
		}
		
		System.out.println(a.toString());
		System.out.println(b.toString());
		
		System.out.println("Estos sysos están en el test de bfs, Toño. Si quieres, los puedes borrar.");
		
		assertEquals(a,b);
		
		
		}
>>>>>>> 885da2ce27860bcfb253f698a85abe1eb3a84513
		
		
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
