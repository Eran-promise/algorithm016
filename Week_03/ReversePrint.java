package week03;

import java.util.Deque;
import java.util.LinkedList;
/**
 * author: Eran-promise
 * question: 从尾到头打印链表
 * url: https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * action:
 * time complexity：O(n)
 */
public class ReversePrint {
    public int[] reversePrint(ListNode head) {
        if(head == null) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        while(head != null){
            deque.push(head.val);
            head = head.next;
        }
        int[] res = new int[deque.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = deque.pop();
        }
        return res;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}