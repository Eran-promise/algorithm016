package week02;

import java.util.PriorityQueue;
/**
 * author: Eran-promise
 * question: 最小的k个数
 * url: https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 * action:
 * time complexity：O(NlogK)
 */
public class GetLeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> box = new PriorityQueue<>();
        for(int num: arr){
            box.add(num);
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = box.poll();
        }
        return res;
    }
}
