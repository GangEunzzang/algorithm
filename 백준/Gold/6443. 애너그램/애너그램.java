import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static char[] words;
    static char[] tmp;
    static boolean[] visited;
    static int length;

    public static void main(String[] args) throws IOException {
        N = toInt(br.readLine());

        while (N-- > 0) {
            words = br.readLine().toCharArray();
            length = words.length;
            tmp = new char[length];
            visited = new boolean[length];
            Arrays.sort(words);
            dfs(0);

        }

        bw.flush();
        bw.close();

    }

    private static void dfs(int idx) throws IOException {
        if (idx == length) {
            bw.write(tmp);
            bw.write("\n");
        }

        for (int i = 0; i < length; i++) {
            if (visited[i] || (i > 0 && words[i] == words[i - 1] && !visited[i - 1])) continue;

            visited[i] = true;
            tmp[idx] = words[i];
            dfs(idx + 1);
            visited[i] = false;
        }
    }


    static int toInt(String val) {
        return Integer.parseInt(val);
    }


}

