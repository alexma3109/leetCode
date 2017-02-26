/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        q.offer(root);
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0 ; i < len ; i++){
                TreeNode node = q.poll();
                if(node != null){
                    sb.append(node.val);// seperate append, otherwise it will be the ascii code //
                    sb.append(",");
                    q.offer(node.left);
                    q.offer(node.right);
                }
                else{
                    sb.append("x,");
                }
            }
        }
        sb.deleteCharAt(sb.length() - 1); // remove the tail ',' //
        return sb.toString();       
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == ""){
            return null;
        }
        String[] values = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.offer(root);
        for(int i = 1 ; i < values.length ; i++){
            TreeNode node = q.poll();
            if(!values[i].equals("x")){
                node.left = new TreeNode(Integer.parseInt(values[i]));
                q.offer(node.left);
            }
            i++; // !important i has to be increased //
            if(!values[i].equals("x")){
                node.right = new TreeNode(Integer.parseInt(values[i]));
                q.offer(node.right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));