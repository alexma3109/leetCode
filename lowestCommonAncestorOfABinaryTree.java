////O(n), bottom-up////
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
			return null;
		}
		if(root == p){
			return p;
		}
		if(root == q){
			return q;
		}
		if(lowestCommonAncestor(root.right, p, q) == null){
			return lowestCommonAncestor(root.left, p, q);
		}
		if(lowestCommonAncestor(root.left, p, q) == null){
			return lowestCommonAncestor(root.right, p, q);
		}
		return root;
    }
}