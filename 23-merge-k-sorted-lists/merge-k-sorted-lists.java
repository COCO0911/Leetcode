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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0 || lists == null) return null;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> (a - b));

        //把所有listNode加进去minheap里面
        for (ListNode cur : lists){
            while (cur != null) {
                minHeap.add(cur.val);
                cur = cur.next;
            }
        }

        ListNode dummy = new ListNode();
        ListNode head = dummy;

        //每次minHeap出来的都是heap里面最小的
        while(!minHeap.isEmpty()){
            head.next = new ListNode(minHeap.remove());
            head = head.next;
        }

        return dummy.next;
    }
}