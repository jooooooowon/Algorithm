package Algorithm.algorithm.programmers;

public class 키패드_누르기 {

	public String solution(int[] numbers, String hand) {
		String answer = "";
		Point[] btns = new Point[10];
		btns[0] = new Point(1, 3);
		btns[1] = new Point(0, 0);
		btns[2] = new Point(1, 0);
		btns[3] = new Point(2, 0);
		btns[4] = new Point(0, 1);
		btns[5] = new Point(1, 1);
		btns[6] = new Point(2, 1);
		btns[7] = new Point(0, 2);
		btns[8] = new Point(1, 2);
		btns[9] = new Point(2, 2);
		Point left = new Point(0, 3);
		Point right = new Point(2, 3);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numbers.length; i++) {
			int num = numbers[i];
			if (num == 1 || num == 4 || num == 7) {
				sb.append("L");
				left = btns[num];
			} else if (num == 3 || num == 6 || num == 9) {
				sb.append("R");
				right = btns[num];
			} else {
				int leftDistance = left.distance(btns[num]);
				int rightDistance = right.distance(btns[num]);
				if (leftDistance > rightDistance) {
					right = btns[num];
					sb.append("R");
				} else if (rightDistance > leftDistance) {
					left = btns[num];
					sb.append("L");
				} else {
					if (hand.equals("right")) {
						right = btns[num];
						sb.append("R");
					} else {
						left = btns[num];
						sb.append("L");
					}
				}
			}
		}
		answer = sb.toString();
		return answer;
	}

	class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int distance(Point point) {
			return Math.abs(point.x - this.x) + Math.abs(point.y - y);
		}
	}
}