/* dfs */
/* time O(3^n) */
/* n layer, so extra space O(n) */
/* record not only the total value, but also the last calculated value */
/* number overflow */
/* kick out cases like "0123", only "0" is accepted */
/* be careful for the initial status */

public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        dfs(res, num, "", 0, 0, 0, target);
        return res;
    }
    public void dfs(List<String> res, String num, String str, int index, long val, long preVal, int target) {
        if(index > num.length()) {
            return;
        }
        if(index == num.length() && val <= Integer.MAX_VALUE && val >= Integer.MIN_VALUE && (int) val == target) {
            res.add(str);
            return;
        }
        for(int i = index ; i < num.length() ; i++) {
            String temp = num.substring(index, i + 1);
            long curVal = Long.parseLong(temp);
            if(i != index && temp.charAt(0) == '0') {
                break;
            }
            if(index == 0) {
                dfs(res, num, temp, i + 1, curVal, curVal, target);
            }
            else {
                dfs(res, num, str + "+" + temp, i + 1, val + curVal, curVal, target);
                dfs(res, num, str + "-" + temp, i + 1, val - curVal, -curVal, target);
                dfs(res, num, str + "*" + temp, i + 1, val - preVal + preVal * curVal, preVal * curVal, target);    
            }            
        }
    }
}