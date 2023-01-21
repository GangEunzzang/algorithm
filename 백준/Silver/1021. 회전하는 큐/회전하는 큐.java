import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static LinkedList<Integer> queue = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();
    static int calCount = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int extractionCount = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++ ) {
            queue.offer(i);
        }

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[extractionCount];

        for (int i = 0; i < extractionCount; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 0; i < arr.length; i++ ) {

            int searchNum = arr[i];
            int indexOf = queue.indexOf(searchNum);
            int halfIdx;

            if (queue.size() % 2 == 0 ) {
                halfIdx = queue.size() / 2 - 1;
            } else {
                halfIdx = queue.size() / 2;
            }
            if(indexOf <= halfIdx) {
                for(int j = 0; j < indexOf; j++) {
                    int temp = queue.pollFirst();
                    queue.offerLast(temp);
                    calCount++;
                }
            }
            else {	
                for(int j = 0; j < queue.size() - indexOf; j++) {
                    int temp = queue.pollLast();
                    queue.offerFirst(temp);
                    calCount++;
                }

            }
            queue.pollFirst();	
        }

        System.out.println(calCount);
    }


}
