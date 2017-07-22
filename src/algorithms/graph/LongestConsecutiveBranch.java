package algorithms.graph;

import static java.util.Arrays.asList;

import java.util.List;

import data_structures.binaryTree.BinarySearchTree;
import data_structures.binaryTree.TreeNode;

public class LongestConsecutiveBranch {
	BinarySearchTree<Integer> tree;
	
	public LongestConsecutiveBranch(List<Integer> treeElements){
		tree = new BinarySearchTree<Integer>();
		tree.insert(treeElements);
	}
	
	public int consecutive(){
		TreeNode<Integer> root = tree.getRoot();
		if(root == null) return 0;
		return max(consecutive(root.left, root.value, 1), 
				consecutive(root.right, root.value, 1));
	}
	
	private int consecutive(TreeNode<Integer> root, int prev, int length){
		if(root == null) return length;
		if(root.value == prev + 1){
			int left = consecutive(root.left, root.value, length + 1);
			int right = consecutive(root.right, root.value, length + 1);
			return max(left, right);
		} else {
			int left = consecutive(root.left, root.value, 1);
			int right = consecutive(root.right, root.value, 1);
			return max(left, right, length);
		}
	}
	
	private int max(int... vals){
		int max = Integer.MIN_VALUE;
		for(int i : vals){
			if(i > max) max = i;
		}
		return max;
	}
	
    // test 
	public static void main(String[] args){
		List<Integer> elems = asList(40, 25, 78, 10, 3, 17, 32, 100, 30, 38, 75, 50, 93, 150);
		LongestConsecutiveBranch lcb = new LongestConsecutiveBranch(elems);
		System.out.println(lcb.consecutive());
		

	}
	
	
	
}
