class Solution {

    private static boolean[][] bomb;
    private static int[] nowPoint = new int[2];

    private static int width;
    private static int height;

    public int[] solution(String[] park, String[] routes) {

        width = park[0].length()-1;
        height = park.length-1;

        System.out.println("width = " + width);
        System.out.println("height = " + height);

        bomb = new boolean[park.length][park[0].length()];

        for (int i = 0; i < park.length; i++) {
            String s = park[i];

            for (int j = 0; j < s.length(); j++) {

                char charAt = s.charAt(j);

                if (charAt == 'S') {
                    nowPoint[0] = i; // 세로
                    nowPoint[1] = j; // 가로
                }

                if (charAt == 'X') {
                    bomb[i][j] = true;
                }
            }
        }

        for (int i = 0; i < routes.length; i++) {
            char direction = routes[i].charAt(0);
            int count = Character.getNumericValue(routes[i].charAt(2));
            movement(direction, count);

        }
        return new int[]{nowPoint[0], nowPoint[1]};
    }

    private static void movement(char direction, int count) {

        int heightOfPoint = nowPoint[0];
        int widthOfPoint = nowPoint[1];

        for (int i = 1; i <= count; i++) {

            if (direction == 'E') {

                if (isBombOrEscape(heightOfPoint, widthOfPoint + i)) {
                    return;
                }

                if (i == count) {
                    nowPoint[1] = widthOfPoint + i;
                }

            } else if (direction == 'W') {

                if (isBombOrEscape(heightOfPoint, widthOfPoint - i)) {
                    return;
                }

                if (i == count) {
                    nowPoint[1] = widthOfPoint - i;
                }

            } else if (direction == 'S') {

                if (isBombOrEscape(heightOfPoint + i, widthOfPoint)) {
                    return;
                }

                if (i == count) {
                    nowPoint[0] = heightOfPoint + i;
                }

            } else if (direction == 'N') {

                if (isBombOrEscape(heightOfPoint - i, widthOfPoint)) {
                    return;
                }

                if (i == count) {
                    nowPoint[0] = heightOfPoint - i;
                }
            }
        }
    }

    private static boolean isBombOrEscape(int h, int w) {
        return h < 0 || w < 0 || h > height || w > width || bomb[h][w];
    }
}