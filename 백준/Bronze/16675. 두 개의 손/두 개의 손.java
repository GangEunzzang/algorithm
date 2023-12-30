import java.io.*;
import java.util.*;

class Main {
    static Map<String, String> winMap = new HashMap<>();
    static final String DRAW = "DRAW";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        winMap.put("P", "R");
        winMap.put("R", "S");
        winMap.put("S", "P");

        String ms1 = st.nextToken();
        String ms2 = st.nextToken();
        String tk1 = st.nextToken();
        String tk2 = st.nextToken();

        String ms1Vstk1 = whoWin(ms1, tk1);
        String ms1Vstk2 = whoWin(ms1, tk2);
        String ms2Vstk1 = whoWin(ms2, tk1);
        String ms2Vstk2 = whoWin(ms2, tk2);
        
        if (ms1.equals(ms2) && tk1.equals(tk2) && ms1.equals(tk1)) {
            System.out.println("?");
            return;
        }
        if (ms1.equals(ms2)) {
            if (ms1Vstk1.equals("TK") || ms1Vstk2.equals("TK")) {
                System.out.println("TK");
            } else if(ms1Vstk1.equals("DRAW") || ms1Vstk2.equals("DRAW")){
                System.out.println("?");
            } else {
                System.out.println("MS");
            }
            return;
        }

        if (tk1.equals(tk2)) {
            if (ms1Vstk1.equals("MS") || ms2Vstk1.equals("MS")) {
                System.out.println("MS");
            } else if (ms1Vstk1.equals("DRAW") || ms2Vstk1.equals("DRAW")) {
                System.out.println("?");
            } else {
                System.out.println("TK");
            }
            return;
        }
        System.out.println("?");
    }

    private static String whoWin(String ms, String tk) {
        String msWin = winMap.get(ms);
        String tkWin = winMap.get(tk);

        if (msWin.equals(tk)) {
            return "MS";
        }

        if (tkWin.equals(ms)) {
            return "TK";
        }
        return DRAW;
    }
}