package week02;

import java.util.Arrays;

/**
 * author: Eran-promise
 * question: 有效的字母异位词
 * url: https://leetcode-cn.com/problems/valid-anagram/
 * action:
 *      思路一
 *      1.将两个字符串都转为字符数组
 *      2.对两个字符数组进行排序
 *      3.直接比较这两个字符数组是否相等
 *      思路二
 *      因为一共只有26个英文字符，所以可以初始化一个长度为26的数组，下标用字符-‘a’来表示，数组的值用来计数，
 *      两个字符串的字符，一个用来加，一个用来减，最后遍历数组，如果有不为零的值，则返回false，否则返回true
 * time complexity：O(NlogN)
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null) return false;
        if(s.length() != t.length()) return false;
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        return Arrays.equals(sArr, tArr);
    }
}
