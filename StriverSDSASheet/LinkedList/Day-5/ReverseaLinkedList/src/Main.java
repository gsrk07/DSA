/*

Problem Statement: Given the head of a singly linked list,
write a program to reverse the linked list, and return the head pointer to the reversed list.

Input Format:
head = [3,6,8,10]
This means the given linked list is 3->6->8->10 with head pointer at node 3.

Result:
Output = [10,6,8,3]
This means, after reversal, the list should be 10->6->8->3 with the head pointer at node 10.
 */


class ListNode {

    int data;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
    }
}

public class Main {

    public static void main(String[] args) {
        System.out.println(" Reverse a LL");
    }

    public ListNode reverseLL (ListNode head){

        // we first create a dummy node which will be the new head node.

        ListNode newhead = null;

        while(head != null) {

        ListNode next = head.next;
        head.next = newhead;
        newhead = head;
        head = next;

        }

        return newhead;
    }

}