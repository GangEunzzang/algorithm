class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int length = diffs.length;

        long start = 1;
        long end = limit;
        int result = 0;

        while (start <= end) {
            long mid = (start + end) / 2;

            long totalTime = times[0];

            for (int i = 1; i < length; i++) {
                int curDiff = diffs[i];
                int curTime = times[i];
                int preTime = times[i - 1];

                if (curDiff > mid) {
                    totalTime += (preTime + curTime) * (curDiff - mid) + curTime;
                } else {
                    totalTime += curTime;
                }
            }

            if (totalTime > limit) {
                start = mid + 1;
            } else {
                end = mid -1;
                result = (int) mid;
            }
        }

        return result;
    }
}