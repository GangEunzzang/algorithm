import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        String target = br.readLine().replace(" ", "");
        String click = br.readLine().replace(" ", "");

        System.out.println(click.contains(target) ? "secret" : "normal");

    }


}