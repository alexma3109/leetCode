//// citations has been sorted ////
public class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0){
            return 0;
        }
        int res = 0;
        for(int i = citations.length - 1 ; i >= 0 ; i--){
            if(citations[i] <= res){
                return res;
            }
            res++;
        }
        return res;
    }
}