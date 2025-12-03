import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String a = br.readLine();
        String b = br.readLine();

        char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();

        if (!alphabetCountCheck(N, aArray, bArray)) {
            System.out.println("NO");
            return;
        }

        if (!deletedVowels(N, aArray, bArray)) {
            System.out.println("NO");
            return;
        }

        if (aArray[0] == bArray[0] && aArray[N - 1] == bArray[N - 1]) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }


    }

    private static boolean deletedVowels(int N, char[] aArray, char[] bArray) {
        boolean[] aRemoved = new boolean[N];
        boolean[] bRemoved = new boolean[N];

        for (int i = 0; i < N; i++) {
            boolean aCheck = vowels.contains(aArray[i]);
            boolean bCheck = vowels.contains(bArray[i]);
            if (aCheck) {
                aRemoved[i] = true;
            }

            if (bCheck) {
                bRemoved[i] = true;
            }
        }

        StringBuilder aResult = new StringBuilder();
        StringBuilder bResult = new StringBuilder();

        for (int i = 0; i < N; i++) {
            if (!aRemoved[i]) {
                aResult.append(aArray[i]);
            }
            if (!bRemoved[i]) {
                bResult.append(bArray[i]);
            }
        }

        return aResult.toString().contentEquals(bResult);
    }

    private static boolean alphabetCountCheck(int N, char[] aArray, char[] bArray) {
        int[] aCount = new int[26];
        int[] bCount = new int[26];

        for (int i = 0; i < N; i++) {
            aCount[aArray[i] - 'a']++;
            bCount[bArray[i] - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (aCount[i] != bCount[i]) {
                return false;
            }
        }

        return true;
    }
}
