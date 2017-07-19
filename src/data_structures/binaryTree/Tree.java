package data_structures.binaryTree;

public interface Tree<E extends Comparable<E>> {
	// Search for element in the tree 
	public boolean search(E data);

    // Insert element o into the binary tree
	public void insert(E data);

	// Delete the specified element from the tree
	public boolean delete(E data);

	// Inorder traversal from the root
	public void inorder();

    // Postorder traversal from the root
	public void postorder();

    // Preorder traversal from the root
	public void preorder();

    // Get the number of nodes in the tree
    public int getSize();

    // Check if the tree is empty
	public boolean isEmpty();
}
