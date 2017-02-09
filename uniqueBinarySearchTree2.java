public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; left = null; right = null; }
}
/******  Time Comp: O(Catalan(n)). C[n+1] = sum(C[i] * C[n-i])  ******/
public class Solution {
    public List<TreeNode> generateTrees(int n) {
		return helper(1, n);
	}
	public List<TreeNode> helper(int start, int end){
		List<TreeNode> res = new ArrayList<TreeNode>();
		if(start > end){
			res.add(null);/* very important!!!!! 
			make sure the for loop can run at least once */
			return res;
		}
		for(int i = start ; i <= end ; i++){
			List<TreeNode> left = helper(start, i - 1);
			List<TreeNode> right = helper(i + 1, end);
			for(TreeNode l : left){
				for(TreeNode r : right){
					TreeNode root = new TreeNode(i);
					root.left = l;
					root.right = r;
					res.add(root);
				}
			}
		}
		return res;
	}
}