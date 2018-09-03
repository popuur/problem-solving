

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2294 {
	public static void main(String[] args) throws IOException {
		/*
		 * 동전 2
		 * https://www.acmicpc.net/problem/2294
		 */

		//System.setIn(new FileInputStream("res/test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		

		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] a = new int[n+1];
		for (int i = 1; i <= n; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		
		int[] d = new int[k+1];
		Arrays.fill(d, 10001);
		
		for (int i = 1; i <= n; i++) {
			for (int j = a[i]; j <= k; j++) {
				if (j == a[i]) {
					d[j] = 1;
				} else {
					d[j] = Math.min(d[j], d[j-a[i]]+1);
				}
			}
		}
		
		int result = d[k];
		if (result == 10001) {
			result = -1;
		}
		bw.write(result+"\n");
		
		br.close();
		bw.flush();
		bw.close();
	}

}
