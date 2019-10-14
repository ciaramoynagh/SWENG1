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

}
