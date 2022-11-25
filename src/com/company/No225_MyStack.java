package com.company;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class No225_MyStack {

    Queue<Integer> inQueue = new LinkedList<>();

    public No225_MyStack() {

    }

    public void push(int x) {
        inQueue.add(x);
        int count = inQueue.size();
        while(count -- > 1) {
            inQueue.add(inQueue.poll());
        }
    }

    public int pop() {
        return inQueue.poll();
    }

    public int top() {
        return inQueue.element();
    }

    public boolean empty() {
        return inQueue.isEmpty() ;
    }

    public static void main(String[] args) {
        Map<String, Integer> test = new HashMap<>();
        test.put("test", 1);
        test.put("allow", 2);
        System.out.println(test.get("1234"));
    }
}
