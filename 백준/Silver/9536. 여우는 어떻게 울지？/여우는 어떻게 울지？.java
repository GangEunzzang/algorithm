import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            List<String> deleteSountList = new ArrayList<>();
            String fullSound = br.readLine();

            while (true) {
                String otherAnimalSound = br.readLine();

                if (otherAnimalSound.equals("what does the fox say?")) {
                    break;
                }

                String[] split = otherAnimalSound.split(" ");
                String sound = split[2];
                deleteSountList.add(sound);
            }

            String[] sounds = fullSound.split(" ");

            String foxSound = Arrays.stream(sounds)
                    .filter(sound -> !deleteSountList.contains(sound))
                    .map(sound -> sound + " ")
                    .collect(Collectors.joining());

            sb.append(foxSound).append("\n");
        }

        System.out.println(sb);

    }

}