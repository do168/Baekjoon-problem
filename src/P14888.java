package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14888 {
	static int n = 0;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		n = Integer.parseInt(str.nextToken());
		str = new StringTokenizer(bfr.readLine());
		int[] digits = new int[n];
		int[] cals = new int[4];
		for (int i = 0; i < n; i++) {
			digits[i] = Integer.parseInt(str.nextToken());
		}
		str = new StringTokenizer(bfr.readLine());
		for (int i = 0; i < 4; i++) {
			cals[i] = Integer.parseInt(str.nextToken());
		}
		dfs(digits, cals, digits[0], 1);
		System.out.println(max+"\n"+min);
	}

	static void dfs(int[] digits, int[] cals, int result, int cnt) {
		if (cnt == n) {
			min = Math.min(result, min);
			max = Math.max(result, max);
			return;
		} else {
			for (int i = 0; i < 4; i++) {
				if (cals[i] == 0)
					continue;
				switch (i) {
				case (0): {
					int temp = result;
					result = result + digits[cnt];
					cals[i]--;
					dfs(digits, cals, result, cnt+1);
					cals[i]++;
					result = temp;
					break;
				}
				case (1): {
					int temp = result;
					result = result - digits[cnt];
					cals[i]--;
					dfs(digits, cals, result, cnt+1);
					cals[i]++;
					result = temp;
					break;
				}
				case (2): {
					int temp = result;
					result = result * digits[cnt];
					cals[i]--;
					dfs(digits, cals, result, cnt+1);
					cals[i]++;
					result = temp;
					break;
				}
				case (3): {
					int temp = result;
					result = result / digits[cnt];
					cals[i]--;
					dfs(digits, cals, result, cnt+1);
					cals[i]++;
					result = temp;
					break;
				}
				}
			}
		}
	}
}
