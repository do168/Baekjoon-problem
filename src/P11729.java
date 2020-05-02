package BAEKJOON;

import java.util.Scanner;

public class P11729 {
	static StringBuilder answer;
	static int cnt = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		answer = new StringBuilder();
		int n = sc.nextInt();
		hanoi(1,2,3,n);
		System.out.println(cnt+"\n"+answer);
	}

	static void hanoi(int start, int mid, int end, int n) {
		if (n == 1) {
			answer.append(start+" "+end+"\n");
			cnt++;
		} else {
			hanoi(start, end, mid, n - 1);
			answer.append(start+" "+end+"\n");
			cnt++;
			hanoi(mid, start, end, n - 1);
		}
	}
}
