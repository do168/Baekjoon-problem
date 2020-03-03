package baekjoon;

import java.io.*;
import java.util.*;

public class P15752 {
	static int[] cows;
	
	static int N;
	static boolean[] isVisit;
	static int[] realVisit;
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		N = Integer.valueOf(str.nextToken());
		str = new StringTokenizer(bfr.readLine());
		
		cows = new int[N];
		isVisit = new boolean[N];
		realVisit = new int[N];
		
		for (int i=0; i<N; i++) {
			cows[i] = Integer.valueOf(str.nextToken());
			isVisit[i] = false;
			realVisit[i] = 0;
		}
		Arrays.sort(cows);
		
		int[] result_dfs = new int[N];
		for(int i=0; i<N; i++) {
			DFS(i);
			clearVisitArr();
		}
		int answer = 0;
		
		
		for (int i=0; i<N; i++) {
			if(realVisit[i] == 0) {
				
				answer++;
			}
			if(i<next(i) && next(next(i))==i && realVisit[i]==2 && realVisit[next(i)]==2) {
				
				answer++;
			}
		}
		System.out.println(answer);
	}
	
	static int DFS(int n) {
		int nextcow = next(n);
		if(!visit(nextcow)) {
			isVisit[nextcow]=true;
			realVisit[nextcow]++;
			DFS(nextcow);
		}
		else {return nextcow;}
		return -1;
		
	}
	static int next(int n) {
		if (n==0) return n+1;
		else if(n==N-1) return n-1;
		else {
			if(Math.abs(cows[n]-cows[n-1]) >Math.abs(cows[n]-cows[n+1]) ) {
				return n+1;
			}
			else return n-1;
		}
	}
	
	static boolean visit(int check) {
		if(isVisit[check]==true) {
			return true;
		}
		else {
			return false;
		}
	}
	static void clearVisitArr() {
        for(int i=0; i<N; i++) {
            isVisit[i] = false;
        }
    }

	
}
