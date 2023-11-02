class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            int remainder = n % 3;
            switch (remainder) {
                case 0:
                    sb.append(4);
                    break;
                case 1:
                    sb.append(1);
                    break;
                default:
                    sb.append(2);
                    break;
            }

            if (remainder == 0) n -= 1;
            n /= 3;
        }

        return sb.reverse().toString();
    }
}