package com.spring.effective;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author chenjunlin  junlin.chen@msn.cn
 * @date 2019-03-25 16:05
 *
 * 优先考虑泛型
 */
public class Generic {
    private static <E> Set<E> union(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<E>(s1);
        result.addAll(s2);
        return result;
    }
    public static void main(String[] args) {
        Set<String> guys = new HashSet<>(Arrays.asList("Tom","Dick","Harry"));
        Set<String> stooges = new HashSet<>(Arrays.asList("Larry","Moe","Curly"));
        Set<String> aflCio = union(guys,stooges);
        System.out.println(aflCio);


    }


}
