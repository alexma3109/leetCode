public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
		helper(res, root);
		return res;
    }
	public void helper(List<Integer> res, TreeNode root){
		if(root == null){
			return;
		}
		helper(res, root.left);
		res.add(root.val);
		helper(res, root.right);
	}
}

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
		if(root == null){
			return res;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode node = root;
		while(!stack.isEmpty() || node != null){
			if(node != null){
				stack.push(node);
				node = node.left;
			}
			else{
				node = stack.pop();
				res.add(node.val);
				node = node.right;
			}
		}
		return res;
    }
}