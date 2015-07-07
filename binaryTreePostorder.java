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