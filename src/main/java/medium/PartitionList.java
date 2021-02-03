package medium;

import utils.ListNode;
import utils.MainClass;

public class PartitionList {
	//比x小的挪到前面，大于等于x的不变
	public ListNode partition(ListNode head, int x) {
		ListNode smallerHead = new ListNode();
		ListNode smallerEnd = smallerHead;

		ListNode biggerHead = new ListNode();
		ListNode biggerEnd = biggerHead;
		while (head != null){
			if(head.val < x){
				smallerEnd.next = head;
				smallerEnd = smallerEnd.next;
			}else {
				biggerEnd.next = head;
				biggerEnd = biggerEnd.next;
			}
			head = head.next;
		}
		smallerEnd.next = biggerHead.next;
		biggerEnd.next = null;
		return smallerHead.next;
	}

	public static void main(String[] args) {
		PartitionList partitionList = new PartitionList();
		int[] input = new int[]{1,4,3,2,5,2};
		ListNode head  = MainClass.arrayToListNode(input);
		head = partitionList.partition(head, 3);
		while (head != null){
			System.out.println(head.val);
			head = head.next;
		}
	}

}
