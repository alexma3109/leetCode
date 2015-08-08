public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        if(head.next.next == null){
            ListNode temp = head.next;
            temp.next = head;
            head.next = null;
            return temp;
        }
        ListNode curr = head.next;
        ListNode prev = head;
        ListNode next = head.next.next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head.next = null;
        return prev;
    }
}