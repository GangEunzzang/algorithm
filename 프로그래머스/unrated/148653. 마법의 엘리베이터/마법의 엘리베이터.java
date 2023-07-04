import java.util.*;

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(43321232));
    }
    public int solution(int storey) {
        String s = Integer.toString(storey);
        int[] arr = new int[s.length()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.charAt(i) - '0';
        }

        int count = 0;

        for (int i = s.length() - 1; i >= 0; i--) {

            if (arr[i] > 5) {
                count += 10 - arr[i];
                if(i == 0) count++;
                else arr[i-1]++;

            } else if (arr[i] == 5 && i >= 1 && arr[i-1]>=5) {
                arr[i-1]++;
                count += 5;

            } else count +=arr[i];

        }

        return count;
    }

}
