/************************************/
/* Also works for:                  */
/* Kth Smallest Element in a BST    */
/* Validate Binary Search Tree      */
/* syemmetric tree                  */
/* Same Tree                        */
/************************************/

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

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode curr = root;
        TreeNode prev = null;        
        List<Integer> res = new ArrayList<>();
        curr = root;
        while(curr != null){
            if(curr.left == null){
                res.add(curr.val);
                curr = curr.right;
            }
            else{
                prev = curr.left;
                while(prev.right != null && prev.right != curr){
                    prev = prev.right;
                }
                if(prev.right == null){
                    prev.right = curr;
                    curr = curr.left;
                }
                else{
                    prev.right = null;
                    res.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return res;
    }
}