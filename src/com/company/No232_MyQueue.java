package com.company;

import java.util.LinkedList;
import java.util.Stack;

public class No232_MyQueue {
    Stack<Integer> inStack = new Stack<>();
    Stack<Integer> outStack = new Stack<>();

    public No232_MyQueue() {

    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        in2Out();
        return outStack.pop();
    }

    public int peek() {
        in2Out();
        return outStack.peek();
    }

    private void in2Out() {
        if(outStack.empty()) {
            while(!inStack.empty()) {
                outStack.push(inStack.pop());
            }
        }
    }

    public boolean empty() {
        return inStack.empty() && outStack.empty();
    }
}
