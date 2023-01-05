package linkNodeList.Solution88;

public class Solution {

      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode resultList = null;

        ListNode tempNode = null;
        ListNode currentNode = null;
        while (list1 != null || list2!=null){
            if (list1!=null && list2!=null){
                if (list1.val < list2.val){
                    tempNode = list1;
                    list1 = list1.next;
                }else {
                    tempNode = list2;
                    list2 = list2.next;
                }
            }else if (list1!=null){
                tempNode = list1;
                list1 = list1.next;
            }else if (list2!=null){
                tempNode = list2;
                list2 = list2.next;
            }
            if (resultList == null){
                resultList = tempNode;
                currentNode = tempNode;
            }else {
                currentNode.next = tempNode;
                currentNode = currentNode.next;
            }


        }
        return resultList;
    }
}
