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

	@Override
	public boolean delete(E data) {
		// TODO Auto-generated method stub
		return false;
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

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}
}
