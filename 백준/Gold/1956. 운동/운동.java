import java.io.*;
import java.util.*;


public class Main {

    static int INF = 1_000_000_000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int V, E;
    static int[][] distance;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        V = toInt(st.nextToken());
        E = toInt(st.nextToken());
        distance = new int[V + 1][V + 1];

        for (int i = 1; i <= V; i++) {
            Arrays.fill(distance[i], INF);
            distance[i][i] = 0;
        }


        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = toInt(st.nextToken());
            int b = toInt(st.nextToken());
            int c = toInt(st.nextToken());
            distance[a][b] = c;
        }


        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }

        int answer = INF;

        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i == j || distance[i][j] == INF || distance[j][i] == INF) continue;

                answer = Math.min(distance[i][j] + distance[j][i], answer);
            }
        }

        System.out.println(answer == INF ? -1 : answer);

    }
    
    static int toInt(String val) {
        return Integer.parseInt(val);
    }

}



