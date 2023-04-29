package wang.chenguang.learn.algorithm;

/**
 * 392. 判断子序列
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * 进阶：
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 * <p>
 * 示例 1：
 * 输入：s = "abc", t = "ahbgdc"
 * 输出：true
 */
public class IsSubsequence_392 {

    public static void main(String[] args) {
        System.out.println(isSubsequence("abbc", "ahbgbdc"));
    }

    /**
     * 判断 s 是否为 t 的子序列
     */
    public static boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        // 解题思路：双指针
        var indexS = 0;
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == s.charAt(indexS)) {
                indexS++;
            }
            // 找到子序列
            if (indexS >= s.length()) {
                return true;
            }
        }
        return false;
    }
}
