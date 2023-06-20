class Solution {

    public static void main(String[] args) {
        new Solution().solution(2, 4, 2, 1);
    }
    // n -> 진법 (2,4,8,16)
    // t -> 말해야하는 개수
    // m -> 게임 참가 인원
    // p -> 순서
    public String solution(int n, int t, int m, int p) {

        StringBuilder sb = new StringBuilder();

        int idx = 0;
        int talkCount = 1;

        while (sb.length() < t) {
            String value = convert(n, idx);

            for (int i = 0; i < value.length(); i++) {
                if(talkCount++ == p && sb.length() < t) sb.append(value.charAt(i));
                if(talkCount > m) talkCount = 1;
            }

            idx++;

        }
        return sb.toString().toUpperCase();
    }

    private String convert(int radix, int num) {
        String s = Integer.toString(num, radix);
        return s;
    }
}  