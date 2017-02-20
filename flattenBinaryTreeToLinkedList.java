/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        List<TreeNode> list = new ArrayList<>();
        deque.push(root);
        while(!deque.isEmpty()){
            TreeNode node = deque.pop();
            list.add(node);
            if(node.right != null){
                deque.push(node.right);
            }
            if(node.left != null){
                deque.push(node.left);
            }
        }
        for(int i = 0 ; i < list.size() ; i++){
            list.get(i).left = null;
            if(i < list.size() - 1){
                list.get(i).right = list.get(i + 1);
            }
        }
    }    
}

//////////////////////////////////////////////

public class Solution {
    private TreeNode prev = null;
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}

//////////////////////////////////////////////

public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        while (root != null) {
            if (root.left == null) {
                root = root.right;
                continue;
            }
            TreeNode left = root.left;
            while (left.right != null) {
                left = left.right;
            }
            left.right = root.right;
            root.right = root.left;
            root.left = null;
            root = root.right;
        }
    }
}