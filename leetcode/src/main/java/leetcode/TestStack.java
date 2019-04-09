package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenjunlin  junlin.chen@msn.cn
 * @date 2019-04-08 10:16
 *
 * 1. 入栈：你可以单击下面的 Push 按钮查看如何将新元素 6 添加到栈中。
 *
 * 2. 退栈：你可以单击下面的 Pop 按钮查看当你从栈中弹出一个元素时将移除哪个元素。
 */

class MyStack {
    private List<Integer> data;               // store elements
    public MyStack() {
        data = new ArrayList<>();
    }
    /** 插入一个元素到盏中. */
    public void push(int x) {
        data.add(x);
    }
    /** 检查这个盏是否为空 */
    public boolean isEmpty() {
        return data.isEmpty();
    }
    /** 从集合中获得队列. */
    public int top() {
        return data.get(data.size() - 1);
    }
    /** 从队列中删除一个水元素如果成功返回ture*/
    public boolean pop() {
        if (isEmpty()) {
            return false;
        }
        data.remove(data.size() - 1);
        return true;
    }
};
public class TestStack {
    public static void main(String[] args) {
        MyStack s = new MyStack();
        s.push(1);
        s.push(2);
        s.push(3);
        for (int i = 0; i < 4; ++i) {
            if (!s.isEmpty()) {
                System.out.println(s.top());
            }
            System.out.println(s.pop());
        }
    }
}
