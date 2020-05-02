package BAEKJOON;

import java.util.*;
import java.io.*;
public class P15592 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		int m_x1 = Integer.parseInt(str.nextToken());
		int m_y1 = Integer.parseInt(str.nextToken());
		int m_x2 = Integer.parseInt(str.nextToken());
		int m_y2 = Integer.parseInt(str.nextToken());
		
		str = new StringTokenizer(bfr.readLine());
		int f_x1 = Integer.parseInt(str.nextToken());
		int f_y1 = Integer.parseInt(str.nextToken());
		int f_x2 = Integer.parseInt(str.nextToken());
		int f_y2 = Integer.parseInt(str.nextToken());
		
		int m_area = (m_x2 - m_x1) * (m_y2 - m_y1);
		if (m_x1>=f_x1 && m_x2 <=f_x2 && m_y1>=f_y1 && m_y2 <= f_y2) {
			m_area = 0;
		}
		else if (m_x1>=f_x1 && m_x2 <=f_x2 && ((f_y1 <= m_y2 && f_y2 >=m_y2) || (f_y1<=m_y1 && f_y2 >=m_y1))) {
			if (Math.max(m_y2, f_y2) == f_y2) {
				m_area = (m_x2-m_x1) * (f_y1 - m_y1);
			}
			else {
				m_area = (m_x2-m_x1) * (m_y2 - f_y2);
			}
		}
		else if (m_y1>=f_y1 && m_y2 <= f_y2 && ((f_x1 <= m_x2 && f_x2 >=m_x2) || (f_x1<=m_x1 && f_x2 >=m_x1))) {
			if (Math.max(m_x2, f_x2) == f_x2) {
				m_area = (m_y2-m_y1) * (f_x1 - m_x1);
			}
			else {
				m_area = (m_y2-m_y1) * (m_x2 - f_x2);
			}
		}
		System.out.println(m_area);
		
	}

}
