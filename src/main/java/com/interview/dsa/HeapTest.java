package com.interview.dsa;

import java.util.Collections;
import java.util.PriorityQueue;

public class HeapTest {
    public static void main(String[] args) throws Exception {
//        Heap<Integer> heap = new Heap<>();
//        var heap1 = new PriorityQueue<Integer>();
//        heap1.add(6);
//        heap1.add(4);
//        System.out.println(heap1.peek());
//        System.out.println();
//
//        heap.insert(89);
//        heap.insert(72);
//        heap.insert(71);
//        heap.insert(55);
//        heap.insert(34);
//
//        System.out.println(heap);
//
//        System.out.println(heap.remove());
//
//        System.out.println(heap);

        findMedian(new int[] {6, 2, 1, 3, 7, 5});
        //5 4 3 2 1
        System.out.println();
        findMedian(new int[] {5,4,3,2,1});
    }

    public static void findMedian(int arr[])  {


        var maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        var minHeap = new PriorityQueue<Integer>();

        for (int i = 0; i < arr.length; i++) {
            int item = arr[i];
            if (i == 0) {
                maxHeap.add(item);
                System.out.print(maxHeap.peek() + " ");
            } else if ((i + 1)  % 2 != 0) {

                if (minHeap.peek() < item) {
                    maxHeap.add(minHeap.poll());
                    minHeap.add(item);
                } else {
                    maxHeap.add(item);
                }
                System.out.print(maxHeap.peek() + " ");
            } else  {
                if (maxHeap.peek() > item ) {
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(item);
                } else {
                    minHeap.add(item);
                }
                System.out.print(((maxHeap.peek() + minHeap.peek()) / 2 ) + " ");
            }
        }

    }
}
