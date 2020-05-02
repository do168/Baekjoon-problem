package BAEKJOON;

import java.util.Scanner;

public class P2163 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N =sc.nextInt();
		int M = sc.nextInt();
		int answer = (N-1) + (N)*(M-1);
		System.out.println(answer);
	}

}
