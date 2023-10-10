package Algorithm.algorithm.baekjoon.A형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// N의 범위가 2 <= N <= 10 이므로 비트마스킹을 써서 부분집합을 구할 수 있겠다는 생각을 하였다.
// 부분 집합 구해서 두 집합으로 나눈 후 각 집합이 모두 연결되어 있는 지 확인한다.
// 만약 모두 연결되어 있다면 인구수 차이를 구한 후 값을 최소값으로 갱신해준다.
public class 게리멘더링_17471 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] people = new int[n];
		// 최소값을 구할 때 초기화를 위한 result
		int result = 0;
		for (int i = 0; i < people.length; i++) {
			people[i] = Integer.parseInt(st.nextToken());
			result += people[i];
		}
		
		// 각 노드마다 간선을 이어준다. 이 때 양방향인 것을 생각하고 연결해준다.
		ArrayList<Integer>[] arr = new ArrayList[people.length];
		for (int i = 0; i < arr.length; i++) {
			st = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken());
			for (int j = 0; j < len; j++) {
				int from = i;
				int to = Integer.parseInt(st.nextToken()) - 1;

				if (arr[from] == null) {
					arr[from] = new ArrayList<>();
				}
				arr[from].add(to);

				if (arr[to] == null) {
					arr[to] = new ArrayList<>();
				}
				arr[to].add(from);
			}
		}
		
		// 만약 하나의 부분 집합이 모두 연결이 되어 있지 않다면 계속 false를 나타낸다.
		boolean tf = false;
		// 무조건 두 개의 부분 집합으로 나눠야 하므로 bit == 0 즉, 전체 집합이 곧 부분 집합인 경우는 생각해주지 않는다.
		for (int bit = 1; bit < (1 << n); bit++) {
			// 비트 마스크의 수가 n / 2보다 큰 수는 
			// n / 2보다 작은 수를 구할 때 이미 처리를 해주었기 때문에 생각하지 않는다.
			// 예를 들어 n = 8일 때 left = 3 , right = 5인 경우와 left = 5 , right = 3인 경우는 같을 것이기 때문에
			// 굳이 한 번 더 계산해주지 않는다.
			if (Integer.bitCount(bit) <= n / 2) {
				// 편의상 하나의 부분 집합이 오른쪽과 왼쪽에 있다고 생각하고 문제를 풀었다.
				// left : bit로 인해 만들어진 부분집합
				// right : 전체 집합에서 bit로 인해 만들어진 부분집합의 차집합
				// 여기서 i는 index에 대한 접근임을 상기하며 문제를 풀자.
				ArrayList<Integer> left = new ArrayList<>();
				ArrayList<Integer> right = new ArrayList<>();
				int leftSum = 0;
				int rightSum = 0;
				for (int i = 0; i < n; i++) {
					// bit마스크가 가르키는 비트들을 left에 넣는다.
					if ((bit & (1 << i)) > 0) {
						leftSum += people[i];
						left.add(i);
					} 
					// left에 들어가지 않는 값들을 right에 넣는다.
					else {
						rightSum += people[i];
						right.add(i);
					}
				}
				// bfs를 위한 leftQ, rightQ
				// bfs를 이용하여 하나의 부분집합이 모두 연결되어 있는 지 확인하였다.
				Queue<Integer> leftQ = new LinkedList<>();
				Queue<Integer> rightQ = new LinkedList<>();
				leftQ.add(left.remove(0));
				while (!leftQ.isEmpty()) {
					int num = leftQ.poll();
					if (arr[num] != null) {
						// 연결되어 있는 간선들을 확인하고 
						for (int next : arr[num]) {
							// 이 때 간선에 연결되어있는 노드가 부분집합에 포함인 지 확인한다.
							if (left.contains(next)) {
								// list의 remove를 하기 때문에 다음 bfs단계에서 다시 돌아오는 간선을 고려해줄 필요가 없다.
								// 따라서 visited로 방문 체크를 해주지 않아도 된다.
								left.remove(Integer.valueOf(next));
								leftQ.offer(next);
							}
						}
					}
				}
				// 만약 방문하지 않은 부분집합이 있다면 다음은 현재 부분 집합은 불가하므로 continue
				if (left.size() != 0) {
					continue;
				}

				rightQ.add(right.remove(0));
				while (!rightQ.isEmpty()) {
					int num = rightQ.poll();
					if (arr[num] != null) {
						for (int next : arr[num]) {
							if (right.contains(next)) {
								right.remove(Integer.valueOf(next));
								rightQ.offer(next);
							}
						}
					}
				}
				if (right.size() != 0) {
					continue;
				}
				
				// 만약 부분집합이 안된다면 tf 는 계속 false로 남아있을 것이고,
				// 어떠한 부분집합이 가능한 부분집합이라면 tf는 true로 바뀐다.
				tf = true;
				result = Math.min(result, Math.abs(leftSum - rightSum));
			}
		}
		// tf가 false라는 것은 모든 부분 집합이 소용 없다는 것.
		if(!tf) {
			result = -1;
		}
		System.out.println(result);
	}

}
