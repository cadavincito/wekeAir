package dataStructures;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.InvalidBaseNumber;
import model.City;

class TestAdjacencyMatrix {
	
		//undirected graph with 0 vertexes
		AdjacencyMatrix<City> adjacencyMatrix;
		void setupScenario1() {
			adjacencyMatrix = new AdjacencyMatrix<City>(false);
		}
		
		//undirected graph with 10 vertexes
		void setupScenario2() {
			adjacencyMatrix = new AdjacencyMatrix<City>(true);
			for(int i = 0; i<10; i++) {
				Vertex<City> vi = new Vertex<City>(new City(i+""));
				adjacencyMatrix.addVertex(vi);
			}
		}
		
		
		//undirected graph with 10 vertexes
		void setupScenario3() {
			adjacencyMatrix = new AdjacencyMatrix<City>(false);
			for(int i = 0; i<10; i++) {
				Vertex<City> vi = new Vertex<City>(new City(i+""));
				adjacencyMatrix.addVertex(vi);
			}
			// 1 ---> 2 && 2 ----> 1
			adjacencyMatrix.addEdge(adjacencyMatrix.getVertex().get(1), adjacencyMatrix.getVertex().get(2));
			adjacencyMatrix.addEdge(adjacencyMatrix.getVertex().get(2), adjacencyMatrix.getVertex().get(1));
			
			// 2 ---> 5 && 2 ----> 6
			adjacencyMatrix.addEdge(adjacencyMatrix.getVertex().get(2), adjacencyMatrix.getVertex().get(6));
			adjacencyMatrix.addEdge(adjacencyMatrix.getVertex().get(2), adjacencyMatrix.getVertex().get(5));	
			
			// 5 ---> 7 && 7 ----> 30
			adjacencyMatrix.addEdge(adjacencyMatrix.getVertex().get(5), adjacencyMatrix.getVertex().get(7));
			adjacencyMatrix.addEdge(adjacencyMatrix.getVertex().get(7), adjacencyMatrix.getVertex().get(9));	
			
			
		}

		//there are 4 edges in this graph
		//the graph is not directed
		void setupScenario4() {
			try {
				adjacencyMatrix = new AdjacencyMatrix<City>(false,7);
			} catch (InvalidBaseNumber e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int i = 0; i<6; i++) {
				Vertex<City> vi = new Vertex<City>(new City(i+""));
				adjacencyMatrix.addVertex(vi);
			}
			
			
			adjacencyMatrix.addEdge(adjacencyMatrix.getVertex().get(1), adjacencyMatrix.getVertex().get(3),13);
			adjacencyMatrix.addEdge(adjacencyMatrix.getVertex().get(1), adjacencyMatrix.getVertex().get(2),17);
			
		
			adjacencyMatrix.addEdge(adjacencyMatrix.getVertex().get(2), adjacencyMatrix.getVertex().get(3),14);
			adjacencyMatrix.addEdge(adjacencyMatrix.getVertex().get(3), adjacencyMatrix.getVertex().get(4),5);
			adjacencyMatrix.addEdge(adjacencyMatrix.getVertex().get(2), adjacencyMatrix.getVertex().get(4),16);
			adjacencyMatrix.addEdge(adjacencyMatrix.getVertex().get(5), adjacencyMatrix.getVertex().get(4),4);
			adjacencyMatrix.addEdge(adjacencyMatrix.getVertex().get(5), adjacencyMatrix.getVertex().get(2),3);



		}
				
		
		
		//graph with 9 vertexes
		//the graph is directed
		//there are 8 edges in this graph
		void setupScenario5() {
			
			adjacencyMatrix = new AdjacencyMatrix<City>(true);
			for(int i = 0; i<10; i++) {
				Vertex<City> vi = new Vertex<City>(new City(i+""));
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
		
		//graph with 10 vertexes
		//the graph is directed
		//there are 8 edges in this graph
		void setupScenario6() {
			
			try {
				adjacencyMatrix = new AdjacencyMatrix<City>(true,10);
			} catch (InvalidBaseNumber e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int i = 0; i<10; i++) {
				Vertex<City> vi = new Vertex<City>(new City(i+""));
				adjacencyMatrix.addVertex(vi);
			}
			
			// 0 ---> 1 && 0 ----> 2
			adjacencyMatrix.addEdge(adjacencyMatrix.getVertex().get(0), adjacencyMatrix.getVertex().get(1),100);
			adjacencyMatrix.addEdge(adjacencyMatrix.getVertex().get(0), adjacencyMatrix.getVertex().get(2),200);
			
			// 1 ---> 3 && 1 ----> 4
			adjacencyMatrix.addEdge(adjacencyMatrix.getVertex().get(1), adjacencyMatrix.getVertex().get(3),300);
			adjacencyMatrix.addEdge(adjacencyMatrix.getVertex().get(1), adjacencyMatrix.getVertex().get(4),250);
			
			// 2 ---> 5 && 2 ----> 6
			adjacencyMatrix.addEdge(adjacencyMatrix.getVertex().get(2), adjacencyMatrix.getVertex().get(5),500);
			adjacencyMatrix.addEdge(adjacencyMatrix.getVertex().get(2), adjacencyMatrix.getVertex().get(6),600);
			
			// 3 ---> 7 && 3 ----> 8
			adjacencyMatrix.addEdge(adjacencyMatrix.getVertex().get(3), adjacencyMatrix.getVertex().get(7),250);
			adjacencyMatrix.addEdge(adjacencyMatrix.getVertex().get(3), adjacencyMatrix.getVertex().get(8),400);
		}
		
		//graph with 7 vertexes
		//the graph is undirected
		//there are 9 edges in this graph
		void setupScenario7() {
					
			try {
				adjacencyMatrix = new AdjacencyMatrix<City>(false,10);
			} catch (InvalidBaseNumber e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int i = 0; i<7; i++) {
				Vertex<City> vi = new Vertex<City>(new City(i+""));
				adjacencyMatrix.addVertex(vi);
			}
			
			// 1 ---> 2 && 1 ----> 3
			adjacencyMatrix.addEdge(adjacencyMatrix.getVertex().get(1), adjacencyMatrix.getVertex().get(2),4);
			adjacencyMatrix.addEdge(adjacencyMatrix.getVertex().get(1), adjacencyMatrix.getVertex().get(3),2);
			
			// 2 ---> 3 && 2 ----> 4 
			adjacencyMatrix.addEdge(adjacencyMatrix.getVertex().get(2), adjacencyMatrix.getVertex().get(3),1);
			adjacencyMatrix.addEdge(adjacencyMatrix.getVertex().get(2), adjacencyMatrix.getVertex().get(4),5);
		

			// 3 ---> 5 && 3 ----> 4
			adjacencyMatrix.addEdge(adjacencyMatrix.getVertex().get(3), adjacencyMatrix.getVertex().get(5),10);
			adjacencyMatrix.addEdge(adjacencyMatrix.getVertex().get(3), adjacencyMatrix.getVertex().get(4),8);
			
			// 5 ---> 4 && 3 ----> 8
			adjacencyMatrix.addEdge(adjacencyMatrix.getVertex().get(5), adjacencyMatrix.getVertex().get(4),2);
			adjacencyMatrix.addEdge(adjacencyMatrix.getVertex().get(5), adjacencyMatrix.getVertex().get(6),3);
			
			// 6 ---> 4
			adjacencyMatrix.addEdge(adjacencyMatrix.getVertex().get(6), adjacencyMatrix.getVertex().get(4),6);
			
		}
		
		//graph with 9 vertexes
				//the graph is directed
				//there are 8 edges in this graph
				void setupScenario8() {
					
					try {
						adjacencyMatrix = new AdjacencyMatrix<City>(true,7);
					} catch (InvalidBaseNumber e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					for(int i = 0; i<5; i++) {
						Vertex<City> vi = new Vertex<City>(new City(i+""));
						adjacencyMatrix.addVertex(vi);
					}
					
					// 1 ---> 2 && 1 ----> 3
					adjacencyMatrix.addEdge(adjacencyMatrix.getVertex().get(1), adjacencyMatrix.getVertex().get(2),5);
					adjacencyMatrix.addEdge(adjacencyMatrix.getVertex().get(1), adjacencyMatrix.getVertex().get(3),9);
					
					// 2 ---> 3 && 3 ----> 4
					adjacencyMatrix.addEdge(adjacencyMatrix.getVertex().get(2), adjacencyMatrix.getVertex().get(3),1);
					adjacencyMatrix.addEdge(adjacencyMatrix.getVertex().get(3), adjacencyMatrix.getVertex().get(4),2);
					
				    //4 ----> 3
					adjacencyMatrix.addEdge(adjacencyMatrix.getVertex().get(4), adjacencyMatrix.getVertex().get(2),3);
				
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
			Vertex<City> vi = new Vertex<City>(new City(10+""));
			boolean b = adjacencyMatrix.addVertex(vi);
			
			assertTrue(b&&(adjacencyMatrix.getSize()==1));
			
		}
		
		@Test
		void addVertexTest2() {
			setupScenario2();
			Vertex<City> vi = new Vertex<City>(new City(10+""));
			boolean b = adjacencyMatrix.addVertex(vi);
			
			assertTrue(b&&(adjacencyMatrix.getSize()==11));
			
		}		
		//we test when the graph is full 
		@Test
		void addVertexTest3() {
			setupScenario3();
			Vertex<City> vi = new Vertex<City>(new City(30+""));
			boolean b = adjacencyMatrix.addVertex(vi);
			assertTrue(b&&(adjacencyMatrix.getSize()==11));
		}
		
		
		@Test
		void removeVertexTest1() {
			setupScenario1();
			Vertex<City> vi = new Vertex<City>(new City(0+""));
			boolean b = adjacencyMatrix.removeVertex(vi);
			assertTrue(!b);
		
		}
		
		@Test
		void removeVertexTest2() {
			setupScenario2();
			Vertex<City> vi = new Vertex<City>(new City(0+""));
			boolean b = adjacencyMatrix.removeVertex(vi);
			assertTrue(b&&adjacencyMatrix.getSize()==9);
		}
		
		@Test
		void removeVertexTest3() {
			setupScenario3();
			Vertex<City> vi = new Vertex<City>(new City(0+""));
			boolean b = adjacencyMatrix.removeVertex(vi);
			assertTrue(b&&adjacencyMatrix.getSize()==9);
		}
		
		//test for adding an unweighted edge
		//the graph is empty, therefore an
		//edge cant be added
		@Test
		void addEdgeTest1() {
			setupScenario1();
			Vertex<City> vi = new Vertex<City>(new City(0+""));
			Vertex<City> va = new Vertex<City>(new City(1+""));
			boolean b = adjacencyMatrix.addEdge(vi, va);
			assertTrue(!b);
		}
		
		//test for adding a unweighted edge
		//when the graph is not empty
		//the graph is not directed
		@Test
		void addEdgeTest2() {
			setupScenario2();
			Vertex<City> vi = new Vertex<City>(new City(0+""));
			Vertex<City> va = new Vertex<City>(new City(1+""));
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
			Vertex<City> vi = new Vertex<City>(new City(0+""));
			Vertex<City> va = new Vertex<City>(new City(57+""));
			
			boolean b = adjacencyMatrix.addEdge(vi, va);
			assertTrue(!b);
		}
		
		//test for adding a unweighted edge
		//when the matrix is full
		//the graph is not directed
		@Test
		void addEdgeTest4() {
			setupScenario3();
			Vertex<City> vi = new Vertex<City>(new City(2+""));
			Vertex<City> va = new Vertex<City>(new City(9+""));
			boolean a = adjacencyMatrix.addEdge(vi, va);
			int b = adjacencyMatrix.getGraph()[2][9];
			int c = adjacencyMatrix.getGraph()[9][2];
			assertTrue(a&&(b==1)&&(c==1));
		}
		
		
		//test for adding a unweighted edge
		//when the matrix is full
		//the graph is not  directed
		@Test
		void addEdgeTest5() {
			setupScenario4();
			//must be 1 if there is a connection
			//must be 0 if there is not a connection
			int b = adjacencyMatrix.getGraph()[1][3];
			int c = adjacencyMatrix.getGraph()[3][1];
	
			assertTrue((b==1)&&(c==1));
		}		
		
		
		//test for adding a unweighted edge
		//when the matrix is full
		//the graph is directed
		@Test
		void addEdgeTest6() {
			setupScenario6();
			
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
			Vertex<City> vi = new Vertex<City>(new City(0+""));
			Vertex<City> va = new Vertex<City>(new City(1+""));
			boolean b = adjacencyMatrix.addEdge(vi, va,100);
			assertTrue(!b);
		}
		
		//test for adding a weighted edge
		//in a directed graph
		@Test
		void addWeightedEdgeTest2() {
			setupScenario2();
			Vertex<City> vi = new Vertex<City>(new City(0+""));
			Vertex<City> va = new Vertex<City>(new City(1+""));
			Vertex<City> ve = new Vertex<City>(new City(2+""));
			Vertex<City> vo = new Vertex<City>(new City(3+""));
			Vertex<City> vu = new Vertex<City>(new City(4+""));
			
			boolean a = adjacencyMatrix.addEdge(vi, va,200);
			boolean b = adjacencyMatrix.addEdge(va, ve,100);
			boolean c = adjacencyMatrix.addEdge(ve, vo,300);
			boolean d = adjacencyMatrix.addEdge(vo, vu,300);
			assertTrue(a);
			assertTrue(b);
			assertTrue(c);
			assertTrue(d);
			int g = adjacencyMatrix.getGraph()[0][1];//1
			int gg = adjacencyMatrix.getGraph()[1][0];//0
			
			int h = adjacencyMatrix.getGraph()[1][2];//1
			int hh = adjacencyMatrix.getGraph()[2][1];//0
			
			int l = adjacencyMatrix.getGraph()[2][3];//1
			int ll = adjacencyMatrix.getGraph()[3][2];//0
			
			int t = adjacencyMatrix.getGraph()[3][4];//1
			int tt = adjacencyMatrix.getGraph()[4][3];//0
			
			
			assertTrue((g==1)&&(gg==0));
			assertTrue((h==1)&&(hh==0));
			assertTrue((l==1)&&(ll==0));
			assertTrue((t==1)&&(tt==0));
			
		}
		
		//test for adding a weighted edge
		@Test
		void addWeightedEdgeTest3() {
			setupScenario3();
			Vertex<City> vi = new Vertex<City>(new City(9+""));
			Vertex<City> va = new Vertex<City>(new City(1+""));
			boolean b = adjacencyMatrix.addEdge(vi, va,300);
			assertTrue(b);
		}
		
		
		//test for adding a weighted edge
		@Test
		void addWeightedEdgeTest4() {
			setupScenario3();
			Vertex<City> vi = new Vertex<City>(new City(2+""));
			Vertex<City> va = new Vertex<City>(new City(9+""));
			boolean a = adjacencyMatrix.addEdge(vi, va,200);
			int b = adjacencyMatrix.getGraph()[2][9];
			int c = adjacencyMatrix.getGraph()[9][2];
			assertTrue(a&&(b==1)&&(c==1));
		}
		
		

		

	
		
		
		@Test
		void adjacentsTest1() {
		setupScenario6();
		//get the adjacent vertexes to the vertex 0
		List<Integer> a = adjacencyMatrix.adjacents(0);
		List<Integer> b = new ArrayList<Integer>();
		b.add(1);
		b.add(2);
		
		
		assertEquals(a,b);
		
		}
		
		@Test
		void adjacentsTest2() {
		setupScenario6();
		//get the adjacent vertexes to the vertex 3
		List<Integer> a = adjacencyMatrix.adjacents(3);
		List<Integer> b = new ArrayList<Integer>();
		b.add(7);
		b.add(8);
		
		
		assertEquals(a,b);
		
		}
		
		
		@Test
		void adjacentsTest3() {
		setupScenario6();
		//get the adjacent vertexes to the vertex 3
		List<Integer> a = adjacencyMatrix.adjacents(2);
		List<Integer> b = new ArrayList<Integer>();
		b.add(5);
		b.add(6);
		
	
		assertEquals(a,b);
		
		}
		
		@Test
		void searchIndexTest1() {
		setupScenario2();
		Vertex<City> vi = new Vertex<City>(new City(0+""));
		int a = adjacencyMatrix.searchIndex(vi);
		int b = 0;
		
		assertEquals(a,b);
		
		
		}
		
		@Test
		void searchIndexTest2() {
		setupScenario1();
		Vertex<City> vi = new Vertex<City>(new City(0+""));
		int a = adjacencyMatrix.searchIndex(vi);
		int b = -1;
		assertEquals(a,b);
		}
		
		@Test
		void searchIndexTest3() {
		setupScenario3();
		Vertex<City> vi = new Vertex<City>(new City(9+""));
		int a = adjacencyMatrix.searchIndex(vi);
		int b = 9;
		assertEquals(a,b);
		}

		
		@Test
		void bfsTest1() {
		setupScenario4();

		List<Integer> a=adjacencyMatrix.bfs(adjacencyMatrix.getVertex().get(1));
		List<Integer> b = new ArrayList<Integer>();	
		
		for(int i = 1; i<6;i++){
			b.add(i);
		}
		
				
		assertEquals(a,b);
		
		
		}
		
		
		
		
		
		@Test
		void bfsTest2() {
		setupScenario3();

		List<Integer> a=adjacencyMatrix.bfs(adjacencyMatrix.getVertex().get(2));
		List<Integer> b = new ArrayList<Integer>();	
		
		b.add(2);
		b.add(1);
		b.add(5);
		b.add(6);
		b.add(7);
		b.add(9);
		
	
		assertEquals(a,b);
		
		
		}
		
		@Test
		void bfsTest3() {
		setupScenario7();

		List<Integer> a=adjacencyMatrix.bfs(adjacencyMatrix.getVertex().get(1));
		List<Integer> b = new ArrayList<Integer>();	
		
		b.add(1);
		b.add(2);
		b.add(3);
		b.add(4);
		b.add(5);
		b.add(6);
		
	
				
		assertEquals(a,b);
		
		
		}
		
		
		@Test
		void dfsTest1() {
		setupScenario4();

		List<Integer> a=adjacencyMatrix.dfs(adjacencyMatrix.getVertex().get(1));
		
		
		List<Integer> b = new ArrayList<Integer>();	
		
		b.add(1);
		b.add(3);
		b.add(4);
		b.add(5);
		b.add(2);
	
		assertEquals(a,b);
		
		
		}
		
		
		
		
		
		
		@Test
		void dfsTest2() {
		setupScenario3();

		List<Integer> a=adjacencyMatrix.dfs(adjacencyMatrix.getVertex().get(2));
		List<Integer> b = new ArrayList<Integer>();	
		
		b.add(2);
		b.add(6);
		b.add(5);
		b.add(7);
		b.add(9);
		b.add(1);
		
		assertEquals(a,b);
		
		
		}
		
		@Test
		void dfsTest3() {
		setupScenario7();

		List<Integer> a=adjacencyMatrix.dfs(adjacencyMatrix.getVertex().get(1));
		List<Integer> b = new ArrayList<Integer>();	
		
		b.add(1);
		b.add(3);
		b.add(5);
		b.add(6);
		b.add(4);
		b.add(2);
		
		assertEquals(a,b);
		
		
		}
		
		@Test
		void primsAlgorithmTest1() {
		setupScenario7();
		}
		
		@Test
		void primsAlgorithmTest2() {
		setupScenario3();
		
		}
		
		@Test
		void kruskalTest1() {
		setupScenario7();
		}
		
		@Test
		void kruskalTest2() {
		setupScenario3();
		
		}
		
		
		@Test
		void djikstraTest1() {
			setupScenario7();
			List<Vertex<City>> a = adjacencyMatrix.dijkstra(adjacencyMatrix.getVertex().get(3).getElement());
			System.out.println("djikstra: "+a);
			
			
			
			
			
		}
		
		@Test
		void djikstraTest2() {
			setupScenario4();
			List<Vertex<City>> a = adjacencyMatrix.dijkstra(adjacencyMatrix.getVertex().get(3).getElement());
			System.out.println("djikstra 2: "+a);
		}
		
		@Test
		void fWTest1() {
			setupScenario4();
			int d = adjacencyMatrix.getWeights().length;
			double[][] a= {
					    {0.0,17.0,13.0,18.0,20.0},
					   {17.0, 0.0, 12.0, 7.0, 3.0},
					   {13.0, 12.0, 0.0, 5.0, 9.0},
					   {18.0, 7.0, 5.0, 0.0, 4.0},
					   {20.0, 3.0, 9.0, 4.0, 0.0},};
			
					
			double [][] b = adjacencyMatrix.floydWarshall();
			
			//System.out.println(Arrays.deepToString(b).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
				assertEquals(a,b);
			
			
				System.out.println();
			
				
		}
		
		
		@Test
		void fWTest2() {
			setupScenario8();
		double d = Double.MAX_VALUE;
		//the resulting matrix must be like this one
		double[][] a= {
				   {0.0,5.0,6.0,8.0},
				   {d, 0.0, 1.0, 3.0},
				   {d, 5.0, 0.0, 2.0},
				   {d, 3.0, 4.0, 0.0}};
		double [][] b = adjacencyMatrix.floydWarshall();
		
		//System.out.println(Arrays.deepToString(b).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
			assertEquals(a,b);
		
		
			
		}

}
