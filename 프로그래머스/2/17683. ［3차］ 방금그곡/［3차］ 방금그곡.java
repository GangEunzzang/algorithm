import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {

    private String m;
    public String solution(String m, String[] musicinfos) {

        m = replaceMelody(m);

        String lastSongTitle = "(None)";
        int lastSongTime = 0;

        for (String musicInfo : musicinfos) {
            StringTokenizer st = new StringTokenizer(musicInfo, ",");
            int currentSongTime = getPlayedSongTime(st.nextToken(), st.nextToken());
            String currentSongTitle = st.nextToken();
            String currentMelody = replaceMelody(st.nextToken());

            if (currentSongTime < m.length()) {
                continue;
            }

            StringBuilder songs = new StringBuilder();
            for (int i = 0; i < currentSongTime; i++) {
                songs.append(currentMelody.charAt(i % currentMelody.length()));
            }

            if (!songs.toString().contains(m) || lastSongTime >= currentSongTime) {
                continue;
            }

            lastSongTitle = currentSongTitle;
            lastSongTime = currentSongTime;
        }

        return lastSongTitle;
    }

    private int getPlayedSongTime(String startTime, String endTime) {
        StringTokenizer startSt = new StringTokenizer(startTime, ":");
        StringTokenizer endSt = new StringTokenizer(endTime, ":");

        int start = Integer.parseInt(startSt.nextToken()) * 60 + Integer.parseInt(startSt.nextToken());
        int end = Integer.parseInt(endSt.nextToken()) * 60 + Integer.parseInt(endSt.nextToken());

        return end - start;
    }

    private String replaceMelody(String melody) {
        melody = melody.replaceAll("C#", "H");
        melody = melody.replaceAll("D#", "I");
        melody = melody.replaceAll("F#", "J");
        melody = melody.replaceAll("G#", "K");
        return melody.replaceAll("A#", "L");
    }
}