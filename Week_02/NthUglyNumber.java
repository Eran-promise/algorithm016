package week02;
/**
 * author: Eran-promise
 * question: 丑数
 * url: https://leetcode-cn.com/problems/chou-shu-lcof/
 * action: https://leetcode-cn.com/problems/chou-shu-lcof/solution/xiang-xi-jie-da-chao-jian-dan-bu-dong-zhao-wo-by-y/
 * time complexity：O(n)
 */
public class NthUglyNumber {
    public int nthUglyNumber(int n) {
        int po2 = 0, po3 = 0, po5 = 0;
        int[] res = new int[n];
        res[0] = 1;
        for(int i = 1; i < n; i++){
            res[i] = Math.min(res[po2] * 2, Math.min(res[po3] * 3, res[po5] * 5));
            if(res[i] == res[po2] * 2) po2++;
            if(res[i] == res[po3] * 3) po3++;
            if(res[i] == res[po5] * 5) po5++;
        }
        return res[n - 1];
    }
}
