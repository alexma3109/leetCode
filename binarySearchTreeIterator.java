/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/* refer to : inorder traversal */
public class BSTIterator {
    private Deque<TreeNode> deque = new LinkedList<>();
    private TreeNode current;
    public BSTIterator(TreeNode root) {
        current = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return(!deque.isEmpty() || current != null);
    }

    /** @return the next smallest number */
    public int next() {
        while(current != null){
            deque.push(current);
            current = current.left;
        }
        current = deque.pop();
        TreeNode node = current;
        current = current.right;
        return node.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */