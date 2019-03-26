package com.spring.effective;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author chenjunlin  junlin.chen@msn.cn
 * @date 2019-03-25 14:42
 */
public class WordList {
    public static void main(String[] args) {
        Set<String> s = new TreeSet<String>();
        Collections.addAll(s,args);
        System.out.println(s);
    }
}
