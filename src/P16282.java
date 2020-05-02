package BAEKJOON;

import java.util.Scanner;

public class P16282 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long cnt=1;
		int i = 2;
		int answer = 0;
		for(int cut=2; cut<=64; cut++) {
			i*=2;
			cnt = (i-1)*cut + cut-1;
			answer++;
			if(cnt>=n) {
				break;
			}
		}
		System.out.println(answer);
	}

}
