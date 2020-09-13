package week01;
/**
 * author: Eran-promise
 * question: 爬楼梯
 * url: https://leetcode-cn.com/problems/climbing-stairs/
 * action:
 * time complexity：
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        if(n < 3) return n;
        int a = 1, b = 2, sum = 0;
        while(n-- > 2){
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }
}
