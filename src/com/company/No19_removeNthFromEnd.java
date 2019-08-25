package com.company;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

public class No19_removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // find the Nth node from end
        if( n == 0) return head;

        ListNode result = new ListNode(-1);
        result.next = head;

        ListNode p1 = result;
        ListNode p2 = result;

        for(int i = 0; i < n && p1 != null; i ++)
        {
            p1 = p1.next;
        }
        if( p1 == null) return head;

        while(p1.next != null)
        {
            p1 = p1.next;
            p2 = p2.next;
        }

        // p2 indicates the pre node of the deleting node
        ListNode deleteNode = p2.next;
        if(deleteNode != null)
        {
            p2.next = deleteNode.next;
            return result.next;
        }
        else return head;
    }
}
