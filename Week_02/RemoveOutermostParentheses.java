package week02;
/**
 * author: Eran-promise
 * question: 删除最外层的括号
 * url: https://leetcode-cn.com/problems/remove-outermost-parentheses/
 * action:
 * time complexity：O(n)
 */
public class RemoveOutermostParentheses {
    public String removeOuterParentheses(String S) {
        if(S == null) return "";
        char[] arr = S.toCharArray();
        int count = 0;
        StringBuffer res = new StringBuffer();
        for(char temp: arr){
            if(')' == temp) --count;
            if(count > 0) res.append(temp);
            if('(' == temp) count++;
        }
        return res.toString();
    }
}
