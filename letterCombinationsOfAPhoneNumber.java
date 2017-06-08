/* Actually a BFS. Using queue to do FIFO */

public class Solution {
    public List<String> letterCombinations(String digits) {
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        LinkedList<String> q = new LinkedList<>();
        if(digits == null || digits.length() == 0){
            return q;
        }
        q.add("");// initialize the loop !important //
        for(int i = 0 ; i < digits.length() ; i++){
            int num = digits.charAt(i) - '0';
            while(q.peek().length() == i){// as long as it's length is i, then it's not handled yet //
                String str = q.remove();
                for(char c : mapping[num].toCharArray()){
                    StringBuilder sb = new StringBuilder(str);
                    sb.append(c);
                    q.offer(sb.toString());
                }
            }
        }
        return q;
    }
}