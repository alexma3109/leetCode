public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
//// check the left most and the right most depth, if same, complete tree ////
//// if not, add left and right and 1 ////
public class Solution {
    public int countNodes(TreeNode root) {
		if(root == null){
			return 0;
		}
		int left = leftNodes(root);
		int right = rightNodes(root);
		if(left == right){
			return (1 << left) - 1;
		}
		else{
			return countNodes(root.left) + countNodes(root.right) + 1;
		}
	}
	public int leftNodes (TreeNode root) {
		int count = 0;
		while(root != null){
			root = root.left;
			count++;
		}
		return count;
	}
	public int rightNodes (TreeNode root) {
		int count = 0;
		while(root != null){
			root = root.right;
			count++;
		}
		return count;
    }
}