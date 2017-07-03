/* Actually a BFS. Using queue to do FIFO */

public class Solution {
    public List<String> letterCombinations(String digits) {
        String[] strings = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        Queue<String> q = new LinkedList<>();
        List<String> res = new ArrayList<>();
        if(digits.length() == 0) {
            return res;
        }
        q.offer(""); // initialize //
        for(char c : digits.toCharArray()) {
            int index = Character.getNumericValue(c);
            int len = q.size(); // get the queue size first //
            for(int i = 0 ; i < len ; i++) { // loop len times, not queue.size() //
                String str = q.poll();
                for(char letter : strings[index].toCharArray()) {
                    q.offer(str + letter);
                }
            }
        }
        while(!q.isEmpty()) {
            res.add(q.poll());
        }
        return res;
    }
}