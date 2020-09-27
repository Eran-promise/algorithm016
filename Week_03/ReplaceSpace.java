package week03;
/**
 * author: Eran-promise
 * question: 替换空格
 * url: https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 * action:
 * time complexity：O(n) n = s.length()
 */
public class ReplaceSpace {
    public String replaceSpace(String s) {
        if(s == null || s.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char temp = s.charAt(i);
            if(temp == ' ') sb.append("%20");
            else sb.append(temp);
        }
        return sb.toString();
    }
}
