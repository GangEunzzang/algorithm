import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] arr = {9,8,7,6,5,4,3,2,1,0};
    static List<Long> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dfs(0, 0);
        Collections.sort(list);
        System.out.println(list.size() >= N ? list.get(N-1) : -1);
    }

    static void dfs(long num, int index) {
        if (!list.contains(num)) list.add(num);

        if (index > 9) return;

        dfs(num * 10 + arr[index], index + 1);
        dfs(num, index + 1);
    }
}