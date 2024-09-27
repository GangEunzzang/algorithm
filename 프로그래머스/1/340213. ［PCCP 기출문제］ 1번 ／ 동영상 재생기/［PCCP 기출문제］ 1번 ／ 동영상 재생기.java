class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {

        int videoTotalTime = toMinutes(video_len);
        int nowTime = toMinutes(pos);
        int openingStartTime = toMinutes(op_start);
        int openingEndTime = toMinutes(op_end);

        if (openingStartTime <= nowTime && nowTime <=openingEndTime) {
            nowTime = openingEndTime;
        }

        for (String command : commands) {
            if (command.equals("prev")) {
                int prevTime = Math.max(nowTime - 10, 0);
                nowTime = openingStartTime <= prevTime && prevTime <= openingEndTime ? openingEndTime : prevTime;
                continue;
            }

            int nextTime = Math.min(nowTime + 10, videoTotalTime);
            nowTime = openingStartTime <= nextTime && nextTime <= openingEndTime ? openingEndTime : nextTime;

        }

        int hour = nowTime / 60;
        int minute = nowTime % 60;

        return String.format("%02d", hour) + ":" + String.format("%02d", minute);
    }

    private int toMinutes(String time) {
        String[] split = time.split(":");
        int hour = Integer.parseInt(split[0]);
        int minute = Integer.parseInt(split[1]);

        return hour * 60 + minute;
    }
}