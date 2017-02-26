/* binary tree path */

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
		helper(res, root);
		return res;
    }
	public void helper(ArrayList<Integer> res, TreeNode root){
		if(root == null){
			return;
		}
		helper(res, root.left);
		helper(res, root.right);
		res.add(root.val);		
	}
}

public class Solution {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        TreeNode pre = null;
        while(!stack.isEmpty() || node != null){
            if(node != null){
                stack.push(node); // keep going left and push into stack //
                node = node.left;
            }
            else{
                TreeNode temp = stack.peek();
                if(temp.right != null && pre != temp.right){
                    node = temp.right; // when there's no left, and the right is not visited yet, go right //
                }
                else{
                    stack.pop();  // no left && no right (or right is visited), pop and add in list //
                    res.add(temp.val);
                    pre = temp;
                }
            }
        }
        return res; 
    }
}