package hard;

public class ReverseKNode {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode cur = head;
        while (count < k){
            if (cur == null)return head;
            cur = cur.next;
            count++;
        }
        //现在prev是下一个group逆转后的head，cur是下一个group的head
        ListNode prev = reverseKGroup(cur, k);
        //然后自己的这组逆转一下
        cur = head;
        count = 0;
        // cur和next 为待逆转链的头
        //prev为逆转后的头
        while (count < k){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            count++;
        }

        return prev;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        ListNode ahead = new ListNode(-1);
        ListNode cur = ahead;
        for(int each : nums){
            cur.next = new ListNode(each);
            cur = cur.next;
        }
        ReverseKNode rkn = new ReverseKNode();
        ahead = rkn.reverseKGroup(ahead.next, 1);
    }
}
