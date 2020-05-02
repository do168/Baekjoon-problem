package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P9466 {
	static HashMap<Integer, Integer> hm;
	static boolean[] isVisit;
	static boolean[] isChecked;
	static int cnt;
	public static void main (String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		int T = Integer.parseInt(str.nextToken());
			for(int i=0; i<T; i++) {
			str = new StringTokenizer(bfr.readLine());
			int n = Integer.parseInt(str.nextToken());
			hm = new HashMap<Integer, Integer>();
			isVisit = new boolean[n+1];
			isChecked = new boolean[n+1];
			cnt = 0;
			str = new StringTokenizer(bfr.readLine());
			for(int j=1; j<=n; j++) {
				int value = Integer.parseInt(str.nextToken());
				hm.put(j, value);
			}
			for(int j=1; j<=n; j++) {
				dfs(j);
			}
			System.out.println(n-cnt);
		}
	}
	static void dfs(int index) {
		if(isVisit[index])
			return;
		isVisit[index] = true;
		int value = hm.get(index);
		if(!isVisit[value]) {
			dfs(value);
		}
		else {
			if(!isChecked[value]) {
				cnt++;
				for(int i = value; i!=index; i=hm.get(i))
					cnt++;
			}
		}
		isChecked[index] = true;
	}
}

