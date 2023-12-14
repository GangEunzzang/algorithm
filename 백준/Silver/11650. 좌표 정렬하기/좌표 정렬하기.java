import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static List<Node> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        N = toInt(br.readLine());

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            list.add(new Node(toInt(st.nextToken()), toInt(st.nextToken())));
        }

        Collections.sort(list, ((o1, o2) -> {
            if (o1.x != o2.x) return o1.x - o2.x;
            return o1.y - o2.y;
        }));

        for (Node node : list) {
            sb.append(node.x).append(" ").append(node.y).append("\n");
        }

        System.out.println(sb);
    }

    static int toInt(String val) {
        return Integer.parseInt(val);
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}

