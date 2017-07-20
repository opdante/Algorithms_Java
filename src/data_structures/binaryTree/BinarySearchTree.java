package data_structures.binaryTree;

public class BinarySearchTree<E extends Comparable<E>> 
		extends AbstractTree<E>{
	protected TreeNode<E> root;
	protected int size = 0;
	
	public BinarySearchTree(){
		this.root = null;
	}
	
	public void insert(E data){
		TreeNode<E> new_node = new TreeNode<>(data);
		if(root == null){
			root = new_node;
			return;
		}
		
		TreeNode<E> curr = root;
		TreeNode<E> parent = null;
		while(curr != null){
			// if data to insert is less than value of current 
			// node then go down the left 
			if(data.compareTo(curr.value) < 0){
				parent = curr;
				curr = curr.left;
			} else if(data.compareTo(curr.value) > 0){
				parent = curr;
				curr = curr.right;
			} else
				return;
		}
		
		if(data.compareTo(parent.value) < 0)
			parent.left = new_node;
		else
			parent.right = new_node;
		size++;
		
	}

	/// Check if a given element is in the tree */
	public boolean search(E data) {
		if(root == null) return false;
		TreeNode<E> curr = root;
		
		while(curr != null){
			if(data.compareTo(curr.value) < 0)
				curr = curr.left;
			else if(data.compareTo(curr.value) > 0)
				curr = curr.right;
			else
				return true;
		}
		
		return false;
		
	}

	// Delete an element from the binary tree
	public boolean delete(E data) {
		if(root == null) return false;
		TreeNode<E> curr = root;
		root = deleteNode(curr, data);
		size--;
		return true;
	}
	
	private TreeNode<E> deleteNode(TreeNode<E> root, E data){
		if(root == null) return root;
		if(root.value.compareTo(data) > 0) root.left = deleteNode(root.left, data);
		else if(root.value.compareTo(data) < 0) root.right = deleteNode(root.right, data);
		else{
			if(root.left == null) return root.right;
			else if(root.right == null) return root.left;
			// for a node with with two children, replace the min value of the right subtree
			root.value = this.getMin(root.right);
			root.right = deleteNode(root.right, root.value);
		}
		return root;
	}

	@Override
	public void inorder() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postorder() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void preorder() {
		// TODO Auto-generated method stub
		
	}

	// get number of nodes in tree
	public int getSize() {
		return size;
	}
	
	private E getMin(TreeNode<E> root) {
        E min = root.value;
        while (root.left != null) {
            root = root.left;
            min = root.value;
        }
        return min;
    }
	
}
