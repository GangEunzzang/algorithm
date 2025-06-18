class Solution {
       public static String convert(String s, int numRows) {
        char[][] arr = new char[numRows][s.length()];
        
        if (numRows == 1) return s;
        // 0 == down
        // 1 == up
        int dir = 0;
        int curX = 0;
        int curY = 0;

        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);

            if (dir == 0 && curX == numRows - 1) dir = 1;
            if (dir == 1 && curX == 0) dir = 0;

            if (dir == 0) {
                arr[curX++][curY] = curChar;
            }

            if (dir == 1) {
                arr[curX--][curY++] = curChar;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < s.length(); j++) {
                char c = arr[i][j];
                if (c != 0) {
                    sb.append(arr[i][j]);
                }
            }
        }

        return sb.toString();

    }
}