package com.algorithms.chapter.practice.stack;

import java.util.Stack;

/**
 * 递归实现栈反转
 * @param <Item>
 */
public class ReverseStack<Item> {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        ReverseStack reverseStack = new ReverseStack();
        System.out.println("getAndRemoveLast args = [" + reverseStack.getAndRemoveLast(stack) + "]");
        reverseStack.reverse(stack);
        System.out.println("reverseStack arg  = [" + stack.pop() + "]");
    }

    /**
     * 获取栈底元素
     * @param stack
     * @return
     */
    public Item getAndRemoveLast(Stack<Item> stack){
        Item item = stack.pop();
        if(stack.empty()){
            return item;
        }else {
            Item last = getAndRemoveLast(stack);
            stack.push(item);
            return last;
        }
    }

    /**
     * 1，递归获取栈底元素
     * 2，并在最后将每个栈底元素push
     * @param stack
     */
    public void reverse(Stack<Item> stack){
        if(stack.empty()){
            return;
        }
        Item last = getAndRemoveLast(stack);
        reverse(stack);
        stack.push(last);
    }
}
