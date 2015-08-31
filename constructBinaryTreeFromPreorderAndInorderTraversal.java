public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0){
            return null;
        }
        TreeNode root = helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
		return root;
    }
	public static TreeNode helper(int[] preorder, int[] inorder, int pStart,int pEnd, int iStart, int iEnd){
		if(pEnd < pStart || iEnd < iStart){
			return null;
		}
		TreeNode root = new TreeNode(preorder[pStart]);
		int pos = findPos(inorder, iStart, iEnd, preorder[pStart]);
		root.left = helper(preorder, inorder, pStart + 1, pEnd + iEnd - pos, iStart, pos - 1);
		root.right = helper(preorder, inorder, pStart + pos - iStart + 1, pEnd, pos + 1, iEnd);
		return root;
	}
	public static int findPos(int[] inorder, int s, int e, int value){
		for(int i = s ; i <= e ; i++){
			if(inorder[i] == value){
				return i;
			}
		}
		return -1;
	}
}