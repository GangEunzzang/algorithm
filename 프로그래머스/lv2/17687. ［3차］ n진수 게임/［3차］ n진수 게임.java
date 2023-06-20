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
        return sb.toString();
    }

    private String convert(int radix, int num) {

        switch (radix) {
            case 2 : return Integer.toString(num, 2);
            case 3 : return Integer.toString(num, 3);
            case 4 : return Integer.toString(num, 4);
            case 5 : return Integer.toString(num, 5);
            case 6 : return Integer.toString(num, 6);
            case 7 : return Integer.toString(num, 7);
            case 8 : return Integer.toString(num, 8);
            case 9 : return Integer.toString(num, 9);
            case 10 : return Integer.toString(num, 10);
            case 11 : return Integer.toString(num, 11).toUpperCase();
            case 12 : return Integer.toString(num, 12).toUpperCase();
            case 13 : return Integer.toString(num, 13).toUpperCase();
            case 14 : return Integer.toString(num, 14).toUpperCase();
            case 15 : return Integer.toString(num, 15).toUpperCase();
            case 16 : return Integer.toString(num, 16).toUpperCase();
        }

        throw new IllegalArgumentException("Invalid Parameter");
    }
}  