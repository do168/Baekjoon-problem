package baekjoon;

import java.util.*;
import java.io.*;
public class P15751 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		
		int start = Integer.valueOf(str.nextToken());
		int end = Integer.valueOf(str.nextToken());
		int x = Integer.valueOf(str.nextToken());
		int y =Integer.valueOf(str.nextToken());
		
		int case1 = Math.abs(start-end);
		int case2 = 0;
		if (Math.abs(start-x)<Math.abs(start-y)) {
			case2 = Math.abs(start-x) + Math.abs(y-end);
		}
		else {
			case2 = Math.abs(start-y) + Math.abs(x-end);
		}
		System.out.println(Math.min(case1, case2));
	}

}
