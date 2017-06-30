/* two queues, BFS and record the col at the same time. */
/* node.left is in col - 1, node.right is in col + 1 */
/* update min and max, to know the total size of the map */
/* cannot iterate the map since that's not in order */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
        	return res;
        }
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        int max = 0, min = 0;
        q.offer(root);
        cols.offer(0);
        while(!q.isEmpty()) {
        	TreeNode node = q.poll();
        	int col = cols.poll();
        	if(!map.containsKey(col)) {
        		map.put(col, new ArrayList<Integer>());
        	}
        	map.get(col).add(node.val); // no need to use map.put(), the List object is the same //
        	if(node.left != null) {
        		q.offer(node.left);
        		cols.offer(col - 1);
        		min = Math.min(min, col - 1);
        	}
        	if(node.right != null) {
        		q.offer(node.right);
        		cols.offer(col + 1);
        		max = Math.max(max, col + 1);
        	}
        }
        for(int i = min ; i <= max ; i++) {
        	res.add(map.get(i));
        }
        return res;
    }
}