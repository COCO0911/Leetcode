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
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
    
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int list1 = (l1 == null) ? 0 : l1.val;
            int list2 = (l2 == null) ? 0 : l2.val;
            
            int value = list1 + list2 + carry;
            
            carry = value / 10;
            value = value % 10;
            cur.next = new ListNode(value);
            
    
            cur = cur.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
           
        }
        
        
        return dummy.next;

    }
}