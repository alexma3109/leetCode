public class Solution {
    public String simplifyPath(String path) {
        String[] strs = path.split("/");
        Deque<String> dq = new LinkedList<>();
        for(String str : strs) {
            if(str.equals("") || str.equals(".")) {
                continue;
            }
            if(str.equals("..")) {
                if(!dq.isEmpty()) {
                    dq.pop();
                }
            }
            else {
                dq.push(str);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!dq.isEmpty()) {
            sb.append('/');
            sb.append(dq.pollLast());
        }
        return sb.length() == 0 ? "/" :sb.toString();
    }
}