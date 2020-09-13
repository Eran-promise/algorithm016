package week01;
/**
 * author: Eran-promise
 * question: 移动零
 * url: https://leetcode-cn.com/problems/move-zeroes/
 * action:
 * time complexity：O(n)
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int left = 0, right = 0;
        while(right < nums.length){
            if(nums[right] != 0){
                int temp = nums[left];
                nums[left++] = nums[right];
                nums[right] = temp;
            }
            right++;
        }
    }
}
