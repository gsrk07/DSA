/*
    Problem Statement: Given the head of a singly linked list, return the middle node of the linked list.
    If there are two middle nodes, return the second middle node.

 Input Format:
( Pointer / Access to the head of a Linked list )
head = [1,2,3,4,5]

Result: [3,4,5]
( As we will return the middle of Linked list the further linked list will be still available )

 */

import java.util.List;

class ListNode {

    int data;

    ListNode next;

    public ListNode(int data) {
        this.data = data;
    }

}
public class Main {
    public static void main(String[] args) {
        System.out.println("Middle of Linked List");
    }

    public ListNode middleofLL(ListNode head){

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

        }

        return slow;
    }
}