/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/* subtree sum is the sum of all the node of the current subtree */
public class Solution {
    private int maxCount = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        if(root == null){
            return new int[0];
        }
        helper(root, map);
        List<Integer> list = new ArrayList<>();
        Iterator iter = map.keySet().iterator();
        while(iter.hasNext()){
            Integer key = (Integer) iter.next();
            if(map.get(key) == maxCount){
                list.add(key);
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0 ; i < list.size() ; i++){
            res[i] = list.get(i);
        }
        return res;        
    }
    public int helper(TreeNode root, HashMap<Integer, Integer> map){
        if(root == null){
            return 0;
        }
        int left = helper(root.left, map);
        int right = helper(root.right, map);
        int res = left + right + root.val;
        int count = map.getOrDefault(res, 0) + 1;
        maxCount = Math.max(maxCount, count);
        map.put(res, count);
        return res;
    }
}