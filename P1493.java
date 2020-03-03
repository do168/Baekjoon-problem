package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class P1493 {
	static int L;
	static int W;
	static int H;
	static int n;
	static Map<Integer, Integer> tm;
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		L = Integer.parseInt(str.nextToken());
		W = Integer.parseInt(str.nextToken());
		 H = Integer.parseInt(str.nextToken());
		str = new StringTokenizer(bfr.readLine());
		n = Integer.parseInt(str.nextToken());
		tm = new TreeMap<Integer, Integer>(Collections.reverseOrder());
		for(int i=0; i<n; i++) {
			str = new StringTokenizer(bfr.readLine());
			tm.put(Integer.parseInt(str.nextToken()), Integer.parseInt(str.nextToken()));
		}
		
	}
	static void DFS(int l, int w, int h, int cnt) {
		if(l+w+h==0) {
			answer = cnt;
			return;
		}
		else {
			Set set = tm.entrySet();
			Iterator it = set.iterator();
			int index = 0;
			while(it.hasNext()) {
				
				int temp = (Integer)it.next();
				double sq = Math.pow(2, temp);
				if(l>=sq && w>=sq && h>=sq) {
					break;
				}
				index++;
			}
			for(int i=0; i<index++; i++) {
				
			}
		}
	}
}
