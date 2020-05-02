package BAEKJOON;

import java.util.Scanner;

public class P2749 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		long dp_0 = 0; long dp_1 = 1;
		long sum = 0;
		for(long i = 2; i<=N; i++) {
			sum = (dp_0+dp_1)%1000000;
			dp_0 = dp_1%1000000;
			dp_1 = sum;
		}
		System.out.println(sum);
	}

}
