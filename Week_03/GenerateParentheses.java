package week03;

import java.util.ArrayList;
import java.util.List;
/**
 * author: Eran-promise
 * question: 括号生成
 * url: https://leetcode-cn.com/problems/generate-parentheses/
 * action:
 * time complexity：O(n)
 */
public class GenerateParentheses {
    private List<String> resList = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if(n < 1) return resList;
        generate(0, 0, n, "");
        return resList;
    }

    private void generate(int left, int right, int max, String str){
        if(left >= max && right >= max){
            resList.add(str);
            return;
        }
        if(left < max) generate(left + 1, right, max, str + "(");
        if(right < left) generate(left, right + 1, max, str +")");
    }
}
