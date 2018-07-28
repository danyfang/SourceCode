//Leetcode problem 355 Design Twitter
//Solution written by Xuqiang Fang on 25 July, 2018 
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
class Twitter {

    /** Initialize your data structure here. */
    public Twitter() {
        user = new HashMap<>();  
        twitter = new HashMap<>();
        twit = new HashMap<>();
        id = 0;
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!twitter.containsKey(userId)){
            twitter.put(userId, new ArrayList<>());
        }
        twitter.get(userId).add(id);
        twit.put(id++, tweetId);
        if(!user.containsKey(userId)){
            user.put(userId, new HashSet<>());
        }
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. 
    Each item in the news feed must be posted by users who the user followed or by the user herself.
    Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<>();
        if(twitter.containsKey(userId)){
            ans.addAll(twitter.get(userId));
        }
        if(user.containsKey(userId)){
            for(int i : user.get(userId)){
                if(twitter.containsKey(i)){
                    ans.addAll(twitter.get(i));
                }
            }
        }
        ans.sort((a,b)->(b-a));
        List<Integer> ret = new ArrayList<>();
        for(int i : ans){
            if(!ret.contains(twit.get(i))){
                ret.add(twit.get(i));
            }
            if(ret.size() == 10){
                break;
            }
        }
        return ret;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!user.containsKey(followerId)){
            user.put(followerId, new HashSet<>());
        } 
        user.get(followerId).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(user.containsKey(followerId)){
            user.get(followerId).remove(followeeId); 
        }
    }

    Map<Integer, Set<Integer>> user;
    Map<Integer, List<Integer>> twitter; 
    Map<Integer, Integer> twit;
    int id;
}
public class DesignTwitter{
	public static void main(String[] args){
        Twitter twitter = new Twitter();
        // User 1 posts a new tweet (id = 5).
        twitter.postTweet(1, 5);

        // User 1's news feed should return a list with 1 tweet id -> [5].
        twitter.getNewsFeed(1);

        // User 1 follows user 2.
        twitter.follow(1, 2);

        // User 2 posts a new tweet (id = 6).
        twitter.postTweet(2, 6);

        // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
        // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        twitter.getNewsFeed(1);

        // User 1 unfollows user 2.
        twitter.unfollow(1, 2);

        // User 1's news feed should return a list with 1 tweet id -> [5],
        // since user 1 is no longer following user 2.
        twitter.getNewsFeed(1);
	}
}
