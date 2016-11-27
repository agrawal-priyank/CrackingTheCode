package TreesAndGraphs;

/**
 * @author Priyank Agrawal
 * 
 * To check whether a binary tree is balanced or not where balanced means the height difference
 * between the left subtree and right subtree should not be more than one at any node
 * 
 * Time complexity is O(nlogn)
 * 
 * Date: 11/26/2016
 */
public class CheckBalanced {
	
	/**
	 * @return height of the current node of the tree
	 * not an efficient method as nodes are called more than once by it
	 */
	int getHeight(TreeNode node){
		if(node == null)					//base case
			return -1;
		return Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild())) + 1;
	}
	
	boolean isBalanced(TreeNode root){
		if(root == null)					//base case
			return false;
		int heightDiff = getHeight(root.getLeftChild()) - getHeight(root.getRightChild());
		if(Math.abs(heightDiff) > 1)		//false if right and left subtree have height diff more than one
			return false;
		else								//else proceed to the child nodes
			return isBalanced(root.getLeftChild()) && isBalanced(root.getRightChild());
	}
	
}