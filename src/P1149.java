package BAEKJOON;

import java.util.*;
import java.io.*;

public class P1149 {
	static int N;
	static int[][] dp_house;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		
		N = Integer.parseInt(str.nextToken());
		dp_house = new int[N][3];
		
		
		for (int i=0; i<N; i++) {
			str = new StringTokenizer(bfr.readLine());
			for (int j=0; j<3; j++) {
				dp_house[i][j] = Integer.parseInt(str.nextToken());
			}
		}
		
		for (int i=1; i<N; i++) {
			dp_house[i][0] += Math.min(dp_house[i-1][1], dp_house[i-1][2]);
			dp_house[i][1] += Math.min(dp_house[i-1][0], dp_house[i-1][2]);
			dp_house[i][2] += Math.min(dp_house[i-1][0], dp_house[i-1][1]);
		}
		
		
		int answer = Math.min(dp_house[N-1][0], dp_house[N-1][1]);
		System.out.println(Math.min(answer, dp_house[N-1][2]));
		
	}
		
}
