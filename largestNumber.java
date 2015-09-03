public class Solution {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0 ; i < nums.length ; i++){
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, new Comparator<String>(){
            public int compare(String a, String b){
                String l = a + b;
                String r = b + a;
                return -l.compareTo(r);//// if(l > r) return 1, if(l > r), then a > b, need the array to be decreasing//// 
            }
        });
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            sb.append(s);
        }
        while(sb.charAt(0) == '0' && sb.length() > 1){
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}