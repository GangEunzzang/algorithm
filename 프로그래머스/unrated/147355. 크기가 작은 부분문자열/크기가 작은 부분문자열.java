class Solution {
    public int solution(String t, String p) {
        int count = 0;
        long size = Long.parseLong(p);

        for (int i = 0; i <= t.length() - p.length(); i++) {
            long num = Long.parseLong(t.substring(i, i + p.length()));
            if (num <= size) {
                count++;
            }
        }

        return count;
    }
}