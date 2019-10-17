import static org.junit.Assert.*;
import org.junit.Test;

public class LCATest {

	@Test
	public void testEmpty() {
		LCA.BT tree = new LCA.BT(); 
		tree.root = null;

		assertEquals("Null root will return -1", tree.findLCA(1,4), -1);
		assertEquals("Null root will return -1", tree.findLCA(2,3), -1);
	}
	
	@Test
	public void testTwoNodes() {
		LCA.BT tree = new LCA.BT();

		tree.root = new LCA.Node(1);
		tree.root.left = new LCA.Node(2);

		assertEquals("Root should be 1", tree.findLCA(1,2), 1);
	}	

	@Test
	public void testThreeNodes() {
		LCA.BT tree = new LCA.BT();

		tree.root = new LCA.Node(1);
		tree.root.left = new LCA.Node(2);
		tree.root.right = new LCA.Node(3);

		assertEquals("LCA(2,3) should be 1",tree.findLCA(2,3), 1);
	}

	@Test
	public void testManyNodes() {
		LCA.BT tree = new LCA.BT();

		tree.root = new LCA.Node(1);
		tree.root.left = new LCA.Node(2);
		tree.root.right = new LCA.Node(3);
		tree.root.left.left = new LCA.Node(4); 
		tree.root.left.right = new LCA.Node(5); 
		tree.root.right.left = new LCA.Node(6); 
		tree.root.right.right = new LCA.Node(7); 

		assertEquals("LCA (4, 5) should be 2", tree.findLCA(4, 5), 2);
		assertEquals("LCA(4, 6) should be 1", tree.findLCA(4, 6), 1);
		assertEquals("LCA(3, 4) should be 3", tree.findLCA(6, 7), 3);

	}
	
	@Test
	public void testNodeNotInTree() {
		LCA.BT tree = new LCA.BT();
		
		tree.root = new LCA.Node(1);
		tree.root.left = new LCA.Node(2);
		tree.root.right = new LCA.Node(3);
		tree.root.left.left = new LCA.Node(4); 
		tree.root.left.right = new LCA.Node(5); 
		tree.root.right.left = new LCA.Node(6); 
		tree.root.right.right = new LCA.Node(7); 

		assertEquals(-1, tree.findLCA(42,37));
		assertEquals(-1, tree.findLCA(28,77));
	}
}
