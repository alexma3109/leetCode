public class Solution {
    public int findPeakElement(int[] num) {
        if(num == null || num.length < 2){
            return 0;
        }
        int left = 0;
        int right = num.length - 1;
        while(left < right - 1){
            int mid = left + (right - left) / 2;
            if(num[mid] > num[mid + 1]){
                right = mid;
            }
            else{
                left = mid;
            }
        }
        return num[left] > num[right] ? left : right;
    }
}