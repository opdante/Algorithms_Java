package data_structures.naryTree;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class NTreeTest {
	
	Tree<String> tree;
	
	@Before
    public void setUp() {
		tree = new Tree<>();
		NTreeNode<String> rootA = new NTreeNode<String>("A");
	    NTreeNode<String> childB = new NTreeNode<String>("B");
	    NTreeNode<String> childC = new NTreeNode<String>("C");
	    NTreeNode<String> childD = new NTreeNode<String>("D");
	    NTreeNode<String> childE = new NTreeNode<String>("E");
	    NTreeNode<String> childF = new NTreeNode<String>("F");
	    NTreeNode<String> childG = new NTreeNode<String>("G");
	    NTreeNode<String> childH = new NTreeNode<String>("H");
	    NTreeNode<String> childI = new NTreeNode<String>("I");
	    NTreeNode<String> childJ = new NTreeNode<String>("J");
	    NTreeNode<String> childK = new NTreeNode<String>("K");
	    NTreeNode<String> childL = new NTreeNode<String>("L");
	    childI.addChild(childL);
	    childC.addChild(childI);
	    childC.addChild(childJ);
	    childC.addChild(childG);
	    childC.addChild(childH);
	    childB.addChild(childE);
	    childB.addChild(childF);
	    childD.addChild(childK);
        rootA.addChild(childB);
        rootA.addChild(childC);
        rootA.addChild(childD);
        
        tree.setRoot(rootA);
	    
	}
	
	@Test
	public void testLeaves(){
		List<List<String>> expected = asList(
				asList("E", "F", "L", "J", "G", "H", "K"),
				asList("B", "I", "D"),
				asList("C"),
				asList("A"));
		
		List<List<String>> a  = tree.fallingLeaves();
		assertTrue("Expected 'a' and 'expected' to be equal."+
	            "\n  'a'        = "+a+
	            "\n  'expected' = "+expected, 
	            expected.equals(a));
	}

}
