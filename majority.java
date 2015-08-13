public class Solution {
    public int majorityElement(int[] num) {
        if(num == null || num.length == 0){
            return 0;
        }
        if(num.length == 1){
            return num[0];
        }
        int count = 1;
        int cur = num[0];
        for(int i = 1 ; i < num.length ; i++){
            if(cur == num[i]){
                count++;
                continue;
            }
            else if(cur != num[i]){
                if(count > 1){
                    count--;
                    continue;
                }
                else{
                    if(i < num.length - 1){
                        cur = num[i + 1];
                        i++;
                        count = 1;
                    }
                }
            }
        }
        return cur;        
    }
}