package medium;

public class SwapNode {
    public ListNode swapPairs(ListNode head) {
        ListNode ahead = new ListNode(-1);
        ahead.next = head;
        ListNode before = ahead;
        ListNode cur;
        ListNode next;
        while (before.next != null && before.next.next !=null){
            cur = before.next;
            next = cur.next;
            before.next = cur.next;
            cur.next = next.next;
            next.next = cur;
            before = cur;
        }
        return ahead.next;
    }

    public static class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        ListNode ahead = new ListNode(0);
        ListNode cur = ahead;
        for(int each : nums){
            cur.next = new ListNode(each);
            cur = cur.next;
        }

        SwapNode sn = new SwapNode();
        ahead = sn.swapPairs(ahead.next);
        while (ahead != null){
            System.out.println(ahead.val);
            ahead = ahead.next;
        }
    }
}
