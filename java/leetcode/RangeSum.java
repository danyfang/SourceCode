//Leetcode problem 303 Range Sum Query - Immutable
//Leetcode problem 304 Range Sum Query 2D - Immutable
//Leetcode problem 307 Range Sum Query - Mutable
//Solution written by Xuqiang Fang on 18 April, 2018 
/*
class NumArray{
    private int[] sum = null;
    public NumArray(int[] nums) {
        if(nums != null && nums.length > 0){ 
            sum = new int[nums.length+1];
            sum[0] = 0;
            for(int i=1; i<=nums.length; i++){
                sum[i] = sum[i-1] + nums[i-1];
            }
        }
    }
    
    public int sumRange(int i, int j) {
        return sum[j+1] - sum[i]; 
    }	
}
*/


//No 304 
class NumMatrix{
    private int[][] sum = null;
    public NumMatrix(int[][] matrix){
        if(matrix != null && matrix.length > 0 && matrix[0].length > 0){
            int row = matrix.length;
            int col = matrix[0].length;
            sum = new int[row][col];
            sum[0][0] = matrix[0][0];
            for(int i=1; i<row; i++)
                sum[i][0] = sum[i-1][0] + matrix[i][0];
            for(int i=1; i<col; i++)
                sum[0][i] = sum[0][i-1] + matrix[0][i];

            for(int i=1; i<row; ++i){
                for(int j=1; j<col; ++j){
                    sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + matrix[i][j];
                }
            }
            
            /*
            *debug info
            for(int i=0; i<row; ++i){
                for(int j=0; j<col; ++j)
                    System.out.print(sum[i][j] + "\t");
                System.out.println("\n");
            }
            */
        } 
    }

    public int sumRegion(int row1, int col1, int row2, int col2){
        if(row1 == 0){
            if(col1 == 0)
                return sum[row2][col2];
            else
                return sum[row2][col2] - sum[row2][col1-1];
        } 
        if(col1 == 0){
            if(row1 == 0)
                return sum[row2][col2];
            else
                return sum[row2][col2] - sum[row1-1][col2];
        }

        return sum[row2][col2] - sum[row1-1][col2] - sum[row2][col1-1] + sum[row1-1][col1-1];
    }
}
//No. 307 this solution exceeded time limit
class NumArray_{
    private int[] sum = null;
    private int[] update = null;
    private int[] original = null;
    public NumArray_(int[] nums) {
        if(nums != null && nums.length > 0){ 
            original = nums;
            sum = new int[nums.length+1];
            update = new int[nums.length];
            sum[0] = 0;
            for(int i=1; i<=nums.length; i++){
                sum[i] = sum[i-1] + nums[i-1];
            }
        }
    }
    public void update(int i, int val){
        update[i] = original[i] - val;
    } 
    public int sumRange(int i, int j) {
        int decrease = 0;
        for(int x=i; x<=j; x++){
            decrease += update[x];
        }
        return sum[j+1] - sum[i] - decrease; 
    }	
}
//No 307 solution taken reference from user@2guotou
class NumArray{
    class SegmentTreeNode{
        int start, end;
        SegmentTreeNode left, right;
        int sum;
        public SegmentTreeNode(int start, int end){
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.sum = 0;
        }
    }

    SegmentTreeNode root = null;

    public NumArray(int[] nums){
        root = buildTree(nums, 0, nums.length-1);
    }

    private SegmentTreeNode buildTree(int[] nums, int start, int end){
        if(start > end)
            return null;
        else{
            SegmentTreeNode ret = new SegmentTreeNode(start, end);
            if(start == end)
                ret.sum = nums[start];
            else{
                int mid = start + (end - start) / 2;
                ret.left = buildTree(nums, start, mid);
                ret.right = buildTree(nums, mid+1, end);
                ret.sum = ret.left.sum + ret.right.sum;
            }
            return ret;
        }
    }
    
    void update(int i, int val){
        update(root, i, val);
    }

    void update(SegmentTreeNode root, int pos, int val){
        if(root.start == root.end)
            root.sum = val;
        else{
            int mid = root.start + (root.end - root.start) / 2;
            if(pos <= mid){
                update(root.left, pos, val);
            }
            else{
                update(root.right, pos, val);
            }
            root.sum = root.left.sum + root.right.sum;
        }
    }

    public int sumRange(int i, int j){
        return sumRange(root, i, j);
    }

    public int sumRange(SegmentTreeNode root, int start, int end){
        if(root.end == end && root.start == start){
            return root.sum;
        }
        else{
            int mid = root.start + (root.end - root.start) / 2;
            if(end <= mid)
                return sumRange(root.left, start, end);
            else if(start >= mid + 1)
                return sumRange(root.right, start, end);
            else
                return sumRange(root.right, mid+1, end) + sumRange(root.left, start, mid);
        }
    }
}

public class RangeSum{
	public static void main(String[] args){

        /*
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray obj = new NumArray(nums);
        obj.update(0,1);
        System.out.println(obj.sumRange(Integer.valueOf(args[0]), Integer.valueOf(args[1])));
        */
        int[][] matrix = {{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
        NumMatrix obj = new NumMatrix(matrix);
        System.out.println(obj.sumRegion(Integer.valueOf(args[0]),Integer.valueOf(args[1]),Integer.valueOf(args[2]),Integer.valueOf(args[3])));
	}
}
