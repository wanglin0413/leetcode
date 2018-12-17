package easy;

public class ListIntersection {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //将两个list拼起来
        // A遍历到最后，从B开始； B遍历到最后从A开始
        //如果有intersection，则相等在intersection处
        //如果没有intersection，则相等在最后null处
        ListNode aI = headA;
        ListNode bI = headB;
        while (aI != bI){
            aI = aI == null ? headB : aI.next;
            bI = bI == null? headA : bI.next;
        }
        return aI;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
