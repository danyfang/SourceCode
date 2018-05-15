//Leetcode problem  735 Asteroid Collision
//Solution written by Xuqiang Fang on 15 May, 2018
import java.util.Stack;
class Solution{
    public int[] asteroidCollision(int[] asteroids){
        if(asteroids.length == 0)
            return asteroids;
        Stack<Integer> stack = new Stack<>(); 
        stack.push(asteroids[0]);
        for(int i=1; i<asteroids.length; ++i){
            if(!stack.isEmpty() && stack.peek() > 0 && asteroids[i] < 0){
                while(!stack.isEmpty() && stack.peek() > 0){
                    if(stack.peek()+asteroids[i] == 0){
                        stack.pop();
                        asteroids[i] = 0;
                        break;
                    }
                    else if(stack.peek() + asteroids[i] > 0){
                        asteroids[i] = 0;
                        break;
                    }
                    else{
                        stack.pop();
                    }
                }
                if(asteroids[i] < 0){
                    stack.push(asteroids[i]);
                }
            }
            else{
                stack.push(asteroids[i]);
            }
        }

        int[] res = new int[stack.size()];
        for(int i=res.length-1; i>=0; --i){
            res[i] = stack.pop();
        }
        return res;
    }
}

public class AsteroidCollision{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {-2, -1, 1, 2};
        int[] nums2 = {10,2,-5};
        int[] res = s.asteroidCollision(nums2);
        for(int i : res){
            System.out.print(i + "\t");
        }
        System.out.println("\n");
	}
}
