import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static char[][] arr = new char[3][3];
    static int[] moveX = {0, -1, 1, 0, 0};
    static int[] moveY = {0, 0, 0, -1, 1};
    static Set<String> visited;

    public static void main(String[] args) throws IOException {

        int T = toInt(br.readLine());

        while (T-- > 0) {
            visited = new HashSet<>();
            for (int i = 0; i < 3; i++) {
                String s = br.readLine();
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = s.charAt(j);
                }
            }
            sb.append(bfs()).append("\n");
        }


        System.out.println(sb);

    }

    private static int bfs() {
        Queue<Node> q = new LinkedList<>();
        if (check(arr)) return 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char[][] copy = changeAdjacentBoard(arr, i, j);
                q.add(new Node(copy, 1));
                visited.add(toConvertVisited(copy));
            }
        }

        while (!q.isEmpty()) {
            Node node = q.poll();
            char[][] curArr = node.arr;

            if (check(curArr)) return node.count;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    char[][] nextArr = changeAdjacentBoard(curArr, i, j);

                    String convertVisited = toConvertVisited(nextArr);
                    if (visited.contains(convertVisited)) continue;

                    q.add(new Node(nextArr, node.count + 1));
                    visited.add(convertVisited);
                }
            }
        }

        return -999;
    }

    static String toConvertVisited(char[][] arr) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(arr[i][j] == '*' ? 1 : 0);
            }
        }
        return sb.toString();
    }


    private static boolean check(char[][] arr) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[i][j] == '*') {
                    return false;
                }
            }
        }
        return true;
    }

    private static char[][] changeAdjacentBoard(char[][] curArr, int x, int y) {
        char[][] copy = new char[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                copy[i][j] = curArr[i][j];
            }
        }

        for (int i = 0; i < 5; i++) {
            int mx = x + moveX[i];
            int my = y + moveY[i];

            if (mx < 0 || my < 0 || mx >= 3 || my >= 3) continue;
            copy[mx][my] = curArr[mx][my] == '*' ? '.' : '*';
        }


        return copy;
    }

    private static class Node {
        char[][] arr;
        int count;

        public Node(char[][] arr, int count) {
            this.arr = arr;
            this.count = count;
        }
    }


    static int toInt(String val) {
        return Integer.parseInt(val);
    }


}

