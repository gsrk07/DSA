/*

Problem Statement: Given the head of a linked list,
reverse the nodes of the list k at a time, and return the modified list.
k is a positive integer and is less than or equal to the length of the linked list.
If the number of nodes is not a multiple of k then left-out nodes, in the end,
should remain as it is.

Example 1:
Input:
 head = [1,2,3,4,5,6,7,8] k=3
Output:
 head = [3,2,1,6,5,4,7,8]

 */
public class Main {

    public static void main(String[] args) {
        System.out.println(" Reversing LL in groups of size K");
    }

}


 // Definition for singly-linked list.
 class ListNode {
     int val;
    ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        /* firstly we find the length of the given linked list.
        / if we see that there is no linked list or we have a single node, then we will not do any reversal
        */

        if(head == null || k == 1) {
            return head;
        }

        // we need to find the length of the given linked list, so that we can start reversing in groups of K based on length. so we will have lengths/k groups.

        ListNode temp = new ListNode(0);
        temp.next = head;

        ListNode prev = temp; // this is the node which points to last node of the previous group of list reversed.

        ListNode curr = temp; // this is always pointing to the first node of the list in a group which is to be reversed.
        ListNode Next = temp; // this is always pointing to the second node of the list in a group which is to be reversed.

        int length = 0;

        while(curr.next != null){
            curr = curr.next;
            length++;
        }

        // now we start reversing the LL in groups of length k

        while(length >= k){

            curr = prev.next;
            Next = curr.next;

            for (int i = 1; i < k; i++){

                curr.next = Next.next;
                Next.next = prev.next;
                prev.next = Next;
                Next = curr.next;

            }

            prev = curr; // vv imp step to consider to solve this question.
            length -= k;

        }


        return temp.next;

    }


}