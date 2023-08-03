import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numMeetingRooms = Integer.parseInt(st.nextToken());
        int numReservations = Integer.parseInt(st.nextToken());

        Map<String, boolean[]> reservationMap = new HashMap<>();

        List<String> meetingRooms = new ArrayList<>();
        for (int i = 0; i < numMeetingRooms; i++) {
            meetingRooms.add(br.readLine());
        }

        for (int i = 0; i < numReservations; i++) {
            st = new StringTokenizer(br.readLine());
            String meetingRoom = st.nextToken();
            int startHour = Integer.parseInt(st.nextToken());
            int endHour = Integer.parseInt(st.nextToken());

            boolean[] timeUsedArr = reservationMap.getOrDefault(meetingRoom, new boolean[19]);
            for (int j = startHour; j < endHour; j++) {
                timeUsedArr[j] = true;
            }

            reservationMap.put(meetingRoom, timeUsedArr);
        }

        Collections.sort(meetingRooms);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numMeetingRooms; i++) {
            String meetingRoom = meetingRooms.get(i);
            boolean[] timeArr = reservationMap.getOrDefault(meetingRoom, new boolean[19]);
            List<String> availableHours = new ArrayList<>();

            int lastHour = 0;

            for (int j = 9; j <= 18; j++) {
                if (lastHour == 0 && !timeArr[j]) {
                    lastHour = j;
                    continue;
                }

                if (lastHour != 0 && timeArr[j]) {
                    availableHours.add(String.format("%02d-%02d", lastHour, j));
                    lastHour = 0;
                }
            }

            if (lastHour != 0 && lastHour != 18) {
                availableHours.add(String.format("%02d-18", lastHour));
            }

            sb.append("Room ").append(meetingRoom).append(":").append("\n");
            sb.append(availableHours.isEmpty() ? "Not available" : availableHours.size() + " available:").append("\n");
            for (String hourRange : availableHours) {
                sb.append(hourRange).append("\n");
            }
            if (i < numMeetingRooms - 1) {
                sb.append("-----").append("\n");
            }
        }

        System.out.println(sb);
    }
}