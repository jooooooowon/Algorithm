package Algorithm.algorithm.programmers.in_2024;

import java.util.Arrays;
import java.util.Comparator;

public class P_240326_요격시스템 {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (o1, o2) -> (o1[1] - o2[1]));
        int s = targets[0][0];
        int e = targets[0][1];
        answer = 1;
        for (int i = 1; i < targets.length; i++) {
            int tempS = targets[i][0];
            int tempE = targets[i][1];
            if(e < tempS){
                e = tempE;
                answer++;
            }
        }
        return answer;
    }
}
