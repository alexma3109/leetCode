/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int head = 1, tail = n;
        while(head <= tail) {
            int mid = head + (tail - head) / 2;
            if(isBadVersion(mid)) {
                tail = mid - 1;
            }
            else {
                head = mid + 1;
            }
        }
        return isBadVersion(head) ? head : tail;
    }
}