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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy_head = new ListNode(0);
        ListNode l3 = dummy_head;

        int carry=0;

        
        while(l1 != null || l2 != null || carry != 0){
            int l1_val = (l1 != null) ? l1.val : 0;
            int l2_val = (l2 != null) ? l2.val : 0;

            int sum = l1_val + l2_val + carry;

            int ans = sum % 10;
            carry = sum / 10;

            ListNode node = new ListNode(ans);
            l3.next = node;
            l3 = l3.next;

            // if (l1 != null) l1 = l1.next;
            // if (l2 != null) l2 = l2.next;

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        if (carry > 0){
            ListNode node = new ListNode(carry);
            l3.next = node;
            l3 = l3.next;
        }
        return dummy_head.next;
        
        // ListNode result = dummy_head.next;
        // dummy_head.next = null;
        // return result;
    }
}