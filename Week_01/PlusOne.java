package week01;
/**
 * author: Eran-promise
 * question: 加一
 * url: https://leetcode-cn.com/problems/plus-one/
 * action:
 * time complexity：O(n)
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        if(digits == null) return null;
        int car = 1;
        for(int i = digits.length - 1; i >= 0; i--){
            int temp = digits[i] + car;
            digits[i] = temp % 10;
            car = temp / 10;
        }
        if(car == 1){
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }
        return digits;
    }
}
