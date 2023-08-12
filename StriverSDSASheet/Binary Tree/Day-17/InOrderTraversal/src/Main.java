/*

Problem statement is given a binary tree, find the inorder traversal of the binary tree.
 */

import java.util.ArrayList;
import java.util.Stack;

class Node{

    Node left;
    Node right;
    int data;
    Node(int value){
        data = value;
        left = null;
        right = null;
    }

}

public class Main {

    public static ArrayList<Integer> inorder(Node root){

        Node curr = root;

        ArrayList<Integer> ans = new ArrayList<>();

        Stack<Node> st = new Stack<>();

        while(curr != null || st.size() > 0){

            while(curr != null){

                st.push(curr);
                curr = curr.left;
            }

            curr = st.pop();
            ans.add(curr.data);
            curr = curr.right;
        }

        return ans;
    }


    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);

        ArrayList<Integer> inordertraversal;

        inordertraversal = inorder(root);

        System.out.println(" inorder traversal is: ");

        for (int i = 0; i < inordertraversal.size(); i++){
            System.out.println(inordertraversal.get(i) + " ");
        }
    }
}

/*

 Using recursion the solution would be
public class Solution {

    ArrayList<Integer> ans = new ArrayList<Integer>();

    public ArrayList<Integer> inordertraversal(Node root) {

    Node curr = root;

    if(curr == null) {
    return ans;
    }

    inordertraversal(curr.left);
    ans.add(curr.data);
    inordertraversal(curr.right);

    return ans;

    }
  }

 */