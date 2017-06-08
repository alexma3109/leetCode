public class Solution {
    public String intToRoman(int num) {
        String[] M = {"", "M", "MM", "MMM"};
        String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        StringBuilder sb = new StringBuilder();
        sb.append(M[num / 1000]);
        sb.append(C[(num % 1000) / 100]);
        sb.append(X[(num % 100) / 10]);
        sb.append(I[(num % 10)]);
        return sb.toString();
    }
}