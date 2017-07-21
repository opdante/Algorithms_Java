package data_structures.naryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tree<T extends Comparable<T>> {
	private NTreeNode<T> root;

	
	public NTreeNode<T> findNode(T data){
		if(root == null) return null;
		return findUtil(data, root);
	}
	
	private NTreeNode<T> findUtil(T data, NTreeNode<T> curr){
		if(curr == null) return null;
		
		if(curr.getData().equals(data)) return curr;
		else{
			NTreeNode<T> node = null;
			for(NTreeNode<T> child : curr.getChildren()){
				node = findUtil(data, child);
				if(node != null) return node;
			}
		}
	    return null;
	}
	
	public NTreeNode<T> getRoot() {
		return root;
	}

	public void setRoot(NTreeNode<T> root) {
		this.root = root;
	}

	public int numNodes(){
		if(root == null) return 0;
		
		return 1 +  numNodes(root);
	}
	
	private int numNodes(NTreeNode<T> node){	
				
		int num = node.numChildren();
		for(NTreeNode<T> child : node.getChildren()){
			num += numNodes(child);
		}
		return num;
	}
	
	public List<List<T>> fallingLeaves(){
		List<List<T>> leaves = new ArrayList<>();
		fallingLeaves(leaves, root);
		return leaves;
	}
	
	private int fallingLeaves(List<List<T>> list, NTreeNode<T> node){
		if(node == null) return -1;
		
		List<Integer> temp = new ArrayList<>();
		int index = 0; 
		for(NTreeNode<T> child : node.getChildren()){
			temp.add(fallingLeaves(list, child));
			index = Collections.max(temp) + 1;
		}
		
		if(list.size() <= index) list.add(new ArrayList<T>());
		
		list.get(index).add(node.getData());
		
		return index;
	}
	
	public boolean isEmpty(){
		return root == null;
	}
	
}
