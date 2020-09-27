package week03;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
/**
 * author: Eran-promise
 * question: 组合
 * url: https://leetcode-cn.com/problems/combinations/
 * action: https://leetcode-cn.com/problems/combinations/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-ma-/
 * time complexity：O(n)
 */
public class Combinations {
    List<List<Integer>> resList = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if(n < 1 || k < 1) return resList;
        Deque<Integer> box = new ArrayDeque<>();
        combine(n, k, 1, box);
        return resList;
    }

    private void combine(int n, int k, int start, Deque<Integer> box){
        if(box.size() == k){
            resList.add(new ArrayList<Integer>(box));
            return;
        }
        for(int i = start; i <= n - (k - box.size()) + 1; i++){
            box.push(i);
            combine(n, k, i+1, box);
            box.pop();
        }
    }
}
