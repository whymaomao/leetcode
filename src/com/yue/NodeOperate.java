package com.yue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NodeOperate {

    public static class Node {

        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node listGenerator(int length, String[] numbers) {
        Node head = new Node(Integer.parseInt(numbers[0]));
        Node cur = head;
        for (int i = 1; i < length; i++) {
            cur.next = new Node(Integer.parseInt(numbers[i]));
            cur = cur.next;
        }
        cur.next = null;
        return head;
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.value +" ");
            head = head.next;
        }
        System.out.println();
    }

    public static void remove(Node node) {
        if (node == null) {
            return;
        } else if (node.next == null) {
            throw new RuntimeException("cannot remove last node!");
        } else {
            node.value = node.next.value;
            node.next = node.next.next;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        String[] numbers = bufferedReader.readLine().split(" ");
        int num = Integer.parseInt(bufferedReader.readLine());
        Node head = listGenerator(n, numbers);
        Node node = head;
        int index = 1;
        while (node != null && index != num) {
            node = node.next;
            index++;
        }
        remove(node);
        printList(head);
    }
}
