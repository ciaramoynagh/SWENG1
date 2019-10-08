import static org.junit.Assert.*;
import org.junit.Test;

public class LCATest {

	@Test
	public void testEmpty() {
		LCA.BT tree = new LCA.BT();
		
		assertEquals(tree.findLCA(1,4), -1);
		assertEquals(tree.findLCA(2,3), -1);
		
	}
	
	@Test
	public void testTwoNodes() {
		LCA.BT tree = new LCA.BT();
		
		tree.root = new LCA.Node(1);
		tree.root.left = new LCA.Node(2);
		
		assertEquals(tree.findLCA(1,2), 1);
	}	
	
	@Test
	public void testThreeNodes() {
		LCA.BT tree = new LCA.BT();
		
		tree.root = new LCA.Node(1);
		tree.root.left = new LCA.Node(2);
		tree.root.right = new LCA.Node(3);
		
		assertEquals(tree.findLCA(2,3), 1);
	}
}

