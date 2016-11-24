package TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Priyank Agrawal
 *
 * To create d number of linked lists of the tree having depth d with
 * each list containing the nodes at the same depth
 * 
 * Iterative implementation of breadth first search
 * 
 * Time complexity is O(n) and Space complexity is O(n)
 * 
 * Date: 11/23/2016
 */
public class LinkedListsOfDepthsBFS {
	// nested node class of a binary tree
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
	
	ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root){
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
		if(root != null)							//visit the root node by adding it to current linked lists
			current.add(root);
		while(current.size() > 0){
			lists.add(current);						//add previous level which is the current list to the array list
			LinkedList<TreeNode> parents = current; //go to the next level
			current = new LinkedList<TreeNode>();	//initialize the current list again
			for(TreeNode parent : parents){
				if(parent.getLeftChild() != null)	//add the left child from the the next level
					current.add(parent.getLeftChild());
				if(parent.getRightChild() != null)	//add the right child node from the next level
					current.add(parent.getRightChild());
			}
		}
		return lists;
	}
	
}