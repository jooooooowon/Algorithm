package Algorithm.algorithm.baekjoon.in_2024;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_240304_강의실_1374 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Node[] arr = new Node[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[i] = new Node(num, start, end);
        }
        Arrays.sort(arr);
        PriorityQueue<Integer> pque = new PriorityQueue<Integer>();
        int roomCount = 1;

        for (int i = 0; i < n; i++) {
            while (!pque.isEmpty() && pque.peek() <= arr[i].start) {
                pque.poll();
            }
            pque.offer(arr[i].end);
            roomCount = Math.max(roomCount, pque.size());
        }
        System.out.println(roomCount);
    }

    static class Node implements Comparable<Node> {
        int num;
        int start;
        int end;

        public Node(int num, int start, int end) {
            this.num = num;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node node) {
            if (this.start == node.start) {
                return this.end - node.end;
            }
            return this.start - node.start;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "num=" + num +
                    ", start=" + start +
                    ", end=" + end +
                    '}' + "\n";
        }
    }
}
