package dataStructures;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.City;

class TestAdjacencyList {

	private AdjacencyList<City> adjacencylist;
	
	//empty graph
	private void setupScenario1() {
		
		this.adjacencylist = new AdjacencyList<City>(false);
	}
	
	//Graph with 10 vertexes
		void setupScenario2() {
			
			adjacencylist = new AdjacencyList<City>(false);
			
			for(int i = 0; i<10; i++) {
				
				Vertex<City> vi = new Vertex<City>(new City(i+""));
				adjacencylist.addVertex(vi);
			}
		}

		//Graph with 30 vertexes
		void setupScenario3() {
			
			adjacencylist = new AdjacencyList<City>(false);
			for(int i = 0; i<30; i++) {
				Vertex<City> vi = new Vertex<City>(new City(i+""));
				adjacencylist.addVertex(vi);
			}
		}
		
		//there are 4 edges in this graph
		//the graph is directed
		void setupScenario4() {
		adjacencylist = new AdjacencyList<City>(true);
		for(int i = 0; i<30; i++) {
			Vertex<City> vi = new Vertex<City>(new City(i+""));
			adjacencylist.addVertex(vi);
		}
					
		// 0 ---> 1 && 0 ----> 2
		adjacencylist.addEdge(adjacencylist.getVertex().get(0), adjacencylist.getVertex().get(1));
		adjacencylist.addEdge(adjacencylist.getVertex().get(0), adjacencylist.getVertex().get(2));
		
		// 1 ---> 3 && 1 ----> 4
		adjacencylist.addEdge(adjacencylist.getVertex().get(1), adjacencylist.getVertex().get(3));
		adjacencylist.addEdge(adjacencylist.getVertex().get(1), adjacencylist.getVertex().get(4));
	}
						
				
				
		//graph with 30 vertexes
		//the graph is directed
		//there are 8 edges in this graph
		void setupScenario5() {
			
			adjacencylist = new AdjacencyList<City>(true);
			for(int i = 0; i<10; i++) {
				Vertex<City> vi = new Vertex<City>(new City(i+""));
				adjacencylist.addVertex(vi);
			}
			
			// 0 ---> 1 && 0 ----> 2
			adjacencylist.addEdge(adjacencylist.getVertex().get(0), adjacencylist.getVertex().get(1));
			adjacencylist.addEdge(adjacencylist.getVertex().get(0), adjacencylist.getVertex().get(2));
			
			// 1 ---> 3 && 1 ----> 4
			adjacencylist.addEdge(adjacencylist.getVertex().get(1), adjacencylist.getVertex().get(3));
			adjacencylist.addEdge(adjacencylist.getVertex().get(1), adjacencylist.getVertex().get(4));
			
			// 3 ---> 5 && 3 ----> 6
			adjacencylist.addEdge(adjacencylist.getVertex().get(2), adjacencylist.getVertex().get(5));
			adjacencylist.addEdge(adjacencylist.getVertex().get(2), adjacencylist.getVertex().get(6));
			
			// 4 ---> 7 && 4 ----> 8
			adjacencylist.addEdge(adjacencylist.getVertex().get(3), adjacencylist.getVertex().get(7));
			adjacencylist.addEdge(adjacencylist.getVertex().get(3), adjacencylist.getVertex().get(8));
		}
		
				//graph with 7 vertexes
				//the graph is undirected
				//there are 9 edges in this graph
				void setupScenario6() {
							
					adjacencylist = new AdjacencyList<City>(false);
					for(int i = 0; i<7; i++) {
						Vertex<City> vi = new Vertex<City>(new City(i+""));
						adjacencylist.addVertex(vi);
					}
					
					// 1 ---> 2 && 1 ----> 3
					adjacencylist.addEdge(adjacencylist.getVertex().get(1), adjacencylist.getVertex().get(2),4);
					adjacencylist.addEdge(adjacencylist.getVertex().get(1), adjacencylist.getVertex().get(3),2);
					
					// 2 ---> 3 && 2 ----> 4 
					adjacencylist.addEdge(adjacencylist.getVertex().get(2), adjacencylist.getVertex().get(3),1);
					adjacencylist.addEdge(adjacencylist.getVertex().get(2), adjacencylist.getVertex().get(4),5);
				

					// 3 ---> 5 && 3 ----> 4
					adjacencylist.addEdge(adjacencylist.getVertex().get(3), adjacencylist.getVertex().get(5),10);
					adjacencylist.addEdge(adjacencylist.getVertex().get(3), adjacencylist.getVertex().get(4),8);
					
					// 5 ---> 4 && 3 ----> 8
					adjacencylist.addEdge(adjacencylist.getVertex().get(5), adjacencylist.getVertex().get(4),2);
					adjacencylist.addEdge(adjacencylist.getVertex().get(5), adjacencylist.getVertex().get(6),3);
					
					// 6 ---> 4
					adjacencylist.addEdge(adjacencylist.getVertex().get(6), adjacencylist.getVertex().get(4),6);
					
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
		
		Vertex<City> vi = new Vertex<City>(new City(4+""));
		boolean b = this.adjacencylist.addVertex(vi);
		
		boolean c = this.adjacencylist.getVertex().contains(vi);
		
		assertTrue(b&&c&&adjacencylist.getSize()==1);
	}
	
	
	@Test
	void AddVertexTest2() {
		setupScenario2();
		Vertex<City> vi = new Vertex<City>(new City(47+""));
		boolean b = this.adjacencylist.addVertex(vi);
		
		assertTrue(b&&adjacencylist.getSize()==11);
	}
	
	@Test
	void AddVertexTest3() {
		setupScenario3();
		Vertex<City> vi = new Vertex<City>(new City(47+""));
		boolean b = this.adjacencylist.addVertex(vi);
		
		assertTrue(b&&adjacencylist.getSize()==31);
	}


	@Test
	 void removeVertexTest1() {
		setupScenario1();
		Vertex<City> vi = new Vertex<City>(new City(0+""));
		boolean b = adjacencylist.removeVertex(vi);
		assertTrue(!b);
		
	}
	
	@Test
	 void removeVertexTest2() {
		setupScenario2();
		Vertex<City> vi = new Vertex<City>(new City(0+""));
		boolean b = adjacencylist.removeVertex(vi);
		assertTrue(b&&adjacencylist.getSize()==9);
		
	}
	
	@Test
	 void removeVertexTest3() {
		setupScenario3();
		Vertex<City> vi = new Vertex<City>(new City(0+""));
		boolean b = adjacencylist.removeVertex(vi);
		assertTrue(b&&adjacencylist.getSize()==29);
	}

	//test for adding an unweighted edge
	//the graph is empty, therefore an
	//edge can´t be added
	@Test
	 void addEdgeTest1() {
		setupScenario1();
		Vertex<City> vi = new Vertex<City>(new City(0+""));
		Vertex<City> va = new Vertex<City>(new City(1+""));
		boolean b = adjacencylist.addEdge(vi,va);
		assertTrue(!b);
	}
	
	//test for adding a unweighted edge
	//when the graph is not empty
	@Test
	 void addEdgeTest2() {
		setupScenario2();
		Vertex<City> vi = new Vertex<City>(new City(0+""));
		Vertex<City> va = new Vertex<City>(new City(1+""));
		boolean b = adjacencylist.addEdge(vi,va);
		assertTrue(b);
	}
	
	@Test
	 void addEdgeTest3() {
		setupScenario3();
		Vertex<City> vi = new Vertex<City>(new City(0+""));
		Vertex<City> va = new Vertex<City>(new City(1+""));
		boolean b = adjacencylist.addEdge(vi,va);
		assertTrue(b);
	}
	
	//test for adding a unweighted edge
			//when the matrix is full
			//the graph is not directed
			@Test
			void addEdgeTest4() {
				setupScenario3();
				Vertex<City> vi = new Vertex<City>(new City(2+""));
				Vertex<City> va = new Vertex<City>(new City(10+""));
				boolean a = adjacencylist.addEdge(vi, va);
				assertTrue(a);
				
			}
			
			
			//test for adding a unweighted edge
			//when the matrix is full
			//the graph is directed
			@Test
			void addEdgeTest5() {
				setupScenario4();
				//must be 1 if there is a connection
				//must be 0 if there is not a connection

			}

	@Test
	 void addEdgeWeightedTest1() {
		setupScenario1();
		Vertex<City> vi = new Vertex<City>(new City(0+""));
		Vertex<City> va = new Vertex<City>(new City(1+""));
		boolean b = adjacencylist.addEdge(vi,va,100);
		assertTrue(!b);
	}
	
	@Test
	 void addEdgeWeightedTest2() {
		setupScenario2();
		Vertex<City> vi = new Vertex<City>(new City(0+""));
		Vertex<City> va = new Vertex<City>(new City(1+""));
		boolean b = adjacencylist.addEdge(vi,va,200);
		assertTrue(b);
		
	}
	
	@Test
	 void addEdgeWeightedTest3() {
		setupScenario3();
		Vertex<City> vi = new Vertex<City>(new City(4+""));
		Vertex<City> va = new Vertex<City>(new City(10+""));
		boolean b = adjacencylist.addEdge(vi,va,1000);
		assertTrue(b);
	}
	
	@Test
	void adjacentsTest1() {
	setupScenario5();
	//get the adjacent vertexes to the vertex 0
	List<Integer> a = adjacencylist.adjacents(0);
	List<Integer> b = new ArrayList<Integer>();
	b.add(1);
	b.add(2);
	
	System.out.println("adja list"+a.toString());
	System.out.println("adja "+b.toString());
	assertEquals(a,b);
	
	}
	
	
	@Test
	void adjacentsTest2() {
	setupScenario5();
	//get the adjacent vertexes to the vertex 3
	List<Integer> a = adjacencylist.adjacents(3);
	List<Integer> b = new ArrayList<Integer>();
	b.add(7);
	b.add(8);
	
	System.out.println("adja"+a.toString());
	System.out.println("adja "+b.toString());
	assertEquals(a,b);
	
	}
	
	
	@Test
	void adjacentsTest3() {
	setupScenario5();
	//get the adjacent vertexes to the vertex 3
	List<Integer> a = adjacencylist.adjacents(2);
	List<Integer> b = new ArrayList<Integer>();
	b.add(5);
	b.add(8);
	
	System.out.println("adja"+a.toString());
	System.out.println("adja "+b.toString());
	assertNotEquals(a,b);
	
	}
	
	
	
	@Test
	void searchIndexTest1() {
	setupScenario2();
	Vertex<City> vi = new Vertex<City>(new City(0+""));
	int a = adjacencylist.searchIndex(vi);
	int b = 0;
	
	assertEquals(a,b);
	
	
	}
	
	@Test
	void searchIndexTest2() {
	setupScenario1();
	Vertex<City> vi = new Vertex<City>(new City(0+""));
	int a = adjacencylist.searchIndex(vi);
	int b = -1;
	
	assertEquals(a,b);
	
	
	}
	
	@Test
	void searchIndexTest3() {
	setupScenario3();
	Vertex<City> vi = new Vertex<City>(new City(19+""));
	int a = adjacencylist.searchIndex(vi);
	int b = 19;
	
	assertEquals(a,b);
	
	
	}
	
	@Test
	void bfsTest1() {
		setupScenario4();
		
		Vertex<City> z =adjacencylist.getVertex().get(0);
		
		List<City> a=adjacencylist.bfs(z);
		
		
		List<Integer> b = new ArrayList<Integer>();	
		
		for(int i = 0; i<5;i++){
			b.add(i);
		}
		
		System.out.println(a.toString());
		System.out.println(b.toString());
				
		assertEquals(a,b);
	
	}
	
	
	@Test
	void bfsTest2() {
	
	
	
	}
	
	
	@Test
	void dfsTest1() {
	
	
	}
	
	
	@Test
	void dfsTest2() {
	
	
	
	}
	
	@Test
	void primsAlgorithmTest1() {
	
	}
	
	@Test
	void kruskalAlgorithmTest1() {
	
	}
	@Test
	void kruskalAlgorithmTest2() {
	
	}
	
	@Test
	void primsAlgorithmTest2() {
	
	}
	
	
	@Test
	void djikstraTest1() {
	
	}
	
	@Test
	void djikstraTest2() {
	
	}
	

}