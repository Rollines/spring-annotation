package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenjunlin  junlin.chen@msn.cn
 * @date 2019-04-08 09:41
 * 入队和出队。入队会向队列追加一个新元素，而出队会删除第一个元素。 所以我们需要一个索引来指出起点。
 *
 * MyCircularQueue(k): 构造器，设置队列长度为 k 。
 * Front: 从队首获取元素。如果队列为空，返回 -1 。
 * Rear: 获取队尾元素。如果队列为空，返回 -1 。
 * enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
 * deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
 * isEmpty(): 检查循环队列是否为空。
 * isFull(): 检查循环队列是否已满。
 *
 */
class MyQueue{
    private List<Integer> data;

    private int p_start;
    public MyQueue(){
        data = new ArrayList<Integer>();
        p_start = 0;
    }
    //插入一个元素到队列中，如果元素存在返回true
    public boolean enQueue(int x){
        data.add(x);
        return true;
    }
    //删除队列中的一个元素，如果成功返回true
    public boolean deQueue(){
        if (isEmpty() == true){
            return false;
        }
        p_start++;
        return true;
    }
    public boolean isEmpty(){
        return p_start >= data.size();
    }

    public int Front(){
        return data.get(p_start);
    }

};
public class TestQueue {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.enQueue(5);
        myQueue.enQueue(3);

        if (myQueue.isEmpty() == false){
            System.out.println(myQueue.Front());
        }
        myQueue.deQueue();
        if (myQueue.isEmpty() == false){
            System.out.println(myQueue.Front());
        }
        myQueue.deQueue();
        if (myQueue.isEmpty() == false){
            System.out.println(myQueue.Front());
        }
    }
}
