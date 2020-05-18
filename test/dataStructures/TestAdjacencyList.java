
//TODO 
//bfs path, pathcost, containsV (if a vertex is in the array)
package dataStructures;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.InvalidBaseNumber;
import model.City;

class TestAdjacencyList {

	private AdjacencyList<City> adjacencylist;

	// empty graph
	private void setupScenario1() {

		this.adjacencylist = new AdjacencyList<City>(false);
	}

	// Graph with 10 vertexes
	void setupScenario2() {

		adjacencylist = new AdjacencyList<City>(false);

		for (int i = 0; i < 10; i++) {

			Vertex<City> vi = new Vertex<City>(new City(i + ""));
			adjacencylist.addVertex(vi);
		}
	}

	// Graph with 10 vertexes
	void setupScenario3() {

		adjacencylist = new AdjacencyList<City>(true);
		for (int i = 0; i < 10; i++) {
			Vertex<City> vi = new Vertex<City>(new City(i + ""));
			adjacencylist.addVertex(vi);
		}

		// 1 ---> 2 && 2 ----> 1
		adjacencylist.addEdge(adjacencylist.getVertex().get(1), adjacencylist.getVertex().get(2));
		adjacencylist.addEdge(adjacencylist.getVertex().get(2), adjacencylist.getVertex().get(1));

		// 2 ---> 5 && 2 ----> 6
		adjacencylist.addEdge(adjacencylist.getVertex().get(2), adjacencylist.getVertex().get(6));
		adjacencylist.addEdge(adjacencylist.getVertex().get(2), adjacencylist.getVertex().get(5));

		// 5 ---> 7 && 7 ----> 30
		adjacencylist.addEdge(adjacencylist.getVertex().get(5), adjacencylist.getVertex().get(7));
		adjacencylist.addEdge(adjacencylist.getVertex().get(7), adjacencylist.getVertex().get(9));

	}

	// there are 4 edges in this graph
	// the graph is directed
	void setupScenario4() {
		adjacencylist = new AdjacencyList<City>(false);

		for (int i = 0; i < 6; i++) {
			Vertex<City> vi = new Vertex<City>(new City(i + ""));
			adjacencylist.addVertex(vi);
		}

		adjacencylist.addEdge(adjacencylist.getVertex().get(1), adjacencylist.getVertex().get(3), 13);
		adjacencylist.addEdge(adjacencylist.getVertex().get(1), adjacencylist.getVertex().get(2), 17);

		adjacencylist.addEdge(adjacencylist.getVertex().get(2), adjacencylist.getVertex().get(3), 14);
		adjacencylist.addEdge(adjacencylist.getVertex().get(3), adjacencylist.getVertex().get(4), 5);
		adjacencylist.addEdge(adjacencylist.getVertex().get(2), adjacencylist.getVertex().get(4), 16);
		adjacencylist.addEdge(adjacencylist.getVertex().get(5), adjacencylist.getVertex().get(4), 4);
		adjacencylist.addEdge(adjacencylist.getVertex().get(5), adjacencylist.getVertex().get(2), 3);
	}

	// graph with 30 vertexes
	// the graph is directed
	// there are 8 edges in this graph
	void setupScenario5() {

		adjacencylist = new AdjacencyList<City>(true);
		for (int i = 0; i < 10; i++) {
			Vertex<City> vi = new Vertex<City>(new City(i + ""));
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

	// graph with 7 vertexes
	// the graph is directed
	// there are 9 edges in this graph
	void setupScenario6() {

		adjacencylist = new AdjacencyList<City>(true);

		for (int i = 0; i < 10; i++) {
			Vertex<City> vi = new Vertex<City>(new City(i + ""));
			adjacencylist.addVertex(vi);
		}

		// 0 ---> 1 && 0 ----> 2
		adjacencylist.addEdge(adjacencylist.getVertex().get(0), adjacencylist.getVertex().get(1), 100);
		adjacencylist.addEdge(adjacencylist.getVertex().get(0), adjacencylist.getVertex().get(2), 200);

		// 1 ---> 3 && 1 ----> 4
		adjacencylist.addEdge(adjacencylist.getVertex().get(1), adjacencylist.getVertex().get(3), 300);
		adjacencylist.addEdge(adjacencylist.getVertex().get(1), adjacencylist.getVertex().get(4), 250);

		// 2 ---> 5 && 2 ----> 6
		adjacencylist.addEdge(adjacencylist.getVertex().get(2), adjacencylist.getVertex().get(5), 500);
		adjacencylist.addEdge(adjacencylist.getVertex().get(2), adjacencylist.getVertex().get(6), 600);

		// 3 ---> 7 && 3 ----> 8
		adjacencylist.addEdge(adjacencylist.getVertex().get(3), adjacencylist.getVertex().get(7), 250);
		adjacencylist.addEdge(adjacencylist.getVertex().get(3), adjacencylist.getVertex().get(8), 400);

	}

	// graph with 7 vertexes
	// the graph is undirected
	// there are 9 edges in this graph
	void setupScenario7() {

		adjacencylist = new AdjacencyList<City>(false);

		for (int i = 0; i < 7; i++) {
			Vertex<City> vi = new Vertex<City>(new City(i + ""));
			adjacencylist.addVertex(vi);
		}

		// 1 ---> 2 && 1 ----> 3
		adjacencylist.addEdge(adjacencylist.getVertex().get(1), adjacencylist.getVertex().get(2), 4);
		adjacencylist.addEdge(adjacencylist.getVertex().get(1), adjacencylist.getVertex().get(3), 2);

		// 2 ---> 3 && 2 ----> 4
		adjacencylist.addEdge(adjacencylist.getVertex().get(2), adjacencylist.getVertex().get(3), 1);
		adjacencylist.addEdge(adjacencylist.getVertex().get(2), adjacencylist.getVertex().get(4), 5);

		// 3 ---> 5 && 3 ----> 4
		adjacencylist.addEdge(adjacencylist.getVertex().get(3), adjacencylist.getVertex().get(5), 10);
		adjacencylist.addEdge(adjacencylist.getVertex().get(3), adjacencylist.getVertex().get(4), 8);

		// 5 ---> 4 && 3 ----> 8
		adjacencylist.addEdge(adjacencylist.getVertex().get(5), adjacencylist.getVertex().get(4), 2);
		adjacencylist.addEdge(adjacencylist.getVertex().get(5), adjacencylist.getVertex().get(6), 3);

		// 6 ---> 4
		adjacencylist.addEdge(adjacencylist.getVertex().get(6), adjacencylist.getVertex().get(4), 6);

	}
	
	// graph with 9 vertexes
		// the graph is directed
		// there are 8 edges in this graph
		void setupScenario8() {

		
				adjacencylist= new AdjacencyList<City>(true);
			
			for (int i = 0; i < 5; i++) {
				Vertex<City> vi = new Vertex<City>(new City(i + ""));
				adjacencylist.addVertex(vi);
			}

			// 1 ---> 2 && 1 ----> 3
			adjacencylist.addEdge(adjacencylist.getVertex().get(1), adjacencylist.getVertex().get(2), 5);
			adjacencylist.addEdge(adjacencylist.getVertex().get(1), adjacencylist.getVertex().get(3), 9);

			// 2 ---> 3 && 3 ----> 4
			adjacencylist.addEdge(adjacencylist.getVertex().get(2), adjacencylist.getVertex().get(3), 1);
			adjacencylist.addEdge(adjacencylist.getVertex().get(3), adjacencylist.getVertex().get(4), 2);

			// 4 ----> 3
			adjacencylist.addEdge(adjacencylist.getVertex().get(4), adjacencylist.getVertex().get(2), 3);

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

		Vertex<City> vi = new Vertex<City>(new City(4 + ""));
		boolean b = this.adjacencylist.addVertex(vi);

		boolean c = this.adjacencylist.getVertex().contains(vi);

		assertTrue(b && c && adjacencylist.getSize() == 1);
	}

	@Test
	void AddVertexTest2() {
		setupScenario2();
		Vertex<City> vi = new Vertex<City>(new City(47 + ""));
		boolean b = this.adjacencylist.addVertex(vi);

		boolean c = this.adjacencylist.getVertex().contains(vi);
		assertTrue(c && b && adjacencylist.getSize() == 11);
	}

	@Test
	void AddVertexTest3() {
		setupScenario3();
		Vertex<City> vi = new Vertex<City>(new City(47 + ""));
		boolean b = this.adjacencylist.addVertex(vi);
		boolean c = this.adjacencylist.getVertex().contains(vi);

		assertTrue(c && b && adjacencylist.getSize() == 11);
	}

	@Test
	void removeVertexTest1() {
		setupScenario1();
		Vertex<City> vi = new Vertex<City>(new City(0 + ""));
		boolean b = adjacencylist.removeVertex(vi);
		assertTrue(!b);

	}

	@Test
	void removeVertexTest2() {
		setupScenario2();
		Vertex<City> vi = new Vertex<City>(new City(0 + ""));
		boolean b = adjacencylist.removeVertex(vi);
		assertTrue(b && adjacencylist.getSize() == 9);

	}

	@Test
	void removeVertexTest3() {
		setupScenario3();
		Vertex<City> vi = new Vertex<City>(new City(0 + ""));
		boolean b = adjacencylist.removeVertex(vi);
		assertTrue(b && adjacencylist.getSize() == 9);
	}

	// test for adding an unweighted edge
	// the graph is empty, therefore an
	// edge can�t be added
	@Test
	void addEdgeTest1() {
		setupScenario1();
		Vertex<City> vi = new Vertex<City>(new City(0 + ""));
		Vertex<City> va = new Vertex<City>(new City(1 + ""));
		boolean b = adjacencylist.addEdge(vi, va);
		assertTrue(!b);

	}

	// test for adding a unweighted edge
	// when the graph is not empty
	@Test
	void addEdgeTest2() {
		setupScenario2();
		// edge between 8 and 1
		Vertex<City> vi = new Vertex<City>(new City(8 + ""));
		Vertex<City> va = new Vertex<City>(new City(1 + ""));
		boolean b = adjacencylist.addEdge(vi, va);

		// edge between 8 and 3
		Vertex<City> vo = new Vertex<City>(new City(3 + ""));
		boolean c = adjacencylist.addEdge(vo, vi);

		// edge between 8 and 2
		Vertex<City> vu = new Vertex<City>(new City(2 + ""));
		boolean d = adjacencylist.addEdge(vu, vi);

		// edge between 8 and 0
		Vertex<City> ve = new Vertex<City>(new City(0 + ""));
		boolean e = adjacencylist.addEdge(ve, vi);

		Double x = adjacencylist.getGraph().get(0).get(0).get(0);// must be 8
		Double y = adjacencylist.getGraph().get(8).get(0).get(0);// must be 1

		Double w = adjacencylist.getGraph().get(3).get(0).get(0);// must be 8
		Double q = adjacencylist.getGraph().get(8).get(1).get(0);// must be 3

		Double r = adjacencylist.getGraph().get(2).get(0).get(0);// must be 8
		Double s = adjacencylist.getGraph().get(8).get(2).get(0);// must be 2

		assertTrue(b);
		assertTrue(c);
		assertTrue(d);
		assertTrue(e);

		assertTrue(x == 8);
		assertTrue(y == 1);
		assertTrue(w == 8);
		assertTrue(q == 3);
		assertTrue(r == 8);
		assertTrue(s == 2);
	}

	@Test
	void addEdgeTest3() {
		setupScenario2();

		// edge between 9 and 1
		Vertex<City> vi = new Vertex<City>(new City(9 + ""));
		Vertex<City> va = new Vertex<City>(new City(1 + ""));
		boolean b = adjacencylist.addEdge(vi, va);

		// edge between 9 and 5
		Vertex<City> vo = new Vertex<City>(new City(5 + ""));
		boolean c = adjacencylist.addEdge(vo, vi);

		// edge between 9 and 4
		Vertex<City> vu = new Vertex<City>(new City(4 + ""));
		boolean d = adjacencylist.addEdge(vu, vi);

		Double x = adjacencylist.getGraph().get(1).get(0).get(0);// must be 9
		Double y = adjacencylist.getGraph().get(9).get(0).get(0);// must be 1

		Double w = adjacencylist.getGraph().get(5).get(0).get(0);// must be 9
		Double q = adjacencylist.getGraph().get(9).get(1).get(0);// must be 5

		Double r = adjacencylist.getGraph().get(4).get(0).get(0);// must be 9
		Double s = adjacencylist.getGraph().get(9).get(2).get(0);// must be 4

		
		assertTrue(b);
		assertTrue(c);
		assertTrue(d);
		assertTrue(x == 9);
		assertTrue(y == 1);
		assertTrue(w == 9);
		assertTrue(q == 5);
		assertTrue(r == 9);
		assertTrue(s == 4);

	}

	// test for adding a unweighted edge
	// when the matrix is full
	// the graph is directed
	@Test
	void addEdgeTest4() {
		setupScenario5();

		Double x = adjacencylist.getGraph().get(0).get(0).get(0);// must be 1
		Double y = adjacencylist.getGraph().get(0).get(1).get(0);// must be 2

		Double w = adjacencylist.getGraph().get(1).get(0).get(0);// must be 3
		Double q = adjacencylist.getGraph().get(1).get(1).get(0);// must be 4

		Double r = adjacencylist.getGraph().get(2).get(0).get(0);// must be 5
		Double s = adjacencylist.getGraph().get(2).get(1).get(0);// must be 6

		Double t = adjacencylist.getGraph().get(3).get(0).get(0);// must be 7
		Double u = adjacencylist.getGraph().get(3).get(1).get(0);// must be 8

		assertTrue(x == 1);
		assertTrue(y == 2);
		assertTrue(w == 3);
		assertTrue(q == 4);
		assertTrue(r == 5);
		assertTrue(s == 6);
		assertTrue(t == 7);
		assertTrue(u == 8);
		
		
		

	}

	@Test
	void addEdgeWeightedTest1() {
		setupScenario1();
		Vertex<City> vi = new Vertex<City>(new City(0 + ""));
		Vertex<City> va = new Vertex<City>(new City(1 + ""));
		boolean b = adjacencylist.addEdge(vi, va, 100);
		assertTrue(!b);
	}

	@Test
	void addEdgeWeightedTest2() {

		setupScenario6();
		Double x = adjacencylist.getGraph().get(0).get(0).get(0);// must be 1
		Double xx = adjacencylist.getGraph().get(0).get(0).get(1);// must be 100
		Double y = adjacencylist.getGraph().get(0).get(1).get(0);// must be 2
		Double yy = adjacencylist.getGraph().get(0).get(1).get(1);// must be 200

		Double w = adjacencylist.getGraph().get(1).get(0).get(0);// must be 3
		Double ww = adjacencylist.getGraph().get(1).get(0).get(1);// must be 300
		Double q = adjacencylist.getGraph().get(1).get(1).get(0);// must be 4
		Double qq = adjacencylist.getGraph().get(1).get(1).get(1);// must be 250

		Double r = adjacencylist.getGraph().get(2).get(0).get(0);// must be 5
		Double rr = adjacencylist.getGraph().get(2).get(0).get(1);// must be 500
		Double s = adjacencylist.getGraph().get(2).get(1).get(0);// must be 6
		Double ss = adjacencylist.getGraph().get(2).get(1).get(1);// must be 600

		Double t = adjacencylist.getGraph().get(3).get(0).get(0);// must be 7
		Double tt = adjacencylist.getGraph().get(3).get(0).get(1);// must be 250
		Double u = adjacencylist.getGraph().get(3).get(1).get(0);// must be 8
		Double uu = adjacencylist.getGraph().get(3).get(1).get(1);// must be 600

		assertTrue(x == 1);
		assertTrue(xx == 100);
		assertTrue(y == 2);
		assertTrue(yy == 200);
		assertTrue(w == 3);
		assertTrue(ww == 300);
		assertTrue(q == 4);
		assertTrue(qq == 250);
		assertTrue(r == 5);
		assertTrue(rr == 500);
		assertTrue(s == 6);
		assertTrue(ss == 600);
		assertTrue(t == 7);
		assertTrue(tt == 250);
		assertTrue(u == 8);
		assertTrue(uu == 400);

	}

	@Test
	void addEdgeWeightedTest3() {
		setupScenario3();
		Vertex<City> vi = new Vertex<City>(new City(4 + ""));
		Vertex<City> va = new Vertex<City>(new City(0 + ""));
		boolean b = adjacencylist.addEdge(vi, va, 1000);

		Double t = adjacencylist.getGraph().get(4).get(0).get(0);// must be 0
		Double tt = adjacencylist.getGraph().get(4).get(0).get(1);// must be 1000
		assertTrue(t == 0);
		assertTrue(tt == 1000);
		assertTrue(b);
	}

	@Test
	void adjacentsTest1() {
		setupScenario5();
		// get the adjacent vertexes to the vertex 0
		List<Integer> a = adjacencylist.adjacents(0);
		List<Integer> b = new ArrayList<Integer>();
		b.add(1);
		b.add(2);

		
		assertEquals(a, b);

	}

	@Test
	void adjacentsTest2() {
		setupScenario7();
		// get the adjacent vertexes to the vertex 3
		List<Integer> a = adjacencylist.adjacents(2);
		List<Integer> b = new ArrayList<Integer>();
		b.add(1);
		b.add(3);
		b.add(4);

		assertEquals(a, b);

	}

	@Test
	void adjacentsTest3() {
		setupScenario7();
		// get the adjacent vertexes to the vertex 3
		List<Integer> a = adjacencylist.adjacents(4);
		List<Integer> b = new ArrayList<Integer>();
		b.add(2);
		b.add(3);
		b.add(5);
		b.add(6);

		assertEquals(a, b);

	}

	@Test
	void searchIndexTest1() {
		setupScenario2();
		Vertex<City> vi = new Vertex<City>(new City(0 + ""));
		int a = adjacencylist.searchIndex(vi);
		int b = 0;

		assertEquals(a, b);

	}

	@Test
	void searchIndexTest2() {
		setupScenario1();
		Vertex<City> vi = new Vertex<City>(new City(0 + ""));
		int a = adjacencylist.searchIndex(vi);
		int b = -1;

		assertEquals(a, b);

	}

	@Test
	void searchIndexTest3() {
		setupScenario3();
		Vertex<City> vi = new Vertex<City>(new City(9 + ""));
		int a = adjacencylist.searchIndex(vi);
		int b = 9;

		assertEquals(a, b);

	}

	@Test
	void bfsTest1() {
		setupScenario4();

		Vertex<City> z = adjacencylist.getVertex().get(1);

		List<Vertex<City>> a = adjacencylist.bfs(z);
		List<Vertex<City>> b = new ArrayList<Vertex<City>>();

		b.add(null);
		b.add(null);
		b.add(adjacencylist.getVertex().get(1));
		b.add(adjacencylist.getVertex().get(1));
		b.add(adjacencylist.getVertex().get(3));
		b.add(adjacencylist.getVertex().get(2));
	

	
	
	assertEquals(a, b);

	}

	@Test
	void bfsTest2() {
		setupScenario6();

		Vertex<City> z = adjacencylist.getVertex().get(0);

		List<Vertex<City>> a = adjacencylist.bfs(z);

		List<Vertex<City>> b = new ArrayList<Vertex<City>>();

		
		b.add(null);
		b.add(adjacencylist.getVertex().get(0));
		b.add(adjacencylist.getVertex().get(0));
		b.add(adjacencylist.getVertex().get(1));
		b.add(adjacencylist.getVertex().get(1));
		b.add(adjacencylist.getVertex().get(2));
		b.add(adjacencylist.getVertex().get(2));
		b.add(adjacencylist.getVertex().get(3));
		b.add(adjacencylist.getVertex().get(3));
		b.add(null);
		
		assertEquals(a, b);

	}

	@Test
	void dfsTest1() {
		setupScenario4();

		List<Integer> a = adjacencylist.dfs(adjacencylist.getVertex().get(1));

		List<Integer> b = new ArrayList<Integer>();

		b.add(1);
		b.add(2);
		b.add(5);
		b.add(4);
		b.add(3);

		
		assertEquals(a, b);

	}

	@Test
	void dfsTest2() {
		setupScenario3();

		List<Integer> a = adjacencylist.dfs(adjacencylist.getVertex().get(1));
		List<Integer> b = new ArrayList<Integer>();
		
		b.add(1);
		b.add(2);
		b.add(5);
		b.add(7);
		b.add(9);
		b.add(6);
		

		
		assertEquals(a, b);

	}

	@Test
	void dfsTest3() {
		setupScenario7();

		List<Integer> a = adjacencylist.dfs(adjacencylist.getVertex().get(1));
		List<Integer> b = new ArrayList<Integer>();

		b.add(1);
		b.add(3);
		b.add(4);
		b.add(6);
		b.add(5);
		b.add(2);
		

		assertEquals(a, b);

	}

	@Test
	void fWTest1() {
		setupScenario4();
		double d = Double.MAX_VALUE;
		double[][] a = { { 0.0,d, d, d, d, d },
				         { d,0.0, 17.0, 13.0, 18.0, 20.0 },
				         { d,17.0, 0.0, 12.0, 7.0, 3.0 }, 
				         {d, 13.0, 12.0, 0.0, 5.0, 9.0 },
				         { d,18.0, 7.0, 5.0, 0.0, 4.0 },
				         {d, 20.0, 3.0, 9.0, 4.0, 0.0 }, };

		double[][] b = adjacencylist.floydWarshall();

		
	boolean flag = true;
	for(int i=0; i<a.length;i++) {
			
			for(int j = 0; j< a[0].length;j++) {
				if(a[i][j]!=b[i][j]) {
					flag = false;
				}
			}
		}

	 assertTrue(flag);
	}

	@Test
	void fWTest2() {
		setupScenario8();
		double d = Double.MAX_VALUE;
		// the resulting matrix must be like this one
		double[][] a = {  { 0.0,d, d, d, d },
				         {d, 0.0, 5.0, 6.0, 8.0 },
			        	{ d,d, 0.0, 1.0, 3.0 }, 
				        {d, d, 5.0, 0.0, 2.0 }, 
				        {d, d, 3.0, 4.0, 0.0 } };
		double[][] b = adjacencylist.floydWarshall();

		
		
		boolean flag = true;
		for(int i=0; i<b.length;i++) {
				
				for(int j = 0; j< b[0].length;j++) {
					if(a[i][j]!=b[i][j]) {
						flag = false;
					}
				}
			}

		 assertTrue(flag);
	

	}

	@Test
	void primsAlgorithmTest1() {
		setupScenario7();
		
		List <Vertex<City>>a = adjacencylist.buildMSTPrim(adjacencylist.getVertex().get(0).getElement());
		List <Vertex<City>>b = new ArrayList<Vertex<City>>();
	
		
		b.add(null);
		b.add(adjacencylist.getVertex().get(3));
		b.add(adjacencylist.getVertex().get(3));
		b.add(adjacencylist.getVertex().get(4));
		b.add(adjacencylist.getVertex().get(5));
		b.add(adjacencylist.getVertex().get(6));
		b.add(null);
		assertEquals(a,b);
	}
	
	@Test
	void primsAlgorithmTest2() {
		setupScenario4();
		
		List <Vertex<City>>a = adjacencylist.buildMSTPrim(adjacencylist.getVertex().get(0).getElement());
		List <Vertex<City>>b = new ArrayList<Vertex<City>>();
		
		b.add(null);
		b.add(adjacencylist.getVertex().get(3));
		b.add(adjacencylist.getVertex().get(5));
		b.add(adjacencylist.getVertex().get(4));
		b.add(adjacencylist.getVertex().get(5));
		b.add(null);
		assertEquals(a,b);
	}

	@Test
	void kruskalTest1() {
		setupScenario1();
		for (int i = 0; i < 6; i++) {
			Vertex<City> vi = new Vertex<City>(new City(i + ""));
			adjacencylist.addVertex(vi);
		}

		// 1 ---> 2 && 1 ----> 3 && 1 ----> 5
		adjacencylist.addEdge(adjacencylist.getVertex().get(1), adjacencylist.getVertex().get(2), 2);
		adjacencylist.addEdge(adjacencylist.getVertex().get(1), adjacencylist.getVertex().get(3), 4);
		adjacencylist.addEdge(adjacencylist.getVertex().get(1), adjacencylist.getVertex().get(5), 2);
		// 3 ---> 5 && 3 ----> 4 
		adjacencylist.addEdge(adjacencylist.getVertex().get(3), adjacencylist.getVertex().get(5), 3);
		adjacencylist.addEdge(adjacencylist.getVertex().get(3), adjacencylist.getVertex().get(4), 1);
		
		// 2 ---> 4 && 2 ----> 5
		adjacencylist.addEdge(adjacencylist.getVertex().get(2), adjacencylist.getVertex().get(4), 3);
		adjacencylist.addEdge(adjacencylist.getVertex().get(2), adjacencylist.getVertex().get(5), 3);
		
		// 5 ---> 4
		adjacencylist.addEdge(adjacencylist.getVertex().get(5), adjacencylist.getVertex().get(4), 2);




	}

	@Test
	void kruskalTest2() {
		setupScenario1();
		for (int i = 0; i < 5; i++) {
			Vertex<City> vi = new Vertex<City>(new City(i + ""));
			adjacencylist.addVertex(vi);
		}

		// 1 ---> 2 && 1 ----> 3 && 1 ----> 5
		adjacencylist.addEdge(adjacencylist.getVertex().get(1), adjacencylist.getVertex().get(2), 10);
		adjacencylist.addEdge(adjacencylist.getVertex().get(1), adjacencylist.getVertex().get(3), 7);
		adjacencylist.addEdge(adjacencylist.getVertex().get(2), adjacencylist.getVertex().get(3), 5);
		//  3 ----> 4 
		adjacencylist.addEdge(adjacencylist.getVertex().get(2), adjacencylist.getVertex().get(4), 5);

	}

	

	@Test
	void djikstraTest1() {
		setupScenario7();
		List<Vertex<City>> a = adjacencylist.dijkstra(adjacencylist.getVertex().get(1).getElement());
		
		// la lista de los indices de predecesores
		// esta deberia ser asi si es correcto el algoritmo
		// b = {null, null, 3, 1, 2, 4, 5}
		List<Vertex<City>> b = new ArrayList<Vertex<City>>();
		// this null position
		// is from the vertex
		// in the index 0
		b.add(null);
		b.add(null);
		b.add(adjacencylist.getVertex().get(3));
		b.add(adjacencylist.getVertex().get(1));
		b.add(adjacencylist.getVertex().get(2));
		b.add(adjacencylist.getVertex().get(4));
		b.add(adjacencylist.getVertex().get(5));

		assertEquals(a, b);
	}

	@Test
	void djikstraTest2() {
		setupScenario1();

		for (int i = 0; i < 7; i++) {
			Vertex<City> vi = new Vertex<City>(new City(i + ""));
			adjacencylist.addVertex(vi);
		}

		// 1 ---> 2 && 1 ----> 3
		adjacencylist.addEdge(adjacencylist.getVertex().get(1), adjacencylist.getVertex().get(2), 2);
		adjacencylist.addEdge(adjacencylist.getVertex().get(1), adjacencylist.getVertex().get(3), 3);

		// 2 ---> 4 && 2 ----> 5
		adjacencylist.addEdge(adjacencylist.getVertex().get(2), adjacencylist.getVertex().get(4), 5);
		adjacencylist.addEdge(adjacencylist.getVertex().get(2), adjacencylist.getVertex().get(5), 2);

		// 3 ---> 5
		adjacencylist.addEdge(adjacencylist.getVertex().get(3), adjacencylist.getVertex().get(5), 5);
		adjacencylist.addEdge(adjacencylist.getVertex().get(3), adjacencylist.getVertex().get(4), 8);

		// 4 ---> 5 && 3 ----> 8
		adjacencylist.addEdge(adjacencylist.getVertex().get(4), adjacencylist.getVertex().get(5), 1);
		adjacencylist.addEdge(adjacencylist.getVertex().get(5), adjacencylist.getVertex().get(6), 4);

		// 6 ---> 4
		adjacencylist.addEdge(adjacencylist.getVertex().get(6), adjacencylist.getVertex().get(4), 2);

		List<Vertex<City>> a = adjacencylist.dijkstra(adjacencylist.getVertex().get(1).getElement());
			
		// la lista de los indices de predecesores
		// esta deberia ser asi si es correcto el algoritmo
		// b = {null, null, 1, 1, 5, 2, 4}
		List<Vertex<City>> b = new ArrayList<Vertex<City>>();
		// this null position
		// is from the vertex
		// in the index 0
		b.add(null);
		b.add(null);
		b.add(adjacencylist.getVertex().get(1));
		b.add(adjacencylist.getVertex().get(1));
		b.add(adjacencylist.getVertex().get(5));
		b.add(adjacencylist.getVertex().get(2));
		b.add(adjacencylist.getVertex().get(4));

		assertEquals(a, b);
	}
	
	
	@Test
	void pathCostTest() {
		setupScenario4();
		double a =adjacencylist.pathCost(adjacencylist.getVertex().get(1).getElement(), adjacencylist.getVertex().get(5).getElement());
		double b = 40.0;
		
		assertTrue(a==b);
	}
	
	@Test
	void pathCostTest1() {
		setupScenario7();
		double a =adjacencylist.pathCost(adjacencylist.getVertex().get(1).getElement(), adjacencylist.getVertex().get(6).getElement());
		double b = 39.0;
		
		assertTrue(a==b);
	}
	
	
	@Test
	void bfsPathTest() {
		setupScenario3();
		ArrayList<City> a =adjacencylist.bfsPath(adjacencylist.getVertex().get(1).getElement(), adjacencylist.getVertex().get(9).getElement());
		ArrayList<City> b = new ArrayList<City>();
	
		
		b.add(adjacencylist.getVertex().get(1).getElement());
		b.add(adjacencylist.getVertex().get(2).getElement());
		b.add(adjacencylist.getVertex().get(5).getElement());
		b.add(adjacencylist.getVertex().get(7).getElement());
		b.add(adjacencylist.getVertex().get(9).getElement());
		
		boolean flag = true;
		
		for (int i = 0; i < a.size(); i++) {
			if(a.get(i)!=b.get(i)) {
				flag =false;
			}
		}
		
		assertTrue(flag);
		
	}
	
	@Test
	void bfsPathTest1() {
		setupScenario7();
		ArrayList<City> a =adjacencylist.bfsPath(adjacencylist.getVertex().get(1).getElement(), adjacencylist.getVertex().get(3).getElement());
		ArrayList<City> b = new ArrayList<City>();
		
		b.add(adjacencylist.getVertex().get(1).getElement());
		b.add(adjacencylist.getVertex().get(3).getElement());
		b.add(adjacencylist.getVertex().get(5).getElement());
		
		
		boolean flag = true;
		
		for (int i = 0; i < a.size(); i++) {
			if(a.get(i)!=b.get(i)) {
				flag =false;
			}
		}
		
		assertTrue(flag);
	}
	
	@Test
	void bfsPathTest2() {
		setupScenario4();
		ArrayList<City> a =adjacencylist.bfsPath(adjacencylist.getVertex().get(1).getElement(), adjacencylist.getVertex().get(5).getElement());
		ArrayList<City> b = new ArrayList<City>();
		
		
		b.add(adjacencylist.getVertex().get(1).getElement());
		b.add(adjacencylist.getVertex().get(2).getElement());
		b.add(adjacencylist.getVertex().get(5).getElement());
	
		
		boolean flag = true;
		
		for (int i = 0; i < a.size(); i++) {
			if(a.get(i)!=b.get(i)) {
				flag =false;
			}
		}
		
		assertTrue(flag);
	}
	
	
	
	@Test
	void dijkstraPathTest() {
		setupScenario7();
		ArrayList<City> a = adjacencylist.dijkstraPath(adjacencylist.getVertex().get(1).getElement(),
				adjacencylist.getVertex().get(6).getElement());
		ArrayList<City> b = new ArrayList<City>();

		b.add(adjacencylist.getVertex().get(1).getElement());
		b.add(adjacencylist.getVertex().get(3).getElement());
		b.add(adjacencylist.getVertex().get(2).getElement());
		b.add(adjacencylist.getVertex().get(4).getElement());
		b.add(adjacencylist.getVertex().get(5).getElement());
		b.add(adjacencylist.getVertex().get(6).getElement());

		boolean flag = true;

		for (int i = 0; i < a.size(); i++) {
			if (a.get(i) != b.get(i)) {
				flag = false;
			}
		}
	

		assertTrue(flag);
		
		assertTrue(flag);
		
	}
	
	@Test
	void dijkstraPathTest1() {
		setupScenario4();
		ArrayList<City> a = adjacencylist.dijkstraPath(adjacencylist.getVertex().get(1).getElement(),
				adjacencylist.getVertex().get(5).getElement());
		ArrayList<City> b = new ArrayList<City>();

		b.add(adjacencylist.getVertex().get(1).getElement());
		b.add(adjacencylist.getVertex().get(2).getElement());
		b.add(adjacencylist.getVertex().get(5).getElement());

		boolean flag = true;

		for (int i = 0; i < a.size(); i++) {
			if (a.get(i) != b.get(i)) {
				flag = false;
			}
		}
		
	
		assertTrue(flag);
	}


}