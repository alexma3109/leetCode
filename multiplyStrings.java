/* use array to handle string calculation to save memory */
public class Solution {
    public String multiply(String num1, String num2) {
        String new1 = new StringBuilder(num1).reverse().toString();
        String new2 = new StringBuilder(num2).reverse().toString();
        int[] res = new int[num1.length() + num2.length()];
        for(int i = 0 ; i < num1.length() ; i++) {
            for(int j = 0 ; j < num2.length() ; j++) {
                res[i + j] += (new1.charAt(i) - '0') * (new2.charAt(j) - '0'); // use '+=' to add more //
            }
        }
        int carry = 0;
        for(int i = 0 ; i < res.length ; i++) {
            res[i] += carry;
            carry = res[i] / 10;
            res[i] = res[i] % 10;
        }
        StringBuilder str = new StringBuilder();
        for(int num : res){
        	str.insert(0, num);
        }
        while(str.charAt(0) == '0' && str.length() > 1) {
            str.deleteCharAt(0); // remove leading '0's 
        }
        return str.toString();
    }
}