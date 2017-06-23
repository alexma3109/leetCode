public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        if(maxWidth == 0) {
            res.add("");
            return res;
        }
        int i = 0;
        while(i < words.length) {
        	int len = words[i].length();
        	int k = 1;
        	StringBuilder sb = new StringBuilder(words[i]);
        	while((i + k < words.length) && (len + words[i + k].length() + 1 <= maxWidth)) {
        		len += 1 + words[i + k].length();
        		k++;
        	} // find strings combo //
        	if(k == 1) { // if only 1 word //
        		sb.append(insertSp(maxWidth - len));
        	}
        	else if(i + k == words.length) { // if the last line //
        		for(int j = 0 ; j < k - 1 ; j++) {
        			sb.append(' ');
        			sb.append(words[i + j + 1]);
        		}
        		sb.append(insertSp(maxWidth - len));
        	}
        	else {
				int extra = (maxWidth - len) % (k - 1);
	        	for(int j = 0 ; j < k - 1 ; j++) {
        			sb.append(insertSp((maxWidth - len) / (k - 1) + 1));
        			if(extra > 0) { // extra 1 space from left to right//
        				sb.append(' ');
        				extra--;
        			}
        			sb.append(words[i + j + 1]);
        		}        		
        	}
        	res.add(sb.toString());
        	i += k;
        }
        return res;
    }
    public String insertSp(int num) {
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0 ; i < num ; i++) {
    		sb.append(' ');
    	}
    	return sb.toString();
    }
}