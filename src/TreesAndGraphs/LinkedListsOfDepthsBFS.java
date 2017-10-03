package TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedListsOfDepthsBFS {
	
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