package com.interview;

import java.util.Arrays;
import java.util.Stack;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = new int[] {5, 4, 3, 2, 1, 6 };
      //  insertionSort(6, arr);
//        System.out.println(Arrays.toString(arr));

        Node n1 = new Node(5);
        Node n2 = new Node(3);
        Node n3 = new Node(1);
        Node n4 = new Node(2);
        Node n5 = new Node(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
//        insertionSortLL(n1);
       // pairsSwap(n1);
        kThCharaterOfDecryptedString("a12b3cd3", 8L);
    }


    public static char kThCharaterOfDecryptedString(String s, Long k)
    {
        // Write your code here

        Stack<Character> stack = new Stack<>();
        int n = s.length();
        for (int i = n - 1; i >= 0; i--) {
            stack.push(s.charAt(i));
        }
        int start = 0;
        int end = 0;
        String temp = "";
        String digit = "";
        var sb = new StringBuilder();
        Boolean indicator = null;

        while (!stack.isEmpty()) {
            char ch = stack.pop();
            if (Character.isLetter(ch)) {
                temp = temp + ch;
            } else if (Character.isDigit(ch)) {
                indicator = true;
                digit = digit + ch;
                if (stack.isEmpty() || Character.isLetter(stack.peek())) {
                    indicator = false;
                }
            }

            if (indicator != null && !indicator) {
                temp = temp.repeat(Integer.parseInt(digit));

                System.out.println(temp);
                temp = "";
                digit = "";
                indicator = null;
            }


        }


        return 'a';
    }

    public static void insertionSort(int n , int[] arr) {
        // Write your code here.
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {

                int j = i;
                while (j > 0 && arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    j--;
                }
            }
        }
    }

    public static Node pairsSwap(Node head) {
        // Write your code here.

        if (head == null) {
            return head;
        }
        Node dummy = new Node(-1);
        dummy.next = head;
        var curr = dummy;

        while (curr.next != null && curr.next.next != null) {
            curr.next = swap(curr.next, curr.next.next);
            curr = curr.next.next;
        }

        return dummy.next;
    }

    public static Node swap(Node prev, Node curr) {
        prev.next = curr.next;
        curr.next = prev;
        return curr;
    }

    public static Node insertionSortLL(Node head) {
        // Write your code here
        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = head;
        Node curr = head.next;

        while (curr != null) {

            if (curr.data < prev.data) {

                Node temp = dummy;
                while (curr.data > temp.next.data) {
                    temp = temp.next;
                }

                prev.next = curr.next;
                curr.next = temp.next;
                temp.next = curr;
                curr = prev.next;

            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return head.next;
    }
}

class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}
