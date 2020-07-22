public class Solution15 {
    /*反转链表升级版
    * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。

    说明:
    1 ≤ m ≤ n ≤ 链表长度。*/

    /*
     * 遍历记录到第m个节点的前一个节点，
     * 进行反转
     * 进行反转，达到n后结束反转
     * 将三部分进行连接
     * */
    public ListNode reverseBetween(ListNode head, int m, int n) {

        /*遍历到达开始的节点*/
        if (head == null || head.next == null)
            return head;
        ListNode ans = null;
        if (m>1)
            ans = head;
        int index = 1;
        ListNode firstPart = null;
        ListNode secondPartTail;

        ListNode cur;
        ListNode pre;
        ListNode curNext;
        cur = head;
        while (index < m && cur.next != null){
            firstPart = cur;
            cur = cur.next;
            index++;
        }

        secondPartTail = cur;

        /*进行反转*/
        pre = cur;
        cur = cur.next;
        for (int i = m;i < n && cur != null;i++){

            curNext = cur.next;

            cur.next = pre;
            pre = cur;
            cur = curNext;


        }
        if (m == 1)
            firstPart = pre;
        if (ans == null)
            ans = pre;
        firstPart.next = pre;
        secondPartTail.next = cur;

        return ans;


    }
}
