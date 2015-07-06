public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){
			return 0;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		int count = 0;
		while(!q.isEmpty()){
			count++;
			int len = q.size();
			for(int i = 0 ; i < len ; i++){
				TreeNode node = q.poll();
				if(node.left != null){
					q.offer(node.left);
				}
				if(node.right != null){
					q.offer(node.right);
				}				
			}
		}
		return count;
    }
}