package easy;

public class RemoveLLVal {
    public ListNode removeElements(ListNode head, int val) {
        ListNode newHead = head;
        while (newHead != null && newHead.val == val){
            newHead = newHead.next;
        }
        if(newHead == null)return null;
        ListNode cur = newHead;
        ListNode next = cur.next;
        boolean needSkip = false;
        while (next != null){
            if(next.val == val){
                next = next.next;
                needSkip = true;
            }else {
                if(needSkip){
                    cur.next = next;
                    needSkip = false;
                }
                cur = cur.next;
                next = cur.next;
            }
        }
        if(needSkip){
            cur.next = null;
        }
        return newHead;
    }
    public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
}
