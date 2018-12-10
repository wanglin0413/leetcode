package easy;

public class RemoveListDup {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)return null;
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null){
            if(cur.val != pre.val){
                pre.next = cur;
                pre = cur;
            }
            cur = cur.next;
        }
        pre.next = null;
        return head;
    }

     public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
