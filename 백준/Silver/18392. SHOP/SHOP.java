import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder root = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int customerCount = 1;


        while (T-- > 0) {
            int amount = Integer.parseInt(br.readLine());
            PriorityQueue<Node> pq = new PriorityQueue<>();
            StringBuilder sb = new StringBuilder();

            sb.append("Customer").append(customerCount).append(":").append("\n");
            root.append(sb);
            sb.setLength(0);
            StringTokenizer st = new StringTokenizer(br.readLine(), ",");
            while (st.hasMoreTokens()) {
                StringTokenizer divide = new StringTokenizer(st.nextToken(), ":");
                int money = Integer.parseInt(divide.nextToken().trim());
                int count = Integer.parseInt(divide.nextToken().trim());
                pq.add(new Node(money, count));
            }

            while (amount > 0) {
                if (pq.isEmpty()) {
                    sb.setLength(0);
                    sb.append("Impossible").append("\n");
                    break;
                }

                Node node = pq.poll();
                int money = node.money;
                int count = node.count;

                if(money > amount) continue;

                int canDivide = amount / money;

                if (canDivide > count) {
                    amount -= money * count;
                    sb.append(money).append(" ").append(count).append("\n");
                } else {
                    amount -= money * canDivide;
                    sb.append(money).append(" ").append(canDivide).append("\n");
                }
            }

            customerCount++;
            root.append(sb);
        }

        System.out.println(root);

    }

    static class Node implements Comparable<Node>{
        int money;
        int count;

        Node(int money, int count) {
            this.money = money;
            this.count = count;
        }


        @Override
        public int compareTo(Node o) {
            return Integer.compare(o.money, this.money);
        }
    }



}