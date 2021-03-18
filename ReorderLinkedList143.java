/*
Input : 1->2->3->4->5->6->7->8    
Output: 1->8->2->7->3->6->4->5

Split 
1->2->3->4
5->6->7->8

Reverse Second half
5->6->7->8    ===> 8->7->6->5

Merge both parts
1->8->2->7->3->6->4->5
*/    

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/*
Input : 1->2->3->4->5->6->7->8    
Output: 1->8->2->7->3->6->4->5

Split 
1->2->3->4
5->6->7->8

Reverse Second half
5->6->7->8    ===> 8->7->6->5

Merge both parts
1->8->2->7->3->6->4->5
*/    
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/*
Input : 1->2->3->4->5->6->7->8    
Output: 1->8->2->7->3->6->4->5

Split 
1->2->3->4
5->6->7->8

Reverse Second half
5->6->7->8    ===> 8->7->6->5

Merge both parts
1->8->2->7->3->6->4->5
*/    
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next != null)
            return;
        //Head of first half
        ListNode l1= head;
        //Head of second half
        ListNode slow= head;
        //Tail of second half
        ListNode fast= head;
        //Tail of first half
        ListNode prev= null;
        
        while(fast != null && fast.next != null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        
        ListNode l2= reverseLinkedList(slow);
        
        merge(l1,l2);
        
    }
    
    public ListNode reverseLinkedList(ListNode head)
    {
        ListNode prev= null;
        ListNode current_node = head;
        
        while(current_node != null)
        {
            //current_node =5,6,7,8
            ListNode next_node= current_node.next;
            //next_node =6,7,8,null
            current_node.next = prev;
            //current_node.next= null,5,6,7
            prev= current_node;
            //prev= 5,6,7,8
            current_node = next_node;
            //current_node =6,7,8,null
        }
        return prev;
    }
    
    public void merge(ListNode l1, ListNode l2)
    {
        while(l1 != null)
        {
            ListNode l1_next = l1.next;
            ListNode l2_next = l2.next;
            
            l1.next = l2;
            
            if(l1_next == null)
                break;
            
            l2.next = l1_next;
            l1= l1_next;
            l2 = l2_next;
        }
    }
}
