package Algorithm.algorithm.baekjoon.in_2024;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class B_240226_노드사이의_거리_1240 {
    static Map<Integer,Integer>[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new Map[n + 1];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = new HashMap();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            arr[start].put(end, distance);
            arr[end].put(start, distance);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(bfs(start, end));
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static int bfs(int start, int end) {
        Queue<Node> queue = new LinkedList();
        boolean[] visited = new boolean[arr.length];
        int[] count = new int[arr.length];
        queue.add(new Node(start,0));
        visited[start] = true;
        while(!queue.isEmpty()){
            Node now = queue.poll();
            for(int next : arr[now.idx].keySet()){
                if(!visited[next]){
                    queue.add(new Node(next,arr[now.idx].get(next) + now.distance));
                    visited[next] = true;
                    count[next] = now.distance + arr[now.idx].get(next);
                }else if (now.distance + arr[now.idx].get(next) < count[next]){
                    queue.add(new Node(next, arr[now.idx].get(next) + now.distance));
                    count[next] = now.distance + arr[now.idx].get(next);
                }
            }
        }
        return count[end];
    }

    static class Node{
        int idx;
        int distance;

        Node(int idx, int distance){
            this.idx = idx;
            this.distance = distance;
        }
    }
}
