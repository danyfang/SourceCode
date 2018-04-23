//Leetcode problem 401 Binary Watch 
//Solution written by Xuqiang Fang on 21 April, 2018 
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

class Solution{
    public List<String> readBinaryWatch(int num){
        List<String>[] hour  = new ArrayList[4];
        List<String>[] minute = new ArrayList[6];
        List<String> ret = new ArrayList<>();
        
        for(int i=0; i<4; ++i)
            hour[i] = new ArrayList<>();
        for(int i=0; i<6; ++i){
            minute[i] = new ArrayList<>();
        }
        
        for(int i=0; i<12; ++i){
            hour[Integer.bitCount(i)].add(String.valueOf(i));
            //System.out.println(Integer.bitCount(i));
        }
        for(int i=0; i<60; ++i){
            if(i < 10)
                minute[Integer.bitCount(i)].add("0"+String.valueOf(i));
            else
                minute[Integer.bitCount(i)].add(String.valueOf(i));
            //System.out.println(Integer.bitCount(i));
        }
        /*
        System.out.println(hour[0]);
        System.out.println(hour[1]);
        System.out.println(hour[2]);
        System.out.println(hour[3]);
        System.out.println(minute[0]);
        System.out.println(minute[1]);
        System.out.println(minute[2]);
        System.out.println(minute[3]);
        System.out.println(minute[4]);
        System.out.println(minute[5]);
        */
        for(int i=0; i<4 ; ++i){
            for(int j=0; j<6; ++j){
                if(i + j == num){
                    for(String h : hour[i]){
                        for(String m : minute[j]){
                            ret.add(h + ":" + m);
                        }
                    }
                }
            }
        }
        //System.out.println(ret);
        System.out.println(ret.size());
        return ret;



    }	

    /*
    public List<String> select(int n, Set<String> set, int hm){
        List<String> list = new ArrayList<>();
        if(n == 1){
            for(String s : set){
                list.add(s);
            }
            return list;
        } 
        Set<String> clone = new HashSet<>();
        clone.addAll(set);
        for(String s : clone){
            set.addAll(clone);
            set.remove(s);
            System.out.println("n - 1 = "+ (n-1) + " set.size() = " + set.size());
            List<String> temp = select(n-1,set,hm);
            for(String st : temp){
                int value = Integer.valueOf(st) + Integer.valueOf(s); 
                if(value < hm){
                    String str = String.valueOf(value);
                    if(value < 10 && hm == 60)
                        str = "0" + str;
                    if(!list.contains(str))
                        list.add(str);
                }
            }
        }
        return list;
    }
    */
}

public class BinaryWatch{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.readBinaryWatch(Integer.valueOf(args[0])));
        //s.readBinaryWatch(Integer.valueOf(args[0]));
        int count = 0;
        System.out.println(Integer.bitCount(31));
        System.out.println(Integer.bitCount(47));
        for(int i=0; i<10; ++i){
            count += s.readBinaryWatch(Integer.valueOf(i)).size();
        }
        System.out.println(count);
	}
}
