package data_structures.binaryTree;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import static java.util.Arrays.*;
import java.util.List;

public class AVLTest {
	List<Integer> elems;
	AVLTree<Integer> tree;
	
	@Before
    public void setUp() {
		elems = asList(40, 25, 78, 10, 3, 17, 32, 100, 30, 38, 75, 50, 93, 150);
		tree = new AVLTree<>();
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

}
