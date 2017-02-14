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
    public void recoverTree(TreeNode root) {
        //Morris-traversal        
        TreeNode first = null;
        TreeNode second = null;
        TreeNode prev = null; 
        
        TreeNode pred = null; //rightmost node in left tree        
        TreeNode curr = root;
        
        while(curr != null){
            //for each node, we compare it with prev node as we did in in-order-traversal
            if(prev != null && curr.val <= prev.val){
                if(first == null) first = prev;
                second = curr;
            }            
            if(curr.left != null){
                //got left tree, then let's locate its rightmost node in left tree
                pred = curr.left;
                //we may have visited the left tree before, and connect the rightmost node with curr node (root node)
                while(pred.right != null && pred.right != curr){
                    pred = pred.right;
                }
                
                if(pred.right == curr){
                    //if this left tree has been visited before, then we are done with it
                    //cut the connection with currNode and start visit curr's right tree
                    pred.right = null;
                    prev = curr;
                    curr = curr.right;
                }else{
                    //if this left tree has not been visited before, then we create a back edge from rightmost node
                    // to curr node, so we can return to the start point after done the left tree
                    pred.right = curr;
                    curr = curr.left;
                }                
            }else{
                //no left tree, then just visit its right tree
                prev = curr;
                curr = curr.right;
            }
        }
        if(first != null && second != null){
            int temp = first.val;
            first.val = second.val;
            second.val = temp;             
        }               
    }
}

public class Solution {
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;
    public void recoverTree(TreeNode root) {
        traverse(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        return;
    }
    public void traverse(TreeNode root){
        if(root == null){
            return;
        }
        traverse(root.left);
        if(prev != null && prev.val > root.val){
            if(first == null){
                first = prev;
            }
            second = root;
        }
        prev = root;
        traverse(root.right);        
    }
}