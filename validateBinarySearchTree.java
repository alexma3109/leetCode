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
    private long lastVal = Integer.MIN_VALUE - (long) 1;
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        if(!isValidBST(root.left)){
            return false;
        }
        if(lastVal >= (long) root.val){
            return false;
        }
        lastVal = root.val;
        return isValidBST(root.right);
    }
}

/********************************************/
public class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre != null && pre.val >= root.val){
                return false;
            }
            pre = root;
            root = root.right;
        }
        return true;
    }
}