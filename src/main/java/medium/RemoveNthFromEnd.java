package medium;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 1;
        ListNode ahead = new ListNode(-1);
        ahead.next = head;
        while (head.next != null){
            head = head.next;
            count++;
        }
        if(count < n)return ahead.next;
        ListNode beforeCur = ahead;
        ListNode cur = beforeCur.next;
        while (count > n ){
            beforeCur = cur;
            cur = cur.next;
            count--;
        }
        if(cur ==null){
            beforeCur.next = null;
        }else {
            beforeCur.next = cur.next;
        }
        return ahead.next;
    }

    public static class ListNode {
     int val;
     ListNode next;
    ListNode(int x) { val = x; }
 }

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        ListNode ahead = new ListNode(0);
        ListNode cur = ahead;
        for(int each : nums){
            cur.next = new ListNode(each);
            cur = cur.next;
        }
        RemoveNthFromEnd rne = new RemoveNthFromEnd();
        ahead = rne.removeNthFromEnd(ahead.next, 1);
        while (ahead != null){
            System.out.println(ahead.val);
            ahead = ahead.next;
        }
    }
}
