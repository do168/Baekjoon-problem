package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class P17199 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		int N = Integer.parseInt(str.nextToken());
		ArrayList<Integer> station = new ArrayList<Integer>();
		for (int i=1;i<=N; i++) {
			station.add(i);
		}
		for (int i = 0; i < N - 1; i++) {
			str = new StringTokenizer(bfr.readLine());
			int a = Integer.parseInt(str.nextToken());
			if(!station.contains(a)) {System.out.println(a); return;}
			else {station.remove(a); }
		}
		
	}
}