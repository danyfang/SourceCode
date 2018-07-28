//Leetcode problem 883 Generate Random Point in a Circle
//Solution written by Xuqiang Fang on 28 July, 2018
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
//http://www.anderswallin.net/2009/05/uniform-random-points-in-a-circle-using-polar-coordinates/
class Solution {
    double radius, x_center, y_center;
    public Solution(double radius, double x_center, double y_center) {
        this.radius=radius;
        this.x_center=x_center;
        this.y_center=y_center;
    }
    
    public double[] randPoint() {
        double len= Math.sqrt(Math.random())*radius;
        double deg= Math.random()*360;
        double x= x_center+len*Math.cos(deg);
        double y= y_center+len*Math.sin(deg);
        return new double[]{x,y};
    }
}

public class RandomPointCircle{
	public static void main(String[] args){
		Solution s = new Solution();
	}
}
