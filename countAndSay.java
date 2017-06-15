public class Solution {
    public String countAndSay(int n) {
        if(n == 1) {
            return "1";
        }
        StringBuilder sb = new StringBuilder();
        String str = countAndSay(n - 1);
        char curr = str.charAt(0);
        int count = 1;
        for(int i = 1 ; i < str.length() ; i++) {
            if(str.charAt(i) == str.charAt(i - 1)) {
                count++;
            }
            else {
                sb.append(count);
                sb.append(curr);
                count = 1;
                curr = str.charAt(i);
            }
        }
        sb.append(count);// handle the last several chars //
        sb.append(curr);
        return sb.toString();
    }
}