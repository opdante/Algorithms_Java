package data_structures.binaryTree;

public class TreeNode<E extends Comparable<E>> {
	public E value;
    public TreeNode<E> left;
	public TreeNode<E> right;
	public TreeNode(E value){
		this.value = value;
		left = null;
		right = null;
	}
}
