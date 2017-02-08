/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
    	if(num == null || num.length == 0){
    		return null;
    	}
        TreeNode root = new TreeNode(0);
        root = helper(root, num, 0, num.length - 1);
        return root;
    }
    public TreeNode helper(TreeNode root, int[] num, int head, int tail){
    	if(head > tail){
    	   return null;
    	}
    	int mid = (tail - head) / 2 + head;
    	root = new TreeNode(num[mid]);
    	root.left = helper(root.left, num, head, mid - 1);
    	root.right = helper(root.right, num, mid + 1, tail);
    	return root;        
    }
}