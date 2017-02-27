/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/* tree left view. Refer to binaryTreeRightSideView.java */
public class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int res = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0 ; i < len ; i++){
                TreeNode node = q.poll();
                if(i == 0){
                    res = node.val;
                }
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
            }
        }
        return res;
    }
}