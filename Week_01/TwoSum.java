package week01;

import java.util.HashMap;
import java.util.Map;

/**
 * author: Eran-promise
 * question: 两数之和
 * url:https://leetcode-cn.com/problems/two-sum/
 * action:
 *      1.数组为空或者数组长度小于2的数组不满足题目基本条件，直接返回null
 *      2.借助map特性来巧妙的解题，将数组某个元素的值当做map的key,该值对应的下标作为map的value
 *      3.从下标0开始遍历数组，判断 map中是否已经存在值为 ‘target-nums[i]’ 的key，如果存在则说明当前数组下标对应的值与map中保存的值满足解题条件，直接返回即可；
 *                                                                        如果不存在，则将当前值与下标存入map中。
 *      4.如果循环正常结束，则表明没有符合条件的答案，返回null即可
 * time complexity：O(n)
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length < 2) return null;
        Map<Integer, Integer> box = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(box.containsKey(target - nums[i])) return new int[]{box.get(target - nums[i]), i};
            box.put(nums[i], i);
        }
        return null;
    }
}
