package easy;

public class LinkListCircle {
    public boolean hasCycle(ListNode head) {
        ListNode cur = head;
        while (cur != null){
            if(cur.val == Integer.MAX_VALUE)return true;
            cur.val = Integer.MAX_VALUE;
            cur = cur.next;
        }
        return false;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
