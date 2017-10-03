package TreesAndGraphs;

public class CreateMinimalBST {
	
	TreeNode createMinimalBST(int[] array, int start, int end) {
		if (end < start)
			return null;
		int mid = (start + end) / 2;								//get the middle element of the array
		TreeNode node = new TreeNode(mid);							//make middle element the parent node
		node.setLeftChild(createMinimalBST(array, 0, mid - 1));		//make left sub-array the left child (sub-tree) of the parent node
		node.setRightChild(createMinimalBST(array, mid + 1, end));	//make right sub-array the right child (sub-tree) of the parent node
		return node;
	}

	TreeNode createMinimalBST(int[] sortedArray) {
		return createMinimalBST(sortedArray, 0, sortedArray.length - 1);
	}

}