package algorithm;

public class $3_lengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabca"));
    }

    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     * 中等
     * 示例 1:
     * <p>
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     * <p>
     * 输入: s = "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     * <p>
     * 输入: s = "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     */
    // 考点：滑动窗口
    // while里边的 for 循环可以改为使用 map 来记录位置
    public static int lengthOfLongestSubstring(String s) {
        int maxLen = 0;

        int left = 0;
        int right = 0;
        while (right < s.length() - 1) {
            right++;
            char rVal = s.charAt(right);
            int temp = left;
            for (; temp < right; temp++) {
                if (s.charAt(temp) == rVal) {
                    left = ++temp;
                    break;
                }
            }

            int curLen = right - left + 1;
            if (curLen > maxLen) {
                maxLen = curLen;
            }
        }

        return maxLen;
    }
}
