class Solution {
    public int[] solution(String s) {

        int zeroCount = 0;
        int count = 0;

        while (!s.equals("1")) {
            String replaceOfS = s.replace("0", "");
            zeroCount += s.length() - replaceOfS.length();
            count++;
            
            s = Integer.toBinaryString(replaceOfS.length());
        }
        
        return new int[]{count, zeroCount};
    }
}