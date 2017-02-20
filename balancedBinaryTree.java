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
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int res = depth(root);
        return res == -1 ? false : true;
    }
    public int depth(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = depth(root.left);
        if(left == -1){
            return -1;
        }
        int right = depth(root.right);
        if(right == -1){
            return -1;
        }
        if(Math.abs(left - right) <= 1){
            return Math.max(left, right) + 1;
        }
        else{
            return -1;
        }
    }
}