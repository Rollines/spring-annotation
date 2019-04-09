package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenjunlin  junlin.chen@msn.cn
 * @date 2019-04-08 10:42
 *
 * 迭代的时候将元素插入到表中的同时，
 * 检查哈斯表中是否已经存在当前元素对应的目标元素，也就是target - x，如果它存在，那我们已经找到了对应解，并立即将其返回。
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] {
                        map.get(complement), i
                };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = { 2, 7, 11, 15 };
        int b = 9;
        solution.twoSum(a,b);
    }


}
