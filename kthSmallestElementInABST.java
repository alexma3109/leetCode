//// modify the TreeNode structure, add an 'int lefCn' to record the left number of node////
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int leftCount = helper(root.left);
		if(leftCount + 1 == k){
			return root.val;
		}
		if(leftCount + 1 > k){
			return kthSmallest(root.left, k);
		}
		if(leftCount + 1 < k) {
			return kthSmallest(root.right, k - leftCount - 1);
		}
    }
	public int helper(TreeNode root){
		if(root == null){
			return 0;
		}
		return helper(root.left) + helper(root.right) + 1;
	}
}