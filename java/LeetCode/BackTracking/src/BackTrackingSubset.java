import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class ThreeSum{
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0,0);
        return list;
    }
    private void backtrack(List<List<Integer>> list, List<Integer> templist, int[] nums, int remain, int start){
        //todo;
        if(remain == 0 && templist.size() == 3 && !list.contains(templist)){
            list.add(new ArrayList<>(templist));
        }
        for(int i=start; i<nums.length; i++){
            if(templist.size() > 2){
                break;
            }
            templist.add(nums[i]);
            backtrack(list,templist,nums,remain-nums[i],i+1);
            templist.remove(templist.size()-1);
        }
    }
}

public class BackTrackingSubset {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args){
        BackTrackingSubset s = new BackTrackingSubset();
        int[] nums = {1,2,3};
        System.out.println(s.subsets(nums));

        int[] sum2 = {-1, 0, 1, 2, -1, -4};
        ThreeSum three = new ThreeSum();
        System.out.println(three.threeSum(sum2));

    }
}
