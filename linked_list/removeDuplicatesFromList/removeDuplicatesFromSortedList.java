/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        //initialise a dummy node
        ListNode dummy = new ListNode(0), d = dummy;
        //assign dummy next to head
        dummy.next = head; 
        while(head!=null){
            //if there are no duplicate nodes found, increment the dummy and head pointer
            if(head.next == null || head.next.val != head.val) {
                //dummy.next = head is used to establish a reference and connection when there are duplicate nodes. This will connect the node and discard the duplicate ones
                dummy.next = head;
                //increment dummy
                dummy = dummy.next;
                //increment head
                head = head.next;
            }else{
                // increment head pointer until we find the value where there are no duplicates
                int val = head.val;
                while(head!=null && head.val == val){
                    head = head.next;
                }
            }
        }
        dummy.next = null;
        
        return d.next;
    }
}
  
