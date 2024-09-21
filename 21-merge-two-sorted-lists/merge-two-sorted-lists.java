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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
       
        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val){
                cur.next = list1;
                list1 = list1.next;
            }else {
                cur.next =list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

        if (list1 != null){
            cur.next = list1;
            list1 = list1.next;
        }
        if (list2 != null) {
            cur.next = list2;
            list2 = list2.next;
        }

        return dummy.next;
    }
}

// list1 =[2,4]
       
// list2 =[3,4]
        

// dummy -> 1 -> 1 