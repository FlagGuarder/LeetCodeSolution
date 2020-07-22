
public class Solution14 {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        ListNode curNext = null;
        ListNode temp;
        pre = cur;
        temp = cur;
        if (cur == null || cur.next == null)
            return cur;
        cur = cur.next;
        while (cur.next != null){


            curNext = cur.next;

            cur.next = pre;
            pre = cur;
            cur = curNext;

        }
        cur.next = pre;
        temp.next = null;
        return cur;
    }
}
