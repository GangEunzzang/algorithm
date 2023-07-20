import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            Arrays.sort(chars);
            set.add(Arrays.toString(chars));
        }

        System.out.println(set.size());
    }


}