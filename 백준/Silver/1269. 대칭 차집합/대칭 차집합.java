import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        HashMap<String, String> mapA = new HashMap<>();
        HashMap<String, String> mapB = new HashMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            String data = st.nextToken();
            mapA.put(data, data);
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            String data = st.nextToken();
            mapB.put(data, data);
        }

        int size = mapA.size() + mapB.size();

        for (String key : mapA.keySet()) {
            if (mapB.containsKey(key)) {
                size --;
            }
        }

        for (String key : mapB.keySet()) {
            if (mapA.containsKey(key)) {
                size --;
            }
        }

        System.out.println(size);
    }
}