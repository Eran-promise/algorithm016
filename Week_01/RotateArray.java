package week01;

/**
 * author: Eran-promise
 * question: 旋转数组
 * url: https://leetcode-cn.com/problems/rotate-array/
 * action:
 *      思路：直接将每个数字一次性放到最终移动之后的位置，然后再将移动后位置原来的元素放到他移动之后应该的的位置，重复该过程n（数组的长度）次,得到移动后的数组。
 *      注意： 1.这种思路会存在两种情况 1. n % k == 0 时 会发现在没有遍历完所有的数组元素的情况下，记录数字的指针会回到首次操作的下标位置，此时，我们应该从该
 *                                    下标的下一个位置继续重复移动数组的过程，直到总移动次数等于n(数组的长度)为止。
 *                                 2. n % k != 0 时 没有特殊情况，一气呵成成n次移动。
 *            2.当 k > n(数组长度) 时，实际上移动的次数为 k = k % n;
 * time complexity：O(n)
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for(int i = 0; count < nums.length; i++){
            int start = i;
            int temp = nums[i];
            do {
                int next = (k + start) % nums.length;
                int nextValue = nums[next];
                nums[next] = temp;
                temp = nextValue;
                start = next;
                count++;
            }while (start != i);
        }
    }
}
