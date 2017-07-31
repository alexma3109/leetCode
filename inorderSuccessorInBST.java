/* This is to find the smallest node that is larger than target */
/* binary search */
/* only when node.val > target.val, the res = root */
/* otherwise, even root is the target, still keep going right */
/* time O(log(n)) */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode res = null;
        while (root != null) {
            if (root.val > p.val) {
                res = root;
                root = root.left;
            }
            else {
                root = root.right;
            }
        }
        return res;
    }
}