package week02;
/**
 * author: Eran-promise
 * question: 各位相加
 * url: https://leetcode-cn.com/problems/add-digits/
 * action: https://leetcode-cn.com/problems/add-digits/solution/java-o1jie-fa-de-ge-ren-li-jie-by-liveforexperienc/
 * time complexity：O(1)
 */
public class AddDigits {
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}
