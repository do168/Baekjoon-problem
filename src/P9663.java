package BAEKJOON;
import java.io.*;
import java.util.*;
public class P9663 {
	static int answer = 0;
	static int N;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		N = Integer.parseInt(str.nextToken());
		
		int[] list = new int[N];
		dfs(list, 0);
		System.out.println(answer);
	}
	
	static void dfs(int[] list, int current) {
		if(current == N) {
			answer++;
			return;
		}
		else {
			for (int i=0; i<N; i++) {
				if(isPossible(list, current, i)) {
					list[current] = i;
					dfs(list, current+1);
				}
			}
		}
	}
	static boolean isPossible(int[] list, int present, int check) {
		for (int i=0; i<present; i++) {
			if(list[i]==check || Math.abs(i-present) == Math.abs(list[i]-check))
				return false;
		}
		return true;
	}

}
