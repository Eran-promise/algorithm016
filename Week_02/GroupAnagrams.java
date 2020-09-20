package week02;

import java.util.*;

/**
 * author: Eran-promise
 * question: 字母异位词分组
 * url: https://leetcode-cn.com/problems/group-anagrams/
 * action:
 *      1.定义一个map Map<String, List<String>>，利用map的key的唯一性来巧妙解决问题
 *      2.遍历数组，将每个元素转成字符数组 str.toCharArray()
 *      3.对所得字符数组进行排序 Arrays.sort()
 *      4.再将排序后的字符数组转为字符串，当做map的key
 *      5.判断map中是否已经存在该key，如果存在则取出value，并将当前遍历的字符串添加到value中
 *                                如果不存在则新建一个集合，并将当前遍历的字符串添加到集合中，再将该集合作为当前key对应的value值存入map中
 *      6.将map的value值处理成需要的格式返回即可
 * time complexity：O（n K log（K）） n:数组的长度  K:字符串的平均长度
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null) return null;
        Map<String, List<String>> box = new HashMap<>();
        for(String str: strs){
            char[] cArr = str.toCharArray();
            Arrays.sort(cArr);
            String key = String.valueOf(cArr);
            if(box.containsKey(key)) box.get(key).add(str);
            else{
                List<String> temp = new ArrayList<>();
                temp.add(str);
                box.put(key, temp);
            }
        }
        return new ArrayList<>(box.values());
    }
}
