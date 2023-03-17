import java.util.*;


class Solution {
    public long solution(long n) {
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();

        Arrays.sort(chars);
        
        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
            sb.append(aChar);
        }

        StringBuilder reverse = sb.reverse();
        return  Long.parseLong(reverse.toString());
        
    }
}