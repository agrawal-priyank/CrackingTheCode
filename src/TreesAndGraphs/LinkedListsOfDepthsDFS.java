package TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Priyank Agrawal
 *
 * To create d number of linked lists of the tree having depth d with each list
 * containing the nodes at the same depth
 * 
 * Recursive implementation of depth first search
 * 
 * Time complexity is O(n) and Space complexity is O(n)
 * 
 * Date: 11/23/2016
 */
public class LinkedListsOfDepthsDFS {
	
	void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level){
		if(root == null)								//base case
			return;										//do nothing
		LinkedList<TreeNode> list = null;
		if(lists.size() == level){						//level has not yet been explored
			list = new LinkedList<TreeNode>();
			lists.add(list);							//add new level linked list to the array list of linked lists
		}
		else{
			list = lists.get(level);					//level has been explored so the linked lists of this level must already be present
		}
		list.add(root);
		createLevelLinkedList(root.getLeftChild(), lists, level+1);	//same for the left child with a level more
		createLevelLinkedList(root.getRightChild(), lists, level+1);//same for the right child with a level more
	}
	
	ArrayList<LinkedList<TreeNode>> createArrayListOfLinkedList(TreeNode root){
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();	//an array lists of linked lists consisting of tree nodes
		createLevelLinkedList(root, lists, 0);			//call method from level 0 that has the root of the tree
		return lists;
	}

}