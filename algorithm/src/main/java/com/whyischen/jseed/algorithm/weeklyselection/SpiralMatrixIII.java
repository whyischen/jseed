package com.whyischen.jseed.algorithm.weeklyselection;

import java.util.Arrays;

/**
 * leetcode 885. 螺旋矩阵 III
 * <p>
 * 在R行C列的矩阵上，我们从(r0, c0)面朝东面开始
 * <p>
 * 这里，网格的西北角位于第一行第一列，网格的东南角位于最后一行最后一列。
 * <p>
 * 现在，我们以顺时针按螺旋状行走，访问此网格中的每个位置。
 * <p>
 * 每当我们移动到网格的边界之外时，我们会继续在网格之外行走（但稍后可能会返回到网格边界）。
 * <p>
 * 最终，我们到过网格的所有R * C个空间。
 * <p>
 * 按照访问顺序返回表示网格位置的坐标列表。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SpiralMatrixIII {

    // 官方答案
    public static int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int[] dr = new int[]{0, 1, 0, -1};
        int[] dc = new int[]{1, 0, -1, 0};

        int[][] ans = new int[R*C][2];
        int t = 0;

        ans[t++] = new int[]{r0, c0};
        if (R * C == 1) return ans;

        for (int k = 1; k < 2*(R+C); k += 2)
            for (int i = 0; i < 4; ++i) {  // i: direction index
                int dk = k + (i / 2);  // number of steps in this direction
                for (int j = 0; j < dk; ++j) {  // for each step in this direction...
                    // step in the i-th direction
                    r0 += dr[i];
                    c0 += dc[i];
                    if (0 <= r0 && r0 < R && 0 <= c0 && c0 < C) {
                        ans[t++] = new int[]{r0, c0};
                        if (t == R * C) return ans;
                    }
                }
            }

        throw null;
    }

    public static int[][] spiralMatrixIII2(int R, int C, int r, int c) {
        // 方向: 0-➡️,1-⬇️,2-⬅️,3-⬆️
        int direction = 0;
        // r,c 关于direction的变化量
        var dr = new int[]{0, 1, 0, -1};
        var dc = new int[]{1, 0, -1, 0};

        // 步长
        int stepLength = 1;

        var res = new int[R * C][2];
        res[0] = new int[]{r, c};

        int size = 1;
        while (size < R * C) {
            for (int i = 0; i < stepLength; i++) {
                r += dr[direction];
                c += dc[direction];
                // 当前坐标合法
                if (r >= 0 && r < R && c >= 0 && c < C ) {
                    res[size] = new int[]{r, c};
                    size++;
                }
            }
            // 改变步长
            stepLength += direction % 2;
            // 改变方向
            direction = ++direction % 4;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(spiralMatrixIII2(1, 4, 0, 0)));
    }
}
