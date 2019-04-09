package leetcode;

import java.util.Scanner;

/**
 * @author chenjunlin  junlin.chen@msn.cn
 * @Date 2019-04-08 11:06
 * @Description: 最长回文子串
 */
public class LeetCoder5 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // 从键盘读入字符串
        String str = null;
        Scanner reader = new Scanner(System.in);
        str = reader.nextLine();
        System.out.println(getLongestPalindrome(str));
    }

    /**
     * 此方法返回s的最长回文串
     *
     * @param str
     * @return
     */
    private static String getLongestPalindrome(String str) {

        boolean dp[][];
        // 如果字符串的长度为0，则认为str的最长回文串为空字符串
        if (str.length() == 0) {
            return "";
        }
        // 字符串str长度为1.则字符串本身就是一个最长回文串
        if (str.length() == 1) {
            return str;
        }
        // dp[i][j],表示字符串str从str[i]到str[j]的子串为最长回文子串
        dp = new boolean[str.length()][str.length()];
        // 记录已经找到的最长回文子串的长度
        int maxLen = 1;
        // 记录最长回文子串的起点位置和终点位置
        int start = 0, end = 0;
        // 动态规划的进行是按照字符串的长度从1 到 n推进的，k表示正在判断的子串的长度
        // 用于和已知的子串的长度maxLen进行比较
        int k;
        // 找出str的所有子串的dp对应的boolean值,初始化过程
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < str.length(); j++) {
                // 当i==j的时候，只有一个字符的字符串
                // 当i>j的时候认为是空串，dp[i][j]
                if (i >= j) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = false;
                }
            }
        }

        // 我在这里犯了一个幼稚的错误，把i、j的定义放在了for循环中，在else{}中是访问不到的
        // 运行程序报java.lang.StringIndexOutOfBoundsException: String index out of
        // range错误
        int i, j;
        for (k = 1; k < str.length(); k++) {
            for (i = 0; i + k < str.length(); i++) {

                j = i + k;
                if (str.charAt(i) != str.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    dp[i][j] = dp[i + 1][j - 1];
                    if (dp[i][j]) {
                        // 判断找到的子串的长度是否大于我们已知的最长子串的长度
                        if (k + 1 > maxLen) {
                            // 记录最长回文子串
                            maxLen = k + 1;
                            // 记录子串的起始位置，因为后面的函数subString(int beginIndex,int
                            // endIndex)函数要用到
                            start = i;
                            end = j;
                        }
                    }
                }
            }
        }
        return str.substring(start, end + 1);
    }
}
