import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    private static List<Character> vowelList = List.of('a', 'e', 'i', 'o', 'u');
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String password = br.readLine();
            if (password.equals("end")) break;

            if (!validateContainsVowel(password) || !validateNoThreeConsecutive(password) || !validateNoDuplicateCharacter(password)) {
                sb.append("<" + password  + "> is not acceptable.\n");
            } else {
                sb.append("<" + password  + "> is acceptable.\n");
            }
        }

        System.out.println(sb);

    }

    private static boolean validateContainsVowel(String password) {

        if (password.contains("a")) return true;
        if (password.contains("e")) return true;
        if (password.contains("i")) return true;
        if (password.contains("o")) return true;
        if (password.contains("u")) return true;

        return false;
    }

    private static boolean validateNoThreeConsecutive(String password) {
        if (password.length() < 3) return true;

        int consonantContinuousCount = 0; // 연속된 자음 개수
        int vowelContinuousCount = 0;   // 연속된 모음 개수

        for (char letter : password.toCharArray()) {
            if (vowelList.contains(letter)) {
                consonantContinuousCount = 0;
                vowelContinuousCount++;
            } else {
                consonantContinuousCount++;
                vowelContinuousCount = 0;
            }

            if (vowelContinuousCount == 3 || consonantContinuousCount == 3) {
                return false;
            }
        }

        return true;
    }

    private static boolean validateNoDuplicateCharacter(String password) {
        if (password.length() < 2) return true;

        char[] letters = password.toCharArray();
        char lastLetter = letters[0];
        int continuousCount = 1;

        for (int i = 1; i < letters.length; i++) {
            char letter = letters[i];
            if (lastLetter != letter) {
                lastLetter = letter;
                continuousCount = 1;
                continue;
            }
            if (++continuousCount == 2 && lastLetter != 'e' && lastLetter != 'o') return false;
        }

        return true;
    }
}
