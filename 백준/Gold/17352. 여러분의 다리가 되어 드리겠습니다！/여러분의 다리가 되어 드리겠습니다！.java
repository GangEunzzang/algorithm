import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        N = toInt(br.readLine());
        parent = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        while (true) {
            String s = br.readLine();
            if (s == null || s.isBlank()) break;
            st = new StringTokenizer(s);
            int a = toInt(st.nextToken());
            int b = toInt(st.nextToken());
            union(a,b);
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            set.add(find(i));
        }

        sb.append(set.stream().map(i -> i + " ").collect(Collectors.joining()));
        System.out.println(sb);
    }

    static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if (a == b) return;

        if (a > b) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }
    
    private static int toInt(String s) {
        return Integer.parseInt(s);
    }


}
