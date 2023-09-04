package Algorithm.algorithm.baekjoon.A형;

import java.util.Scanner;

public class 괄호추가하기16637 {
	// 괄호는 인접한 두 개의 수만 묶을 수 있음에 집중하였다.
	// 인접한 두 수만 묶을 수 있고 여러 개의 수를 묶을 수 있기 때문에 부분 집합으로 풀면 되겠다는 생각을 하였다.
	// 숫자들을 담는 배열과 사칙연산을 담는 배열을 보면 사칙연산을 기준으로 왼쪽에 있는 숫자와 사칙연산의 인덱스가 같음을 알 수 있다.
	// 따라서 사칙연산을 기준으로 왼쪽에 있는 숫자와 오른쪽에 있는 숫자를 하나의 부분집합으로 생각하고 여러가지를 만든다.
	// 부분집합끼리 먼저 계산을 하고 오른쪽에 있는 숫자는 0으로, 가운데에 있는 사칙연산은 +로 만든다.
	// 부분집합끼리 먼저 계산하고 난 후 나온 숫자들을 계산해준다.
	// n <= 19 이므로 2의 n/2+1승은 int의 최댓값을 넘지않기 때문에 비트마스킹을 이용하였다.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String str = sc.next();
		// n은 항상 홀수이고, 숫자들은 사칙연산보다 항상 하나 더 많다.
		int[] numArr = new int[n / 2 + 1];
		// 사칙연산을 담을 배열.
		char[] calArr = new char[n / 2];
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				numArr[i / 2] = str.charAt(i) - '0';
			} else {
				calArr[i / 2] = str.charAt(i);
			}
		}

		int max = Integer.MIN_VALUE;
		// 비트마스킹을 이용하여 조합을 찾는다.
		for (int bit = 0; bit < 1 << (n / 2 + 1); bit++) {
			max = Math.max(max, combination(bit, numArr, calArr));
		}
		System.out.println(max);
	}

	private static int combination(int bit, int[] numArr, char[] calArr) {
		// 깊은 복사.
		int[] tempNum = numArr.clone();
		char[] tempCal = calArr.clone();
		for (int i = 0; i < numArr.length - 1; i++) {
			if ((bit & 1 << i) > 0) {
				// 만약 인접한 부분집합이 되어 버린다면
				// 이미 부분집합이 되어버린 오른쪽의 수가 왼쪽의 수가 될 수 있으므로 
				// 계산할 필요가 없다. 리턴한다.
				if((bit & 1 << i + 1) > 0) {
					return Integer.MIN_VALUE;
				}
				// 부분집합들을 미리 계산해준다.
				if (tempCal[i] == '+') {
					tempNum[i] += tempNum[i + 1];
				} else if (tempCal[i] == '-') {
					tempNum[i] -= tempNum[i + 1];
				} else if (tempCal[i] == '*') {
					tempNum[i] *= tempNum[i + 1];
				} else if (tempCal[i] == '/') {
					tempNum[i] /= tempNum[i + 1];
				}
				// 후에 계산을 위해 오른쪽 수를 0으로 하고 사칙연산은 +로 한다.
				// 0을 더해봤자 값은 달라지지 않음을 이용하였다.
				tempNum[i + 1] = 0;
				tempCal[i] = '+';
			}
		}
		
		// 결과 값.
		int sum = tempNum[0];
		
		// 괄호안에서 먼저 계산해야할 숫자들을 계산한 후 나머지들을 계산해준다.
		for (int i = 0; i < tempNum.length - 1; i++) {
			if (tempCal[i] == '+') {
				sum += tempNum[i + 1];
			} else if (tempCal[i] == '-') {
				sum -= tempNum[i + 1];
			} else if (tempCal[i] == '*') {
				sum *= tempNum[i + 1];
			} else if (tempCal[i] == '/') {
				// 0을 나누게 되면  ArithmeticException이 발생하기 때문에 예외 처리를 해준다.
				if(tempNum[i+1] == 0) {
					return Integer.MIN_VALUE;
				}
				sum /= tempNum[i + 1];
			}
		}
		return sum;
	}

}
