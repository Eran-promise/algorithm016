package week03;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    List<List<Integer>> resList = new ArrayList<>();
    boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0) return resList;
        used = new boolean[nums.length];
        permute(nums, new ArrayList<>());
        return resList;
    }

    private void permute(int[] nums, List<Integer> list){
        if(list.size() == nums.length){
            resList.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(!used[i]){
                list.add(nums[i]);
                used[i] = true;
                permute(nums, list);
                used[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
