import java.util.*;
import java.io.*;
import java.util.stream.IntStream;


public class Main {

    private static final int[] ascending = {1, 2, 3, 4, 5, 6, 7, 8};
    private static final int[] descending = {8, 7, 6, 5, 4, 3, 2, 1};

    public static void main(String[] args) throws IOException{
        int[] arr = Arrays.stream(new BufferedReader(new InputStreamReader(System.in)).readLine()
                        .split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        if(Arrays.equals(ascending, arr)) System.out.println("ascending");
        else if(Arrays.equals(descending, arr)) System.out.println("descending");
        else System.out.println("mixed");

    }
}