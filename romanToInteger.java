public class Solution {
    public int romanToInt(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
        for(int i = 0 ; i < s.length() ; i++){
            int curr = map.get(s.charAt(i));
            if(i + 1 < s.length() && map.get(s.charAt(i + 1)) > curr){
                curr = -curr;
            }
            res += curr;
        }
        return res;
    }
}