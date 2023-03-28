import java.io.IOException;
import java.util.*;

class Solution {

    private static Map<Character, Integer> mbtiMap;
    public String solution(String[] survey, int[] choices) {

        StringBuilder sb = new StringBuilder();

        mbtiMap = new HashMap<>();
        mbtiMap.put('R',0);
        mbtiMap.put('C', 0);
        mbtiMap.put('J', 0);
        mbtiMap.put('A', 0);


        for (int i = 0; i < survey.length; i++ ) {
            insertScore(survey[i].charAt(0), choices[i]);
        }

        if (mbtiMap.get('R') >= 0) {
            sb.append('R');
        } else {
            sb.append('T');
        }

        if (mbtiMap.get('C') >= 0) {
            sb.append('C');
        } else {
            sb.append('F');
        }

        if (mbtiMap.get('J') >= 0) {
            sb.append('J');
        } else {
            sb.append('M');
        }

        if (mbtiMap.get('A') >= 0) {
            sb.append('A');
        } else {
            sb.append('N');
        }

        System.out.println("mbtiMap = " + mbtiMap.get('R'));
        System.out.println("mbtiMap = " + mbtiMap.get('C'));
        System.out.println("mbtiMap = " + mbtiMap.get('J'));
        System.out.println("mbtiMap = " + mbtiMap.get('A'));

         return sb.toString();

    }

    private static void insertScore(char charAt, int choice) {

        if (choice == 4) {
            return;
        }

        if (charAt == 'R' || charAt == 'C' || charAt == 'J' || charAt == 'A') {
            if (choice <= 3) mbtiMap.put(charAt, mbtiMap.get(charAt) + (4 - choice));
            if (choice >= 5) mbtiMap.put(charAt, mbtiMap.get(charAt) - (choice - 4));
            return;
        }

        switch (charAt) {
            case 'T':
                if (choice >= 5) mbtiMap.put('R', mbtiMap.get('R') + (choice - 4));
                if (choice <= 3) mbtiMap.put('R', mbtiMap.get('R') - (4 - choice));
                break;

            case 'F':
                if (choice >= 5) mbtiMap.put('C', mbtiMap.get('C') +  (choice - 4));
                if (choice <= 3) mbtiMap.put('C', mbtiMap.get('C') - (4 - choice));
                break;

            case 'M':
                if (choice >= 5) mbtiMap.put('J', mbtiMap.get('J') + (choice - 4));
                if (choice <= 3) mbtiMap.put('J', mbtiMap.get('J') -  (4 - choice));
                break;

            case 'N':
                if (choice >= 5) mbtiMap.put('A', mbtiMap.get('A') + (choice - 4));
                if (choice <= 3) mbtiMap.put('A', mbtiMap.get('A') - (4 - choice));
                break;
        }
    }
}






