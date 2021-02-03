package easy;

import utils.ListNode;

public class MergeSortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2==null) return l1;
        ListNode root = l1;
        ListNode temp = l1;
        ListNode temp1=l1.next;
        ListNode temp2=l2;
        if(l1.val > l2.val){
            root = l2;
            temp = l2;
            temp1 = l1;
            temp2 = l2.next;
        }
        while (temp1 !=null && temp2 != null){
            if(temp1.val > temp2.val){
                temp.next = temp2;
                temp = temp2;
                temp2 = temp2.next;
            }else {
                temp.next = temp1;
                temp = temp1;
                temp1 = temp1.next;
            }
        }
        if(temp1 == null){
            temp.next = temp2;
        }else {
            temp.next = temp1;
        }
        return root;
    }

}


