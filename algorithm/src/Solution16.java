public class Solution16 {
    /*反转链表升级版
* 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。

说明:
1 ≤ m ≤ n ≤ 链表长度。*/
    private ListNode left;
    private boolean stop;
    public void recurseAndReverse(ListNode right, int m, int n){
        if (n == 1)
            return;

        right = right.next;
        if (m > 1)
            this.left = this.left.next;

        recurseAndReverse(right, m-1,n-1);
        if (right == this.left || right.next == this.left){
            this.stop = true;
        }
        if (!this.stop){
            int val = this.left.val;
            this.left.val = right.val;
            right.val = val;

            this.left = this.left.next;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n){
        this.left = head;
        this.stop = false;
        recurseAndReverse(head,m,n);
        return head;
    }
}
