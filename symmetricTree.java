/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
///////////////// recursive //////////////////////
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return helper(root.left, root.right);
    }
    
    public boolean helper(TreeNode left, TreeNode right){
        if(left == null || right == null){
            return left == right;
        }
        return (left.val == right.val && helper(left.left, right.right) && helper(left.right, right.left));
    }
}

///////////////// non-recursive ///////////////////
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        if((root.left == null || root.right == null)){
            if(root.left != root.right){
                return false;
            }
        }
        else {
            stack.push(root.left);
            stack.push(root.right);
        }
        while(!stack.isEmpty()){
            if(stack.size() % 2 != 0){
                return false;
            }
            TreeNode right = stack.pop();
            TreeNode left = stack.pop();
            if(left.val != right.val){
                return false;
            }
            if((left.left == null || right.right == null)){
                if(left.left != right.right){
                    return false;
                }
            }
            else{
                stack.push(left.left);
                stack.push(right.right);                
            }
            if((left.right == null || right.left == null)){
                if(left.right != right.left){
                    return false;
                }
            }
            else{
                stack.push(left.right);
                stack.push(right.left);                
            }
        }
        return true; 
    }
}