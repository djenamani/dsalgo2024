package com.dj.ds.algo;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given a singly linked list, remove the nth node
 * from the end of the list and return its head.
 *
 * For Example, {1, 2, 4, 3, 6} and n = 3 then 4 will be removed from the list
 * and the head will be returned {1, 2, 3, 6}
 */
public class RemoveNthNode {

    public Node removeNthNode(Integer[] arr, int n){
        // Set two pointers left and right at the beginning of the linked list or the head
        LinkedList<Integer> list = new LinkedList<>();
        list.insertArray(arr);
        System.out.println(list.toString());

        // define two pointers at the head of the list
        Node left = list.head;
        Node right = list.head;

        // Now move the right pointer n elements away from left
        for (int i = 0; i < n; i++){
            right = right.next;
        }

        // To handle the edge case where the nth node would be the first element or the
        // head of the list.
        if(right == null)
        {
            return list.head.next;
        }

        // Move both left and right pointer until right pointer reaches the last node
        while(right.next != null){
            right = right.next;
            left = left.next;
        }

        left.next = left.next.next;
        //System.out.println(list.head.data);
        return list.head;
    }

    // Print the items in the list
    public static void printList(Node headNode){
        //print elements in the linkedlist starting from the head node
        Node tempNode = headNode;
        StringBuffer sb = new StringBuffer();
        while(tempNode != null)
        {
            sb.append(tempNode.data + " -> ");
            // move the pointer to next node
            tempNode = tempNode.next;
            if(tempNode == null){
                sb.append("null");
            }
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        RemoveNthNode removeNthNode = new RemoveNthNode();
        Node headNode = removeNthNode.removeNthNode(new Integer[]{1, 2, 3, 5, 7, 10}, 6);
        printList(headNode);
    }

    // Define the LinkedList data structure to store elements
    class LinkedList<T> {
        // head of the linked list
        Node head;

        LinkedList(){
            this.head = null;
        }

        // this method will insert the node to the head of the linked list
        void insertNodeAtHead(Node node){
            if(this.head == null) {
                head = node;
            }
            else {
                node.next = this.head;
                this.head = node;
            }
        }

        public void insertArray(Integer[] arr){
            List<Integer> reversedList = Arrays.asList(arr);
            Collections.reverse(reversedList);

            reversedList.stream().forEach(System.out::println);

            reversedList.stream().forEach(i -> insertNodeAtHead(new Node(i)));
        }
    }

    /**
     * Linked Nodes to contain values of Integer type
     */
    class Node{
        public int data;
        public Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
}
