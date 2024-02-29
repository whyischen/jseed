package wang.chenguang.notes.algorithm;

import java.util.Stack;

/**
 * 32. 最长有效括号
 * </p>
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * <p>
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * <p>
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 */
public class $32_LongestValidParentheses {

    /**
     * 栈底始终记录当前有效括号的起始位置
     */
    public static int longestValidParentheses(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int max = 0;
        var stack = new Stack<Integer>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if ('(' == s.charAt(i)) {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        var s = "))))()";
        System.out.println("length::::::::" + longestValidParentheses(s));
    }

}