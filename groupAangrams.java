public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            char[] cArray = str.toCharArray();
            Arrays.sort(cArray);
            String sortedStr = String.valueOf(cArray);
            List<String> list = new ArrayList<>();
            if(!map.isEmpty() && map.containsKey(sortedStr)) {
                list = map.get(sortedStr);
            }
            list.add(str);
            map.put(sortedStr, list);
        }
        List<List<String>> res = new ArrayList<List<String>>(map.values());
        // map.values() is a list of value objects //
        return res;
    }
}

// exceed time limit //
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, Integer> map = new HashMap<>(); // store the index of list in listRes //
        List<List<String>> listRes = new ArrayList<>();
        for(String str : strs) {
            char[] cArray = str.toCharArray();
            Arrays.sort(cArray);
            String res = new String(cArray);
            if(!map.containsKey(res)) {
                List<String> list = new ArrayList<>();
                list.add(str);
                listRes.add(list);
                map.put(res, listRes.indexOf(list));
            }
            else {
                List<String> list = listRes.get(map.get(res));
                list.add(str);
                listRes.set(map.get(res), list);
            }
        }
        return listRes;
    }
}