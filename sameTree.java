/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

///////// recursive //////////////////////
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null){
            return p == q;
        }
        return (p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }
}

//////////////// non-recursive ///////////////

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null){
            return p == q;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(p);
        stack.push(q);
        while(!stack.isEmpty()){
            if(stack.size() % 2 != 0){
                return false;
            }
            TreeNode nodeA = stack.pop();
            TreeNode nodeB = stack.pop();
            if(nodeA.val != nodeB.val){
                return false;
            }
            if(nodeA.left == null || nodeB.left == null){
                if(nodeA.left != nodeB.left){
                    return false;
                }
            }
            else{
                stack.push(nodeA.left);
                stack.push(nodeB.left);
            }
            if(nodeA.right == null || nodeB.right == null){
                if(nodeA.right != nodeB.right){
                    return false;
                }
            }
            else{
                stack.push(nodeA.right);
                stack.push(nodeB.right);
            }
        }
        return true;
    }
}