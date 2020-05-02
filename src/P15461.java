package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class P15461 {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		int N = Integer.parseInt(str.nextToken());
		str.nextToken();
		int ID = 1;
		int[] day_ID = new int[1000001];
		int[] milk_change = new int[1000001];

		HashMap<Integer, Integer> cows = new HashMap<Integer, Integer>();
		for (int i = 0; i < N; i++) {
			str = new StringTokenizer(bfr.readLine());
			int day = Integer.parseInt(str.nextToken());
			day_ID[day] = Integer.parseInt(str.nextToken());
			if (!cows.containsKey(day_ID[day]))
				cows.put(day_ID[day], ID++);
			String rank_displayp = str.nextToken();
			if (rank_displayp.charAt(0) == '+')
				rank_displayp = rank_displayp.substring(1);
			milk_change[day] = Integer.parseInt(rank_displayp);
		}
		for (int i = 0; i < day_ID.length; i++) {
			if (day_ID[i] != 0)
				day_ID[i] = cows.get(day_ID[i]);
		}
		int[] milk_now = new int[ID];
		TreeMap<Integer, Integer> rank_display = new TreeMap<Integer, Integer>();
		rank_display.put(0, ID);
		int cnt = 0;
		int max = 0;
		for (int i = 0; i < day_ID.length; i++) {
			if (day_ID[i] == 0)
				continue;
			int prev = milk_now[day_ID[i]];
			int cur = prev + milk_change[i];
			milk_now[day_ID[i]] = cur;

			int numOld = rank_display.get(prev);
			if (numOld == 1) 
				rank_display.remove(prev);
			else
				rank_display.put(prev, numOld - 1);
			if (rank_display.containsKey(cur))
				rank_display.put(cur, rank_display.get(cur) + 1);
			else
				rank_display.put(cur, 1);
			if (prev < max && max <= cur)
				cnt++;
			if (prev == max && numOld > 1 && max < cur)
				cnt++;
			int newtop = rank_display.lastKey();
			if (prev == max && cur < newtop)
				cnt++;
			if (prev == max && cur == newtop && rank_display.get(newtop) > 1)
				cnt++;
			max = newtop;
		}
		System.out.println(cnt);
	}

}