package data_structures.binaryTree;

public abstract class AbstractTree<E extends Comparable<E>>
	implements Tree<E>{
	
	// Check if the tree is empty
	public boolean isEmpty() {
	    return getSize() == 0;
	}
}
