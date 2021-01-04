package medium;

import utils.ListNode;

public class RotateList {
	public ListNode rotateRight(ListNode head, int k) {
		if(head == null)return null;
			ListNode fast = head;
			ListNode slow = head;
			for(int i = 0; i < k; i++){
				fast = fast.next;
				if(fast == null){
					fast = head;
					for(int j = 0; j < k%(i+1); j++){
						fast = fast.next;
					}
					break;
				}
			}
			while (fast.next != null){
				fast = fast.next;
				slow = slow.next;
			}
			fast.next = head;
		  ListNode newHead = slow.next;
			slow.next = null;
			return newHead;
	}

}
