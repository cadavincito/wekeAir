package dataStructures;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.InvalidBaseNumber;
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

		//Graph with 10 vertexes
		void setupScenario3() {
			
			adjacencylist = new AdjacencyList<City>(true);
			for(int i = 0; i<10; i++) {
				Vertex<City> vi = new Vertex<City>(new City(i+""));
				adjacencylist.addVertex(vi);
			}
		}
		
		//there are 4 edges in this graph
		//the graph is directed
		void setupScenario4() {
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
				//the graph is directed
				//there are 9 edges in this graph
				void setupScenario6() {
							
					adjacencylist = new AdjacencyList<City>(true);
					
					for(int i = 0; i<10; i++) {
						Vertex<City> vi = new Vertex<City>(new City(i+""));
						adjacencylist.addVertex(vi);
					}
					
					// 0 ---> 1 && 0 ----> 2
					adjacencylist.addEdge(adjacencylist.getVertex().get(0), adjacencylist.getVertex().get(1),100);
					adjacencylist.addEdge(adjacencylist.getVertex().get(0), adjacencylist.getVertex().get(2),200);
					
					// 1 ---> 3 && 1 ----> 4
					adjacencylist.addEdge(adjacencylist.getVertex().get(1), adjacencylist.getVertex().get(3),300);
					adjacencylist.addEdge(adjacencylist.getVertex().get(1), adjacencylist.getVertex().get(4),250);
					
					// 2 ---> 5 && 2 ----> 6
					adjacencylist.addEdge(adjacencylist.getVertex().get(2), adjacencylist.getVertex().get(5),500);
					adjacencylist.addEdge(adjacencylist.getVertex().get(2), adjacencylist.getVertex().get(6),600);
					
					// 3 ---> 7 && 3 ----> 8
					adjacencylist.addEdge(adjacencylist.getVertex().get(3), adjacencylist.getVertex().get(7),250);
					adjacencylist.addEdge(adjacencylist.getVertex().get(3), adjacencylist.getVertex().get(8),400);
					
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
		
		assertTrue(b&&adjacencylist.getSize()==11);
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
		assertTrue(b&&adjacencylist.getSize()==9);
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
				//edge between 8 and 1
				Vertex<City> vi = new Vertex<City>(new City(8+""));
				Vertex<City> va = new Vertex<City>(new City(1+""));
				boolean b = adjacencylist.addEdge(vi,va);
				
				//edge between 8 and 3
			    Vertex<City> vo = new Vertex<City>(new City(3+""));
				boolean c = adjacencylist.addEdge(vo,vi);
				
				//edge between 8 and 2
			    Vertex<City> vu = new Vertex<City>(new City(2+""));
				boolean d = adjacencylist.addEdge(vu,vi);
				
				//edge between 8 and 0
			    Vertex<City> ve = new Vertex<City>(new City(0+""));
				boolean e = adjacencylist.addEdge(ve,vi);
				
				
				Double x =adjacencylist.getGraph().get(0).get(0).get(0);//must be 8
				Double y =adjacencylist.getGraph().get(8).get(0).get(0);//must be 1
				
				Double w =adjacencylist.getGraph().get(3).get(0).get(0);//must be 8
				Double q =adjacencylist.getGraph().get(8).get(1).get(0);//must be 3
				
				Double r =adjacencylist.getGraph().get(2).get(0).get(0);//must be 8
				Double s =adjacencylist.getGraph().get(8).get(2).get(0);//must be 2
				
				
			
				System.out.println("addEdgeTest3: "+x+" "+y);
				
				assertTrue(b);
				assertTrue(c);
				assertTrue(d);
				assertTrue(e);

				assertTrue(x==8);
				assertTrue(y==1);
				assertTrue(w==8);
				assertTrue(q==3);
				assertTrue(r==8);
				assertTrue(s==2);
	}
	
	@Test
	 void addEdgeTest3() {
		setupScenario2();
		
		//edge between 9 and 1
		Vertex<City> vi = new Vertex<City>(new City(9+""));
		Vertex<City> va = new Vertex<City>(new City(1+""));
		boolean b = adjacencylist.addEdge(vi,va);
		
		//edge between 9 and 5
	    Vertex<City> vo = new Vertex<City>(new City(5+""));
		boolean c = adjacencylist.addEdge(vo,vi);
		
		//edge between 9 and 4
	    Vertex<City> vu = new Vertex<City>(new City(4+""));
		boolean d = adjacencylist.addEdge(vu,vi);
		
		
		Double x =adjacencylist.getGraph().get(1).get(0).get(0);//must be 9
		Double y =adjacencylist.getGraph().get(9).get(0).get(0);//must be 1
		
		Double w =adjacencylist.getGraph().get(5).get(0).get(0);//must be 9
		Double q =adjacencylist.getGraph().get(9).get(1).get(0);//must be 5
		
		Double r =adjacencylist.getGraph().get(4).get(0).get(0);//must be 9
		Double s =adjacencylist.getGraph().get(9).get(2).get(0);//must be 4
	
		System.out.println("addEdgeTest3: "+x+" "+y);
		
		assertTrue(b);
		assertTrue(c);
		assertTrue(d);
		assertTrue(x==9);
		assertTrue(y==1);
		assertTrue(w==9);
		assertTrue(q==5);
		assertTrue(r==9);
		assertTrue(s==4);
		
		
	}
	
			//test for adding a unweighted edge
			//when the matrix is full
			//the graph is  directed
			@Test
			void addEdgeTest4() {
				setupScenario5();
				
				Double x =adjacencylist.getGraph().get(0).get(0).get(0);//must be 1
				Double y =adjacencylist.getGraph().get(0).get(1).get(0);//must be 2
				
					
				Double w =adjacencylist.getGraph().get(1).get(0).get(0);//must be 3
				Double q =adjacencylist.getGraph().get(1).get(1).get(0);//must be 4
				
				Double r =adjacencylist.getGraph().get(2).get(0).get(0);//must be 5
				Double s =adjacencylist.getGraph().get(2).get(1).get(0);//must be 6
				
				Double t =adjacencylist.getGraph().get(3).get(0).get(0);//must be 7
				Double u =adjacencylist.getGraph().get(3).get(1).get(0);//must be 8
				
				
								
				assertTrue(x==1);
				assertTrue(y==2);
				assertTrue(w==3);
				assertTrue(q==4);
				assertTrue(r==5);
				assertTrue(s==6);
				assertTrue(t==7);
				assertTrue(u==8);
				
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
		
		setupScenario6();
		Double x =adjacencylist.getGraph().get(0).get(0).get(0);//must be 1
		Double xx =adjacencylist.getGraph().get(0).get(0).get(1);//must be 100
		Double y =adjacencylist.getGraph().get(0).get(1).get(0);//must be 2
		Double yy =adjacencylist.getGraph().get(0).get(1).get(1);//must be 200

		
			
		Double w =adjacencylist.getGraph().get(1).get(0).get(0);//must be 3
		Double ww =adjacencylist.getGraph().get(1).get(0).get(1);//must be 300
		Double q =adjacencylist.getGraph().get(1).get(1).get(0);//must be 4
		Double qq =adjacencylist.getGraph().get(1).get(1).get(1);//must be 250

		
		Double r =adjacencylist.getGraph().get(2).get(0).get(0);//must be 5
		Double rr =adjacencylist.getGraph().get(2).get(0).get(1);//must be 500
		Double s =adjacencylist.getGraph().get(2).get(1).get(0);//must be 6
		Double ss =adjacencylist.getGraph().get(2).get(1).get(1);//must be 600
		
		Double t =adjacencylist.getGraph().get(3).get(0).get(0);//must be 7
		Double tt =adjacencylist.getGraph().get(3).get(0).get(1);//must be 250
		Double u =adjacencylist.getGraph().get(3).get(1).get(0);//must be 8
		Double uu =adjacencylist.getGraph().get(3).get(1).get(1);//must be 600
		
		
		System.out.println(xx + "weight "+ uu);
						
		assertTrue(x==1);
		assertTrue(xx==100);
		assertTrue(y==2);
		assertTrue(yy==200);
		assertTrue(w==3);
		assertTrue(ww==300);
		assertTrue(q==4);
		assertTrue(qq==250);
		assertTrue(r==5);
		assertTrue(rr==500);
		assertTrue(s==6);
		assertTrue(ss==600);
		assertTrue(t==7);
		assertTrue(tt==250);
		assertTrue(u==8);
		assertTrue(uu==400);
		
		
	}
	
	@Test
	 void addEdgeWeightedTest3() {
		setupScenario3();
		Vertex<City> vi = new Vertex<City>(new City(4+""));
		Vertex<City> va = new Vertex<City>(new City(0+""));
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
	Vertex<City> vi = new Vertex<City>(new City(9+""));
	int a = adjacencylist.searchIndex(vi);
	int b = 9;
	
	assertEquals(a,b);
	
	
	}
	
	@Test
	void bfsTest1() {
		setupScenario4();
		
		Vertex<City> z =adjacencylist.getVertex().get(0);
		
		List<Integer> a=adjacencylist.bfs(z);
		
		
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