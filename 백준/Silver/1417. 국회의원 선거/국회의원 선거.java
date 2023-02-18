import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    static PriorityQueue<Candidate> q = new PriorityQueue<>((c1, c2) -> c2.getVal() - c1.getVal());

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int first = Integer.parseInt(br.readLine());

        for (int i = 1; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            Candidate candidate = new Candidate(i + 1, num);
            q.add(candidate);
        }

        int count = 0;

        while (!q.isEmpty()) {
            Candidate candidate = q.poll();
            if (candidate.getVal() >= first) {
                int newVote = candidate.getVal() - 1;
                candidate.setVal(newVote);
                q.add(candidate);
                first++;
                count++;
            } else {
                break;
            }
        }

        System.out.println(count);
    }
}

class Candidate {

    private int num;
    private int val;

    Candidate(int num, int val) {
        this.num = num;
        this.val = val;
    }

    public int getNum() {
        return num;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
