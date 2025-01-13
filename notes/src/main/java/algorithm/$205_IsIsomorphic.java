package algorithm;

import java.util.HashMap;

/**
 * 205. 同构字符串
 * 给定两个字符串 s 和 t ，判断它们是否是同构的。
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 * <p>
 * 示例 1:
 * 输入：s = "egg", t = "add"
 * 输出：true
 */
public class $205_IsIsomorphic {

    public static void main(String[] args) {
        System.out.println(isIsomorphic("abcdefghijklmnopqrstuvwxyzva", "abcdefghijklmnopqrstuvwxyzck"));
    }

    public static boolean isIsomorphic(String s, String t) {
        var s1 = getHashStr(s);
        var t1 = getHashStr(t);

        return s1.equals(t1);
    }

    public static String getHashStr(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        int index = 65;
        var map = new HashMap<String, String>();
        for (int i = 0; i < str.length(); i++) {
            var key = str.substring(i, i + 1);
            var value = map.get(key);
            if (value != null) {
                res.append(value);
            } else {
                // 提取字符串特征
                value = (char)index + "";
                map.put(key, value);
                index++;
                res.append(value);
            }
        }
        return res.toString();
    }


}
