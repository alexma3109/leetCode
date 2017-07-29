/* one HashMap, two pointers */
/* left stay, scan right */
/* if value in map >= 0, then count++ */
/* after window formatted, move left or right */

public class Solution {
    public String minWindow(String s, String t) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int right = 0 ; right < t.length() ; right++) {
			if (map.containsKey(t.charAt(right))) {
				map.put(t.charAt(right), map.get(t.charAt(right)) + 1);
			}
			else {
				map.put(t.charAt(right), 1);
			}
		}
		int count = 0;
		int minStart = 0, minLen = s.length() + 1;
		int left = 0;
		for (int right = 0 ; right < s.length() ; right++) {
			if (map.containsKey(s.charAt(right))) {
				map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
				if (map.get(s.charAt(right)) >= 0) {
					count++;
				}
				while (count == s.length()) { // the window formatted when the first match found //
					int len = right - left + 1;
					if (len < minLen) {
						minLen = len;
						minStart = left;
					}
					if (map.containsKey(s.charAt(left))) {
						map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
						if (map.get(s.charAt(left)) > 0) {
							count--;
						}
					}
					left++;
				}
			}
		}
		if (minLen > s.length()) {
			return "";
		}
		return s.substring(minStart, minStart + minLen);
    }
}
