/* DFS */
public class Solution {
    public List<String> removeInvalidParentheses(String s) {
    	List<String> res = new ArrayList<>();
    	helper(res, s, 0, 0, new char[] {'(', ')'});
    	return res;
    }
    public void helper(List<String> list, String str, int start, int index, char[] par) {    	
    	for(int i = start, count = 0; start < str.length() ; i++) {
    		if(str.charAt(i) == par[0]) {
    			count++;
    		}
    		if(str.charAt(i) == par[1]) {
    			count--;
    		}
    		if(count < 0) { // whenever count < 0, it's invlid //
    			for(int j = index ; j <= i ; j++) {
    				// j = index, the old index was kicked out, //
    				// the new index is (j + 1) from the last recurse //
    				// j == i is OK, since i < s.length() //
    				if(s.charAt(j) == par[1] && (j == index || s.charAt(j - 1) != par[1])) {
    					// remove the ')', but it either the first, //
    					// or the previous char cannot be ')' as well //
    					// otherwise it'll be duplicate // 
    					helper(list, str.substring(0, j) + str.substring(j + 1), i, j, par);
    				}
    			}
    			return; // invalid str cannot go to the following part //	
    		}
    	}
    	String strRev = new StringBuilder(s).reverse().toString();
    	if(par[0] == '(') { 
    	// '(' may be extra, do the same from tail //
    	// reverse par[] as well //
    		helper(list, strRev, 0, 0, new char[] {')', '('}); // start, index have to be reset //
    	}
    	else {
    		res.add(strRev);
    	}
    }
}