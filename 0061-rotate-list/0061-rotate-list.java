/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) return head;
        int count = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            count++;
        }

        tail.next = head;
        k = k % count;
        int n = count - k;
        ListNode newTail = head;

        for (int i = 1; i < n; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}