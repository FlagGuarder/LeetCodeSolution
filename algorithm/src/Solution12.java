import java.util.HashMap;
import java.util.Map;

public class Solution12 {
    /*罗马数字转整数*/
    public static int romanToInt(String s) {
        int ans = 0;
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1); map.put('V',5);
        map.put('X',10); map.put('L',50);
        map.put('C',100); map.put('D',500);
        map.put('M',1000);
        if (null == s || s.length()==0)
            return -1;
        for (int i = 0 ; i< s.length(); i++){
            if (i + 1 < s.length() && map.get(s.charAt(i)) < map.get(s.charAt(i+1)))
            {  ans += map.get(s.charAt(i+1)) - map.get(s.charAt(i)); i++;}
                
            else 
                ans += map.get(s.charAt(i));
        }
        
        return ans;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        trie.search("apple");
        System.out.println(trie.startWith("app"));   // 返回 true
        trie.search("app");     // 返回 false
         // 返回 true
        trie.insert("app");
        trie.search("app");     // 返回 true


    }
}
