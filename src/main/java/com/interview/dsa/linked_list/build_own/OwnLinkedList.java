package com.interview.dsa.linked_list.build_own;

import java.util.NoSuchElementException;

public class OwnLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public OwnLinkedList() {
        this.size = 0;
    }

    public void addFirst(int t) {
        var node = new Node(t);
        node.next = head;
        head = node;
        if (tail == null) {
            tail = head;
        }
        size += 1;
    }

    public void addLast(int t) {
        if (tail == null) {
            addFirst(t);
            return;
        }
        var node = new Node(t);
        tail.next = node;
        tail = node;
        size += 1;
    }

    public void addAt(int t, int index) {
        if (index == 0) {
            addFirst(t);
            return;
        }
        if (index == size) {
            addLast(t);
            return;
        }
        var node = new Node(t);
        Node temp = head;

        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
        size += 1;
    }

    public void insertRes(int val, int index) {
        head = insertRes(val, index, head);
    }

    private Node insertRes(int val, int index, Node node) {
        if (index == 0) {
            Node temp = new Node(val, node);
            size += 1;
            return temp;
        }

        node.next =  insertRes(val, index -= 1, node.next);

        return node;
    }

    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public int deleteFirst() {
        Node temp = head;
        if (temp == null) {
            throw new NoSuchElementException();
        }

        int val = temp.data;
        head = temp.next;
        var next = temp.next;

        temp.next = null;
        head = next;
        if (head == null) {
            tail = null;
        }
        size -= 1;
        return val;
    }

    public int deleteLast() {
        Node temp = tail;
        if (temp == null) {
            throw new NoSuchElementException();
        }


        if (size == 1) {
            return deleteFirst();
        }

        int data = tail.data;
        Node secondLast = get(size - 2);
        tail = secondLast;
        tail.next = null;
        size -= 1;
        return data;
    }

    public int deleteAt(int index) {
        if (!(index >= 0 && index < size)) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            return deleteFirst();
        }

        if (index == size - 1) {
            return deleteLast();
        }

        Node prevNode = get(index - 1);
        Node removerNode = prevNode.next;

        int data = removerNode.data;
        Node next = removerNode.next;
        prevNode.next = next;
        removerNode.next = null;

        size -= 1;
        return data;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.print("END");
    }


    public void reverse() {

        if (getSize() < 2) return;

        var present = head;
        Node previous = null;
        while (present != null) {
            var next = present.next;
            present.next = previous;
            previous = present;
            present = next;
        }

        head = previous;
    }

    public void test() {
        var mid = middleNode(head);
        var reverse = reverseLinkedList(mid);

        System.out.println();
    }
    Node reverseLinkedList (Node head) {
        // add your logic here
        if (head.next == null) return head;

        var present = head;
        Node previous = null;

        while (present != null) {
            var next = present.next;
            present.next = previous;
            previous = present;
            present = next;
        }

        return previous;
    }

    public Node middleNode(Node head) {

        var fast = head;
        var slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }


    public int getSize() {
        return size;
    }

    private static class Node {
         int data;
         Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
        
    }
}
