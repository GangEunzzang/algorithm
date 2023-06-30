import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        List<Node> list = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int idx = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            list.add(new Node(idx, gold, silver, bronze));

        }

        int rank = 0;
        int lastGoldCount = 0;
        int lastSilverCount = 0;
        int lastBronzeCount = 0;

        Collections.sort(list, (o1, o2) -> {
            int first = o2.gold - o1.gold;
            if (first != 0) return first;

            int second = o2.silver - o1.silver;
            if (second != 0) return second;

            return o2.bronze - o1.bronze;
        });

        for (Node node : list) {
            if (node.idx == K) {
                System.out.println(rank);
                break;
            }

            if (lastGoldCount == node.gold && lastSilverCount == node.silver && lastBronzeCount == node.bronze)
                continue;

            lastGoldCount = node.gold;
            lastSilverCount = node.silver;
            lastBronzeCount = node.bronze;
            rank++;

        }

    }

    static class Node {

        int idx;
        int gold;
        int silver;
        int bronze;

        @Override
        public String toString() {
            return idx + " " + gold + " " + silver + " " + bronze;
        }

        Node(int idx, int gold, int silver, int bronze) {
            this.idx = idx;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

    }

}