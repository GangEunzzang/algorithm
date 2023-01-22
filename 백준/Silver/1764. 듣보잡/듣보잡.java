import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        HashMap<String, String> mapA = new HashMap<>();
        HashMap<String, String> mapB = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int count = 0;


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String data = br.readLine();
            mapA.put(data, data);
        }

        for (int i = 0; i < M; i++) {
            String data = br.readLine();
            if (mapA.containsKey(data)) {
                mapB.put(data, data);
            }
        }
        List<String> collect = mapB.values().stream().sorted().collect(Collectors.toList());

        sb.append(collect.size()).append("\n");

        for (String s : collect) {
            sb.append(s).append("\n");
        }

        
        System.out.print(sb);

    }
}