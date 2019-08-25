import java.util.HashMap;
import java.util.Map;

public class No3_lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        Map<Character,Integer> stringIndex = new HashMap<>();
        int leftIndex = 0;
        for(int i = 0 ;i < s.length(); i ++)
        {
            while(stringIndex.containsKey(s.charAt(i)))
            {
                stringIndex.remove(s.charAt(leftIndex));
                leftIndex ++;
            }
            res = (i - leftIndex) > res? (i - leftIndex):res;
            stringIndex.put(s.charAt(i),i);
        }
        return res;
    }
}
