import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    private static int G;
    private static int P;
    private static int[] parent;
    public static void main(String[] args) throws IOException {

        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());
        parent = new int[G + 1];

        for (int i = 0; i <= G; i++) {
            parent[i] = i;
        }

        int answer = 0;

        while (P-- > 0) {
            int g = Integer.parseInt(br.readLine());
            int emptyGate = find(g);

            if (emptyGate != 0) {
                answer++;
                union(emptyGate, emptyGate - 1);
            } else {
                break;
            }
        }

        System.out.println(answer);
        

    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
        
    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[x] = y;
        }
    }


}