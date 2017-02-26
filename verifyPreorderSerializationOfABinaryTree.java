/* graph knowledge */
/* all non-null node provides 2 outdegree and 1 indegree (2 children and 1 parent), except root */
/* all null node provides 0 outdegree and 1 indegree (0 child and 1 parent). */
public class Solution {
    public boolean isValidSerialization(String preorder) {
        if(preorder == null){
            return true;
        }
        String[] strs = preorder.split(",");
        int diff = 1;
        for(String str : strs){
            if(--diff < 0){     
                /* must do the minus for all nodes first */
                /* Because for each loop start, diff cannot be 0 */
                /* diff == 0 only possible when loop ends, otherwise false */
                return false;
            }
            if(!str.equals("#")){
                diff += 2;
            }   
        }
        return diff == 0;
    }
}