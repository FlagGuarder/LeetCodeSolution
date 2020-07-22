import java.util.List;

class ListNode{
    ListNode next = null;
    int val;
    public ListNode(int x){
        this.val = x;
    }
}

public class Solution {

    public static void main(String[] args) {

    }

    ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode1 = null;
        ListNode listNode2 = null;
        ListNode node ;
        ListNode returnList = null;
        ListNode list = null;
        listNode1 =l1;
        listNode2 = l2;

        int sum = 0;
        while(listNode1!=null && listNode2!=null){
            if (list!=null){
                if (sum!=0){
                    node = new ListNode(sum);
                    list.next = node;
                    list = list.next;

                    list.val = (list.val+listNode1.val+listNode2.val)%10;
                    sum = (sum+listNode1.val+listNode2.val)/10;
                }else {
                    node = new ListNode((listNode1.val+listNode2.val)%10);
                    list.next = node;
                    list = list.next;
                    sum = (listNode1.val+listNode2.val)/10;
                }

            }else {
                list = new ListNode((listNode1.val+listNode2.val)%10);
                returnList = list;
                sum = (listNode1.val+listNode2.val)/10;
            }


            listNode1 = listNode1.next;
            listNode2 = listNode2.next;
        }
        if (listNode1==null&&listNode2==null&&sum!=0){
            node = new ListNode(sum);
            list.next = node;
            list = list.next;
            sum = 0;
        }
        while (listNode1!=null){
            if (sum==0) {
                node = new ListNode(listNode1.val);
                list.next = node;
                list = list.next;
                listNode1 = listNode1.next;
            }else{
                node = new ListNode(sum);
                node.val = (node.val+listNode1.val)%10;
                list.next = node;
                list = list.next;
                sum = (sum+listNode1.val)/10;
                listNode1 = listNode1.next;


            }
        }
        while (listNode2!=null){
            if (sum==0){
                node = new ListNode(listNode2.val);
                list.next = node;
                list = list.next;

                listNode2 = listNode2.next;
            }else {
                node = new ListNode(sum);
                node.val = (node.val+listNode2.val)%10;
                list.next = node;
                list = list.next;
                sum = (sum+listNode2.val)/10;
                listNode2 = listNode2.next;

            }


        }
        if(sum!=0){
            node = new ListNode(sum);
            list.next = node;

        }

    return returnList;
    }
}
