package week02;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
/**
 * author: Eran-promise
 * question: 前 K 个高频元素
 * url: https://leetcode-cn.com/problems/top-k-frequent-elements/
 * action:
 * time complexity：O(NlogK)
 */
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums == null || nums.length <= 0) return new int[0];
        Map<Integer, Integer> box = new HashMap<>();
        for(int num: nums){
            box.put(num, box.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> que = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
        for(Map.Entry<Integer, Integer> temp : box.entrySet()){
            que.add(temp);
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = que.poll().getKey();
        }
        return res;
    }
}
