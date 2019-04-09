package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chenjunlin  junlin.chen@msn.cn
 * @Date 2019-04-08 10:50
 * @Description:  无重复字符的最长子串
 */
public class LengthOfLongest {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                if (allUnique(s, i, j)) ans = Math.max(ans, j - i);
        return ans;
    }

    public boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }
}
