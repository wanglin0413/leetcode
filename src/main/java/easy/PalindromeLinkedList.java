package easy;

import utils.ListNode;

public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)return true;
        if(head.next.next == null)return head.val == head.next.val;
        //先用快慢指针找到中点
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next !=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast != null) slow= slow.next;
        //然后reverse后半部分
        ListNode next = reverse(slow);
        ListNode first = head;
        while(next != null){
            if(first.val != next.val)return false;
            first = first.next;
            next = next.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head){
        if(head == null || head.next == null)return head;
        ListNode newTail = head;
        ListNode cur = head.next;
        ListNode newHead = head;

        newTail.next = null;
        while(cur != null){
            newHead = cur;
            cur = cur.next;
            newHead.next = newTail;
            newTail = newHead;
        }
        return newHead;
    }

    public static void main(String[] args) {
        int[] testcase = new int[]{1,1,2,1};
        ListNode header = new ListNode(-1);
        ListNode cur = header;
        for(int each : testcase){
            ListNode eachnode = new ListNode(each);
            cur.next = eachnode;
            cur = cur.next;
        }
        PalindromeLinkedList pll = new PalindromeLinkedList();
        System.out.println(pll.isPalindrome(header.next));
    }
}
