

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_10942 {
	/*
	 * 팰린드롬? 
	 * https://www.acmicpc.net/problem/10942
	 */
	
	static int[] a;
	static int N;
	public static void main(String[] args) throws IOException {

		//System.setIn(new FileInputStream("res/test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		a = new int [N+1];
		for (int i = 1; i <= N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			
			int result = checkPal(s, e);
			bw.write(result+"\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	static int checkPal (int s, int e) {
		while(s <= e) {
			if (a[s] != a[e]) {
				return 0;
			}
			s++;
			e--;
		}
		return 1;
	}
}
