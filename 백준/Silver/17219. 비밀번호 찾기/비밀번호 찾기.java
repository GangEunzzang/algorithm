import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        Map<String, String> password = new HashMap<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++ ) {
            st = new StringTokenizer(br.readLine());

            String key = st.nextToken();
            String value = st.nextToken();
            password.put(key, value);
        }

        for (int i = 0; i < M; i++ ) {
            st = new StringTokenizer(br.readLine());

            String search = st.nextToken();
            String value = password.get(search);

            sb.append(value).append("\n");
        }

        System.out.println(sb);

    }

}