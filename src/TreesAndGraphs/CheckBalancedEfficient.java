package TreesAndGraphs;

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