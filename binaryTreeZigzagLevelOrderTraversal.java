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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean flag = true;
        while(!q.isEmpty()){
            int len = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0 ; i < len ; i++){
                TreeNode node = q.poll();
                if(flag){
                    list.add(node.val);
                }
                else{
                    list.add(0, node.val);
                }
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
            }
            res.add(list);
            flag = !flag;
        }
        return res;
    }
}