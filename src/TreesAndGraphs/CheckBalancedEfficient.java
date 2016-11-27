package TreesAndGraphs;

/**
 * @author Priyank Agrawal
 * 
 * To check whether a binary tree is balanced or not where balanced means the height difference
 * between the left subtree and right subtree should not be more than one at any node
 * 
 * Time complexity is O(n)
 * 
 * Date: 11/26/2016
 */
public class CheckBalancedEfficient {
	
	int checkHeight(TreeNode root){
		if(root == null)						//base case
			return -1;
		int leftHeight = checkHeight(root.getLeftChild());
		if(leftHeight == Integer.MIN_VALUE)
			return Integer.MIN_VALUE;			//pass error value up	
		int rightHeight = checkHeight(root.getRightChild());
		if(rightHeight == Integer.MIN_VALUE)
			return Integer.MIN_VALUE;			//pass error value up
		int heightDiff = leftHeight - rightHeight;
		if(Math.abs(heightDiff) > 1)
			return Integer.MIN_VALUE;			//pass error value up
		else
			return Math.max(leftHeight, rightHeight) + 1;
	}
	
	boolean isBalanced(TreeNode root){
		return checkHeight(root) != Integer.MIN_VALUE;
	}

}