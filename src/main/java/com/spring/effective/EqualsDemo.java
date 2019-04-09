package com.spring.effective;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author chenjunlin  junlin.chen@msn.cn
 * @date 2019-03-27 09:07
 */
public class EqualsDemo {

    private String name;
    private String info;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EqualsDemo that = (EqualsDemo) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return info != null ? info.equals(that.info) : that.info == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (info != null ? info.hashCode() : 0);
        return result;
    }

    @Test
    public void TestConcurrentHashMap(){
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("id","1");
        concurrentHashMap.put("name","andy");
        concurrentHashMap.put("sex","男");


        String name = concurrentHashMap.get("name");
        Assert.assertEquals(name,"andy");

        int size = concurrentHashMap.size();
        Assert.assertEquals(size,3);
        System.out.println(size);
    }
}
