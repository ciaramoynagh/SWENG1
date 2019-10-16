import static org.junit.Assert.*;

import org.junit.Test;

	public class DAGTest {
		
		@Test
		public void testEmpty() {
			DAG dag = new DAG(10);
			
			assertEquals(-1, dag.findLCA(2,3));

		}

		@Test
		public void testLCA()
		{
			DAG dag = new DAG(10);

	        dag.addEdge(0, 3);                  //     0
	        dag.addEdge(0, 5);                  //    / \
	        dag.addEdge(2, 7);                  //   2   5
	        dag.addEdge(5, 7);                  //    \ / \
	        dag.addEdge(7, 8);                  //     7   3
	        dag.addEdge(5, 9);                  //     |   |
	        dag.addEdge(9, 6);                  //     8   6

			assertEquals(0, dag.findLCA(0, 3));
			assertEquals(5, dag.findLCA(8, 6));
		    assertEquals(5, dag.findLCA(7, 6));
		}	

		@Test
		public void addAnEdge()
		{
			DAG dag = new DAG(10);
			
			dag.addEdge(1,2);
			dag.addEdge(3, 13);
			
			// edge will not be added as 13 is greater than 10
			
			assertEquals(1, dag.E());
		}	
		
		
		@Test 
		public void testVertex()
		{
			DAG dag = new DAG(10);
			assertEquals(10, dag.V());
			// check for negative vertex
			assertEquals(-1, dag.findLCA(-7, 1));
			// text for non present vertex
			assertEquals(-1, dag.findLCA(9, 6));
		}
		
		@Test
		public void testEdge(){
			
			DAG dag = new DAG(5);
			
			dag.addEdge(2, 2);
			dag.addEdge(2, 3);
			dag.addEdge(4, 4);
			
			assertEquals(3, dag.E());
		}
		
		@Test
		public void testForCycle()
		{
			DAG dag = new DAG(10);
			
			dag.addEdge(0, 1);
			dag.addEdge(1, 2);
			dag.addEdge(2, 0);
			dag.addEdge(2, 3);
			dag.addEdge(3, 4);
			dag.addEdge(4, 5);
			
			dag.findCycle(0);
			
			assertTrue(dag.hasCycle());
			
			dag.addEdge(5, 5);
			
			dag.findCycle(1);
			
			assertTrue(dag.hasCycle());
		}

		@Test
		public void testAdj()
		{
			DAG dag = new DAG(10);
			
			dag.addEdge(2, 6);
			dag.addEdge(4, 3);
			
			String adjacent = "[3]";
			assertEquals(adjacent, dag.adj(4).toString());
		}
		
		@Test
		public void testIndegree()
		{
			DAG dag = new DAG(10);
			
			dag.addEdge(1, 2);
			dag.addEdge(3, 4);
			dag.addEdge(5, 6);
			
			assertEquals(1, dag.indegree(4));
			assertEquals(-1, dag.indegree(12));
		}
		
		@Test
		public void testOutdegree()
		{
			DAG dag = new DAG(10);
			
			dag.addEdge(1, 2);
			dag.addEdge(3, 4);
			dag.addEdge(5, 6);
			
			assertEquals(1, dag.outdegree(5));
			assertEquals(-1, dag.outdegree(10));
		}
		
		@Test
		public void testNoCommonAncestorsOnLCA()
		{
			DAG dag = new DAG(10);
			
			dag.addEdge(0, 1);
			dag.addEdge(0, 3);
			dag.addEdge(1, 3);
			dag.addEdge(3, 2);
			dag.addEdge(2, 4);
			dag.addEdge(1, 5);
			dag.addEdge(2, 5);
			
			//Check LCA function works
			assertEquals(0, dag.findLCA(2, 1));
			assertEquals(3, dag.findLCA(2, 3));
			assertEquals(2, dag.findLCA(4, 5));
			
			//Check for negative vertices
			assertEquals(-1, dag.findLCA(-7, -7));
			assertEquals(-1, dag.findLCA(-8, 5));
			assertEquals(-1, dag.findLCA(6, -5));
			
			//Check for non-present vertices
			assertEquals(-1, dag.findLCA(9, 4));
		}
		
		@Test
		public void testLCAForSameVertex()
		{
			DAG dag = new DAG(10);
			
			dag.addEdge(1, 4);
			dag.addEdge(2, 8);
			dag.addEdge(9, 7);
			dag.addEdge(0, 3);
			dag.addEdge(6, 8);
			dag.addEdge(3, 2);
			
			assertEquals(5, dag.findLCA(5, 5));	
		}
	}

