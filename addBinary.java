public class Solution {
    public String addBinary(String a, String b) {
        int sum = 0; // carry and sum can be combined together //
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        while(i >= 0 || j >= 0) {
            if(i >= 0 && j >= 0) {
                sum += Character.getNumericValue(a.charAt(i)) + Character.getNumericValue(b.charAt(j));
            }
            else if(i >= 0) {
                sum += Character.getNumericValue(a.charAt(i));
            }
            else {
                sum += Character.getNumericValue(b.charAt(j));
            }
            sb.append(sum % 2);
            sum = sum / 2;
            i--;
            j--;
        }
        if(sum == 1) {
            sb.append(sum);
        }
        return sb.reverse().toString();
    }
}