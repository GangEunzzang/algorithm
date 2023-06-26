import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final List<String> testCaseList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        inputTestCase();
        doCalc();
    }

    private static void doCalc() throws IOException {
        int result = 0;
        int beforeTime = 0;
        int penaltyCnt = 0;

        testCaseList.sort((o1, o2) -> {
            int parseInt1 = Integer.parseInt(o1.split(" ")[0]);
            int parseInt2 = Integer.parseInt(o2.split(" ")[0]);

            if(parseInt1 > parseInt2) return 1;
            else if(parseInt1 < parseInt2) return -1;
            return 0;
        });

        for(String testCase : testCaseList) {
            String[] records = testCase.split(" ");
            int solvingTime = Integer.parseInt(records[0]);
            penaltyCnt += Integer.parseInt(records[1]);

            result += (beforeTime + solvingTime);
            beforeTime += solvingTime;
        }
        result += (20 * penaltyCnt);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static void inputTestCase() throws IOException {
        for(int i=0; i<11; i++) {
            testCaseList.add(br.readLine());
        }
        br.close();
    }

}