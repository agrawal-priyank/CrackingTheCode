package TreesAndGraphs;

/**
 * @author Priyank Agrawal
 *
 * To search for the next node of a given node n in the binary search tree
 * 
 * Time complexity is O(logn)
 * 
 * Date: 02/10/2017
 */
public class Successor {

	TreeNode inOrderSuccessor(TreeNode n) {
		if (n == null) {
			return null;
		} else if (n.getRightChild() != null) {
			return leftMostChild(n.getRightChild());
		} else {					//n is the child
			TreeNode q = n;
			TreeNode x = n.getParent();
			while(x != null && x.getLeftChild() != q){
				q = x;
				x = x.getParent();
			}
			return x;				//returns null if n is the rightmost node of the tree
		}
	}

	TreeNode leftMostChild(TreeNode n) {
		if (n == null) {
			return null;
		}
		while (n.getLeftChild() != null) {
			n = n.getLeftChild();
		}
		return n;					//returns leftmost node of the right sub-tree of n
	}

}