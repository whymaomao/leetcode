package com.yue;

public class addTwoListNodes {
  // reverse two ListNode
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode result = new ListNode();
    ListNode returnResult = result;
    ListNode l1_index = l1;
    ListNode l2_index = l2;
    int carry = 0;
    while(l1_index != null && l2_index != null) {
        int temp = (l1_index.val + l2_index.val + carry);
        carry = temp / 10;
        ListNode sumNode = new ListNode(temp % 10);
        result.next = sumNode;
        l1_index = l1_index.next;
        l2_index = l2_index.next;
        result = result.next;
    }

    while(l1_index != null) {
      int temp = (l1_index.val + carry);
      carry = temp / 10;
      ListNode sumNode = new ListNode(temp % 10);
      result.next = sumNode;
      l1_index = l1_index.next;
      result = result.next;
    }

    while(l2_index != null) {
      int temp = (l2_index.val + carry);
      carry = temp / 10;
      ListNode sumNode = new ListNode(temp % 10);
      result.next = sumNode;
      l2_index = l2_index.next;
      result = result.next;
    }
    return returnResult.next;
  }

}
