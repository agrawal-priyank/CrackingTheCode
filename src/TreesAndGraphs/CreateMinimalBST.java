package TreesAndGraphs;

/**
 * @author Priyank Agrawal
 * 
 * Given a sorted (increasing order) array create a binary search tree
 * with minimum height
 * 
 * Time complexity is O(n) Space complexity is O(n)
 * 
 *  Date: 11/22/2016
 */
public class CreateMinimalBST {

	//nested node class of a binary tree
	static class TreeNode {
		private int value;
		private TreeNode leftChild;
		private TreeNode rightChild;
		public TreeNode(int value) {
			this.value = value;
		}
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public TreeNode getLeftChild() {
			return leftChild;
		}
		public void setLeftChild(TreeNode leftChild) {
			this.leftChild = leftChild;
		}
		public TreeNode getRightChild() {
			return rightChild;
		}
		public void setRightChild(TreeNode rightChild) {
			this.rightChild = rightChild;
		}
	}

	TreeNode createMinimalBST(int[] sortedArray) {
		return createMinimalBST(sortedArray, 0, sortedArray.length - 1);
	}

	TreeNode createMinimalBST(int[] array, int start, int end) {
		if (end < start)
			return null;
		int mid = (start + end) / 2;								//get the middle element of the array
		TreeNode node = new TreeNode(mid);							//make middle element the parent node
		node.setLeftChild(createMinimalBST(array, 0, mid - 1));		//make left sub-array the left child (sub-tree) of the parent node
		node.setRightChild(createMinimalBST(array, mid + 1, end));	//make right sub-array the right child (sub-tree) of the parent node
		return node;
	}

}