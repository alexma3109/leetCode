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
            String s = dq.pollLast();
            System.out.println(s);
            sb.append(s);
        }
        return sb.length() == 0 ? "/" :sb.toString();
    }
}