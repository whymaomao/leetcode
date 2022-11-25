package com.yue;


import java.util.List;

// only one node left
// delete the first node
// delete the last node
public class listNodePractive {
    public ListNode removeNthFromEnd(ListNode head, int n) {
       if(head == null) return null;
       if(head.next == null && n == 1) {
         return null;
       }
       ListNode soldier = new ListNode(0);
       soldier.next = head;
       ListNode quick = soldier;
       ListNode slow = soldier;

       for(int i = 0; i < n; i ++) {
         if(quick.next != null) {
           quick = quick.next;
         }
       }

       while(quick.next != null) {
         quick = quick.next;
         slow= slow.next;
       }

       // delete node
      slow.next = slow.next.next;
       return soldier.next;
    }

    public ListNode detectNode(ListNode head) {
      ListNode fast = head;
      ListNode slow = head;

      while(fast != null && fast.next != null) {
          slow = slow.next;
          fast = fast.next.next;

          if(slow == fast) {
            fast = head;

            while(fast != slow) {
              fast = fast.next;
              slow = slow.next;
            }
            return fast;
          }
      }
      return null;
    }


  public ListNode mergeNodes(ListNode head) {
      if(head == null) return null;
      ListNode dummy = new ListNode(-1, head);
      ListNode temp = head;
      int tempSum = 0;
      ListNode zeroNode = dummy;
      while(temp != null ) {
          if(temp.val != 0) {
              tempSum += temp.val;
          } else{
            if(tempSum != 0) {
              ListNode newNode = new ListNode(tempSum, temp.next);
              zeroNode.next = newNode;
              zeroNode = newNode;
            } else {
              zeroNode.next = temp.next;
            }
            tempSum = 0;
          }
          temp = temp.next;
      }
      return dummy.next;
  }

}

