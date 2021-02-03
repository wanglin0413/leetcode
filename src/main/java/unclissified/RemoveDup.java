package unclissified;

import utils.ListNode;

/**
 * Created by wanglin03 on 2017/9/30.
 */
public class RemoveDup {
    

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode tempHead = new ListNode(0);
        tempHead.next = head;
        ListNode pre = tempHead;
        ListNode curNode = head;
        while (curNode != null) {
            if (curNode.next != null && curNode.next.val == curNode.val) {
                curNode = curNode.next;
                continue;

            }
            if (pre.next == curNode) {
                pre = curNode;
            } else if (pre.next.val == curNode.val) {
                pre.next = curNode.next;
            }
            curNode = curNode.next;

        }
        return tempHead.next;

    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(2);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        ListNode newHead = deleteDuplicates(listNode1);
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }


    }


}
