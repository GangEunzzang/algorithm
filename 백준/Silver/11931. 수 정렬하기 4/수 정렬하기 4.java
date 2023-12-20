import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;

    public static void main(String[] args) throws IOException {
        int N = toInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        while (N-- > 0) {
            list.add(toInt(br.readLine()));
        }
        
        Collections.sort(list, Collections.reverseOrder());

        for (Integer i : list) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);



    }


    static int toInt(String val) {
        return Integer.parseInt(val);
    }

}

