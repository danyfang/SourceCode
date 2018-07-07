//Leetcode problem 149 Max Points on a Line
//Solution written by Xuqiang Fang on 4 July, 2018
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;
class Point{
    int x;
    int y;
    Point(){x = 0; y = 0;}
    Point(int a, int b){
        x = a;
        y = b;
    }
}
class Solution{
    public int maxPoints_(Point[] points){
        int n = points.length;
        int ans = 0;
        for(int i=0; i<n; ++i){
            Map<Double, Integer> map = new HashMap<>();
            int same = 1;
            int max = 0;
            Point p1 = points[i];
            for(int j=i+1; j<n; ++j){
                Point p2 = points[j];
                if(p1.x == p2.x && p1.y == p2.y){
                    ++same;
                }
                else{
                    double s = Double.MAX_VALUE;
                    if(p1.x != p2.x){
                        s = (p1.y-p2.y)*1.0 / (p1.x-p2.x);
                    }
                    map.put(s, map.getOrDefault(s, 0)+1);
                    max = Math.max(max, map.get(s));
                }
            }
            ans = Math.max(ans, max+same);
        }
        return ans;
    }
    public int maxPoints(Point[] points){
        int n = points.length;
        int ans = 0;
        for(int i=0; i<n; ++i){
            //here i used a string form of slopes
            Map<String, Integer> map = new HashMap<>();
            int same = 1;
            int max = 0;
            Point p1 = points[i];
            for(int j=i+1; j<n; ++j){
                Point p2 = points[j];
                if(p1.x == p2.x && p1.y == p2.y){
                    ++same;
                }
                else{
                    String s = getSlope(p1, p2);
                    map.put(s, map.getOrDefault(s, 0)+1);
                    max = Math.max(max, map.get(s));
                }
            }
            ans = Math.max(max+same, ans);
        }
        return ans;
    } 
    private String getSlope(Point p1, Point p2){
        int dx = p2.x - p1.x;
        int dy = p2.y - p1.y;
        if(dy == 0){
            return p1.y + ","  + 0;
        }
        if(dx == 0){
            return 0 + "," + p1.x;
        }
        int d = gcd(dx, dy);
        return dy/d + "," + dx/d;
    }
    private int gcd(int m, int n){
        return n == 0 ? m : gcd(n, m%n);
    }
}

public class MaxPoints{
	public static void main(String[] args){
		Solution s = new Solution();
        Point a = new Point(2,3);
        Point b = new Point(1,1);
        Point c = new Point(2,3);
        Point d = new Point(2,3);
        Point e = new Point(2,1);
        Point f = new Point(4,7);
        Point g = new Point(2,3);
        Point h = new Point(4,7);
        Point[] point = {a, b, c, d, e, f, g, h};
        System.out.println(s.maxPoints(point));
        System.out.println(s.maxPoints_(point));
	}
}
