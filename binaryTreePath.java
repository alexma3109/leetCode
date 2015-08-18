public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
		List<List<Integer>> temp = new ArrayList<List<Integer>>();
        List<Integer> array = new ArrayList<Integer>();
		helper(root, temp, array);
		for(int i = 0 ; i < temp.size() ; i++){
			StringBuilder sb = new StringBuilder();
			for(int j = 0 ; j < temp.get(i).size() ; j++){
				sb.append(temp.get(i).get(j));
				if(j < temp.get(i).size() - 1){
					sb.append("->");
				}
			}
			res.add(sb.toString());
		}
		return res;
    }
	public static void helper(TreeNode root, List<List<Integer>> temp, List<Integer> array){
		if(root == null){
			return;
		}
		array.add(root.val);
		if(root.left == null && root.right == null){
			temp.add(new ArrayList<Integer>(array));
			array.remove(array.size() - 1);
			return;
		}
		helper(root.left, temp, array);
		helper(root.right, temp, array);
		array.remove(array.size() - 1);		
	}
}