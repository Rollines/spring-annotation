package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chenjunlin  junlin.chen@msn.cn
 * @date 2019-04-08 10:01
 *
 * 队列有两个重要的操作，入队 enqueue 和出队 dequeue。
 * 此外，我们应该能够获得队列中的第一个元素，因为应该首先处理它。
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
public class EnAndDeQueue {
    public static void main(String[] args) {
        //1、定义一个队列
        Queue<Integer> q = new LinkedList<>();
        //2、获取第一个元素如果队列不存在就返回null
        System.out.println("The first element is: "+q.peek());
        //3、加入元素
        q.offer(5);
        q.offer(13);
        q.offer(8);
        q.offer(6);
        //4、pop一个元素
        q.poll();
        //5、获取第一个元素
        System.out.println("The first element is: " + q.peek());
        // 6. 获取队列长度
        System.out.println("The size is: " + q.size());
    }
}
