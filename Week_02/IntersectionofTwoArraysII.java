package week02;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/**
 * author: Eran-promise
 * question: 两个数组的交集 II
 * url: https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 * action:
 *      分析：因为同一个数字在两个数组中都可能出现多次，所以可以用map来记录每一个数字出现的次数，对于某一个数字来说，
 *          他在交集中出现的次数就等于他在两个数组中出现次数的最小值
 *      步骤:
 *          1.首先定义一个 map,以及一个交集数组 int[]，数组的长度为两个数组长度的较小值，交集数组的下标 index
 *          2.遍历长度较小的数组，将每个数出现的次数添加进map中
 *          2.遍历长度较大的数组，如果当前数字在map中不存在，则直接跳过进入下一次循环
 *                             如果存在，判断当前数字出现的次数是否大于0，如果大于0，则将当前数字添加到交集数组中，index++，并且更新map中的值，将该数字出现的次数减一
 *                                                                 否则进入下一次循环。
 *
 * time complexity：O(m+n) m,n分别为两个数组的长度
 */
public class IntersectionofTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null  || nums2 == null) return null;
        if(nums1.length > nums2.length) return intersect(nums2, nums1);
        Map<Integer, Integer> box = new HashMap<>();
        int res[] = new int[nums1.length];
        int index = 0;
        for(int num: nums1) {
            box.put(num, box.getOrDefault(num, 0) + 1);
        }
        for(int num: nums2){
            if(!box.containsKey(num)) continue;
            int temp = box.get(num);
            if(temp > 0){
                res[index++] = num;
                box.put(num, temp -1 > 0?temp-1:0);
            }
        }
        return Arrays.copyOfRange(res, 0, index);
    }
}
