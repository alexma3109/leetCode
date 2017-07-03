/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int head = 1, tail = n;
        while(head + 1 < tail) {
            int mid = head + (tail - head) / 2;
            if(isBadVersion(mid)) {
                tail = mid;
            }
            else {
                head = mid;
            }
        }
        return isBadVersion(head) ? head : tail;
    }
}