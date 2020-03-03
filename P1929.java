package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P1929 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		boolean[] prime = new boolean[N+1];
		
		Arrays.fill(prime, true);
		for(int i=2; i<=N; i++) {
			for(int j=i*2; j<=N; j+=i) {
				if(!prime[j])
					continue;
				prime[j] = false;
			}
		}
		prime[1]=false;
		for(int i=M; i<=N; i++) {
			if(prime[i])
				System.out.println(i);
		}
	}

}
