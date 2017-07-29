/* maintain PriorityQueue, initialize with the first node of each list */
/* poll the head, and offer the head.next unless head.next is null */
/* null is not allowed in PriorityQueue */
/* time: poll() -> O(1); offer() -> O(log(k_heapSize); for & while loop -> O(n_nodeNum) */
/* form the res -> O(n_nodeNum) */
/* total time: O(log(k)) * O(log(n)) + O(log(n)) --> O(log(k)) * O(log(n)) */
/* space: O(log(k)) */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode> () {
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            } 
        });
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        for (int i = 0 ; i < lists.length ; i++) {
            if (lists[i] != null) {
                heap.offer(lists[i]);
            }            
        }
        while (!heap.isEmpty()) {
            node.next = heap.poll();
            if (node.next.next != null) {
                heap.offer(node.next.next);
            }            
            node = node.next;
        }
        return dummy.next;
    }
}