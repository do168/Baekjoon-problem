package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class P15462 {
	static int[] shuffle;
	static boolean[] isVisit;
	static boolean[] isCalculated;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		int N = Integer.parseInt(str.nextToken());
		answer = 0;
		isVisit = new boolean[N+1];
		isCalculated = new boolean[N+1];
		str = new StringTokenizer(bfr.readLine());
		shuffle = new int[N+1];
		for (int i = 1; i <= N; i++) {
			shuffle[i] = Integer.parseInt(str.nextToken());
		}
		for(int i=1; i<=N; i++) {
			if(!isVisit[i]) DFS(i);
		}
		System.out.println(answer);
	}
	static void DFS(int cow_pos) {
		isVisit[cow_pos] = true;
		if(!isVisit[shuffle[cow_pos]]) DFS(shuffle[cow_pos]);
		else if(!isCalculated[shuffle[cow_pos]]) {
			for(int i=shuffle[cow_pos]; i!=cow_pos; i=shuffle[i])
				answer++;
			answer++;
		}
	}
}
