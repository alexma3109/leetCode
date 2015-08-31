public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode node = head;
        while(node != null){
            stack.push(node);
            node = node.next;
        }
        node = head;
        while(!stack.isEmpty() && stack.pop().val == node.val){
            node = node.next;
        }
        return stack.isEmpty();        
    }
}