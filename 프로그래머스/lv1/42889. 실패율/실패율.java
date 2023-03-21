import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[] solution(int N, int[] stages) {

        int[] stageClearArr = new int[N + 2];
        int[] stageStayArr = new int[N + 2];

        for (int i = 0; i < stages.length; i++) {

            int stage = stages[i];
            stageStayArr[stage]++;

            for (int j = 1; j <= stage; j++) {
                stageClearArr[j] ++;
            }
        }
        List<Stage> stageList = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            
                      if (stageStayArr[i] == 0) {
                stageList.add(new Stage(i, 0));
                continue;
            }
            
            double fail = ((double)stageStayArr[i] / (double)stageClearArr[i]);
            
            stageList.add(new Stage(i, fail));
        }

        Comparator<Stage> comparator = (o1, o2) -> Double.compare(o2.getStageFail(), o1.getStageFail());

        Collections.sort(stageList, comparator);

        return stageList.stream().mapToInt(a -> a.getStageNum()).toArray();

    }

}

class Stage {
    public Stage(int stageNum, double stageFail) {
        this.stageNum = stageNum;
        this.stageFail = stageFail;
    }
    private int stageNum;
    private double stageFail;

    public double getStageFail() {
        return stageFail;
    }

    public int getStageNum() {
        return stageNum;
    }
}