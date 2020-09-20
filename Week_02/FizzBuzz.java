package week02;

import java.util.ArrayList;
import java.util.List;
/**
 * author: Eran-promise
 * question: Fizz Buzz
 * url: https://leetcode-cn.com/problems/fizz-buzz/
 * action:
 * time complexity：O(n)
 */
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            if(i % 3 == 0 && i % 5 == 0) res.add("FizzBuzz");
            else if(i % 3 == 0) res.add("Fizz");
            else if(i % 5 == 0) res.add("Buzz");
            else res.add(i+"");
        }
        return res;
    }
}
