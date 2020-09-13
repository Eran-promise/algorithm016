package week01;

/**
 * author: Eran-promise
 * question: 删除排序数组中的重复项
 * url: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * action:
 *      1. 如果数组为null，直接返回0
 *      2. 利用双指针思路解题，定义一个左指针初始化下标为‘0’，一个右指针初始化下标为‘1’
 *      3. 遍历数组，循环结束条件为右指针下标小于数组长度，因为右指针始终走在左指针的前边，先到达临界点。
 *      4. 比较左右指针对应的值，如果不等，则将左指针下一位对应的值替换为右指针当前对应的值，然后左右指针各后移一位，进入下一次循环；
 *                           如果相等，则直接将右指针后移一位，进入下一次循环。
 *      5. 循环结束后左指针的位置正好是新数组的最大下标，题目要求返回新数组的长度，所以返回左指针对应下标加一。
 *      6. 以上解题前提为该数组已经排序，如果原数组未排序，则需要先进行排序。
 * time complexity：O(n)
 */
public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        if(nums == null) return 0;
        int a = 0, b= 1;
        while(b < nums.length){
            if(nums[b] != nums[a]) nums[++a] = nums[b];
            b++;
        }
        return a+1;
    }
}
