/* The knows API is defined in the parent class Relation.
    a knows b -> boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int res = 0;
        for(int i = 1 ; i < n ; i++) {
            if(knows(res, i)) {
                res = i;
            }
        } // find the candidate //
        for(int i = 0 ; i < n ; i++) { // check whether it is //
            if(i < res) {
                if(!knows(i, res) || knows(res, i)) {
                    return -1;
                }
            } // dont check res itself //
            else if(i > res) {
                if(!knows(i, res)) {
                    return -1;
                } // knows(res, i) has been done in the first loop //
            }
        }
        return res;
    }
}