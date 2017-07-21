package data_structures.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class AVLTree<E extends Comparable<E>> implements Tree<E>{
	
	protected AVLTreeNode<E> root;
	public AVLTree(){
		this.root = null;
	}

	@Override
	public boolean search(E data) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void insert(List<E> elements){
		for(E elem: elements){
			this.insert(elem);
		}
	}

	@Override
	public void insert(E data) {
		root = insert(data, root);
	}
	
	private AVLTreeNode<E> insert(E data, AVLTreeNode<E> node){
		if(node == null)
			return new AVLTreeNode<E>(data);
		
		if(data.compareTo(node.key) < 0) {
			node.left = insert(data, node.left);
			
		} else if(data.compareTo(node.key) > 0) {
			node.right = insert(data, node.right);
		} else{
			return node;
		}
		
		node.height = Math.max(height(node.left), height(node.right)) + 1;
		
		int balance = this.getBalanceFactor(node);
		
		// if the node becomes unbalanced
		if(balance > 1 && data.compareTo(node.left.key) < 0){
			return this.rightRotate(node);
		}
		
		if(balance < -1 &&data.compareTo(node.right.key) > 0){
			return this.leftRotate(node);
		}
			
		if(balance > 1 && data.compareTo(node.left.key) > 0){
			node.left = this.leftRotate(node.left);
			return this.rightRotate(node);
		}
		
		if(balance < -1 && data.compareTo(node.right.key) < 0){
			node.right = this.rightRotate(node.left);
			return this.leftRotate(node);
		}
		
		return node;
	}

	@Override
	public boolean delete(E data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<E> inorder() {
		AVLTreeNode<E> curr = root;
		List<E> inorderList = new ArrayList<E>();
		inorder(curr, inorderList);
		return inorderList;
	}
	
	private void inorder(AVLTreeNode<E> node, List<E> inorderList){
		if(node == null) return;
		
		inorder(node.left, inorderList);
		inorderList.add(node.key);
		inorder(node.right, inorderList);
	}

	@Override
	public List<E> postorder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<E> preorder() {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	// function to get the height of the tree
	public int height(AVLTreeNode<E> node){
		if(node == null)
			return 0;
		return node.height;
	}
	
	// function to right rotate subtree
	private AVLTreeNode<E> rightRotate(AVLTreeNode<E> node){
		AVLTreeNode<E> ret_node = node.left;
		AVLTreeNode<E> ret_right = ret_node.right;
		
		//rotate 
		ret_node.right = node;
		node.left = ret_right;
		
		// update heights
		node.height = Math.max(height(node.left), height(node.right)) + 1;
		ret_node.height = Math.max(height(ret_node.left), height(ret_node.right)) + 1;
		
		return ret_node;
	}
	
    private AVLTreeNode<E> leftRotate(AVLTreeNode<E> node){
    	AVLTreeNode<E> ret_node = node.right;
		AVLTreeNode<E> ret_left = ret_node.left;
		
		//rotate 
		ret_node.left = node;
		node.right = ret_left;
		
		// update heights
		node.height = Math.max(height(node.left), height(node.right)) + 1;
		ret_node.height = Math.max(height(ret_node.left), height(ret_node.right)) + 1;
				
		return ret_node;
    }
    
    //get balance factor of a given node
    private int getBalanceFactor(AVLTreeNode<E> node){
    	if(node == null) return 0;
    	return height(node.left) - height(node.right);
    }

}

class AVLTreeNode<E> {
    E key;
    int height;
    AVLTreeNode<E> left, right;
 
    AVLTreeNode(E key) {
        this.key = key;
        height = 1;
    }
}
