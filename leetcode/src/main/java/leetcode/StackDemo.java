package leetcode;

import java.util.Stack;

/**
 * @author chenjunlin  junlin.chen@msn.cn
 * @date 2019-04-08 10:21
 */
public class StackDemo {
    public static void main(String[] args) {
        // 1. 实例化一个栈
        Stack<Integer> s = new Stack<>();
        // 2. push一个元素.
        s.push(5);
        s.push(13);
        s.push(8);
        s.push(6);
        // 3. 检查栈是否为空.
        if (s.empty() == true) {
            System.out.println("Stack is empty!");
            return;
        }
        // 4. Pop 一个元素.
        s.pop();
        // 5. Get 获得顶端元素.
        System.out.println("The top element is: " + s.peek());
        // 6. Get 栈的长度.
        System.out.println("The size is: " + s.size());
    }
}
