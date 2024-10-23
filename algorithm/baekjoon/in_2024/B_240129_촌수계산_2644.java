package Algorithm.algorithm.baekjoon.in_2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_240129_촌수계산_2644 {
    static int[] findArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n + 1];
        findArr = new int[n + 1];
        for (int i = 0; i < findArr.length; i++) {
            findArr[i] = i;
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list[to] = from;
            findArr[to] = from;
        }
        int head = findHead(x, y);
        if (head == 0) {
            System.out.println(-1);
        } else {
            int child = Integer.min(x,y);
            int parent = Integer.max(x,y);
            int[] countChild = new int[n + 1];
            int[] countParent = new int[n + 1];
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(parent);
            while(!queue.isEmpty()){
                int num = queue.poll();
                if(findArr[num] != num){
                    queue.offer(list[num]);
                    countParent[list[num]] = countParent[num] + 1;
                }
            }
            int result = 0;
            queue.offer(child);
            while(!queue.isEmpty()){
                int num = queue.poll();
                if(num == parent || countParent[num] > 0){
                    result = countParent[num] + countChild[num];
                    break;
                }
                countChild[list[num]] = countChild[num] + 1;
                queue.offer(list[num]);
            }
            System.out.println(result);
        }
    }


    private static int findHead(int x, int y) {
        int resultX = find(x);
        int resultY = find(y);
        if (resultX == resultY) {
            return resultX;
        }
        return 0;
    }

    private static int find(int x) {
        if (findArr[x] == x) {
            return findArr[x];
        }
        return findArr[x] = find(findArr[x]);
    }
}
