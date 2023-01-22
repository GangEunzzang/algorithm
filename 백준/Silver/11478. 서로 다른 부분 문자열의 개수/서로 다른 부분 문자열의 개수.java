import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        int count = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, String> map = new HashMap<>();

        String S = br.readLine();

        for (int i = 0; i < S.length(); i++ ) {
            for (int j = i+1; j <= S.length(); j++ ) {
                String data = S.substring(i , j);
                map.put(data, data);
            }
        }

        System.out.println(map.size());
    }
}