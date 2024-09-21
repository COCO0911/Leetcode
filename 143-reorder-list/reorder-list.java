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
    public void reorderList(ListNode head) {
        if (head == null) return;
        
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //reverse the second part of the list
        ListNode prev = null, curr = slow;
        while (curr != null) {
            //record tmp 在cur的下一个
            ListNode tmp = curr.next;
            //指向下一个
            curr.next = prev;
            //shift prev to curr
            prev = curr;
            //shift cur to recorded place
            curr = tmp;
        }
        
        ListNode first = head, second = prev;
        while (second.next != null) {
            ListNode tmp = first.next;
            first.next = second;
            first = tmp;
            
            tmp = second.next;
            second.next = first;
            second = tmp;
        }
    }
}