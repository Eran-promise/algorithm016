package week02;
/**
 * author: Eran-promise
 * question: 滑动窗口的最大值
 * url: https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 * action:
 * time complexity：
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) return new int[0];
        int[] res = new int[nums.length - k + 1];
        for(int i = 0; i <=  nums.length - k; i++){
            int count = k - 1, start = i;
            int max = nums[i];
            while(count-- > 0){
                max = Math.max(max, nums[++start]);
            }
            res[i] = max;
        }
        return res;
    }
}
