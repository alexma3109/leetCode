public class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length == 0 || nums.length == 1) {
            return;
        }
        int head = 0, tail = 1;
        while(head < tail && tail < nums.length) {
            if(nums[head] == 0 && nums[tail] != 0) {
                nums[head] = nums[tail];
                nums[tail] = 0;
                head++;
                tail++;
                continue;
            }
            if(nums[head] != 0) {
                head++;
                tail++; // once head move, tail has to move //
            }
            else if(nums[tail] == 0) { // since tail moved in previous if, it may exceed length //
                tail++;
            }
        }
    }
}