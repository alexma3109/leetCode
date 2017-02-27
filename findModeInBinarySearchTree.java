/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/* This also apply for normal binary tree */
/* use extra space of hasmap */
/* recursive */
public class Solution {
    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        if(root == null){
            return new int[0];
        }
        helper(root, map);
        int max = 0;
        List<Integer> list = new ArrayList<>();
        for(int count : map.values()){
            if(count > max){
                max = count;
            }
        }
        Iterator iter = map.keySet().iterator();
        while(iter.hasNext()){
            Integer key = (Integer) iter.next();
            if(map.get(key) == max ){
                list.add(key);
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0 ; i < list.size() ; i++){
            res[i] = list.get(i);
        }
        return res;
    }
    public void helper(TreeNode root, HashMap<Integer, Integer> map){
        if(root == null){
            return;
        }
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        helper(root.left, map);
        helper(root.right, map);
    }
}