package algorithms.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import data_structures.naryTree.NTreeNode;
import data_structures.naryTree.Tree;

public class LongestConsercutiveBranchNTree {
	Tree<Integer> tree;
	
	public LongestConsercutiveBranchNTree(Tree<Integer> tree){
		this.tree = tree;
	}
	
	public int consecutive(){
		NTreeNode<Integer> root = tree.getRoot();
		if(root == null) return 0;
		List<Integer> temp = new ArrayList<>();
	    for(NTreeNode<Integer> child : root.getChildren()){
	    	temp.add(consecutive(child, root.getData(), 1));
	    }
		return Collections.max(temp);
		
	}
	
	public int consecutive(NTreeNode<Integer> root, int prev, int length){
		if(root == null) return length;
		List<Integer> temp = new ArrayList<>();
		if(root.getData() == prev + 1){
			for(NTreeNode<Integer> child : root.getChildren()){
				temp.add(consecutive(child, root.getData(), length + 1));
				length = Collections.max(temp);
			}
			return length;
		} else {
			int tmp = 0;
			for(NTreeNode<Integer> child : root.getChildren()){
				temp.add(consecutive(child, root.getData(), 1));
				tmp = Collections.max(temp);
			}
			return Math.max(length, tmp);
		}
	}
	
	public static void main(String[] args){
		Tree<Integer> tree = new Tree<>();
		NTreeNode<Integer> rootA = new NTreeNode<>(1);
	    NTreeNode<Integer> childB = new NTreeNode<Integer>(2);
	    NTreeNode<Integer> childC = new NTreeNode<Integer>(3);
	    NTreeNode<Integer> childD = new NTreeNode<Integer>(4);
	    NTreeNode<Integer> childE = new NTreeNode<Integer>(5);
	    NTreeNode<Integer> childF = new NTreeNode<Integer>(6);
	    NTreeNode<Integer> childG = new NTreeNode<Integer>(7);
	    NTreeNode<Integer> childH = new NTreeNode<Integer>(8);
	    NTreeNode<Integer> childI = new NTreeNode<Integer>(9);
	    NTreeNode<Integer> childJ = new NTreeNode<Integer>(10);
	    NTreeNode<Integer> childK = new NTreeNode<Integer>(11);
	    NTreeNode<Integer> childL = new NTreeNode<Integer>(12);
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
        
        LongestConsercutiveBranchNTree lcb = new LongestConsercutiveBranchNTree(tree);
        
        System.out.println(lcb.consecutive());
        
        
	}
}
