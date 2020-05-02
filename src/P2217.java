package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2217 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		int n = Integer.parseInt(str.nextToken());
		int[] rope = new int[n];
		for(int i=0; i<n; i++) {
			str = new StringTokenizer(bfr.readLine());
			rope[i] = Integer.parseInt(str.nextToken());
		}
		Arrays.sort(rope);
		int max = 0;
		for(int i=n-1; i>=0; i--) {
			int temp = rope[i]*(n-i);
			max = Math.max(temp, max);
		}
		System.out.println(max);
		
	}

}
