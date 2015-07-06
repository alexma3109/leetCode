public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
		helper(root, res);
		return res;
    }
	public void helper(TreeNode root, ArrayList<Integer> res){
		if(root == null){
			return;
		}
		res.add(root.val);
		helper(root.left, res);
		helper(root.right, res);
	}
}

public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(root == null){
			return res;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode temp = stack.pop();
			res.add(temp.val);
			if(temp.right != null){
				stack.push(temp.right);
			}
			if(temp.left != null){
				stack.push(temp.left);
			}
		}
		return res;
	}
}