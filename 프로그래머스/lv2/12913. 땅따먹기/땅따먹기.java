class Solution {

    int solution(int[][] land) {

        for (int i = 1; i < land.length; i++) {
            int[] arr = land[i-1];
            land[i][0] += Math.max(Math.max(arr[1], arr[2]), arr[3]);
            land[i][1] += Math.max(Math.max(arr[0], arr[2]), arr[3]);
            land[i][2] += Math.max(Math.max(arr[0], arr[1]), arr[3]);
            land[i][3] += Math.max(Math.max(arr[0], arr[1]), arr[2]);
        }

        return Math.max(Math.max(Math.max(land[land.length - 1][0], land[land.length - 1][1]), land[land.length - 1][2]), land[land.length-1][3]);
    }


}