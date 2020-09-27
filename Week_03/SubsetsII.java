package week03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    List<List<Integer>> resList = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums == null || nums.length == 0) return resList;
        Arrays.sort(nums);
        subsetsWithDup(nums, 0, new ArrayList<>());
        return resList;
    }
    private void subsetsWithDup(int[] nums, int start, List<Integer> list){
        resList.add(new ArrayList<>(list));
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i - 1] == nums[i]) continue;
            list.add(nums[i]);
            subsetsWithDup(nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
