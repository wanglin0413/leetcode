package hard;


public class MergeSortedList {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)return null;
        if(lists.length == 1)return lists[0];

        return mergeRe(lists, 0, lists.length - 1);
    }

    private ListNode mergeRe(ListNode[] lists, int low, int high) {
        if(low == high)return lists[low];
        if(low > high)return null;
        int mid = (low + high)/2;
        return merge(mergeRe(lists, low, mid), mergeRe(lists,mid+1, high));
    }

    private ListNode merge(ListNode first, ListNode second) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (true){
            if(first == null){
                cur.next = second;
                break;
            }
            if(second == null){
                cur.next = first;
                break;
            }
            if(first.val < second.val){
                cur.next = first;
                first = first.next;
            }else {
                cur.next = second;
                second = second.next;
            }
            cur = cur.next;
        }
        return head.next;
    }
}

class ListNode {
     int val;
      ListNode next;
    ListNode(int x) { val = x; }
  }
