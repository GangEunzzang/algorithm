class Solution {
    public int solution(int[][] sizes) {

        int[][] arr = sizes;

        for (int i = 0; i < sizes.length; i++) {
            int w = sizes[i][0];
            int h = sizes[i][1];
            arr[i][0] = Math.max(w, h);
            arr[i][1] = Math.min(w, h);
        }
        
        int widthMaxValue = 0;
        int heightMaxValue = 0;

        for (int i = 0; i < sizes.length; i++) {

            int w = sizes[i][0];
            int h = sizes[i][1];

            if (w > widthMaxValue) {
                widthMaxValue = w;
            }

            if (h > heightMaxValue) {
                heightMaxValue = h;
            }
        }

        return widthMaxValue * heightMaxValue;
    }
}