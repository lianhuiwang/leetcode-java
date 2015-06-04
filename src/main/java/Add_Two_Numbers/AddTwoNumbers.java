package Add_Two_Numbers;

public class AddTwoNumbers {

 
   //Definition for singly-linked list.
   public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
   }
   
  public class Solution {
      public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = null;
        ListNode head = null;
        ListNode head1 = l1;
        ListNode head2 = l2;
        int carry = 0;
        while (head1 != null || head2 !=null) {
          int i1 = head1==null ?0 : head1.val;
          int i2 = head2==null ?0 : head2.val;
          int sum = i1 + i2 +carry;
          int value = sum % 10;
          carry = sum/10;
          ListNode temp = new ListNode(value);
          if (prev == null) {
            prev = temp;
            head = temp;
          } else {
            prev.next = temp;
            prev = temp;
          }
          if (head1 != null) {
            head1 = head1.next;
          }
          if (head2 != null) {
            head2 = head2.next;
          }
        }
        if (carry > 0) {
          prev.next = new ListNode(carry);
        }
        return head;
      }
  }
}
