package Algorithm.algorithm.baekjoon.in_2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_240129_스타트링크_5014 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        if (s == g) {
            System.out.println(0);
            System.exit(0);
        }
        boolean[] visited = new boolean[f + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        visited[s] = true;
        int[] count = new int[f + 1];
        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (now == g) {
                break;
            }
            int up = now + u;
            if (up <= f && !visited[up]) {
                visited[up] = true;
                count[up] = count[now] + 1;
                queue.offer(up);
            }
            int down = now - d;
            if (down > 0 && !visited[down]) {
                visited[down] = true;
                count[down] = count[now] + 1;
                queue.offer(down);
            }
        }
        if (count[g] == 0) {
            System.out.println("use the stairs");
        } else {
            System.out.println(count[g]);
        }
    }

}
