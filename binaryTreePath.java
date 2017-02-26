/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/* O(n * log*(n)) Time Complexity */
/* postorder traversal */
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode node = root;
        TreeNode pre = null;
        while(!deque.isEmpty() || node != null){
            if(node != null){
                deque.push(node); // keep going left and push into stack //
                node = node.left;
            }
            else{
                TreeNode temp = deque.peek(); // dont touch node, use temp //
                if(temp.right != null && pre != temp.right){
                    node = temp.right; // when there's no left, and the right is not visited yet, go right //
                }
                else{
                    if(temp.left == null && temp.right == null){
                    	String str = formString(deque);
                    	res.add(str);
                    }
                    deque.pop();  // no left && no right (or right is visited), pop and add in list //
                    pre = temp;
                }
            }
        }
        return res;
    }
    public String formString(Deque<TreeNode> deque){
    	List<Integer> temp = new ArrayList<>();
        for(TreeNode node : deque){
        	temp.add(0, node.val);
        }
    	StringBuilder sb = new StringBuilder();
    	sb.append(temp.get(0));
        for(int i = 1 ; i < temp.size(); i++){
        	sb.append("->");
        	sb.append(temp.get(i));
        }
        return sb.toString();
    }
}