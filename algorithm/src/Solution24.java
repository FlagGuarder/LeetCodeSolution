import java.util.List;

public class Solution24 {
    /*利用递归找到倒数节点*/
    //记录倒数的节点位置
    private int index;
    //记录正数的节点位置
    private int curIndex = 0;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        curIndex++;
        //找到末尾就返回
        if (head.next != null)
            removeNthFromEnd(head.next,n);
        curIndex--;
        //找到尾节点，将index初始化
        if (head.next == null){
            index = 0;
        }
        index++;
        //如果倒数的第n个节点为头节点的情况
        if (curIndex == 0 && index==n)
            return head.next;
        //倒数第n个节点前面还有节点
        if (index == n+1){
            head.next = head.next.next;
        }

        return head;
    }
}
