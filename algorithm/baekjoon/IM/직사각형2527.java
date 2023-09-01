package Algorithm.algorithm.baekjoon.IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 직사각형2527 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x_1 = Integer.parseInt(st.nextToken());
			int y_1 = Integer.parseInt(st.nextToken());
			int p_1 = Integer.parseInt(st.nextToken());
			int q_1 = Integer.parseInt(st.nextToken());

			int x_2 = Integer.parseInt(st.nextToken());
			int y_2 = Integer.parseInt(st.nextToken());
			int p_2 = Integer.parseInt(st.nextToken());
			int q_2 = Integer.parseInt(st.nextToken());
			if (x_1 > p_2 || p_1 < x_2 || y_1 > q_2 || q_1 < y_2)
				sb.append("d\n");
			else if (x_1 == p_2) {
				if (y_1 == q_2 || y_2 == q_1)
					sb.append("c\n");
				else
					sb.append("b\n");
			} else if (p_1 == x_2) {
				if (q_1 == y_2 || q_2 == y_1)
					sb.append("c\n");
				else
					sb.append("b\n");
			} else if (y_1 == q_2) {
				if (x_1 == p_2 || x_2 == p_1)
					sb.append("c\n");
				else
					sb.append("b\n");
			} else if (q_1 == y_2) {
				if (p_1 == x_2 || p_2 == x_1)
					sb.append("c\n");
				else
					sb.append("b\n");
			} else
				sb.append("a\n");
		}
		System.out.println(sb);
	}

}
