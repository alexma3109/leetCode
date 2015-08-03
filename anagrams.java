public class Solution {
    public List<String> anagrams(String[] strs) {
        List<String> res = new ArrayList<String>();
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();		
		for(int i = 0 ; i < strs.length ; i++){
			char[] charArray = strs[i].toArray();
			Arrays.sort(charArray);
			String string = new String(charArray);
			if(map.containsKey(string)){
				map.get(string).add(strs[i]);
			}
			else{
				ArrayList<String> temp = new ArrayList<String>();
				temp.add(strs[i]);
				map.put(string, temp);
			}
		}
		Iterator iter = map.values().iterator();
		while(iter.hasNext()){
			ArrayList<String> temp = (ArrayList) iter.next();
			if(temp.size() > 1){
				res.addAll(temp);
			}
		}
		return res;
    }
}