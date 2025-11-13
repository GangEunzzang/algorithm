import java.util.Arrays;

class Solution {
    static int[][] map;
    static int n,m;

    public int solution(int[] mats, String[][] park) {
        n = park.length;
        m = park[0].length;
        map = new int[n][m];

        convertMap(park);
        Arrays.sort(mats);

        for (int i = mats.length - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    boolean check = check(mats[i], j, k);
                    if (check) {
                        System.out.println("j = " + j);
                        System.out.println("k = " + k);
                        return mats[i];
                    }
                }
            }
        }

        return -1;

    }

    private static void convertMap(String[][] park) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isDigit(park[i][j])) map[i][j] = 1;
            }
        }
    }

    private static boolean isDigit(String s) {
        try {
            Integer.parseInt(s);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    private static boolean check(int length, int x, int y) {
        if (x + length > n || y + length > m) {
            return false;
        }

        for (int i = x; i < x + length; i++) {
            for (int j = y; j < y + length; j++) {
                    if (map[i][j] == 0) return false;
            }
        }

        return true;

    }


}