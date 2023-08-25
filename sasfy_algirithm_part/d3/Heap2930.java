package Algorithm.sasfy_algirithm_part.d3;

import java.util.Scanner;

public class Heap2930 {
	static int[] arr;
	static int size;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int testCase = 1; testCase <= test; testCase++) {
			int n = sc.nextInt();
			// 모두 offer만 있을 경우를 생각해 사이즈를 n + 1로 한다.
			// 처음은 1로 잡아야하기에 n + 1로 하였다.
			arr = new int[n + 1];
			size = 0;
			sb.append("#").append(testCase).append(" ");
			for (int i = 0; i < n; i++) {
				int cal = sc.nextInt();
				if (cal == 1) {
					int num = sc.nextInt();
					offer(num);
				} else {
					sb.append(pop()).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	// 최상단 노드 뽑기.
	private static int pop() {
		// TODO Auto-generated method stub
		// 사이즈가 0이라면 -1 반환
		if (size == 0) {
			return -1;
		}
		// 값 반환을 위한 result 저장
		int result = arr[1];
		// 반환한 값은 삭제하고,
		// 맨 마지막 값을 제일 위에 둔다.
		arr[1] = arr[size];
		arr[size] = 0;
		size--;

		int idx = 1;
		// ArrayIndexOutOfBounds를 피하기 위한 조건.
		// 변경 후 계속 확인해줘야 하므로 while을 쓴다.
		while (idx * 2 + 1 <= size) {
			// 자식 노드 중 더 큰 값으로 가기 위해 max 값을 찾는다.
			int max = Math.max(arr[idx * 2], arr[idx * 2 + 1]);
			// max의 index를 찾는다.
			int index = idx * 2;
			if (max == arr[idx * 2 + 1]) {
				index = idx * 2 + 1;
			}
			// 현재의 노드가 자식의 노드보다 같거나 크다면 바꿔줄 필요가 없으므로 break
			if (arr[idx] >= max) {
				break;
			}
			// 현재의 노드가 자식의 노드보다 작다면 변경해준다.
			int temp = arr[idx];
			arr[idx] = arr[index];
			arr[index] = temp;
			idx = index;
		}
		return result;
	}

	private static void offer(int num) {
		// TODO Auto-generated method stub
		size++;
		int idx = size;
		// 맨 마지막에 추가할 값을 넣는다.
		arr[idx] = num;
		// 부모의 값이 현재의 값 보다 작다면 변경해준다.
		while (arr[idx] > arr[idx / 2] && idx / 2 > 0) {
			int temp = arr[idx];
			arr[idx] = arr[idx / 2];
			arr[idx / 2] = temp;
			idx /= 2;
		}
	}

}
