package com.whyischen.algorithm;

import java.util.Arrays;
import java.util.Comparator;

public class EraseOverlapIntervals {

    /**
     * 435. 无重叠区间
     * <p>
     * 给定一个区间的集合 intervals，其中 intervals[i] = [starti, endi]。返回 需要移除区间的最小数量，使剩余区间互不重叠。
     * <p>
     * 输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
     * 输出: 1
     * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
     * <p>
     * 输入: intervals = [ [1,2], [2,3] ]
     * 输出: 0
     * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        return intervals.length - intervalSchedule(intervals);
    }

    /**
     * 无重叠区间个数
     *
     * @param intvs 区间集合
     * @return 无重叠区间个数
     */
    public int intervalSchedule(int[][] intvs) {
        if (intvs.length == 0) return 0;
        // 按照 end 排序
        Arrays.sort(intvs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int count = 1;
        var minEnd = intvs[0][1];
        for (int i = 0; i < intvs.length; i++) {
            var item = intvs[i];

            if (item[0] >= minEnd) {
                count++;
                minEnd = item[1];
            }
        }
        return count;
    }

}
