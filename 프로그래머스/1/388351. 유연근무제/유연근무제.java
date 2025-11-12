class Solution {

    public int solution(int[] schedules, int[][] timelogs, int startday) {

        int count = 0;
        int[] entTime = new int[schedules.length];
        setupEndTime(schedules, entTime);

        outer:
        for (int i = 0; i < entTime.length; i++) {
            for (int j = 0; j < 7; j++) {
                int nowDay = (startday + j - 1) %  7 ;

                if (nowDay != 5 && nowDay != 6) {
                    if (timelogs[i][j] > entTime[i]) {
                        continue outer;
                    }
                }
            }
            count++;
        }
        return count;
    }

    private static void setupEndTime(int[] schedules, int[] entTime) {
        for (int i = 0; i < entTime.length; i++) {
            int time = schedules[i];
            int hour = time / 100;
            int minute = time % 100;
            int newTime = hour * 100 + minute + 10;
            if (newTime % 100 >= 60) newTime+= 40;
            entTime[i] = newTime;
        }
    }
}