import java.util.*;
import java.io.*;
public class Main{
    
    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        final int NUMBER_OF_FAN = Integer.parseInt(br.readLine());
        
        int mostStartPoint = -1,
            lowestFinishPoint = 1000001;
        
        for(int i=0;i<NUMBER_OF_FAN;i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()),
                finish = Integer.parseInt(st.nextToken());
            
            if(start > mostStartPoint) {
                mostStartPoint = start;
            }
            
            if(finish < lowestFinishPoint) {
                lowestFinishPoint = finish;
            }
        }
        int answer = mostStartPoint - lowestFinishPoint;
        if(answer < 0) {
            sb.append(0);
        }else {
            sb.append(answer);
        }
        
        sb.append("\n"); 
        
        bw.write(sb.toString());
        
        bw.flush();
        br.close();
        bw.close();
        
    }

    
}