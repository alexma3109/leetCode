public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if(words.length == 0 || s == null || s.length() == 0){
            return list;
        }
        HashMap<String, Integer> map = new HashMap<>();
        int len = words[0].length();
        int totalLen = len * words.length;
        for(String str : words){
            if(map.containsKey(str)){
                map.put(str, map.get(str) + 1);
            }
            else{
                map.put(str, 1);
            }
            
        }
        for(int i = 0 ; i < s.length() - totalLen + 1 ; i++){
            String subStr = s.substring(i, i + len);
            if(map.containsKey(subStr)){
                HashMap<String, Integer> temp = new HashMap<>(map);
                String wholeStr = s.substring(i, i + totalLen);
                for(int j = 0 ; j < wholeStr.length() - len + 1 ; j += len){
                    String str = wholeStr.substring(j, j + len);
                    if(!temp.containsKey(str)){
                        break;
                    }
                    if(temp.get(str) == 1){
                        temp.remove(str);
                    }
                    else{
                        temp.put(str, temp.get(str) - 1);
                    }
                }
                if(temp.isEmpty()){
                    list.add(i);
                }
            }
        }
        return list;
    }
}