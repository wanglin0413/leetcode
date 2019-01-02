package easy;

import java.util.Stack;

public class ReverseLinkedList {
    //迭代
//    public ListNode reverseList(ListNode head) {
//        if(head == null)return null;
//        ListNode newTail = head;
//        ListNode cur = head.next;
//        ListNode newHead = head;
//        newTail.next = null;
//        while (cur != null){
//            newHead = cur;
//            cur = cur.next;
//            newHead.next = newTail;
//            newTail = newHead;
//        }
//        return newHead;
//    }
    //递归
    public ListNode reverseList(ListNode head) {
       if(head == null)return null;
       if(head.next == null)return head;

       //存了当前节点 head 下一个节点newHead
       ListNode newHead = head.next;
       head.next = null;
        //下一个节点的next 设为当前节点
       ListNode result = reverseList(newHead);
       newHead.next = head;
       return result;
    }
    public static class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

    public static void main(String[] args) {
        int[] testcase = new int[]{1,2,3,4,5};
        ListNode header = new ListNode(-1);
        ListNode cur = header;
        for(int each : testcase){
            ListNode eachnode = new ListNode(each);
            cur.next = eachnode;
            cur = cur.next;
        }
        ReverseLinkedList rll = new ReverseLinkedList();
        ListNode newlist = rll.reverseList(header.next);
        while (newlist != null){
            System.out.println(newlist.val);
            newlist = newlist.next;
        }
    }
}
