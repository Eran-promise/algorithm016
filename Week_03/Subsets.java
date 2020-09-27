package week03;

import java.util.*;

public class Subsets {
    Set<List<Integer>> resSet = new HashSet<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(0, nums, new ArrayList<Integer>());
        List<List<Integer>> res = new ArrayList<>(resSet);
        res.forEach(item->{
            System.out.println(item.toString());
        });
        return res;

    }

    private void backtrack(int i, int[] nums, ArrayList<Integer> tmp) {
        Collections.sort(tmp);
         resSet.add(new ArrayList<>(tmp));
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            backtrack(j + 1, nums, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int[] arr = {4,4,4,1,4};
        subsets.subsets(arr);
    }
}
