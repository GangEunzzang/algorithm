import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Solution {
    public int solution(String[][] book_time) {
        int[][] convertOfBookTime = convert(book_time);

        Arrays.sort(convertOfBookTime, Comparator.comparing(arr -> arr[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count = 1;

        for (int[] arr : convertOfBookTime) {
            while (!pq.isEmpty() && pq.peek() <= arr[0]) pq.poll();
            if (pq.size() >= count) count++;
            pq.add(arr[1]);
        }

        return count;
    }

    private int[][] convert(String[][] bookTime) {

        int[][] arr = new int[bookTime.length][2];

        for (int i = 0; i < bookTime.length; i++) {
            String startTime = bookTime[i][0];
            String endTime = bookTime[i][1];

            String startHour = startTime.substring(0, 2);
            String startMinute = startTime.substring(3, 5);
            String endHour = endTime.substring(0, 2);
            String endMinute = endTime.substring(3, 5);

            arr[i][0] = (Integer.parseInt(startHour) * 60)  +  Integer.parseInt(startMinute);
            arr[i][1] = (Integer.parseInt(endHour) * 60)  + Integer.parseInt(endMinute) +  10;
        }

        return arr;
    }
}