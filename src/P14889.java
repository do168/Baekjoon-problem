package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P14889 {
	static int[][] s;
	static int[] arr;
	static boolean[] isVisit;
	static int N;
	static int max = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		N = Integer.parseInt(str.nextToken());
		s = new int[N+1][N+1];
		isVisit = new boolean[N+1];
		arr = new int[N+1];
		for(int i=1; i<=N; i++) {
			str = new StringTokenizer(bfr.readLine());
			for(int j=1; j<=N; j++) {
				s[i][j] = Integer.parseInt(str.nextToken());
			}
		}
		dfs(N, 1);
		System.out.println(max);
		
	}
	static void dfs(int n, int start) {
		if(n==N/2) {
			//isVisit[start] = true;
			ArrayList<Integer> arr_a = new ArrayList<Integer>();
			int arr_a_score = 0;
			ArrayList<Integer> arr_b = new ArrayList<Integer>();
			int arr_b_score = 0;
			for(int i=1; i<=N; i++) {
				if(isVisit[i])
					arr_a.add(i);
				else
					arr_b.add(i);
			}
			for(int i = 0; i<arr_a.size(); i++) {
				int tmp = arr_a.get(i);
				for(int j=i+1; j<arr_a.size(); j++) {
					int tmp_ = arr_a.get(j);
					arr_a_score += s[tmp][tmp_] + s[tmp_][tmp];
				}
			}
			System.out.println();
			for(int i = 0; i<arr_b.size(); i++) {
				int tmp = arr_b.get(i);
				for(int j=i+1; j<arr_b.size(); j++) {
					int tmp_ = arr_b.get(j);
					arr_b_score += s[tmp][tmp_] + s[tmp_][tmp];
				}
			}
			System.out.println();
			max = Math.min(max, Math.abs(arr_a_score - arr_b_score));
			//isVisit[start] = false;
			return;
		}
		
		else {
			for(int i=start; i<N; i++) {
				if(!isVisit[i]) {
					isVisit[i] = true;
					dfs(n-1, i+1);
					isVisit[i] = false;
				}
			}
		}
	}

}
