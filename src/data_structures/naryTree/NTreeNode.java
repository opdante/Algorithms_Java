package data_structures.naryTree;

import java.util.ArrayList;
import java.util.List;

public class NTreeNode<T extends Comparable<T>> {
	private T data;
	private List<NTreeNode<T>> children;
	private NTreeNode<T> parent;
	
	public NTreeNode(T data){
		setData(data);
		this.setChildren(new ArrayList<NTreeNode<T>>());
	}
	
	public void setData(T data){
		this.data = data;
	}

	public NTreeNode<T> getParent() {
		return parent;
	}

	public List<NTreeNode<T>> getChildren() {
		return children;
	}

	public void setChildren(List<NTreeNode<T>> children) {
		//set the parent for each child
		for(NTreeNode<T> ch : children){
			ch.parent = this;
		}
		this.children = children;
	}
	
	public void addChild(NTreeNode<T> child){
		//set the child's parental 
		child.parent = this;
		this.children.add(child);
	}
	
	public T getData(){
		return data;
	}
	
	public int numChildren(){
		return this.children.size();
	}
	
}
