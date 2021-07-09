package com.whyischen.jseed.algorithm.weeklyselection;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 示例 3：
 * <p>
 * 输入：s = "A", numRows = 1
 * 输出："A"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ZigzagConversion {

    public static String convert(String s, int numRows) {
        int tail = numRows - 2;

        int unitLength = numRows + tail;

        List<List<Character>> longList = new ArrayList<>(unitLength);
        List<List<Character>> tailList = new ArrayList<>(unitLength);

        List<Character> curLong = new ArrayList<>(numRows);
        List<Character> curTail = new ArrayList<>(tail);
        for (int i = 0; i < s.length(); i++) {

            int loc = i % unitLength;

            if (loc < numRows) {
                curLong.add(s.charAt(i));
                if (curLong.size() >= numRows) {
                    longList.add(curLong);
                    curLong = new ArrayList<>(numRows);
                }
            } else {
                curTail.add(s.charAt(i));
                if (curTail.size() >= tail) {
                    tailList.add(curTail);
                    curTail = new ArrayList<>(tail);
                }
            }

            if (i == s.length() - 1) {
                if (!curLong.isEmpty() && curLong.size() < numRows) {
                    longList.add(curLong);
                }
                if (!curTail.isEmpty() && curTail.size() < tail) {
                    tailList.add(curTail);
                }
            }
        }

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < longList.size(); j++) {
                curLong = longList.get(j);
                builder.append(curLong.get(j));

                if (i == 0 || i == numRows - 1) {
                    if (tailList.size() - 1 >=  j) {
                        int index = 0;


                        curTail = tailList.get(j);
                        builder.append(curTail.get(index));
                    }
                }
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        System.out.println("PAHNAPLSIIGYIR".equals(convert(s, 3)));
    }

}
