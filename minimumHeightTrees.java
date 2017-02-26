public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Set<Integer>> pairs = new ArrayList<>(n);
        for(int i = 0 ; i < n ; i++){
            pairs.add(new HashSet<>());
        }
        for(int[] edge : edges){
            pairs.get(edge[0]).add(edge[1]);
            pairs.get(edge[1]).add(edge[0]);
        }
        List<Integer> leaves = new ArrayList<>();
        if(n == 1){
            leaves.add(0);
        }
        for(int i = 0 ; i < n ; i++){
            if(pairs.get(i).size() == 1){
                leaves.add(i);
            }
        }
        while(n > 2){
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for(int leaf : leaves){
                int target = pairs.get(leaf).iterator().next();
                pairs.get(target).remove(leaf);
                if(pairs.get(target).size() == 1){
                    newLeaves.add(target);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}