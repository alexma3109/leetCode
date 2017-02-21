/*******************
The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:

dir
    subdir1
        file1.ext
        subsubdir1
    subdir2
        subsubdir2
            file2.ext
**********************/

public class Solution {
    public int lengthLongestPath(String input) {
        int maxLen = 0;
        Deque<Integer> deque = new LinkedList<>();
        deque.push(0); // dummy root keeps deque.peek() valid //
        for(String str : input.split("\n")){
            int layer = str.lastIndexOf("\t") + 1; // get the current layer, root is 0 // 
            // if no "\t", str.lastIndexOf("\t") == -1 //
            while(layer < deque.size() - 1){ // find the parent. (size - 1{the dummy head}) //
                deque.pop();
            }
            int len = deque.peek() + str.length() - layer; // parent length + current length - '\t' //
            deque.push(len + 1); // + 1 for the slash //
            if(str.contains(".")){
                maxLen = Math.max(len, maxLen);
            }
        }
        return maxLen;
    }
}