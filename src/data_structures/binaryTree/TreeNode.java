package data_structures.binaryTree;

public class TreeNode<E extends Comparable<E>> {
	E value;
    TreeNode<E> left, right;
	public TreeNode(E value){
		this.value = value;
		left = null;
		right = null;
	}
}
