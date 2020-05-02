package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class P13904 {
	static int[] dl;
	static int[] score;
	static int n;
	static ArrayList<Boolean> isVisit;
	static ArrayList<Integer> isAuto;
	static int sum;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		n = Integer.parseInt(str.nextToken());
		dl = new int[n];
		score = new int[n];
		isVisit = new ArrayList<Boolean>();
		isAuto = new ArrayList<Integer>();
		sum = 0;
		for (int i = 0; i < n; i++) {
			str = new StringTokenizer(bfr.readLine());
			dl[i] = Integer.parseInt(str.nextToken());
			score[i] = Integer.parseInt(str.nextToken());
			isVisit.add(false);
		}
		for (int i = 0; i < n; i++) {
			dfs(i, 0, 1);
		}
		System.out.println(sum);
	}

	static void dfs(int now, int result, int day) {
		if (isVisit.contains(false)==false) {
			sum = Math.max(sum, result);
			Iterator it = isAuto.iterator();
			while(it.hasNext()) {
				isVisit.set((Integer)it.next(), false);
			}
			isAuto.clear();
			return;
		}
		if (dl[now] < day) {
			isVisit.set(now, true);
			isAuto.add(now);
			return;
		}
		if (isVisit.get(now)==true) {
			return;
		} else {
			isVisit.set(now, true);
			result += score[now];
			System.out.println(result + " " + day);
			Iterator it = isVisit.iterator();
			while(it.hasNext()) {
				System.out.print((boolean)it.next()+" ");
			}
			System.out.println();
			for (int i = 0; i < n; i++) {
				if (i == now)
					continue;
				else {
					dfs(i, result, day + 1);
				}
			}
			result -= score[now];
			isVisit.set(now, false);
		}

	}
}
