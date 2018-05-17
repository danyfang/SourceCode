//Leetcode problem 535 Encode and Decode TinyURL
//Solution written by Xuqiang Fang on 17 May, 2018
import java.util.HashMap;
import java.util.Map;
class Codec {
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
         map.put(id, longUrl);
         return "http://leetcode/"+id++; 
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int n = Integer.parseInt(shortUrl.replace("http://leetcode/", "")); 
        return map.get(n);
    }
    private Map<Integer, String> map = new HashMap<>();
    private int id = 0;
}
public class TinyUrl{
	public static void main(String[] args){
        Codec s = new Codec();
        String sho = s.encode("https://leetcode.com/problems/design-tinyurl");
        System.out.println(sho);
        System.out.println(s.decode(sho));
	}
}
