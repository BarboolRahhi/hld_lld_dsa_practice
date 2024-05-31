package com.interview.dsa.linked_list.build_own;

import java.util.LinkedList;

public class Test {

    public static void main(String[] args) {
        String a = "";
        var e = a == "d" ? 1 : null;
        System.out.println(e);
        OwnLinkedList linked = new OwnLinkedList();

//        linked.addFirst(3);
//        linked.addFirst(5);
//        linked.addFirst(7);
//
//        linked.addLast(56);
        linked.addLast(1);
        linked.addLast(2);
        linked.addLast(3);
        linked.addLast(4);
        linked.addLast(5);

        //linked.addAt(78, linked.getSize() - 1);

//        System.out.println(linked.deleteFirst());
//
//        System.out.println(linked.deleteLast());

//        linked.display();
//        System.out.println();
//        //System.out.println(linked.deleteAt(1));
//        linked.insertRes(5, 2);
//        linked.display();

        linked.display();
        linked.reverse();
        System.out.println();
        linked.display();

        System.out.println("hello");
        System.out.println(3 % 3);
    }


    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k  + 1];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            max = Math.max(max, nums[i]);
        }
        result[0] = max;
        int resIndex = 1;
        int left = 1;
        int right = 3;

        while (right < nums.length) {
           // if (nums[right] )
            left++;
            right++;
        }

        return result;
    }
}
