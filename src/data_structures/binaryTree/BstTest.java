package data_structures.binaryTree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import static java.util.Arrays.*;
import java.util.List;

public class BstTest {
	List<Integer> elems;
	BinarySearchTree<Integer> tree;
	
	@Before
    public void setUp() {
		elems = asList(40, 25, 78, 10, 3, 17, 32, 100, 30, 38, 75, 50, 93, 150);
		tree = new BinarySearchTree<>();
		tree.insert(elems);
	}
	
	@Test
	public void testInOrder(){
		List<Integer> a = asList(3, 10, 17, 25, 30, 32, 38, 40, 50, 75, 78, 93, 100, 150);
		List<Integer> expected = tree.inorder();
		assertTrue("Expected 'a' and 'expected' to be equal."+
	            "\n  'a'        = "+a+
	            "\n  'expected' = "+expected, 
	            expected.equals(a));
	}
	
	@Test 
	public void testPreOrder(){
		List<Integer> a = asList(40, 25, 10, 3, 17, 32, 30, 38, 78, 75, 50, 100, 93, 150);
		List<Integer> expected = tree.preorder();
		assertTrue("Expected 'a' and 'expected' to be equal."+
	            "\n  'a'        = "+a+
	            "\n  'expected' = "+expected, 
	            expected.equals(a));
	}
	
	@Test 
	public void testPostOrder(){
		List<Integer> a = asList(3, 17, 10, 30, 38, 32, 25, 50, 75, 93, 150, 100, 78, 40);
		List<Integer> expected = tree.postorder();
		assertTrue("Expected 'a' and 'expected' to be equal."+
	            "\n  'a'        = "+a+
	            "\n  'expected' = "+expected, 
	            expected.equals(a));
	}
	
	@Test
	public void testSearch(){
		assertTrue(tree.search(32));
		assertTrue(tree.search(200) == false);
	}
	
	@Test
	public void testHeight(){
		assertEquals(tree.height(), 4);
	}
	
	@Test
	public void testLeaves(){
		List<List<Integer>> a = asList(
				asList(3, 17, 30, 38, 50, 93, 150),
				asList(10, 32, 75, 100),
				asList(25, 78),
				asList(40));
		
		List<List<Integer>> expected = tree.findLeaves();
		assertTrue("Expected 'a' and 'expected' to be equal."+
	            "\n  'a'        = "+a+
	            "\n  'expected' = "+expected, 
	            expected.equals(a));
	}
	
}
