import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {

        int[] arr = new int[4];
        Arrays.fill(arr, -1);

        for (int i = 0; i < wallpaper.length; i++) {

            String s = wallpaper[i];

            for (int j = 0; j < s.length(); j++) {

                if (s.charAt(j) == '.') {
                    continue;
                }

                if (arr[0] == -1) {
                    arr[0] = i;
                }

                 if (arr[1] > j || arr[1] == -1) {
                    arr[1] = j;
                }

                if (arr[2] < i + 1) {
                    arr[2] = i + 1;
                }

                if (arr[3] < j + 1) {
                    arr[3] = j + 1;
                }
            }

        }
        
        return arr;
    }
}