package wang.chenguang.learn.algorithm;

import java.util.HashMap;

/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * 进阶：
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 * <p>
 * 示例 1：
 * 输入：s = "abc", t = "ahbgdc"
 * 输出：true
 */
public class 判断子序列_392 {

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc","ahbgdc"));
    }

    public static boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        if (s.length() == t.length()) {
            return s.equals(t);
        }

        var map = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            if (map.containsKey(t.charAt(i))) {
                continue;
            }
            map.put(t.charAt(i), i);
        }
        var numsArr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            var index = map.get(s.charAt(i));
            if (index == null) {
                return false;
            }
            numsArr[i] = index;
        }

        return isOrderAsc(numsArr);
    }

    private static boolean isOrderAsc(int[] arr) {
        for(int i=0;i < arr.length-1;i++) {
            if(arr[i] > arr[i+1]) {
                return false;
            }
        }
        return true;
    }
}
