package com.spring.effective;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author chenjunlin  junlin.chen@msn.cn
 * @date 2019-03-26 11:01
 *
 * LinkedHashMap通常提供的是遍历顺序符合插入顺序，它的实现是通过为条目（键值对）维护一个双向链表。注意，通过特定构造函数，我们可以创建反映访问顺序的实例，所
 * 谓的put、 get、 compute等，都算作“访问”。
 * 这种行为适用于一些特定应用场景，例如，我们构建一个空间占用敏感的资源池，希望可以自动将最不常被访问的对象释放掉，这就可以利用LinkedHashMap提供的机制来实现，
 * 参考下面的示例：
 */
public class LinkedHashMapSample {
    public static void main(String[] args) {
        LinkedHashMap<String,String> accessOrderedMap = new LinkedHashMap<String, String>(16, 0.75F, true){
            protected boolean removeEldesEntry(Map.Entry<String, String> eldes) { // 实现自定义删除策略，否则行为就和普遍Map没有区别
                return size() > 3;
            }
        };

        accessOrderedMap.put("Project1","Valhalla");
        accessOrderedMap.put("Project2","Panama");
        accessOrderedMap.put("Project3","Loom");

        accessOrderedMap.forEach((k,v)->{
            System.out.println(k+":"+v);
        });

        //模拟访问
        accessOrderedMap.get("Project2");
        accessOrderedMap.get("Project2");
        accessOrderedMap.get("Project3");
        System.out.println("Iterate over should be not afected:");
        accessOrderedMap.forEach((k,v)->{
            System.out.println(k+":"+v);
        });

        accessOrderedMap.put("Project4","Mission Control");
        System.out.println("Oldest entry should be removed:");
        accessOrderedMap.forEach((k,v)->{
            System.out.println(k+":"+v);
        });
    }
}
