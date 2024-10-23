package Algorithm.algorithm.baekjoon.in_2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class B_240122_기차가어둠을_해치고_은하수를_15787 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] trains = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int trainNum = Integer.parseInt(st.nextToken());
            if(command == 1 || command == 2){
                int seat = Integer.parseInt(st.nextToken());
                seat--;
                if(command == 1){
                    trains[trainNum] |= 1 << seat;
                }else{
                    trains[trainNum] &= ~ (1 << seat);
                }
            }else{
                if(command == 3){
                    trains[trainNum] = (trains[trainNum] & ~(1 << 19)) << 1;
                }else{
                    trains[trainNum] = (trains[trainNum] & ~ 1) >> 1;
                }
            }
        }
        Set<Integer> result = new HashSet<>();
        for(int i = 1 ; i < trains.length; i++){
            result.add(trains[i]);
        }
        System.out.println(result.size());
    }
}
