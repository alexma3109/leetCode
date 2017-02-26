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
        while((root.val < p.val && root.val < q.val) || (root.val > p.val && root.val > q.val)){
            if(root.val < p.val && root.val < q.val){
                root = root.right;
            }
            else{
                root = root.left;
            }
        }
        return root;
    }
}