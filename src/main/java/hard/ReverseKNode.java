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
        //prev是反转后的链的头
        //next是待反转链的头
        //cur是从next转移到prev的那个节点
        //           cur   next  prev
        //            3- > 4  -> 5
        //           prev
        //            3 -> 5
        //                   cur   next
        //                   4  -> 5
        //           prev           cur
        //            4  -> 3  -> 5
        ListNode prev = reverseKGroup(cur, k);
        //然后自己的这组逆转一下

        //cur为待逆转链的头
        cur = head;
        count = 0;
        while (count < k){
            //next 为待逆转链的头
            ListNode next = cur.next;
            cur.next = prev;
            //prev是逆转后的链的头
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
