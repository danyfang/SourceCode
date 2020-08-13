import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Liss {
    public class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public int getDecimalValue(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        int ans = 0;
        for(int i=0; i<list.size(); ++i){
            ans += list.get(list.size()-1-i)*Math.pow(2, i);
        }
        return ans;
    }

    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<n; ++i){
            set.add(arr[i]);
        }
        for(int x : set){
            if((rightIndex(arr, x) - leftIndex(arr, x))*4 >= n){
                return x;
            }
        }
        return -1;
    }
    public int leftIndex(int[] nums, int x){
        int n = nums.length;
        int l = 0, r = n;
        while(l < r){
            int m = l + (r-l)/2;
            if(nums[m] >= x){
                r = m;
            } else {
                l = m+1;
            }
        }
        return l;
    }
    public int rightIndex(int[] nums, int x){
        int n = nums.length;
        int l = 0, r = n;
        while(l < r){
            int m = l + (r-l)/2;
            if(nums[m] <= x){
                l = m+1;
            } else {
                r = m;
            }
        }
        return l;
    }
}
